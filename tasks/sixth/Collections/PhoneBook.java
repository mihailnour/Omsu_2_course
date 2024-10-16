package Collections;

import java.util.*;

public class PhoneBook {
    private Map<Human, List<String>> phoneBook;

    public Map<Human, List<String>> getPhoneBook() {
        return phoneBook;
    }
    public PhoneBook (Map<Human, List<String>> phoneBook){
        if (phoneBook.isEmpty()){
            throw new IllegalArgumentException("Empty sample");
        }
        this.phoneBook = new HashMap<>(phoneBook);
    }

    public void addPhone (Human human, String phone){
        if (human == null || !this.getPhoneBook().containsKey(human)){
            throw new IllegalArgumentException("Gimme normal human pls");
        }
        if(phone == null ||phone.isBlank()){
            throw new IllegalArgumentException("Gimme normal phone pls");
        }
        this.phoneBook.get(human).add(phone);
    }
    public void deletePhone(Human human, String phone){
        if (human == null || !this.getPhoneBook().containsKey(human)){
            throw new IllegalArgumentException("Gimme normal human pls");
        }
        if(phone.equals("") ){
            throw new IllegalArgumentException("Gimme normal phone pls");
        }
        boolean flag = this.phoneBook.get(human).remove(phone);
    }
    public List<String> getNumbersOfThisPerson(Human person){
        if (person == null  || !this.getPhoneBook().containsKey(person)){
            throw new IllegalArgumentException("Gimme normal person pls");
        }

        return this.phoneBook.get(person);
    }
    public Human findByPhoneNumber(String phone){
        if(phone.equals("")){
            throw new IllegalArgumentException("Gimme normal phone pls");
        }
        for (Map.Entry<Human, List<String>> entry: this.phoneBook.entrySet()){
            if (entry.getValue().contains(phone)){
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("There are no person with this number");
    }
    public Map<Human, List<String>> getStringsStartsWithThisChar(char ch){
        if (ch == ' '){
            throw new IllegalArgumentException("Wrong character");
        }
        Map<Human, List<String >> result = new HashMap<>();
        for (Human human : this.getPhoneBook().keySet()){
            if (human.getMiddleName().charAt(0) == ch){
                result.put(human, this.phoneBook.get(human));
            }
        }
        return result;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneBook)) return false;
        PhoneBook phoneBook1 = (PhoneBook) o;
        return Objects.equals(getPhoneBook(), phoneBook1.getPhoneBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhoneBook());
    }

    @Override
    public String toString() {
        return "PhoneBook=[" +
                  phoneBook +
                ']';
    }
}
