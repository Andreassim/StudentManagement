package com.app.model;

import java.util.HashMap;
import java.util.Map;

public class Exam {
  private final ExamResult[] exams;
  private final Map<ExamResult, Double> examWeight = new HashMap<>();
  private String name;

  // WIP
  static boolean isValidGrade(int needle, int[] haystack) {
    for (int i : haystack) {
      if (i == needle) {
        return true;
      }
    }

    return false;
  }

  public Exam(String name) {
    // todo isValidGrade
    setName(name);
    exams = initializeTests(1);
  }

  public Exam(String examName, double[] examWeight) {
    setName(examName);
    int testAmount = examWeight.length;
    exams = initializeTests(testAmount);
    // TODO Refactor - rethink where we validate testWeight
    setWeightOfTest(examWeight);
  }

  public String getName() {
    return name;
  }

  private void setName(String name) {
    this.name = name;
  }

  private ExamResult[] initializeTests(int testAmount) {
    ExamResult[] exams = new ExamResult[testAmount];
    for (int i = 0; i < testAmount; i++) {
      exams[i] = new ExamResult();
      examWeight.put(exams[i], 1.0 / testAmount);
    }
    return exams;
  }

  private void setWeightOfTest(double[] weight) {
    if (!(weight.length == exams.length)) {
      throw new IllegalArgumentException("Length of the array is different from amount of tests");
    }
    double weightSum = 0;
    for (double v : weight) {
      weightSum += v;
    }
    // TODO allow some variance to rounding
    if (!(weightSum == 1)) {
      throw new IllegalArgumentException("Sum weight must be 1.0");
    }
    for (int i = 0; i < weight.length; i++) {
      examWeight.replace(exams[i], weight[i]);
    }
  }

  public void setGrade(int examIndex, int grade) {
    if (0 > examIndex || exams.length - 1 < examIndex) {
      throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
    }
    grade = gradeRoundToValidGrade(grade);
    exams[examIndex].setGrade(grade);
  }

  public int getGrade() throws NullPointerException {
    if (exams.length == 1) {
      return exams[0].getGrade();
    }
    int result;
    double weightedGrade = 0.0;
    for (ExamResult exam : exams) {
      weightedGrade += exam.getGrade() * examWeight.get(exam);
    }
    result = (int) weightedGrade;
    result = gradeRoundToValidGrade(result);
    return result;
  }

  private int gradeRoundToValidGrade(int grade) {
    if (0 > grade) {
      return -3;
    } else if (2 > grade) {
      return 0;
    } else if (4 > grade) {
      return 2;
    } else if (7 > grade) {
      return 4;
    } else if (10 > grade) {
      return 7;
    } else if (12 > grade) {
      return 10;
    } else {
      return 12;
    }
  }

  // TODO set grade; throw exceptions -> Andreas
}
