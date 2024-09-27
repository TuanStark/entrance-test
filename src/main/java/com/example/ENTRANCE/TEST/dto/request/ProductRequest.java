package com.example.ENTRANCE.TEST.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
     String name;
     String description;
     double price;
     boolean expiration;
     int discount;
     int quantity;
     int status;
     Long categoryID;
     Long colorID;
     Long sizeID;
     Long styleID;
     Double minPrice;
     Double maxPrice;
     int page;
     int size;
     @NotNull
     private List<MultipartFile> images;
     @NotNull
     private List<Boolean> isDefaultList;
}
