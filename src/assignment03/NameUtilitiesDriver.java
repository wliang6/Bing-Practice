package assignment03;

import java.util.ArrayList;

public class NameUtilitiesDriver {

	/*
	 * Make a Driver class with a main method. In the main method, 
	 * make an ArrayList of Strings called names and in a loop that 
	 * executes 1000 times, add to names using resources.NamesResource.getRandomFirstName().
	 * Make an Arraylist of Object called test containing three objects: 
	 * one each of the three classes FirstCharAnalyzer, LengthAverageAnalyzer, 
	 * and SyllablesAverageAnalyzer. In the constructors use names for the ArrayList parameter 
	 * and pick any char you want for the constructor of FirstCharAnalyzer.
 
	 * Print test.
 
	 * You will get different values every time you run this program 
	 * because of the random name generator but the main point is that even 
	 * though you have three Object elements in the ArrayList, when you call 
	 * toString() on each of them, you execute a really different piece of code. 
	 * That is what happens in polymorphism.
	 */
	public static void main(String[] args){
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i < 1000; i++){
			names.add(resources.NamesResource.getRandomFirstName());
		}

		
		ArrayList<Object> test = new ArrayList<Object>();
		FirstCharAnalyzer f = new FirstCharAnalyzer('a', names);
		LengthAverageAnalyzer l = new LengthAverageAnalyzer(names);
		SyllablesAverageAnalyzer s = new SyllablesAverageAnalyzer(names);
		test.add(f);
		test.add(l);
		test.add(s);
		System.out.println(test);
		
	}
	
}
