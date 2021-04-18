package com.app.controllers;

import com.app.model.SchoolSubject;
import com.app.model.Student;
import com.app.view.View;

public class Controller {
  public void run() {
    View view = new View();

    Student student = new Student("Mathias");
    student.addExam(SchoolSubject.MATH, new double[] {0.25, 0.75}, new int[] {7, 7});
    student.addExam(SchoolSubject.PHYSICS, new double[] {0.25, 0.75}, new int[] {10, 12});
    student.addExam(SchoolSubject.GEOGRAPHY, 7);

    view.displayStudent(student.getName(), student.result());
    view.displayAverage(student.getAverage());
    view.newLine();

    Student student2 = new Student("Andreas");
    student2.addExam(SchoolSubject.HISTORY, new double[] {0.25, 0.75}, new int[] {10, 10});
    student2.addExam(SchoolSubject.PHYSICS, new double[] {0.25, 0.75}, new int[] {10, 12});
    student2.addExam(SchoolSubject.SCIENCE, 12);

    view.displayStudent(student2.getName(), student2.result());
    view.displayAverage(student2.getAverage());
  }
}
