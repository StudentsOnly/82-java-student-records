import java.util.Random;

public class Student {
  private String name;
  private double gpa;
  private Status status;

  enum Status {
    ACTIVE, INACTIVE, NON_DEGREE;
  }

  private Student(String name, double gpa, Status status) {
    this.name = name;
    this.gpa = gpa;
    this.status = status;
  }

  public static Student getRandom() {
    Random r = new Random();
    String[] names = {"Alph", "Betty", "Carmen", "Daniel", "Emanuel", "Fred", "Gustav"};
    String fullName = names[r.nextInt(0, names.length)] + " " +
      (char) r.nextInt('A', 'Z') + ".";
    double gpa = r.nextDouble(1.0, 4.01);
    Status[] statusAr = Status.values();
    Status status = statusAr[r.nextInt(0, statusAr.length)];

    return new Student(fullName, gpa, status);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getGpa() {
    return gpa;
  }

  public void setGpa(double gpa) {
    this.gpa = gpa;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "%s(%.2f, %s)".formatted(name, gpa, status);
  }
}
