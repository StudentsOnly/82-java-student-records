public class Student {
    private String name;
    private int age;
    private String enrollmentStatus;
    private String course;
    private float gpa;

    public Student(String name, int age, String enrollmentStatus, String course, float gpa) {
        this.name = name;
        this.age = age;
        this.enrollmentStatus = enrollmentStatus;
        this.course = course;
        this.gpa = gpa;
    }

    public Student(String name, int age, String enrollmentStatus, String course) {
        this.name = name;
        this.age = age;
        this.enrollmentStatus = enrollmentStatus;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student: " + name + ", age: " + age + ", course: " + course + ", status: " + enrollmentStatus + ", GPA: " + gpa;
    }
}
