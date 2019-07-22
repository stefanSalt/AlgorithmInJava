package leetcode;

/**
 * 
 * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
 * 
 * ˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���
 * 
 * ʾ�� 1:
 * 
 * ����: "A man, a plan, a canal: Panama" ���: true ʾ�� 2:
 * 
 * ����: "race a car" ���: false
 * 
 * @author stefa
 *
 */

public class L125ValidPalindrome {
	/**
	 * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ� ˫ָ����������м�ƽ����ж϶�λ�ַ��Ƿ���ͬ
	 * 
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		char[] chars = s.toLowerCase().toCharArray();
		int left = 0;
		int right = chars.length - 1;
		while (left < right) {
			while (left < chars.length && !isCharOrNum(chars[left]))// ���˷����ֻ���ĸ�ַ�
				left++;
			while (right >= 0 && !isCharOrNum(chars[right]))// ���˷����ֻ���ĸ�ַ�
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
	 * �ж��ַ�c�Ƿ�Ϊ��ĸ��������
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
