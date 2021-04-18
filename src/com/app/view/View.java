package com.app.view;

import com.app.model.SchoolSubject;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.HashMap;

public class View {
  public void displayStudent(String heading, HashMap<SchoolSubject, Integer> result) {
    System.out.println(getHeading(heading));

    for (SchoolSubject key : result.keySet()) {
      System.out.printf("Subject: %s | Grade: %02d%n", key.name(), result.get(key));
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
}
