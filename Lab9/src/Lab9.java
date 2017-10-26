import java.util.Scanner;

/********************************************
*   Joey Wilson
*   Lab9   ArrayList class with sorting algorithms
*   Due: 10/24/2017
********************************************/

// Class implementing an array based list.
// Bubblesort and quicksort algorithms are implemented also.

class ArrayList{
    private static int SIZE; //size of array that stores list items
    private int[] list;      //array to store the list items
    private int length;		 //amount of items in the list

    // Default constructor
    public ArrayList(){
        SIZE = 20;
        list = new int[SIZE];
        length = 0;
    }

    // Three-Arg constructor
    public ArrayList(int size){
        SIZE = size;
        list = new int[SIZE];
        length = 0;
    }

    // Determines whether the list is empty
    public boolean isEmpty(){
        return length == 0;
    }

    // Prints the list elements
    public void display(){
        for (int i = 0; i < length; i++)
            System.out.print(list[i] + " ");
        System.out.println();
    }

    // Adds the element x to the end of the list
    // List length is increased by 1
    public void add(int x)    {
        if (length == SIZE)
            System.out.println("Insertion Error: list is full");
        else  {
            list[length] = x;
            length++;
        }
    }

    // Removes the element at the given location from the list.
    public void removeAt(int pos){
        for (int i = pos; i < length - 1; i++)
            list[i] = list[i + 1];
        length--;
    }


    // Returns the number of items in the list (accessor method).
    public int getLength(){
        return length;
    }

    // Returns the size of the list (accessor method).
    public int getSize(){
        return SIZE;
    }

    // Removes all of the items from the list
    public void clear(){
        length = 0;
    }

    // Replaces item in list at position specified by location
    public void replace(int location, int item){
        if (location < 0 || location >= length)
            System.out.println("Error: invalid location");
        else
            list[location] = item;
    }

    // Adds an item to list at position specified by location
    public void add(int location, int item){
        if (location < 0 || location >= length)
            System.out.println("Error: invalid position");
        else if (length == SIZE)
            System.out.println("Error: Array is full");
        else {
            for (int i = length; i > location; i--)
                list[ i] = list[ i - 1];
            list[location] = item;
            length++;
        }
    }

    public void remove(int item){
        for (int i = 0; i < length; i++)
            if (list[i] == item){
                removeAt(i);
                i--; //consecutive values won't be all removed 
                	 // that's why i-- is here
            }
    }

    // Returns the element at location
    public int get(int location){
        int x = -1;

        if (location < 0 || location >= length)
            System.out.println("Error: invalid location");
        else
            x = list[location];

        return x;
    }

    // Methods listed below are new additions to ArrayList class

    // Makes a deep copy to another ArrayList object
    public ArrayList copy(){
        ArrayList newList = new ArrayList(this.SIZE);

        newList.length = this.length;

        for (int i = 0; i < length; i++)
            newList.list[i] = this.list[i];

        return newList;
    }

    // Bubble-sorts this ArrayList
    public void bubbleSort(){
        for (int i = 0; i < length - 1; i++)
            for (int j = 0; j < length - i - 1; j++)
                if (list[j] > list[j + 1]) {
                    //swap list[j] and list[j+1]
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
    }

    // Quick-sorts this ArrayList
    public void quickSort() {
        quickSort(0, length - 1);
    }

    // Recursive quicksort algorithm.
    private void quickSort(int begin, int end) {
        int temp;
        int pivot = findPivotLocation(begin, end);

        // swap list[pivot] and list[end]
        temp = list[pivot];
        list[pivot] = list[end];
        list[end] = temp;

        pivot = end;
        int i = begin;
        int j = end - 1;

        boolean iterationCompleted = false;
        while (!iterationCompleted) {
            while (list[i] < list[pivot])
                i++;
            while ((j >= 0) && (list[pivot] < list[j]))
                j--;

            if (i < j) {
                //swap list[i] and list[j]
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;

                i++;
                j--;
            } else
            iterationCompleted = true;
        }

        //swap list[i] and list[pivot]
        temp = list[i];
        list[i] = list[pivot];
        list[pivot] = temp;

        if (begin < i - 1)
            quickSort(begin, i - 1);
        if (i + 1 < end)
            quickSort(i + 1, end);
    }

    // Computes the pivot location
    private int findPivotLocation(int b, int e) {
        return (b + e) / 2;
    }

}

// Class to test bubblesort and quicksort 
// algorithms implemented in ArrayList.
public class Lab9 {
    public Lab9() {
    	Scanner myScanner = new Scanner(System.in);
    	//timer trackers for sorting algos
    	long beginTime,
    		  endTime,
    		  totalTime;
      
    	int n;
    	//take six array lengths as user input and test the speed 
    	//of bubblesort and quicksort with those arrays
    	for (int i=0;i<6;i++) {
    		System.out.println("enter the next list length to test "
    				+ "("+(6-i)+" more array lengths to test)");
    		n= myScanner.nextInt();
	        ArrayList numbers = new ArrayList(n);
	
	        //filling the list with random integers
	        for (int e = 0; e < n; e++)
	            numbers.add((int) (Math.random() * 100000));
	        
	        //commented out to get right to the speed in the output
	        //printing the list
	        //System.out.println("Original list of numbers:");
	        //numbers.display();
	
	        //testing bubblesort
	        ArrayList numbersCopy1 = numbers.copy();
	        
	        //System.out.println("\nBubble-sorted list of numbers:");
	        /*used nano seconds instead of milliseconds to
	           get a better look at the time difference
	           lower size arrays all come out to zero under mills
	           may be that my os counts by 10 mills instead one
	        */
	        
	        beginTime = System.currentTimeMillis();
	        numbersCopy1.bubbleSort();
	        endTime = System.currentTimeMillis();
	        totalTime = endTime - beginTime;
	        //numbersCopy1.display();
	        System.out.println("Time to complete bubble sort: "
	        		+ totalTime);
	
	        //testing quicksort
	        ArrayList numbersCopy2 = numbers.copy();
	        //System.out.println("\nQuick-sorted list of numbers:");
	        beginTime = System.currentTimeMillis();
	        numbersCopy2.quickSort();
	        endTime = System.currentTimeMillis();
	        totalTime = endTime - beginTime;
	        //numbersCopy2.display();
	        System.out.println("Time to complete quicksort: "+
    							totalTime);
    	}
    }

    public static void main(String[] args) {
        Lab9 myAppl = new Lab9();
    }
}

/**OUTPUT
 * 	enter the next list length to test (6 more array lengths to test)
	4
	Time to complete bubble sort: 0
	Time to complete quicksort: 0
	enter the next list length to test (5 more array lengths to test)
	10
	Time to complete bubble sort: 0
	Time to complete quicksort: 0
	enter the next list length to test (4 more array lengths to test)
	100
	Time to complete bubble sort: 2
	Time to complete quicksort: 2
	enter the next list length to test (3 more array lengths to test)
	1000
	Time to complete bubble sort: 46
	Time to complete quicksort: 5
	enter the next list length to test (2 more array lengths to test)
	10000
	Time to complete bubble sort: 485
	Time to complete quicksort: 6
	enter the next list length to test (1 more array lengths to test)
	100000
	Time to complete bubble sort: 56407
	Time to complete quicksort: 38
 *	
 * */




