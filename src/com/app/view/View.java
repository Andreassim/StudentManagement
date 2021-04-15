package com.app.view;

import com.app.model.SchoolSubject;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.HashMap;

public class View {
  public void displayStudent(String heading, HashMap<SchoolSubject, Integer> result) {
    System.out.println(getHeading(heading));

    for (SchoolSubject key : result.keySet()) {
      System.out.printf("Subject: %s | Grade: %d%n", getSubject(key), result.get(key));
    }
  }

  private String getHeading(String heading) {
    return (MessageFormat.format("==== {0} ====", heading));
  }

  public void displayAverage(double result) {
    DecimalFormat format = new DecimalFormat("##.00");
    System.out.printf("Average: %s%n", format.format(result));
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
