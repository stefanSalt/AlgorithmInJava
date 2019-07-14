package LeetCode;
import java.util.ArrayList;
import java.util.List;

public class L118PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> llist = new ArrayList<>();
		if (numRows == 0)
			return llist;
		int[] q = { 1, 7, 9 };
		int[][] arr = new int[numRows][];
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();
			arr[i] = new int[i + 1];
			arr[i][0] = 1;
			arr[i][i] = 1;
			list.add(arr[i][0]);

			for (int j = 1; j < i; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				list.add(arr[i][j]);
			}
			if (i != 0)
				list.add(arr[i][i]);
			llist.add(list);

		}
		return llist;
	}
}
