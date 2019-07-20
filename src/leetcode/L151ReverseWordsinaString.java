package leetcode;

import java.util.Arrays;
import java.util.Stack;

/*
 * 给定一个字符串，逐个翻转字符串中的每个单词。

 

示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 

说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。


 */
public class L151ReverseWordsinaString {
	/*
	 * 利用栈来存储单词，然后逐个弹出，拼成新的字符串 注意：字符串开头可能有空格，要先处理开头的空格。
	 */
	public static String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return s;
		Stack<String> stack = new Stack<>();
		int i = 0, j = 0;
		while (i < s.length() && s.charAt(i) == ' ')// 处理开头可能出现的空格
			i++;
		while (i < s.length()) {
			j = i;
			while (j < s.length() && s.charAt(j) != ' ')
				j++;
			stack.push(s.substring(i, j));
			while (j < s.length() && s.charAt(j) == ' ')
				j++;
			i = j;
		}
		StringBuffer sBuffer = new StringBuffer();
		while (!stack.isEmpty() && stack.peek() != " ") {
			sBuffer.append(stack.pop());
			sBuffer.append(' ');
		}
		if (sBuffer.length() > 0)
			sBuffer.deleteCharAt(sBuffer.length() - 1);
		return sBuffer.toString();
	}

	/*
	 * 利用String提供的方法trim()和spilt()来处理字符串
	 */
	public static String reverseWords2(String s) {
		if (s == null || s.length() == 0)
			return s;
		String[] strings = s.split(" ");
		StringBuilder sBuilder = new StringBuilder();
		for (int i = strings.length - 1; i >= 0; i--) {
			String temp = strings[i].trim();
			if (temp.equals(" ") || temp.equals(""))
				continue;
			sBuilder.append(temp).append(" ");
		}
		sBuilder.deleteCharAt(sBuilder.length() - 1);
		return sBuilder.toString();
	}

	public static void main(String[] args) {
		String string = "  1     hello  world!  ";
		String string2[] = string.split("  ");
		System.out.println(Arrays.toString(string2));
		System.out.println(string2.length);
		for (int i = 0; i < string2.length; i++) {
			System.out.println(string2[i].trim());
		}
		System.out.println(Arrays.toString(string2));
		System.out.println(reverseWords(string) + 4);

	}
}
