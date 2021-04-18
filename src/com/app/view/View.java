package com.app.view;

import com.app.model.SchoolSubject;

import java.util.HashMap;

public class View {
  public void displayStudent(String heading, HashMap<SchoolSubject, Integer> result) {
    System.out.println(formatHeading(heading));

    for (SchoolSubject key : result.keySet()) {
      System.out.printf("Subject: %s | Grade: %s%n", key.name(), formatGrade(result.get(key)));
    }
  }

  private String formatGrade(int grade) {
    if (0 == grade || 2 == grade) {
      return String.format("%02d", grade);
    }
    return String.format("%d", grade);
  }

  private String formatHeading(String heading) {
    return (String.format("==== %s ====", heading));
  }

  public void displayAverage(double result) {
    System.out.printf("Average grade: %.2f%n", result);
  }

  public void newLine() {
    System.out.println();
  }

  private String getSubject(SchoolSubject subject) {
    switch (subject) {
      case ART:
        return "Art";
      case CITIZENSHIP:
        return "Citizenship";
      case GEOGRAPHY:
        return "Geography";
      case HISTORY:
        return "History";
      case MUSIC:
        return "Music";
      case PHYSICS:
        return "Physics";
      case SCIENCE:
        return "Science";
      case MATH:
        return "Math";
      case RELIGION:
        return "Religion";

      default:
        return "Unknown";
    }
  }
}
