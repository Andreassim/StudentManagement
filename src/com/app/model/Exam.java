package com.app.model;

import java.util.HashMap;
import java.util.Map;

class Exam {
  private final ExamResult[] exams;
  private final Map<ExamResult, Double> examWeight = new HashMap<>();
  private SchoolSubject name;

  Exam(SchoolSubject name) {
    setName(name);
    exams = initializeTests(1);
  }

  Exam(SchoolSubject examName, double[] examWeight) {
    setName(examName);
    int testAmount = examWeight.length;
    exams = initializeTests(testAmount);
    // TODO Refactor - rethink where we validate testWeight
    setWeightOfExamResult(examWeight);
  }

  SchoolSubject getName() {
    return name;
  }

  private void setName(SchoolSubject name) {
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

  private void setWeightOfExamResult(double[] weight) {
    double weightSum = 0;
    for (double v : weight) {
      weightSum += v;
    }

    if (!(weightSum == 1)) {
      throw new IllegalArgumentException("Sum weight must be 1.0");
    }

    for (int i = 0; i < weight.length; i++) {
      examWeight.replace(exams[i], weight[i]);
    }
  }

  private boolean isValidGrade(int grade) {
    int[] grades = new int[] {-3, 0, 2, 4, 7, 10, 12};

    for (int i : grades) {
      if (i == grade) {
        return true;
      }
    }

    return false;
  }

  void setGrade(int examIndex, int grade) {
    if (!isValidGrade(grade)) {
      throw new IllegalArgumentException("Illegal grade");
    }

    if (0 > examIndex || exams.length - 1 < examIndex) {
      throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
    }
    exams[examIndex].setGrade(grade);
  }

  int getGrade() throws NullPointerException {
    if (1 == exams.length) {
      return exams[0].getGrade();
    }

    double weightedGrade = 0.0;
    for (ExamResult exam : exams) {
      weightedGrade += exam.getGrade() * examWeight.get(exam);
    }

    int result = (int) weightedGrade;
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
}
