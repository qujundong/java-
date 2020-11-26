package item3;

public class HungrySingleton {
    private final static HungrySingleton single = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return single;
    }
}
