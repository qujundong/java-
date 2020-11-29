package item19;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;

/**
 * @author: qujundong
 * @date: 2020/11/28 上午9:36
 * @description:
 */
public class CloneSub extends CloneSuper {
    private Time time2 ;
    private String subName;
    private Instant instant;
    CloneSub(int id, Time time1, String name, Time time2, String subName) {
        super(id, time1, name);
        this.time2 = time2;
        this.subName = subName;
    }
    public void print(){
        System.out.println(instant);
    }
    public CloneSub clone() throws CloneNotSupportedException {
        CloneSub obj = (CloneSub)super.clone();
        obj.time2 = (Time)time2.clone();
        instant =  Instant.now();
        print();
        return obj;
    }

    @Override
    public String toString() {
        return super.toString() + " CloneSub{" +
                "date2=" + time2 +
                ", subName='" + subName + '\'' +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        Time time1 = new Time(System.currentTimeMillis());
        Thread.sleep(1000);
        Time time2 = new Time(System.currentTimeMillis());
        CloneSub obj1 = new CloneSub(1, time1, "CloneSuper", time2, "subname");
        CloneSub obj2 = obj1.clone();
        System.out.println(obj1 == obj2);
        System.out.println(obj1);
        System.out.println(obj2);
    }

}
//null
//2020-11-28T02:06:02.119Z
//false
//CloneSuper{id=1, date=10:06:01, name='CloneSuper'} CloneSub{date2=10:06:02, subName='subname'}
//CloneSuper{id=1, date=10:06:01, name='CloneSuper'} CloneSub{date2=10:06:02, subName='subname'}