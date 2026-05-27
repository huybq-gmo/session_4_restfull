package com.re.pratice.mapper;

import com.re.pratice.dto.request.ProductRequestDto;
import com.re.pratice.dto.response.ProductResponseDto;
import com.re.pratice.entity.Product;

import javax.swing.*;
import java.util.List;

public interface ProductMapper {

    ProductResponseDto toDto(Product p);

    Product toEntity(ProductRequestDto responseDto);

    List<ProductResponseDto> toList(List<Product> products);
}
