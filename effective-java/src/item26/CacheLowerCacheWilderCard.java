package item26;

import Entity.Man;
import Entity.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**p
 * @author: qujundong
 * @date: 2020/11/28 下午6:27
 * @description:
 */
public class CacheLowerCacheWilderCard {
    public void readCache(List<? super Man> value){
        for(Object v : value){
            System.out.println(v);
        }
    }
    public void writeCache(List<? super Man> value){
        //无法添加，因为我们根本不知道？的类型，都没办法new对象
        value.add(new Man(1, "ss", LocalDate.now(), true));
        //编译无法通过
        //value.add(new Person(2, "dd", LocalDate.now()));
    }

    public static void main(String[] args) {
        ArrayList<Man> list = new ArrayList<>();
        list.add(new Man(234, "sssdd", LocalDate.now(), false));
        CacheLowerCacheWilderCard cache = new CacheLowerCacheWilderCard();
        cache.readCache(list);
        cache.writeCache(list);
        System.out.println(list);
    }
}
