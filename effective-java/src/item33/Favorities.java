package item33;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author: qujundong
 * @date: 2020/12/5 下午6:50
 * @description:
 */
public class Favorities {
    private Map<Class<?>, Object> map = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance){
        map.put(type, instance);
    }
    public  <T> T getFavorite(Class<T> type){
        return type.cast(map.get(type));
    }

    public static void main(String[] args) {
        Favorities favorities = new Favorities();
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("123");
        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(123);
        favorities.putFavorite(HashSet.class, hashSet);
        favorities.putFavorite(HashSet.class, hashSet2);

        System.out.println(hashSet);
        Integer ires = favorities.getFavorite(Integer.class);
        System.out.println(ires);
    }
}
