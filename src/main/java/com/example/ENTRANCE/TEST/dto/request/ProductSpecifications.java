package com.example.ENTRANCE.TEST.dto.request;

import com.example.ENTRANCE.TEST.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {

    public static Specification<Product> filterByCategory(Long categoryId) {
        return (root, query, criteriaBuilder) -> {
            if (categoryId == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("category").get("id"), categoryId);
        };
    }

    public static Specification<Product> filterByColor(Long colorId) {
        return (root, query, criteriaBuilder) -> {
            if (colorId == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("color").get("id"), colorId);
        };
    }

    public static Specification<Product> filterByStyle(Long styleId) {
        return (root, query, criteriaBuilder) -> {
            if (styleId == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("style").get("id"), styleId);
        };
    }

    public static Specification<Product> filterBySize(Long sizeId) {
        return (root, query, criteriaBuilder) -> {
            if (sizeId == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("size").get("id"), sizeId);
        };
    }

    public static Specification<Product> filterByPrice(Double minPrice, Double maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice == null && maxPrice == null) {
                return criteriaBuilder.conjunction();
            }
            if (minPrice != null && maxPrice != null) {
                return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
            } else if (minPrice != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            } else {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            }
        };
    }
}
