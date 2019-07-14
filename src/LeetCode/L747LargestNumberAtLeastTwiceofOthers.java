package LeetCode;
//�������������������������
/*
 * ������������ŵ�ǰ���ֵ�ʹδ�ֵ������������ж��Ƿ����Ҫ��
 */
public class L747LargestNumberAtLeastTwiceofOthers {
	 public int dominantIndex(int[] nums) {
	        if(nums.length==1)return 0;
	        int maxindex=0;
	        int nextMaxindex=1;
	        for(int index=1;index<nums.length;index++){
	            if(nums[maxindex]<nums[index]){
	                nextMaxindex=maxindex;
	                maxindex=index;
	            }
	            else if(nums[nextMaxindex]<nums[index]){
	                nextMaxindex=index;
	            }
	        
	        }
	        if(nums[nextMaxindex]*2>nums[maxindex])
	            return -1;
	        else
	            return maxindex;
	        
	    }
}
