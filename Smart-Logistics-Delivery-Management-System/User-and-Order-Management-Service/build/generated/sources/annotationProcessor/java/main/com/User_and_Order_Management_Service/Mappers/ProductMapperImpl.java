package com.User_and_Order_Management_Service.Mappers;

import com.User_and_Order_Management_Service.Entites.Products;
import com.User_and_Order_Management_Service.ResponseDtos.ProductResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-01T16:03:05+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponseDto toDto(Products products) {
        if ( products == null ) {
            return null;
        }

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setProductName( products.getProductName() );
        productResponseDto.setPrice( products.getPrice() );

        return productResponseDto;
    }
}
