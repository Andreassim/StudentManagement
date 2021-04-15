package com.app.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExamTest {

  Exam testExam;

  @BeforeEach
  void setup() {
    testExam = new Exam("Math");
  }

  @Test
  void getNameTest() {
    String expected = "Math";

    Assertions.assertEquals(expected, testExam.getName());
  }

  @Test
  void getGradeCase12() {
    testExam.setGrade(0, 12);

    int expected = 12;

    Assertions.assertEquals(expected, testExam.getGrade());
  }

  @Test
  void getGradeCase10() {
    testExam.setGrade(0, 10);

    int expected = 10;

    Assertions.assertEquals(expected, testExam.getGrade());
  }

  @Test
  void getGradeWeighted() {
    testExam = new Exam("Math", new double[] {0.25, 0.75});
    testExam.setGrade(0, 2);
    testExam.setGrade(1, 7);

    int expected = 4;

    Assertions.assertEquals(expected, testExam.getGrade());
  }

  @Test
  void getGradeWeightedWrong() {
    testExam = new Exam("Math", new double[] {0.1, 0.9});
    testExam.setGrade(0, 10);
    testExam.setGrade(1, 4);

    Assertions.assertNotEquals(7, testExam.getGrade());
  }

  @Test
  void setWeightOfExamResultExpection() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> testExam = new Exam("Test", new double[] {0.1, 0.99}));
  }

  @Test
  void setGradeExceptionOutOfBoundsAbove() {
    testExam = new Exam("Test", new double[] {0.5, 0.5});
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> testExam.setGrade(3, 0));
  }

  @Test
  void setGradeExceptionOutOfBoundsBelow() {
    testExam = new Exam("Test", new double[] {0.5, 0.5});
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> testExam.setGrade(-1, 0));
  }

  @Test
  void setGradeSingleGradeExceptionOutOfBoundsAbove() {
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> testExam.setGrade(3, 0));
  }

  @Test
  void setGradeSingleGradeExceptionOutOfBoundsBelow() {
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> testExam.setGrade(-1, 0));
  }

  @Test
  void setGradeTest() {
    testExam.setGrade(0, 1);

    Assertions.assertEquals(0, testExam.getGrade());
  }

  @Test
  void gradeRoundingLessThan0() {
    testExam.setGrade(0, -1);

    Assertions.assertEquals(-3, testExam.getGrade());
  }

  @Test
  void gradeRoundingLessThan4() {
    testExam.setGrade(0, 3);

    Assertions.assertEquals(2, testExam.getGrade());
  }

  @Test
  void gradeRoundingLessThan7() {
    testExam.setGrade(0, 6);

    Assertions.assertEquals(4, testExam.getGrade());
  }

  @Test
  void gradeRoundingLessThan10() {
    testExam.setGrade(0, 9);

    Assertions.assertEquals(7, testExam.getGrade());
  }

  @Test
  void gradeRoundingLessThan12() {
    testExam.setGrade(0, 11);

    Assertions.assertEquals(10, testExam.getGrade());
  }
}
