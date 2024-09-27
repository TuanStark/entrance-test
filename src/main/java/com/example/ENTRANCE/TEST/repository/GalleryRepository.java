package com.example.ENTRANCE.TEST.repository;

import com.example.ENTRANCE.TEST.dto.response.GalleryResponse;
import com.example.ENTRANCE.TEST.dto.response.GalleryResponseImageAndIsDefault;
import com.example.ENTRANCE.TEST.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery,Long> {
    List<Gallery> findByProduct_IdAndIsDefaultTrue(Long productId);
    List<Gallery> findByProduct_Id(Long id);
    @Query("SELECT new com.example.ENTRANCE.TEST.dto.response.GalleryResponse(g.image, g.isDefault) " +
            "FROM Gallery g WHERE g.product.id = :productId")
    List<GalleryResponse> findGalleryByProductId(@Param("productId") Long productId);

}
