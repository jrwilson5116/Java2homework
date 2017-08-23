/**Joey Wilson
 * Lab1A.java
 * Due: 8/24/2017
 * 
 */
package lab1a;


public class Lab1A {

    public static void main(String[] args) {
        //creating some people
        Person joey = new Person();
        Person jonSnow = new Person("Jon","Snow","0","winterIsComing@gmail.com");
        
        //testing setter mutators 
        joey.setFirstName("Joey");
        joey.setLastName("Wilson");
        joey.setPhoneNumber("555");
        joey.setEmail("jrwilson@gmail.com");
        
        //test if joey and jon snow are the same guy
        System.out.println(joey.equals(jonSnow));
        
        //testing toString method
        System.out.println(joey);
        System.out.println(jonSnow);
    }
}

class Person {
    //data members
    private String fName, lName,phone,email;

    //default constructor
    public Person(){
        fName = ""; //my bolagna has a first name. It's  O-S-C-A-R.
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
        String output = fName + " " + lName + " " + phone + " " + email;
        return output;
       }

    //check for duplicates 
    public boolean equals(Person someDude){
        return someDude.fName == fName && someDude.lName == lName &&
                someDude.phone == phone && someDude.email == email;
    }         
}

/**OUTPUT
 *  false
    Joey Wilson 555 jrwilson@gmail.com
    Jon Snow 0 winterIsComing@gmail.com
    BUILD SUCCESSFUL (total time: 0 seconds)
 */
