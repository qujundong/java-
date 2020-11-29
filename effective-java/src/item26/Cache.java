package item26;

/**
 * @author: qujundong
 * @date: 2020/11/28 下午5:12
 * @description:
 */
public class Cache<T> {
    private T value;
    public void setValue(T value){
        this.value = value;
    }
    public T getValue(){
        return value;
    }

    public static void main(String[] args) {
        Cache<Integer> cache = new Cache();
        cache.setValue(134);
        int value = (int) cache.getValue();
        System.out.println(value);

    }
}
