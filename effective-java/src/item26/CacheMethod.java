package item26;

import com.sun.org.apache.bcel.internal.classfile.Constant;

import java.util.Date;

/**
 * @author: qujundong
 * @date: 2020/11/28 下午5:26
 * @description:
 */
public class CacheMethod<T> {
    public <T> T testOneType(T value) {
        System.out.println("one type");
        return null;
    }
    public <T, E> E testTwoTypes(T value){
        System.out.println("two types");
        return null;
    }

    public static void main(String[] args) {
        CacheMethod<Constant> cache = new CacheMethod();
        cache.testOneType(new String("ss"));
        cache.testOneType(123);
        cache.testTwoTypes(new Date());
    }

}
