package leecode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s == null)
			return true;
		
		StringBuffer sb = new StringBuffer() ;
		for(int i = 0 ;i<s.length();i++){
			if(Character.isLetterOrDigit(s.charAt(i))){
				sb.append(Character.toLowerCase(s.charAt(i)));
			}
		}
		String simple = sb.toString();
		int len = simple.length();
		for(int i = 0 ;i<len/2;i++){
			if(simple.charAt(i)==simple.charAt(len-1-i))
				continue;
			else return false;
		}
		
		return true;

	}
	
}
