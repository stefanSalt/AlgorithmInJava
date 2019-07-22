package leetcode;

/*
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。


 */
public class L007ReverseInteger {
	/*
	 * 利用%10获取末尾数字，
	 * 注意溢出的情况Integer.MAX_VALUE=2147483647,Integer.MIN_VALUE=-2147483648
	 * 考虑正数的情况，当num溢出时，也就是num>Integer.MAX_VALUE， 即num*10+d>Integer.MAX_VALUE
	 * 那么num满足num>=Integer.MAX_VALUE/10 如果num>Integer.MAX_VALUE/10,那么必定溢出
	 * 如果num==Integer.MAX_VALUE/10，那么d要小于等于7，否则溢出 同理，负数的情况也类似。
	 */
	public static int reverse(int x) {
		int num = 0;
		while (x != 0) {
			int d = x % 10;
			if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && d > 7)
				return 0;
			if (num < Integer.MIN_VALUE / 10 || num == Integer.MIN_VALUE / 10 && d > 8)
				return 0;
			num = num * 10 + d;
			x = x / 10;
		}
		return num;
	}

	/* 思路2：利用long型存储num，最后判断是否溢出 */

	/*
	 * 思路3 利用字符串反转
	 */

	public static void main(String[] args) {
		System.out.println(reverse(1324125511));
		System.out.println(reverse(464564848));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
