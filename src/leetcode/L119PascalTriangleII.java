package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * ����һ���Ǹ����� k������ k �� 33������������ǵĵ� k �С�



����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�

ʾ��:

����: 3
���: [1,3,3,1]
���ף�

������Ż�����㷨�� O(k) �ռ临�Ӷ���
 */
public class L119PascalTriangleII {
	/*
	 * ͨ����ʽa[i][j]=a[i-1][j-1]+a[i-1][j]�������ͷ��β����1��������� ��һ��ʹ�ö�ά������������֣����ֻҪ���k������
	 * ֻ��ʹ��һ������ͨ��������ȡ��k������
	 * 
	 * ע�⣺��Ϊ�õ��������ţ�����a[i][j]�Ḳ�ǵ�a[i-1][j],�ڼ���a[i][j+1]ʱ��a[i-1][j]�Ѿ������ǵ��ˣ��Ӷ���ô�����
	 * ����Ҫ�����򣬴Ӻ���ǰ����
	 */
	public List<Integer> getRow(int rowIndex) {
		int r[] = new int[rowIndex];
		r[0] = 1;
		for (int i = 0; i <= rowIndex; i++) {
			r[i] = 1;
			for (int j = 1; j < rowIndex; j++) {
				r[j] = r[j - 1] + r[j];
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < r.length; i++) {
			list.add(r[i]);
		}
		return list;
	}
}
