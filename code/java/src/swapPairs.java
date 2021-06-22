/**
 24. 两两交换链表中的节点
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



 示例 1：


 输入：head = [1,2,3,4]
 输出：[2,1,4,3]
 示例 2：

 输入：head = []
 输出：[]
 示例 3：

 输入：head = [1]
 输出：[1]


 提示：

 链表中节点的数目在范围 [0, 100] 内
 0 <= Node.val <= 100
 **/
class Solution {
    /**
     * 遍历链表
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode();
        node = head;
        int n = 1;
        while (node != null && node.next != null){
            if (n % 2 == 1){
                int tmp = node.val;
                node.val = node.next.val;
                node.next.val = tmp;
            }
            node = node.next;
            n++;
        }
        return head;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = new ListNode();
        next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }

}