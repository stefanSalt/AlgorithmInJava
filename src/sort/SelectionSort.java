package sort;

public class SelectionSort {
	public static int[] SelectionSort(int[] arr) {
		// TODO Auto-generated constructor stub
		if (arr.length == 0)
			return arr;
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		int a[] = { 1, 4, 5, 7, 8, 2, 9, 3, 6 };
		a = SelectionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
}
