package assignment03;

import java.util.ArrayList;

public class SyllablesAverageAnalyzer {

	private ArrayList<String> list;
	
	public SyllablesAverageAnalyzer(ArrayList<String> li) {
		list = li;
	}
	
	public String toString() {
		String[] names = {};
		names = list.toArray(names); // "list" is the ArrayList field
		return "" + NameUtilities.averageNumberOfSyllables(names); // ch is the char field
	}
}
