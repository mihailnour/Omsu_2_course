package Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Group{
    private int id;
    private int[] groupArray;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0 ){
            throw new IllegalArgumentException("Wrong id");
        }
        this.id = id;
    }

    public int[] getGroupArray() {
        return groupArray;
    }

    public void setGroupArray(int[] groupArray) {
        if (groupArray == null){
            throw new IllegalArgumentException("Wrong numbers");
        }
        this.groupArray = groupArray;

    }

    public Group(int id, int ... array){
        this.setId(id);
        groupArray = array;
    }

    public int getLength(){
        return this.groupArray.length;
    }
}
