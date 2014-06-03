package shrey.number.sense.latex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Latex {
	public static final String LaTeXHeader() {
		String s = "";
		s += "\\documentclass[11pt]{article}\n";
		s += "\\usepackage[margin=1in]{geometry}\n";
		s += "\\usepackage{mathptmx}\n";
		s += "\\usepackage{multicol}\n";
		s += "\\begin{document}\n";
		s += "\\boldmath";
		s += "\\section{PRACTICE}\n";
		s += "\n";
		return s;
	}

	public static final void compile(String inputDir, String outputDir,
			String fileName) {
		String toRun = "/usr/texbin/pdflatex -output-directory=" + outputDir
				+ " " + inputDir + fileName + ".ltx";
		String f2 = outputDir + fileName + ".pdf";
		String toRun2 = "open -a Preview.app " + f2;
		try {
			Process a = Runtime.getRuntime().exec(toRun);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(
					a.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(
					a.getErrorStream()));

			// read the output from the command
			System.out.println("STANDARD OUTPUT:\n");
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}

			// read any errors from the attempted command
			System.out.println("ERROR OUTPUT (IF ANY):\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}
			Runtime.getRuntime().exec(toRun2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
