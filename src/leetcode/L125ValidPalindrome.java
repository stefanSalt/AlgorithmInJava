package leetcode;

/**
 * 
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama" 输出: true 示例 2:
 * 
 * 输入: "race a car" 输出: false
 * 
 * @author stefa
 *
 */

public class L125ValidPalindrome {
	/**
	 * 给定一个字符串，验证它是否是回文串 双指针从两端向中间逼近，判断对位字符是否相同
	 * 
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		char[] chars = s.toLowerCase().toCharArray();
		int left = 0;
		int right = chars.length - 1;
		while (left < right) {
			while (left < chars.length && !isCharOrNum(chars[left]))// 过滤非数字或字母字符
				left++;
			while (right >= 0 && !isCharOrNum(chars[right]))// 过滤非数字或字母字符
				right--;
			if (left >= chars.length || right < 0)
				break;
			if (chars[left] != chars[right])//
				return false;
			left++;
			right--;
		}
		return true;
	}

	/**
	 * 判断字符c是否为字母或者数字
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isCharOrNum(char c) {
		if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9')
			return true;
		return false;
	}
}
