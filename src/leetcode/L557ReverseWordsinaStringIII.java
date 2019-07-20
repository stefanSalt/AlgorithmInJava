package leetcode;

/*
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class L557ReverseWordsinaStringIII {
	/*
	 * 从字符串逐个读字符，读取到空格停下，将之前子串逆序写到StringBuffer中，添加空格，继续循环，直到到达末尾
	 */
	public static String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		int j = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			j = -1;
			while (i + j + 1 < s.length() && s.charAt(i + j + 1) != ' ') {
				j++;
			}
			int k = i;
			i = i + j + 1;
			for (; j >= 0; j--) {
				sb.append(s.charAt(k + j));
			}
			sb.append(' ');

		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();

	}

	/*
	 * 将字符串转化为字符数组，双指针定位单词，从单词两端对位交换，完成单词逆序
	 */
	public static String reverseWords2(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		char[] chars = s.toCharArray();
		int i = 0, j = 0;
		while (i < chars.length) {
			j = i;
			while (j < chars.length && chars[j] != ' ')
				j++;// 定位单词末尾
			reverse(chars, i, j - 1);
			i = j + 1;
		}
		return String.valueOf(chars);
	}

	public static void reverse(char[] chars, int left, int right) {
		while (left < right) {
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		String string = "Let's take LeetCode contest";
		System.out.println(reverseWords(string));
		System.out.println(reverseWords2(string));
	}
}
