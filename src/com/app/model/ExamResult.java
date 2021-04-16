package com.app.model;

class ExamResult {
  private Grade grade;

  int getGrade() {
    if (null == grade) {
      throw new NullPointerException("Grade is not set");
    }

    return grade.getGrade();
  }

  void setGrade(int grade) {
    this.grade = new Grade(grade);
  }
}
