package item18;

/**
 * @author: qujundong
 * @date: 2020/11/27 下午10:11
 * @description:
 */
public class Person {
    public void print(){
        System.out.println("this is person");
    }
    public void usePrint(){
        System.out.println("this is usePrint, want to use person print ");
        print();
    }
}
