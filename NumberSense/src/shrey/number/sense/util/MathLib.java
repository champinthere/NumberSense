package shrey.number.sense.util;

public class MathLib {
	public static String baseConvert(String input, int inputRadix, int outputRadix)  {
		int i = Integer.parseInt(input, inputRadix);
		return Integer.toString(i, outputRadix);
	}
	
}
