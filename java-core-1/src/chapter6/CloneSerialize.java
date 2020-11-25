package chapter6;

import java.io.*;
import java.util.Date;

public class CloneSerialize implements Serializable {
    private String name;
    private double salary;
    private Date hireDay;

    @Override
    public String toString() {
        return "CloneSerialize{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }

    public CloneSerialize(String name, double salary, Date hireDay){
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }
    public CloneSerialize clone(){
        ByteArrayOutputStream out = null;
        ObjectOutputStream oout = null;
        ByteArrayInputStream in = null;
        ObjectInputStream oin = null;
        CloneSerialize obj = null;
        try {
            out = new ByteArrayOutputStream();
            oout = new ObjectOutputStream(out);
            oout.writeObject(this);
            in = new ByteArrayInputStream(out.toByteArray());
            oin = new ObjectInputStream(in);
            obj =(CloneSerialize) oin.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                assert out != null;
                out.close();
                assert oout != null;
                oout.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return obj;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneSerialize obj1 = new CloneSerialize("zhangsan", 100.0, new Date());
        CloneSerialize obj2 = (CloneSerialize)obj1.clone();
        System.out.println(obj1 == obj2);
        System.out.println(obj1);
        System.out.println(obj2);
    }

}
