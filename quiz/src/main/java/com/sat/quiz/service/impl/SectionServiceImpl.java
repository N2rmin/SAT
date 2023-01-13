package com.sat.quiz.service.impl;

import com.sat.quiz.dto.requestDto.SectionRequestDto;
import com.sat.quiz.dto.responseDto.SectionResponseDto;
import com.sat.quiz.entity.Section;
import com.sat.quiz.repository.SectionRepository;
import com.sat.quiz.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {
    private final SectionRepository sectionRepository;
    private final ModelMapper modelMapper;



    @Override
    public SectionResponseDto addSection(SectionRequestDto requestDto) {
        Section section=modelMapper.map(requestDto,Section.class);

        section.setCreatedDate(new Date());
        section.setCreatedBy("Narmin");

        section=sectionRepository.save(section);

        return modelMapper.map(sectionRepository.save(section),SectionResponseDto.class );
    }

    @Override
    public List<SectionResponseDto> getSections() {
        List<Section> sections=sectionRepository.findAll();
        List<SectionResponseDto> sectionResponseDtos=sections.stream().map(section -> modelMapper.map(section,SectionResponseDto.class)).collect(Collectors.toList());
        return sectionResponseDtos;
    }

    @Override
    public SectionResponseDto getSection(Long id) {
        Optional<Section> section = sectionRepository.findById(id);
        if(section.isPresent()){
            return modelMapper.map(section.get(),SectionResponseDto.class);
        }
        throw new RuntimeException("Section tapilmadi") ;
    }

    @Override
    public Section getSectionSelf(Long id) {
        return sectionRepository.findById(id).orElseThrow(()->new IllegalArgumentException("could not find section with id:"+id));
    }

    @Override
    public SectionResponseDto updateSection(Long id, SectionRequestDto requestDto) {
        Optional<Section> section = sectionRepository.findById(id);
        if(section.isPresent()){
            section.get().setName(requestDto.getName());
            section.get().setStatus(requestDto.isStatus());
            section.get().setUpdateDate(new Date());
            section.get().setUpdatedBy("Narmin");


            return modelMapper.map(sectionRepository.save(section.get()),SectionResponseDto.class);
        }
        throw new RuntimeException("Section tapilmadi") ;
    }

    @Override
    public Boolean deleteSection(Long id) {
        Optional<Section> section=sectionRepository.findById(id);

        if(section.isPresent()){
            sectionRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
