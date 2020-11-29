package item26;

/**
 * @author: qujundong
 * @date: 2020/11/28 下午5:23
 * @description:
 */
public class CacheMultiType<E, T> {
    private E value1;
    private T value2;
    public void setValue1(E value){
        this.value1 = value;
    }
    public void setVaule2(T value){
        this.value2 = value;
    }

    public static void main(String[] args) {
        CacheMultiType<String, Integer> cache = new CacheMultiType<>();
        cache.setValue1(new String("ssss"));
        cache.setVaule2(new Integer(3));
    }
}
