package shrey.number.sense;

import java.io.PrintWriter;
import java.util.ArrayList;

import shrey.number.sense.gui.TrickCollection;
import shrey.number.sense.latex.Latex;

/**
 * 
 * Trick is the superclass of all problem-generators used by the software. As
 * such, Trick provides certain features. All the extending class need do is
 * define a method to generate problems, using LaTeX.
 * 
 * @author Shreyas Balaji
 * 
 * 
 */
public abstract class Trick {

	/**
	 * Generates <code>reps</code> amount of problems and solutions and outputs
	 * it using the PrintWriter <code>p</code>.
	 * 
	 * @param p
	 *            Output stream of end LaTeX file.
	 * @param reps
	 *            Number of sets of problems of solutions generated.
	 * @see #trickMix(PrintWriter, int, Trick[])
	 * @deprecated
	 */
	public void trick(PrintWriter p, int reps) {
		ArrayList<String> arr1, arr2;
		arr1 = new ArrayList<String>(reps);
		arr2 = new ArrayList<String>(reps);
		for (int i = 1; i <= reps; i++) {
			String[] st = tL();
			arr1.add(st[0]);
			arr2.add(st[1]);
		}
		p.print(Latex.LaTeXHeader());
		p.print("\nPROBLEMS\n \\begin{multicols}{2} \\begin{enumerate}\n");

		for (String string : arr1)
			p.println(string + " \\hspace{4mm} \\line(1,0){50}");
		p.println("\\end{enumerate} \\end{multicols}\n\\pagebreak");

		p.print("\nSOLUTIONS\n\\begin{multicols}{5}\n\\begin{enumerate}");
		for (String string : arr2)
			p.println(string);
		p.println("\\end{enumerate} \\end{multicols}\n");
		p.println("\\end{document}");
		p.flush();
	}

	/**
	 * This method, for all intents and purposes, replaces and improves the
	 * deprecated method <code>trick()</code>. Given an array of problem
	 * generators which incorporate LaTeX formatting, it outputs a file
	 * containing problems and solutions to a PrintWriter.
	 * 
	 * @param p
	 *            The a <code>PrintWriter</code> which serves as the output
	 *            stream for this method.
	 * @param reps
	 *            The amount of problems to be generated.
	 * @param t
	 *            An array of problem generators which are instances of
	 *            <code>Trick</code>. To replicate the functionality of the old
	 *            function <code>trick()</code>, pass an array containing a
	 *            single object.
	 *            @see
	 */
	public static void trickMix(PrintWriter p, int reps, Trick[] t) {
		final int tLen = t.length;
		int randomNumber;
		ArrayList<String> arr1, arr2, arr3;
		arr1 = new ArrayList<String>(reps);
		arr2 = new ArrayList<String>(reps);
		arr3 = new ArrayList<String>(reps);
		for (int i = 1; i <= reps; i++) {
			randomNumber = (int) (Math.random() * tLen);
			String[] st = t[randomNumber].tL();
			arr1.add(st[0]);
			arr2.add(st[1]);
			if (st.length > 2)
				arr3.add(st[2]);
			else
				arr3.add("");
		}
		p.print(Latex.LaTeXHeader());
		p.print("\nPROBLEMS\n \\begin{multicols}{2} \\begin{enumerate}\n");

		for (int i = 0; i < reps; i++) {
			String string = arr1.get(i);
			p.println(string + " \\hspace{3mm} \\line(1,0){50}" + arr3.get(i));
		}
		p.println("\\end{enumerate} \\end{multicols}\n\\pagebreak");

		p.print("\nSOLUTIONS\n\\begin{multicols}{4}\n\\begin{enumerate}");
		for (String string : arr2)
			p.println(string);
		p.println("\\end{enumerate} \\end{multicols}\n");
		p.println("\\end{document}");
		p.flush();
	}

	/**
	 * Given an <code>TrickCollection</code> of problem generators which
	 * incorporate LaTeX formatting, it outputs a file containing problems and
	 * solutions to a PrintWriter.
	 * 
	 * @param p
	 *            The a <code>PrintWriter</code> which serves as the output
	 *            stream for this method.
	 * @param reps
	 *            The amount of problems to be generated.
	 * @param t
	 *            A <code>TrickCollection</code> of generators which are instances of
	 *            <code>Trick</code>. To replicate the functionality of the old
	 *            function <code>trick()</code>, pass an array containing a
	 *            single object.
	 * @see #trickMix(PrintWriter, int, Trick[])
	 */
	public static void trickMix(PrintWriter p, int reps, TrickCollection t) {
		ArrayList<String> arr1, arr2, arr3;
		arr1 = new ArrayList<String>(reps);
		arr2 = new ArrayList<String>(reps);
		arr3 = new ArrayList<String>(reps);
		for (int i = 1; i <= reps; i++) {
			String[] st = t.getRandomElement().tL();
			arr1.add(st[0]);
			arr2.add(st[1]);
			if (st.length > 2)
				arr3.add(st[2]);
			else
				arr3.add("");
		}
		p.print(Latex.LaTeXHeader());
		p.print("\nPROBLEMS\n \\begin{multicols}{2} \\begin{enumerate}\n");

		for (int i = 0; i < reps; i++) {
			String string = arr1.get(i);
			p.println(string + " \\hspace{3mm} \\line(1,0){50}" + arr3.get(i));
		}
		p.println("\\end{enumerate} \\end{multicols}\n\\pagebreak");

		p.print("\nSOLUTIONS\n\\begin{multicols}{4}\n\\begin{enumerate}");
		for (String string : arr2)
			p.println(string);
		p.println("\\end{enumerate} \\end{multicols}\n");
		p.println("\\end{document}");
		p.flush();
	}

	/**
	 * Should return a problem and a solution in a compact way, in the correct
	 * format so it can be parsed to create custom problem sets by our compiler.
	 * 
	 * @return <code>String[] problemAndSolution</code> such that: <br>
	 * 
	 *         <code>problemAndSolution[0]</code> contains the problem
	 *         statement, formatted in LaTeX to contain
	 *         <code>"\\item \\( %s \\)"</code>, where the %s format specifier
	 *         indicates the math of the problem, in LaTeX. <br>
	 * 
	 *         <code>problemAndSolution[1]</code> contains the solution, in the
	 *         same format as the problem. <br>
	 * 
	 *         <code>problemAndSolution[2]</code> (optional) contains the type
	 *         of the problem if it should be appended as a suffix. Ex.
	 *         <code>"\\hspace{3mm}(Mixed)"</code>.
	 */
	public abstract String[] tL();
}
