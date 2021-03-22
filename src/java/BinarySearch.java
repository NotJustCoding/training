package java;

/**
 * @description: 二分查找
 * @author: ZhaoYang
 * @create: 2021-03-22 14:44
 */
public class BinarySearch {
    public static int rank(int key, int[] a) {
        // 数组必须是有序的
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            // 被查找的键要么不存在，要么必然存在于 a[lo..hi] 之中
            int mid = low + (high - low) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    
}
