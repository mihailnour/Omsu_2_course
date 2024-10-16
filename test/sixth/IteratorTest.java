import Iterator.Data;
import Iterator.Group;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    @Test
    public void ConstructorTest(){
        Group group = new Group(100, 1, 2, 3);
    }
    @Test (expected = IllegalArgumentException.class)
    public void ConstructorExceptionTest(){
        Group group = new Group(-10, 1, 2, 3);
    }
    @Test
    public void DataConstructorTest(){
        Data data = new Data("Test data",
                new Group(100, 1, 2, 3),
                null,
                new Group(10, 1, 2, 3),
                new Group(15, 1, 2, 3));
    }
    @Test (expected = IllegalArgumentException.class)
    public void DataConstructorExceptionTest(){
        Data data = new Data("Test data",
                new Group(100, 1, 2, 3),
                new Group(50, 1, 2, 3),
                new Group(-10, 1, 2, 3),
                new Group(15, 1, 2, 3));
    }

    @Test
    public void mainTest1(){
        Data data = new Data("Test data",
                new Group(100, 1, 2, 3),
                new Group(50, 4, 5, 6),
                new Group(10, 7, 8, 9),
                new Group(15, 10, 20, 30));
        Iterator<Integer> it = data.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test
    public void mainTest2(){
        Data data = new Data("Test data",
                new Group(100, 1, 2, 3),
                new Group(50, 4, 5, 6),
                null,
                new Group(10, 7, 8, 9),
                new Group(15, 10, 20, 30));
        Iterator<Integer> it = data.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test
    public void mainTest3(){
        Data data = new Data("Test data",
                new Group(100, 1, 2, 3),
                new Group(50, 4, 5, 6),
                new Group(10, 7, 8, 9),
                new Group(15, 10, 20, 30),
                null,
                null,
                null,
                null);
        Iterator<Integer> it = data.iterator();

        while (it.hasNext()){
            System.out.print(it.next()+ " ");
        }
        System.out.println();
    }
    @Test
    public void mainTest4(){
        Data data = new Data("Test data",
                new Group(100, 1, 2, 3),
                new Group(50, 4, 5, 6),
                null,
                null,
                new Group(10, 7, 8, 9),
                null,
                new Group(15, 10, 20, 30),
                null,
                null,
                null,
                null);
        Iterator<Integer> it = data.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test (expected = NullPointerException.class)
    public void mainTest5(){
        Data data = new Data("Test data",
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        for (Integer datum : data) {
            System.out.println(datum);
        }
    }

}
