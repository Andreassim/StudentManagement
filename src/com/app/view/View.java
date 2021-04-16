package com.app.view;

import com.app.model.SchoolSubject;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Scanner;

public class View {
  Scanner input = new Scanner(System.in);

  public void showMenu() {
    String[] options = new String[] {"Create Student", "Grade Student", "Show Student Grades"};
    System.out.println("Student Menu");
    for (int i = 0; i < options.length; i++) {
      System.out.println((i + 1) + "\t" + options[i]);
    }
    System.out.println("9\tExit");
  }

  public int getMenuInput(int[] options) {
    boolean valid = false;
    int result = 0;
    while (!valid) {
      System.out.print("Input:");
      if (input.hasNextInt()) {
        result = input.nextInt();
        input.nextLine();
        valid = validOption(options, result);
      }
    }
    return result;
  }

  public String getStringInput(String message) {
    String result = "";
    System.out.print(message + ":");
    if (input.hasNext()) {
      result = input.nextLine();
    }
    return result;
  }

  public int getIntInput(String message) {
    int result = 0;
    boolean valid = false;
    while (!valid) {
      System.out.print(message + ":");
      if (input.hasNextInt()) {
        result = input.nextInt();
        input.nextLine();
        return result;
      }
      input.nextLine();
    }
    return result;
  }

  public SchoolSubject getSchoolSubject(String message) {
    String subjectName = getStringInput(message);
    switch (subjectName) {
      case "math":
        return SchoolSubject.MATH;
      case "history":
        return SchoolSubject.HISTORY;

      default:
        return SchoolSubject.ART;
    }
  }

  public void displayMessage(String message) {
    System.out.println(message);
  }

  public void displayStudent(String heading, HashMap<SchoolSubject, Integer> result) {
    System.out.println(getHeading(heading));

    for (SchoolSubject key : result.keySet()) {
      System.out.printf("Subject: %s | Grade: %02d%n", getSubject(key), result.get(key));
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

  private boolean validOption(int[] options, int choice) {
    for (int i = 0; i < options.length; i++) {
      if (choice == options[i]) {
        return true;
      }
    }
    return false;
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
