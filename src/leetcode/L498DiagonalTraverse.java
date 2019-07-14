package leetcode;

public class L498DiagonalTraverse {
	public static int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0)
			return new int[0];
		int rowlen = matrix.length;
		int collen = matrix[0].length;
		int i = 0, j = 0;
		int arr[] = new int[rowlen * collen];

		int index = 0;
		for (; index < arr.length; index++) {
			arr[index] = matrix[i][j];
			if (((i + j) & 1) == 0) {// 向右上走時i+j只和为偶数
				if (j == collen - 1) {// 最后一列，向下走
					i++;
				} else if (i == 0) {
					j++;
				} else {
					i--;
					j++;
				}

			} else {
				if (i == rowlen - 1) {// 第一列，向下走
					j++;
				} else if (j == 0) {
					i++;
				} else {
					i++;
					j--;
				}
			}

		}
		return arr;
	}
}
