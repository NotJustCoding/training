package basic.sort;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @description:
 * @author: ZhaoYang
 * @create: 2021-03-23 14:03
 */
public class BaseSort extends SortTemplate {
    
    public static void selection(Comparable[] a) {
        // 数组长度
        int size = a.length;
        // 将a[i]和a[i+1..N]中最小的元素交换
        for (int i = 0; i < size; i++) {
            // 最小元素的索引
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }
    
    public static void injection(Comparable[] a) {
        int n = a.length;
        // 将 a[i] 插入到 a[i-1]、a[i-2]、a[i-3]...之中
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }
    
    
    public static void shell(Comparable[] a) {
        int size = a.length;
        int h = 1;
        while (h < size / 3) {
            // 1, 4, 13, 40, 121, 364, 1093, ...
            h = 3 * h + 1;
        }
        // 将数组变为h有序
        while (h >= 1) {
            // 将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]... 之中
            for (int i = h; i < size; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
    
    public static void main(String[] args) {
        Comparable<Integer>[] a = new Integer[30];
        for (int i = 0; i < 30; i++) {
            int num = ThreadLocalRandom.current().nextInt(100);
            a[i] = num;
        }
        shell(a);
    }
    
    
}
