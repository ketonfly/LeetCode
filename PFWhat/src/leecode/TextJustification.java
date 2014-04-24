package leecode;

import java.util.ArrayList;

public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		int[] length = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			String s = words[i];
			length[i] = s.length();
		}

		ArrayList<String> al = new ArrayList<String>();

		for (int i = 0; i < words.length;) {

			StringBuffer s = new StringBuffer();
			int len = length[i];
			int j = i + 1;

			if (j >= words.length) {
				s.append(words[i]);
				for (int k = 0; k < L - length[i]; k++) {
					s.append(' ');
				}
				
				al.add(s.toString());
				break;
			}
			while (len < L) {
				if (len + 1 + length[j] > L) {
					break;
				}
				len = len + 1 + length[j];
				j++;
				if(j>=words.length){
					for(int k = 0 ;k < j-i-1;k++){
						s.append(words[i+k]).append(' ');
					}
					s.append(words[j-1]);
					
					for(int k = 0 ;k < L - len;k++){
						s.append(' ');
					}
					al.add(s.toString());
					return al;
				}
			}

			int number = j - i;
			int interval = number - 1;
			int space = L - len;

			if (number == 1) {
				s.append(words[i]);
				for (int k = 0; k < space; k++) {
					s.append(' ');
				}
				al.add(s.toString());
				i = j;
				continue;
			}

			int base = space / interval;
			int another = space % interval;

			int[] ext = new int[number];
			for (int k = 0; k < interval; k++) {
				ext[k] = base + 1;
			}
			for (int k = 0; k < another; k++) {
				ext[k]++;
			}
			ext[number - 1] = 0;
			for (int k = 0; k < number; k++) {
				s.append(words[i + k]);
				s.append(g(ext[k]));
			}			
			al.add(s.toString());

			i = j;
		}

		return al;

	}

	public StringBuffer g(int k) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < k; i++) {
			s = s.append(' ');
		}
		return s;
	}

	public static void main(String[] args) {
		TextJustification tj = new TextJustification();
		String[] words = { "What","must","be","shall","be." };
		System.out.println(tj.fullJustify(words, 12));
	}
}
