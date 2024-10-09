import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(List.of(
                new Student("Alice", 22, "Enrolled", "CS-101", 3.8f),
                new Student("John", 27, "Graduated", "EE-201", 3.5f),
                new Student("Emma", 24, "Enrolled", "ME-305", 3.2f),
                new Student("Michael", 26, "Graduated", "CE-402", 3.9f),
                new Student("Sophia", 23, "Enrolled", "IT-202", 3.6f),
                new Student("David", 28, "Graduated", "CS-303", 3.4f),
                new Student("Olivia", 21, "Enrolled", "BIO-150", 3.7f),
                new Student("James", 25, "Graduated", "PHY-201", 3.3f),
                new Student("Isabella", 22, "Enrolled", "CHE-102", 3.5f),
                new Student("Ethan", 26, "Graduated", "LAW-301", 3.8f)
        ));

        System.out.println("\n===Original list===");
        students.forEach(System.out::println);

        System.out.println("\n===Enrolled students older than 23===");
        Predicate<Student> isEnrolled = s -> s.getEnrollmentStatus().equals("Enrolled");
        Predicate<Student> olderThan23 = s -> s.getAge() > 23;
        Predicate<Student> enrolledAndOlderThan23 = isEnrolled.and(olderThan23);
        filterStudents(students, enrolledAndOlderThan23).forEach(System.out::println);

        System.out.println("\n===Graduated students===");
        Predicate<Student> isGraduated = s -> s.getEnrollmentStatus().equals("Graduated");
        Function<Student, String> addGraduatedToName = student -> student.getName() + "-graduated";
        transformStudentNames(students, isGraduated, addGraduatedToName);
        students.forEach(System.out::println);

        System.out.println("\n===Modified GPA===");
        modifyGPA(students, gpa -> gpa + 0.5f);
        students.forEach(System.out::println);
    }


    private static ArrayList<Student> filterStudents(ArrayList<Student> students, Predicate<Student> p) {
        ArrayList<Student> output = new ArrayList<>();
        students.forEach(student -> {
            if (p.test(student)) output.add(student);
        });
        return output;
    }

    private static void transformStudentNames(ArrayList<Student> students, Predicate<Student> p, Function<Student, String> f) {
        filterStudents(students, p).forEach(s -> s.setName(f.apply(s)));
    }

    private static void modifyGPA(ArrayList<Student> students, UnaryOperator<Float> uop) {
        students.forEach(s -> s.setGpa(uop.apply(s.getGpa())));
    }
}

