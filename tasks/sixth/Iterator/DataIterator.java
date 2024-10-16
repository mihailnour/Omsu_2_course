package Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataIterator implements Iterator<Integer> {
    private int currentIndex;
    private int lastGroup;
    private int indexOfCurrentGroup ;
    private final Data data;
    public DataIterator(Data data){
        if (data == null || data.getGroups() == null){
            throw new IllegalArgumentException("Data is null");
        }
        this.data = data;
        boolean first = true;
        for (int i =0; i < data.getLength(); i++){
            if (data.getGroups()[i] != null){
                if (first){
                    indexOfCurrentGroup = i;
//                    System.out.println(indexOfCurrentGroup);
                    first = false;
                    currentIndex = 0;
//                    System.out.println(currentIndex);
                }
                lastGroup = i;
//                System.out.println("Last group :" + lastGroup);
            }
        }
        if (first){
            throw new NullPointerException("There are only null groups");
        }
    }

    @Override
    public boolean hasNext() {
        return indexOfCurrentGroup < lastGroup|| (indexOfCurrentGroup == lastGroup && currentIndex < data.getGroups()[indexOfCurrentGroup].getLength());
    }

    @Override
    public Integer next() {
        if (indexOfCurrentGroup == lastGroup && currentIndex == data.getGroups()[lastGroup].getLength()){
            throw new NoSuchElementException("There are no next element");
        }
        int result = data.getGroups()[indexOfCurrentGroup].getGroupArray()[currentIndex];
        if (indexOfCurrentGroup == lastGroup){
            currentIndex++;
        } else
        if (currentIndex == data.getGroups()[indexOfCurrentGroup].getLength()-1 ){
            for (int i = indexOfCurrentGroup+1; i <= lastGroup; i++){
                if (data.getGroups()[i] != null){
                    indexOfCurrentGroup = i;
                    break;
                }
            }
            currentIndex = 0;
        } else{
            currentIndex++;
        }

        return result;
    }
}

