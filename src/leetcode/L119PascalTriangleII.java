package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class L119PascalTriangleII {
	/*
	 * 通过公式a[i][j]=a[i-1][j-1]+a[i-1][j]来计算除头和尾两个1除外的数字 上一题使用二维数组来存放数字，这次只要求第k行数字
	 * 只需使用一个数组通过迭代获取第k行数字
	 * 
	 * 注意：因为用单行数组存放，所以a[i][j]会覆盖掉a[i-1][j],在计算a[i][j+1]时，a[i-1][j]已经被覆盖掉了，从而求得错误结果
	 * 所以要用逆序，从后向前计算
	 */
	public List<Integer> getRow(int rowIndex) {
		int r[] = new int[rowIndex];
		r[0] = 1;
		for (int i = 0; i <= rowIndex; i++) {
			r[i] = 1;
			for (int j = 1; j < rowIndex; j++) {
				r[j] = r[j - 1] + r[j];
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < r.length; i++) {
			list.add(r[i]);
		}
		return list;
	}
}
