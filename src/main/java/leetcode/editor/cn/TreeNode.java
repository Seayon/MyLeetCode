package leetcode.editor.cn;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage leetcode.editor.cn.entiy
 * @Copyleft 2013-3102
 * @Author: SaeyonZhao
 * @Date: 2021/12/17 10:01 上午
 * @Version V1.0
 * @Description: Definition for a binary tree node.
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

