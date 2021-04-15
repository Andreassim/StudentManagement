package com.app.model;

public class ExamResult {
  private Grade grade;

  public int getGrade() {
    if (null == grade) {
      throw new NullPointerException("Grade is not set");
    }

    return grade.getGrade();
  }

  public void setGrade(int grade) {
    this.grade = new Grade(grade);
  }
}
