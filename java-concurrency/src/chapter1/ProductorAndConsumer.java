package chapter1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: qujundong
 * @date: 2020/12/11 下午9:44
 * @description:
 */
public class ProductorAndConsumer {
    private static final int MAX_SiZE = 10;
    private static List<Integer> queue = new LinkedList<Integer>();
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(() -> {
            while (flag) {
                synchronized (queue) {

                    while (queue.size() == MAX_SiZE) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    queue.notifyAll();
                }
            }
            System.out.println("结束生产");
        });
        Thread consumer = new Thread(() -> {
            while (flag) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.remove(0);
                    queue.notifyAll();
                }
            }
            System.out.println("结束消费");

        });
        producer.start();
        consumer.start();
        Thread.sleep(1000);
        flag = false;
    }

}
