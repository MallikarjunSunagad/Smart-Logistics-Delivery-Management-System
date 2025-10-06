package com.User_and_Order_Management_Service.ServiceImpl;

import com.User_and_Order_Management_Service.Entites.Orders;
import com.User_and_Order_Management_Service.Exceptions.BadRequestException;
import com.User_and_Order_Management_Service.Exceptions.DataNotFoundException;
import com.User_and_Order_Management_Service.Mappers.OrderMapper;
import com.User_and_Order_Management_Service.Repository.OrderRepository;
import com.User_and_Order_Management_Service.Repository.ProductsRepository;
import com.User_and_Order_Management_Service.Repository.UserRepository;
import com.User_and_Order_Management_Service.RequestDtos.OrderRequestDto;
import com.User_and_Order_Management_Service.ResponseBuilder.PageResponse;
import com.User_and_Order_Management_Service.ResponseDtos.OrderResponseDto;
import com.User_and_Order_Management_Service.Services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final UserRepository userRepository;

    private final ProductsRepository productsRepository;

    @Override
    @Cacheable(value = "orders")
    public PageResponse<OrderResponseDto> getAllOrders(int page, int size) {
            validatePageableParams(page, size);
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Orders> orderPages = orderRepository.findAll(pageRequest);
        List<OrderResponseDto> dtoList = orderPages.stream()
                .map(orderMapper::toDto)
                .toList();
        log.info("Fetching all the orders \n {}",dtoList);
        return new PageResponse<>(
                dtoList,
                orderPages.getNumber(),
                orderPages.getSize(),
                orderPages.getTotalElements(),
                orderPages.getTotalPages()
        );
    }

    @Override
    @Cacheable(value = "allOrders")
    public OrderResponseDto getOrderById(Long id) {
        Orders orderById = orderRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Order with id: " + id + " not found!"));
        log.info("Fetching the orders by user id:{}",id);
        return orderMapper.toDto(orderById);
    }

    @Override
    public String createOrder(OrderRequestDto orderRequestDto) {
        userRepository.findById(orderRequestDto.getUserId())
                .orElseThrow(()-> new DataNotFoundException("User with id:"+orderRequestDto.getUserId()+" not found!"));

        productsRepository.findById(orderRequestDto.getProductId())
                .orElseThrow(()->new DataNotFoundException("Product with id:"+" not found!"));

        Orders orderEntity = orderMapper.toEntity(orderRequestDto);

        Orders savedOrder = orderRepository.save(orderEntity);
        log.info("Order details saved successfully!..\n {}",orderEntity);

        return "Order created successfully";
    }

    @Override
    public PageResponse<OrderResponseDto> getOrdersByUserId(int page, int size, Long userId) {
        validatePageableParams(page,size);
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Orders> byUserId = orderRepository.findByUserId(userId, pageRequest);
        if(byUserId!=null){
            List<OrderResponseDto> list = byUserId.stream().map(orderMapper::toDto).toList();
            log.info("Fetching the list of orders by user id {}",userId);
            return new PageResponse<>(
                    list,
                    byUserId.getNumber(),
                    byUserId.getSize(),
                    byUserId.getTotalElements(),
                    byUserId.getTotalPages()
                );
        }else throw new DataNotFoundException("Orders not found for user id: "+userId);
    }

    @Override
    public String deleteOrderByOrderId(Long orderId) {
        Orders orderById = orderRepository.findById(orderId)
                .orElseThrow(() -> new DataNotFoundException("Order with id: " + orderId + " not found!"));
        orderRepository.deleteById(orderId);
        log.info("Order with order id:{} deleted successfully!",orderId);
        return "Order Deleted Successfully!!";
    }

    private void validatePageableParams(int page, int size){
        if (page<0 || size<1){
            throw new BadRequestException("Invalid Page and size parameters");
        }
    }

}
