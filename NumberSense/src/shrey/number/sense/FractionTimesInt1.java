package shrey.number.sense;
import shrey.number.sense.util.Rational;

/*  This trick is meant to teach the multiplication of a fraction by an integer
 *  where the integer is equal to the numerator of the fraction. The trick is 
 *  as follows: let a be the integer and a/b be the fraction. a * a/b will 
 *  equal d c/b where d = 2a - b and c = (a-b)^2. Updated by Vishnu Iyer.
 */

public class FractionTimesInt1 extends Trick
{
  @Override
  public String [] tL ()
  {
    int a = (int)(Math.random()*70)+10;
    int b = a + (int)(Math.random()*8)+2;
    int val = 2*a-b;
    Rational r1 = new Rational(a,b);
    Rational temp = new Rational((a-b)*(a-b),b);
    int c = temp.getP();
    int d = temp.getQ();
    if (c>d)
    {
      val += c / d;
      int e = c % d;
      temp = new Rational(e,d);
    }
    String [] st = new String [3];
    st[0] = String.format("\\item \\( %d \\times %d \\)", a , r1.toLatex());
    st[1] = val+temp.toLatex();
    st[2] = "\\hspace{3mm}(Mixed)";
  }
}
