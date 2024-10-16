package Collections;

import java.util.Objects;

public class Human implements Comparable<Human>{
    private String lastName, middleName, firstName;
    private int age;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.equals("")){
            throw new IllegalArgumentException("Last name doesn't exist");
        }
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if (middleName == null || middleName.equals("")){
            throw new IllegalArgumentException("Middle name doesn't exist");
        }
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.equals("")){
            throw new IllegalArgumentException("First name doesn't exist");
        }
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException("Age cannot be less then 0");
        }
        this.age = age;
    }

    public Human (String firstName, String middleName, String lastName, int age){
        this.setAge(age);
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getAge() == human.getAge()
                && getLastName().equals(human.getLastName())
                && getMiddleName().equals(human.getMiddleName())
                && getFirstName().equals(human.getFirstName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLastName(), getMiddleName(), getFirstName(), getAge());
    }

    @Override
    public int compareTo(Human o) {
        int answer = this.getMiddleName().compareTo(o.getMiddleName());

        if (answer == 0){
            answer = this.getFirstName().compareTo(o.getFirstName());

        }
        if (answer == 0){
            answer = this.getLastName().compareTo(o.getLastName());

        }
        if (answer == 0){
            if (this.getAge() < o.getAge()){
                answer = -1;
            }
            if (this.getAge() > o.getAge()){
                answer = 1;
            }
        }

        return answer;
    }

  @Override
    public String toString() {
        return "Human{" +
                " " + middleName +
                " " + firstName +
                " " + lastName +
                ", " + age +
                '}';
    }
}
