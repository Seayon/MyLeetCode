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
            ListNode listNodeResult = new ListNode(0);
            ListNode listNodel1Temp = l1;
            ListNode listNodel2Temp = l2;
            ListNode listNodeResultTemp = listNodeResult;
            int tempAdd = 0;
            while (listNodel1Temp != null || listNodel2Temp != null) {
                int val1 = listNodel1Temp == null ? 0 : listNodel1Temp.val;
                int val2 = listNodel2Temp == null ? 0 : listNodel2Temp.val;
                int val = val1 + val2 + tempAdd;
                tempAdd = val / 10;//取整数，作为进位，下一轮相加所用的
                listNodeResultTemp.next = new ListNode(val % 10);//求余数，作为本位留下来的
                listNodeResultTemp = listNodeResultTemp.next;
                //继续指向下一位的操作
                if (listNodel1Temp != null) {
                    listNodel1Temp = listNodel1Temp.next;
                }
                if (listNodel2Temp != null) {
                    listNodel2Temp = listNodel2Temp.next;
                }
            }
            if (tempAdd > 0) {
                listNodeResultTemp.next = new ListNode(tempAdd);
            }
            return listNodeResult.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
