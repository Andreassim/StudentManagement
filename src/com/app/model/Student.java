package com.app.model;

import com.app.controllers.SchoolSubject;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
  String name;
  ArrayList<Exam> exams = new ArrayList<>();

  public Student(String name) {
    setName(name);
  }

  public void addExam(SchoolSubject subject, double[] array, int[] array2) {
    Exam exam = new Exam(subject, array);
    exams.add(exam);

    for (int i = 0; i < array.length; i++) {
      exam.setGrade(i, array2[i]);
    }
  }

  public void addExam(SchoolSubject subject, int grade) {
    Exam exam = new Exam(subject);
    exams.add(exam);
    exam.setGrade(0, grade);
  }

  public SchoolSubject getExamName(int i) {
    return exams.get(i).getName();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    boolean valid = name.matches("(?i)[a-z]([- ',.a-z]{0,23}[a-z])?");
    if (!valid) {
      throw new IllegalArgumentException("Illegal name");
    }

    this.name = name;
  }

  public int getGrade(int i) {
    return exams.get(i).getGrade();
  }

  public HashMap<SchoolSubject, Integer> result() {
    HashMap<SchoolSubject, Integer> result = new HashMap<>();

    for (int i = 0; i < exams.size(); i++) {
      result.put(getExamName(i), getGrade(i));
    }

    return result;
  }

  public double calculateAverage() {
    double result = 0;
    for (int i = 0; i < exams.size(); i++) {
      result += getGrade(i);
    }

    return result / exams.size();
  }
}
