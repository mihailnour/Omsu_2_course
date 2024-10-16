import org.junit.BeforeClass;
import org.junit.Test;
import Collections.*;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CollectionsTest {

    @BeforeClass
    public static void setUp(){

    }
    @Test
    public void TestFirst(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("baa");
        list.add("bbbb");
        list.add("ccscd");
        list.add("asdvbd");
        list.add("sdfvc");
        list.add("aaaaaaaaaaaaaaaaaaa");
        assertEquals(3, CollectionsDemo.firstSymbolEquals(list, 'a'));
    }
    @Test
    public void TestFirst2(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("baa");
        list.add("bbbb");
        list.add(null);
        list.add("ccscd");
        list.add("asdvbd");
        list.add("sdfvc");
        list.add("aaaaaaaaaaaaaaaaaaa");
        assertEquals(0, CollectionsDemo.firstSymbolEquals(list, 'v'));
    }
    @Test
    public void TestFirst3(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("baa");
        list.add("bbbb");
        list.add("ccscd");
        list.add("asdvbd");
        list.add("sdfvc");
        list.add("aaaaaaaaaaaaaaaaaaa");
        assertEquals(0, CollectionsDemo.firstSymbolEquals(list, 'p'));
    }
    @Test
    public void TestSecond(){
        Human human1 = new Human("Алексaндр", "Александров", "Александрович", 20);
        Human human2 = new Human("Алексaндр", "JJ", "Александрович", 20);
        Human human3 = new Human("Сашка", "DAA", "Александрович", 20);
        Human human4 = new Human("Алексендр", "Александров", "Александрович", 20);
        List<Human> humanList = new ArrayList<>();
        humanList.add(0, human1);
        humanList.add(1, human2);
        humanList.add(2, human3);
        humanList.add(3, human4);
        List<Human> excepted = new ArrayList<>();
        excepted.add(human1);
        excepted.add(human4);

        assertEquals(excepted, CollectionsDemo.namesakes(humanList, human1));
    }
    @Test
    public void TestSecond2(){
        Human human1 = new Human("Алексaндр", "Александров", "Александрович", 20);
        Human human2 = new Human("Алексaндр", "JJ", "Александрович", 20);
        Human human3 = new Human("Сашка", "DAA", "Александрович", 20);
        Human human4 = new Human("Алексендр", "Александров", "Александрович", 20);
        List<Human> humanList = new ArrayList<>();
        humanList.add(0, human1);
        humanList.add(1, human2);
        humanList.add(2, human3);
        humanList.add(3, human4);
        List<Human> excepted = new ArrayList<>();


        assertEquals(excepted, CollectionsDemo.namesakes(humanList, new Human("ФФФ", "AKFS", "ASdlaldla", 50)));
    }
    @Test
    public void TestThird(){
        Human human1 = new Human("Алексaндр1", "Александров", "Александрович", 20);
        Human human2 = new Human("Алексендр", "Александров", "Александрович", 20);
        Human human3 = new Human("Алексaндр", "JJ", "Александрович", 20);
        Human human4 = new Human("Сашка", "DAA", "Александрович", 20);
        Human human5 = new Human("Алексендр", "Александров", "Александрович", 20);
        Human human6 = new Human("Алексендр", "Александров", "Александрович", 20);
        Human human7 = new Human("Алексендр", "Александров", "Александрович", 20);
        Human human8 = new Human("Алексендр", "Александров", "Александрович", 20);
        List<Human> humanList = new ArrayList<>();
        humanList.add( human1);
        humanList.add( human2);
        humanList.add( human3);
        humanList.add( human4);
        humanList.add( human5);
        humanList.add( human6);
        humanList.add( human7);
        humanList.add( human8);
        List<Human> excepted = new ArrayList<>();
        excepted.add(human1);
        excepted.add(human3);
        excepted.add(human4);

        assertEquals(excepted, CollectionsDemo.deleteThis(humanList, human8));
    }
    @Test
    public void TestThird2(){
        Human human1 = new Human("Алексaндр1", "Александров", "Александрович", 20);
        Human human2 = new Human("Алексендр", "Александров", "Александрович", 20);
        Human human3 = new Human("Алексaндр", "JJ", "Александрович", 20);
        Human human4 = new Human("Сашка", "DAA", "Александрович", 20);
        Human human5 = new Human("Алексендр", "Александров", "Александрович", 20);
        Human human6 = new Human("Алексендр", "Александров", "Александрович", 20);
        Human human7 = new Human("Алексендр", "Александров", "Александрович", 20);
        Human human8 = new Human("Алексендр", "Александров", "Александрович", 20);
        List<Human> humanList = new ArrayList<>();
        humanList.add( human1);
        humanList.add( human2);
        humanList.add( human3);
        humanList.add( human4);
        humanList.add( human5);
        humanList.add( human6);
        humanList.add( human7);
        humanList.add( human8);
        List<Human> excepted = new ArrayList<>();
        excepted.add(human1);
        excepted.add(human2);
        excepted.add(human3);
        excepted.add(human4);
        excepted.add(human5);
        excepted.add(human6);
        excepted.add(human7);
        excepted.add(human8);

        assertEquals(excepted, CollectionsDemo.deleteThis(humanList, new Human("ФФФ", "AKFS", "ASdlaldla", 50) ));
    }
    @Test
    public void TestFour() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        set2.add(6);
        set2.add(7);
        set2.add(8);
        set2.add(9);
        set2.add(10);

        set3.add(1);
        set3.add(0);
        set3.add(11);
        set3.add(20);
        set3.add(50);

        List<Set<Integer>> list = new ArrayList<>();
        list.add(set1);
        list.add(set2);

        List<Set<Integer>> excepted = new ArrayList<>();
        excepted.add(set2);
        System.out.println(list);
        List<Set<Integer>> result = CollectionsDemo.notIntersect(list, set3);
        System.out.println(list);
        System.out.println(result);
        assertEquals(excepted, result);


    }
    @Test
    public void TestFour2() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        set2.add(6);
        set2.add(7);
        set2.add(8);
        set2.add(9);
        set2.add(10);

        set3.add(500);
        set3.add(0);
        set3.add(11);
        set3.add(20);
        set3.add(50);

        List<Set<Integer>> list = new ArrayList<>();
        list.add(set1);
        list.add(set2);

        List<Set<Integer>> excepted = new ArrayList<>();
        excepted.add(set1);
        excepted.add(set2);

        assertEquals(excepted, CollectionsDemo.notIntersect(list, set3));
    }
    @Test
    public void TestFour3() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        set2.add(10);
        set2.add(20);
        set2.add(30);
        set2.add(40);
        set2.add(50);

        set3.add(1);
        set3.add(0);
        set3.add(6);
        set3.add(20);
        set3.add(50);

        List<Set<Integer>> list = new ArrayList<>();
        list.add(set1);
        list.add(set2);

        List<Set<Integer>> excepted = new ArrayList<>();


        assertEquals(excepted, CollectionsDemo.notIntersect(list, set3));
    }
    @Test
    public void TestFive(){
        Human human1 = new Human("Алексaндр", "Александров", "Александрович", 0);
        Human human2 = new Human("Алексaндр", "Александров", "Александрович", 10);
        Human human3 = new Human("Сашка", "Александров", "Александрович", 10);
        Human human4 = new Human("Алексендр", "Александров", "Александрович", 5);
        Student student = new Student("Алексендр", "Александров", "Александрович", 10, "FMIT");
        List<Human> humanList = new ArrayList<>();
        humanList.add(0, human1);
        humanList.add(1, human2);
        humanList.add(2, human3);
        humanList.add(3, human4);
        humanList.add(4,student);

        List<Human> expected = new ArrayList<>(humanList);

        expected.remove(3);
        expected.remove(0);
        assertEquals(expected, CollectionsDemo.maxAgeHumans(humanList));
    }
    @Test
    public void TestSix (){
        Human human1 = new Human("Александр", "Александров", "Александрович", 10);
        Human human2 = new Human("Алексей", "Александров", "Александрович", 10);
        Human human3 = new Human("Сашка", "Александров", "Александрович", 10);
        Human human4 = new Human("Филип", "Александров", "Александрович", 5);
        Student student = new Student("Александр", "Александров", "Александрович", 0, "FMIT");
        Set<Human> set = new HashSet<Human>();
        set.add(human1);
        set.add(human2);
        set.add(human3);
        set.add(human4);
        set.add(student);

        List<Human> expected = new ArrayList<>();
        expected.add(student);
        expected.add(human1);
        expected.add(human2);
        expected.add(human3);
        expected.add(human4);

        assertEquals( expected, CollectionsDemo.listByName(set));
    }
    @Test
    public void TestSeven(){
        Human human1 = new Human("Александр", "Александров", "Александрович", 10);
        Human human2 = new Human("Алексей", "Александров", "Александрович", 10);
        Human human3 = new Human("Сашка", "Александров", "Александрович", 10);
        Human human4 = new Human("Филип", "Александров", "Александрович", 5);
        Map<Integer, Human> map = new HashMap<Integer, Human>();
        map.put(0,human1);
        map.put(1,human2);
        map.put(2,human3);
        map.put(3,human4);


        Set<Integer> set = new HashSet<Integer>();
        set.add(0);
        set.add(3);

        Set<Human> expected = new HashSet<>();
        Collections.addAll(expected, human1, human4);

        assertEquals(expected, CollectionsDemo.byId(map,set));
    }
    @Test
    public void TestSeven2(){
        Human human1 = new Human("Александр", "Александров", "Александрович", 10);
        Human human2 = new Human("Алексей", "Александров", "Александрович", 10);
        Human human3 = new Human("Сашка", "Александров", "Александрович", 10);
        Human human4 = new Human("Филип", "Александров", "Александрович", 5);
        Map<Integer, Human> map = new HashMap<Integer, Human>();
        map.put(0,human1);
        map.put(1,human2);
        map.put(2,human3);
        map.put(3,human4);


        Set<Integer> set = new HashSet<Integer>();
        set.add(0);
        set.add(3);
        set.add(5);

        Set<Human> expected = new HashSet<>();
        Collections.addAll(expected, human1, human4);
        assertEquals(expected, CollectionsDemo.byId(map,set));
    }
    @Test
    public void TestSeven3(){
        Human human1 = new Human("Александр", "Александров", "Александрович", 10);
        Human human2 = new Human("Алексей", "Александров", "Александрович", 10);
        Human human3 = new Human("Сашка", "Александров", "Александрович", 10);
        Human human4 = new Human("Филип", "Александров", "Александрович", 5);
        Map<Integer, Human> map = new HashMap<Integer, Human>();
        map.put(0,human1);
        map.put(1,human2);
        map.put(2,human3);
        map.put(3,human4);


        Set<Human> excepted = new HashSet<>();


        Set<Integer> set = new HashSet<>();


        assertEquals(excepted, CollectionsDemo.byId(map,set));
    }
    @Test
    public void TestEight(){
        Human human1 = new Human("Александр", "Александров", "Александрович", 18);
        Human human2 = new Human("Алексей", "Александров", "Александрович", 10);
        Human human3 = new Human("Сашка", "Александров", "Александрович", 10);
        Human human4 = new Human("Филип", "Александров", "Александрович", 55);
        Map<Integer, Human> map = new HashMap<>();
        map.put(0,human1);
        map.put(1,human2);
        map.put(2,human3);
        map.put(3,human4);


        List<Integer> excepted = new ArrayList<>();
        excepted.add(0);
        excepted.add(3);

        assertEquals(excepted, CollectionsDemo.adults(map));
    }
    @Test
    public void TestEight2(){
        Human human1 = new Human("Александр", "Александров", "Александрович", 0);
        Human human2 = new Human("Алексей", "Александров", "Александрович", 10);
        Human human3 = new Human("Сашка", "Александров", "Александрович", 10);
        Human human4 = new Human("Филип", "Александров", "Александрович", 0);
        Map<Integer, Human> map = new HashMap<>();
        map.put(0,human1);
        map.put(1,human2);
        map.put(2,human3);
        map.put(3,human4);


        List<Integer> excepted = new ArrayList<>();


        assertEquals(excepted, CollectionsDemo.adults(map));
    }

    @Test
    public void TestNine(){
        Human human1 = new Human("Александр", "Александров", "Александрович", 18);
        Human human2 = new Human("Алексей", "Александров", "Александрович", 10);
        Human human3 = new Human("Сашка", "Александров", "Александрович", 10);
        Human human4 = new Human("Филип", "Александров", "Александрович", 55);
        Map<Integer, Human> map = new HashMap<Integer, Human>();
        map.put(0,human1);
        map.put(1,human2);
        map.put(2,human3);
        map.put(3,human4);


        Map<Integer, Integer> excepted = new HashMap<>();
        excepted.put(0,18);
        excepted.put(1,10);
        excepted.put(2,10);
        excepted.put(3,55);

        assertEquals(excepted, CollectionsDemo.ages(map));
    }

    @Test
    public void TestTen(){
        Human human1 = new Human("Александр", "Александров", "Александрович", 18);
        Human human2 = new Human("Алексей", "Александров", "Александрович", 10);
        Human human3 = new Human("Сашка", "Александров", "Александрович", 50);
        Human human4 = new Human("Филип", "Александров", "Александрович", 18);
        Set<Human> set = new HashSet<>();
        set.add(human1);
        set.add(human2);
        set.add(human3);
        set.add(human4);

        List<Human> list18 = new ArrayList<>();
        list18.add(human4);
        list18.add(human1);

        List<Human> list10 = new ArrayList<>();
        list10.add(human2);

        List<Human> list50 = new ArrayList<>();
        list50.add(human3);

        Map<Integer, List<Human>> excepted = new HashMap<>();
        excepted.put(18,list18);
        excepted.put(10,list10);
        excepted.put(50,list50);


        assertEquals(excepted, CollectionsDemo.mapByAges(set));
    }

    @Test
    public void TestEleven(){
        Human human1 = new Human("Al", "A", "a", 18);
        Human human2 = new Human("Alex", "Al", "a", 18);
        Human human4 = new Human("Fli", "F", "a", 18);
        Human human3 = new Human("S", "S", "a", 50);

        Set<Human> set = new HashSet<>();
        set.add(human1);
        set.add(human2);
        set.add(human3);
        set.add(human4);


        List<Human> listA = new ArrayList<>();
        listA.add(human1);
        listA.add(human2);

        List<Human> listC = new ArrayList<>();
        listC.add(human3);

        List<Human> listF = new ArrayList<>();
        listF.add(human4);

        Map<Character, List<Human>> map18 = new HashMap<>();
        map18.put('A', listA);
        map18.put('F', listF);

        Map<Character, List<Human>> map50 = new HashMap<>();
        map50.put('S', listC);

        Map<Integer,Map<Character,List <Human>>> excepted = new HashMap<>();
        excepted.put(18 ,map18);
        excepted.put(50 ,map50);


        assertEquals(excepted, CollectionsDemo.mapByFirstLetter(set));
    }
