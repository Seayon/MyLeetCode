//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
//
//
//
// 进阶：你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针 👍 1772 👎 0


package leetcode.editor.cn;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        MyLeetCodeUtil.printListNode(solution.removeNthFromEnd(MyLeetCodeUtil.createSimpleListNode(), 2));
        MyLeetCodeUtil.printListNode(solution.removeNthFromEnd(MyLeetCodeUtil.createSimpleListNode(), 1));
        MyLeetCodeUtil.printListNode(solution.removeNthFromEnd(MyLeetCodeUtil.createSimpleListNode(), 2));
        MyLeetCodeUtil.printListNode(solution.removeNthFromEnd(MyLeetCodeUtil.createSimpleListNode(), 3));
        MyLeetCodeUtil.printListNode(solution.removeNthFromEnd(MyLeetCodeUtil.createSimpleListNode(), 4));
        MyLeetCodeUtil.printListNode(solution.removeNthFromEnd(MyLeetCodeUtil.createSimpleListNode(), 5));
        MyLeetCodeUtil.printListNode(solution.removeNthFromEnd(MyLeetCodeUtil.createListNodeByArray(new int[]{1}), 1));
        MyLeetCodeUtil.printListNode(solution.removeNthFromEnd(MyLeetCodeUtil.createListNodeByArray(new int[]{1, 2}), 2));
        MyLeetCodeUtil.printListNode(solution.removeNthFromEnd(MyLeetCodeUtil.createListNodeByArray(new int[]{1, 2}), 1));
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 哑元节点
            ListNode dummyHead = new ListNode(0, head);
            ListNode first = head;
            ListNode second = dummyHead;
            int i = 0;
            while (i < n) {
                first = first.next;
                ++i;
            }
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
