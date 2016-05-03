/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 5
 * The program reads graphs from a file, and assesses whether they are fully connected or not
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {

	/*  VARIABLES:
	 * string filename: to register user-entry for the location of the file (URI)
	 * Scanner input: to register user-entry
	 * Integer nodes: to store the amount of nodes included in the graph (1st number in the file)
	 * 2D array of integers: to register the first two columns of text in the file
	 */
	
	String filename;
	Scanner input;
	static int nodes;
	int[][] array;

	/**
	 * CONSTRUCTOR creates Graph object 
	 * @param filename user-defined file to read the graph from
	 */
	public Graph(String filename) {

		this.filename = filename;
		try {
			this.input = new Scanner(new File(filename));
			Scanner input = new Scanner(new File(filename));
			nodes = input.nextInt();
			int[][] array = new int[nodes][3];

			for (int x = 0; x < nodes; x++) {
				for (int y = 0; y < 3; y++) {
					array[x][y] = input.nextInt();
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			e.printStackTrace();
		}
	}

	/**
	 * METHOD: to chech if graph is fully connected or not
	 * @return boolean
	 */
	public boolean isFullyConnected() {
		try {
			Scanner input = new Scanner(new File(filename));
			nodes = input.nextInt();
			int[][] array = new int[nodes * nodes][3];
			System.out.println(nodes);
			int x = 0;
			int y = 0;
			int[] value = new int[nodes * nodes];
			int counter = 0;

			while (input.hasNextLine()) {
				for (y = 0; y < 2; y++) {
					if (input.hasNext() == false)
						break;
					array[x][y] = input.nextInt();
					System.out.print(array[x][y] + " ");
				}
				if (input.hasNext() == false)
					break;
				value[x] = input.nextInt();
				System.out.println(value[x]);
				x++;
			}

			for (x = 0; x < value.length; x++) {
				if (value[x] == 0)
					counter++;
			}
			input.close();
			if (counter == ((nodes * nodes) - nodes)) {
				return true;
			} else
				return false;

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			e.printStackTrace();
			return false;
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		Graph g1 = new Graph("g4.graph");
		g1.isFullyConnected();
		if (g1.isFullyConnected() == true) {
			System.out.println("fully connected.");
		} else
			System.out.println("Not fully connected.");
	}
}
