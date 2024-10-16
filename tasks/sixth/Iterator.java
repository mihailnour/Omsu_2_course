package Iterator;

import java.util.*;

public class Data implements Iterable<Integer>{
    private String name;
    private Group[] groups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("") || name == null){
            throw new IllegalArgumentException("Wrong name");
        }
        this.name = name;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        if (groups == null){
            throw new IllegalArgumentException("Wrong groups");
        }
        this.groups = groups;
    }

    public Data(String name, Group ... groups){
        this.setName(name);
        this.setGroups(groups);
    }

    public Data(Data data){
        this.setName(data.getName());
        this.setGroups(data.getGroups());
    }

    public int getLength(){
        return groups.length;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new DataIterator(this);
    }
}
