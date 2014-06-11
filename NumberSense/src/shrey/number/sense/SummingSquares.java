package shrey.number.sense;

public class SummingSquares extends Trick
{
  @Override
  public String[] tL()
  {
    String [] st = new String [2];
    int a = 0;
    int b = 0;
    int c = (int)(Math.random()*3);
    switch(c)
    {
      case 0:
        a = (int)(Math.random()*18)+13;
        b = 3*a;
        break;
      case 1:
        a = (int)(Math.random()*11)+10;
        b = 7*a;
        break;
      case 3:
        boolean cmp = true;
        while(cmp)
        {
          a = (int)(Math.random()*71)+15;
          cmp = a%10==0;
        }
        b = 10*(a%10-1)+(10-a/10);
        break;
    }
    int d = (int) (Math.pow(a,2)+ Math.pow(b,2));
    st[0] = String.format("\\item \\( %d \\times %d \\plus %d \\times %d \\)", a, a, b, b);
    st[1] = String.format("\\item \\( %d \\)", d); 
    return st;
  }
}
