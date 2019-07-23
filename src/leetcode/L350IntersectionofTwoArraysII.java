package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2,2] 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [4,9] 说明：
 * 
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 我们可以不考虑输出结果的顺序。 进阶:
 * 
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？ 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 
 * 
 * @author stefa
 *
 */
public class L350IntersectionofTwoArraysII {
	/*
	 * 遍历nums1,使用hashmap存储各元素和出现次数 遍历nums2，map中找到的元素加入到list中，，作为结果输出
	 */
	public int[] intersect(int[] nums1, int[] nums2) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// 先遍历第一个数组，并初始化map
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i]))
				map.put(nums1[i], map.get(nums1[i]) + 1);
			else
				map.put(nums1[i], 1);
		}

		// 再遍历第二个数组，将于map中找到的key放入list中
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int j = 0; j < nums2.length; j++) {
			if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
				list.add(nums2[j]); // 添加到list中
				map.put(nums2[j], map.get(nums2[j]) - 1);
			}
		}

		// 最后，将list中的值放入数组中
		int count = list.size();
		int[] aux = new int[count];
		for (int i = 0; i < count; i++) {
			aux[i] = list.poll();
		}
		return aux;

	}

	/*
	 * 先将两数组排序，使用双指针分别指向两数组的元素并进行比对
	 */
	public int[] intersect2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0;
		List<Integer> list = new ArrayList<Integer>();
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}

		// list转化为数组并作为返回值返回
		int[] res = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			res[k] = list.get(k);
		}
		return res;
	}
}
