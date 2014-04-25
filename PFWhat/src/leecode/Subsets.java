package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> Tresult = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> empty = new ArrayList<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		if(S.length == 0 ){
			result.add(empty);
			return result;
		}
		if(S.length == 1 ){
			result.add(empty);
			al.add(S[0]);
			result.add(al);
			return result;
		}
		
		Arrays.sort(S);
		int T[] = new int[S.length -1];
		for(int i = 0 ;i< S.length -1 ;i++){
			T[i] = S[i];
		}
		int target = S[S.length -1];
		Tresult = subsets(T);
				
		result.addAll(Tresult);
		for(ArrayList<Integer> a : Tresult){
			ArrayList<Integer> t = new ArrayList<Integer>();
			t = (ArrayList<Integer>) a.clone();
			t.add(target);
			result.add(t);
		}
		return result;

	}
	//很好的思想
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        int len = S.length;
        int max = (int)Math.pow(2, len) - 1;
        
        Set<ArrayList<Integer>> sa = new HashSet<ArrayList<Integer>>();
        
        for(int i=0; i<=max; i++){
            BitSet tmp = convert(i);
            
            ArrayList<Integer> subset = new ArrayList<Integer>();
            
            for(int j=tmp.nextSetBit(0); j!=-1; j=tmp.nextSetBit(j+1))
                subset.add(S[j]);
            Collections.sort(subset);
            sa.add(subset);
        }
        
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>(sa);            
        return ret;
    }
    
    public BitSet convert(int value){
        BitSet bits = new BitSet();
        int index = 0;
        while(value != 0){
            if(value % 2 != 0) bits.set(index);
            ++index;
            value = value >>> 1;
        }
        return bits;
    }
	
	
	
	public static void main(String []args){
		Subsets ss = new Subsets();
		int []S = {1,3,2};
		System.out.println(ss.subsets(S));
	}
	
}
