package item6;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class AutoBox {
    private static long sum1() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
    private static long sum2() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        sum1();
        System.out.println("the auto boxing use time : " + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        sum2();
        System.out.println("no auto boxing use time : " + (System.currentTimeMillis() - start2));
    }

}
/*
the auto boxing use time : 7077
no auto boxing use time : 502
 */
