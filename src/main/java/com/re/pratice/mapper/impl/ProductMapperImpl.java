package com.re.pratice.mapper.impl;

import com.re.pratice.dto.request.ProductRequestDto;
import com.re.pratice.dto.response.ProductResponseDto;
import com.re.pratice.entity.Product;
import com.re.pratice.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductResponseDto toDto(Product p) {

        return ProductResponseDto.builder()
                .name(p.getName())
                .category(p.getCategory())
                .quantity(p.getQuantity())
                .build();
    }

    @Override
    public Product toEntity(ProductRequestDto responseDto) {
         return Product.builder()
                .name(responseDto.name())
                .category(responseDto.category())
                .quantity(responseDto.quantity())
                .build();
    }


    @Override
    public List<ProductResponseDto> toList(List<Product> products) {
        return List.of();
    }
}
