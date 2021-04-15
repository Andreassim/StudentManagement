package com.app.model;

import java.util.HashMap;
import java.util.Map;

public class Examination {
  private Test[] tests;
  private String name;
  private Map<Test, Double> testWeight = new HashMap<Test, Double>();

  public Examination(String name) {
    setName(name);
    tests = initializeTests(1);
  }

  public Examination(String name, double[] testWeight) {
    setName(name);
    int testAmount = testWeight.length;
    tests = initializeTests(testAmount);
    //TODO Refactor - rethink where we validate testWeight
    setWeightOfTest(testWeight);
  }

  public void setName(String name) {
    this.name = name;
  }

  public Test[] initializeTests(int testAmount) {
    Test[] tests = new Test[testAmount];
    for (int i = 0; i < testAmount; i++) {
      tests[i] = new Test();
      testWeight.put(tests[i], 1.0 / testAmount);
    }
    return tests;
  }

  public void setWeightOfTest(double[] weight) {
    if (!(weight.length == tests.length)) {
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
      testWeight.replace(tests[i], weight[i]);
    }
  }
}
