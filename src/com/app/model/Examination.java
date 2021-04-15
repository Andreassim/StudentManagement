package com.app.model;

import java.util.HashMap;
import java.util.Map;

public class Examination {
  private final Exam[] exams;
  private final Map<Exam, Double> testWeight = new HashMap<Exam, Double>();
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
      testWeight.put(exams[i], 1.0 / testAmount);
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
      testWeight.replace(exams[i], weight[i]);
    }
  }

  // TODO Add getters; final grade -> Andreas
  // TODO set grade; throw exceptions -> Andreas
}
