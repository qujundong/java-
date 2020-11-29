package item26;

import Entity.Man;
import Entity.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: qujundong
 * @date: 2020/11/28 下午6:48
 * @description:
 */
public class CacheLowerAndUpperGeneric {
    public <T, E extends T> void readUpperValue(List<E> values, T flag){
        for(T t : values){
            System.out.println(t);
        }
    }
    public <T, E extends T> void writeUpperValue(List<E> values, T flag){
        values.add((E)new  Man(234, "sssdd", LocalDate.now(), false));
        values.add((E)new String("好奇怪"));
    }
//    public <T, E super T> void readLowerValue(List<E> values, T flag){
//        for(T t : values){
//            System.out.println(t);
//        }
//    }
//    public <T, E super T> void writeLowerValue(List<E> values, T flag){
//        values.add((E)new  Man(234, "sssdd", LocalDate.now(), false));
//        values.add((E)new String("好奇怪"));
//    }




    public static void main(String[] args) {
        CacheLowerAndUpperGeneric cache = new CacheLowerAndUpperGeneric();
        ArrayList<Person> list1 = new ArrayList<>();
        Person p1 = new Person(123, "ds", LocalDate.now());
        Person p2 = new Man(234, "sssdd", LocalDate.now(), false);
        list1.add(p1);
        cache.readUpperValue(list1, p1);
        cache.writeUpperValue(list1, p1);
        System.out.println(list1);

    }
}
