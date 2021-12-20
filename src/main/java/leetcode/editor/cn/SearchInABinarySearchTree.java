//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
//
// 例如，
//
//
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
//
//
// 你应该返回如下子树:
//
//
//      2
//     / \
//    1   3
//
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
// Related Topics 树 二叉搜索树 二叉树 👍 221 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree().new Solution();

        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2,
                new TreeNode(4, null, null), new TreeNode(3, new TreeNode(6), null)),
                new TreeNode(5, null, new TreeNode(7)));

        Assertions.assertEquals(2, solution.searchBST(treeNode1, 2).val);
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
        public TreeNode searchBST(TreeNode root, int val) {
            while (root != null) {
                if (val == root.val) {
                    return root;
                }
                if (val > root.val) {
                    root = root.right;
                } else if (val < root.val) {
                    root = root.left;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}