package classcode; 

// import java.lang.*   // this is done implicitly, contains System, etc.
import stdlib.*;   // all classes from stdlib can be called directly with .*
import java.util.Arrays; // helper class for raw arrays 
import java.util.ArrayList; // dynamic like a python list

// this file LearnJava.java needs a LearnJava class
// to run this file it needs a public static void main defined
// public classes and methods are visible by other classes
class Hello {
  // class method (called through an object)
  public void hello() {
    StdOut.println("Hello");
  }
}

public class LearnJava {

  // static functions do not require a class object to call
  public static int addOne(int i) {
    return i + 1;
  }
 
  
  public static void main (String[] args) {
  
    // built in print from Java
    System.out.println("Hi from Test, using java's builtin in console writer"); 
    
    // stdlib print function - we'll only use this
    StdOut.println("uses stdlib print");
    StdOut.println();
    
    // -----
    
    // declare a variable (local vars need initialized before printing)
    // int, float, double, char, etc. are primitive types
    int decl;
    decl = 0;
    StdOut.println(decl);
    
    // better to declare and initialize
    int var1 = 100;
    StdOut.println(var1);
   
    // variables have a type that need assigned values from that type or child type  
    String name;
    name = "Ben";  // only use "" for String since '' is for chars
    // name = 3.4;   // compilation error   
    StdOut.println(name);
    StdOut.println();
    
    float x1 = (float) 3.14;
    boolean b = true;
    
    
    /* This is
     * a multiline comment
     * 
     */ 
    
    // -----
    
    // each primitive type has a corresponding object type
    // int has Integer, double has Double, etc.
    // they tend to work together without extra code
    // object types usually require new to create
    // explicit casting using (type) will attempt to convert one type to another, if possible
    // primitives and their object types will do this implicitly, so will inherited types
    Integer int1 = new Integer(3);
    int ten = 10;
    int1 = (Integer) ten;   // cast an int to an Integer
    StdOut.println(int1);
    StdOut.println();
    // -----
    
    
    // declare and initialize a "raw" array
    int[] iarr = {1, 2, 3};  
    
    // implicitly init with default values for type 
    // java.util.Arrays has static helper functions for raw arrays
    int[] iarr2 = new int[3];    //  with 0's 
    StdOut.println(Arrays.toString(iarr2));
    StdOut.println();
   
    // -----
     
    // raw arrays have length property
    // loop by index
    /*
      TODO: write an index for loop on iarr that adds one
            to each member, prints the ref, and the values
    */
     
    // for each loop - like "for in" in python
    // read only, so will not modify values in the array
    /* 
      TODO: write a for each loop on iarr that tries to add one to 
          each val in the array, and prints results
    */
    
    // ----- 
     
    // import allows you to use classes without package namespace
    // however you can call with the package
    // Some types/classes require a non-primitive type parameter in <>
    // full classes (unlike raw arrays) have a toString() defined, called by println() 
    // you can add more to your print messages with +
    java.util.ArrayList<String> slist = new java.util.ArrayList<String>();  // can always use visible packages
    ArrayList<Integer> list1 = new ArrayList<Integer>(3);                   // shortened by import
    StdOut.println(slist);
    StdOut.println("list 1 is " + list1);
    StdOut.println();

    // -----
    // method called through an object of Hello class
    Hello hl = new Hello();   
    hl.hello();
    // ----- 


    // -----



    // call a static function/method using function_name()
    Integer t = 300;
    t.equals(300);   // method
    int i2 = 100;
    i2 = addOne(i2);  // static method
    StdOut.println(i2 + "\n");
    StdOut.println();

    // -----
   
    // if - else if - else block in a for loop
    // ++var is the pre increment: same as var += 1
    // == returns true when primitive vals are equal, false otherwise
    // != returns true when they are false
    // only adds to the count on the first div check
    int[] iarr3 = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int divthrees = 0;
    int divtwos = 0;
    int divones = 0;
    for (int i = 0; i < iarr3.length; ++i) {
      if (iarr3[i] % 3 == 0) {
        ++divthrees;
      }
      else if (iarr3[i] % 2 == 0) {
        ++divtwos;
      }
      else {
        ++divones;
      }
    }
    StdOut.println(divones + ", " + divtwos + ", " + divthrees);
    StdOut.println();
    
    // -----
    
    // outer scope variables are visible in its scope and any containing scopes
    // variables defined in an inner scope are not visible in an outer/containing scope
    // this is true for any {} used, including in method/function definitions, if blocks, class definitions, etc.

    {
      int h = 100;
    }
    // StdOut.println(h);  // not readable in outer scope
    int f;
    {
      f = 101;  
    }
    StdOut.println(f);    
    

 
  }
  
}





