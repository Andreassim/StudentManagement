package com.app.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Student {
  final String FILENAME = "data.txt";
  String name;

  ArrayList<Exam> exams = new ArrayList<>();
  private double average;

  public Student(String name) {
    setName(name);
  }

  public void addExams(Exam exam) {
    exams.add(exam);
  }

  public void save() {
    String line = name + exams.get(0).getGrade();
    System.out.println(line);
  }

  // Assume the file exists
  void saveFile(String Line) throws FileNotFoundException, IOException{
      FileOutputStream fileStream = new FileOutputStream(FILENAME, true);
      PrintStream fileOut = new PrintStream(fileStream);
      fileOut.append(Line).append(System.lineSeparator());
      fileStream.close();
  }

  public void setName(String name) {
    boolean valid = name.matches("(?i)[a-z]([- ',.a-z]{0,23}[a-z])?");
    if (!valid) {
      throw new IllegalArgumentException("Illegal name");
    }
    this.name = name;
  }

  public void calculateAverage() {
    double result = 0;
    for (int i = 0; i < exams.size(); i++) {
      result += i;
    }

    average = result / exams.size();
  }

  public double getAverage() {
    return average;
  }
}
