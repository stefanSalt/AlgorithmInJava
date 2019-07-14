package sort;

public class InsertionSort {
	public static int[] InsertionSort(int[] arr) {
		// TODO Auto-generated constructor stub
		if (arr.length == 0)
			return arr;
		int s = 0;
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > current) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					s++;
				}
			}
		}
		System.out.println(s);
		return arr;
	}

	public static void main(String[] args) {
		int a[] = { 1, 4, 5, 7, 8, 2, 9, 21, 13, 3, 6, 99, 54, 3, 6, 11, 10, 6, 5, 18, };
		a = InsertionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}

}
