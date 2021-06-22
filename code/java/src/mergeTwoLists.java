/**
 21. 合并两个有序链表
 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。



 示例 1：


 输入：l1 = [1,2,4], l2 = [1,3,4]
 输出：[1,1,2,3,4,4]
 示例 2：

 输入：l1 = [], l2 = []
 输出：[]
 示例 3：

 输入：l1 = [], l2 = [0]
 输出：[0]


 提示：

 两个链表的节点数目范围是 [0, 50]
 -100 <= Node.val <= 100
 l1 和 l2 均按 非递减顺序 排列
 **/

class Solution {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //判断特殊情况，并使用递归思想
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }

        ListNode head = new ListNode();
        ListNode pre1 = new ListNode();
        ListNode pre2 = new ListNode();

        if(l1.val < l2.val){
            head = l1;
            pre1 = l1;
            pre2 = l2;
        }else{
            head = l2;
            pre1 = l2;
            pre2 = l1;
        }

        while (pre1.next !=null && pre2 != null){
            if (pre1.next.val < pre2.val){
                pre1 = pre1.next;
            }else{
                ListNode tmp = new ListNode();
                tmp = pre2;
                pre2 = pre1.next;
                pre1.next = tmp;
                pre1 = pre1.next;
            }
        }

        pre1.next = pre2;

        return head;
    }
}