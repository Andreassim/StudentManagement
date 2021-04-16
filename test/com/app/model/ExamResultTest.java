package com.app.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExamResultTest {

  @Test
  void gradeNull(){
  Exam test = new Exam(SchoolSubject.ART);

    Assertions.assertThrows(NullPointerException.class,() -> test.getGrade());
  }

}
