package leecode;

import java.util.HashMap;



public class TwoSum {
	public static void main(String []args){
		int []numbers={2, 7, 11, 15};
		int target=9;
		int r[] = new int[2];
		r = new solution().twoSum(numbers, target);
		System.out.println("index1="+r[0]+", index2="+r[1]);
	}
}

class solution{
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int l = numbers.length;
		int result[] = new int[2];
        for(int i = 0 ;i<l;i++){
        	if(hm.get(target - numbers[i])!=null){
        		if(hm.get(target-numbers[i]).intValue()!=i){
        			//这里面有问题，这个i必然是第二个数字
        			result[1] = i+1;
        			result[0] = hm.get(target-numbers[i]).intValue()+1;
        			return result;
        		}
        	}
        	else hm.put(numbers[i],i);
        }
        return result;
    }
}