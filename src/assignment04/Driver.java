package assignment04;

import java.util.ArrayList;

public class Driver {
public static void main(String[] args){
	
	System.out.println("Tests for oddEvenCount method");
	long [] array = {5,2,1,5,3,4,6,2}; //sample array
	long [] nullarray = null; //null array
	long [] emptyarray = new long [0]; //empty array
	long [] array1 = new long [1]; //array with length 1

	System.out.println("Test 1 : Expected: 3, " + VariousMethods.oddEvenCount(array));
	System.out.println("Test 2 : Expected: -1, " + VariousMethods.oddEvenCount(nullarray));
	System.out.println("Test 3 : Expected: 0, " + VariousMethods.oddEvenCount(emptyarray));
	System.out.println("Test 4 : Expected: 0, " + VariousMethods.oddEvenCount(array1));
	
	System.out.println("-----------------------------------");
	
	System.out.println("Tests for minCount method");
	

	BankAccount acc1 = new BankAccount(20.0); 
	BankAccount acc2 = new BankAccount(55.0);
	BankAccount acc3 = new BankAccount(70.0);
	BankAccount acc4 = new BankAccount(150.0);
	
	ArrayList<BankAccount> list = new ArrayList<>(); 
	list.add(acc1);
	list.add(acc2);
	list.add(acc3);
	list.add(acc4);
	
	ArrayList <BankAccount > seclist = null; 
	
	System.out.println("Test 1 : Expected: 3, " + VariousMethods.minCount(20.0, list));
	System.out.println("Test 2 : Expected: -1, " + VariousMethods.minCount(10.0, seclist));

	System.out.println("-----------------------------------");
	
	System.out.println("Tests for justAnExercise method");
	
	Person Bob = new Person("Bob", 20, 3, 1968);
	Person Rachel = new Person("Rachel", 4, 6, 1989);
	Person David = new Person("David", 15, 9, 1993);
	Person May = new Person("May", 28, 10, 2000);
	Person Michael = new Person("Michael", 10, 10, 1957);
	Person Samantha = new Person("Samantha", 2, 1, 1995);
	Person Eric = new Person("Eric", 29, 11, 1980);
	Person Michelle = new Person("Michelle", 9, 8, 1989);
	Person Rondo = new Person("Rondo", 22, 7, 1985);
	Person Leslie = new Person("Leslie", 25, 12, 1971);
	
	BankAccount ba1 = new BankAccount(10.20);
	BankAccount ba2 = new BankAccount(1000);
	BankAccount ba3 = new BankAccount(500.00);
	BankAccount ba4 = new BankAccount(620.00);
	BankAccount ba5 = new BankAccount(30.00);
	BankAccount ba6 = new BankAccount(200.00);
	BankAccount ba7 = new BankAccount(245.10);
	BankAccount ba8 = new BankAccount(150.00);
	BankAccount ba9 = new BankAccount(100.70);
	BankAccount ba10 = new BankAccount(300.00);
	
	ba1.setCustomer(Bob); 
	ba2.setCustomer(Rachel); 
	ba3.setCustomer(David); 
	ba4.setCustomer(May); 
	ba5.setCustomer(Michael);
	ba6.setCustomer(Samantha);
	ba7.setCustomer(Eric);
	ba8.setCustomer(Michelle); 
	ba9.setCustomer(Rondo);
	ba10.setCustomer(Leslie);
	
	BankAccount[] test1 = null; 
	BankAccount[] test2 = {};
	BankAccount[] test3 = {null, null, null};
	BankAccount[] test4 = {ba2, ba5, ba10 };
	BankAccount[] test5 = {ba3, null, ba8, null, ba10, null, ba9 };
	BankAccount[] test6 = {ba2, ba7, ba5, ba10, ba9, ba2 };
	BankAccount[] test7 = {null, null, ba1, null, ba9, null, null, null, ba5, ba2, null };
	BankAccount[] test8 = {ba10, null, null, ba2, null, ba9, ba2, ba3, null, null, null, null, ba3 };
	BankAccount[] test9 = {null, null, null, null, null, ba7, null, null, ba2, null, null, ba1, null };
	BankAccount[] test10 = {ba4, ba5, ba10, ba9, null, ba8 };
	
	System.out.println("Test 1 : Expected: -1.0, " + VariousMethods.justAnExercise(20 , 'X', test1));
	System.out.println("Test 2 : Expected: -1.0, " + VariousMethods.justAnExercise(500, 'A', test2));
	System.out.println("Test 3 : Expected: -1.0, " + VariousMethods.justAnExercise(15.00 , 'Z', test3));
	System.out.println("Test 4 : Expected: -1.0, " + VariousMethods.justAnExercise(300.00, 'W', test4));
	System.out.println("Test 5 : Expected: 300.0, " + VariousMethods.justAnExercise(300.00 , 'M', test5));
	System.out.println("Test 6 : Expected: 1000.0, " + VariousMethods.justAnExercise(50.00, 'R', test6));
	System.out.println("Test 7 : Expected: 10.2, " + VariousMethods.justAnExercise(700 , 'B', test7));
	System.out.println("Test 8 : Expected: 500.0, " + VariousMethods.justAnExercise(700.00, 'R', test8));
	System.out.println("Test 9 : Expected: 10.2, " + VariousMethods.justAnExercise(1000.00 , 'B', test9));
	System.out.println("Test 10 : Expected: 620.0, " + VariousMethods.justAnExercise(1000.00, 'D', test10));

	System.out.println("-----------------------------------");
	
	System.out.println("Tests for anotherExercise method");
	
	ArrayList<BankAccount> firList = new ArrayList<BankAccount> ();
	firList.add(null);
	firList.add(ba3);
	firList.add(null);
	firList.add(ba6); 
	firList.add(ba8); 
	
	System.out.println("Test 1 : Expected: 4, " + VariousMethods.anotherExercise(firList));
	
	ArrayList<BankAccount> secList = new ArrayList<BankAccount> ();
	
	secList.add(null);
	secList.add(null);
	secList.add(null);
	
	System.out.println("Test 2 : Expected: -1, " + VariousMethods.anotherExercise(secList));
	System.out.println("Test 3 : Expected: -1, " + VariousMethods.anotherExercise(null));
	
	ArrayList<BankAccount> emptyList = new ArrayList<BankAccount> ();
	System.out.println("Test 4 : Expected: -1, " + VariousMethods.anotherExercise(emptyList));
}

}

