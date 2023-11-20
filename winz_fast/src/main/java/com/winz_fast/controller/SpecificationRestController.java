package com.winz_fast.controller;

import com.winz_fast.dto.request.SpecificationRequestDTO;
import com.winz_fast.dto.response.SpecificationResponseDTO;
import com.winz_fast.service.ISpecificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/specifications")
@AllArgsConstructor
public class SpecificationRestController {
    private final  ISpecificationService iSpecificationService;
    @PostMapping("/create")
    public ResponseEntity<SpecificationResponseDTO> createSpecification(@RequestBody SpecificationRequestDTO specificationRequestDTO){
        SpecificationResponseDTO specificationResponseDTO= iSpecificationService.createSpecification(specificationRequestDTO);
        return new ResponseEntity<>(specificationResponseDTO, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<SpecificationResponseDTO> updateProduct(@PathVariable Long id, @RequestBody SpecificationRequestDTO specificationRequestDTO) {
        SpecificationResponseDTO specificationResponseDTO = iSpecificationService.updateSpecification(id,specificationRequestDTO);
        if (specificationRequestDTO != null) {
            return new ResponseEntity<>(specificationResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
