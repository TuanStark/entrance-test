package com.example.ENTRANCE.TEST.mapper;

import com.example.ENTRANCE.TEST.dto.request.GalleryRequest;
import com.example.ENTRANCE.TEST.dto.response.GalleryResponse;
import com.example.ENTRANCE.TEST.entity.Gallery;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GalleryMapper {
    Gallery toGallery(GalleryRequest request);
    GalleryResponse toGalleryResponse(Gallery gallery);
    void updateGallery(@MappingTarget Gallery gallery, GalleryRequest request);
}
