package com.app;

import com.app.model.Examination;
import com.app.model.Student;

public class Main {
  public static void main(String[] args) {
    //new App().run();
    Examination examination = new Examination("Matematik",new double[]{0.25,0.75});
    Student student = new Student("Mathias");

    student.addExams(examination);
    examination.setGrade(0,7);
    examination.setGrade(1,12);

//    examination.setGrade(1,12);
    student.save();


  }
}
