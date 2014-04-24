package leecode;

public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		
		if(s == null){
			return 0;
		}
		if(s.contains(" ")==false){
			return s.length();
		}
		s= s.trim();
		
		return s.length() - s.lastIndexOf(' ')-1;
	}
	public static void main(String []args){
		LengthofLastWord l = new LengthofLastWord();
		String s = " a ";
		System.out.println(l.lengthOfLastWord(s));
	}
}
