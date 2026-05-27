package com.re.pratice.controller;

import com.re.pratice.dto.request.ProductRequestDto;
import com.re.pratice.dto.response.ApiResponse;
import com.re.pratice.dto.response.ProductResponseDto;
import com.re.pratice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponseDto>>> getProducts(){
        List<ProductResponseDto> products = productService.getProducts();
        return ResponseEntity.ok(ApiResponse.response("Get product successfully",products));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponseDto>> createProduct(@RequestBody ProductRequestDto requestDto){
        ProductResponseDto responseDto = productService.createProduct(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.response("Product created successfully",responseDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> createProduct(@PathVariable Long id,@RequestBody ProductRequestDto requestDto){
        ProductResponseDto responseDto = productService.updateProduct(id,requestDto);

        return ResponseEntity.ok(ApiResponse.response("Product updated successfully",responseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
