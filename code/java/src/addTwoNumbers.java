/**
 * 2. 两数相加
 *给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *     输入：
 *       2->4->3->null
 *       5->6->4->null
 *     输出:
 *       7->0->8->null
 */

/**
 * 思路1：将链表转换为整数，然后相加之后的数再转换为链表
 * 思路2：依次遍历两个链表，然后按位求和，将求和的结果插入到新链表尾部，有进位的标记 flag，计入到下一位求和，最后得到新链表
 */

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int num1 = 0;
            int num2 = 0;
            int sum = 0;
            if (l1 != null) num1 = l1.val;
            if (l2 != null) num2 = l2.val;
                sum = num1 + num2 + flag;
                flag = sum / 10;
            if (head == null) {
                tail = head = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10, null);
                tail = tail.next;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (flag > 0) {
             tail.next = new ListNode(flag, null);
        }
        return head;
}

/**
 * node 节点
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
