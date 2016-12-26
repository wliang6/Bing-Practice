package assignment02;

//Write a separate test driver with tests for all the methods of DollarsAndCents.
public class Driver {
	public static void main(String[] args){
		
		//Each test results in a cumulative dollar and cents value after each occuring method. 
		
		DollarsAndCents dc1 = new DollarsAndCents();
		DollarsAndCents dc2 = new DollarsAndCents();
		DollarsAndCents dc3 = new DollarsAndCents();
		dc1.setDollars(100); dc1.setCents(50); //$100.50
		dc2.setDollars(1); dc2.setCents(20);   //$1.20
		dc3.setDollars(0); dc3.setCents(500);  //$5.00
		
		DollarsAndCents [] array = {dc1, dc2, dc3};
		
		DollarsAndCents test1 = new DollarsAndCents();        //$0.00
		DollarsAndCents test2 = new DollarsAndCents(523);     //$5.23
		DollarsAndCents test3 = new DollarsAndCents(10, 50);  //$10.50
		DollarsAndCents test4 = new DollarsAndCents(10, 130); //$11.30

	
	    System.out.println("");
	    System.out.println("Testing test1.add(), expect $106.70"); 
	    System.out.println(test1.add(array)); 
	    System.out.println("Testing test1.lessThan(), expect false"); 
	    System.out.println(test1.lessThan(dc2)); 
	    System.out.println("Testing test1.subtract(), expect $101.70"); 
	    System.out.println(test1.subtract(dc3)); 
	    System.out.println("Testing test1.upOrDown(), expect $1220.40"); 
	    System.out.println(test1.upOrDown(12)); 
	    System.out.println("");
		
	    System.out.println("");
	    System.out.println("Testing test2.add(), expect $111.93"); 
	    System.out.println(test2.add(array)); 
	    System.out.println("Testing test2.lessThan(), expect false"); 
	    System.out.println(test2.lessThan(dc2)); 
	    System.out.println("Testing test2.subtract(), expect $106.93"); 
	    System.out.println(test2.subtract(dc3)); 
	    System.out.println("Testing test2.upOrDown(), expect $1283.16"); 
	    System.out.println(test2.upOrDown(12)); 
	    System.out.println("");
	    
	    System.out.println("");
	    System.out.println("Testing test3.add(), expect $117.20"); 
	    System.out.println(test3.add(array)); 
	    System.out.println("Testing test3.lessThan(), expect false"); 
	    System.out.println(test3.lessThan(dc2)); 
	    System.out.println("Testing test3.subtract(), expect $112.20"); 
	    System.out.println(test3.subtract(dc3)); 
	    System.out.println("Testing test3.upOrDown(), expect $1346.40"); 
	    System.out.println(test3.upOrDown(12)); 
	    System.out.println("");
	    
	    System.out.println("");
	    System.out.println("Testing test4.add(), expect $118.00"); 
	    System.out.println(test4.add(array)); 
	    System.out.println("Testing test4.lessThan(), expect false"); 
	    System.out.println(test4.lessThan(dc2)); 
	    System.out.println("Testing test4.subtract(), expect $113.00"); 
	    System.out.println(test4.subtract(dc3)); 
	    System.out.println("Testing test4.upOrDown(), expect $1356.00"); 
	    System.out.println(test4.upOrDown(12)); 
	    System.out.println("");
	}

}
