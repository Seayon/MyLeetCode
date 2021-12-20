//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1666 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2,
                new TreeNode(4, null, null), new TreeNode(3, new TreeNode(6), null)),
                new TreeNode(5, null, new TreeNode(7)));
        TreeNode treeNode123 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, null)));
        Assertions.assertEquals(false, solution.isSymmetric(treeNode1));
        Assertions.assertEquals(false, solution.isSymmetric(treeNode123));

        treeNode123 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, null)));
        Assertions.assertEquals(false, solution.isSymmetric(treeNode123));

        treeNode123 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        Assertions.assertEquals(false, solution.isSymmetric(treeNode123));

        treeNode123 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3, null, null)), null);
        Assertions.assertEquals(false, solution.isSymmetric(treeNode123));

        treeNode123 = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), null), null);
        Assertions.assertEquals(false, solution.isSymmetric(treeNode123));


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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode poll1 = queue.poll();
                TreeNode poll2 = queue.poll();
                if (poll1 == null && poll2 == null) {
                    continue;
                }
                if ((poll1 == null ^ poll2 == null) || poll1.val != poll2.val) {
                    return false;
                }
                queue.offer(poll1.left);
                queue.offer(poll2.right);

                queue.offer(poll1.right);
                queue.offer(poll2.left);
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
