package com.sat.quiz.controller;

import com.sat.quiz.dto.requestDto.SectionRequestDto;
import com.sat.quiz.dto.responseDto.SectionResponseDto;
import com.sat.quiz.service.SectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/sections")
public class SectionController {
    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping
    public ResponseEntity<SectionResponseDto> addSection(@RequestBody SectionRequestDto requestDto){
        SectionResponseDto sectionResponseDto=sectionService.addSection(requestDto);
        return ResponseEntity.ok(sectionResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<SectionResponseDto>> getSections(){
        List<SectionResponseDto> sectionResponseDtos =sectionService.getSections();
        return ResponseEntity.ok(sectionResponseDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<SectionResponseDto> getSection(@PathVariable("id") Long id){
        SectionResponseDto sectionResponseDto= sectionService.getSection(id);
        return ResponseEntity.ok(sectionResponseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<SectionResponseDto> updateSection(@PathVariable("id") Long id,
                                                                @RequestBody SectionRequestDto requestDto){
        SectionResponseDto sectionResponseDto= sectionService.updateSection(id,requestDto);
        return ResponseEntity.ok(sectionResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteSection(@PathVariable("id") Long id){
        Boolean resultSection=sectionService.deleteSection(id);
        return ResponseEntity.ok(resultSection);
    }
}
