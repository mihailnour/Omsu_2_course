package Collections;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsDemo {

    public static int firstSymbolEquals (List<String> list, char a){
        if (list.isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }
        if (a ==  ' ' || a == '\u0000'){
            throw new IllegalArgumentException("Character is empty");
        }
        int counter = 0;
        for (String item : list){
            if (item!= null && a == item.charAt(0)){
                counter ++;
            }
        }
        return counter;
    }

    /**
     * 4
     * @param list
     * @param set
     * @return
     */
    public static List<Set<Integer>> notIntersect (List<Set<Integer>> list, Set<Integer> set){
        if (list == null || set == null || list.isEmpty() || set.isEmpty()){
            throw new IllegalArgumentException("Input is empty");
        }
        List<Set<Integer>> answer = new ArrayList<>(list);

        for (Set<Integer> sets: list){
            for (var setsInt: sets){
                for (var setInt: set){
                    if (setsInt.equals(setInt)){
                        answer.remove(sets);
                        break;
                    }
                }
            }
        }
        return answer;
    }

    /**
     * 2
     * @param list
     * @param human
     * @return
     */
    public static List<Human> namesakes(List<Human> list, Human human){
        if (list.isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }
        if (human == null){
            throw new IllegalArgumentException("Gimme human please");
        }
        List<Human> answer = new ArrayList<>();
        for (Human value : list) {
            if (value != null && Objects.equals(value.getMiddleName(), human.getMiddleName())) {
                answer.add(value);
            }
        }
        return answer;
    }

    /**
     * 3
     * @param list
     * @param human
     * @return
     */
    public static List<Human> deleteThis(List<Human> list, Human human){
        if (list.isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }
        if (human == null){
            throw new IllegalArgumentException("Gimme human please");
        }
        List<Human> answer = new ArrayList<>(list);
        while (answer.contains(human)) {
                answer.remove(human);
            }
        return answer;
    }

    /**
     * 5
     * @param list
     * @return
     */
    public static List<? extends Human> maxAgeHumans(List<? extends Human> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }
        List<Human> answer = new ArrayList<>();
        int max = 0;
        for (Human human: list)
            if (human != null && human.getAge() > max){
                max = human.getAge();
            }
        int counter = 0;
        for (Human human: list)
            if (human != null && human.getAge() == max){
                answer.add(counter, human);
                counter++;
            }
        return answer;
    }

    public static List<? extends Human> listByName(Set<? extends Human> set){
        return new ArrayList<Human>(new TreeSet<Human>(set));
    }

    /**
     * 7
     * @param map
     * @param set
     * @return
     */
    public static Set<Human> byId(Map<Integer, Human> map, Set<Integer> set){
        Set<Human> answer = new HashSet<>();
        for (Map.Entry<Integer, Human> entry: map.entrySet()){
            for (Integer id: set){
                if (entry != null && Objects.equals(id, entry.getKey())){
                    answer.add(entry.getValue());
                }
            }
        }
        return answer;
    }

    /**
     * 8
     * @param map
     * @return
     */
    public static List<Integer> adults(Map<Integer, Human> map){
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<Integer, Human> entry: map.entrySet()){
            if (entry != null && entry.getValue().getAge() >= 18){
                answer.add(entry.getKey());
            }
        }
        return answer;
    }

    public static Map<Integer, Integer> ages(Map<Integer, Human> map){
        Map<Integer, Integer> answer = new HashMap<>();
        for (Map.Entry<Integer, Human> entry: map.entrySet()){
            answer.put(entry.getKey(),entry.getValue().getAge());
        }
        return answer;
    }

    public static Map<Integer,List<Human>> mapByAges(Set<Human> set){
        if (set == null || set.isEmpty()){
            throw new IllegalArgumentException("Set is wrong");
        }
        Map<Integer, List<Human>> answer = new HashMap<>();
        for (Human item : set){
            answer.putIfAbsent(item.getAge(), new ArrayList<Human>());
            answer.get(item.getAge()).add(item);
        }
        return answer;
    }

    public static Map<Integer,Map<Character,List <Human>>> mapByFirstLetter(Set<Human> set){
        if (set == null || set.isEmpty()){
            throw new IllegalArgumentException("Set is wrong");
        }
        Set<Human> localeSet = new TreeSet<>((h1,h2)->  h1.compareTo(h2));
        localeSet.addAll(set);
//        ((h1,h2)-> - h1.compareTo(h2));
        Map<Integer, Map<Character, List<Human>>> answer = new HashMap<>();
        for (Human human : localeSet){
            answer.putIfAbsent(human.getAge(), new HashMap<Character, List<Human>>());
            answer.get(human.getAge()).putIfAbsent(human.getMiddleName().charAt(0),new ArrayList<Human>());
            answer.get(human.getAge()).get(human.getMiddleName().charAt(0)).add(human);
        }
        return answer;
    }
}
