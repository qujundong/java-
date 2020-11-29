package item26;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: qujundong
 * @date: 2020/11/28 下午9:10
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("str123");
        list.add("str345");
        list.add(LocalDate.now());
        System.out.println(list);
    }
}
