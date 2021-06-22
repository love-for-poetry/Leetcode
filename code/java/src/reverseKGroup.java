/**
 25. K 个一组翻转链表
 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

 k 是一个正整数，它的值小于或等于链表的长度。

 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 进阶：

 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。


 示例 1：


 输入：head = [1,2,3,4,5], k = 2
 输出：[2,1,4,3,5]
 示例 2：


 输入：head = [1,2,3,4,5], k = 3
 输出：[3,2,1,4,5]
 示例 3：

 输入：head = [1,2,3,4,5], k = 1
 输出：[1,2,3,4,5]
 示例 4：

 输入：head = [1], k = 1
 输出：[1]
 提示：

 列表中节点的数量在范围 sz 内
 1 <= sz <= 5000
 0 <= Node.val <= 1000
 1 <= k <= sz
 **/

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = head;
        ListNode node = head.next;
        ListNode next;
        //两条尾指针分别记录当前链表表尾指针和上条链表尾指针
        ListNode tail1 = head;
        ListNode tail2 = null;
        //用来返回最终链表头部
        ListNode reNode = null;
        int n = 1;
        int flag = 0;
        //遍历翻转链表，若 node 到 k 的倍数节点，需要剪断链表，存入arr，然后将尾指针存入hash
        while (node != null){
            next = node.next;
            if (n % k == 0){
                node.next = null;
                if(flag > 0) {
                    tail1.next = pre;
                    tail1 = tail2;
                }else{ //第一段链表头就是最终需要返回的链表头部
                    reNode = pre;
                }
                tail2 = node;
                flag++;
            }else{
                node.next = pre;
            }
            pre = node;
            node = next;
            n++;
        }

        //若最后一段的链表长度小于k，则不需要翻转，那么之前翻转的需要再反转回去
        if(n % k == 0){
            if (n == k){//总长度刚好等于k，直接返回，但头节点还没置为 null
                head.next = null;
                return pre;
            }
            tail1.next = pre;
        }else{
            ListNode pre1 = pre;
            ListNode node1 = pre.next;

            while (node1 != null){
                next = node1.next;
                node1.next = pre1;
                pre1 = node1;
                node1 = next;
            }
            pre.next = null;

            if (n < k){
                head.next = null;
                return pre1;
            }
            tail1.next = pre1;
        }

        return reNode;
    }
}