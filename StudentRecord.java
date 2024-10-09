import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class StudentRecord {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("John", 3.8, true),
                new Student("Peter", 2.9, false),
                new Student("Katrin", 3.5, true),
                new Student("David", 4.0, false),
                new Student("Eva", 3.2, false)
        );

        System.out.println("\nInitial list of students\n");
        students.forEach(System.out::println);

        List<Student> highGpaStudents = filterStudents(students, student -> student.getGpa() > 3.0);
        System.out.println("\nStudents with GPA greater than 3.0:\n");
        highGpaStudents.forEach(System.out::println);

        List<String> transformedNames = transformStudentNames(students, student ->
        student.hasGraduated() ? student.getName() + " (Graduated)" : student.getName());
        System.out.println("\nTransformed student names:\n");
        transformedNames.forEach(System.out::println);

        List<Student> modifiedGpaStudents = modifyStudentGPAs(students, student -> {
            student.setGpa(student.getGpa() + 0.5);
            return student;
        });
        System.out.println("\nStudents with modified GPAs:\n");
        modifiedGpaStudents.forEach(System.out::println);

    }

    private static List<Student> filterStudents(List<Student> students, Predicate<Student> criteria) {
        List<Student> filteredList = new ArrayList<>();
        students.forEach(student -> {
            if (criteria.test(student)) {
                filteredList.add(student);
            }
        });
        return filteredList;
    }

    private static List<String> transformStudentNames(List<Student> students, Function<Student, String> transformer) {
        List<String> transformedNames = new ArrayList<>();
        students.forEach(student -> transformedNames.add(transformer.apply(student)));
        return transformedNames;
    }

    private static List<Student> modifyStudentGPAs(List<Student> students, UnaryOperator<Student> gpaModifier) {
        List<Student> modifiedList = new ArrayList<>();
        students.forEach(student -> modifiedList.add(gpaModifier.apply(student)));
        return modifiedList;
    }
}
