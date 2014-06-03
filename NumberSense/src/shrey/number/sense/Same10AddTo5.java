package shrey.number.sense;

/**
 * Generates problem statements (with solution) of type AB * AC =?, with B + C =
 * 5.
 * 
 * @author shreyas
 * 
 */
public class Same10AddTo5 extends Trick {

	@Override
	public String[] tL() {
		int val1 = (int) (Math.random() * 9 + 1) * 10;
		int val2 = (int) (Math.random() * 4 + 1);
		int mult1 = val1 + val2;
		int mult2 = val1 - val2 + 5;
		int c = (int) (Math.random() * 4);
		if (c == 3) {
			mult1 += 100;
			mult2 += 100;
		}
		String[] st = new String[2];
		st[0] = String.format("\\item \\( %d \\times %d \\)", mult1, mult2);
		int mult = (mult1 * mult2);
		st[1] = String.format("\\item \\( %d \\)", mult);
		return st;
	}

}
