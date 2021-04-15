package com.app.model;

import java.util.ArrayList;

public class Student {
  String name;

  ArrayList<Exam> exams = new ArrayList<>();

  public Student(String name) {
    setName(name);
  }

  public void addExam(String subject, double[] array, int[] array2) {
    Exam exam = new Exam(subject, array);
    exams.add(exam);

    for (int i = 0; i < array.length; i++) {
      exam.setGrade(i, array2[i]);
    }
  }

  public void addExam(String subject, int grade) {
    Exam exam = new Exam(subject);
    exams.add(exam);
    exam.setGrade(0, grade);
  }

  public String getName(int i) {
    return exams.get(i).getName();
  }

  public int getGrade(int i) {
    return exams.get(i).getGrade();
  }

  public void save() {
    for (int i = 0; i < exams.size(); i++) {
      System.out.println("Result: " + getName(i) + " " + getGrade(i));
    }
    System.out.println("Average: " + calculateAverage());
  }


  public void setName(String name) {
    boolean valid = name.matches("(?i)[a-z]([- ',.a-z]{0,23}[a-z])?");
    if (!valid) {
      throw new IllegalArgumentException("Illegal name");
    }
    this.name = name;
  }

  public double calculateAverage() {
    double result = 0;
    for (int i = 0; i < exams.size(); i++) {
      result += getGrade(i);
    }

    return result / exams.size();
  }
}
