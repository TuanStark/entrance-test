package com.example.ENTRANCE.TEST.service.Impl;

import com.example.ENTRANCE.TEST.dto.request.ProductRequest;
import com.example.ENTRANCE.TEST.dto.request.ProductSpecifications;
import com.example.ENTRANCE.TEST.dto.response.GalleryResponseImageAndIsDefault;
import com.example.ENTRANCE.TEST.dto.response.ProductResponse;
import com.example.ENTRANCE.TEST.entity.Product;
import com.example.ENTRANCE.TEST.helpper.base.constant.StatusMessage;
import com.example.ENTRANCE.TEST.repository.ProductRepository;
import com.example.ENTRANCE.TEST.service.GalleryService;
import com.example.ENTRANCE.TEST.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {
     ProductRepository productRepository;
     GalleryService galleryService;

    @Override
    public List<ProductResponse> getAllProducts(ProductRequest request) {
        Specification<Product> specification = Specification.where(
                        ProductSpecifications.filterByCategory(request.getCategoryID())
                ).and(ProductSpecifications.filterByColor(request.getColorID()))
                .and(ProductSpecifications.filterByStyle(request.getStyleID()))
                .and(ProductSpecifications.filterBySize(request.getSizeID()))
                .and(ProductSpecifications.filterByPrice(request.getMinPrice(), request.getMaxPrice()));

        Sort sort = Sort.by("createdAt").descending();
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize(), sort);
        Page<Product> products = productRepository.findAll(specification, pageable);
        return products.stream().map(this::convertToProductResponse).collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException(StatusMessage.NOT_FOUND));
        ProductResponse response = convertToProductResponse(product);
        return response;
    }

    private ProductResponse convertToProductResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setDiscount(product.getDiscount());
        response.setQuantity(product.getQuantity());
        response.setCategoryID(product.getCategory() != null ? product.getCategory().getId() : null);
        response.setColorID(product.getColor() != null ? product.getColor().getId() : null);
        response.setSizeID(product.getSize() != null ? product.getSize().getId() : null);
        response.setStyleID(product.getStyle() != null ? product.getStyle().getId() : null);

        GalleryResponseImageAndIsDefault galleryResponse = galleryService.getGalleryByProductId(product.getId());
        response.setImageUrls(galleryResponse.getImageUrls());
        response.setIsDefaultList(galleryResponse.getIsDefaultList());


        return response;
    }

}
