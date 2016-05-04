/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 4
 * The program reads a P2 type PGM greyscale image file provided by the user, arranges its colour values to a two-dimensional array
 * (matrix) and performs some simple image manipulation on them, the output of which is presented on the console.
 */

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class PGMImage {

	/*
	 * VARIABLES:
	 * Integer width: width of the image
	 * Integer height: height of the image
	 * Integer maxShade: maximum amount of shade (i.e. black)
	 * Integer array shade: to store all shade values in an array
	 * Scanner input: to register user-input filename
	 * String filename: user-defined file name or path (URI)
	 * String fileType: to store type of file (eg P2, P1)
	 * Integer array[x][y]: stores shade values in a matrix, where x = amount of rows (height), y = amount of columns (width)
	 */
	static int width;
	static int height;
	int maxShade;
	int[] shade = new int[maxShade];
	static Scanner input;
	String fileType;
	static String filename;
	static int[][] pixels = new int[width][height];

	/**
	 * CONSTRUCTOR to create PGMImage objects using user-defined filenames
	 * @param filename user defined filename or path (URI)
	 * @throws IOException is thrown in case file cannot be read, in which case a blank, size: 100*100 PGM image is generated
	 */
	public PGMImage(String filename) throws IOException {
		try { // if there is no I/O error
			PGMImage.filename = filename;	// filename is assigned to the object
			input = new Scanner(Paths.get(PGMImage.filename));	// Scanner input is directed to the filename
			this.fileType = input.next();		// fileType is assigned the first line file (always the type, eg. P2)
			width = input.nextInt();			// width and height are the next values in a PGM file, which are assigned to 
												// integers 'width' and 'height' respectively
			height = input.nextInt();
			maxShade = input.nextInt();			// the last part of the image header is the maximum amount of grey shade, which is
												// assigned to the variable maxShade

			int[][] pixels = new int[width][height]; // the matrix is allocated the size of width*height 

			for (int i = 0; i < width; i++) {			// loops 'i' until counter reaches the amount of width
				for (int j = 0; j < height; j++) {		// loops 'j' until counter reaches the amount of height
					pixels[i][j] = input.nextInt();		// the next integer read from the file is assigned to the array's current value 
				}
			}

		} catch (IOException e) { // if there's an I/O error
			// filling the image with white pixels (maxShade = 0)
			System.out.println("File doesn't exist. Colouring pixels white. ");
			// creating an image of size 100*100
			width = 100;
			height = 100;
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					shade[i + j] = 0; // all shade values 0 (white)
				}
			}
		}
		input.close(); // input closed
	}

	/**
	 * getter to retrieve
	 * @return pixels array
	 */
	public static int[][] getPixels() {
		return pixels;
	}

	// method to invert greyscale of image
	public void invert() throws IOException {

		// image header begins
		System.out.println(fileType);
		System.out.print(width + " ");
		System.out.println(height);
		System.out.println(maxShade);
		// image header over

		input = new Scanner(Paths.get(PGMImage.filename));	// Scanner input is directed to the filename
		this.fileType = input.next();		// fileType is assigned the first line file (always the type, eg. P2)
		width = input.nextInt();			// width and height are the next values in a PGM file, which are assigned to 
											// integers 'width' and 'height' respectively
		height = input.nextInt();
		maxShade = input.nextInt();			// the last part of the image header is the maximum amount of grey shade, which is
											// assigned to the variable maxShade
		int[] shade = new int[width * height]; // shade array of integers is alloted the size of width*height in order to be able to store
												 // all values in a single array

		for (int i = 0; i < width; i++) {			// loops i until it reaches the size of width
			for (int j = 0; j < height; j++) {		// loops j until it reaches the size of height
				shade[i + j] = input.nextInt();		// current shade index is assigned the next integer value
				if (shade[i + j] >= 128) {			// if the value is equal to or greater than 128, it is then subtracted from 
													// the maximum 255 which will provide the inverted shade value.
													// the exact opposite happens in case the value is smaller than 128 i.e. the value is
													// subtracted from 128, and the result is added to 128 to provide its inverted shade value.
													//
													//    BLACK------------------MIDDLE------------------WHITE
													//      0---x-----------------128---------------------255
													//
													//							becomes 
													//
													//    BLACK------------------MIDDLE------------------WHITE
													//      0--------------------128------------------x---255
													//

					shade[i + j] = 255 - shade[i + j];
				} else {
					int tmp = 128 - shade[i + j];
					shade[i + j] = 128 + tmp;
				}
				System.out.println(shade[i + j]);	// inverted values printed on the console
			}
		}
		input.close();	// input closed
	}

	// method to rotate image clockwise by 90
	public void rotateClockwise() throws IOException {
		input = new Scanner(Paths.get(PGMImage.filename));	// Scanner input is directed to the filename
		this.fileType = input.next();		// fileType is assigned the first line file (always the type, eg. P2)
		width = input.nextInt();			// width and height are the next values in a PGM file, which are assigned to 
											// integers 'width' and 'height' respectively
		height = input.nextInt();
		maxShade = input.nextInt();			// the last part of the image header is the maximum amount of grey shade, which is
											// assigned to the variable maxShade
		// image header begins
		System.out.println(fileType);
		System.out.print(width + " ");
		System.out.println(height);
		System.out.println(maxShade);
		// image header over

		int i = 0;
		int j = 0;
		int y = 0;

		int[][] pixels = new int[height + width][height + width];
		int[][] temp = new int[height+width][height+width];
		int[][] rotated = new int[height + width][height + width];

		int newWidth = width;
		int newHeight = height;
		for (i = 0; i < newHeight; ++i) {

			for (j = 0; j < newWidth; ++j) {
				pixels[i][j] = input.nextInt();
				temp[i][width - j - 1]= pixels[j][i];
			}
			
			for (y = 0; y < newWidth; y++) {
				rotated[i][y] = temp[i][y];
				System.out.println(rotated[i][y]);
			}
			
		}
	}

	// P2 to P1 conversion
	public void exportToP1(String filename) throws IOException {
		// image header begins
		System.out.println("P1");	
		System.out.print(width + " ");
		System.out.println(height);
		// image header over

		input = new Scanner(Paths.get(PGMImage.filename));	// Scanner input is directed to the filename
		this.fileType = input.next();		// fileType is assigned the first line file (always the type, eg. P2)
		width = input.nextInt();			// width and height are the next values in a PGM file, which are assigned to 
											// integers 'width' and 'height' respectively
		height = input.nextInt();
		maxShade = input.nextInt();			// the last part of the image header is the maximum amount of grey shade, which is
											// assigned to the variable maxShade

		int[] shade = new int[width * height]; // shade array of integers is alloted the size of width*height in order to be able to store
		 										 // all values in a single array
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				shade[i + j] = input.nextInt();
				if (shade[i + j] >= 128) {		// if the shade value is closer to 0 on a scale of 0-255, the value is changed to 0 (black)
					shade[i + j] = 1;			// if the shade value is closer to 255 on a scale of 0-255, the value is changed to 1(white)
				} else {
					shade[i + j] = 0;
				}
				System.out.println(shade[i + j]);	// converted black and white P1 image values are displayed on the console
			}
		}
		input.close();	// input closed
	}

	public static void main(String[] args) throws IOException {
		
		
		// TESTING: (note: as the program does not write any data on the disk, testing is only possible by copying
		// image data from the console display into a file in a text editor, saving it and viewing the file as an image)
		
		PGMImage photo = new PGMImage("image.pgm");
		// photo.invert();
		photo.rotateClockwise();
		// photo.exportToP1("image.pgm");

	}
}