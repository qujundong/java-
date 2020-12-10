package item39;

/**
 * @author: qujundong
 * @date: 2020/12/6 下午1:22
 * @description:
 */
import java.lang.annotation.*;

public class Annotatioon {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Schedule {
        String dayOfMonth() default "first";
        String dayOfWeek() default "Mon";
        int hour() default 12;
    }
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Schedules {
       Schedule[] value();
    }
    @Schedules(value = {
            @Schedule(dayOfMonth = "a", dayOfWeek = "b"),
            @Schedule(dayOfMonth = "c", dayOfWeek = "d")
    })

    public static void test(){

    }

    public static void main(String[] args) {
        test();
    }
}
