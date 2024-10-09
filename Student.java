class Student {
    private String name;
    private double gpa;
    private boolean graduated;

    public Student(String name, double gpa, boolean graduated) {
        this.name = name;
        this.gpa = gpa;
        this.graduated = graduated;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public boolean hasGraduated() {
        return graduated;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return name + ", GPA: " + gpa + ", Graduated: " + graduated;
    }
}
