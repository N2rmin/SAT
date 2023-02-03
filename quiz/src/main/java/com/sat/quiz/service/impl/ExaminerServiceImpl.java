package com.sat.quiz.service.impl;

import com.sat.quiz.dto.requestDto.ExaminerRequestDto;
import com.sat.quiz.dto.responseDto.ExaminerResponseDto;

import com.sat.quiz.dto.responseDto.TextQuestionResponseDto;
import com.sat.quiz.entity.Examiner;

import com.sat.quiz.entity.PromoCode;
import com.sat.quiz.entity.TextQuestion;
import com.sat.quiz.repository.ExaminerRepository;
import com.sat.quiz.repository.PromoCodeRepository;
import com.sat.quiz.service.ExaminerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {
    private final ExaminerRepository examinerRepository;

    private final PromoCodeRepository promoCodeRepository;
    private final ModelMapper modelMapper;



    @Override
    public ExaminerResponseDto addExaminer(ExaminerRequestDto requestDto) throws Exception {
        //TextQuestion textQuestion= modelMapper.map(requestDto,TextQuestion.class);

        Examiner examiner=modelMapper.map(requestDto,Examiner.class);

        String promoCode= examiner.getPromoCode();

        PromoCode promoCode1=promoCodeRepository.findByPromoCode(promoCode);


//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//
//
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));



         System.out.println(promoCode1.getStartDate().compareTo(new Date()));
if (promoCode1.getStartDate().compareTo(new Date())>0) {

    System.out.println("Imtahan hele aktiv deyil");
    throw new Exception("Imtahan hele aktiv deyil");
    //  examiner.setCreatedDate(new Date());
    //examiner.setCreatedBy("Narmin");
//        examiner.setName(requestDto.getName());
//        examiner.setLastName(requestDto.getLastName());
//        examiner.setPromoCode(requestDto.getPromoCode());

    }

    //   examinerRepository.save(examiner);


        return  modelMapper.map(examinerRepository.save(examiner), ExaminerResponseDto.class);

       // return modelMapper.map(examiner,ExaminerResponseDto.class );
    }

    @Override
    public List<ExaminerResponseDto> getExaminers() {
        List<Examiner> examiners=examinerRepository.findAll();
        List<ExaminerResponseDto> examinerResponseDtos=examiners.stream().map(examiner -> modelMapper.map(examiner,ExaminerResponseDto.class)).collect(Collectors.toList());
        return examinerResponseDtos;
    }

    @Override
    public ExaminerResponseDto getExaminer(Long id) {
        Optional<Examiner> examiner = examinerRepository.findById(id);
        if(examiner.isPresent()){
            return modelMapper.map(examiner.get(),ExaminerResponseDto.class);
        }
        throw new RuntimeException("Examiner tapilmadi") ;
    }

    @Override
    public Examiner getExaminerSelf(Long id) {
        return examinerRepository.findById(id).orElseThrow(()->new IllegalArgumentException("could not find examiner with id:"+id));
    }

    @Override
    public ExaminerResponseDto updateExaminer(Long id, ExaminerRequestDto requestDto) {
        Optional<Examiner> examiner = examinerRepository.findById(id);
        if(examiner.isPresent()){
            examiner.get().setName(requestDto.getName());

            // examiner.get().setStatus(requestDto.isStatus());
            examiner.get().setUpdateDate(new Date());
            examiner.get().setUpdatedBy("Narmin");


            return modelMapper.map(examinerRepository.save(examiner.get()),ExaminerResponseDto.class);
        }
        throw new RuntimeException("Examiner tapilmadi") ;
    }

    @Override
    public Boolean deleteExaminer(Long id) {
        Optional<Examiner> examiner=examinerRepository.findById(id);

        if(examiner.isPresent()){
            examinerRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
