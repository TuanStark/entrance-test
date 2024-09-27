package com.example.ENTRANCE.TEST.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GalleryResponseImageAndIsDefault {
    private List<String> imageUrls;
    private List<Boolean> isDefaultList;
}
