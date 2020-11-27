package item14;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetAndTreeSetCompare {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("1.0");
        BigDecimal bigDecimal2 = new BigDecimal("1.00");
        HashSet<BigDecimal> hashSet = new HashSet<>();
        TreeSet<BigDecimal> treeSet = new TreeSet<>();
        hashSet.add(bigDecimal1);
        hashSet.add(bigDecimal2);
        treeSet.add(bigDecimal1);
        treeSet.add(bigDecimal2);
        System.out.println("treeset output : " + treeSet.toString());
        System.out.println("hashset output : " + hashSet.toString());
    }
}
//treeset output : [1.0]
//hashset output : [1.0, 1.00]