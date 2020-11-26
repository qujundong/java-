package item3;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
//使用枚举类实现返回list的单例模式
public class EnumSingleton {
    public enum Singleton{
        INSTANCE;
        private List<Integer> list = null;
        private Singleton(){
            list = new ArrayList<>();
        }
        public List getInstance(){
            return list;
        }
    }
}
