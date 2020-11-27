package item18;

/**
 * @author: qujundong
 * @date: 2020/11/27 下午10:23
 * @description:
 */
// Wrapper class - uses composition in place of inheritance
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ComInstrumentedSet<E> extends ForwardingSet<E> {

    private int addCount = 0;

    public ComInstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("123");
        set.add("abc");
        set.add("bcd");
        ComInstrumentedSet<String> instrumenteHashSet = new ComInstrumentedSet<String>(new TreeSet<>());
        instrumenteHashSet.addAll(set);
        System.out.println(instrumenteHashSet.getAddCount());
    }
}
