
public class L66PlusOne {
	public int[] plusOne(int[] digits) {
		int flag = 1;
		int index = digits.length - 1;
		for(int i=index;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
                flag=1;    
            }
            else{
                flag=0;
                digits[i]+=1;
            }
            if(flag==0) break;
        }
        if(flag==1){
            int[] newarray = new int[digits.length + 1];
			newarray[0] = 1;
			for (int j = 1; j < newarray.length; j++)
				newarray[j] = digits[j - 1];
			return newarray;
        }

		return digits;

	}
}
