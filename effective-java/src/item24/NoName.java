package item24;

/**
 * @author: qujundong
 * @date: 2020/11/28 下午12:15
 * @description:
 */
public class NoName {
    public void test(){
        int a = 2;
        //a ++;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(a);
            }
        }).start();
    }
    public static void main(String[] args) {
       new NoName().test();

    }
}
