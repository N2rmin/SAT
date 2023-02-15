package com.sat.quiz.service.impl;

import com.sat.quiz.dto.requestDto.PromoCodeDate;
import com.sat.quiz.dto.requestDto.PromoCodeId;
import com.sat.quiz.dto.requestDto.PromoCodeRequestDto;
import com.sat.quiz.dto.responseDto.PromoCodeResponseDto;
import com.sat.quiz.entity.Examiner;
import com.sat.quiz.entity.PromoCode;
import com.sat.quiz.entity.Result;
import com.sat.quiz.repository.ExaminerRepository;
import com.sat.quiz.repository.PromoCodeRepository;
import com.sat.quiz.repository.ResultRepository;
import com.sat.quiz.service.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromoCodeServiceImpl implements PromoCodeService {
    private final PromoCodeRepository promoCodeRepository;

    private final ExaminerRepository examinerRepository;
    private  final ResultRepository resultRepository;
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
                promoCodes=promoCodeRepository.findTopByIdAndStatusTrueAndStartDateIsNotNull(50L);
    }else {
            promoCodes=promoCodeRepository.findFirst50AndStatusTrueAndStartDateIsNullByOrderByIdAsc();
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
    public PromoCodeResponseDto updatePromoCode( PromoCodeDate requestDto) {
        for (Long id:requestDto.getPromoCodeIds()){
            Optional<PromoCode> promoCode = promoCodeRepository.findById(id);
            System.out.println(id);
            if(promoCode.isPresent()){

                // promoCode.get().setStatus(requestDto.isStatus());
                promoCode.get().setStartDate(requestDto.getStartDate());
                promoCode.get().setEndDate(requestDto.getEndDate());
                // promoCode.get().setStatus(requestDto.getStatus());


                 modelMapper.map(promoCodeRepository.save(promoCode.get()),PromoCodeResponseDto.class);
            }else {
                throw new RuntimeException("PromoCode tapilmadi");
            }
        }
        return null;

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

    @Override
    public List<PromoCodeResponseDto> checkPromoCode(String promoCode, Long moduleId) throws Exception {

        PromoCode promoCode1=promoCodeRepository.findByPromoCode(promoCode);


//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//
//
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));



        System.out.println(promoCode1.getStartDate().compareTo(new Date()));
        if (promoCode1.getStartDate().compareTo(new Date())>0 || promoCode1.getEndDate().compareTo(new Date())<0) {

            System.out.println("Imtahan hele aktiv deyil");
            throw new Exception("Imtahan hele aktiv deyil");
            //  examiner.setCreatedDate(new Date());
            //examiner.setCreatedBy("Narmin");
//        examiner.setName(requestDto.getName());
//        examiner.setLastName(requestDto.getLastName());
//        examiner.setPromoCode(requestDto.getPromoCode());
        }


            Examiner examiner= examinerRepository.findByPromoCode(promoCode);
            Result result = resultRepository.findByExaminerIdAndModuleId(examiner.getId(),moduleId);
            if (result != null){
                throw new DataIntegrityViolationException("Bir user eyni modulue yeniden imtahan vere bilmez");
            }






        return null;
    }


}
