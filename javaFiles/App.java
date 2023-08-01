package Hotel_Reservation.src;

// Import Java Scanner for user input
import java.util.Scanner;

// Main Java App class
public class App {
    public static void main(String[] args) throws Exception{

        cls();

        // Create 10 Room elements with the help of the Java Room class
        Room r1 = new Room(1 ,"Single" , true , 100);
        Room r2 = new Room(1 ,"Double" , true , 200);
        Room r3 = new Room(1 ,"Triple" , true , 420);
        Room r4 = new Room(1 ,"Single" , true , 100);
        Room r5 = new Room(1 ,"Double" , true , 200);
        Room r6 = new Room(1 ,"Triple" , true , 420);
        Room r7 = new Room(1 ,"Single" , true , 100);
        Room r8 = new Room(1 ,"Double" , true , 200);
        Room r9 = new Room(1 ,"Triple" , true , 420);
        Room r10 = new Room(1 ,"Suite" , true , 1000000000);

        // Create an array of rooms to add to a Hotel object
        Room[] rooms = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};

        // Create Hotel element
        Hotel H = new Hotel(rooms);

        // Create Scanner object called scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Simple hotel reservation system
        while (true){
            System.out.println("\nWelcome to Hotel Toad!");
            System.out.println("If Admin Enter 'Admin': ");
            System.out.println("If Customer Enter 'Customer' ");
            System.out.println("To Exit Enter 'Exit': ");
            System.out.println("Enter your choice: ");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Admin")){

                // Create Manger object
                Manager M = new Manager();
                M.generateReport();

            } else if (input.equalsIgnoreCase("Customer")){

                System.out.println("To make a reservation we need you're First Name: ");
                String firstName = scanner.nextLine();

                System.out.println("Next you're Last Name: ");
                String lastName = scanner.nextLine();

                System.out.println("Lastly you're Email: ");
                String email = scanner.nextLine();

                // Create Guest object
                Guest G = new Guest(firstName, lastName, email);

                // Call Guest method printGuestInfo to print guest object data
                System.out.println(G.printGuestInfo());

            } else if (input.equalsIgnoreCase("Exit")){

                // Exit reservation system
                System.out.println("Exiting...");
                break;

            } else {

                // Continue loop until valid input is given
                System.out.println("Invalid choice, please try again.");
            }
        }

        // close scanner object
        scanner.close();
    }

    public static void cls(){

        // cls
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 

    }
}