package main

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

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var head, tail *ListNode
	flag := 0
	for l1 != nil || l2 != nil {
		num1, num2, sum := 0, 0, 0
		if l1 != nil {
			num1 = l1.Val
		}
		if l2 != nil {
			num2 = l2.Val
		}

		sum = num1 + num2 + flag
		flag = sum / 10
		if head == nil {
			head = &ListNode{Val: sum % 10, Next: nil}
			tail = &ListNode{Val: sum % 10, Next: nil}
		} else {
			tail.Next = &ListNode{Val: sum % 10, Next: nil}
			tail = tail.Next
		}

		if l1 != nil {
			l1 = l1.Next
		}
		if l2 != nil {
			l2 = l2.Next
		}
	}

	if flag > 0 {
		tail.Next = &ListNode{Val: flag, Next: nil}
	}
	return head
}
