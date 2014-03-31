package leecode;

public class ClimbStairs {
	public static void main(String []args){
		System.out.println(new Solution().climbStairs(2));
	}
}

class Solution {

	public int climbStairs(int n) {
		
		int []result = new int[n];
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		
		result[0] = 1;
		result[1] = 2;
		int i = 2;
		while(i<n){
			
			result[i] = result[i-1] + result[i-2];
			i++;
		}
		return result[n-1];
				
	}

}