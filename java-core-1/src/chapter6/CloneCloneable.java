package chapter6;

import java.util.Date;

/**
 * 使用Cloneable实现clone
 */
public class CloneCloneable implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    @Override
    public String toString() {
        return "CloneCloneable{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }

    public CloneCloneable(String name, double salary, Date hireDay){
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public CloneCloneable clone() throws CloneNotSupportedException{
        CloneCloneable obj = (CloneCloneable)super.clone();
        obj.hireDay = (Date)hireDay.clone();
        return obj;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneCloneable obj1 = new CloneCloneable("zhangsan", 100.0, new Date());
        CloneCloneable obj2 = obj1.clone();
        System.out.println(obj1 == obj2);
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
