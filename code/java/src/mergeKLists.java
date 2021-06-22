/**
 23. 合并K个升序链表
 给你一个链表数组，每个链表都已经按升序排列。

 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 示例 1：

 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 输出：[1,1,2,3,4,4,5,6]
 解释：链表数组如下：
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 将它们合并到一个有序链表中得到。
 1->1->2->3->4->4->5->6
 示例 2：

 输入：lists = []
 输出：[]
 示例 3：

 输入：lists = [[]]
 输出：[]


 提示：

 k == lists.length
 0 <= k <= 10^4
 0 <= lists[i].length <= 500
 -10^4 <= lists[i][j] <= 10^4
 lists[i] 按 升序 排列
 lists[i].length 的总和不超过 10^4
 **/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 暴力法，直接遍历
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        head = null;
        for (int i=0;i < lists.length;i++){
            head = recursionMerge(head,lists[i]);
        }
        return head;
    }

    public ListNode recursionMerge(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        if (l1.val < l2.val){
            l1.next = recursionMerge(l1.next,l2);
            return l1;
        }else{
            l2.next = recursionMerge(l1,l2.next);
            return  l2;
        }
    }
}