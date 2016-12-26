package ArrayStats;
import java.util.Arrays;

// Write a test driver class that imports java.util.Arrays and has a main method that tests your code on the following:

public class Driver {
  public static void main(String[] args){
    ArrayStats test1 = new ArrayStats();
    ArrayStats test2 = new ArrayStats(null); // this equivalent passing an empty array {} as the argument 

    double[] arr = {7, 2, 3, 6, 8, 2, 1, 3, 6, 3, -4, 0, -5, 8}; 
    ArrayStats test3 = new ArrayStats(arr);
    
    System.out.println("");
    System.out.println("Testing test1.getData(), expect []"); 
    System.out.println(Arrays.toString(test1.getData())); 
    System.out.println("Testing test1.getMax(), expect 0.0"); 
    System.out.println(test1.getMax()); 
    System.out.println("Testing test1.getMin(), expect 0.0"); 
    System.out.println(test1.getMin()); 
    System.out.println("Testing test1.getMaxIdx(), expect -1"); 
    System.out.println(test1.getMaxIdx()); 
    System.out.println("Testing test1.getMinIdx(), expect -1"); 
    System.out.println(test1.getMinIdx()); 
    System.out.println("Testing test1.getAvg(), expect 0.0"); 
    System.out.println(test1.getAvg());
    System.out.println("");

    
    System.out.println("");
    System.out.println("Testing test2.getData(), expect null"); 
    System.out.println(Arrays.toString(test2.getData())); 
    System.out.println("Testing test2.getMax(), expect 0.0"); 
    System.out.println(test2.getMax()); 
    System.out.println("Testing test2.getMin(), expect 0.0"); 
    System.out.println(test2.getMin()); 
    System.out.println("Testing test2.getMaxIdx(), expect -1"); 
    System.out.println(test2.getMaxIdx()); 
    System.out.println("Testing test2.getMinIdx(), expect -1"); 
    System.out.println(test2.getMinIdx()); 
    System.out.println("Testing test2.getAvg(), expect 0.0"); 
    System.out.println(test2.getAvg());
    System.out.println("");

    
    System.out.println("");
    System.out.println("Testing test3.getData(), expect [7.0, 2.0, 3.0, 6.0, 8.0, 2.0, 1.0, 3.0, 6.0, 3.0, -4.0, 0.0, -5.0, 8.0]"); 
    System.out.println(Arrays.toString(test3.getData())); 
    System.out.println("Testing test3.getMax(), expect 8.0"); 
    System.out.println(test3.getMax()); 
    System.out.println("Testing test3.getMin(), expect -5.0"); 
    System.out.println(test3.getMin()); 
    System.out.println("Testing test3.getMaxIdx(), expect 4"); 
    System.out.println(test3.getMaxIdx()); 
    System.out.println("Testing test3.getMinIdx(), expect 12"); 
    System.out.println(test3.getMinIdx()); 
    System.out.println("Testing test3.getAvg(), expect 2.857142857142857"); 
    System.out.println(test3.getAvg());
    System.out.println("");

  }
}