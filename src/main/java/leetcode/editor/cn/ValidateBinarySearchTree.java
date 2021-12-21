//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下：
//
//
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
//
//
// 示例 1：
//
//
//输入：root = [2,1,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在[1, 10⁴] 内
// -2³¹ <= Node.val <= 2³¹ - 1
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1353 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        TreeNode treeNode123 = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));

        Assertions.assertEquals(true, solution.isValidBST(treeNode123));

        TreeNode treeNode456 = new TreeNode(5, new TreeNode(1, null, null), new TreeNode(4, new TreeNode(3, null, null), new TreeNode(6, null, null)));
        Assertions.assertEquals(false, solution.isValidBST(treeNode456));
        TreeNode treeNode546 = new TreeNode(5, new TreeNode(4, new TreeNode(1,null,new TreeNode(2,null,null)), null), new TreeNode(6, new TreeNode(3, null, null), new TreeNode(7, null, null)));
        Assertions.assertEquals(false, solution.isValidBST(treeNode546));


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
        public boolean isValidBST(TreeNode root) {
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean helper(TreeNode root, long lower, long upper){
            if (root == null) {
                return true;
            }
            if (root.val <= lower || root.val >= upper) {
                return false;
            }
            return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
