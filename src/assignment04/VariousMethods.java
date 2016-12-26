package assignment04;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.text.NumberFormatter;


public class VariousMethods {

	/*
	 * Returns how many elements in the array at odd index 
	 * values (index 1, 3, 5, 7, ...) are even numbers. The return 
	 * value is -1 if the array is null and 0 if the array is empty 
	 * or only has length 1.
	 */
	public static int oddEvenCount(long[] arr){
		if(arr == null) return -1;
		if(arr.length == 0 || arr.length == 1) return 0;
		int counter = 0;
		for(int i = 0; i < arr.length; i++){
			if(i%2 == 1 && arr[i]%2 == 0){
				counter++;
			}
		}
		return counter;
	}
	
	/*
	 * Counts how many elements in the list with a balance that 
	 * is greater than min (-1 if list is null)
	 */
	public static int minCount(double min, ArrayList<BankAccount> list){
		if(list == null) return -1;
		int counter = 0;
		for(BankAccount b : list){
			if(b.getBalance() > min){
				counter++;
			}
		}
		return counter;
	}
	
	/*
	 * Returns the largest balance among the BankAccounts that satisfy one of the following 
	 * condtions depending on their indices in the array:
	 * 
		The array index is a multiple of 3 and the balance of the account is less than cap.
		The array index is 1 greater than a multiple of 3 and the account id is even.
		The array index is 2 greater than a multiple of 3 and the first letter of the String 
		name is the letter initial (independent of upper or lower case)
		 
		The return value is -1.0 if the array is null or there were not any non-null elements
		that satisfy the conditions. YES elements of arr can be null.
		Note that the final largest balance may turn out to be greater than or equal to cap,
	 	because cap only applies to indices 0, 3, 6, 9, ...
	 */
	public static double justAnExercise(double cap, char initial, BankAccount[] arr){
		if(arr == null || arr.length == 0) return -1.0;
		double largestBalance = 0.0;
		ArrayList<Double> balances = new ArrayList<>();
		for(int i = 0; i < arr.length; i++){
			BankAccount account = arr[i];
			if(account != null && i%3 == 0 && account.getBalance() < cap){
				balances.add(account.getBalance());
			}
			else if(account != null && i%3 == 1 && account.getID()%2 == 0){
				balances.add(account.getBalance());
			}
			else if(account != null && i%3 == 2 && account.getCustomer().getName().toLowerCase().charAt(0) == Character.toLowerCase(initial)){
				balances.add(account.getBalance());
			}
			else{ 
				balances.add(-1.0);
			}
		}
		largestBalance = Collections.max(balances);
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.parseDouble(df.format(largestBalance));
		//return largestBalance;
	}
	
	
	/*
	 * Returns the index in list, where the BankAccount customer 
	 * with the longest name occurs. If there is a tie, give the 
	 * LAST index. Return -1 if there is no index because of things
	 * being null.
	 */
	public static int anotherExercise(ArrayList<BankAccount>list) {
		if(list == null || list.size() == 0) return -1;
		int highestIndex = 0, currLength = 0, highestLength = 0;
		BankAccount account;
		for(int i = 0; i < list.size(); i++){
			account = list.get(i);
			if(account != null){
				currLength = account.getCustomer().getName().length();
				if(currLength > highestLength){
					highestLength = currLength;
					highestIndex = i;
				}
				else if(currLength == highestLength){
					highestIndex = list.lastIndexOf(account); //we assume professor meant LAST index of the string in case of strings are equal condition
				}
			} else{
				highestIndex = -1;
			}
		}
		return highestIndex;
	}
	
	
}
