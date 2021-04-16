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
    testExam = new Exam(SchoolSubject.ART, new double[] {0.25, 0.75});
    testExam.setGrade(0, 2);
    testExam.setGrade(1, 7);

    int expected = 4;

    Assertions.assertEquals(expected, testExam.getGrade());
  }

  @Test
  void getGradeWeightedWrong() {
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 10);
    testExam.setGrade(1, 4);

    Assertions.assertNotEquals(7, testExam.getGrade());
  }

  @Test
  void setWeightOfExamResultExpection() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.99}));
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
  void getGradeWeigthedRoundingLessThan2HigherThan0(){
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 00);
    testExam.setGrade(1, 02);

    Assertions.assertEquals(0, testExam.getGrade());
  }

  @Test
  void getGradeWeigthedRoundingLessThan10HigherThan7(){
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 02);
    testExam.setGrade(1, 10);

    Assertions.assertEquals(7, testExam.getGrade());
  }

  @Test
  void getGradeWeigthedRoundingLessThan12(){
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 10);
    testExam.setGrade(1, 12);

    Assertions.assertEquals(10, testExam.getGrade());
  }

  @Test
  void getGradeWeigthedRoundingLessThan0(){
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 00);
    testExam.setGrade(1, -3);

    Assertions.assertEquals(-3, testExam.getGrade());
  }

  @Test
  void getGradeWeigthedRounding12(){
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 12);
    testExam.setGrade(1, 12);

    Assertions.assertEquals(12, testExam.getGrade());
  }

  @Test
  void getGradeWeigthedRoundingLessThan4HigherThan2(){
    testExam = new Exam(SchoolSubject.ART, new double[] {0.1, 0.9});
    testExam.setGrade(0, 02);
    testExam.setGrade(1, 4);

    Assertions.assertEquals(2, testExam.getGrade());
  }




}
