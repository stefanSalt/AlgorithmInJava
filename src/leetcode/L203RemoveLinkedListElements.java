package leetcode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * 
 * 示例:
 * 
 * 输入: 1->2->6->3->4->5->6, val = 6 输出: 1->2->3->4->5
 * 
 * @author stefa
 *
 */
public class L203RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode nhead = new ListNode(0);
		nhead.next = head;
		ListNode cur = nhead;
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else
				cur = cur.next;
		}
		return nhead.next;

	}
}
