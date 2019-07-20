package leetcode;

/*
 * ����һ������ n ���������������һ�������� s ���ҳ���������������� �� s �ĳ�����С�����������顣��������ڷ������������������飬���� 0��

ʾ��: 

����: s = 7, nums = [2,3,1,2,4,3]
���: 2
����: ������ [4,3] �Ǹ������µĳ�����С�����������顣
 */
public class L209MinimumSizeSubarraySum {
	/*
	 * ˼·һ���������ƽ�
	 */
	public int minSubArrayLen1(int s, int[] nums) {
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += nums[k];
				}
				if (sum >= s) {
					minLen = Math.min(minLen, j - i + 1);
					break;
				}
			}

		}

		return Integer.MAX_VALUE == minLen ? 0 : minLen;
	}

	/*
	 * ˼·���������ƽ���� �ڲ�ѭ�����������ʱ�кܶ��ظ����㣬����������sums������������
	 */
	public int minSubArrayLen2(int s, int[] nums) {
		int minLen = Integer.MAX_VALUE;
		int sums[] = new int[nums.length];
		sums[0] = nums[0];
		for (int i = 1; i < sums.length; i++) {
			sums[i] += sums[i - 1] + nums[i];
		}
		for (int i = 0; i < sums.length; i++) {
			for (int j = i; j < sums.length; j++) {
				int sum = sums[j] - sums[i] + nums[i];
				if (sum >= s) {
					minLen = Math.min(minLen, j - i + 1);
					break;
				}
			}
		}

		return Integer.MAX_VALUE == minLen ? 0 : minLen;
	}

	/*
	 * ˼·����������˼·�������Ż������ҹ��̸�Ϊ���ֲ���
	 */
	public int minSubArrayLen3(int s, int[] nums) {
		int minLen = Integer.MAX_VALUE;
		int sums[] = new int[nums.length];
		sums[0] = nums[0];
		for (int i = 1; i < sums.length; i++) {
			sums[i] += sums[i - 1] + nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			int target = s + (i == 0 ? 0 : sums[i - 1]);
			int j = findWindowEnd(i, sums, target);
			if (j != nums.length) {
				minLen = Math.min(minLen, j - i + 1);
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	private int findWindowEnd(int start, int[] sums, int target) {
		int left = start;
		int right = sums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (sums[mid] == target) {
				return mid;
			} else if (sums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	/*
	 * ˫ָ�룬˫ָ������ȷ�����������ˣ�����ʼ��Ϊ0��������ͷ��ʼ����
	 */
	public int minSubArrayLen4(int s, int[] nums) {
		int minLen = Integer.MAX_VALUE;
		int sum = 0;
		int left = 0;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (sum >= s) {
				minLen = Math.min(minLen, right - left + 1);
				sum -= nums[left++];
			}
		}
		return Integer.MAX_VALUE == minLen ? 0 : minLen;
	}
}
