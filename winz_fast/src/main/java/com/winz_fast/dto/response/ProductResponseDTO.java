package com.winz_fast.dto.response;

import com.winz_fast.entity.Category;
import com.winz_fast.entity.Users;
import lombok.Data;

import java.util.Date;

@Data
public class ProductResponseDTO {
    private Long id;
    private String title;
    private String thumbnail;
    private String productDate;
    private String price;
    private String view;
    private Long categoryId;
    private Long userId;
    private String message;

}
