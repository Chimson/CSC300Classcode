package classcode;
import stdlib.*;

public class OrderGrowthLoops {

  public static int countZeros(int[] vals) {
		int count = 0;
		for (int i = 0; i < vals.length; ++i) {
      if (vals[i] == 0) {
        ++count;
      }
    }
		return count;
	 }

	 // worst case vals = [0, 0, ..., 0] size of vals is N
	 // C(N) = 2N, C(N) ~ 2N, O(N) = N
	 // best case: C(N) = N, O(N)

	 // count everything: C(N) = 1 + 1 + N + 1 + N + N  + N -1


  public static void main(String[] args) {  
 
    // linear in N
    // ~2N O(N)
    int[] arr = new int[100];
    int N = arr.length;

    for (int i = 0; i < N; ++i) {
      //if (val[i] == 0) {
        //int val = i * i;
        //arr[i] = val;
      //}
    }
    
    // quadratic in N
    // ~3N^2 O(N^2)
    /*
    [
      [1, 2, 3, 4],
      [3, 4, 5, 6],
      [7, 8, 9, 9],
      [10, 11, 2, 3]
    ]
    */

   //[2, 5, 8, 9, 10, 25, 89]


    int[][] tdarr = new int[N][N]; 
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        int val = i * j;
        val -= 1;
        tdarr[i][j] = val;
      }
    }  
   
    // also quadratic, using the triangular sum formula
    N = 5;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < i + 1; ++j) {
        StdOut.print(j);        
      }
      StdOut.println();
    }
    StdOut.println();
    /*
    i = 0
      j = 0
    i = 1
      j = 0
      j = 1
    i = 2
      j = 0
      j = 1
      j = 2
    ...
    i = N-1
      j = 0
      ...
      j = N - 1
    */
    
    // TODO: write a logarithmic loop
    // N/10 = (1/10) * N
   // O(lgN)
    StdOut.println("log loop:");
    N = 64;  // 2^6  // lg(N) = 6 when N = 64
		int count = 0;
		for (int i = 1; i < N; i*=2) {
			StdOut.print(i + " ");
		}
    StdOut.println("---");
		// O(lg(N))

    /* TODO: write a linearithmic loop using a double loop */
    // O(N * lgN);
    count = 0;
    StdOut.println("linearithmic loop:");
    // N = 8;  // 2^6  // lg(N) = 6 when N = 64
    for (int j = 0; j < N; ++j) {
	    for (int i = 1; i < N; i*=2) {
	      StdOut.print(i + " ");
	    }
		}
    StdOut.println("---");
    // 8 * lg(8) = 8 * 3 = 24 illustrates O(N * lg(N))

    // exponential
    // count is 2^N - 1 which is Order of Growth 2^N
    count = 0;
    N = 4;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < Math.pow(2, i); ++j) {
        ++count;
        StdOut.print(j + " ");
      }
      StdOut.println();
    }   
    StdOut.println("count: " + count); 
  }
}
