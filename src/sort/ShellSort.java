package sort;

public class ShellSort {
	public static int[] ShellSort(int[] arr) {
		// TODO Auto-generated constructor stub
		if (arr.length == 0)
			return arr;
		int s = 0;
		int gap = arr.length / 2;
		while (gap > 0) {
			for (int i = 0; i < arr.length; i += gap) {
				int current = arr[i];
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > current) {
						int temp = arr[j + gap];
						arr[j + gap] = arr[j];
						arr[j] = temp;
						s++;
					}
				}
			}
			gap /= 2;
		}
		System.out.println(s);
		return arr;
	}

	public static void main(String[] args) {
		int a[] = { 1, 4, 5, 7, 8, 2, 9, 21, 13, 3, 6, 99, 54, 3, 6, 11, 10, 6, 5, 18, };
		a = ShellSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
}
