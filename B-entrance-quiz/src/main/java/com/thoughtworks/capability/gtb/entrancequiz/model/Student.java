package com.thoughtworks.capability.gtb.entrancequiz.model;

public class Student {
  private int number;
  private String name;

  public Student(int number, String name) {
    this.number = number;
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void set(int number, String name) {
    this.number = number;
    this.name = name;
  }
}
