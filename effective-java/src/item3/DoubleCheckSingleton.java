package item3;

public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton singleton = null;
    private DoubleCheckSingleton(){}
    public static DoubleCheckSingleton getInstance(){
        if(singleton == null){
            synchronized (DoubleCheckSingleton.class){
                if(singleton == null){
                    DoubleCheckSingleton singleton  = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
