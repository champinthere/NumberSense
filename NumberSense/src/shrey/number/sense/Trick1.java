package shrey.number.sense;

/**
 * Generate problem statements (with solution) of the type 1A * BC =?.
 * 
 * @author Shreyas Balaji
 * 
 */
public class Trick1 extends Trick {

	public static String[] t1() {
		int a = (int) (Math.random() * 9 + 11);
		int b = (int) (Math.random() * 80 + 20);
		while (b % 10 == 0)
			b = (int) (Math.random() * 80 + 20);
		int tmp;
		int c = (int) (Math.random() * 2);
		if (c == 1) {
			tmp = a;
			a = b;
			b = tmp;
		}
		String[] st = new String[2];
		st[0] = a + " * " + b + " = __________";
		st[1] = String.valueOf(a * b);
		return st;
	}

	@Override
	public String[] tL() {
		int a = (int) (Math.random() * 9 + 11);
		int b = (int) (Math.random() * 80 + 20);
		while (b % 10 == 0)
			b = (int) (Math.random() * 80 + 20);
		int tmp;
		int c = (int) (Math.random() * 2);
		if (c == 1) {
			tmp = a;
			a = b;
			b = tmp;
		}
		String[] st = new String[2];
		st[0] = String.format("\\item \\( %d \\times %d \\)", a, b);
		int mult = (a * b);
		st[1] = String.format("\\item \\( %d \\)", mult);
		return st;
	}

}
