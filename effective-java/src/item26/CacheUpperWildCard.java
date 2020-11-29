package item26;

import Entity.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: qujundong
 * @date: 2020/11/28 下午6:08
 * @description:
 */
public class CacheUpperWildCard {
    public void readCache(List<? extends Person> value){
        for(Person v : value){
            System.out.println(v);
        }
    }
    public void writeCache(List<? extends Person> value){
        //无法添加，因为我们根本不知道？的类型，都没办法new对象
//        value.add(new Person(1, "name", LocalDate.now()));
    }

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(1, "name", LocalDate.now()));
        CacheUpperWildCard cache = new CacheUpperWildCard();
        cache.readCache(list);
    }
}
