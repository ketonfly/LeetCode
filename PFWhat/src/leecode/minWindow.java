package leecode;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class minWindow {
	public String MyminWindow(String S, String T) {
		//int targetNum = T.length();
		//char FirstChar;
		//int justNum = 0;
		Map<Character,Integer> TIndex = new HashMap<Character,Integer>();
		for(int i = 0 ; i < T.length() ; i++){
			TIndex.put(T.charAt(i), -1);
		}
		System.out.println(TIndex.toString());
		
		for(int i = 0 ;i<S.length();i++){
			if(TIndex.containsKey(S.charAt(i))){
				TIndex.put(S.charAt(i), i);
			}
			if(TIndex.containsValue(-1)==false){
				break;
			}
		}
		System.out.println(TIndex.toString());
		
		int minIndex = 0 ;
		int maxIndex = 0 ;
		Collection<Integer> TInt =  TIndex.values();
		for(int i : TInt){
			
			if(minIndex > i){
				minIndex =i;
			}
			if(maxIndex <i){
				maxIndex = i;
			}
		}
		System.out.println(S.substring(0, 5));
		return S.substring(minIndex, maxIndex);
		
    }
	
	public static void main(String []args){
		String S = "ADOBECODEBANC";
		String T = "ABC";
		System.out.println(new minWindow().MyminWindow(S, T));
	}
}
