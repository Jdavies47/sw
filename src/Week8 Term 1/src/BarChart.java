import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BarChart extends JPanel {

	public static final int offset = 20;
	public static int barGap = 10;
	public ArrayList<Measure> measures;
	public static int panelWidth = 600;
	public static int panelHeight = 500;
	public static int maximalBarHeight = 420;
	public static int barWidth() {
		return 3 * barGap;
	}
	public static int xOffset() {
		return 4 * barGap;
	}

	
	public BarChart(ArrayList<Measure> measures) {
		this.measures = measures;
	}

	public int getMaximal(ArrayList<Measure> measures) {
		int maximum = measures.get(0).getValue();
		for (int i = 0; i < measures.size(); i++) {
			if (measures.get(i).getValue() > maximum) {
				maximum = measures.get(i).getValue();
			}
		}
		return maximum;
	}

	public static int normalize(int measure, int maximum) {
		if (maximum == 0) {
			return measure;
		} else {
			return maximalBarHeight * measure / maximum;
		}
	}

	@Override
	/**
	 * Override the paintComponent method from the JPanel class. We display the
	 * entries in 2-dimensional array to be displayed by colouredthe grid matrix
	 * as: 0 not displayed, 1 as green, and 2 as red.
	 * 
	 * @param g
	 *            The graphics component used for painting.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < this.measures.size(); i++) {

			int maximum = getMaximal(this.measures);
			int height = normalize(this.measures.get(i).getValue(), maximum);
			String description = this.measures.get(i).getDescription();
			if (this.measures.size() > 30) {
				barGap = 1;
			}
			g.fillRect(offset + i * xOffset(), maximalBarHeight - height - offset, barWidth(), height);

			g.drawString(description, offset + i * xOffset(), panelHeight - 90);
		}
	}

	public static void displayBarChart(ArrayList<Measure> measures) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BarChart panel = new BarChart(measures);
		frame.setSize(panelWidth, panelHeight);
		frame.add(panel);
		frame.setVisible(true); // makes the application visible.
	}

	public static int randomEl(int low, int high) {
		return (int) (low + (high - low) * Math.random());
	}

	public static String randomName() {
		int r1 = (int) (26 * Math.random());
		int r2 = (int) (26 * Math.random());
		int offset = (int) 'A';
		return "" + (char) (offset + r1) + "." + (char) (offset + r2) + ".";
	}

	public static ArrayList<Measure> randomMeasures(int n, int low, int high) {
		ArrayList<Measure> result = new ArrayList<Measure>();
		for (int i = 0; i < n; i++) {
			result.add(new Measure(randomName(), randomEl(low, high)));
		}
		return result;
	}

	/*
	 * Main method to initialize a matrix and display it.
	 */
	public static void main(String[] args) {
		ArrayList<Measure> measures1 = new ArrayList<Measure>();

		Measure m1 = new Measure("John", 100);
		Measure m2 = new Measure("Mary", 200);
		Measure m3 = new Measure("Sam", 150);

		measures1.add(m1);
		measures1.add(m2);
		measures1.add(m3);

		displayBarChart(randomMeasures(100, 100, 200));

		displayBarChart(measures1);
	}
}
