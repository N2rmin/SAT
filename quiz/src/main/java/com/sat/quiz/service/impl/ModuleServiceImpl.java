package com.sat.quiz.service.impl;

import com.sat.quiz.dto.TextQuestionDtoTest;
import com.sat.quiz.dto.mapper;
import com.sat.quiz.dto.requestDto.ModuleRequestDto;
import com.sat.quiz.dto.responseDto.ModuleResponseDto;
import com.sat.quiz.dto.responseDto.SectionResponseDto;
import com.sat.quiz.entity.Module;
import com.sat.quiz.entity.Section;
import com.sat.quiz.repository.ModuleRepository;
import com.sat.quiz.service.ModuleService;
import com.sat.quiz.service.SectionService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private  final ModuleRepository moduleRepository;
    private final SectionService selectionService;

    private final ModelMapper modelMapper;

    @Override
    public ModuleResponseDto addModule(ModuleRequestDto requestDto) {
        Module module= new Module();
        if (requestDto.getSectionId()==null){
            throw  new IllegalArgumentException("module at least one selection");
        }
        Section selection= selectionService.getSectionSelf(requestDto.getSectionId());
        module.setSection(selection);
        module.setName(requestDto.getName());
        module.setStatus(requestDto.isStatus());
        module.setDuration(requestDto.getDuration());
        module.setNumberOfQuestion(requestDto.getNumberOfQuestion());
        return modelMapper.map(moduleRepository.save(module), ModuleResponseDto.class );

    }




    @Override
    public List<ModuleResponseDto> getModules() {

        List<ModuleResponseDto> list = new ArrayList<>();

       moduleRepository.findAll().stream().forEach(obj->{
          list.add(modelMapper.map(obj,ModuleResponseDto.class));
      });
        return list;


    }


    @Override
    public ModuleResponseDto getModule(Long id) {
        Module module= getModuleSelf(id);
        return modelMapper.map(module,ModuleResponseDto.class);
    }

    @Override
    public Module getModuleSelf(Long id) {
        return moduleRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("cannot find module with id:" +id));
    }


    @Override
    public ModuleResponseDto updateModule(Long id, ModuleRequestDto requestDto) {
        Module module= getModuleSelf(id);
        if(requestDto.getSectionId()!=null){
            Section selection=selectionService.getSectionSelf(requestDto.getSectionId());
            module.setSection(selection);
        }
        module.setName(requestDto.getName());
        module.setStatus(requestDto.isStatus());
        module.setDuration(requestDto.getDuration());
        module.setNumberOfQuestion(requestDto.getNumberOfQuestion());
        moduleRepository.save(module);
        return modelMapper.map(module,ModuleResponseDto.class);
    }

    @Override
    public Boolean deleteModule(Long id) {
        Optional<Module> module=moduleRepository.findById(id);

        if(module.isPresent()){
            moduleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
