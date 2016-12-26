package assignment05;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Question1 {
	
	public static int[] counter(String s) {
		s = s.toLowerCase();
		int [] array = new int[26];
		
		int count = 0;
		for (char ch = 'a' ; ch <= 'z' ; ch++) {
			if (ch >= 'a' && ch <= 'z') {
				for (int i = 0 ; i < s.length() ; i++) {
					if(ch == s.charAt(i))
						count ++;
				}
				array[ch - 'a'] = count;
			}
		}
		return array;
	}
	
	public static boolean permutation1(String s1, String s2) {
		if(s1 == null || s2 == null){
			return false;
		}
	    return Arrays.equals(counter(s1), counter(s2));
	}
	
	
	public static int count(char c, String s) {
		int count = 0;
		for(char ch : s.toCharArray()) {
			if (c == ch) {
				count++;
			}
		}
		return count;
	}
	
	 public static boolean permutation2(String s1, String s2) {
		 s1 = s1.toLowerCase();
		 s2 = s2.toLowerCase();
		 boolean retVal = true;
		 for(char c = 'a'; c <= 'z'; c++) {
			 if (count(c, s1) != count(c, s2)) {
				 retVal = false;
			 }
		 }
		 return retVal;
	 }
	
	 
	static class MyChCounter {
	    char c;
	    int count = 1;
	    MyChCounter(char c1) {
	        c = c1;
	    }
	    void increment() {
	        count++;
	    }
	    @Override
	    public boolean equals(Object obj) {
	        boolean retVal = false;
	        if(obj != null && getClass() == obj.getClass()) {
	            MyChCounter m = (MyChCounter)obj;
	            retVal = (c == m.c && count == m.count);
	        }
	        return retVal;
	    }        
	    @Override
	    public int hashCode() {
	        return Character.hashCode(c)*31 + Integer.hashCode(count);
	    }
	}
	
	public static boolean permutation3(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		Map<Character, MyChCounter> counter1 = new TreeMap<>();
		Map<Character, MyChCounter> counter2 = new TreeMap<>();
		
		for (char c : s1.toCharArray()) {
			if (Character.isLetter(c)) {
				if (counter1.containsKey(c)) {
					counter1.get(c).increment();
				}
				else {
					counter1.put(c, new MyChCounter(c));
				}
			}
		}
		for (char c : s2.toCharArray()) {
			if (Character.isLetter(c)) {
				if (counter2.containsKey(c)) {
					counter2.get(c).increment();
				}
				else {
					counter2.put(c, new MyChCounter(c));
				}
			}
		}
		return counter1.equals(counter2);
	}

	public static void main(String[] args) {
		System.out.println(permutation1("Here's the cinema", "The Iceman's here"));
		System.out.println(permutation1("Here's the machine", "The Iceman's here"));
		System.out.println("");
		System.out.println(permutation2("Here's the cinema", "The Iceman's here"));
		System.out.println(permutation2("Here's the machine", "The Iceman's here"));
		System.out.println("");
		System.out.println(permutation3("Here's the cinema", "The Iceman's here"));
		System.out.println(permutation3("Here's the machine", "The Iceman's here"));
	}
}
