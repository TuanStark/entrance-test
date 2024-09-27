package com.example.ENTRANCE.TEST.mapper;


import com.example.ENTRANCE.TEST.dto.request.CategoryRequest;
import com.example.ENTRANCE.TEST.dto.response.CategoryResponse;
import com.example.ENTRANCE.TEST.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequest request);
    CategoryResponse toCategoryResponse(Category category);
    void updateCategory(@MappingTarget Category category, CategoryRequest request);
}
