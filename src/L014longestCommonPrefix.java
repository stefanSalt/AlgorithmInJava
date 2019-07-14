
public class L014longestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int len = strs[0].length();
		for (int i = 1; i < strs.length; i++)
			len = Math.min(len, strs[i].length());
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || c != strs[j].charAt(i))
					return strs[0].substring(0, i);

			}

		}

		return strs[0];
	}
}
