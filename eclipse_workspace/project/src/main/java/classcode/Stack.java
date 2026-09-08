package classcode;
import java.util.Iterator;
import stdlib.*;

public class Stack<Item> implements Iterable<Item> {
  private Node first; 
  private int N; // number of items
  
  private class Node { 
    Item item;
    Node next;
  }
  
  public boolean isEmpty() { 
    return first == null; 
  }
   
  public int size() { 
    return N; 
  }
  
  /*
    TODO:  
      add new node with item to the top/first of the stack
      use an alias, since old first is now second
      first field should point to new node
      update N
  */
  public void push(Item item) { 
  }
  

  public Item pop() { 
    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }

  /*
    TODO: complete in class
      do not use an iterator
      us a while or for loop
      return true if val is in the list, false if not
      items should use .equals() not ==
  */
  public boolean isIn(Item val) { 
    return false;
  }
  
  /*
    TODO: complete in class
      do not use iterator, use a while loop
      keep track of the previous as you travel forward to compare with current
      When cur changes from previous add to the count 
      Need to consider edge cases: empty list, list size 1
        empty list returns 0 changes  X
        list size 1 returns 1 change
  */

  public int numChanges() {
    return 0;
  }
  
  public Iterator<Item> iterator() { 
    return new ListIterator(); 
  }
  
  private class ListIterator implements Iterator<Item> {
    private Node current = first;
    
    public boolean hasNext() { 
      return current != null; 
    }
   
    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    } 
  } 
  
  public static void main(String[] args) {
    
    
    Stack<String> st = new Stack<>();
    Assert.that(st.first == null);
    Assert.that(st.N == 0);
    
    st.push("A");
    st.push("B");
    st.push("C");
    st.push("D");
    st.push("E");
    Assert.that(st.first != null);
    Assert.that(st.N == 5);
    
    // LIFO order
    // try the iterator
    for (String b : st) {
      StdOut.println(b);
    }
    
    Assert.that(st.first.item.equals("E"));
    Assert.that(st.first.next.item.equals("D"));
    Assert.that(st.first.next.next.item.equals("C"));
    Assert.that(st.first.next.next.next.item.equals("B"));
    Assert.that(st.first.next.next.next.next.item.equals("A"));
    
    StdOut.println("PASSED: push() 5 items");
    
    Assert.that(st.pop().equals("E"));
    Assert.that(st.pop().equals("D"));
    Assert.that(st.pop().equals("C"));
    Assert.that(st.pop().equals("B"));
    Assert.that(st.pop().equals("A"));
    Assert.that(st.N == 0);
    Assert.that(st.first == null); 
    
    StdOut.println("PASSED: pop() 5 items");
  
    
    st.push("A");
    st.push("B");
    st.push("C");
    st.push("D");
    st.push("E");
    Assert.that(st.isIn("E") == true);
    Assert.that(st.isIn("D") == true);
    Assert.that(st.isIn("C") == true);
    Assert.that(st.isIn("B") == true);
    Assert.that(st.isIn("A") == true);
    StdOut.println("PASSED: isIn() 5 items");
  
    Stack<Integer> istk = new Stack<Integer>();
    Assert.that(istk.numChanges() == 0);
    istk.push(0);
    Assert.that(istk.numChanges() == 1);
    istk.push(0);
    Assert.that(istk.numChanges() == 1);
    istk.push(1);
    Assert.that(istk.numChanges() == 2);
    StdOut.print("stack: ");
    for (Integer val: istk) {
      StdOut.print(val + " -> ");
    }
    StdOut.println("null");
    
    StdOut.println("PASSED: numChanges() tests");
    
    StdOut.println("Stack demo finished!");
  }
}
