package com.winz_fast.service.impl;
import com.winz_fast.converter.ProductConverter;
import com.winz_fast.dto.request.ProductRequestDTO;
import com.winz_fast.dto.response.ProductResponseDTO;
import com.winz_fast.entity.Category;
import com.winz_fast.entity.Product;
import com.winz_fast.repository.ICategoryRepository;
import com.winz_fast.repository.IProductRepository;
import com.winz_fast.service.IProductService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository iProductRepository;
    private final ProductConverter productConverter;
    private final ICategoryRepository iCategoryRepository;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        return getProductResponseDTO(productRequestDTO, product);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Optional<Product> optionalProduct = iProductRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            throw new RuntimeException("Product not found with id" + id);
        }
        Product product=optionalProduct.get();
        return getProductResponseDTO(productRequestDTO, product);
    }

    private ProductResponseDTO getProductResponseDTO(ProductRequestDTO productRequestDTO, Product product) {
        product.setTitle(productRequestDTO.getTitle());
        product.setThumbnail(productRequestDTO.getThumbnail());
        product.setProductDate(productRequestDTO.getProductDate());
        product.setPrice(productRequestDTO.getPrice());
        Long categoryId = productRequestDTO.getCategoryId();
        Category category = iCategoryRepository.findById(categoryId).orElse(null);
        product.setCategoryId(category);
        iProductRepository.save(product);
        return productConverter.getProductResponseDTO(product);
    }
}