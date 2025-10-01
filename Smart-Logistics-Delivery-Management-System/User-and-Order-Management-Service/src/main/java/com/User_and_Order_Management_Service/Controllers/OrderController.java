package com.User_and_Order_Management_Service.Controllers;

import com.User_and_Order_Management_Service.RequestDtos.OrderRequestDto;
import com.User_and_Order_Management_Service.ResponseBuilder.ApiResponse;
import com.User_and_Order_Management_Service.ResponseBuilder.PageResponse;
import com.User_and_Order_Management_Service.ResponseDtos.OrderResponseDto;
import com.User_and_Order_Management_Service.Services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.User_and_Order_Management_Service.ResponseBuilder.responseBuilder;

import static com.User_and_Order_Management_Service.constants.OrderConfigurationConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-management")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
  public ResponseEntity<ApiResponse<PageResponse<OrderResponseDto>>> getAllOrders(@RequestParam int page, @RequestParam int size){
        PageResponse<OrderResponseDto> allOrders = orderService.getAllOrders(page, size);
        return responseBuilder.success(allOrders,RETRIEVE_ORDERS, HttpStatus.OK);
    }


    @GetMapping("/orders_users/{userId}")
    public ResponseEntity<ApiResponse<PageResponse<OrderResponseDto>>> getOrdersByUserId(@PathVariable Long userId, @RequestParam int page, @RequestParam int size){
        PageResponse<OrderResponseDto> allOrdersByUserId = orderService.getOrdersByUserId(page, size, userId);
        return responseBuilder.success(allOrdersByUserId,RETRIEVE_ORDERS_BY_USER_ID, HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<ApiResponse<OrderResponseDto>> getOrderById(@PathVariable Long id){
        OrderResponseDto orderById = orderService.getOrderById(id);
        return responseBuilder.success(orderById,RETRIEVE_ORDERS_BY_ORDER_ID, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<ApiResponse<String>> createOrder(@Validated  @RequestBody OrderRequestDto orderRequestDto){
        String orderCreated = orderService.createOrder(orderRequestDto);
        return responseBuilder.success(orderCreated,ORDER_CREATED,HttpStatus.CREATED);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<ApiResponse<String>> deleteOrdersById(@PathVariable Long id) {
        String message = orderService.deleteOrderByOrderId(id);
        return responseBuilder.success(message,ORDER_DELETED,HttpStatus.OK);
    }
}

