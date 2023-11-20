package com.winz_fast.service.impl;
import com.winz_fast.converter.SpecificationConverter;
import com.winz_fast.dto.request.SpecificationRequestDTO;
import com.winz_fast.dto.response.SpecificationResponseDTO;
import com.winz_fast.entity.Product;
import com.winz_fast.entity.Specification;
import com.winz_fast.repository.IProductRepository;
import com.winz_fast.repository.ISpecificationRepository;
import com.winz_fast.service.ISpecificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SpecificationServiceImpl implements ISpecificationService {

    private final SpecificationConverter specificationConverter;

    private final ISpecificationRepository iSpecificationRepository;
    private final IProductRepository iProductRepository;


    @Override
    public SpecificationResponseDTO createSpecification(SpecificationRequestDTO specificationRequestDTO) {
        Specification specification = new Specification();
        return getSpecificationResponseDTO(specificationRequestDTO, specification);
    }

    @Override
    public SpecificationResponseDTO updateSpecification(Long id, SpecificationRequestDTO specificationRequestDTO) {
        Optional<Specification> optionalSpecification = iSpecificationRepository.findById(id);
        if (!optionalSpecification.isPresent()) {
            throw new RuntimeException("Specification not found with id" + id);
        }
        Specification specification = optionalSpecification.get();
        return getSpecificationResponseDTO(specificationRequestDTO, specification);

    }

    private SpecificationResponseDTO getSpecificationResponseDTO(SpecificationRequestDTO specificationRequestDTO, Specification specification) {
        specification.setBrand(specificationRequestDTO.getBrand());
        specification.setCarModel(specificationRequestDTO.getCarModel());
        specification.setGear(specificationRequestDTO.getGear());
        specification.setFuel(specificationRequestDTO.getFuel());
        specification.setEngine(specificationRequestDTO.getEngine());
        specification.setOrigin(specificationRequestDTO.getOrigin());
        specification.setNumberOfSeat(specificationRequestDTO.getNumberOfSeat());
        specification.setYear(specificationRequestDTO.getYear());
        Long productId = specificationRequestDTO.getProductId();
        Product product = iProductRepository.findById(productId).orElse(null);
        specification.setProductId(product);
        iSpecificationRepository.save(specification);
        return specificationConverter.getSpecificationResponseDTO(specification);
    }


}
