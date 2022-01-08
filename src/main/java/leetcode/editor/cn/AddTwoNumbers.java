//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学 👍 7323 👎 0


package leetcode.editor.cn;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Stack;

import static leetcode.editor.cn.MyLeetCodeUtil.*;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        Assertions.assertEquals(true, MyLeetCodeUtil.checkListNodeSame(solution.addTwoNumbers(createListNodeByArray(new int[]{5, 5}), createListNodeByArray(new int[]{5, 5})), createListNodeByArray(new int[]{0, 1, 1})));
        Assertions.assertEquals(true, MyLeetCodeUtil.checkListNodeSame(solution.addTwoNumbers(createListNodeByArray(new int[]{5}), createListNodeByArray(new int[]{5})), createListNodeByArray(new int[]{0, 1})));
        Assertions.assertEquals(true, checkListNodeSame(solution.addTwoNumbers(createListNodeByArray(new int[]{9, 9, 1}), createListNodeByArray(new int[]{1})), createListNodeByArray(new int[]{0, 0, 2})));
        Assertions.assertEquals(true, checkListNodeSame(solution.addTwoNumbers(createListNodeByArray(new int[]{2, 4, 9}), createListNodeByArray(new int[]{5, 6, 4, 9})), createListNodeByArray(new int[]{7, 0, 4, 0, 1})));
        Assertions.assertEquals(true, checkListNodeSame(solution.addTwoNumbers(createListNodeByArray(new int[]{2, 4, 3}), createListNodeByArray(new int[]{5, 6, 4})), createListNodeByArray(new int[]{7, 0, 8})));
        Assertions.assertEquals(true, checkListNodeSame(solution.addTwoNumbers(createListNodeByArray(new int[]{9, 8, 5, 4, 3}), createListNodeByArray(new int[]{3, 7, 8})), createListNodeByArray(new int[]{2, 6, 4, 5, 3})));
        Assertions.assertEquals(true, checkListNodeSame(solution.addTwoNumbers(createListNodeByArray(new int[]{9, 9, 9, 9, 9, 9, 9}), createListNodeByArray(new int[]{9, 9, 9, 9})), createListNodeByArray(new int[]{8, 9, 9, 9, 0, 0, 0, 1})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1, p2 = l2;
            ListNode result = new ListNode();
            ListNode reP = result;
            ListNode pre = reP;
            int increase = 0;
            while (p1 != null && p2 != null) {
                int val = p1.val + p2.val + increase;
                if (val > 9) {
                    reP.val = val - 10;
                    increase = 1;
                } else {
                    reP.val = val;
                    increase = 0;
                }
                p1 = p1.next;
                p2 = p2.next;
                reP.next = new ListNode();
                pre = reP;
                reP = reP.next;
            }
            if (p1 == null && p2 == null && increase > 0) {
                pre.next = new ListNode(increase);
                return result;
            }
            //拼接剩下的
            ListNode notNull = p1 == null ? p2 : p1;
            pre.next = notNull;
            // 如果下面有进位上来的,要进行计算
            if (increase != 0) {
                ListNode notNullTmp = notNull;
                while (notNullTmp != null) {
                    int i = notNullTmp.val + increase;
                    if (i > 9) {
                        notNullTmp.val = i - 10;
                        increase = 1;
                        if (notNullTmp.next == null) {
                            notNullTmp.next = new ListNode(0);
                        }
                        notNullTmp = notNullTmp.next;
                    } else {
                        notNullTmp.val = i;
                        break;
                    }

                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
