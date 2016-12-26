package assignment06;

import java.math.BigInteger;

public class Question1 {
	public static String name(int n) {
	      if (n >= 26*26*26*26*26*26) return "ZZZZZZ";
	      if (n < 0) return "AAAAAA";
	      char[] chs = Integer.toString(n, 26).toCharArray();
	      char[] chs2 = new char[6];
	      System.arraycopy(chs, 0, chs2, 6-chs.length, chs.length);
	      for(int i = 0; i < 6; i++) {
	         if(chs2[i] == 0) chs2[i] = 'A';
	         if(chs2[i] >= '0' && chs2[i] <= '9') chs2[i] = (char)('A' + chs2[i]-'0');
	         if(chs2[i] >= 'a' && chs2[i] <= 'p') chs2[i] = (char)('A' + 10 + chs2[i]-'a');
	      }		
	      return new String(chs2);
	   }
	
	   public static void main(String[] args) {
	      for(int n = 10000; n < 11000; n++) {
	         System.out.println(name(n));
	      }
	      System.out.println(name(0));
	      System.out.println(name(26*26*26*26*26*26 - 2));
	      System.out.println(name(26*26*26*26*26*26 - 1));
	      System.out.println(26*26*26*26*26*26); //308,915,776
	   
	      //Additional test cases
	      
	      System.out.println("");
	      System.out.println("nameToInt(\"AAAAAB\") is : " + nameToInt("AAAAAB"));
	      System.out.println("nameToInt(\"AAAABB\") is : " + nameToInt("AAAABB"));
	      System.out.println("nameToInt(\"ZZZZZZ\") is : " + nameToInt("ZZZZZZ"));
	      System.out.println("nameToInt(\"AAAAAA\") is : " + nameToInt("AAAAAA"));
	      System.out.println("nameToInt(\"ZZZZZX\") is : " + nameToInt("ZZZZZX"));
	      System.out.println("nameToInt(\"ABCDEF\") is : " + nameToInt("ABCDEF"));
	      
	      System.out.println("");
	      
	      System.out.println(name(49920));
	      System.out.println(name(720));
	      
	      System.out.println("");
	      
	      System.out.println("next(ZZZZZZ) is AAAAAA : " + next("ZZZZZZ"));
	      System.out.println("next(AAAQGR) is AAAQGS : " + next("AAAQGR"));
	      System.out.println("next(AAAQGZ) is AAAQHA : " + next("AAAQGZ"));
	      
	      System.out.println("");
	      
	      System.out.println("previous(AAAQGR) is AAAQGQ : " + previous("AAAQGR"));
	      System.out.println("previous(AAAQGA) is AAAQFZ : " + previous("AAAQGA"));
	      System.out.println("previous(AAAAAA) is ZZZZZZ : " + previous("AAAAAA"));
	      
	   }
	   
	   public static int nameToInt(String str){
		   if(str == null || str.length() == 0) 
			   return -1;
		   if(str == "AAAAAA") 
			   return 0;
		   if(str == "ZZZZZZ") 
			   return (int)Math.pow(26, 6) - 1;
		   
		   str = new StringBuilder(str).reverse().toString().trim();
		   char[] array = str.toCharArray();
		   double num = 0;
		   for(int i = 0; i < array.length; i++){
			   char ch = array[i];
			   if('A' <= ch && ch <= 'Z'){
				   num += (int)(ch - 'A') * Math.pow(26, i);
			   }
		   }
		   return (int)num;
	   }
	   
	   
	   public static String next(String str){
		   if(str == null || str.length() == 0) 
			   return null;
		   if(str == "ZZZZZZ") 
			   return "AAAAAA";
		   if(nameToInt(str) != -1)
			   return name(nameToInt(str) + 1);
		   return null;
	   }
	   
	   public static String previous(String str){
		   if(str == null || str.length() == 0) 
			   return null;
		   if(str == "AAAAAA") 
			   return "ZZZZZZ";
		   if(nameToInt(str) != -1)
			   return name(nameToInt(str) - 1);
		   return null;
	   }
	   
	   
}
