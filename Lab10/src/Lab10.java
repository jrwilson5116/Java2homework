/********************************************
*   Joey Wilson
*   Lab10:  Faster Sorting Algorithms
*   Due: 10/26/2017
********************************************/

import java.util.*;
public class Lab10 {
	
   public static void main(String[] args) {
	   	Scanner myScanner = new Scanner(System.in);
        //final int SIZE = 1*1000*1000; // This format makes it easy to read!
	   	int size;
	   	for(int i=0;i<6;i++) {
	   		System.out.println("Please enter array length to test "+
	   								"("+(6-i)+" more lengths to test)");
	   		size = myScanner.nextInt();
	        Random r = new Random();
			  int[] a = new int[size];
			  int[] b = new int[size];
	        for (int e=0; e<size; e++) {
	            a[e] = r.nextInt(Integer.MAX_VALUE);
					b[e] = a[e];
	        }
	        
	        long start = System.nanoTime();
		     mergeSort(a);
	        long end = System.nanoTime();
	        System.out.println("mergesort time: ");
	        System.out.println(end-start); 
	        
	        start = System.nanoTime();
	        radixSort(b);
	        end = System.nanoTime();
	        System.out.println("radix sort time: ");
	        System.out.println(end-start);
	   	}    
   }
    
   //////////////////////////////////////////////////////////////////////////
   //                  MERGE SORT
   //////////////////////////////////////////////////////////////////////////
   public static void mergeSort(int[ ] a) {
		int[] tmp = new int[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
   }
   private static void mergeSort(int[ ] a, int[ ] tmp, int left, int right) {
      if( left < right ) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
		}
   }
   private static void merge(int[ ] a, int[ ] tmp, int left, int right, 
						int rightEnd ) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;
        while(left <= leftEnd && right <= rightEnd) {
            if(a[left] <=a[right])
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];
        }
        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];
        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];
        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
    
    //////////////////////////////////////////////////////////////////////////
    //                RADIX SORT
	 //////////////////////////////////////////////////////////////////////////
    // Sort the numbers beginning with least-significant digit
    public static int[] radixSort(int[] input){
        // Largest place for a 32-bit int is the 1 billion's place
        for(int place=1; place <= 1000000000; place *= 10){
            // Use counting sort at each digit's place
            input = countingSort(input, place);
        }
        return input;
    }
    private static int[] countingSort(int[] input, int place){
        int[] out = new int[input.length];
        int[] count = new int[10];
        for(int i=0; i < input.length; i++){
            int digit = getDigit(input[i], place);
            count[digit] += 1;
        }
        for(int i=1; i < count.length; i++){
            count[i] += count[i-1];
        }
        for(int i = input.length-1; i >= 0; i--){
            int digit = getDigit(input[i], place);

            out[count[digit]-1] = input[i];
            count[digit]--;
        }
        return out;
    }
    private static int getDigit(int value, int digitPlace){
        return ((value/digitPlace ) % 10);
    }    
}

/**OUTPUT
 * using currentTimeMills method to track time:
 * 
	Please enter array length to test (6 more lengths to test)
	4
	mergesort time: 
	0
	radix sort time: 
	0
	Please enter array length to test (5 more lengths to test)
	10
	mergesort time: 
	0
	radix sort time: 
	0
	Please enter array length to test (4 more lengths to test)
	100
	mergesort time: 
	0
	radix sort time: 
	0
	Please enter array length to test (3 more lengths to test)
	1000
	mergesort time: 
	6
	radix sort time: 
	20
	Please enter array length to test (2 more lengths to test)
	10000
	mergesort time: 
	5
	radix sort time: 
	42
	Please enter array length to test (1 more lengths to test)
	100000
	mergesort time: 
	70
	radix sort time: 
	164
 
 * 
 * */
