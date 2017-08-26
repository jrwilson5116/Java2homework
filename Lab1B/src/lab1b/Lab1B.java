/**Joey Wilson
 * Lab1B
 * Due: 8/29/2017
 * Continuing to review OOP by adding subclasses to Lab1A
 */
package lab1b;

public class Lab1B {

    public static void main(String[] args) {
        //create some people 
    	Student joey = new Student("Joey","Wilson",
    			"5555555","jrwilson5116@gmail.com", 1);
    	Employee scruffy = new Employee("Scruffy","Poppins","6666666",
    			"futuramaJanitor@hotmail.com","Custodial","25000","Jan 1 3001");
    	Faculty soden = new Faculty("Richard","Soden",
    			"77777777","richard.soden@gmail.com",4);
    	Staff layoffBot9000 = new Staff("layoffBot","9000","1010101100",
    			"fireAllHumans@layoffBot.com","A.I. created to select humans for termination");
    	
    	//test toString method
    	System.out.println(joey + "\n" + scruffy + "\n" + 
    			soden + "\n" + layoffBot9000);
    }
    
}

class Person {
    //data members
    private String fName, lName,phone,email;

    //default constructor
    public Person(){
        fName = ""; 
        lName = "";
        phone = "";
        email = "";
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
    private int status;
    static final String[] STATUS = {"","Freshman","Sophomore",
        "Junior","Senior"};  
    
    public Student(String firstName, String lastName, 
    		String phoneNumber, String emailAddress, int year){
        super(firstName,lastName,phoneNumber,emailAddress);
        status = year;
    }
    
    public String toString(){
        return super.toString() + " " +STATUS[status] + "\n";
    }
}

class Employee extends Person {
    String dept,salary,hireDate;
    
    public Employee(String firstName, String lastName, String phoneNumber, 
    		String emailAddress,String department, String pay, String startDate) {
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

class Faculty extends Person {
    int rank;
    static final String[] RANK = {"","Instructor","Assistant Professor",
        "Associate Professor","Professor"};        
    
    public Faculty(String firstName,String lastName,String phoneNumber, 
    		String emailAddress, int jobRank) {
    	super(firstName,lastName,phoneNumber,emailAddress);
    	rank = jobRank;
    }
    
    public String toString() {
    	return super.toString() + " " + RANK[rank] + "\n";
    }
}

class Staff extends Person {
    String title;
    
    public Staff(String firstName,String lastName, String phoneNumber,
    		String emailAddress, String jobTitle) {
    	super(firstName,lastName,phoneNumber,emailAddress);
    	title = jobTitle;
    }
    
    public String toString() {
    	return super.toString() + " " + title + "\n";
    }
}

/***OUTPUT
**Joey Wilson 5555555 jrwilson5116@gmail.com Freshman
**
**Scruffy Poppins 6666666 futuramaJanitor@hotmail.com Custodial 25000 Jan 1 3001
**
**Richard Soden 77777777 richard.soden@gmail.com Professor
**
**layoffBot 9000 1010101100 fireAllHumans@layoffBot.com A.I. created to select humans for termination
**
***/