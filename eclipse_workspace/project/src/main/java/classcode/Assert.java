package classcode;

public class Assert {
  
  // meant to be like a silent assert like java assert keyword
  public static void that(boolean expr) {
    
    if (!expr) {
	    try {
	      throw new AssertionError();
	    }
	    catch (AssertionError e) {
	      e.printStackTrace();
	    }
	  }
	}

  public static void main(String[] args) {
    
    Assert.that(true);
    Assert.that(false);

  }

}
