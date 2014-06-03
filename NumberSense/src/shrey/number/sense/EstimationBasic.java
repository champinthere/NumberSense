package shrey.number.sense;

/**
 * Generates problems (with solution) which are intended to be practice
 * multiplying and dividing large integers, with a touch of addition/subtraction thrown in.
 * Format: LargeNum1 (* or /) LargeNum2 (+ or -) LargeNum3 =?.
 * 
 * @author Shreyas Balaji
 *
 */
public class EstimationBasic extends Trick {

	@Override
	public String[] tL() {
		double num = Math.round(2 + Math.random() * 50000) / 10.0;
		double num2 = Math.round(2 + Math.random() * 1000) / 10.0;
		double num3 = Math.round(2 + Math.random() * 20000) / 10.0;
		String[] st = new String[2];
		double ans = 0;
		boolean mult = false;
		
		if (Math.random() < .5) {
			mult = true;
			ans += num * num2;
		}
		else  {
			num = 10000 + Math.round(2 + Math.random() * 10000);
			ans += num / num2;
		}
		
		boolean add = false;
		
		if (Math.random() < .5)  {
			add = true;
			ans += num3;
		}
		else
			ans -= num3;
		
		long minimumAcceptedValue = 0, maximumAcceptedValue = 0;
		if (ans > 0)  {
			minimumAcceptedValue = Math.round(.95 * ans);
			maximumAcceptedValue = Math.round(1.05 * ans);
		}
		else  {
			maximumAcceptedValue = Math.round(.95 * ans);
			minimumAcceptedValue = Math.round(1.05 * ans);
		}
		
		String problem = num + ((mult) ? "\\times" : " \\div ") 
								+ num2 + ((add) ? "+" : "-") + num3;
		String solution = "[" + minimumAcceptedValue + "," + maximumAcceptedValue + "]";
		st[0] = String.format("\\item \\( %s \\)", problem);
		st[1] = String.format("\\item \\( %s \\)", solution);
			
			
		return st;
	}

}
