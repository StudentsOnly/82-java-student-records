import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {

    List<Student> students = IntStream.rangeClosed(0, 100)
      .mapToObj(i -> Student.getRandom())
      .toList();
    System.out.println();
    printTen("Students", students);

    var filtered = filterStudents(students, s -> s.getStatus() == Student.Status.ACTIVE);
    printTen("Filtered Students", filtered);

    var transformed = transformStudentNames(students, Main::addGraduated);
    printTen("Transformed Students", transformed);

    var gpaIncreased = modifyStudentGPAs(students, s -> increasedGpa(s, 0.5));
    printTen("GPA Increased Students", gpaIncreased);
  }

  private static List<Student> filterStudents(List<Student> students,
                                              Predicate<Student> predicate) {
    return students.stream()
      .filter(predicate)
      .toList();
  }

  private static Student addGraduated(Student student) {

    return Student.newStudent(
      student.getName() +
        (student.getStatus() == Student.Status.GRADUATED ? " (Graduated)" : ""),
      student.getGpa(),
      student.getStatus());
  }

  private static List<Student> transformStudentNames(List<Student> students,
                                              UnaryOperator<Student> unaryOperator) {
    return students.stream()
      .map(unaryOperator)
      .toList();
  }

  private static Student increasedGpa(Student student, double increase) {
    return Student.newStudent(student.getName(), student.getGpa() + increase,
      student.getStatus());
  }

  private static <T extends Student> List<T> modifyStudentGPAs(List<T> students,
                                                 UnaryOperator<T> unaryOperator) {
    return students.stream()
      .map(unaryOperator)
      .toList();
  }

  private static void printTen(String header, List<?> list) {
    System.out.printf("%s[%d]%n", header.toUpperCase(), list.size());
    System.out.println("--------------------------------------");
    list.stream()
      .limit(10)
      .forEach(System.out::println);
    System.out.println();
  }
}
