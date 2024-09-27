package com.example.ENTRANCE.TEST.dto.response;

import com.example.ENTRANCE.TEST.entity.Gallery;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
     Long id;
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
     @NotNull
     private List<String> imageUrls;
     @NotNull
     private List<Boolean> isDefaultList;
}
