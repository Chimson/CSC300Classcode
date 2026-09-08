package classcode;
import stdlib.*;
import java.util.Arrays;

public class QuickUnionUF {
    
  private int[] parent;  // parent[i] = parent of i
  private int count;     // number of components

  public QuickUnionUF(int n) {
    parent = new int[n];
    count = n;
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  public int count() {
    return count;
  }

  public int find(int p) {
    while (p != parent[p]) {
      p = parent[p];
    }
    return p; 
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) {
      return;
    }
    parent[rootP] = rootQ;
    count--;
  }

  public static void main(String[] args) {
    
      // create initial union find size 8
      
      QuickUnionUF qf = new QuickUnionUF(10);
      Assert.that(Arrays.equals(qf.parent, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
      Assert.that(qf.count() == 10);
      
      qf.union(4, 3);
      qf.union(3, 8);
      qf.union(6, 5);
      qf.union(9, 4);
      qf.union(2, 1);
      qf.union(8, 9);
      qf.union(5, 0);
      qf.union(7, 2);
      qf.union(6, 1);
      
      Assert.that(Arrays.equals(qf.parent, 
        new int[] {1, 1, 1, 8, 3, 0, 5, 1, 8, 8}));
      
      StdOut.println("All tests pass!");    
  }


}

