package item15;

public class Child extends Person {
    //无法编译
    public void testAcessable(){
        System.out.println("this is child and the accessable level is private");
    }
}
