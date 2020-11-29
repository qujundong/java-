package Item29;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author: qujundong
 * @date: 2020/11/29 上午9:36
 * @description:
 */
public class StackObject {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    public StackObject(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(Object e){
        ensureCapacity();
        elements[size ++] = e;
    }
    public Object pop(){
        if(size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }
    private boolean isEmpty(){
        return size == 0;
    }
    private void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    @Override
    public String toString() {
        return "StackObject{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        StackObject stack = new StackObject();
        stack.push(2);
        stack.push(4);
        stack.push("SS");
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
