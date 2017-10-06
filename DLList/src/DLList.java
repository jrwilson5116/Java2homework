/*******************************
* Joey Wilson   
* Lab 7 - Doubly Linked List  				   *
* Due: Thursday, Oct.5, 2017
*******************************/
//package dllist;

// Class implementing a doubly linked list.
class DLinkedList<T> {
    private Node first;  //dummy header node

    // Initializes the list to empty creating a dummy header node.
    public DLinkedList() {
        first = new Node();
    }

    // Returns true if the list is empty, false otherwise
    public boolean isEmpty() {
        return (first.getNext()==null);
    }

    // Clears all elements from the list
    public void clear() {
    	first.setNext(null);
        first.setPrev(null);
    }

    // Returns the number of item in the list
    public int getLength() {
	int length = 0;
	Node current = first.getNext();
        if(current == null)
            return 0;
	while (current != first) {
		length++;
		current = current.getNext();
	}
	return length;
    }

    // Prints the list elements.
    public String toString() {
    	String list = "";
        if(!isEmpty()) {
            Node current = first.getNext();
            while (current != first) {
                list += current.getInfo() + " ";
                current = current.getNext();
            }
        }
        return list;
    }

    // Adds the element x to the beginning of the list.
    public void add(T x) {
        Node p = new Node(x);
        p.setPrev(first);
        if(isEmpty()) {
            p.setNext(first);
            first.setPrev(p);
        }
        else {
            p.setNext(first.getNext());
            first.getNext().setPrev(p);
        }
        first.setNext(p);
    }

    // Deletes an item x from the list. Only the first
    // occurrence of the item in the list will be removed.
    public void remove(T x) {
        Node old = first.getNext();
        Node p = first;

        //Find reference to node before the one to be deleted
        boolean found = false;
        while (old != first && !found) {
            if (old.getInfo().equals(x))
                found = true;
            else {
                p = old;
                old = p.getNext();
            }
        }

        //if x is in the list, remove it.
        if (found) {
            old.getNext().setPrev(p); 
            p.setNext(old.getNext());
        }
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
Students to complete the following method
**************************************************/
    // Adds item to the end of the list
    public void addEnd(T item) {
    	Node end = new Node(item);
    	Node current = first;
    	
    	while(current.next!=first) {
    		current = current.next;
    	}
    	current.next=end;
    	end.next= first;
    	end.prev=current;
    	first.prev=end;
    	
    }

    // Replaces the info in the list at location with item
    public void replace(int location, T item) {
        if(location < 1)
            System.out.println("Location can not be less than 1.");
        int n =1;
        Node current = first.getNext();
        if(current == null)
            System.out.println("List is empty!");
        while (n<location && current.getNext()!=first) {
            current = current.getNext();
            n++;
        }
        if(n == location)
            current.setInfo(item);
        // To replace at 1 more than length, add it to the end
        else if(n == location-1)
            addEnd(item);
        else
            System.out.println("Location "+location
                    +" more that 1 beyond list length.");
    }
    ///////////////////////////////////////////////////////////////////////////
    // Inner class Node.
    private class Node<T> {
    	private T info;   //element stored in this node
    	private Node next;  //link to next node
        private Node prev;

    	// Initializes node setting info to null and next to null
    	public Node() {
            info = null;
            next = null;
            prev = null;
    	}
        
        /***************************************************** 
        Students to complete the following two constructors
        ******************************************************/
        // Creates a new Node and sets info to the argument
        public Node(T i) {
        	info = i;
        	prev = null;
        	next = null;
        }
        // Creates a new Node and sets both info and next to the arguments
        public Node(T i, Node n, Node p) {
        	info = i;
        	prev = p;
        	next = n;
        }
                
    	// Sets the value for this node
	public void setInfo(T i) {
	        info = i;
	}

	// Sets the link to the next node
	public void setNext(Node lnk) {
	        next = lnk;
	}
        
        // Sets prev to the previous node
        public void setPrev(Node p) {
                prev = p;
        }

	// Returns the value in this node
	public T getInfo() {
	        return info;
	}

	// Returns the link to the next node
	public Node getNext() {
	        return next;
	}
        
        // Returns the link to the previous node
        public Node getPrev() {
                return prev;
        }
    }
}
///////////////////////////////////////////////////////////////////////////////
public class DLList {
    public static void main(String args[]) {
        
        DLinkedList<Double> list = new DLinkedList();

        for (int i = 0; i < 9; i++) {
            list.add((int)(1000*Math.random()) / 10.0);
        }
        System.out.println("Starting list:");
        System.out.println(list);
        System.out.println("Get length: "+list.getLength());
        System.out.println("Adding 99.9 at the end:");
        list.addEnd(99.9);
        System.out.println(list);
        System.out.println("Get length: "+list.getLength());
        System.out.println("Replace at 1, 5, and 10 with a 5.2: ");
        list.replace(1, 5.2);
        list.replace(5, 5.2);
        list.replace(10, 5.2);
        System.out.println(list);
        System.out.println("Replace at 11 with a 6.3: ");
        list.replace(11, 6.3);
        System.out.println(list);
        
        System.out.println("Removing first item 5.2: ");
        list.remove(5.2);
        System.out.println(list);
        System.out.println("Removing 6.3:");
        list.remove(6.3);
        System.out.println(list);
        System.out.print("Getting position 3:" +list.get(3));
        System.out.print("\nClearing:");
        list.clear();
        System.out.println(list);
        System.out.println("Get length: "+list.getLength());
        
    }
}

/* Sample Program Output:
	Starting list:
	29.5 52.3 13.9 14.6 13.6 3.4 64.4 98.5 29.3 
	Get length: 9
	Adding 99.9 at the end:
	29.5 52.3 13.9 14.6 13.6 3.4 64.4 98.5 29.3 99.9 
	Get length: 10
	Replace at 1, 5, and 10 with a 5.2: 
	5.2 52.3 13.9 14.6 5.2 3.4 64.4 98.5 29.3 5.2 
	Replace at 11 with a 6.3: 
	5.2 52.3 13.9 14.6 5.2 3.4 64.4 98.5 29.3 5.2 6.3 
	Removing first item 5.2: 
	52.3 13.9 14.6 5.2 3.4 64.4 98.5 29.3 5.2 6.3 
	Removing 6.3:
	52.3 13.9 14.6 5.2 3.4 64.4 98.5 29.3 5.2 
	Getting position 3:14.6
	Clearing:
	Get length: 0
*/