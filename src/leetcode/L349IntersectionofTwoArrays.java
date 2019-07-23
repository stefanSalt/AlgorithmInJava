package leetcode;

import java.util.HashSet;
import java.util.Iterator;

/*
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2] 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [9,4] 说明:
 * 
 * 输出结果中的每个元素一定是唯一的。 我们可以不考虑输出结果的顺序。
 * 
 */
public class L349IntersectionofTwoArrays {
	/*
	 * 用hashset存储nums1出现过的数字，遍历nums2，如果nums2[2]出现在hashSet中，则nums2[i]为交集元素
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
