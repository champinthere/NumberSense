package shrey.number.sense.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import shrey.number.sense.Trick;
import shrey.number.sense.latex.Latex;

public class GUI extends JFrame {
	
	public static final String FILE= "Number_Sense";
	public static final String LTDIR = "/Users/shreyas/Programming/NS/";
	public static final String OUTPUT_DIR = "/Users/shreyas/Programming/NS/";
	private static Map<String, String> tipMappings;
	
	
	public GUI(String st) {
		super(st);
		getContentPane().setLayout(null);
		setSize(600, 640);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(8, 70, 300, 440);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("Number of Problems");
		label.setBounds(80, 47, 140, 25);
		label.setOpaque(true);
		getContentPane().add(label);
		
		panel.setOpaque(true);
		setMinimumSize(new Dimension(314, 600));
		
		final JTextField textbox = new JTextField();
		textbox.setBounds(100, 20, 100, 25);
		getContentPane().add(textbox);
		
		setupTipMappings();
		final JList<String> list = new JList<>();
		list.setFont(new Font("Helvetica", Font.PLAIN, 17));
		list.setBounds(8, 70, 286, 428);
		Vector<String> text = new Vector<>();
		text.add("T3367");
		text.add("EstimationBasic");
		text.add("FReciprocal");
		text.add("Same10");
		text.add("Same10AddTo5");
		text.add("Trick1");
		text.add("TrickFoil");
		text.add("TrickMult123");
		text.add("FractionTimesInt1");
		text.add("143Trick");
		text.add("Squaring5s");
		text.add("SummingSquares");
		list.setListData(text);
	    list.addMouseMotionListener(new MouseMotionAdapter() {
	        @Override
	        public void mouseMoved(MouseEvent e) {
	            JList<String> l = (JList<String>) e.getSource();
	            ListModel<String> m = l.getModel();
	            int index = l.locationToIndex(e.getPoint());
	            if( index>-1 ) {
	                l.setToolTipText(getToolTip(m.getElementAt(index).toString()));
	            }
	            else  {
	            	l.setToolTipText("");
	            }
	        }
	    });
		panel.add(list);

		JButton button = new JButton("Compile");
		button.setBounds(100, 538, 100, 20);
		getContentPane().add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 120;
				try {
					int k = Integer.parseInt(textbox.getText());
					if (k < 1000 && k > 4)
						num = k;
				} catch(Exception e2)  {
					e2.printStackTrace();
				}
				List<String> items = list.getSelectedValuesList();
				TrickCollection t = new TrickCollection();
				for (String s : items)
					t.add(s);
				try (PrintWriter p = new PrintWriter(LTDIR + FILE + ".ltx"))  {
					Trick.trickMix(p, num, t);
					Latex.compile(LTDIR, OUTPUT_DIR, FILE);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}

		});
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				display();
			}
		});
	}

	public static void display() {
		// 1. Create the frame.
		JFrame frame = new GUI("TestMaker");

		// 2. Optional: What happens when the frame closes?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 4. Size the frame.
		frame.pack();

		// 5. Show it.
		frame.setVisible(true);
	}
	
	public static void setupTipMappings()  {
		tipMappings = new HashMap<>();
		try {
			Scanner tipScanner = new Scanner(new File("Tipper.txt"));
			while (tipScanner.hasNext()) {
				String className = tipScanner.nextLine().trim();
				while (tipScanner.hasNext() && className.isEmpty())
					className = tipScanner.nextLine().trim();
				
				if (className.isEmpty()) break;
				
				String classInfo = "";
				boolean shouldContinue = true;
				while (tipScanner.hasNext() && shouldContinue)  {
					String next = tipScanner.nextLine().trim();
					if (next.isEmpty()) 
						shouldContinue = false;
					else
						classInfo += next + '\n';
				}
				tipMappings.put(className, classInfo);
				System.out.println(className);
				System.out.println(classInfo);
				System.out.println();
			}
			tipScanner.close();
		} catch(IOException ex)  {
			ex.printStackTrace();
		}
	}
	
	public static String getToolTip(String s)  {
//		if (tipMappings.containsKey(s))
//			System.out.println(s);
//		else
//			System.out.println("NO " + s);
		return tipMappings.get(s.trim());
	}
}
