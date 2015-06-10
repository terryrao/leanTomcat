package java8.innerclass;

import java.util.Random;

public class LocalRandomInteger {
	public RandomInteger getRandInteger() {
		class LocalRandInteger extends RandomInteger {

			@Override
			public Integer getValue() {
				// ignoring the fraction part
				Random rand = new Random();
				long n1 = rand.nextInt();
				long n2 = rand.nextInt();
				int value = (int) ((n1 + n2)/2);
				return value;

			}
			
		}
		return new LocalRandInteger();
	}
}
