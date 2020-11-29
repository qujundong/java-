package Item29;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author: qujundong
 * @date: 2020/11/29 上午9:48
 * @description:
 */
public class StackGeneric<E> {

    private E[] elements ;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    @SuppressWarnings("unchecked")
    public StackGeneric(){
       elements =  (E[])new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(E e){
        ensureCapacity();
        elements[size ++] = e;
    }
    public E pop(){
        if(size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
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
        StackGeneric<Object> stack = new StackGeneric<>();
        stack.push(2);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
