//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
//
//
// 示例 2：
//
//
//输入：head = [], val = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [7,7,7,7], val = 7
//输出：[]
//
//
//
//
// 提示：
//
//
// 列表中的节点数目在范围 [0, 10⁴] 内
// 1 <= Node.val <= 50
// 0 <= val <= 50
//
// Related Topics 递归 链表 👍 759 👎 0


package leetcode.editor.cn;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6_2 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode6;
        listNode6.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6_2;
        // ListNode listNode = solution.removeElements(listNode1, 6);
        // ListNode listNode = solution.removeElements(null, 1);
        // while (listNode != null) {
        //     System.out.println(listNode.val + " ");
        //     listNode = listNode.next;
        // }

        ListNode listNode7_1 = new ListNode(7);
        ListNode listNode7_2 = new ListNode(7);
        ListNode listNode7_3 = new ListNode(7);
        ListNode listNode7_4 = new ListNode(7);
        listNode7_1.next = listNode7_2;
        listNode7_2.next = listNode7_3;
        listNode7_3.next = listNode7_4;
        listNode7_4.next = null;

        ListNode listNode = solution.removeElements(listNode7_1, 7);
        while (listNode != null) {
            System.out.println(listNode.val + " ");
            listNode = listNode.next;
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
        public ListNode removeElements(ListNode head, int val) {
            //创建一个哑元节点,将它的下一个节点指向 head,一边从 head 开始遍历,使用这个哑元节点来一点点往后指
            // dummy
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode tmp = dummy;
            while (tmp.next != null) {
                if (tmp.next.val == val) {
                    tmp.next = tmp.next.next;
                } else {
                    tmp = tmp.next;
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
