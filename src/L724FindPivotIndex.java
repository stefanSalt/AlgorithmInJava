/*
 * 求数组累加和，再用一个数字存放从头到当前位置数字和，判断是否符合要求
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
