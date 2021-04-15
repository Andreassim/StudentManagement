package com.app.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExamTest {

  @Test
  void getGrade12Test(){
    Exam test = new Exam("Math");
    test.setGrade(0, 12);

    int expected = 12;

    assertEquals(expected, test.getGrade());

  }


  @Test
  void getGradeWeighted(){
    Exam test = new Exam("Math", new double[] {0.25,0.75});
    test.setGrade(0, 2);
    test.setGrade(1, 7);

    int expected = 4;

    assertEquals(expected, test.getGrade());
  }

}