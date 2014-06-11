package shrey.number.sense;
// Trick to multiply number by 143
// the trick is to divide the number by 7 and multipy that by 1001
// updated by Vishnu Iyer

public class Trick143 extends Trick
{
  @Override
  public String[] tL()
  {
	String[] st = new String[2];
	
    int val1 = 7 * ((int)(Math.random()*15)+5);
    int val2 = 143 * val1;
    
    st[0] = String.format("\\item \\( %d \\times %d \\)", val1, 143);
    if (Math.random() < .18)  {
    	st[0] = String.format("\\item \\( %d \\times %d \\)", val1, 429);
    	val2 *= 3;
    }
    st[1] = String.format("\\item \\( %d \\)", val2);
    
    
    return st;
  }
}
