package item18;

/**
 * @author: qujundong
 * @date: 2020/11/27 下午10:13
 * @description:
 */
public class Man extends Person {
    public void print(){
        System.out.println("this is man");
    }

    public static void main(String[] args) {
        Person man = new Man();
        man.usePrint();
    }
}
