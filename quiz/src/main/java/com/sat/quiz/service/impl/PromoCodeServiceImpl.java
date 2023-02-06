package com.sat.quiz.service.impl;

import com.sat.quiz.dto.requestDto.PromoCodeRequestDto;
import com.sat.quiz.dto.responseDto.PromoCodeResponseDto;
import com.sat.quiz.entity.PromoCode;
import com.sat.quiz.repository.PromoCodeRepository;
import com.sat.quiz.service.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromoCodeServiceImpl implements PromoCodeService {
    private final PromoCodeRepository promoCodeRepository;
    private final ModelMapper modelMapper;



    @Override
    public PromoCodeResponseDto addPromoCode(PromoCodeRequestDto requestDto) {
        //TextQuestion textQuestion= modelMapper.map(requestDto,TextQuestion.class);

        PromoCode promoCode=modelMapper.map(requestDto,PromoCode.class);

      //  promoCode.setCreatedDate(new Date());
        //promoCode.setCreatedBy("Narmin");
//        promoCode.setName(requestDto.getName());
//        promoCode.setLastName(requestDto.getLastName());
//        promoCode.setPromoCode(requestDto.getPromoCode());

    //   promoCodeRepository.save(promoCode);

        return  modelMapper.map(promoCodeRepository.save(promoCode), PromoCodeResponseDto.class);

       // return modelMapper.map(promoCode,PromoCodeResponseDto.class );
    }

    @Override
    public List<PromoCodeResponseDto> getPromoCodes(Boolean isUsed) {
        List<PromoCode> promoCodes;
        if (isUsed){
                promoCodes=promoCodeRepository.findAllByStartDateIsNotNull();
    }else {
            promoCodes=promoCodeRepository.findAllByStartDateIsNull();
        }

        List<PromoCodeResponseDto> promoCodeResponseDtos=promoCodes.stream().map(promoCode -> modelMapper.map(promoCode,PromoCodeResponseDto.class)).collect(Collectors.toList());
        return promoCodeResponseDtos;
    }

    @Override
    public PromoCodeResponseDto getPromoCode(Long id) {
        Optional<PromoCode> promoCode = promoCodeRepository.findById(id);
        if(promoCode.isPresent()){
            return modelMapper.map(promoCode.get(),PromoCodeResponseDto.class);
        }
        throw new RuntimeException("PromoCode tapilmadi") ;
    }

    @Override
    public PromoCode getPromoCodeSelf(Long id) {
        return promoCodeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("could not find promoCode with id:"+id));
    }

    @Override
    public PromoCodeResponseDto updatePromoCode(Long id, PromoCodeRequestDto requestDto) {
        Optional<PromoCode> promoCode = promoCodeRepository.findById(id);
        if(promoCode.isPresent()){

            // promoCode.get().setStatus(requestDto.isStatus());
            promoCode.get().setStartDate(requestDto.getStartDate());
            promoCode.get().setStatus(requestDto.getStatus());


            return modelMapper.map(promoCodeRepository.save(promoCode.get()),PromoCodeResponseDto.class);
        }
        throw new RuntimeException("PromoCode tapilmadi") ;
    }

    @Override
    public Boolean deletePromoCode(Long id) {
        Optional<PromoCode> promoCode=promoCodeRepository.findById(id);

        if(promoCode.isPresent()){
            promoCodeRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
