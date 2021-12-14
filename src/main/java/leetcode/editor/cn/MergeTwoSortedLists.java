//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表 👍 2090 👎 0


package leetcode.editor.cn;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();

        ListNode listNode_1_1 = new ListNode(1);
        ListNode listNode_1_2 = new ListNode(2);
        ListNode listNode_1_4 = new ListNode(4);

        listNode_1_1.next = listNode_1_2;
        listNode_1_2.next = listNode_1_4;

        ListNode listNode_2_1 = new ListNode(1);
        ListNode listNode_2_3 = new ListNode(3);
        ListNode listNode_2_4 = new ListNode(4);

        listNode_2_1.next = listNode_2_3;
        listNode_2_3.next = listNode_2_4;

        ListNode actual = solution.mergeTwoLists(listNode_1_1, listNode_2_1);
        while (actual != null) {
            System.out.println(actual.val + " ");
            actual = actual.next;
        }

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            ListNode prevhead = new ListNode(-1);
            ListNode prev = prevhead;

            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    prev.next = list2;
                    list2 = list2.next;
                } else {
                    prev.next = list1;
                    list1 = list1.next;
                }
                prev = prev.next;
            }
            // 当其中一个链表为空的时候,把另外一个链表剩下的直接接上就行了
            prev.next = list1 == null ? list2 : list1;
            return prevhead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
