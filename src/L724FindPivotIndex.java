/*
 * �������ۼӺͣ�����һ�����ִ�Ŵ�ͷ����ǰλ�����ֺͣ��ж��Ƿ����Ҫ��
 */
public class L724FindPivotIndex {
	 public int pivotIndex(int[] nums) {
	        int sum =0;
	        for(int index=0;index<nums.length;index++){
	            sum+=nums[index];
	        }
	        int midSum=0;
	        for(int index=0;index<nums.length;index++){
	            
	            if(midSum*2==(sum-nums[index])){
	                return index;
	            }
	            midSum+=nums[index];
	        }
	        return -1;
	    }

}
