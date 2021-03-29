package java1.sort;

/**
 * @description: 堆排序
 * @author: ZhaoYang
 * @create: 2021-03-23 17:09
 */
public class HeapSort<Key extends Comparable<Key>> {
    // 基于堆的完全二叉树
    private Key[] pq;
    // 存储于pq[1..N]中，pq[0]没有使用
    private int size = 0;
    
    public HeapSort(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void insert(Key v) {
        pq[++size] = v;
        swim(size);
    }
    
    public Key delMax() {
        // 从根结点得到最大元素
        Key max = pq[1];
        // 将其和最后一个结点交换
        exchange(1, size--);
        // 防止对象游离
        pq[size + 1] = null;
        // 恢复堆的有序性
        sink(1);
        return max;
    }
    
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
    
    private void exchange(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }
    }
    
    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }
}
