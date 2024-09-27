package com.example.ENTRANCE.TEST.service;

import com.example.ENTRANCE.TEST.dto.response.GalleryResponseImageAndIsDefault;
import org.springframework.stereotype.Service;

@Service
public interface GalleryService {
    public GalleryResponseImageAndIsDefault getGalleryByProductId(Long productId);
}
