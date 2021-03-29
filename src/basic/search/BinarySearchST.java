package basic.search;

import basic.structure.Queue;

/**
 * @description:
 * @author: ZhaoYang
 * @create: 2021-03-29 10:26
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;
    
    public BinarySearchST(int capacity) {
        // 调整数组大小的标准代码请见算法1.1
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }
    
    public int size() {
        return N;
    }
    
    public Value get(Key key) {
        if (key == null) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }
    
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    
    
    public void put(Key key, Value val) { // 查找键，找到则更新值，否则创建新的元素
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    
    public void delete(Key key) {
        // 该方法的实现请见练习3.1.16
    }
    
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }
    
    public Key floor(Key key) {
        // 请见练习3.1.17
        return null;
    }
    
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }
        return q;
    }
    
}
