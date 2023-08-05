package Hotel_Reservation.src;

// Import Java Scanner for user input
import java.util.Scanner;

// Main Java App class
public class App {
    public static void main(String[] args) throws Exception{

        cls();

        // Create 10 Room elements with the help of the Java Room class
        Room r1 = new Room(1 ,"Single" , true);
        Room r2 = new Room(2 ,"Double" , true);
        Room r3 = new Room(3 ,"Triple" , true);
        Room r4 = new Room(4 ,"Single" , true);
        Room r5 = new Room(5 ,"Double" , true);
        Room r6 = new Room(6 ,"Triple" , true);
        Room r7 = new Room(7 ,"Single" , true);
        Room r8 = new Room(8 ,"Double" , true);
        Room r9 = new Room(9 ,"Triple" , true);
        Room r10 = new Room(10 ,"Suite" , true);

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

            // Handles Manager input
            if (input.equalsIgnoreCase("Admin")){

                // Create Manger object
                Manager M = new Manager();
                M.generateReport();

            // Handles Customer input
            } else if (input.equalsIgnoreCase("Customer")){

                // Asks Customer if they want to reserve or cancel room
                System.out.println("Do you want to 'Reserve' or 'Cancel' a room?");
                String choice = scanner.nextLine();

                // Gets information from customer to reserve room
                if (choice.equalsIgnoreCase("Reserve")){
                    System.out.println("To make a reservation we're going to need some information");
                    System.out.println("Enter you're First Name: ");
                    String firstName = scanner.nextLine();

                    // Information for Guest object
                    System.out.println("Enter you're Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.println("Enter you're Email: ");
                    String email = scanner.nextLine();

                    // Create Guest object
                    Guest G = new Guest(firstName, lastName, email);

                    // Information for Reservation object
                    System.out.println("Enter the number of Adults: ");
                    int adults = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter the number of Children: ");
                    int children = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter check-in date (MM/DD/YYYY): ");
                    String checkIn = scanner.nextLine();

                    System.out.println("Enter check-out date (MM/DD/YYYY): ");
                    String checkOut = scanner.nextLine();

                    System.out.println("Enter room type (Single/Double/Triple/Suite): ");
                    String roomType = scanner.nextLine();

                    System.out.println("Anything else? (message): ");
                    String message = scanner.nextLine();

                    // Create Reservation Object
                    Reservation R = new Reservation(adults, children, checkIn, checkOut, roomType, message);

                    // Call Guest method printGuestInfo to print guest object data
                    System.out.println("\nGuest Information");
                    System.out.println(G.printGuestInfo());

                    // Call Reservation method printReservationInfo to print reservation object data
                    System.out.println("\nReservation Information");
                    System.out.println(R.printReservationInfo());

                    // Call reserveRoom method from Hotel Class to reserve hotel room for Customer
                    H.reserveRoom(G, roomType, checkIn, checkOut,email);
                    
                    // Create Payment object
                    Payment P = new Payment();

                    // Calculate Hotel Bill for Customer stay
                    P.calculateBill(G, R);

                // Cancel guest reservation option
                } else if (choice.equalsIgnoreCase("Cancel")){
                    System.out.println("Enter the room number for the room reservation you want to cancel: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();

                    // Call cancelRoom method from Hotel Class to cancel hotel room reservation for Customer
                    H.cancelRoom(roomNumber);
                }

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