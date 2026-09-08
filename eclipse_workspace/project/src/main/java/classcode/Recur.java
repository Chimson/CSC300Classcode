package classcode;

import stdlib.StdOut;
import java.util.Arrays;

public class Recur {
  
  public static void pattern(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n needs to be nonnegative");
    }
    patternHelper(n);
  }
  
  // move print statement to see the different patterns with two 
  //   recursive statements
  private static void patternHelper(int n) {
    // base case (recursion breaks or stops)
    if (n == 0) {
      return;
    }
   
    patternHelper(n - 1);
    StdOut.print(n);
    patternHelper(n - 1); 
    
  }
  
  
  // execution travels down the left branch first, returns to previous parent call, etc. 
  /*
   Assume patternHelper is pH
   pH(3):
     pH(2):
       pH(1):
         pH(0): 
           return
         pH(0):
           return 
       pH(1):
         pH(0)
           return
         pH(0):
           return
     pH(2):
       pH(1):
         pH(0):
           return
         pH(0):
           return
       pH(1):
         pH(0)
           return
         pH(0):
           return
   */
  

  public static double minFor(double[] arr) {
    double  cur_min = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (cur_min > arr[i]) {
        cur_min = arr[i];
      }
    }
    return cur_min;
  }
  
  public static double min(double[] arr) {
    return minHelper(arr, 0, arr[0]);
  }
  
  // {7, 6, 3, -1, 10}
  
  private static double minHelper(double[] arr, int i, double crmin) {
    // base case
    // once i is an invalid index
    if (i > arr.length - 1) {
      return crmin;
    }
    
    else if (arr[i] < crmin) {
      crmin = arr[i];
    }
    
    return minHelper(arr, i + 1, crmin);
  }
    
  /*
    Assume mh is minHelper
    return mh([4, 8, 3], 0, 4):    
      return mh([4, 8, 3], 1, 4):
        return mh([4, 8, 3], 2, 4):  
          crmin = 3
          return mh([4, 8, 3], 3, 3): 
            return 3   
  */
  
  /*
  append([1, 2], [1, 2, 3]) = [1, 2, 1, 2, 3]
  TODO: Complete append to place all elements in a beside b in a new array
        Write a helper recursive function to call in append
        Helper can have a new double result array as a local var 
        Can use a result index param as a local var
  */   
  public static double[] append(double[] a, double[] b) {
    return null;
  } 

  
  
  

  
  public static void main(String[] args) {
    
    // see how same work is done over and over again in pattern
    StdOut.println("test pattern:");
    pattern(3);
    
    StdOut.println("\n*****\n");
    
    StdOut.println("test min:");
    double m = min(new double[] {4, 8, 3, 6, 10});
    Assert.that(m == 3.0);
    StdOut.println(m);
   
    m = min(new double[] {1, 8, 3, 6, 10});
    Assert.that(m == 1.0);
    StdOut.println(m);    
    
    m = min(new double[] {3, 8, 3, 6, -1});
    Assert.that(m == -1.0);
    StdOut.println(m);    
    
    m = min(new double[] {1});
    Assert.that(m == 1);
    
    StdOut.println("\n*****\n");
    
    // append modifies an array in place, and has mutually exclusive cases
    StdOut.println("test append:");
    double[] result1 = append(new double[] {1, 2, 3}, new double[] {4, 5, 6});
    Assert.that(Arrays.equals(result1, new double[] {1, 2, 3, 4, 5, 6}));
    StdOut.println(Arrays.toString(result1));
    
    double[] result2 = append(new double[] {200, 100, 300, 700}, new double[] {400, 600});
    Assert.that(Arrays.equals(result2, new double[] {200, 100, 300, 700, 400, 600}));
    StdOut.println(Arrays.toString(result2));
    
    StdOut.println("Tests pass!");


    
  }
}
