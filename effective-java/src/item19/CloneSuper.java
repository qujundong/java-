package item19;

import java.io.Closeable;
import java.sql.Time;
import java.time.Instant;
import java.util.Date;

/**
 * @author: qujundong
 * @date: 2020/11/28 上午9:30
 * @description:
 */
public class CloneSuper implements Cloneable{
    private int id;
    private Time time;
    private String name;
    CloneSuper(int id, Time date, String name){
        this.id = id;
        this.time = date;
        this.name = name;
    }
    public void print(){
    }

    @Override
    public String toString() {
        return "CloneSuper{" +
                "id=" + id +
                ", date=" + time +
                ", name='" + name + '\'' +
                '}';
    }

    public CloneSuper clone() throws CloneNotSupportedException{
        CloneSuper obj = (CloneSuper)super.clone();
        obj.time = (Time)time.clone();
        print();
        return obj;
    }
}
