package sort;

public class BubbleSort {
	public static int[] BubbleSort(int[] arr) {
		// TODO Auto-generated constructor stub
		if (arr.length == 0)
			return arr;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int a[] = { 1, 4, 5, 7, 8, 2, 9, 3, 6 };
		a = BubbleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
}
