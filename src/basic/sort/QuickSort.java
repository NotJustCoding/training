package basic.sort;

/**
 * @description:
 * @author: ZhaoYang
 * @create: 2021-03-23 14:45
 */
public class QuickSort extends SortTemplate {
    
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }
    
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        // 将左半部分a[lo .. j-1]排序
        sort(a, lo, j - 1);
        // 将右半部分a[j+1 .. hi]排序
        sort(a, j + 1, hi);
    }
    
    /**
     * 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        // 左右扫描指针
        int i = lo, j = hi + 1;
        // 切分元素
        Comparable v = a[lo];
        // 扫描左右，检查扫描是否结束并交换元素
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        // 将v = a[j]放入正确的位置
        exchange(a, lo, j);
        // a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
        return j;
    }
    
    private static void sort3Way(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exchange(a, lt++, i++);
            } else if (cmp > 0) {
                exchange(a, i, gt--);
            } else {
                i++;
            }
        }
        // 现在 a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
        sort3Way(a, lo, lt - 1);
        sort3Way(a, gt + 1, hi);
    }
}
