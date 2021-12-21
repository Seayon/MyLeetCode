//给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
//
//
//
// 示例 1：
//
//
//输入: root = [5,3,6,2,4,null,7], k = 9
//输出: true
//
//
// 示例 2：
//
//
//输入: root = [5,3,6,2,4,null,7], k = 28
//输出: false
//
//
// 示例 3：
//
//
//输入: root = [2,1,3], k = 4
//输出: true
//
//
// 示例 4：
//
//
//输入: root = [2,1,3], k = 1
//输出: false
//
//
// 示例 5：
//
//
//输入: root = [2,1,3], k = 3
//输出: true
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [1, 10⁴].
// -10⁴ <= Node.val <= 10⁴
// root 为二叉搜索树
// -10⁵ <= k <= 10⁵
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 299 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

public class TwoSumIvInputIsABst {
    public static void main(String[] args) {
        Solution solution = new TwoSumIvInputIsABst().new Solution();

        TreeNode treeNode123 = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));

        Assertions.assertEquals(true, solution.findTarget(treeNode123, 3));

        TreeNode treeNode456 = new TreeNode(5, new TreeNode(1, null, null), new TreeNode(4, new TreeNode(3, null, null), new TreeNode(6, null, null)));
        Assertions.assertEquals(true, solution.findTarget(treeNode456, 10));
        TreeNode treeNode546 = new TreeNode(5, new TreeNode(4, new TreeNode(1, null, new TreeNode(2, null, null)), null), new TreeNode(6, new TreeNode(3, null, null), new TreeNode(7, null, null)));
        Assertions.assertEquals(true, solution.findTarget(treeNode546, 9));

        TreeNode treeNode213 = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));
        Assertions.assertEquals(true, solution.findTarget(treeNode213, 4));
        Assertions.assertEquals(true, solution.findTarget(treeNode213, 3));

        TreeNode treeNodeZero = new TreeNode(2, new TreeNode(0, null, null), new TreeNode(3, null, null));
        Assertions.assertEquals(true, solution.findTarget(treeNodeZero, 3));
        Assertions.assertEquals(true, solution.findTarget(treeNodeZero, 2));

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
        public boolean findTarget(TreeNode root, int k) {
            // 用任意一种方式去遍历所有节点,然后用这个节点的值去整个树上找差值,并且这个差值不能是当前的节点
            //    这里复习一下刚刚练习的深度优先遍历
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                TreeNode keyInBST = findKeyInBST(root, k - pop.val);
                // 如果能找到这个值,并且不是自己本身,就认为匹配到了,就返回 true
                if (keyInBST != null && keyInBST != pop) {
                    return true;
                }
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
            return false;

        }

        public TreeNode findKeyInBST(TreeNode root, int k) {
            while (root != null) {
                if (root.val == k) {
                    return root;
                }
                if (root.val > k) {
                    root = root.left;
                } else if (root.val < k) {
                    root = root.right;
                }
            }
            return null;
        }

        //BST 查找的递归写法
        public TreeNode findKeyInBSTR(TreeNode root, int k) {
            if (root == null) {
                return null;
            }
            if (root.val == k) {
                return root;
            }
            if (root.val > k) {
                root = root.left;
                return findKeyInBSTR(root, k);
            } else {
                root = root.right;
                return findKeyInBSTR(root, k);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
