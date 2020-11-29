package item31;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: qujundong
 * @date: 2020/11/29 下午3:25
 * @description:
 */
public class BoundedWildcard<E> {
    private List<E> list = new ArrayList<>();
    public void pushAll(Iterable<? extends E> input){
        for(E e : input)
            list.add(e);
    }
    public void consumer(List<? super E> target, E src){
        target.add(src);
    }
    public void product(List<? extends E> src){
        for(E e : src){
            list.add(e);
        }
    }
    @Override
    public String toString() {
        return "BoundedWildcard{" +
                "list=" + list +
                '}';
    }

    public static void main(String[] args) {
        BoundedWildcard<Object> card = new BoundedWildcard<>();
        List<String> strs = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
        strs.add("abc");
        strs.add("bcd");
        ints.add(1);
        ints.add(2);
        card.pushAll(strs);
        card.pushAll(ints);
        System.out.println(card);
    }
}

