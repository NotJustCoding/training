package basic.structure;

import java.util.Iterator;

/**
 * @description: 下压（LIFO）栈（能够动态调整数组大小的实现）
 * @author: ZhaoYang
 * @create: 2021-03-22 16:55
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    // 栈元素
    private Item[] a = (Item[]) new Object[1];
    // 元素数量
    private int size = 0;
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    private void resize(int max) {
        // 将栈移动到一个大小为 max 的新数组
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    
    public void push(Item item) {
        // 将元素添加到栈顶
        if (size == a.length) {
            resize(2 * a.length);
        }
        a[size++] = item;
    }
    
    public Item pop() {
        // 从栈顶删除元素
        Item item = a[--size];
        a[size] = null;
        // 避免对象游离（请见 1.3.2.4 节）
        if (size > 0 && size == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    
    private class ReverseArrayIterator implements Iterator<Item> {
        // 支持后进先出的迭代
        private int i = size;
        
        @Override
        public boolean hasNext() {
            return i > 0;
        }
        
        @Override
        public Item next() {
            return a[--i];
        }
        
        @Override
        public void remove() {
        }
    }
}
