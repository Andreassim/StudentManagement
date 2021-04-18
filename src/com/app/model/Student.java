package com.app.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
  String name;
  ArrayList<Exam> exams = new ArrayList<>();

  public Student(String name) {
    setName(name);
  }

  public void addExam(SchoolSubject subject, double[] weightDistribution, int[] gradeDistribution) {
    Exam exam = new Exam(subject, weightDistribution);
    exams.add(exam);

    for (int i = 0; i < weightDistribution.length; i++) {
      exam.setGrade(i, gradeDistribution[i]);
    }
  }

  public void addExam(SchoolSubject subject, int grade) {
    Exam exam = new Exam(subject);
    exams.add(exam);
    exam.setGrade(0, grade);
  }

  private SchoolSubject getExamName(int i) {
    return exams.get(i).getName();
  }

  public String getName() {
    return name;
  }

  private void setName(String name) {
    boolean valid = name.matches("(?i)[a-z]([- ',.a-z]{0,23}[a-z])?");
    if (!valid) {
      throw new IllegalArgumentException("Illegal name");
    }

    this.name = name;
  }

  private int getGrade(int i) {
    return exams.get(i).getGrade();
  }

  public HashMap<SchoolSubject, Integer> result() {
    HashMap<SchoolSubject, Integer> result = new HashMap<>();

    for (int i = 0; i < exams.size(); i++) {
      result.put(getExamName(i), getGrade(i));
    }

    return result;
  }

  public double getAverage() {
    double result = 0;
    for (int i = 0; i < exams.size(); i++) {
      result += getGrade(i);
    }

    return result / exams.size();
  }
}
