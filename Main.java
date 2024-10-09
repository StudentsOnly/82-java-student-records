import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    List<Student> students = IntStream.rangeClosed(0, 100)
      .mapToObj(i -> Student.getRandom())
      .toList();

    System.out.printf("STUDENTS[%d]", students.size());
    System.out.println("--------------------------------------");
    students.stream()
      .limit(10)
      .forEach(System.out::println);
    System.out.println();


    System.out.println("--------------------------------------");
  }
}
