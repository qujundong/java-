package chapter5;

import java.lang.reflect.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Reflect {
    public static void printConstructors(Class cls){
        Constructor[] constructors = cls.getDeclaredConstructors();
        for(Constructor c : constructors){
            String name = c.getName();
            String modifier = Modifier.toString(c.getModifiers());
            System.out.print("the construct is : " + name + "modifier is " + modifier + " the parameterTypes are " );
            Class[] parameterTypes = c.getParameterTypes();
            for(int i = 0; i < parameterTypes.length; i ++){
                if(i > 0)
                    System.out.print(", ");
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println();
        }
    }
    public static void printMethods(Class cls){
        Method[] methods = cls.getMethods();
        for(Method method: methods){
            String name = method.getName();
            String s = Modifier.toString(method.getModifiers());
            System.out.print("the method is : " + name + "the modifier is : " + s  + " the parameterTypes are " );
            Class<?>[] parameterTypes = method.getParameterTypes();
            for(int i = 0; i < parameterTypes.length; i++){
                if(i > 0)
                    System.out.print(", ");
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println();
        }
    }
    public static void printFields(Class cls){
        Field[] declaredFields = cls.getDeclaredFields();
        for(Field f : declaredFields){
            String name = f.getName();
            String s = Modifier.toString(f.getModifiers());
            System.out.println("the filed is : " + name + "the modifier is : " + s);
        }
    }

    /**
     * 反射尝试使用静态方法，包括有参数和无参数的
     * @param cls
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public  static void useStaticMethod(Class<LocalDate> cls) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Method now = cls.getMethod("now");
        LocalDate invoke = (LocalDate)now.invoke(null, null);
        Method of = cls.getMethod("of", new Class[]{int.class, int.class, int.class});

        System.out.println(invoke);
        System.out.println(of.invoke(null, 2, 1, 3));
    }

    /**
     * 反射使用方法，包括构造函数，普通函数，以及私有函数的处理
     * @param cls
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static void useMethod(Class<LocalDate> cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = cls.getDeclaredConstructor(int.class, int.class, int.class);
        constructor.setAccessible(true);
        LocalDate localDate1 = (LocalDate)constructor.newInstance(2013, 2, 4 );
        Method minusDays = cls.getMethod("minusDays", long.class);
        LocalDate localDate2 = (LocalDate)minusDays.invoke(localDate1, 5);
        System.out.println(localDate1);
        System.out.println(localDate2);
    }
/*
    以Date类和LocalDate类为例练习一下反射的某些写法
 */
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class<?> cls = Class.forName("java.util.Date");
        Class<LocalDate> cls2 = LocalDate.class;
//        printConstructors(cls);
//        printMethods(cls);
//        printMethods(cls);
        useStaticMethod(cls2);
        useMethod(cls2);
    }


}
