package leetcode;

/*
 * ����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��

ʾ�� 1:

����: "Let's take LeetCode contest"
���: "s'teL ekat edoCteeL tsetnoc" 
ע�⣺���ַ����У�ÿ�������ɵ����ո�ָ��������ַ����в������κζ���Ŀո�
 */
public class L557ReverseWordsinaStringIII {
	/*
	 * ���ַ���������ַ�����ȡ���ո�ͣ�£���֮ǰ�Ӵ�����д��StringBuffer�У���ӿո񣬼���ѭ����ֱ������ĩβ
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
	 * ���ַ���ת��Ϊ�ַ����飬˫ָ�붨λ���ʣ��ӵ������˶�λ��������ɵ�������
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
				j++;// ��λ����ĩβ
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
