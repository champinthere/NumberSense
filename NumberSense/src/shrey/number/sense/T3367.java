package shrey.number.sense;

/**
 * Generates problem statements (with solution) of the type 3367 * AB.
 * 
 * @author Shreyas Balaji
 * 
 */
public class T3367 extends Trick {

	@Override
	public String[] tL() {
		int mult1 = 3367;
		int mult2 = (int) (Math.random() * 89 + 11);
		int tmp;
		int c = (int) (Math.random() * 2);
		if (c == 1) {
			tmp = mult1;
			mult1 = mult2;
			mult2 = tmp;
		}
		String[] st = new String[2];
		st[0] = String.format("\\item \\( %d \\times %d \\)", mult1, mult2);
		int mult = (mult1 * mult2);
		st[1] = String.format("\\item \\( %d \\)", mult);
		return st;
	}

}
