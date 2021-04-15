package com.app.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExaminationTest {

  @Test
  void getGrade12Test(){
    Examination test = new Examination("Math");
    test.setGrade(0, 12);

    int expected = 12;

    assertEquals(expected, test.getGrade());

  }


  @Test
  void getGradeWeighted(){
    Examination test = new Examination("Math", new double[] {0.25,0.75});
    test.setGrade(0, 2);
    test.setGrade(1, 7);

    int expected = 4;

    assertEquals(expected, test.getGrade());
  }

}