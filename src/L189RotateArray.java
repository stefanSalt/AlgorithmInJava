/*
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
 */
public class L189RotateArray {
	/*
	 * 数组元素右移k个单位之后，数组原本的后k%len个元素被移动到数组左端， 等价于数组后k%len个元素反转，再反转剩下的元素，再反转整个数组
	 * 这个思路真的是太强了！
	 */
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return;
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);

	}

	public static void reverse(int[] arr, int left, int right) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

	public void rotate2(int[] nums, int k) {
		k %= nums.length;
		for (int i = 0; i < k; i++) {
			int temp = nums[nums.length - i - 1];
			for (int j = nums.length - 1; j >= k; j -= k) {
				nums[j] = nums[j - k];
			}
			nums[i] = temp;
		}
	}

	public static void main(String[] args) {
		int nums[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		L189RotateArray l189RotateArray = new L189RotateArray();
		l189RotateArray.rotate2(nums, 3);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}
}
