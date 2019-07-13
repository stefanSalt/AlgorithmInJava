import java.util.ArrayList;
import java.util.List;

public class L54SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		int row = matrix.length;
		if (row == 0)
			return list;
		int col = matrix[0].length;
		int n = 2;
		int circle = 0;
		int times = ((row < col ? row : col) - 1) / 2 + 1;
		while (circle < times) {
			for (int i = circle; i < col - circle; i++)
				list.add(matrix[circle][i]);

			for (int i = circle + 1; i < row - circle; i++)
				list.add(matrix[i][col - 1 - circle]);

			for (int i = col - 2 - circle; (i >= circle) && (row - 1 - circle != circle); i--)
				list.add(matrix[row - 1 - circle][i]);

			for (int i = row - 2 - circle; (i > circle) && (col - 1 - circle != circle); i--)
				list.add(matrix[i][circle]);
			circle++;
		}
		return list;
	}
}
