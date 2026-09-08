package classcode;

import stdlib.Stopwatch;
import stdlib.In;
import stdlib.StdOut;
import stdlib.StdDraw;

public class TripleSum {

  public static int[] loadInts(String filename) {
    In infile = new In(filename);
    int[] ints = infile.readAllInts();
    return ints;
  }
  
  public static int count(int[] a) {
    int N = a.length;
    int cnt = 0;
    // ops = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i+1; j < N; j++) {
        for (int k = j+1; k < N; k++) {
          // ops += 3;
          if (a[i] + a[j] + a[k] == 0) {
            cnt++;
          }
        }
      }
    }
    return cnt;
  }

  
  public static double timeTripleSum(int[] intarr) {
    int numints = intarr.length;
    Stopwatch timer = new Stopwatch();
    TripleSum.count(intarr);
    double etime = timer.elapsedTime();
    StdOut.println(numints + " ints at " + etime + " seconds");
    return etime;
  }
  
  public static void plotValues(int[] sizes, double[] vals) {
    int N = 8000;
    StdDraw.setXscale(0 - 0.1*N, 1.1*N);
    StdDraw.setYscale(0 - 0.1*vals[3], 1.1*vals[3]);
    StdDraw.setPenRadius(0.003);
    StdDraw.setPenRadius(.01); 
    for (int i = 0; i < vals.length; ++i) {
      StdDraw.point(sizes[i], vals[i]);
    }
    
  }
  
  public static void drawFunction(int sizes[], double[] vals) {
    // draws the approximating cubic function
    StdDraw.setPenColor(StdDraw.BLUE);
    StdDraw.setPenRadius(0.003);
    double a = vals[0]/(sizes[0] * sizes[0] * sizes[0]);
    for (double i = 0; i < sizes[3]; ++i) {
      double y = a * i * i * i;
      StdDraw.point(i, y);
    }
  }    


  public static void main(String[] args) {
  
    // load all the data into int arrays
    int[] okints = loadInts("./src/main/java/classcode/1Kints.txt");
    int[] tkints = loadInts("./src/main/java/classcode/2Kints.txt");
    int[] fkints = loadInts("./src/main/java/classcode/4Kints.txt");
    int[] ekints = loadInts("./src/main/java/classcode/8Kints.txt");
    
    // time ThreeSum on each of the arrays and print output
    double[] vals = new double[4];
    vals[0] = timeTripleSum(okints);
    vals[1] = timeTripleSum(tkints);
//    vals[2] = 3.6;
    vals[2] = timeTripleSum(fkints);
//    vals[3] = 30;
    vals[3] = timeTripleSum(ekints);
    
    int[] sizes = {1000, 2000, 4000, 8000};
    plotValues(sizes, vals);    
    
    drawFunction(sizes, vals);
    
  }

}

