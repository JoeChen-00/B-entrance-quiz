package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class DivideStudentService {
  //TODO GTB-知识点: * 了解下三层架构
  //TODO GTB-知识点: - DivideStudentService.java:13 数据存储相关的操作，不属于service的职责，应该抽取repository层做
  static private List<Student> studentList;
  static private List<ArrayList> sequenceList = new ArrayList<>();

  public DivideStudentService() {
  }


  public void initData(){
    studentList = new ArrayList<>(Arrays.asList(
//      new Student(1,"成吉思汗"),
//      new Student(2,"鲁班七号"),
//      new Student(3,"太乙真人"),
//      new Student(4,"钟无艳"),
//      new Student(5,"花木兰"),
//      new Student(6,"雅典娜"),
//      new Student(7,"芈月"),
//      new Student(8,"白起"),
//      new Student(9,"刘禅"),
//      new Student(10,"庄周"),
//      new Student(11,"马超"),
//      new Student(12,"刘备"),
//      new Student(13,"哪吒"),
//      new Student(14,"大乔"),
//      new Student(15,"蔡文姬")
    ));
  }

  public List<Student> getStudentList() {
    return studentList;
  }

  public List<ArrayList> getSequenceList() {
    return sequenceList;
  }

  public void divideStudent(){
    //TODO GTB-工程实践: - DivideStudentService.java:51 长方法，需要分模块抽取方法，进行重构
    int length = studentList.size();
    List<Student> studentListClone = new ArrayList<>();
    studentListClone.addAll(studentList);
    Collections.shuffle(studentListClone);
    sequenceList.clear();
    //TODO GTB-工程实践: - DivideStudentService.java:56 Magic number
    //TODO GTB-工程实践: - DivideStudentService.java:58 命名不表意，且变量名应该是驼峰形式
    for(int iter_i = 0;iter_i < 6; ++iter_i){
      ArrayList<Student> sequence = new ArrayList<>();
      for(int iter_j = iter_i * 2 + Math.min(iter_i,length%6);
          iter_j < (iter_i + 1) * 2 + Math.min(iter_i + 1,length%6); ++iter_j){
        sequence.add(studentListClone.get(iter_j));
      }
      sequenceList.add(sequence);
    }
  }

  public void addStudent(String StudentName){
    int length = studentList.size();
    Student newStudent = new Student(length + 1,StudentName);
    studentList.add(newStudent);
  }
}
