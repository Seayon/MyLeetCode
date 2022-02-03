//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1730 👎 0


package leetcode.editor.cn;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode[] listNodes = new ListNode[]{
                MyLeetCodeUtil.createListNodeByArray(new int[]{1, 4, 5}),
                MyLeetCodeUtil.createListNodeByArray(new int[]{1, 3, 4}),
                MyLeetCodeUtil.createListNodeByArray(new int[]{2, 6}),
        };
        ListNode listNode = solution.mergeKLists(listNodes);
        MyLeetCodeUtil.printListNode(listNode);

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
        public ListNode mergeKLists(ListNode[] lists) {
            return solution1(lists);
        }


        public ListNode solution1(ListNode[] lists) {
            ListNode tmp = null;
            for (int i = 0; i < lists.length; i++) {
                tmp = merge(tmp, lists[i]);
            }
            return tmp;
        }

        public ListNode merge(ListNode listNode1, ListNode listNode2) {
            ListNode result = new ListNode();
            ListNode p = result;
            while (listNode1 != null && listNode2 != null) {
                if (listNode1.val < listNode2.val) {
                    p.next = listNode1;
                    listNode1 = listNode1.next;
                } else {
                    p.next = listNode2;
                    listNode2 = listNode2.next;
                }
                p = p.next;
            }
            if (listNode1 != null) {
                p.next = listNode1;
            }
            if (listNode2 != null) {
                p.next = listNode2;
            }
            return result.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
