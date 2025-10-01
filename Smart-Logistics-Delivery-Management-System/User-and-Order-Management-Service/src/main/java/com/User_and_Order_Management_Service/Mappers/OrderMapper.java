package com.User_and_Order_Management_Service.Mappers;

import com.User_and_Order_Management_Service.Entites.Orders;
import com.User_and_Order_Management_Service.RequestDtos.OrderRequestDto;
import com.User_and_Order_Management_Service.ResponseDtos.OrderResponseDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {



    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "userId", target = "user.id")
    Orders toEntity(OrderRequestDto orderRequestDto);

    @Mapping(source = "product", target = "product")
    @Mapping(source = "user", target = "userDetails")
    OrderResponseDto toDto(Orders orders);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(OrderRequestDto orderRequestDto, @MappingTarget Orders orders);
}
