package Collections;

import java.util.Comparator;

public class Student extends Human implements Comparable<Human> {
    private String facultyName;

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        if (facultyName == null || facultyName.equals("")){
            throw new IllegalArgumentException("Вас отчислили");
        }
        this.facultyName = facultyName;
    }

    public Student(String firstName, String middleName, String lastName, int age, String facultyName) {
        super(firstName, middleName, lastName, age);
        this.setFacultyName(facultyName);
    }
}
