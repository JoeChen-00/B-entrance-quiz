package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.model.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.DivideStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/handler")
public class Resource {
    private final DivideStudentService divideStudentService;

    public Resource(DivideStudentService divideStudentService) {
        this.divideStudentService = divideStudentService;
        divideStudentService.initData();
    }

    @GetMapping("/All")
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok(divideStudentService.getStudentList());
    }

    @GetMapping("/Sequence")
    public ResponseEntity<List<ArrayList>> getOneSequenceStudent(){
        return ResponseEntity.ok(divideStudentService.getSequenceList());
    }

    @PatchMapping("/DivideStudent")
    public ResponseEntity<String> divideStudent(){
        divideStudentService.divideStudent();
        return ResponseEntity.ok("success");
    }

    @PatchMapping("/AddStudent/{StudentName}")
    public ResponseEntity<String> addStudent(@PathVariable String StudentName){
        divideStudentService.addStudent(StudentName);
        return ResponseEntity.ok("success");
    }
}
