package classcode;
import stdlib.*;
import java.util.Arrays;

public class Insertion<T extends Comparable<T>> {

  public void sort(T[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
        exch(a, j, j-1);
      }
    }
  }

//  public void sort(T[] a, int lo, int hi) {
//    for (int i = lo + 1; i < hi; i++) {
//      for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
//        exch(a, j, j-1);
//      }
//    }
//  }

 /***************************************************************************
  *  Helper sorting functions.
  ***************************************************************************/

  // is v < w ?
  private boolean less(T v, T w) {
    return v.compareTo(w) < 0;
  }

  // exchange a[i] and a[j]
  private void exch(T[] a, int i, int j) {
    T swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

 /***************************************************************************
  *  Check if array is sorted - useful for debugging.
  ***************************************************************************/
  private boolean isSorted(T[] a) {
    return isSorted(a, 0, a.length);
  }

  // is the array a[lo..hi) sorted
  private boolean isSorted(T[] a, int lo, int hi) {
    for (int i = lo + 1; i < hi; i++)
      if (less(a[i], a[i-1])) {
        return false;
      }
    return true;
  }

  public static void main(String[] args) {

    String fullstr = "S O R T E X A M P L E";
    String[] sarr = fullstr.split(" ");
    StdOut.println("Before sort: " + Arrays.toString(sarr));
   
    Insertion<String> insertion = new Insertion<>();
    insertion.sort(sarr);
    
    Assert.that(insertion.isSorted(sarr));
    
    StdOut.println("After sort: " + Arrays.toString(sarr));
    
    StdOut.println("... Tests complete!");
   
  }
}

