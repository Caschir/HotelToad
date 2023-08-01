package Hotel_Reservation.src;

// Java Guest class
public class Guest {

    // Guest class attributes
    private String firstName;
    private String lastName;
    private String email;

    // Guest class constructor
    public Guest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters for Guest class
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String printGuestInfo(){
        return "\nFirst Name: "+firstName+"\nLast Name: "+lastName+"\nEmail: "+email+"\n";
    }
}
