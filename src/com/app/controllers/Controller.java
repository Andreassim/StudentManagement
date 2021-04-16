package com.app.controllers;

import com.app.model.SchoolSubject;
import com.app.model.Student;
import com.app.view.View;

import java.util.ArrayList;

public class Controller {
  View view = new View();
  ArrayList<Student> students = new ArrayList<>();
  int[] options = new int[] {1, 2, 3, 9};

  public void run() {

    Boolean running = true;

    while (running) {
      view.showMenu();
      int choice = view.getMenuInput(options);

      switch (choice) {
        case 1:
          createStudent();
          break;
        case 2:
          gradeStudent();
          break;
        case 3:
          printStudent();
          break;
        case 9:
          running = false;
          break;
      }
    }

    Student student = new Student("Mathias");
    student.addExam(SchoolSubject.MATH, new double[] {0.25, 0.75}, new int[] {7, 7});
    student.addExam(SchoolSubject.PHYSICS, new double[] {0.25, 0.75}, new int[] {10, 12});
    student.addExam(SchoolSubject.GEOGRAPHY, 7);

    view.displayStudent(student.getName(), student.result());
    view.displayAverage(student.calculateAverage());
    view.newLine();
  }

  private void createStudent() {
    String name = view.getStringInput("Type the name of the Student");
    try {
      students.add(new Student(name));
    } catch (IllegalArgumentException e) {
      view.displayMessage(e.getMessage());
    }
  }

  private void gradeStudent() {
    int choice = view.getIntInput("Type the index of the student you want add an exam grade to");
    Student currentStudent = students.get(choice);

    SchoolSubject subject = view.getSchoolSubject("Write the name of the subject");
    int grade = view.getIntInput("Type the grade for the exam");

    // option for one or more grades;
    try {
      currentStudent.addExam(subject, grade);
    } catch (IllegalArgumentException e) {
      view.displayMessage(e.getMessage());
    }
  }

  private void printStudent() {
    int choice = view.getIntInput("Type the index of the student you want to print");
    Student currentStudent = students.get(choice);
    view.displayStudent(currentStudent.getName(), currentStudent.result());
    view.displayAverage(currentStudent.calculateAverage());
  }
}
