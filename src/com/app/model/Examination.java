package com.app.model;

import java.util.HashMap;
import java.util.Map;

public class Examination {
  private final Exam[] exams;
  private final Map<Exam, Double> examWeight = new HashMap<>();
  private String name;

  public Examination(String name) {
    setName(name);
    exams = initializeTests(1);
  }

  public Examination(String examName, double[] examWeight) {
    setName(examName);
    int testAmount = examWeight.length;
    exams = initializeTests(testAmount);
    // TODO Refactor - rethink where we validate testWeight
    setWeightOfTest(examWeight);
  }

  public void setName(String name) {
    this.name = name;
  }

  public Exam[] initializeTests(int testAmount) {
    Exam[] exams = new Exam[testAmount];
    for (int i = 0; i < testAmount; i++) {
      exams[i] = new Exam();
      examWeight.put(exams[i], 1.0 / testAmount);
    }
    return exams;
  }

  public void setWeightOfTest(double[] weight) {
    if (!(weight.length == exams.length)) {
      throw new IllegalArgumentException("Length of the array is different from amount of tests");
    }
    double weightSum = 0;
    for (int i = 0; i < weight.length; i++) {
      weightSum += weight[i];
    }
    // TODO allow some variance to rounding
    if (!(weightSum == 1)) {
      throw new IllegalArgumentException("Sum weight must be 1.0");
    }
    for (int i = 0; i < weight.length; i++) {
      examWeight.replace(exams[i], weight[i]);
    }
  }

  public void setGrade(int examIndex ,int grade){
    if(0 > examIndex || exams.length-1 < examIndex){
      throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
    }
    grade = gradeRoundToValidGrade(grade);
    exams[examIndex].setGrade(grade);
  }


  public int getGrade() throws NullPointerException{
    if(exams.length == 1){
      return exams[0].getGrade();
    }
    int result;
    double weightedGrade = 0.0;
    for(int i = 0; i < exams.length; i ++){
      weightedGrade += exams[i].getGrade()*examWeight.get(exams[i]);
    }
    result = (int) weightedGrade;
    result = gradeRoundToValidGrade(result);
    return result;
  }

  private int gradeRoundToValidGrade(int grade){
    if(0 > grade){
      return -3;
    }else if(2 > grade){
      return 0;
    }else if(4 > grade){
      return 2;
    }else if(7 > grade){
      return 4;
    }else if(10 > grade){
      return 7;
    }else if(12 > grade){
      return 10;
    }else{
      return 12;
    }
  }

  // TODO set grade; throw exceptions -> Andreas
}
