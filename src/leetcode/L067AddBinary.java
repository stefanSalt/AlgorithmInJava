package leetcode;

public class L067AddBinary {
	public String addBinary(String a, String b) {
		int alen = a.length();
		int blen = b.length();
		int flag = 0;
		int aend = 0, bend = 0;
		String result = "";
		while (alen > 0 && blen > 0) {
			if (alen > 0) {
				alen--;
				aend = a.charAt(alen) - '0';
			}
			if (blen > 0) {
				blen--;
				bend = b.charAt(blen) - '0';
			}
			if (flag + aend + bend == 2) {
				result += 0;
				flag = 1;
			} else if (flag + aend + bend == 3) {
				result += 1;
				flag = 1;
			} else {
				result += (flag + aend + bend);
				flag = 0;
			}

		}
		while (alen > 0) {
			alen--;
			aend = a.charAt(alen) - '0';
			if (flag + aend == 2) {
				result += 0;
				flag = 1;
			}

			else {
				result += (flag + aend);
				flag = 0;
			}
		}
		while (blen > 0) {
			blen--;
			bend = b.charAt(blen) - '0';
			if (flag + bend == 2) {
				result += 0;
				flag = 1;
			} else {
				result += (flag + bend);
				flag = 0;
			}
		}
		if (flag == 1)
			result += 1;
		StringBuffer sb = new StringBuffer(result);
		result = sb.reverse().toString();
		return result;
	}
}
