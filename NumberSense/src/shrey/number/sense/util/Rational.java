package shrey.number.sense.util;

public class Rational {

	private int p;
	private int q;
	int iPart;
	int fPart;
	private boolean pos;
	public Rational(int n, int d)  {
		if (d == 0) throw new IllegalArgumentException("Denominator = 0");
		p = n;
		q = d;
		pos = !(((p > 0) ^ (q > 0)) || (p == 0));
		p = Math.abs(p);
		q = Math.abs(q);
		simplify();
		iPart = p / q;
		fPart = p % q;
	}
	
	@Override
	public String toString()  {
		if (q == 1) return String.valueOf(p);
		String s = p + "/" + q;
		if (!isPositive()) s = "-" + s;
		return s;
	}
	public String toLatex() {
		if (q == 1) return String.valueOf(p);
		String s = "\\frac{" + p + "}{" + q + "}";
		if (!isPositive()) s = "-" + s;
		return s;
	}
	public String toMixLatex()  {
		if (q == 1) return String.valueOf(p);
		String s = iPart + "\\frac{" + fPart + "}{" + q + "}";
		if (!isPositive()) s = "-" + s;
		return s;
	}
	public int getP() {
		return p;
	}

	public int getQ() {
		return q;
	}
	
	public Rational multiply(Rational b)  {
		int num = p * b.getP();
		int den = q * b.getQ();
		return new Rational(num, den);
	}
	
	public Rational divide(Rational b)  {
		int num = p * b.getQ();
		int den = q * b.getP();
		return new Rational(num, den);
	}
	
	public Rational add(Rational b)  {
		int den = q * b.getQ();
		int num = b.getQ() * p + q * b.getP();
		return new Rational(num, den);
	}
	
	public Rational subtract(Rational b)  {
		int den = q * b.getQ();
		int num = b.getQ() * p - q * b.getP();
		return new Rational(num, den);
	}
	
	public static int getGCF(int a, int b)  {
		if (b==0) return a;
		else return getGCF(b, a % b);
	}
	
	public void simplify()  {
		int k = getGCF(p, q);
		p /= k;
		q /= k;
	}
	
	public boolean isPositive()  {
		return pos;
	}

}
