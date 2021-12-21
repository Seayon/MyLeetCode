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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
            //用广度优先方式遍历二叉树,检查这个节点能否到达输入的 p 和 q 节点(或者等于节点本身),能到达的话即为一个祖先
            //然后遍历下一层,如果下一层还能找到,就用下一层的,因为下一层更近
            ArrayList<List<TreeNode>> list = new ArrayList<>();
            Queue<TreeNode> current = new LinkedList<>();
            current.offer(root);
            while (!current.isEmpty()) {
                Queue<TreeNode> tmp = new LinkedList<>();
                List<TreeNode> currentLevelNodes = new ArrayList<>();
                // 如果队列中还有数据
                while (!current.isEmpty()) {
                    // 就循环全部取出存储到当前这一层的集合中
                    TreeNode poll = current.poll();
                    currentLevelNodes.add(poll);
                    //并且顺道把下一层的节点都存储到临时的队列中
                    if (poll.left != null) {
                        tmp.add(poll.left);
                    }
                    if (poll.right != null) {
                        tmp.add(poll.right);
                    }
                }
                //存储这一层的数据
                list.add(currentLevelNodes);
                //等到循环完了集合中没有数据了,将当前集合的引用指向下一层集合
                current = tmp;
            }
            //遍历完以后,倒序遍历结果集合,从最低的一层开始找,尝试在这可树上找到目标值,如果都能找到,则是最近的公共祖先
            boolean finded = false;
            TreeNode result = null;
            for (int i = list.size() - 1; i >= 0 && !finded; i--) {
                List<TreeNode> treeNodes = list.get(i);
                for (TreeNode treeNode : treeNodes) {
                    if (findKeyInBST(treeNode, p) != null && findKeyInBST(treeNode, q) != null) {
                        finded = true;
                        result = treeNode;
                        break;
                    }
                }
            }
            return result;
        }

        public TreeNode findKeyInBST(TreeNode root, TreeNode k) {
            while (root != null) {
                if (root == k) {
                    return root;
                }
                if (root.val > k.val) {
                    root = root.left;
                } else if (root.val < k.val) {
                    root = root.right;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
