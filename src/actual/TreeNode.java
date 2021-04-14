package actual;

import java.util.Stack;

/**
 * @description:
 * @author: ZhaoYang
 * @create: 2021-03-29 19:53
 */
public class TreeNode {
    
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
    
    @Override
    public String toString() {
        return Integer.toString(val);
    }
    
    private static int[] strToIntArray(String str) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",");
        int[] arr = new int[strs.length];
        
        for (int i = 0; i < arr.length; i++) {
            if ("null".equals(strs[i])) {
                arr[i] = Integer.MAX_VALUE;
            } else {
                arr[i] = Integer.parseInt(strs[i]);
            }
        }
        
        return arr;
    }
    
    public static TreeNode mkTree(String str) {
        
        int[] arr = strToIntArray(str);
        TreeNode[] nodes = new TreeNode[arr.length + 1];
        for (int i = 1; i < nodes.length; i++) {
            if (arr[i - 1] != Integer.MAX_VALUE) {
                nodes[i] = new TreeNode(arr[i - 1]);
            } else {
                nodes[i] = null;
            }
        }
        
        TreeNode node;
        for (int i = 1; i < nodes.length / 2; i++) {
            node = nodes[i];
            if (node == null) {
                continue;
            }
            node.left = nodes[2 * i];
            node.right = nodes[2 * i + 1];
        }
        return nodes[1];
    }
    
    public static Integer[] treeParseArray(TreeNode root) {
        Stack<Integer> result = new Stack<>();
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<>();
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        for (; ; ) {
            if (root == null && treeNodeStack.isEmpty()) {
                break;
            }
            for (; ; ) {
                // 为了之后能找到该节点的右子树，暂存该节点
                if (root == null) {
                    break;
                }
                result.push(root.val);
                treeNodeStack.push(root);
                if (root.left == null) {
                    if (root.right != null) {
                        result.push(null);
                    }
                    break;
                }
                root = root.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                root = treeNodeStack.pop();
                root = root.right;
            }
        }
        Integer[] a = new Integer[result.size()];
        return result.toArray(a);
    }
}
