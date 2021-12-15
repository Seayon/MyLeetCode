//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：[2,1]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
//
// Related Topics 递归 链表 👍 2146 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        MyLeetCodeUtil.printListNode(solution.reverseList(MyLeetCodeUtil.createSimpleListNode()));
        MyLeetCodeUtil.printListNode(solution.reverseList(MyLeetCodeUtil.createNullListNode()));
        MyLeetCodeUtil.printListNode(solution.reverseList(MyLeetCodeUtil.createOneListNode()));

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
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            Stack<ListNode> stack = new Stack<>();
            while (head != null) {
                ListNode tmp = head;
                head = head.next;
                tmp.next = null;
                stack.push(tmp);
            }
            head = stack.pop();
            ListNode first = head;
            while (!stack.empty()) {
                head.next = stack.pop();
                head = head.next;
            }
            return first;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
