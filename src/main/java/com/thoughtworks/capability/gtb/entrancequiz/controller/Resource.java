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
//TODO GTB-知识点: * API设计不符合restful规范
//TODO GTB-工程实践: * Resource.java:14 一般项目上（使用了常规三层架构），在controller这一层class的命名，以xxxController命名。如果是用了其他必须要按照特定规则命名框架，那就按照项目要求来。
public class Resource {
    private final DivideStudentService divideStudentService;

    public Resource(DivideStudentService divideStudentService) {
        this.divideStudentService = divideStudentService;
        divideStudentService.initData();
    }
    //TODO GTB-工程实践: - Resource.java:22 path应该首字母小写
    @GetMapping("/All")
    //TODO GTB-知识点: * 如果不是特定的自定义返回结果，ResponseEntity可以省略
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok(divideStudentService.getStudentList());
    }

    //TODO GTB-完成度: - Resource.java:30 缺少组名
    @GetMapping("/Sequence")
    public ResponseEntity<List<ArrayList>> getOneSequenceStudent(){
        return ResponseEntity.ok(divideStudentService.getSequenceList());
    }

    //TODO GTB-知识点: - Resource.java:35 按照restful规范，这里应该是一个POST请求
    //TODO GTB-完成度: - Resource.java:37 当组员为0的时候，分组接口会报错，500
    @PatchMapping("/DivideStudent")
    public ResponseEntity<String> divideStudent(){
        divideStudentService.divideStudent();
        return ResponseEntity.ok("success");
    }

    //TODO GTB-知识点: - Resource.java:43 按照restful规范，这里应该是一个POST请求
    @PatchMapping("/AddStudent/{StudentName}")
    //TODO GTB-工程实践: - Resource.java:41 变量名应该是驼峰，首字母小写
    public ResponseEntity<String> addStudent(@PathVariable String StudentName){
        divideStudentService.addStudent(StudentName);
        return ResponseEntity.ok("success");
    }
}

