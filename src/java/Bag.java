package java;

import java.util.Iterator;

/**
 * @description: 背包
 * @author: ZhaoYang
 * @create: 2021-03-22 17:18
 */
public class Bag<Item> implements Iterable<Item> {
    // 链表的首结点
    private Node first;
    
    private class Node {
        Item item;
        Node next;
    }
    
    public void add(Item item) {
        // 和 Stack 的 push() 方法完全相同
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
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
