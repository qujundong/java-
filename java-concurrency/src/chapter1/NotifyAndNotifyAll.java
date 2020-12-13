package chapter1;

/**
 * @author: qujundong
 * @date: 2020/12/13 上午10:22
 * @description:
 */
public class NotifyAndNotifyAll {
    private static Object lock = new Object();
    public static class MyRunnalbe implements Runnable{
        private String threadName;

        public MyRunnalbe(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(threadName + " get lock");
                try {
                    System.out.println(threadName + " begin wait");
                    lock.wait();
                    System.out.println(threadName + " end wait");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new MyRunnalbe("threadA"));
        Thread threadB = new Thread(new MyRunnalbe("threadB"));
        Thread threadC = new Thread(() -> {
            synchronized (lock) {
                System.out.println("threadC begin notify");
//                lock.notify();
                lock.notifyAll();
            }
        });
        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over");
    }
}
