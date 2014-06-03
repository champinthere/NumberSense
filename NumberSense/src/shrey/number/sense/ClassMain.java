package shrey.number.sense;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import shrey.number.sense.gui.TrickCollection;
import shrey.number.sense.latex.Latex;

public class ClassMain {

	public static final String FILE = "Number_Sense";
	public static final String LTDIR = "/Users/shreyas/Programming/NS/";
	public static final String OUTPUT_DIR = "/Users/shreyas/Desktop/";

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		// Trick t1 = new Trick1();
		// Trick t2 = new T3367();
		// Trick t3 = new Same10AddTo5();
		// Trick t4 = new Same10();
		// Trick t5 = new FReciprocal();
		// Trick t6 = new EstimationBasic();
		// Trick t7 = new TrickFoil();
		// Trick t8 = new TrickMult123();
		// Trick[] t = {t7, t7, t7, t8};
		// // t.trick(new PrintWriter(System.out), 60);
		// try (PrintWriter p = new PrintWriter(LTDIR + FILE + ".ltx")) {
		// Trick.trickMix(p, 216, t);
		// Latex.compile(LTDIR, OUTPUT_DIR, FILE);
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }
		test();
	}

	public static void test() {
		TrickCollection t = new TrickCollection();
		t.add("Rational");
		try (PrintWriter p = new PrintWriter(LTDIR + FILE + ".ltx")) {
			Trick.trickMix(p, 216, t);
			Latex.compile(LTDIR, OUTPUT_DIR, FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
