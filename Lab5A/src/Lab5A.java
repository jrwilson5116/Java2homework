import java.lang.reflect.Array;

/*************************************
* Joey Wilson
* Lab5A: implementing an ArrayList class                        
* Due: 9/21/2017
**************************************/
//package lab5a;
/**
 * Class implementing an array based list.
 */
class ArrayList<T> {
    private int size = 20;          //size of array 
    private T[] list;             //array to store the list items
    private int length;             //amount of items in the list
    
    
    
    	
    /**
     * Default constructor. Sets length to 0, initializing the list 
     * as an empty list. Default size of array is 20.
     */
    public ArrayList(Class<T> c) {
    	length = 0;
        T[] list = (T[]) Array.newInstance(c,size);
        this.list =list;
    }

    /**
     * Determines whether the list is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Prints the list elements.
     */
    public void display() {
    	if(list!= null) {
	        for (int i = 0; i < length; i++) {
	            System.out.print(list[i] + " "+"\n");
	        }
    	}else
    		System.out.println("Empty list");

        System.out.println();
    }

    /**
     * Adds the element x to the end of the list. 
     *List length is increased by 1.
     * @param x element to be added to the list
     */
    public void add(T x) {
        if (length == size)
            System.out.println("Insertion Error: list is full");
        else {
            list[length] = x;
            length++;
        }
    }

    /**
     * Removes the element at the given position from the list. 
     * List length is decreased by 1.
     * @param pos position of the item to be removed
     */
    public void removeAt(int pos) {
        if (pos <1 || pos>length)
            System.out.println("Error: That position is not in the list");
        else {
            for (int i = pos; i < length ; i++) {
                list[i-1] = list[i];
            }
            length--;
        }
    }

    //Implementation of methods in the lab exercise
    /**
     * Non default constructor. Sets length to 0, initializing 
     * the list as an empty list. Size of array is passed as a 
     * parameter.
     * @param size size of the array list
     */
    public ArrayList(Class<T> c,int sizeParam) { 
        length = 0;
        size = sizeParam;
        T[] list = (T[]) Array.newInstance(c, sizeParam);
        this.list =list;
    }

    /**
     * Returns the number of items in the list (accessor method).
     * @return the number of items in the list.
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the size of the list (accessor method).
     * @return the size of the array
     */
    public int getSize() {
        return size;
    }

    /**
     * Removes all of the items from the list. After this  
     * operation, the length of the list is zero.
     */
    public void clear() {
       length =0;
    }

    /**
     * Replaces item in list at position specified by position.
     * @param position position of the element to be replaced
     * @param item value that will replace the value at position
     */
    public void replace(int position, T item) {
        list[position-1]=item;
    }

    /**
     * Adds an item to list at position specified by position
     * @param position position where item will be added.
     * @param item item to be added to the list.
     */
    public void add(int position, T item) {
    		
   
          if (position>length) {
        	  System.out.println("No can do");
          }
          length++;
          for(int i=length-1;i>=(position-1);i--){
        	  		list[i]=list[i-1];
        	  		
        	  }
          list[position-1]= item;
          }
    

    /**
     * Deletes an item from list. All occurrences of item in
     *  the list will be removed.
     * @param item element to be removed.
     */
    public void remove(T item) {
        for(int i=0;i>list.length;i++){
            if (list[i]==item)
                removeAt(i);
        }
    }

    /**
     * Returns the element at position
     *
     * @param position position in the list of the item 
     * to be returned
     * @return element at position
     */
    public T get(int position,T item) { 
        return list[position];
    }
}

/////////////////////////////////////////////////////////////
/**
 * Class to test the ArrayList class.
 */
public class Lab5A {
    public static void main(String[] args) {
    	
    	String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", 
        		"DC", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS",
        		"KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", 
        		"NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", 
        		"OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", 
        		"WA", "WI", "WV", "WY"};
    	
        ArrayList<String> list2 = new ArrayList(String.class);
        ArrayList<Double> list3 = new ArrayList(Double.class,15);
       
        int a;
		for (int i=1;i<20;i++) {
			a = (int)(Math.random()*50);
			list2.add(states[a]);
		}
		for (int i=1; i<15; i++) {
			list3.add(Math.random()*100);
		}
		
        list2.display();
        
        list2.removeAt(1);    
        list2.replace(2,"Replace Test");
        list2.display();
        
        
        list3.display();
        
        list3.add(5,1337.101010101);
        list3.display();
        
        list2.clear();
        list3.clear();
        
        //blank lists
        list2.display();
        list3.display();
        
        
    }
}

/**OUTPUT
 * 	IN 
	LA 
	IN 
	OK 
	MD 
	KY 
	MD 
	TX 
	OK 
	FL 
	MS 
	AK 
	ME 
	DE 
	VT 
	KY 
	NE 
	AL 
	RI 
	
	LA 
	IN 
	Replace Test 
	MD 
	KY 
	MD 
	TX 
	OK 
	FL 
	MS 
	AK 
	ME 
	DE 
	VT 
	KY 
	NE 
	AL 
	RI 
	
	86.82609261593701 
	5.366554289645387 
	52.01829894453296 
	30.210356836775077 
	84.41879270528784 
	22.177516006492894 
	5.997146352455118 
	61.83902545630684 
	7.485640328206888 
	15.667228872490513 
	20.761863044262117 
	46.4118471468868 
	98.89219762154143 
	61.609944788461256 
	
	86.82609261593701 
	5.366554289645387 
	52.01829894453296 
	30.210356836775077 
	1337.10101 
	84.41879270528784 
	22.177516006492894 
	5.997146352455118 
	61.83902545630684 
	7.485640328206888 
	15.667228872490513 
	20.761863044262117 
	46.4118471468868 
	98.89219762154143 
	61.609944788461256 

	*/
