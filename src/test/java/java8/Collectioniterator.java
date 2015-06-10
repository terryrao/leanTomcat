package java8;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Collectioniterator {
	public static void main(String[] args) {
//		List<String> persons = Arrays.asList("Joe", "kei", "John");
//		
//		persons.forEach(p -> System.out.println(p));
		

//		List<String> list = Arrays.asList("1","2","3");
//		Stream<String > stream = list.stream();
//		System.out.println();stream.mapToInt(String::length);
		
//		ThreadLocal<List<String>> strings = new ThreadLocal<List<String>>() { @Override protected List<String> initialValue() { return new ArrayList<>();
//		ThreadLocal<List<String>> strinLocal = ThreadLocal.withInitial(ArrayList::new));
		
		//获取方法的参数名称
//		try {
//			Method method = Collectioniterator.class.getMethod("main", String[].class);
//			for(Parameter parameter : method.getParameters()) {
//				System.out.println(parameter.getName());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		System.out.println(getPerCent(new BigDecimal(13.5)));
		
		
	}
	
	public static BigDecimal getPerCent(BigDecimal number1) {
		BigDecimal result = number1.divide(new BigDecimal(100));
		result = getValue(result, new BigDecimal(1), CalculateType.Add);
		return result;
	}
	
	public static BigDecimal getValue(BigDecimal number1, BigDecimal number2, CalculateType calculateType) {
		BigDecimal result = null;
		switch (calculateType) {
		case Add:
			result = number1.add(number2);
			break;
		case Subtract:
			result = number1.subtract(number2);
			break;
		case Multiply:
			result = number1.multiply(number2);
			break;
		case Divide:
			result = number1.divide(number2, 8, BigDecimal.ROUND_HALF_DOWN);
			break;
		default:
			break;
		}
		return result;
}
	enum CalculateType {
		
		Add("add", "加法"), 
		Subtract("subtract", "减法"), 
		Multiply("multiply", "乘法"), 
		Divide("divide", "除法");

		private String value;

		private String name;

		CalculateType(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
}
