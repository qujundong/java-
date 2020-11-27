package item18;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author: qujundong
 * @date: 2020/11/27 下午9:57
 * @description:
 */
public class InstrumenteHashSet<E> extends HashSet<E> {
    private int addCount = 0;
    public InstrumenteHashSet(){}
    public InstrumenteHashSet(int initCap, float loadFactor){
        super(initCap, loadFactor);
    }
    @Override
    public boolean add(E e){
        addCount ++;
        return super.add(e);
    }
    @Override
    public boolean addAll(Collection<? extends E> c){
        addCount += c.size();
        return super.addAll(c);
    }
    public int getAddCount(){return addCount;}

    public static void main(String[] args) {
        InstrumenteHashSet<String> s = new InstrumenteHashSet<>();
        String[] array = {"Snap", "Crackle", "Pop"};
        s.addAll(Arrays.asList(array));
        System.out.println(s.getAddCount());
    }
}
