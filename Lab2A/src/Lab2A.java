/**Joey Wilson
 * Lab2A
 * Due 8/31/2017
 * 
 */

import static java.lang.System.in;
import java.util.Scanner;


public class Lab2A {

    public static void main(String[] args) {
	Scanner myScanner = new Scanner(System.in);
       //create blank directory for staff and students
       Person[] directory = new Person[10];
       
       char keepLooping = 'y';
		int i=0;
		int userInput; 
		while(i<10 && keepLooping == 'y'){
			System.out.println("Would you like to make an entry? y/n");
			keepLooping = myScanner.next().trim().charAt(0);
			if (keepLooping == 'y') {
				System.out.println("Enter 1 for student,2 for faculty member, 3 for staff member ");
				userInput = myScanner.nextInt();
				switch(userInput){
					case 1: directory[i] = new Student();
						i++;
						break;
					case 2: directory[i] = new Faculty();
						i++;
						break;
					case 3: directory[i] = new Staff();
						i++;
						break;
					default: System.out.println("Invalid input. Try again.");
				}
		  }
		}
		//testing toString for all entries
		for(int e=0; e<directory.length;e++) {
			System.out.println(directory[e]);
		}

    }
    
}

abstract class Person {
    //data members
    private String fName, lName,phone,email;

    //default constructor takes input from user
    public Person(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter first name: ");
        fName = myScanner.nextLine(); 
        System.out.println("Please enter last name");
        lName = myScanner.nextLine();
        System.out.println("Please enter phone number");
        phone = myScanner.nextLine();
        System.out.println("Please enter email address");
        email = myScanner.nextLine();
    }

    //constructor with arguments
    public Person(String firstName,String lastName,
            String phoneNumber, String emailAddress){
            fName = firstName;
            lName = lastName;
            phone = phoneNumber;
            email = emailAddress;
    }

    //setters for data members
    public void setFirstName(String firstName){
        fName = firstName;
    }
    public void setLastName(String lastName){
        lName = lastName;
    }
    public void setPhoneNumber(String phoneNumber){
        phone = phoneNumber;
    }
    public void setEmail(String emailAddress){
        email = emailAddress;
    }

    //getters for data members
    public String getFirstName(){
        return fName;
    }
    public String getLastName(){
        return lName;
    }
    public String getPhoneNumber(){
        return phone;
    }
    public String getEmail(){
        return email;
    }

    //add everything to one string 
    public String toString(){
        return fName + " " + lName + " " + phone + " " + email;
       }

    //check for duplicates 
    public boolean equals(Person someDude){
        return someDude.fName == fName && someDude.lName == lName &&
                someDude.phone == phone && someDude.email == email;
    }         
}

class Student extends Person {
    Scanner myScanner = new Scanner(System.in);
    private int status;
    static final String[] STATUS = {"","Freshman","Sophomore",
        "Junior","Senior"};  
    //default constructor takes user input
    public Student(){
        super();
        System.out.println("Enter an integer for student year: ");
        status = myScanner.nextInt();
         String junk = myScanner.nextLine();
    }
    //constructer with arguments
    public Student(String firstName, String lastName, 
    		String phoneNumber, String emailAddress, int year){
        super(firstName,lastName,phoneNumber,emailAddress);
        status = year;
    }
    
    public String toString(){
        return "Student:\n" + super.toString() + " " +STATUS[status] + "\n";
    }
}

abstract class Employee extends Person {
    Scanner myScanner = new Scanner(System.in);
    String dept,salary,hireDate;
    //default constructor takes user input
    public Employee(){
        super();
        System.out.println("Please enter the department: ");
        dept = myScanner.nextLine();
        System.out.println("Please enter salary");
        salary = myScanner.nextLine();
        System.out.println("Please enter hire date");
        hireDate = myScanner.nextLine();
    }
    //constructor with arguments
    public Employee(String firstName, String lastName, String phoneNumber, 
    		String emailAddress,String department, String pay, 
                String startDate) {
    	super(firstName,lastName,phoneNumber,emailAddress);
    	dept = department;
    	salary = pay;
    	hireDate = startDate;
    }
    
    public String toString() {
    	return super.toString() + " " + dept + " " + salary + 
    			" " + hireDate + "\n"; 
    }
}

class Faculty extends Employee {
    Scanner myScanner = new Scanner(System.in);
    int rank;
    static final String[] RANK = {"","Instructor","Assistant Professor",
        "Associate Professor","Professor"};  
    //default constructor takes user input
    public Faculty(){
        super();
        System.out.println("Please enter an integer for rank: ");
        rank = myScanner.nextInt();
        String junk = myScanner.nextLine();
    }
    //constructor with arguments
    public Faculty(String firstName,String lastName,String phoneNumber, 
    		String emailAddress, String department, String pay, 
                String startDate, int jobRank) {
    	super(firstName,lastName,phoneNumber,emailAddress,
               department,  pay, startDate);
    	rank = jobRank;
    }
    
    public String toString() {
    	return "Faculty Member:\n" + super.toString() + " " + RANK[rank] + "\n";
    }
}

class Staff extends Employee {
    Scanner myScanner = new Scanner(System.in);
    String title;
    //default constructor takes user input
    public Staff(){
        super();
        System.out.println("Please enter job title: ");
        title = myScanner.nextLine();
    }
    //constructor with arguments
    public Staff(String firstName,String lastName, String phoneNumber,
    		String emailAddress, String department, String pay,
                String startDate, String jobTitle) {
    	super(firstName,lastName,phoneNumber,emailAddress, 
                department,  pay,  startDate);
    	title = jobTitle;
    }
    
    public String toString() {
    	return "Staff Member:\n" + super.toString() + " " + title + "\n";
    }
}