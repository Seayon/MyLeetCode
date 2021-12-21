//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索 二叉树 👍 1129 👎 0


package leetcode.editor.cn;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2,
                new TreeNode(4, null, null), new TreeNode(3, new TreeNode(6), null)),
                new TreeNode(5, null, new TreeNode(7)));
        solution.levelOrder(treeNode1);

       /* Integer[] a =  {6,2,8,0,4,7,9,null,null,3,5};

        Queue<TreeNode> a = new LinkedList<>();
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        currentLevel.add(new TreeNode(a[0], null, null));
        for (int i = 1; i < a.length; i++) {
        //    存储当前层的所有节点的队列
            while (!currentLevel.isEmpty()) {
                TreeNode poll = currentLevel.poll();
                TreeNode poll1 = nodes.poll();
                if (poll1 != null) {
                    poll.left = poll1;
                }
            }
        }*/


    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            ArrayList<List<Integer>> result = new ArrayList<>();
            Deque<TreeNode> current = new LinkedList<>();
            // 添加元素到队尾
            current.offer(root);
            while (!current.isEmpty()) {
                Deque<TreeNode> tmp = new LinkedList<>();
                List<Integer> currentVal = new ArrayList<>();
                while (!current.isEmpty()) {
                    // 从队首拿出元素
                    TreeNode pop = current.poll();
                    currentVal.add(pop.val);
                    if (pop.left != null) {
                        tmp.add(pop.left);
                    }
                    if (pop.right != null) {
                        tmp.add(pop.right);
                    }
                }
                result.add(currentVal);
                current = tmp;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
