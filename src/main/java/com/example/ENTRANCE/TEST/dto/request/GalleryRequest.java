package com.example.ENTRANCE.TEST.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GalleryRequest {
     String image;
     boolean isDefault;
}
