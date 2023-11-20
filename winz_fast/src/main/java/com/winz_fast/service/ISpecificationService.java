package com.winz_fast.service;

import com.winz_fast.dto.request.SpecificationRequestDTO;
import com.winz_fast.dto.response.SpecificationResponseDTO;
import com.winz_fast.entity.Specification;

import java.util.Optional;

public interface ISpecificationService {
SpecificationResponseDTO createSpecification(SpecificationRequestDTO specificationRequestDTO);
SpecificationResponseDTO updateSpecification(Long id,SpecificationRequestDTO specificationRequestDTO);

}
