package java8.innerclass;

import java.util.Random;

public class RandomInteger {
	
	public Integer getValue(){
		Random random = new Random();
		return random.nextInt();
	}
}
