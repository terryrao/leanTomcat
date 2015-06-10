package java8.innerclass;

public class Test {

	 public Test() {
		 System.out.println("test init...");
	 }
	@org.junit.Test
	public void test(){
		RandomInteger rnadInteger = new LocalRandomInteger().getRandInteger();
		System.out.println(rnadInteger.getValue());
		test2();
	}
	
	public void test2(){
		new Object(){
			{
				System.out.println ("Hello from an anonymous class.");
			}
		};
	}
}
