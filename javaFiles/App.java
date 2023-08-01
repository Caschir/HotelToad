package Hotel_Reservation.src;



public class App {
    public static void main(String[] args) throws Exception {
        
        cls();
         Room r1 = new Room();
        r1.room(1 ,"Single" , true , 100);
        Room r2 = new Room();
        r2.room(2 ,"Double" , true , 200);
        Room r3 = new Room();
        r3.room(3 ,"Triple " , true , 420);
        Room r4 = new Room();
        r4.room(4 ,"Single" , true , 100);
        Room r5 = new Room();
        r5.room(5 ,"Double" , true , 200);
        Room r6 = new Room();
        r6.room(6 ,"Triple " , true , 420);
        Room r7 = new Room();
        r7.room(7 ,"Single" , true , 100);
        Room r8 = new Room();
        r8.room(8 ,"Double" , true , 200);
        Room r9 = new Room();
        r9.room(9 ,"Triple " , true , 420);
        Room r10 = new Room();
        r10.room(10 ,"Stuite " , true , 1000000000);
        Room [] rooms ={r1,r2,r3,r4,r5,r6,r7,r8,r9,r10};
        Hotel H = new Hotel(rooms);




        System.out.println(" Welcome to Hotel Toad ");
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Admin or Customer :");
       
        String input = scanner.nextLine();
     
        if ( input.equalsIgnoreCase("Admin")){
            Manager M = new Manager();
            M.generateReport();
        }
        else if (input.equalsIgnoreCase("Customer")){
            
            
            
            System.out.println(" To make a reservation we need First Name  ");
            String firstName = scanner.nextLine();
            System.out.println("Next youre Last Name ");
            String lastName = scanner.nextLine();
            System.out.println("Lastly youre Email");
            String email = scanner.nextLine();
    
            Guest G = new Guest();
            G.guestInfo(firstName, lastName, email);
        }
        while(true);
        
    }
    public static void cls()
    {
                // cls
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
    
   
}
