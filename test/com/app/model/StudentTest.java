package com.app.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest {

  Student testStudent;

  @BeforeEach
  void setup() {
    testStudent = new Student("Test");
  }

  @Test
  void testAddStudent1() {
    Assertions.assertEquals("Test", testStudent.getName());
  }

  @Test
  void testAddStudent2() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> testStudent = new Student(""));
  }

  @Test
  void testAddStudent3() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> testStudent = new Student("123"));
  }

  @Test
  void testAddStudent4() {
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> testStudent = new Student("Test!"));
  }

  @Test
  void testCalculateAverage() {
    testStudent.addExam(SchoolSubject.HISTORY, new double[] {0.25, 0.75}, new int[] {10, 10});
    testStudent.addExam(SchoolSubject.SCIENCE, 4);

    Assertions.assertEquals(7.0, testStudent.getAverage());
  }
}
