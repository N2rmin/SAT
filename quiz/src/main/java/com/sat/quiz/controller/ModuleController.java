package com.sat.quiz.controller;

import com.sat.quiz.dto.requestDto.ModuleRequestDto;
import com.sat.quiz.dto.responseDto.ModuleResponseDto;
import com.sat.quiz.dto.responseDto.ModuleSectionResponseDto;
import com.sat.quiz.service.ModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/modules")
public class ModuleController {
    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @PostMapping
    public ResponseEntity<ModuleResponseDto> addModule(@RequestBody ModuleRequestDto requestDto){
        ModuleResponseDto moduleResponseDto=moduleService.addModule(requestDto);
        return ResponseEntity.ok(moduleResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<ModuleResponseDto>> getModules(){
        List<ModuleResponseDto> moduleResponseDtos =moduleService.getModules();
        return ResponseEntity.ok(moduleResponseDtos);
    }


    @GetMapping("/bySectionId/{sectionId}")
    public ResponseEntity<List<ModuleSectionResponseDto>> getModulesBySectionId(@PathVariable("sectionId") Long sectionId){
        List<ModuleSectionResponseDto> moduleResponseDtos =moduleService.getModulesBySectionId(sectionId);
        return ResponseEntity.ok(moduleResponseDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<ModuleResponseDto> getModule(@PathVariable("id") Long id){
        ModuleResponseDto moduleResponseDto= moduleService.getModule(id);
        return ResponseEntity.ok(moduleResponseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ModuleResponseDto> updateModule(@PathVariable("id") Long id,
                                                                @RequestBody ModuleRequestDto requestDto){
        ModuleResponseDto moduleResponseDto= moduleService.updateModule(id,requestDto);
        return ResponseEntity.ok(moduleResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteModule(@PathVariable("id") Long id){
        Boolean resultModule=moduleService.deleteModule(id);
        return ResponseEntity.ok(resultModule);
    }
}
