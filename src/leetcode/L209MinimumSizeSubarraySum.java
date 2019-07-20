package leetcode;

/*
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

示例: 

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class L209MinimumSizeSubarraySum {
	/*
	 * 思路一：纯暴力破解
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
	 * 思路二：暴力破解改良 内层循环求子数组和时有很多重复计算，可以用数组sums来存放子数组和
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
	 * 思路三：继续对思路二进行优化，查找过程改为二分查找
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
	 * 双指针，双指针用来确定子数组两端，都初始化为0，从数组头开始遍历
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
