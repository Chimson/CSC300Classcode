package classcode;
import stdlib.*;

public class OrderGrowthLoops {
  
  public static void main(String[] args) {  
 
    // linear in N
    // ~2N O(N)
    int[] arr = new int[100];
    int N = arr.length;
    for (int i = 0; i < N; ++i) {
      if (i % 2 == 0) {
        int val = i * i;
        arr[i] = val;
      }
    }
    
    // quadratic in N
    // ~3N^2 O(N^2)
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
    
    
    // TODO: write a logarithmic loop
    // N/10 = (1/10) * N
    int count = 0;
    
    /* TODO: write a linearithmic loop using a double loop */
    // O(N * lgN);
    count = 0;
    
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
