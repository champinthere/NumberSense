package shrey.number.sense;

import shrey.number.sense.util.Rational;

/**
 * Generator of problem statements where a fraction is added to its reciprocal.
 * For example, 7/11 + 11/17 = ?, with solution 2 36/187.
 * 
 * @author Shreyas Balaji
 * 
 */
public class FReciprocal extends Trick {

	@Override
	public String[] tL() {
		int val1 = (int) (Math.random() * 25 + 4);
		int val2 = 0;
		while (val2 <= 1) {
			int tmp = (int) (1 + Math.random() * 8);
			if (Math.random() < .5)
				val2 = val1 + tmp;
			else
				val2 = val1 - tmp;
		}
		Rational a = new Rational(val1, val2);
		Rational b = new Rational(val2, val1);
		Rational ans = a.add(b);
		String[] st = new String[3];
		st[0] = String.format("\\item \\( %s + %s \\)", a.toLatex(),
				b.toLatex());
		st[1] = String.format("\\item \\( %s \\)", ans.toMixLatex());
		st[2] = "\\hspace{3mm}(Mixed)";
		return st;
	}

}
