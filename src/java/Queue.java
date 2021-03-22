package java;

import java.util.Iterator;

/**
 * @description:
 * @author: ZhaoYang
 * @create: 2021-03-22 17:22
 */
public class Queue<Item> implements Iterable<Item> {
    // 指向最早添加的结点的链接
    private Node first;
    // 指向最近添加的结点的链接
    private Node last;
    // 队列中的元素数量
    private int size;
    
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
    
    public void enqueue(Item item) {
        // 向表尾添加元素
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        size++;
    }
    
    public Item dequeue() { // 从表头删除元素
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        size--;
        return item;
    }
    
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
}
