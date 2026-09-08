package classcode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import stdlib.*;
import java.util.Arrays;
import java.util.ArrayList;

public class ResizingArrayStack<Item> implements Iterable<Item> {

  // fields
  private Item[] a;       
  private int n;        // num of Items on stack

  /*
  * Initializes an empty stack.
  */
  @SuppressWarnings("unchecked")
  // constructor
  public ResizingArrayStack() {
    a = (Item[]) new Object[8];
    n = 0;   // can also use this
  }

  /*
  * True when this stack is empty
  */
  public boolean isEmpty() {
    return n == 0;
  }

  /*
  * Returns the number of items in the stack.
  */
  public int size() {
    return n;
  }

  // resize when filled
  @SuppressWarnings("unchecked")
  private void resize(int capacity) {
    Assert.that(capacity >= n);

    // textbook implementation
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < n; i++) {
      copy[i] = a[i];
    }
    a = copy;

   // can also call java.util.Arrays.copyOf(a, capacity) to copy
  }

  /*
  * Adds an Item to the stack, double the size if necessary
  */
  public void push(Item item) {
    if (n == a.length) {
      resize(2*a.length);    
    }
    a[n++] = item;           // add item
  }
  

 /*
  * Removes and returns the item most recently added to this stack.
  * throws java.util.NoSuchElementException if this stack is empty
  */
  public Item pop() {
    /*
    TODO: Complete this function in class
      if empty throw NoSuchElementException
      save top of stack value to return
      null it out
      decrease the item count
      resize to half the current cap if it only 1/4 full       
    */ 
    
    return null;
  }

  /*
  * Read but not remove or return the first element
  */
  public Item peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }
    return a[n-1];
  }

  /*
  * Iterator for for-each loops
  */
  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  // Reads from the top of the stack down
  private class ReverseArrayIterator implements Iterator<Item> {
    private int i;

    public ReverseArrayIterator() {
      i = n-1;  // top of the stack
    }

    public boolean hasNext() {
      return i >= 0;
    }

    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return a[i--];
    }
  }

  public static void main(String[] args) {
    
    ResizingArrayStack<Integer> ras = new ResizingArrayStack<>();
    Assert.that(ras.n == 0);
    Assert.that(Arrays.equals(ras.a, new Integer[] {null, null, null, null,
      null, null, null, null}));
      
    ras.push(0);
    Assert.that(ras.n == 1);
    Assert.that(Arrays.equals(ras.a, new Integer[] {0, null, null, null,
      null, null, null, null}));  
      
    ras.push(1);
    ras.push(2);
    ras.push(3);
    ras.push(4);  
    ras.push(5);
    ras.push(6);
    ras.push(7);
    
    Assert.that(ras.n == 8);
    Assert.that(Arrays.equals(ras.a, new Integer[] {0, 1, 2, 3,
      4, 5, 6, 7}));  
      
    // resize for more space since filled, then add to array 
      
    ras.push(8);
    Assert.that(ras.n == 9);  
    Assert.that(Arrays.equals(ras.a, new Integer[] {0, 1, 2, 3,
      4, 5, 6, 7, 8, null, null, null, null, null, null, null}));  
    
    
    // pop()
    
    Assert.that(ras.pop().equals(8));
    Assert.that(ras.n == 8);  
    Assert.that(Arrays.equals(ras.a, new Integer[] {0, 1, 2, 3,
      4, 5, 6, 7, null, null, null, null, null, null, null, null}));      
    
    // check shrink 
    Assert.that(ras.pop().equals(7));
    Assert.that(ras.pop().equals(6));
    Assert.that(ras.pop().equals(5));
    Assert.that(ras.pop().equals(4));
    Assert.that(Arrays.equals(ras.a, new Integer[] {0, 1, 2, 3,
      null, null, null, null}));      
    Assert.that(ras.n == 4);
    
    // check exception on pop() 
    Assert.that(ras.pop().equals(3));
    Assert.that(ras.pop().equals(2));
    Assert.that(ras.pop().equals(1));
    Assert.that(ras.pop().equals(0));
    try {
      ras.pop();
    }
    catch (NoSuchElementException e) {}
    
    // iterator
    Assert.that(ras.isEmpty() == true);
    ras.push(0);
    ras.push(1);
    ras.push(2);
    ras.push(3);
    int i = 0;
    Integer[] ex = new Integer[] {3, 2, 1, 0};
    for (Integer val: ras) {
      Assert.that(val.equals(ex[i++]));
    }
    
    StdOut.println("Tests passed!");
    
  }
}

