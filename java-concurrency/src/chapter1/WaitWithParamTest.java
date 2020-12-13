package chapter1;

/**
 * @author: qujundong
 * @date: 2020/12/12 下午10:52
 * @description:
 */
public class WaitWithParamTest {
    private static final Object LOCK = new Object();
    public static void testWaitWithTimeout(){
        new Thread(()->{
            synchronized (LOCK){
                System.out.println("get LOCk ...");
                System.out.println("start block ...");
                try {
                    LOCK.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        synchronized (LOCK){
            LOCK.wait(1000);
        }
        LOCK.wait();
    }
}
