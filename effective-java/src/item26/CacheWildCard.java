package item26;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: qujundong
 * @date: 2020/11/28 下午5:51
 * @description:
 */
public class CacheWildCard{
    public void readCache(List<?> value){
        for(Object v : value){
            System.out.println(v);
        }
    }
    public void writeCache(List<?> value){
        //无法添加，因为我们根本不知道？的类型，都没办法new对象
        value.add(null);
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        CacheWildCard cache = new CacheWildCard();
        cache.readCache(list);
        cache.writeCache(list);
        cache.writeCache(list);
        System.out.println(list);
    }
}
/*
1
2
3
[1, 2, 3, null, null]
 */
