package com.winz_fast.service;

import com.winz_fast.dto.request.ProductRequestDTO;
import com.winz_fast.dto.response.ProductResponseDTO;
import com.winz_fast.entity.Product;

import java.util.Optional;

public interface IProductService {

    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);
}
