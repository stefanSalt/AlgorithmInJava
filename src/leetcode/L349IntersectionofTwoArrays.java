package leetcode;

import java.util.HashSet;
import java.util.Iterator;

/*
 * �����������飬��дһ���������������ǵĽ�����
 * 
 * ʾ�� 1:
 * 
 * ����: nums1 = [1,2,2,1], nums2 = [2,2] ���: [2] ʾ�� 2:
 * 
 * ����: nums1 = [4,9,5], nums2 = [9,4,9,8,4] ���: [9,4] ˵��:
 * 
 * �������е�ÿ��Ԫ��һ����Ψһ�ġ� ���ǿ��Բ�������������˳��
 * 
 */
public class L349IntersectionofTwoArrays {
	/*
	 * ��hashset�洢nums1���ֹ������֣�����nums2�����nums2[2]������hashSet�У���nums2[i]Ϊ����Ԫ��
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			hashSet.add(nums1[i]);
		}
		HashSet<Integer> hashSet2 = new HashSet<>();
		for (int i = 0; i < nums2.length; i++) {
			if (hashSet.contains(nums2[i])) {
				hashSet2.add(nums2[i]);
			}
		}
		int arr[] = new int[hashSet2.size()];
		int i = 0;
		for (Iterator iterator = hashSet2.iterator(); iterator.hasNext();) {
			arr[i++] = (int) iterator.next();

		}
		return arr;
	}
}
