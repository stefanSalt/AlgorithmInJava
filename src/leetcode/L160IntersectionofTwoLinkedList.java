package leetcode;

/*
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class L160IntersectionofTwoLinkedList {
	/*
	 * 
	 * 这里设定两个指针分别指向两个链表头，向后遍历，到达末尾时接到另一链表头继续遍历，两节点相遇时正好为交点
	 * 假设链表a在交点之前的长度为a，链表b在相遇之前的长度为b，公共段长度为c，
	 * 由题可知，两链表差别在相交之前的部分，两指针分别遍历两链表在继续遍历另一链表， 这样在相遇之前，两指针走过的路程都为a+b+c，抹除了两链表的长度差
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode p1 = headA;
		ListNode p2 = headB;
		while (p1 != p2) {
			p1 = p1 == null ? headB : p1.next;
			p2 = p2 == null ? headA : p2.next;
		}
		return p1;
	}

}
