package actual;

import java.util.HashMap;

/**
 * @description: 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * @author: ZhaoYang
 * @create: 2021-03-29 15:43
 */
public class LRUCache {
    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;
    
    private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }
    
    /**
     * 总是在头节点中插入新节点.
     */
    private void addNode(DLinkedNode node) {
        
        node.pre = head;
        node.post = head.post;
        
        head.post.pre = node;
        head.post = node;
    }
    
    /**
     * 摘除一个节点.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        
        pre.post = post;
        post.pre = pre;
    }
    
    /**
     * 摘除一个节点,并且将它移动到开头
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }
    
    /**
     * 弹出最尾巴节点
     */
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
    

    
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        
        head = new DLinkedNode();
        head.pre = null;
        
        tail = new DLinkedNode();
        tail.post = null;
        
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // cache里面没有
            return -1;
        }
        
        // cache 命中,挪到开头
        this.moveToHead(node);
        
        return node.value;
    }
    
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        
        if (node == null) {
            
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            
            this.cache.put(key, newNode);
            this.addNode(newNode);
            
            ++count;
            
            if (count > capacity) {
                // 最后一个节点弹出
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        } else {
            // cache命中,更新cache.
            node.value = value;
            this.moveToHead(node);
        }
    }
    
}
