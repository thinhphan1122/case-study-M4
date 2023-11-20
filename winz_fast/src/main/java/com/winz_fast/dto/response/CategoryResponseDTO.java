package com.winz_fast.dto.response;

import com.winz_fast.entity.Product;
import lombok.Data;

@Data
public class CategoryResponseDTO {
    private Long id;
    private String logo;
    private String name;
    private Product product;
    private String message;
}
