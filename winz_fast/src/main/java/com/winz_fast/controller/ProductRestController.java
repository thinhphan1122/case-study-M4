package com.winz_fast.controller;

import com.winz_fast.dto.request.ProductRequestDTO;
import com.winz_fast.dto.response.ProductResponseDTO;
import com.winz_fast.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    private IProductService iProductService;
    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO= iProductService.createProduct(productRequestDTO);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO productResponseDTO = iProductService.updateProduct(id,productRequestDTO);
        if (productRequestDTO != null) {
            return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
