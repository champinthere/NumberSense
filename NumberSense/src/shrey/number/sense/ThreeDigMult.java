// Decimal to Fraction Conversion Trick
package shrey.number.sense;

public class Squaring5s extends Trick
{
  @Override
  public String[] tL ()
  {
    String st [] = new String [2];
    int [] nums = new int [6];
    nums [0] = (int)(Math.random()*4)+1;
    nums [3] = (int)(Math.random()*4)+1;
    nums [1] = (int)(Math.random()*5);
    nums [2] = (int)(Math.random()*4);
    nums [4] = (int)(Math.random()*5);
    nums [5] = (int)(Math.random()*4);
    int a = nums[0]+10*nums[1]+100*nums[2];
    int b = nums[3]+10*nums[4]+100*nums[5];
    int c = a*b;
    st[0] = String.format("\\item \\( %d \\times %d \\)", a, b);
    st[1] = String.format("\\item \\( %d \\)", c);
    return st;
  }
}
