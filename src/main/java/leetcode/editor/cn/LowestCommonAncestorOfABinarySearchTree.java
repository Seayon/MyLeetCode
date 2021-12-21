//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
//
//
// 示例 2:
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉搜索树中。
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 723 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;

public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            ArrayList<TreeNode> keyInBSTP = findKeyInBST(root, p);
            ArrayList<TreeNode> keyInBSTQ = findKeyInBST(root, q);
            int maxIndex = keyInBSTP.size() > keyInBSTQ.size() ? keyInBSTQ.size() : keyInBSTP.size();
            for (int index = maxIndex - 1; index >= 0; index--) {
                TreeNode treeNodeP = keyInBSTP.get(index);
                TreeNode treeNodeQ = keyInBSTQ.get(index);
                if (treeNodeP == treeNodeQ) {
                    return treeNodeP;
                }
            }
            return null;
        }

        public ArrayList<TreeNode> findKeyInBST(TreeNode root, TreeNode k) {
            ArrayList<TreeNode> path = new ArrayList<>();
            while (root != null) {
                if (root == k) {
                    path.add(root);
                    return path;
                }
                if (root.val > k.val) {
                    path.add(root.left);
                    root = root.left;
                } else if (root.val < k.val) {
                    path.add(root.right);
                    root = root.right;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
