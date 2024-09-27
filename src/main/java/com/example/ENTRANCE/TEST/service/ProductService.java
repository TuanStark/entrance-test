package com.example.ENTRANCE.TEST.service;

import com.example.ENTRANCE.TEST.dto.request.ProductRequest;
import com.example.ENTRANCE.TEST.dto.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<ProductResponse> getAllProducts(ProductRequest request);
    public ProductResponse getProductById(Long id);
}
