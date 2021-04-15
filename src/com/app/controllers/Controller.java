package com.app.controllers;

import com.app.model.Student;

public class Controller {
  public void run() {

    Student student = new Student("Mathias");
    student.addExam("Matematik", new double[] {0.25, 0.75}, new int[] {7, 7});
    student.addExam("Fysik", new double[] {0.25, 0.75}, new int[] {10, 12});
    student.addExam("Dansk",6); // TODO
    student.save();

    System.out.println();

    Student student1 = new Student("Andreas");
    student1.addExam("Dansk", new double[] {0.5, 0.5}, new int[] {12, 12});
    student1.save();
  }
}
