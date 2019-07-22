package leetcode;

/*
 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�

ʾ�� 1:

����: s = "anagram", t = "nagaram"
���: true
ʾ�� 2:

����: s = "rat", t = "car"
���: false
˵��:
����Լ����ַ���ֻ����Сд��ĸ��
����:
��������ַ������� unicode �ַ���ô�죿���ܷ������Ľⷨ��Ӧ�����������
 */
public class L242ValidAnagram {
	/*
	 * Ӧ��hash�����洢���ַ����ֵĴ�����������Ƿ�Ϊ0��
	 * �������õ���int���飨����ȫ����Сд��ĸ���������չ��Unicode�ַ�����Ҫ����hashmap���洢
	 */
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] nums1 = new int[26];
		for (int i = 0; i < s.length(); i++) {
			nums1[s.charAt(i) - 'a']++;
			nums1[t.charAt(i) - 'a']--;
		}

		for (int i : nums1)
			if (i != 0) {
				return false;
			}

		return true;
	}
}
