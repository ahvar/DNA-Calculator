package analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

/**
 * When provided with a string of characters, the Analyzer class calculates the sum of 'A', 'C', 'G', 'T' in 
 * the input, the relative percentages of each character, and the largest consecutive number
 * of each one. All characters other than the above are counted separately and their relative percentages are 
 * calculated as well. Character case is ignored.  
 * 
 * @author Arthur Vargas
 */
public class Analyzer {
	/** The string of character data */
	private StringBuilder str;
	/** Symbol array */
	private final char[] dna = {'a','c','g','t'};
	/** The total count of 'A' */
	private long adenine;
	/** Total count of 'C' */
	private long cytosine;
	/** Total count of 'G' */
	private long guanine;
	/** Total count of 'T' */
	private long thymine;
	/** Total count of other characters */
	private long other;

	/**
	 * Analyzer's constructor accepts a String of characters.
	 * @param input the input string
	 */
	public Analyzer(String fname) {
		str = new StringBuilder();
		readCharFile(fname);
	}
	
	/**
	 * Default constructor for Analyzer
	 */
	public Analyzer() {
		str = new StringBuilder();
	}
	
	/**
	 * Iterates through all characters and counts the instances of 'c'.
	 * @param c the character to count
	 * @return the total occurrences of 'c'
	 */
	public long countCharacter(char c) {
		long count = str.toString().toLowerCase().chars().filter(ch -> ch == Character.toLowerCase(c)).count();
		return count;
	}
	
	/**
	 * Counts the longest consecutive sequence of the c parameter
	 * @param c the character with a consecutive sequence
	 * @return the length of the sequence
	 */
	public long countConsecutive(char c) {
		char ch = Character.toLowerCase(c);
		String string = str.toString().toLowerCase();
		long count = 1;
		long max = 0;
		for(int i = 0; i < string.length(); i++) {
			if( i < string.length() - 1 && string.charAt(i) == ch && string.charAt(i + 1) == ch) count++;
			else {
				if(count > max ) {
					max = count;
				}
				count = 1;
			}
		}
		return max;
	}
	
	/**
	 * Iterates over the DNA array and counts the quantities of each in the string
	 */
	public void countDNA() {
		countAdenine();
		countCytosine();
		countGuanine();
		countThymine();
		countOther();
	}
	
	/**
	 * Starts the program. The user can provide the input character string as a command line 
	 * argument. If no filename is provided, the program will prompt the user for the input.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Analyzer analyzer = null;
		try {
    		if (args.length == 0) {
    			analyzer = new Analyzer();
    			Scanner scan = new Scanner(System.in);
    			System.out.println("Enter character string: ");
    			analyzer.readCharString(scan.next());
    			scan.close();
    		} else if (args.length == 1) {
    			analyzer = new Analyzer(args[0]);
    		} else {
    			throw new IllegalArgumentException("usage: [filename]");
    		} 
    		analyzer.countDNA();
    		analyzer.printCalculations();
		}catch(IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
			System.exit(1);
		}
	}
	
	/**
	 * Reads the character data into the StringBuilder
	 * @param input the string of character data
	 * @throws IllegalArgumentException if there is a problem reading the data
	 */
	private void readCharFile(String input) throws IllegalArgumentException {
		try {
		FileReader fr = new FileReader(input);
		BufferedReader reader = new BufferedReader(fr);
		int c;
		while((c = reader.read()) != -1 ) {
			str.append((char)c);
		}
		reader.close();
		}catch(IOException e) {
		throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	/**
	 * Reads the character data into the StringBuilder
	 * @param input the string of character data
	 * @throws IllegalArgumentException if there is a problem reading the data
	 */
	public void readCharString(String input) throws IllegalArgumentException {
		try {
		StringReader sr = new StringReader(input);
		BufferedReader reader = new BufferedReader(sr);
		int c;
		while((c = reader.read()) != -1 ) {
			str.append((char)c);
		}
		reader.close();
		}catch(IOException e) {
		throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	/**
	 * Prints the count for adenine, cytosine, guanine, and thymine.
	 */
	public void printCalculations() {
		System.out.printf("%s %d %s 2f%% %s", "Total number of Adenine ('A'): " + getAdenine() + ". This is " + getAdenine()/str.length() + "% of the total.\n");
		System.out.printf("%s %d %s 2f%% %s", "Total number of Cytosine ('C'): " + getCytosine() + ". This is " + getCytosine()/str.length() + "% of the total.\n");
		System.out.printf("%s %d %s 2f%% %s", "Total number of Guanine ('G'): " + getGuanine() + ". This is " + getGuanine()/str.length() + "% of the total.\n");
		System.out.printf("%s %d %s 2f%% %s", "Total number of Thymine ('T'): " + getThymine() + ". This is " + getThymine()/str.length() + "% of the total.\n");
		System.out.printf("%s %d %s 2f%% %s", "Total number of other characters: " + getOther() + ". This is " + getOther()/str.length() + "% of the total.\n");
		System.out.println();
		System.out.println("The longest consecutive adenine: " + countConsecutive('a'));
		System.out.println("The longest consecutive cytosine: " + countConsecutive('c'));
		System.out.println("The longest consecutive guanine: " + countConsecutive('g'));
		System.out.println("The longest consecutive thymine: " + countConsecutive('t'));
		
	}

	/**
	 * Returns the total count for Adenine
	 * @return the adenine
	 */
	public long getAdenine() {
		return adenine;
	}

	/**
	 * Sets the total count for Adenine
	 * @param adenine the adenine to set
	 */
	public void countAdenine() {
		this.adenine = this.countCharacter('a');
	}

	/**
	 * Returns the total count for Cytosine
	 * @return the cytosine
	 */
	public long getCytosine() {
		return cytosine;
	}

	/**
	 * Sets the total count for Cytosine
	 * @param cytosine the cytosine to set
	 */
	public void countCytosine() {
		this.cytosine = this.countCharacter('c');
	}

	/**
	 * Returns the total count for Guanine
	 * @return the guanine
	 */
	public long getGuanine() {
		return guanine;
	}

	/**
	 * Sets the count for Guanine
	 * @param guanine the total number of guanine
	 */
	public void countGuanine() {
		this.guanine = this.countCharacter('g');
	}

	/**
	 * Returns the total number of thymine
	 * @return the thymine
	 */
	public long getThymine() {
		return thymine;
	}

	/**
	 * Sets the count for thymine.
	 * 
	 * @param thymine the total number of thymine
	 */
	public void countThymine() {
		this.thymine = this.countCharacter('t');
	}
	
	/**
	 * Counts the number of characters that are not 'A','C','G','T'.
	 */
	public void countOther() {
		this.other = str.length() - (getAdenine() + getGuanine() + getCytosine() + getThymine());
	}
	
	/**
	 * Returns the number of other characters
	 * @return other other characters
	 */
	public long getOther() {
		return other;
	}

	/**
	 * Returns the StringBuilder containing all characters
	 * @return the str
	 */
	public StringBuilder getStr() {
		return str;
	}

	/**
	 * Sets the StringBuilder to the str parameter.
	 * @param str the str to set
	 */
	public void setStr(StringBuilder str) {
		this.str = str;
	}

}
