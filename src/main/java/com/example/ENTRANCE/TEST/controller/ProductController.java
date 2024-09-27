package com.example.ENTRANCE.TEST.controller;

import com.example.ENTRANCE.TEST.dto.request.ProductRequest;
import com.example.ENTRANCE.TEST.dto.response.ProductResponse;
import com.example.ENTRANCE.TEST.helpper.base.constant.StatusMessage;
import com.example.ENTRANCE.TEST.helpper.base.response.ResponseObject;
import com.example.ENTRANCE.TEST.service.ProductService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class ProductController {
    ProductService productService;

    @GetMapping("/getAll")
    public ResponseObject<List<ProductResponse>> getAllProducts(
            @RequestParam(required = false) Long categoryID,
            @RequestParam(required = false) Long colorID,
            @RequestParam(required = false) Long styleID,
            @RequestParam(required = false) Long sizeID,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        ProductRequest request = ProductRequest.builder()
                .categoryID(categoryID)
                .colorID(colorID)
                .styleID(styleID)
                .sizeID(sizeID)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .page(page)
                .size(size)
                .build();

        List<ProductResponse> products = productService.getAllProducts(request);

        return ResponseObject.<List<ProductResponse>>builder()
                .message(StatusMessage.SUCCESS)
                .code(200)
                .data(products)
                .build();
    }

    @GetMapping("/infoProduct/{id}")
    public ResponseObject<ProductResponse> getById(@Valid @PathVariable Long id){
        ProductResponse response = productService.getProductById(id);

        return ResponseObject.<ProductResponse>builder()
                .message(StatusMessage.SUCCESS)
                .code(200)
                .data(response)
                .build();
    }

}
