package item26;

/**
 * @author: qujundong
 * @date: 2020/11/28 下午5:16
 * @description:
 */
public class CacheObject {
    private Object value;
    public void setValue(Object value){
        this.value = value;
    }
    public Object getValue(){
        return value;
    }

    public static void main(String[] args) {
        Cache<Integer> cache = new Cache();
        cache.setValue(134);
        int value =  cache.getValue();
        System.out.println(value);

    }
}
