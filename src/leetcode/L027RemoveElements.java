package leetcode;
/*
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1:

给定 nums = [3,2,2,3], val = 3,

函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,1,2,2,3,0,4,2], val = 2,

函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

注意这五个元素可为任意顺序。

你不需要考虑数组中超出新长度后面的元素。
*/

public class L027RemoveElements {
	/*
	 * 思路1：双指针，元素顺序可以改变，用两个指针分别从两端开始向中间逼近， 左指针遇见等于val的时候停下，与数组末尾元素交换，数组长度减一，如
	 * 此循环，直到两指针相遇。
	 */
	public int removeElement(int[] nums, int val) {
		int i = 0;
		int j = nums.length;
		while (i < j) {
			if (nums[i] == val) {
				nums[i] = nums[j - 1];
				j--;
			} else
				i++;

		}
		return j;
	}

	/*
	 * 思路2：双指针，快指针i负责遍历数组元素，，慢指针j记录遍历过的不等于val的 值，当num[i]!=val时，num[j]=num[i];
	 */
	public int removeElement2(int[] nums, int val) {
		int i = 0;
		int j = 0;
		while (i < nums.length) {
			if (nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}
			i++;
		}
		return j;
	}
}
