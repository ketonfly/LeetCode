package leecode;

public class AddBinary {
	public String addBinary(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		if (aLen > bLen) {
			return add(b, a);
		} else
			return add(a, b);
	}

	public String add(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		char[] ArrayA = a.toCharArray();
		char[] ArrayB = b.toCharArray();

		int flag = 0;

		char[] result = new char[bLen + 1];
		for (int i = aLen - 1, j = bLen - 1; i >= 0; i--, j--) {
			
			
			if (ArrayA[i] == '1' && ArrayB[j] == '1') {

				if (flag == 0) {
					result[j + 1] = '0';
					flag = 1;
				}
				else {
					result[j + 1] = '1';
					flag = 1;
				}

			}
			if (ArrayA[i] == '0' && ArrayB[j] == '1') {
				if (flag == 0) {
					result[j + 1] = '1';
					flag = 0;
				}
				else {
					result[j+1] = '0';
					flag = 1;
				}
			}
			if (ArrayA[i] == '1' && ArrayB[j] == '0') {
				if (flag == 0) {
					result[j + 1] = '1';
					flag = 0;
				}
				else {
					result[j + 1] = '0';
					flag = 1;
				}
			}
			if (ArrayA[i] == '0' && ArrayB[j] == '0') {
				if (flag == 1) {
					result[j + 1] = '1';
					flag = 0;
				}
				else{
					result[j + 1] = '0';
				}
			}

		}

		for (int k = bLen - aLen - 1; k >= 0; k--) {
			if (ArrayB[k] == '1') {
				if (flag == 1) {
					result[k + 1] = '0';
					flag = 1;
				}
				else{
					result[k + 1] = '1';
					flag = 0;
				}
			}
			if (ArrayB[k] == '0') {
				if (flag == 1) {
					result[k + 1] = '1';
					flag = 0;
				}
				else {
					result[k + 1] = '0';
					flag = 0;
				}

			}
		}
		String r= null;
		if (flag == 1) {
			result[0] = '1';
			r = String.valueOf(result);
		} else
			r=String.valueOf(result).substring(1);
		return r;

	}

	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		String a = "101";
		String b = "111";
		System.out.println(ab.addBinary(a, b));
	}

}
