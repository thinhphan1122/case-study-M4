package com.winz_fast.dto.request;

import com.winz_fast.entity.Specification;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductRequestDTO {
    private Long id;
    private String title;
    private String thumbnail;
    private String productDate;
    private String price;
    private String view;
    private Long userId;
    private Long categoryId;
    private Specification specification;
}
