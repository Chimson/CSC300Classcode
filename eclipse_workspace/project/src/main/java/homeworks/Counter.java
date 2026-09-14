package homeworks;

public class Counter {
  private int passes;
  private int fails;
 
  public Counter() {
    passes = 0;
    fails = 0;
  }
  
  public void passed() {
    passes += 1;
  }
  
  public void failed() {
    fails += 1;
  }
  
  public String toString() {
    int total = passes + fails;
    return "\nTests Complete:\n  " + passes + "/" + total + " Tests Passed";
  }

  public int getFails() {
    return fails;
  }

  public int getPasses() {
    return passes;
  }

} 

