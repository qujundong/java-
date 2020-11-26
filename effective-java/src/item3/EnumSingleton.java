package item3;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//使用枚举类实现返回list的单例模式
public class EnumSingleton implements Serializable {
    static class Person implements Serializable{
        @Override
        public String toString() {
            return "Person{" +
                    "a='" + a + '\'' +
                    ", date=" + date +
                    ", id=" + id +
                    '}';
        }

        private String a = null;
        private Date date = null;
        private int id = 0;
        public Person(String a, Date date, int id){
            this.a = a;
            this.date = date;
            this.id = id;
            System.out.println("create the person");
        }
    }
    public enum Singleton{
        INSTANCE;
        private Person instance = null;
        private Singleton(){
            instance = new Person("single person", new Date(), 1);
        }
        public Person getInstance(){
            return instance;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person s1 = Singleton.INSTANCE.getInstance();
        Person s2 = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(s1);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        s2 = (Person)ois.readObject();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }
}
