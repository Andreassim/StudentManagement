package com.app.model;

public class Grade {
  private int grade;

  Grade(int grade) {
    setGrade(grade);
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public int getGrade() {
    return grade;
  }

}
