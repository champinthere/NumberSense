package shrey.number.sense;

public class Squaring5s extends Trick
{
  @Override
  public String[] tL ()
  {
    String st [] = new String [2];
    int a = (int)(Math.random()*12)+3;
    int val = a*10+5;
    int val2 = (int) Math.pow(val, 2);
    st[0] = String.format("\\item \\( %d \\times %d \\)", val, val);
    st[1] = String.format("\\item \\( %d \\)", val2);
    return st;
  }
}
