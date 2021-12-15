package leetcode.editor.cn;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage leetcode.editor.cn
 * @Copyleft 2013-3102
 * @Author: SaeyonZhao
 * @Date: 2021/12/15 12:13 下午
 * @Version V1.0
 * @Description:
 */

public class MyLeetCodeUtil {
    public static ListNode createNullListNode() {
        return null;
    }
    public static ListNode createOneListNode() {
        return new ListNode(3);
    }

    public static ListNode createListNodeByArray(int[] ints) {
        if (ints == null || ints.length == 0) {
            return null;
        }
        ListNode listNode = new ListNode(ints[0]);
        ListNode tmp = listNode;
        for (int i = 1; i < ints.length; i++) {
            int anInt = ints[i];
            ListNode newNode = new ListNode(anInt);
            tmp.next = newNode;
            tmp = tmp.next;
        }
        return listNode;
    }
    public static ListNode createSimpleListNode() {
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
        return listNode1;
    }

    public static void printListNode(ListNode listNode) {
        if (listNode == null) {
            System.out.println("ListNode: " + listNode);
            return;
        }
        checkListNodeCycle(listNode);
        StringBuilder stringBuilder = new StringBuilder();
        while (listNode != null) {
            stringBuilder.append(listNode.val);
            stringBuilder.append(" -> ");
            listNode = listNode.next;
        }
        int i = stringBuilder.lastIndexOf(" -> ");
        stringBuilder.replace(i, stringBuilder.length(), "");
        System.out.println("ListNode: " + new String(stringBuilder));
    }

    public static void checkListNodeCycle(ListNode listNode) {
        LinkedListCycle.Solution solution = new LinkedListCycle().new Solution();
        boolean b = solution.hasCycle(listNode);
        if (b) {
            throw new RuntimeException("这个链表有环,停止运行");
        }

    }
}
