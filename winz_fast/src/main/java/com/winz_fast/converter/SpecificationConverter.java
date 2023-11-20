package com.winz_fast.converter;

import com.winz_fast.dto.request.SpecificationRequestDTO;
import com.winz_fast.dto.response.SpecificationResponseDTO;
import com.winz_fast.entity.Specification;
import org.springframework.stereotype.Component;

@Component
public class SpecificationConverter {
    public SpecificationResponseDTO getSpecificationResponseDTO(Specification specification){
        SpecificationResponseDTO specificationResponseDTO =new SpecificationResponseDTO();
        specificationResponseDTO.setId(specification.getId());
        specificationResponseDTO.setBrand(specification.getBrand());
        specificationResponseDTO.setCarModel(specification.getCarModel());
        specificationResponseDTO.setEngine(specification.getEngine());
        specificationResponseDTO.setYear(specification.getYear());
        specificationResponseDTO.setFuel(specification.getFuel());
        specificationResponseDTO.setOrigin(specification.getOrigin());
        specificationResponseDTO.setGear(specification.getGear());
        specificationResponseDTO.setNumberOfSeat(specification.getNumberOfSeat());
        specificationResponseDTO.setProductId(specification.getProductId().getId());
        return specificationResponseDTO;
    }

}
