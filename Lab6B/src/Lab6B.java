/*******************************
* <put your name here>  	   
* Lab 6B - Generic Linked List  				   *
* Due: Tuesday, Oct.3, 2017
*******************************/

// Class implementing a linked list.
class LinkedList<T> {
    private Node first;  //dummy header node

    // Initializes the list to empty creating a dummy header node.
    public LinkedList() {
        first = new Node();
    }

    // Returns true if the list is empty, false otherwise
    public boolean isEmpty() {
        return (first.getNext() == null);
    }

    // Clears all elements from the list
    public void clear() {
    	first.setNext(null);
    }

    // Returns the number of item in the list
    public int getLength() {
	int length = 0;
	Node current = first.getNext();
	while (current != null) {
		length++;
		current = current.getNext();
	}
	return length;
    }

    // Prints the list elements.
    public String toString() {
    	String list = "";
        Node current = first.getNext();
        while (current != null) {
            list += current.getInfo() + " ";
            current = current.getNext();
        }
        return list;
    }

    // Adds the element x to the beginning of the list.
    public void add(T x) {
        Node p = new Node();
        p.setInfo(x);
        p.setNext(first.getNext());
        first.setNext(p);
    }

    // Deletes an item x from the list. Only the first
    // occurrence of the item in the list will be removed.
    public void remove(T x) {
        Node old = first.getNext();
        Node p = first;

        //Find reference to node before the one to be deleted
        boolean found = false;
        while (old != null && !found) {
            if (old.getInfo().equals(x))
                found = true;
            else {
                p = old;
                old = p.getNext();
            }
        }

        //if x is in the list, remove it.
        if (found)
            p.setNext(old.getNext());
    }

    // Returns the element at a given location in the list
    public T get(int location) {
    	T item = null;
    	int length = getLength();
    	if (location <1 || location > length)
    		System.out.println(
    			"\nError: Attempted get location out of range.");
        else {
    		int n = 1;
    		Node current = first.getNext();
			while (n < location) {
				n++;
				current = current.getNext();
			}
			item = (T)current.getInfo();
    	}
  	return item;
    }

/*************************************************
Students to complete the following two methods
**************************************************/
    // Adds item to the end of the list
    public void addEnd(T item) {

    }

    // Replaces the info in the list at location with item
    public void replace(int location, T item) {

    }
    ///////////////////////////////////////////////////////////////////////////
    // Inner class Node.
    private class Node<T> {
    	private T info;   //element stored in this node
    	private Node next;  //link to next node

    	// Initializes node setting info to null and next to null
    	public Node() {
        	info = null;
        	next = null;
    	}
        
        /***************************************************** 
        Students to complete the following two constructors
        ******************************************************/
        // Creates a new Node and sets info to the argument
        public Node(T i) {
            
        }
        // Creates a new Node and sets both info and next to the arguments
        public Node(T i, Node n) {
            
        }
                
    	// Sets the value for this node
	public void setInfo(T i) {
	        info = i;
	}

	// Sets the link to the next node
	public void setNext(Node lnk) {
	        next = lnk;
	}

	// Returns the value in this node
	public T getInfo() {
	        return info;
	}

	// Returns the link to the next node
	public Node getNext() {
	        return next;
	}
    }
}
///////////////////////////////////////////////////////////////////////////////
public class Lab6B {
	public static void main(String args[]) {
		LinkedList<Integer> intList = new LinkedList();
		System.out.print("List of numbers before list creation: ");
		for (int i =0; i < 10; i++) {
			Integer info = (Integer)(int)(Math.random()*10);
			System.out.print(info + " ");
			intList.add(info);
		}
		System.out.print
			("\nList of numbers after list creation: "
				+ intList);
		System.out.println("\nLength of List: "  
			+ intList.getLength());
		System.out.println("First elements in the list is: " 
                        + intList.get(1));
	}
}

/* Sample Program Output:
List of numbers before list creation: 5 8 8 3 3 6 5 8 0 7 
List of numbers after list creation: 7 0 8 5 6 3 3 8 8 5 
Length of List: 10
First elements in the list is: 7
*/