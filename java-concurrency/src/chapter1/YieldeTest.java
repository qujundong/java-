package chapter1;

/**
 * @author: qujundong
 * @date: 2020/12/13 上午11:30
 * @description:
 */
public class YieldeTest implements Runnable {
    public YieldeTest() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i ++){
            if(i % 5 == 0){
                System.out.println(Thread.currentThread() + "yield cpu ...");
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + " is over");
    }

    public static void main(String[] args) {
        new YieldeTest();
        new YieldeTest();
        new YieldeTest();
    }
}
