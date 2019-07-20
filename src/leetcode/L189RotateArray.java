/*
 * ����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����

ʾ�� 1:

����: [1,2,3,4,5,6,7] �� k = 3
���: [5,6,7,1,2,3,4]
����:
������ת 1 ��: [7,1,2,3,4,5,6]
������ת 2 ��: [6,7,1,2,3,4,5]
������ת 3 ��: [5,6,7,1,2,3,4]
ʾ�� 2:

����: [-1,-100,3,99] �� k = 2
���: [3,99,-1,-100]
����: 
������ת 1 ��: [99,-1,-100,3]
������ת 2 ��: [3,99,-1,-100]
 */
package leetcode;

public class L189RotateArray {
	/*
	 * ����Ԫ������k����λ֮������ԭ���ĺ�k%len��Ԫ�ر��ƶ���������ˣ� �ȼ��������k%len��Ԫ�ط�ת���ٷ�תʣ�µ�Ԫ�أ��ٷ�ת��������
	 * 
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

	public static void main(String[] args) {
		int nums[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		L189RotateArray l189RotateArray = new L189RotateArray();
		l189RotateArray.rotate(nums, 3);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}
}
