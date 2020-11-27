package item14;

public class ComparableTest {
    public static void main(String[] args) {
        Integer a = new Integer(2);
        String s = new String("aa");
        System.out.println(a.equals(s));//编译通过
        //System.out.println(a.compareTo(s));会报错
    }
}
