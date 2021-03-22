package java;

import java.util.Iterator;

/**
 * @description: 下压堆栈（链表实现）
 * @author: ZhaoYang
 * @create: 2021-03-22 17:10
 */
public class Stack<Item> implements Iterable<Item> {
    // 栈顶（最近添加的元素）
    private Node first;
    // 元素数量
    private int size;
    
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        
        @Override
        public boolean hasNext() {
            return current != null;
        }
        
        @Override
        public void remove() {
        }
        
        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    
    private class Node {
        // 定义了结点的嵌套类
        Item item;
        Node next;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public int size() {
        return size;
    }
    
    public void push(Item item) {
        // 向栈顶添加元素
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }
    
    public Item pop() {
        // 从栈顶删除元素
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }
}
