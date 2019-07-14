package LeetCode;

public class L028ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		int m = haystack.length();
		int n = needle.length();
		if (m < n)
			return -1;
		int flag = 1;
		for (int i = 0; i <= m - n; i++) {
			flag = 1;
			for (int j = 0; j < n; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					flag = 0;
					break;
				}
			}
			if (flag == 1)
				return i;
		}
		return -1;
	}
}
