package assignment03;


//Write a separate test driver with tests for all the methods of DollarsAndCents.
public class DollarsAndCentsDriver {
	public static void main(String[] args){
		
		//Each test results in a cumulative dollar and cents value after each occuring method. 
		
		DollarsAndCents dc1 = new DollarsAndCents(100, 50);  //$100.50
		DollarsAndCents dc2 = new DollarsAndCents(1, 20);    //$1.20
		DollarsAndCents dc3 = new DollarsAndCents(5, 0);     //$5.00

		
		DollarsAndCents [] array = {dc1, dc2, dc3};
		
		DollarsAndCents test1 = new DollarsAndCents();        //$0.00
		DollarsAndCents test2 = new DollarsAndCents(523);     //$5.23
		DollarsAndCents test3 = new DollarsAndCents(10, 50);  //$10.50
		DollarsAndCents test4 = new DollarsAndCents(10, 130); //$11.30

	
		//TEST ONE will throw an IllegalArgumentException because of the lessThan() method. This is expected!
//	    System.out.println("");
//	    System.out.println("Testing test1.add(), expect $106.70"); 
//	    System.out.println(test1.add(array)); 
//	    System.out.println("Testing test1.lessThan(), expect false"); 
//	    System.out.println(test1.lessThan(dc2)); 
//	    System.out.println("Testing test1.subtract(), expect IllegalArgumentxception error"); 
//	    System.out.println(test1.subtract(dc3)); 
//	    System.out.println("Testing test1.upOrDown(), expect $1220.40"); 
//	    System.out.println(test1.upOrDown(12)); 
//	    System.out.println("");
		
	    System.out.println("");
	    System.out.println("Testing test2.add(), expect $111.93"); 
	    System.out.println(test2.add(array)); 
	    System.out.println("Testing test2.lessThan(), expect false"); 
	    System.out.println(test2.lessThan(dc2)); 
	    System.out.println("Testing test2.subtract(), expect $0.23"); 
	    System.out.println(test2.subtract(dc3)); 
	    System.out.println("Testing test2.upOrDown(), expect $62.76"); 
	    System.out.println(test2.upOrDown(12)); 
	    System.out.println("");
	    
	    System.out.println("");
	    System.out.println("Testing test3.add(), expect $117.20"); 
	    System.out.println(test3.add(array)); 
	    System.out.println("Testing test3.lessThan(), expect false"); 
	    System.out.println(test3.lessThan(dc2)); 
	    System.out.println("Testing test3.subtract(), expect $5.50"); 
	    System.out.println(test3.subtract(dc3)); 
	    System.out.println("Testing test3.upOrDown(), expect $126.00"); 
	    System.out.println(test3.upOrDown(12)); 
	    System.out.println("");
	    
	    System.out.println("");
	    System.out.println("Testing test4.add(), expect $118.00"); 
	    System.out.println(test4.add(array)); 
	    System.out.println("Testing test4.lessThan(), expect false"); 
	    System.out.println(test4.lessThan(dc2)); 
	    System.out.println("Testing test4.subtract(), expect $6.30"); 
	    System.out.println(test4.subtract(dc3)); 
	    System.out.println("Testing test4.upOrDown(), expect $135.60"); 
	    System.out.println(test4.upOrDown(12)); 
	    System.out.println("");
	}

}
