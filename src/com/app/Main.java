package com.app;

import com.app.model.Examination;
import com.app.model.Student;

public class Main {
  public static void main(String[] args) {
    //new App().run();
    Examination examination = new Examination("Matematik");
    Student student = new Student("Mathias");

    student.addExams(examination);
    student.save();


  }
}
