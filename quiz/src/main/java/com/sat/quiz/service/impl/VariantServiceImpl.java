package com.sat.quiz.service.impl;

import com.sat.quiz.dto.requestDto.VariantRequestDto;
import com.sat.quiz.dto.responseDto.VariantResponseDto;
import com.sat.quiz.entity.Variant;
import com.sat.quiz.repository.VariantRepository;
import com.sat.quiz.service.VariantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VariantServiceImpl implements VariantService {
    private final VariantRepository variantRepository;
    private final ModelMapper modelMapper;



    @Override
    public VariantResponseDto addVariant(VariantRequestDto requestDto) {
        Variant variant=modelMapper.map(requestDto,Variant.class);

        //  variant.setCreatedDate(new Date());
        // variant.setCreatedBy("Narmin");

        variant=variantRepository.save(variant);

        return modelMapper.map(variantRepository.save(variant),VariantResponseDto.class );
    }

    @Override
    public List<VariantResponseDto> getVariants() {
        List<Variant> variants=variantRepository.findAll();
        List<VariantResponseDto> variantResponseDtos=variants.stream().map(variant -> modelMapper.map(variant,VariantResponseDto.class)).collect(Collectors.toList());
        return variantResponseDtos;
    }

    @Override
    public VariantResponseDto getVariant(Long id) {
        Optional<Variant> variant = variantRepository.findById(id);
        if(variant.isPresent()){
            return modelMapper.map(variant.get(),VariantResponseDto.class);
        }
        throw new RuntimeException("Variant tapilmadi") ;
    }

    @Override
    public Variant getVariantSelf(Long id) {
        return variantRepository.findById(id).orElseThrow(()->new IllegalArgumentException("could not find variant with id:"+id));
    }

    @Override
    public VariantResponseDto updateVariant(Long id, VariantRequestDto requestDto) {
        return null;
    }

//    @Override
//    public VariantResponseDto updateVariant(Long id, VariantRequestDto requestDto) {
//        Optional<Variant> variant = variantRepository.findById(id);
//        if(variant.isPresent()){
//            variant.get().setName(requestDto.getName());
//            variant.get().setStatus(requestDto.isStatus());
//            variant.get().setUpdateDate(new Date());
//            variant.get().setUpdatedBy("Narmin");
//
//
//            return modelMapper.map(variantRepository.save(variant.get()),VariantResponseDto.class);
//        }
//        throw new RuntimeException("Variant tapilmadi") ;
//    }

    @Override
    public Boolean deleteVariant(Long id) {
        Optional<Variant> variant=variantRepository.findById(id);

        if(variant.isPresent()){
            variantRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
