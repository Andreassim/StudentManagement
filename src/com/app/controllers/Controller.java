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
    student.addExam(SchoolSubject.ART, 0);
    student.addExam(SchoolSubject.RELIGION, 12);
    student.addExam(SchoolSubject.MUSIC, -3);

    view.displayStudent(student.getName(), student.result());
    view.displayAverage(student.calculateAverage());
    view.newLine();

    Student student2 = new Student("Andreas");
    student2.addExam(SchoolSubject.HISTORY, new double[] {0.25, 0.75}, new int[] {10, 10});
    student2.addExam(SchoolSubject.PHYSICS, new double[] {0.25, 0.75}, new int[] {10, 12});
    student2.addExam(SchoolSubject.SCIENCE, 12);
    student2.addExam(SchoolSubject.CITIZENSHIP, 2);
    student2.addExam(SchoolSubject.MUSIC, 10);
    student2.addExam(SchoolSubject.MATH, new double[] {0.5, 0.5}, new int[] {7, 12});

    view.displayStudent(student2.getName(), student2.result());
    view.displayAverage(student2.calculateAverage());
  }
}
