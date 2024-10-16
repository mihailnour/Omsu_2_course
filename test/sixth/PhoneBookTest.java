import Collections.Human;
import Collections.PhoneBook;
import org.junit.Test;

import java.util.*;
import static org.junit.Assert.assertEquals;

public class PhoneBookTest {
    @Test
    public void constructorTest(){
        Human human1 = new Human("Александр", "Александров", "Александрович", 18);
        Human human2 = new Human("Алексей", "Александров", "Александрович", 10);

        String phone1 = "8 888 888 88 88";
        String phone2 = "8 888 788 88 88";
        String phone3 = "8 888 888 78 88";
        String phone4 = "7 888 888 88 88";

        List<String> phones1 = new ArrayList<>();
        phones1.add(phone1);
        phones1.add(phone2);

        List<String> phones2 = new ArrayList<>();
        phones2.add(phone3);
        phones2.add(phone4);


        Map<Human, List<String>> book = new HashMap<>();
        book.put(human1, phones1);
        book.put(human2, phones2);

        PhoneBook phoneBook = new PhoneBook(book);
    }
    @Test ()
    public void addNumberTest(){
        Human human1 = new Human("А", "Б", "В", 18);
        Human human2 = new Human("A", "B", "C", 10);

        String phone1 = "111";
        String phone2 = "222";
        String phone3 = "333";
        String phone4 = "444";

        List<String> phones1 = new ArrayList<>();
        phones1.add(phone1);
        phones1.add(phone2);

        List<String> phones2 = new ArrayList<>();
        phones2.add(phone3);
        phones2.add(phone4);

        List<String> phones3 = new ArrayList<>();
        phones3.add(phone1);
        phones3.add(phone2);
        phones3.add(phone3);

        Map<Human, List<String>> book = new HashMap<>();
        book.put(human1, phones1);
        book.put(human2, phones2);

        Map<Human, List<String>> book1 = new HashMap<>();
        book1.put(human1, phones3);
        book1.put(human2, phones2);


        PhoneBook phoneBook = new PhoneBook(book);

        PhoneBook excepted = new PhoneBook(book1);



        System.out.println("До: "+ "\n" + excepted + "\n" + phoneBook );

        phoneBook.addPhone(human1,phone3);

        System.out.println("После: "+ "\n" + excepted + "\n" + phoneBook);

        assertEquals(excepted, phoneBook);
    }
    @Test (expected = IllegalArgumentException.class)
    public void addNumberExceptionTest(){
        Human human1 = new Human("А", "Б", "В", 18);
        Human human2 = new Human("A", "B", "C", 10);
        Human human3 = new Human("Y", "Y", "Y", 10);

        String phone1 = "111";
        String phone2 = "222";
        String phone3 = "333";
        String phone4 = "444";

        List<String> phones1 = new ArrayList<>();
        phones1.add(phone1);
        phones1.add(phone2);

        List<String> phones2 = new ArrayList<>();
        phones2.add(phone3);
        phones2.add(phone4);

        List<String> phones3 = new ArrayList<>();
        phones3.add(phone1);
        phones3.add(phone2);
        phones3.add(phone3);

        Map<Human, List<String>> book = new HashMap<>();
        book.put(human1, phones1);
        book.put(human2, phones2);


        Map<Human, List<String>> book1 = new HashMap<>();
        book1.put(human1, phones3);

        PhoneBook phoneBook = new PhoneBook(book);

        PhoneBook excepted = new PhoneBook(book);

        System.out.println("До: "+ "\n" + excepted + "\n" + phoneBook );

        phoneBook.addPhone(human3,phone3);

        System.out.println("После: "+ "\n" + excepted + "\n" + phoneBook);
        assertEquals(excepted, phoneBook);
    }
    @Test
    public void deleteTest(){
        Human human1 = new Human("А", "Б", "В", 18);
        Human human2 = new Human("A", "B", "C", 10);
        Human human3 = new Human("Y", "Y", "Y", 10);

        String phone1 = "111";
        String phone2 = "222";
        String phone3 = "333";
        String phone4 = "444";

        List<String> phones1 = new ArrayList<>();
        phones1.add(phone1);
        phones1.add(phone2);

        List<String> phones2 = new ArrayList<>();
        phones2.add(phone3);
        phones2.add(phone4);

        List<String> phones3 = new ArrayList<>();
        phones3.add(phone1);

        Map<Human, List<String>> book = new HashMap<>();
        book.put(human1, phones1);
        book.put(human2, phones2);

        Map<Human, List<String>> book1 = new HashMap<>();
        book1.put(human1, phones3);
        book1.put(human2, phones2);
        PhoneBook phoneBook = new PhoneBook(book);

        PhoneBook excepted = new PhoneBook(book1);

        System.out.println("До: "+ "\n" + excepted + "\n" + phoneBook );

        phoneBook.deletePhone(human1,phone2);

        System.out.println("После: "+ "\n" + excepted + "\n" + phoneBook);
        assertEquals(excepted, phoneBook);
    }
    @Test (expected = IllegalArgumentException.class)
    public void deleteExceptionTest(){
        Human human1 = new Human("А", "Б", "В", 18);
        Human human2 = new Human("A", "B", "C", 10);
        Human human3 = new Human("Y", "Y", "Y", 10);

        String phone1 = "111";
        String phone2 = "222";
        String phone3 = "333";
        String phone4 = "444";

        List<String> phones1 = new ArrayList<>();
        phones1.add(phone1);
        phones1.add(phone2);

        List<String> phones2 = new ArrayList<>();
        phones2.add(phone3);
        phones2.add(phone4);

        List<String> phones3 = new ArrayList<>();
        phones3.add(phone1);
        phones3.add(phone2);


        Map<Human, List<String>> book = new HashMap<>();
        book.put(human1, phones1);
        book.put(human2, phones2);



        Map<Human, List<String>> book1 = new HashMap<>();
        book1.put(human1, phones3);

        PhoneBook phoneBook = new PhoneBook(book);

        PhoneBook excepted = new PhoneBook(book1);



        System.out.println("До: "+ "\n" + excepted + "\n" + phoneBook );

        phoneBook.deletePhone(human3,phone2);

        System.out.println("После: "+ "\n" + excepted + "\n" + phoneBook);
        assertEquals(excepted, phoneBook);
    }
    @Test
    public void getNumbersTest(){
        Human human1 = new Human("А", "Б", "В", 18);
        Human human2 = new Human("A", "B", "C", 10);
        Human human3 = new Human("Y", "Y", "Y", 10);

        String phone1 = "111";
        String phone2 = "222";
        String phone3 = "333";
        String phone4 = "444";

        List<String> phones1 = new ArrayList<>();
        phones1.add(phone1);
        phones1.add(phone2);

        List<String> phones2 = new ArrayList<>();
        phones2.add(phone3);
        phones2.add(phone4);

        Map<Human, List<String>> book = new HashMap<>();
        book.put(human1, phones1);
        book.put(human2, phones2);

        PhoneBook phoneBook = new PhoneBook(book);



        List<String> excepted = new ArrayList<>();
        excepted.add(phone1);
        excepted.add(phone2);



        assertEquals(excepted, phoneBook.getNumbersOfThisPerson(human1));
    }
    @Test (expected = IllegalArgumentException.class)
    public void getNumbersExceptionTest(){
        Human human1 = new Human("А", "Б", "В", 18);
        Human human2 = new Human("A", "B", "C", 10);
        Human human3 = new Human("Y", "Y", "Y", 10);

        String phone1 = "111";
        String phone2 = "222";
        String phone3 = "333";
        String phone4 = "444";

        List<String> phones1 = new ArrayList<>();
        phones1.add(phone1);
        phones1.add(phone2);

        List<String> phones2 = new ArrayList<>();
        phones2.add(phone3);
        phones2.add(phone4);

        Map<Human, List<String>> book = new HashMap<>();
        book.put(human1, phones1);
        book.put(human2, phones2);

        PhoneBook phoneBook = new PhoneBook(book);

        List<String> excepted = new ArrayList<>();

        assertEquals(excepted, phoneBook.getNumbersOfThisPerson(human3));
    }
    @Test
    public void getByPhoneNUmberTest(){
        Human human1 = new Human("А", "Б", "В", 18);
        Human human2 = new Human("A", "B", "C", 10);
        Human human3 = new Human("Y", "Y", "Y", 10);

        String phone1 = "111";
        String phone2 = "222";
        String phone3 = "333";
        String phone4 = "444";

        List<String> phones1 = new ArrayList<>();
        phones1.add(phone1);
        phones1.add(phone2);

        List<String> phones2 = new ArrayList<>();
        phones2.add(phone3);
        phones2.add(phone4);

        Map<Human, List<String>> book = new HashMap<>();
        book.put(human1, phones1);
        book.put(human2, phones2);

        PhoneBook phoneBook = new PhoneBook(book);

        assertEquals(human1, phoneBook.findByPhoneNumber(phone1));
    }
    @Test (expected = IllegalArgumentException.class)
    public void getByPhoneNumberTestExceptionTest(){
        Human human1 = new Human("А", "Б", "В", 18);
        Human human2 = new Human("A", "B", "C", 10);
        Human human3 = new Human("Y", "Y", "Y", 10);

        String phone1 = "111";
        String phone2 = "222";
        String phone3 = "333";
        String phone4 = "444";
        String phone5 = "555";

        List<String> phones1 = new ArrayList<>();
        phones1.add(phone1);
        phones1.add(phone2);

        List<String> phones2 = new ArrayList<>();
        phones2.add(phone3);
        phones2.add(phone4);

        Map<Human, List<String>> book = new HashMap<>();
        book.put(human1, phones1);
        book.put(human2, phones2);

        PhoneBook phoneBook = new PhoneBook(book);

        assertEquals(human1, phoneBook.findByPhoneNumber(phone5));
    }
    @Test
    public void newMapTest(){

        Human human1 = new Human("А", "Б", "В", 18);
        Human human2 = new Human("A", "B", "C", 10);
        Human human3 = new Human("Y", "Y", "Y", 10);

        String phone1 = "111";
        String phone2 = "222";
        String phone3 = "333";
        String phone4 = "444";

        List<String> phones1 = new ArrayList<>();
        phones1.add(phone1);
        phones1.add(phone2);

        List<String> phones2 = new ArrayList<>();
        phones2.add(phone3);
        phones2.add(phone4);

        List<String> phones3 = new ArrayList<>();
        phones3.add(phone1);

        Map<Human, List<String>> book = new HashMap<>();
        book.put(human1, phones1);
        book.put(human2, phones2);

        Map<Human, List<String>> excepted = new HashMap<>();

        excepted.put(human2, phones2);

        PhoneBook phoneBook = new PhoneBook(book);

        assertEquals(excepted, phoneBook.getStringsStartsWithThisChar('B'));

    }
    @Test
    public void newMapTest2(){

        Human human1 = new Human("А", "Б", "В", 18);
        Human human2 = new Human("A", "B", "C", 10);
        Human human3 = new Human("Y", "Y", "Y", 10);

        String phone1 = "111";
        String phone2 = "222";
        String phone3 = "333";
        String phone4 = "444";

        List<String> phones1 = new ArrayList<>();
        phones1.add(phone1);
        phones1.add(phone2);

        List<String> phones2 = new ArrayList<>();
        phones2.add(phone3);
        phones2.add(phone4);

        List<String> phones3 = new ArrayList<>();
        phones3.add(phone1);

        Map<Human, List<String>> book = new HashMap<>();
        book.put(human1, phones1);
        book.put(human2, phones2);

        Map<Human, List<String>> excepted = new HashMap<>();


        PhoneBook phoneBook = new PhoneBook(book);

        assertEquals(excepted, phoneBook.getStringsStartsWithThisChar('O'));

    }
}
