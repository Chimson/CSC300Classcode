package classcode;
import stdlib.*;
import java.util.Arrays;


public class Selection<T extends Comparable<T>> {

  public void sort(T[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i+1; j < n; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
      }
      exch(a, i, min);
    }
  }

 /***************************************************************************
  *  Helper sorting functions.
  ***************************************************************************/

  // Return true when v < w
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

  // is the array a[] sorted?
  private boolean isSorted(T[] a) {
    return isSorted(a, 0, a.length - 1);
  }

  // is the array sorted from a[lo] to a[hi]
    private boolean isSorted(T[] a, int lo, int hi) {
      for (int i = lo + 1; i <= hi; i++) {
        if (less(a[i], a[i-1])) {
          return false;
        }
      }
      return true;
    }

 
  public static void main(String[] args) {
   
    String fullstr = "S O R T E X A M P L E";
    String[] sarr = fullstr.split(" ");   // ["S", "O", "R" ...]
    StdOut.println("Before sort: " + Arrays.toString(sarr));
   
    Selection<String> selection = new Selection<>();
    selection.sort(sarr);
    
    Assert.that(selection.isSorted(sarr));
    
    StdOut.println("After sort: " + Arrays.toString(sarr));
     
//    Selection<Integer> sel = new Selection<Integer>();
//    Integer[] arr = new Integer[] {6, 5, 4, 3, 2, 1};
//    sel.sort(arr);
    
    
    StdOut.println("... Tests complete!");
  }
}

