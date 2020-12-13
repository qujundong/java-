package chapter1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: qujundong
 * @date: 2020/12/10 下午10:13
 * @description:
 */
public class ThreadCreateAndRun {
    public static class Mythread extends Thread{
        @Override
        public void run(){
            System.out.println("this is Mythread extends thread");
        }
    }
    public static class MyRunnable implements Runnable{
        @Override
        public void run(){
            System.out.println("this is MyRunnalbe implements Runnable");
        }
    }
    public static class MyCallable implements Callable<String>{
        @Override
        public String call() throws Exception{
            return "MyCallable";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.
        new Mythread().start();
        new Thread(new MyRunnable()).start();
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        String s = futureTask.get();
        System.out.println(s);
    }
}
