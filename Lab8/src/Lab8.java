/**Joey Wilson
 * Lab 8
 * Due: 10/19/2017
 *
 */

import java.util.Scanner;


public class Lab8 {

	public static void main(String[] args) {
			
		Scanner myScanner = new Scanner(System.in);
		int[] userInput = new int[20];
		int length;
		char goAgain='y';
		
		//main loop to allow for entering multiple arrays
		do {
			System.out.println("How large of an "
					+ "array would you like to find the sum of?\n"
					+ "Enter a number between 1 and 20\n");
			
			length =0;
			//User input for size of array (up to 20)
			while(length<1||length>20) {
				length =myScanner.nextInt();
			}
			
			//Take user input for array values 
			for(int i=0;i<length;i++) {
				System.out.println("Please add an integer to the array");
				System.out.println(length-i+" integers still needed\n");
				userInput[i]=myScanner.nextInt();
			}
			
			//shave one off because arrays start at zero
			length--;
			System.out.println("The sum of your array is: ");
			
			//call arraySum to add up our array values
			System.out.println(arraySum(userInput,length,0));
			
			System.out.println("Would you like to "
					+ "enter another array? y/n \n");
			goAgain = myScanner.next().trim().charAt(0);
		}while(goAgain=='y');	
	}
	
	public static int arraySum(int[]a, int length,int sum) {
		/*move backwards through array 
		 * values adding them to sum
		 * hits return sum when it has
		 * moved down the length of array
		*/
		
		if (length>=0) {
			
			sum += a[length];
			length--;
			sum = arraySum(a,length,sum);
			
		}	
		return sum;
	}

}

/**OUTPUT
* 	How large of an array would you like to find the sum of?
	Enter a number between 1 and 20
	
	2
	Please add an integer to the array
	2 integers still needed
	
	2
	Please add an integer to the array
	1 integers still needed
	
	3
	The sum of your array is: 
	5
	Would you like to enter another array? y/n 
	
	y
	How large of an array would you like to find the sum of?
	Enter a number between 1 and 20
	
	20
	Please add an integer to the array
	20 integers still needed
	
	1
	Please add an integer to the array
	19 integers still needed
	
	1
	Please add an integer to the array
	18 integers still needed
	
	1
	Please add an integer to the array
	17 integers still needed
	
	1
	Please add an integer to the array
	16 integers still needed
	
	1
	Please add an integer to the array
	15 integers still needed
	
	1
	Please add an integer to the array
	14 integers still needed
	
	1
	Please add an integer to the array
	13 integers still needed
	
	1
	Please add an integer to the array
	12 integers still needed
	
	1
	Please add an integer to the array
	11 integers still needed
	
	1
	Please add an integer to the array
	10 integers still needed
	
	1
	Please add an integer to the array
	9 integers still needed
	
	1
	Please add an integer to the array
	8 integers still needed
	
	1
	Please add an integer to the array
	7 integers still needed
	
	1
	Please add an integer to the array
	6 integers still needed
	
	1
	Please add an integer to the array
	5 integers still needed
	
	1
	Please add an integer to the array
	4 integers still needed
	
	1
	Please add an integer to the array
	3 integers still needed
	
	1
	Please add an integer to the array
	2 integers still needed
	
	1
	Please add an integer to the array
	1 integers still needed
	
	1
	The sum of your array is: 
	20
	Would you like to enter another array? y/n 
*/