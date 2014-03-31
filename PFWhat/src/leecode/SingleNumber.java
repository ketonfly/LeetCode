package leecode;

public class SingleNumber {
	public static int MethodSingleNumber(int A[]){
		int once = 0;
		int twice = 0;
		int flag = 0;
		for(int i = 0 ; i < A.length ; i ++){
			int value = A[i];
			twice = twice | (once & value);
			once = once^value;
			
			flag = ~(once&twice);
			
			once = once&flag;
			twice = twice & flag;
		}
		return once;
	}
	
	public static void main(String []args){
		int A[] = {2,2,2,3,3,3,4,6,6,6};
		System.out.println(MethodSingleNumber(A));
	}
}
