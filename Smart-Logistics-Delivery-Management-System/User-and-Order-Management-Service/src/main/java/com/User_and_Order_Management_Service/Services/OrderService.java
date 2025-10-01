package com.User_and_Order_Management_Service.Services;

import com.User_and_Order_Management_Service.RequestDtos.OrderRequestDto;
import com.User_and_Order_Management_Service.ResponseBuilder.PageResponse;
import com.User_and_Order_Management_Service.ResponseDtos.OrderResponseDto;

public interface OrderService {

    public PageResponse<OrderResponseDto> getAllOrders(int page, int size);

    public OrderResponseDto getOrderById(Long id);

    public String createOrder(OrderRequestDto orderRequestDto);

    public PageResponse<OrderResponseDto> getOrdersByUserId(int page, int size, Long userId);

    public String deleteOrderByOrderId(Long orderId);

}
