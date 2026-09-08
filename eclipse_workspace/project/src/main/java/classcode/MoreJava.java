package classcode;
import static stdlib.StdOut.println;
import stdlib.StdOut;
import java.util.Arrays;
import java.util.ArrayList;


public class MoreJava {
  
  
  public static void printStars() {
    println("\n*****\n");
  }
  
  
  // parameter requires a type
  // returns double[] reference
  // swaps values
  public static void reverseInPlace(double[] arr) {
    /*
    TODO: Complete reverseInPlace so that reverses the array by 
          swaping values at indices 0 and N-1, 1 and N-2, etc. 
     */
     // {1, 2, 3, 4, 5}
     //   {5, 2, 3, 4, 1}
     //   {5, 4, 3, 2, 1}
  }
  
  // assume variables in main are defined as val = 0, arr = {99, 98, 97}
  // return type void, so method does not return an object
  public static void passByValue(int val, int[] arr) {
    val += 1;
    arr[0] = 100;
  }
  
  public static void main(String[] args) {
  
    // primitive equality operators
    int a = 3;
    int b = 3;
    int c = a;  // c is a copy of the value of a (primitiive) (not an alias)
    StdOut.println(a == b);
    StdOut.println(a != c);
    printStars();
     
    // object types check equality differently
    // most objects are like this (except raw arrays and Strings)
    // this includes custom objects with .equals() overridden appropriately
    ArrayList<Integer> lst1 = new ArrayList<Integer>();
    ArrayList<Integer> lst2 = new ArrayList<Integer>();
    lst1.add(1); lst1.add(2);
    lst2.add(1); lst2.add(2);
    println(lst1);   
    println(lst2);
    println(lst1 == lst2);
    println(lst1.equals(lst2));
    printStars();
    
    
    // raw arrays need Arrays static methods to check equality
    int[] arr1 = new int[] {3, 4};   // can also use int[] arr1 = new int[] {3, 4};
    int[] arr2 = new int[] {3, 4};
    println(arr1);
    println(arr2);
    println(Arrays.toString(arr1));
    println(Arrays.toString(arr2));
    println(arr1 == arr2);   // .equals() is the same, not overridden
                             //
    // TODO: use the arr1.equals(arr2) with raw arrays, but unimpl

    println(Arrays.equals(arr1, arr2)); 
    printStars();
   
    // Integer == does compare references 
    // Integer, Double, etc. are object types
    Integer i2 = new Integer(1);
    Integer i3 = new Integer(1);
    StdOut.println(i2);
    StdOut.println(i3);
    StdOut.println(i2 == i3);
    StdOut.println(i2.equals(i3));
    
    // String (even though object type) == compared the values
    String n1 = "Ben";
    String n2 = "Ben";
    StdOut.println(n1);
    StdOut.println(n1 == n2);
    StdOut.println(n1.equals(n2));
    printStars();
    // can create aliases on object types through variables
    // change an object using its alias
    
    StdOut.println("aliases ...");
    double[] arrA = {1.1, 1.2, 1.3};
    double[] arrB = arrA;
    arrB[1] = 0;
    println(Arrays.toString(arrA));
    println(Arrays.toString(arrB));
    double[] arrACopy = Arrays.copyOf(arrA, arrA.length);
    println(arrACopy == arrA);  // two diff refs (false)
    println(arrA == arrB);   // aliases, hold the same reference, true
                               
    // TODO: add using Arrays.equals() to check values
      
    println(arrACopy.equals(arrA));  // false, bc they are raw arrays, no .equals impl
    printStars();
    
    // pass by value functions
    int val2 = 0;
    int[] arr4 = {99, 98, 97};
    passByValue(val2, arr4);
    println(val2);  // 0
    println(Arrays.toString(arr4));  // [100, 98, 97]
    printStars();
   
    // int err = 1/0;
    // handle an exception
    
    try {
      double badval = 1/0;
      println("Does not execute");
    }
    catch (ArithmeticException ex) {
       println(ex);
    }
    println("Execution continues!");
    
    
    // force an exception
    try {
      throw new Exception("Stop!");
    }
    catch (Exception ex) {
      println(ex);
    }
    println("Continue!");
    
    // call static function
    double[] darr = {1.0, 2.0, 3.0, 4.0};
    reverseInPlace(darr);
    println(Arrays.toString(darr));
    printStars();
    
    
    // arrays will not allow access to elements in invalid indices, throws exception
    int[] iarr4 = new int[] {5, 6, 7, 8, 9, 10};
    for (int i = 0; i < iarr4.length - 1; ++i) {  // show the bounds check error too
      iarr4[i + 1] += iarr4[i];
    }
    StdOut.println(Arrays.toString(iarr4));
    
    StdOut.println("end of file");

   
  }
} 





















