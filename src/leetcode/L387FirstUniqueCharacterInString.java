package leetcode;

import java.util.HashMap;

/*
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
 

注意事项：您可以假定该字符串只包含小写字母。

 */
public class L387FirstUniqueCharacterInString {
	/*
	 * 遍历字符串，将字符逐个加入到哈希表中，通过哈希表的特性判断是否唯一
	 */
	public int firstUniqChar(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;
	}

	/*
	 * 假设字符串只包含小写字母，那么可以用长为26的int数组存储对应字符的出现次数
	 */
	public int firstUniqChar2(String s) {
		int nums[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			nums[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (nums[s.charAt(i) - 'a'] == 1)
				return i;
		}
		return -1;
	}

	public int firstUniqChar3(String s) {
		int nums[] = new int[26];
		char[] chars = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			nums[chars[i] - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (nums[chars[i] - 'a'] == 1)
				return i;
		}
		return -1;
	}

	/*
	 * 使用String类提供的方法indexof()和lastindexof()定位各字符的第一次和最后一次出现位置，确定是否唯一
	 */
	public int firstUniqChar4(String s) {

		int index = -1;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			int startIndex = s.indexOf(ch);
			if (startIndex != -1 && startIndex == s.lastIndexOf(ch)) {
				index = (index == -1 || index > startIndex) ? startIndex : index;
			}
		}
		return index;

	}
}
