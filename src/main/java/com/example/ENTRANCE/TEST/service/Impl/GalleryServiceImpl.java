package com.example.ENTRANCE.TEST.service.Impl;

import com.example.ENTRANCE.TEST.dto.response.GalleryResponse;
import com.example.ENTRANCE.TEST.dto.response.GalleryResponseImageAndIsDefault;
import com.example.ENTRANCE.TEST.repository.GalleryRepository;
import com.example.ENTRANCE.TEST.service.GalleryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GalleryServiceImpl implements GalleryService {
    GalleryRepository galleryRepository;

    @Override
    public GalleryResponseImageAndIsDefault getGalleryByProductId(Long productId) {
        List<GalleryResponse> galleryResponses = galleryRepository.findGalleryByProductId(productId);

        List<String> imageUrls = new ArrayList<>();
        List<Boolean> isDefaultList = new ArrayList<>();

        for (GalleryResponse response : galleryResponses) {
            imageUrls.add(response.getImage());
            isDefaultList.add(response.isDefault());
        }

        GalleryResponseImageAndIsDefault galleryResponse = new GalleryResponseImageAndIsDefault();
        galleryResponse.setImageUrls(imageUrls);
        galleryResponse.setIsDefaultList(isDefaultList);

        return galleryResponse;
    }

}
