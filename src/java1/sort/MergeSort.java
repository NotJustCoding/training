package java1.sort;

/**
 * @description: 归并排序
 * @author: ZhaoYang
 * @create: 2021-03-23 14:34
 */
public class MergeSort extends SortTemplate {
    
    /**
     * 归并所需的辅助数组
     */
    private static Comparable[] aux;
    
    /**
     * 　自顶向下的归并排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        // 一次性分配空间
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }
    
    private static void sort(Comparable[] a, int lo, int hi) {
        // 将数组a[lo..hi]排序
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // 将左半边排序
        sort(a, lo, mid);
        // 将右半边排序
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
    
    /**
     * 自底向上的归并排序
     *
     * @param a
     */
    public static void sortBU(Comparable[] a) {
        // 进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        // sz子数组大小
        for (int sz = 1; sz < N; sz = sz + sz) {
            // lo:子数组索引
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }
    
    public static void merge(Comparable[] a, int lo, int mid, int hi) { // 将a[lo..mid] 和 a[mid+1..hi] 归并
        int i = lo, j = mid + 1;
        // 将a[lo..hi]复制到aux[lo..hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // 归并回到a[lo..hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
    
    
}
