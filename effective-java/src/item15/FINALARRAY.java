package item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FINALARRAY {
    private static final Integer[] array = new Integer[10];
    public static final Integer[] values(){
        return array.clone();
    }
    public static void main(String[] args) {
        Integer[] array = FINALARRAY.array;
        array[2] = 3;
        array[4] =5;
        System.out.println(array.toString());
        final List<Integer> finalList = Collections.unmodifiableList(Arrays.asList(array));
        finalList.set(2, 4);
        System.out.println(finalList.toString());

    }
}
