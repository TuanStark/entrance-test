package com.example.ENTRANCE.TEST.mapper;

import com.example.ENTRANCE.TEST.dto.request.ProductRequest;
import com.example.ENTRANCE.TEST.dto.response.ProductResponse;
import com.example.ENTRANCE.TEST.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductRequest request);
    ProductResponse toProductResponse(Product product);
    void updateProduct(@MappingTarget Product product, ProductRequest request);
}
