package com.app.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExamTest {

  Exam testExam;

  @BeforeEach
  void setup() {
    testExam = new Exam(SchoolSubject.ART);
  }

  @Test
  void getNameTest() {
    SchoolSubject expected = SchoolSubject.ART;

    Assertions.assertEquals(expected, testExam.getName());
  }

  @Test
  void getGradeCase12() {
    testExam.setGrade(0, 12);

    Assertions.assertEquals(12, testExam.getGrade());
  }

  @Test
  void getGradeCase10() {
    testExam.setGrade(0, 10);

    Assertions.assertEquals(10, testExam.getGrade());
  }

  @Test
  void getGradeCase7() {
    testExam.setGrade(0, 7);

    Assertions.assertEquals(7, testExam.getGrade());
  }

  @Test
  void getGradeCase4() {
    testExam.setGrade(0, 4);

    Assertions.assertEquals(4, testExam.getGrade());
  }

  @Test
  void getGradeCase2() {
    testExam.setGrade(0, 2);

    Assertions.assertEquals(2, testExam.getGrade());
  }

  @Test
  void getGradeCase0() {
    testExam.setGrade(0, 0);

    Assertions.assertEquals(0, testExam.getGrade());
  }

  @Test
  void getGradeCaseMinus3() {
    testExam.setGrade(0, -3);

    Assertions.assertEquals(-3, testExam.getGrade());
  }

  @Test
  void getGradeWeighted() {
    testExam = new Exam(SchoolSubject.ART, new double[] {0.25, 0.75});
    testExam.setGrade(0, 2);
    testExam.setGrade(1, 7);

    Assertions.assertEquals(4, testExam.getGrade());
  }

  @Test
  void getGradeWeightedWrong() {
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 10);
    testExam.setGrade(1, 4);

    Assertions.assertNotEquals(7, testExam.getGrade());
  }

  @Test
  void setWeightOfExamResultExpectation() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.99}));
  }

  @Test
  void setWeightOfExamResultExpectation2() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> testExam = new Exam(SchoolSubject.ART, new double[] {0.0, 0.0}));
  }

  @Test
  void setWeightOfExamResultExpectation3() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> testExam = new Exam(SchoolSubject.ART, new double[] {-0.5, -0.5}));
  }

  @Test
  void setGradeExceptionOutOfBoundsAbove() {
    testExam = new Exam(SchoolSubject.ART, new double[] {0.5, 0.5});
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> testExam.setGrade(3, 0));
  }

  @Test
  void setGradeExceptionOutOfBoundsBelow() {
    testExam = new Exam(SchoolSubject.ART, new double[] {0.5, 0.5});
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
  void setGradeTestNotValidGrade() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> testExam.setGrade(0, 1));
  }

  @Test
  void getGradeWeightedRoundingLessThan2HigherThan0() {
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 0);
    testExam.setGrade(1, 2);

    Assertions.assertEquals(0, testExam.getGrade());
  }

  @Test
  void getGradeWeightedRoundingLessThan10HigherThan7() {
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 2);
    testExam.setGrade(1, 10);

    Assertions.assertEquals(7, testExam.getGrade());
  }

  @Test
  void getGradeWeightedRoundingLessThan12() {
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 10);
    testExam.setGrade(1, 12);

    Assertions.assertEquals(10, testExam.getGrade());
  }

  @Test
  void getGradeWeightedRoundingLessThan0() {
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 0);
    testExam.setGrade(1, -3);

    Assertions.assertEquals(-3, testExam.getGrade());
  }

  @Test
  void getGradeWeightedRounding12() {
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 12);
    testExam.setGrade(1, 12);

    Assertions.assertEquals(12, testExam.getGrade());
  }

  @Test
  void getGradeWeightedRoundingLessThan4HigherThan2() {
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 2);
    testExam.setGrade(1, 4);

    Assertions.assertEquals(2, testExam.getGrade());
  }
}
