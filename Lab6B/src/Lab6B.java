/*******************************
* <put your name here>  	   
* Lab 6B - Generic Linked List  				   
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
    public void addEnd( T item) {
    	Node end = new Node(item);
    	Node temp = new Node();
    	temp = first;
    	
    	while(temp.next!=null) {
    		temp=temp.next;
    	}
    	temp.next= end;
    	
    	
    	
    }
    // Replaces the info in the list at location with item
    public void replace(int location, T item) {
    	Node temp = new Node();
    	
    	temp = first;
    	for (int i=0; i<location-1; i++) {
    		temp=temp.next;
    	}
    	Node repNode = new Node(item,temp.next.next);
    	temp.next=repNode;
    	
    	
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
        	info = i;
        	next = null;
        }
        // Creates a new Node and sets both info and next to the arguments
        public Node(T i, Node n) {
            info =i;
            next =n;
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
		String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", 
        		"DC", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS",
        		"KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", 
        		"NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", 
        		"OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", 
        		"WA", "WI", "WV", "WY"};
		
		LinkedList<Double> doubleList = new LinkedList();
		LinkedList<String> stringList = new LinkedList();
		
		int a;
		for (int i=0;i<20;i++) {
			a = (int)(Math.random()*50);
			stringList.add(states[a]);
		}
		for (int i=0; i<15; i++) {
			doubleList.add((int)(Math.random()*1000)/10.0);
		}
		
		System.out.println("doubleList: "+doubleList);
		System.out.println("stringList: "+stringList);
		System.out.println("\nSize of doubleList is "+doubleList.getLength());
		System.out.println("Size of stringList is "+stringList.getLength());
			
		doubleList.addEnd(25.1);
		System.out.println("\ndoubleList after adding 25.1 to the end: \n"+ doubleList);
		System.out.println("\ndoubleList length is now: "+doubleList.getLength());
		
		stringList.replace(1, "Replace Test");
		stringList.replace(20, "Replace Test");
		stringList.replace(10, "Replace Test");
		System.out.println("\n\nstringList after testing replace method:");
		System.out.println(stringList);
		System.out.println("\nstringList length is now: "+ stringList.getLength() );
		
	}
}

/* Sample Program Output:
 * 
 
	doubleList: 19.7 3.3 71.3 46.3 45.7 3.0 69.1 76.7 69.4 79.8 47.7 4.1 57.5 66.2 1.5 
	stringList: MD NV MS TX MI AK DE CA CT CA MO MO CO AZ OH HI NY MA CO CO 

	Size of doubleList is 15
	Size of stringList is 20

	doubleList after adding 25.1 to the end: 
	9.7 3.3 71.3 46.3 45.7 3.0 69.1 76.7 69.4 79.8 47.7 4.1 57.5 66.2 1.5 25.1 

	doubleList length is now: 16


	stringList after testing replace method:
	Replace Test NV MS TX MI AK DE CA CT Replace Test MO MO CO AZ OH HI NY MA CO Replace Test 

	stringList length is now: 20

*/