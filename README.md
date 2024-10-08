## Exercise: Student Records

### Objective:

The objective of this exercise is to practice using Java's Predicate, Function, and UnaryOperator interfaces to filter, transform, and modify student records efficiently within a student database. You will create methods to perform these operations using these interfaces.

### Instructions:

### Filter Students
-	Create a method named filterStudents that takes a list of students and a Predicate<Student> as parameters.
-	Use the provided Predicate to filter students based on specific criteria (e.g., GPA, enrollment status, etc.).
-	Return a new list containing the filtered students.

### Transform Student Names
-	Create a method named transformStudentNames that takes a list of students and a Function<Student, String> as parameters.
-	Use the provided Function to transform student names by adding " (Graduated)" to the names of students who have graduated.
-	Return a new list with the transformed student names.

### Modify Student GPAs
-	Create a method named modifyStudentGPAs that takes a list of students and a UnaryOperator<Double> as parameters.
-	Use the provided UnaryOperator to increase the GPA of each student by a fixed amount (e.g., +0.5).
-	Return the modified list of students with updated GPAs.
