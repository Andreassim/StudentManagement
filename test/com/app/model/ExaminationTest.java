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

}