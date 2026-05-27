package com.re.pratice.service;

import com.re.pratice.dto.request.ProductRequestDto;
import com.re.pratice.dto.response.ProductResponseDto;
import com.re.pratice.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getProducts();

    ProductResponseDto createProduct(ProductRequestDto requestDto);

    ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto);

    void deleteProduct(Long  productId);
}
