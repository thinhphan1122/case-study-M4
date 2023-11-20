package com.winz_fast.converter;

import com.winz_fast.dto.request.CategoryRequestDTO;
import com.winz_fast.dto.response.CategoryResponseDTO;
import com.winz_fast.entity.Category;
import com.winz_fast.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConverter {
//    public CategoryDTO entityToDto(Category category) {
//        CategoryDTO categoryDTO = new CategoryDTO();
//        categoryDTO.setId(category.getId());
//        categoryDTO.setName(categoryDTO.getName());
//        categoryDTO.setLogo(categoryDTO.getLogo());
//        return categoryDTO;
//    }
//
//    public Category dtoToEntity(CategoryDTO categoryDTO) {
//        Category category = new Category();
//        category.setName(categoryDTO.getName());
//        category.setLogo(categoryDTO.getLogo());
//        return category;
//    }
//
//    public Category dtoToEntity(CategoryDTO categoryDTO, Category category) {
//        category.setName(categoryDTO.getName());
//        category.setLogo(categoryDTO.getLogo());
//        return category;
//    }
@Autowired
private ProductConverter productConverter;
    public Category fromCategoryDTOToCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = new Category();
        category.setName(categoryRequestDTO.getName());
        category.setLogo(categoryRequestDTO.getLogo());
        return category;
    }

    public CategoryResponseDTO fromCategoryToCategoryDTO(Category category) {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setId(category.getId());
        categoryResponseDTO.setName(category.getName());
        categoryResponseDTO.setLogo(category.getLogo());
        List<Product> productList = (category.getProducts());
        return categoryResponseDTO;
    }

    public List<CategoryResponseDTO> fromCategoryListToCategoryDTOList(List<Category> categoryList) {
        List<CategoryResponseDTO> categoryResponseDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryResponseDTOList.add(fromCategoryToCategoryDTO(category));
        }
        return  categoryResponseDTOList;
    }
}
