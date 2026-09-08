package classcode;
import stdlib.*;
import java.util.Arrays;

public class QuickFindUF {
    private int[] id;    // id[i] = component identifier of i
    private int count;   // number of components

    
    public QuickFindUF(int n) {
      count = n;
      id = new int[n];
      for (int i = 0; i < n; i++) {
        id[i] = i;
      }
    }

    public int count() {
      return count;
    }

    public int find(int p) {
      return id[p];
    }

   
    public boolean connected(int p, int q) {
      return id[p] == id[q];
    }

    public void union(int p, int q) {

      int pID = id[p]; 
      int qID = id[q];  
      
      // p and q are already in the same component
      // same as connected(p, q) without the array reads
      if (pID == qID) {
        return;
      }
      
      // when piD != qID
      for (int i = 0; i < id.length; i++) {
        if (id[i] == pID) {
          id[i] = qID;
        }
      }
      count--;
    }

    public static void main(String[] args) {
      // create initial union find size 8
      
      QuickFindUF qf = new QuickFindUF(10);
      Assert.that(Arrays.equals(qf.id, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
      Assert.that(qf.count == 10);
      
      qf.union(4, 3);
      qf.union(3, 8);
      qf.union(6, 5);
      qf.union(9, 4);
      qf.union(2, 1);
      qf.union(8, 9);
      qf.union(5, 0);
      qf.union(7, 2);
      qf.union(6, 1);
      
      Assert.that(Arrays.equals(qf.id, 
          new int[] {1, 1, 1, 8, 8, 1, 1, 1, 8, 8}));
      
      qf.union(4, 5);
      
      
      StdOut.println("All tests pass!");
    }

}

