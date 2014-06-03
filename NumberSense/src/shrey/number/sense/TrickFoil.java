package shrey.number.sense;

/**
 * Generates problems (with solution) intended for practice in quickly
 * multiplying two digit integers. <br>
 * Format: AB * CD =?
 * 
 * @author Shreyas Balaji
 * 
 */
public class TrickFoil extends Trick {

	@Override
	public String[] tL() {
		String[] problemAndSolution = new String[2];

		int first = 10 + (int) (90 * Math.random());
		int second = 10 + (int) (90 * Math.random());
		int product = first * second;
		problemAndSolution[0] = String.format("\\item \\( %s \\times %s = \\)",
				String.valueOf(first), String.valueOf(second));
		problemAndSolution[1] = String.format("\\item \\( %s \\)",
				String.valueOf(product));
		return problemAndSolution;
	}

}
