package self.basic;

import java.util.Random;

public class randomTest {
	public static void main(String []args){
		Random r = new Random();
		Random rr = new Random(10);
		for(int i = 0;i< 11;i++){
			System.out.print(r.nextInt()+",");
			System.out.print(rr.nextInt()+",");
			System.out.println((int)(Math.random()*10));
		}
	}
}
