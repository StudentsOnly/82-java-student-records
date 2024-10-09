import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    List<Student> students = IntStream.rangeClosed(0, 100)
      .mapToObj(i -> Student.getRandom())
      .toList();

    printTen("Students", students);

    var filtered = filterStudents(students, s -> s.getStatus() == Student.Status.ACTIVE);
    printTen("Filtered Students", filtered);
  }

  private static List<Student> filterStudents(List<Student> students,
                                              Predicate<Student> predicate) {
    return students.stream()
      .filter(predicate)
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
