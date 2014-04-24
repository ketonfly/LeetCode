package leecode;

import java.util.ArrayList;

public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		if(n == 0 ){
			result.add(0);
			return result;
		}
		if (n == 1) {
			result.add(0);
			result.add(1);
			return result;
		}
		ArrayList<Integer> t = grayCode(n - 1);
		int step = (int) Math.pow(2, n - 1);
		result.addAll(t);
		Integer[] tmp = new Integer[step];
		t.toArray(tmp);
		
		
		for(int i = 0 ;i<step;i++){
			int s = tmp[step - i-1];
			result.add(s+step);
		}
		return result;
		
	}
	public static void main(String []args){
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(4));
	}
}
