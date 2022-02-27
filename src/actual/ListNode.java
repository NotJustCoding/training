package actual;

/**
 * @description:
 * @author: ZhaoYang
 * @create: 2022-02-16 14:46
 */
public class ListNode {
    public int val;
    public ListNode next;
    
    ListNode(int x) {
        val = x;
    }
    
    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
