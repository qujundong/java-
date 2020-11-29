package item19;

import java.time.Instant;

/**
 * @author: qujundong
 * @date: 2020/11/28 上午7:33
 * @description:
 */
public class Sub extends Super {
    private final Instant instant;
    Sub(){
        instant = Instant.now();
    }
    @Override
    public void overrideMe(){
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
