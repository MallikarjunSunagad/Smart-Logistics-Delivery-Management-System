package com.User_and_Order_Management_Service.Mappers;

import com.User_and_Order_Management_Service.Entites.Products;
import com.User_and_Order_Management_Service.ResponseDtos.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductResponseDto toDto(Products products);
}
