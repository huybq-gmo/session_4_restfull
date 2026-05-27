package com.re.pratice.service.imp;

import com.re.pratice.dto.request.ProductRequestDto;
import com.re.pratice.dto.response.ProductResponseDto;
import com.re.pratice.entity.Product;
import com.re.pratice.mapper.ProductMapper;
import com.re.pratice.repository.ProductRepository;
import com.re.pratice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tools.jackson.databind.cfg.MapperBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final MapperBuilder mapperBuilder;

    @Override
    public List<ProductResponseDto> getProducts() {

        List<ProductResponseDto> productResponseDtos = productRepository.findAll().stream().map(productMapper::toDto).toList();
        return productResponseDtos;
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto requestDto) {

        Product product = productMapper.toEntity(requestDto);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto) {
        Product p = productRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatusCode.valueOf(404)));

        p.setCategory(requestDto.category());
        p.setName(requestDto.name());
        p.setQuantity(requestDto.quantity());
        productRepository.save(p);
        return productMapper.toDto(p);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product p = productRepository.findById(productId).orElseThrow(()-> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        productRepository.delete(p);
    }
}
