package java1.structure;

/**
 * @description: 定容栈
 * @author: ZhaoYang
 * @create: 2021-03-22 16:49
 */
public class FixedCapacityStack<T> {
    // stack entries
    private T[] a;
    // size
    private int size;
    
    public FixedCapacityStack(int cap) {
        a = (T[]) new Object[cap];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void push(T item) {
        a[size++] = item;
    }
    
    public T pop() {
        return a[--size];
    }
}
