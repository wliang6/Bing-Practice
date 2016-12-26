package assignment03;

public class NameUtilities {

	/*
	 * Counts how many Strings in the array names start with the char ch. 
	 * You cannot assume anything about the upper or lower case of the parameters, 
	 * so test everything in the same case. String has instance methods 
	 * toLowerCase() and toUpperCase() and the class Character has static method 
	 * toLowerCase(char ch) and toUpperCase(char ch). Null or empty Strings in the 
	 * array are skipped. The return value is -1 if names is null or empty.
	 */
	public static int countFirstCharacters(char ch, String[] names){
		int count = 0;
		if(names == null || names.length == 0){
			return -1;
		}
		for(String name : names){
			if(name == null || name.isEmpty()){
				continue;
			}
			name = name.toLowerCase();
			char startLetter = name.charAt(0);
			if(startLetter == ch){
				count++;
			}
		}
		return count;	
	}
	
	/*
	 * Computes the average length of all the Strings in names. 
	 * Null or empty Strings in the array are skipped. The return 
	 * value is -1.0 if names is null or empty.
	 */
	public static double averageLength(String[] names){
		double length = 0.0;
		double avg = 0.0;
		if(names == null || names.length == 0){
			return -1.0;
		} 
		for(String name : names){
			if(name == null || name.isEmpty()){
				continue;
			}
			length += name.length();
		}
		avg = length/names.length;
		return avg;
	}
	
	
	
	public static int countSyllables(String text) {
		int count = 0;
		int end = text.length() - 1;
		if (end < 0) { 
			return 0; 
		} // The empty string has no syllables

		// An e at the end of the word doesn't count as a vowel
		char ch = text.charAt(end);
		if (ch == 'e' || ch == 'E') {
			end--; 
		}

		boolean insideVowelGroup = false;
		for (int i = 0; i <= end; i++) {
			ch = text.charAt(i);
			String vowels = "aeiouyAEIOUY";
			if (vowels.indexOf(ch) >= 0) {
				// ch is a vowel
				if (!insideVowelGroup) {
					// Start of new vowel group
					count++; 
					insideVowelGroup = true;
				}
			} else {
				insideVowelGroup = false;
			}
		}
		// Every word has at least one syllable
		if (count == 0) {
			count = 1;
		}
		return count;      
	}

	
	
	
	/*
	 * computes the average of the number of syllables for all 
	 * the Strings in names. Null or empty Strings in the array 
	 * are skipped. The return value is -1.0 if names is null or empty.
	 */
	public static double averageNumberOfSyllables(String[] names){
		double count = 0.0;
		double avg = 0.0;
		if(names == null || names.length == 0){
			return -1.0;
		} 
		for(String name : names){
			if(name == null || name.isEmpty()){
				continue;
			}
			count += countSyllables(name);
		}
		avg = count/names.length;
		return avg;
	}
	
	
//	//Personal driver to test implemented methods
//	public static void main(String[] args){
//		String[] names = {"Sarah", "Alan", "tom", "Rachel", "adam", "Ariel", "Johnny", "peter", "jess", "Anna"};
//		int count = countFirstCharacters('a', names);
//		System.out.println("The number of 'a's in the string array: " + count);
//		System.out.println("Average length of strings in the string array: " + averageLength(names));
//		
//		System.out.println("Average number of syllables: " + averageNumberOfSyllables(names));
//		
//	}
}
