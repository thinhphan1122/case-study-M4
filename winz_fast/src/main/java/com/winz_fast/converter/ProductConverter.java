package com.winz_fast.converter;

import com.winz_fast.dto.request.ProductRequestDTO;
import com.winz_fast.dto.response.ProductResponseDTO;
import com.winz_fast.entity.Product;
import com.winz_fast.entity.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    @Autowired
    private SpecificationConverter specificationConverter;

    public ProductResponseDTO getProductResponseDTO(Product product) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setThumbnail(product.getThumbnail());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setView(String.valueOf(product.getView()));
        responseDTO.setProductDate(product.getProductDate());
        responseDTO.setCategoryId(product.getCategoryId().getId());
        return responseDTO;
    }
}
