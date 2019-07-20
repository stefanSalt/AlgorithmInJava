package leetcode;

/*
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��

ʾ��:

����: [0,1,0,3,12]
���: [1,3,12,0,0]
˵��:

������ԭ�����ϲ��������ܿ�����������顣
�������ٲ���������
 */
public class L283MoveZero {
	/*
	 * ˫ָ��
	 */
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
		}
		for (int i = j; j < nums.length; j++)
			nums[j] = 0;
		return;
	}
}
