package leetcode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 
 * 说明：不允许修改给定的链表。
 * 
 */
public class L142LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode fast = head;
		ListNode slow = head;

		// 寻找相遇点
		while (fast != null && fast.next != null) {

			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast)
				break;
		}

		// 无环，退出
		if (fast == null || fast.next == null)
			return null;

		// 从相遇点到入环的第一个节点的距离等于从head到入环的第一个节点的距离相等
		ListNode nListNode = head;
		while (nListNode != slow) {
			slow = slow.next;
			nListNode = nListNode.next;
		}
		return nListNode;
	}
}
