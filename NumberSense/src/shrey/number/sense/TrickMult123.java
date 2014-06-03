package shrey.number.sense;

/**
 * Generates problems (with solution) meant for practice multiplying three digit
 * integers where each integer is composed of the first three digits. <br>
 * Format: ABC * DEF = ?, where A,B,C,D,E,F are from the set {1, 2, 3}.
 * 
 * @author Shreyas Balaji
 * 
 */
public class TrickMult123 extends Trick {

	@Override
	public String[] tL() {
		String s = "";
		for (int i = 0; i < 6; i++)
			s += String.valueOf(1 + (int) (3 * Math.random()));
		int first = Integer.parseInt(s.substring(0, 3));
		int second = Integer.parseInt(s.substring(3));
		int product = first * second;

		String[] problemAndSolution = new String[2];

		problemAndSolution[0] = String.format("\\item \\( %s \\times %s = \\)",
				String.valueOf(first), String.valueOf(second));

		problemAndSolution[1] = String.format("\\item \\( %s \\)",
				String.valueOf(product));

		return problemAndSolution;
	}

}
