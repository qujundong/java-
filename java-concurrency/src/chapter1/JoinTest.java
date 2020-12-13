package chapter1;

/**
 * @author: qujundong
 * @date: 2020/12/13 上午10:56
 * @description:
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 begin run ...");
            for (; ; ) {
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("111");
            }
        });
        Thread mainThread = Thread.currentThread();
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainThread.interrupt();
        });
        thread1.start();
        thread2.start();
        try{
            thread1.join();
        }catch (InterruptedException e){
            System.out.println("main thread : " + e);
        }
    }
}
