package leecode;

public class MaximumSubarray {
	//求解 maxSubArray(A[n]) = max(maxSubArray(A[n-1]),A[n],maxSubArray(A[n-1])+A[n]);
	public int maxSubArray(int[] A){
		int max = 0;
		int l = A.length;
		for(int i = 0 ;i<l;i++){
			int sum = A[i] ;
			if(sum > max )
				max = sum;
			for(int j = i+1;j<l;j++){
				sum = sum + A[j];
				if(sum > max){
					max = sum;
				}
			}
			
		}
		return max;
	}
	
	public int DPmaxSubArray(int[] A){
		//maxEnd 必然带着最新元素的前一个元素，
		//当maxEnd不带前面的数的时候，maxSum记录了前面最大的sum
		//最后比较的时候，会进行更新
		int maxEnd = A[0];//记录每次最后一个元素
		int maxSum = A[0];//记录到现在为止，最大的sum
		for(int i = 1 ; i < A.length ;i ++){
			//如果前面的到前面的End为止，和都是一个负数，
			//那么这个数对后面的和不会产生正的效果，可以直接去除
			if( maxEnd < 0 ){
				maxEnd = A[i];
			}
			//如果这个不是一个负数，那么maxEnd，还是一个有潜力去成就一个最大值的
			//可以取maxEnd和A[i]和
			//若A[i]为负数，那么可能产生不好的影响
			//若为正数，那么绝对是正的影响
			else maxEnd = maxEnd+A[i];
			
			if(maxSum < maxEnd){
				maxSum = maxEnd;
			}
			
		}
		return maxSum;
	}
	
	
		
	//divide and conquer approach
	
	/*public int DCmaxSubArray(int A[]){
		return fun(A,0,A.length -1);
	}
	
	public int fun(int A[],int left,int right){
		if(left > right){
			return 0 ;
		}
		if(left == right){
			return A[left];
		}
		
		int mid = (left + right)/2;
		
		int leftMax,rightMax;
		leftMax = rightMax = 0;
		
	}
	*/
	
	
	/*
	 * 
	 * http://oj.leetcode.com/discuss/694/how-solve-maximum-subarray-using-divide-and-conquer-approach
	 * 
	 * class Solution {
public:
    int maxSubArray(int A[], int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(n==0) return 0;
        return maxSubArrayHelperFunction(A,0,n-1);
    }

    int maxSubArrayHelperFunction(int A[], int left, int right) {
        if(right == left) return A[left];
        int middle = (left+right)/2;
        int leftans = maxSubArrayHelperFunction(A, left, middle);
        int rightans = maxSubArrayHelperFunction(A, middle+1, right);
        int leftmax = A[middle];
        int rightmax = A[middle+1];
        int temp = 0;
        for(int i=middle;i>=left;i--) {
            temp += A[i];
            if(temp > leftmax) leftmax = temp;
        }
        temp = 0;
        for(int i=middle+1;i<=right;i++) {
            temp += A[i];
            if(temp > rightmax) rightmax = temp;
        }
        return max(max(leftans, rightans),leftmax+rightmax);
    }
};*/
	
	
	//copy from http://discuss.leetcode.com/questions/231/maximum-subarray
	
	
	
	int maxSubArray(int A[], int n) {
	    return maxSub(A,0,n-1);
	}
	int maxSub(int A[], int left, int right){
	    if(left>right)return -1;
	    if(left==right)return A[left];
	    int mid=left+((right-left)>>1);
	    int leftMax=-1, rightMax=-1;
	    
	    int leftcurrSum=0;
	    for(int i=mid-1; i>=left; --i){
	    	leftcurrSum+=A[i];
	    	leftMax=Math.max(leftMax, leftcurrSum);
	    }
	    	
	    int rightcurrSum = 0;
	    for(int i=mid+1; i<=right; ++i){
	    	rightcurrSum+=A[i];
	    	rightMax=Math.max(rightMax, rightcurrSum);
	    }
	    	
	    int midMax=A[mid]+Math.max(leftMax,0)+Math.max(rightMax,0);
	    return Math.max(Math.max(maxSub(A,left,mid-1),maxSub(A,mid+1,right)),midMax);
	}
	
	public static void main(String []args){
		MaximumSubarray ms = new MaximumSubarray();
		int[] A = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(ms.DPmaxSubArray(A));
	}
}
