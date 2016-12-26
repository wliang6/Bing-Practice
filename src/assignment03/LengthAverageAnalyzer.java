package assignment03;

import java.util.ArrayList;

public class LengthAverageAnalyzer {

	private ArrayList<String> list;
	
	public LengthAverageAnalyzer(ArrayList<String> li) {
		list = li;
	}
	
	public String toString() {
		String[] names = {};
		names = list.toArray(names); // "list" is the ArrayList field
		return "" + NameUtilities.averageLength(names); // ch is the char field
	}
	
}
