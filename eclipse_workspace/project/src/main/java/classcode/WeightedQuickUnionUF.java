package classcode;
import stdlib.*;
import java.util.Arrays;

public class WeightedQuickUnionUF {
    private int[] parent;   // parent[i] = parent of i
    private int[] size;     // size[i] = number of elements in subtree rooted at i
    private int count;      // number of components

    public WeightedQuickUnionUF(int n) {
      count = n;
      parent = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        size[i] = 1;
      }
    }

    public int count() {
      return count;
    }

    public int find(int p) {
      while (p != parent[p])
        p = parent[p];
      return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (rootP == rootQ) return;

      // make smaller root point to larger one
      if (size[rootP] < size[rootQ]) {
        parent[rootP] = rootQ;
        size[rootQ] += size[rootP];
      }
      else {
        parent[rootQ] = rootP;
        size[rootP] += size[rootQ];
      }
      count--;
    }

    public static void main(String[] args) {
      
      // create initial union find size 8
      
      WeightedQuickUnionUF qf = new WeightedQuickUnionUF(10);
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
      qf.union(0, 9);  // connect smaller component under bigger
      
      Assert.that(Arrays.equals(qf.parent, 
        new int[] {6, 2, 6, 4, 6, 6, 6, 2, 4, 4}));

      Assert.that(Arrays.equals(qf.size, 
        new int[] {1, 1, 3, 1, 4, 1, 10, 1, 1, 1}));
      
      StdOut.println("All tests pass!");        
    }

}


