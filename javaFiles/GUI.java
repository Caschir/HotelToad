package Hotel_Toad;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a GUI interface for a hotel system.
 * Contains visual components and related actions for interacting with the hotel system.
 * @author Toad's Taskforce
 * @version 1.0
 * <p>
 * Date of Creation: 28 July 2023
 * </p>
 */


public class GUI {
     /** The first name of the guest. */
     public static String firstName1String;
    
     /** The last name of the guest. */
     public static String lastName1String;
     
     /** The email address of the guest. */
     public static String email1String;
     
     /** The check-in date string. */
     public static String checkIn1String;
     
     /** The check-out date string. */
     public static String checkOut1String;
     
     /** The type of the room reserved by the guest. */
     public static String roomType1String;
     
     /** Any additional message or notes associated with the reservation. */
     public static String message1String;
    
     /** The number of adults for the reservation. */
     static String adults;
     
     /** The number of children for the reservation. */
     static String children;
     
     /** The room number assigned for the reservation. */
     public static int roomNumber;
      /**
     * The main entry point for the hotel reservation system.
     * <p>
     * Initializes the hotel rooms and their properties.
     * </p>
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        /**
         * Initialization of various rooms in the hotel.
         */
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
        
        /**
         * Aggregate all initialized rooms into an array to represent them collectively.
         */
        // Create an array of rooms to add to a Hotel object
        Room[] rooms = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        /**
         * Create a hotel object, passing in the collection of initialized rooms.
         */
        // Create Hotel element
        Hotel H = new Hotel(rooms);
    
        /**
         * Main GUI frame for the hotel application.
         */
        // Create GUI frame
        JFrame frame = new JFrame("Hotel Toad GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);

        /**
         * Initialize various panels for different sections and functionalities of the hotel GUI.
         * For instance, these might represent different screens or sections within the application such 
         * as home, booking, rooms view, etc.
         */
        // Create panels
        JPanel mainPanel = new JPanel(new CardLayout());
        JPanel homePanel = new JPanel(new BorderLayout());
        JPanel bookingPanel = new JPanel(new BorderLayout());
        JPanel roomsPanel = new JPanel(new BorderLayout());
        JPanel amenitiesPanel = new JPanel(new BorderLayout());
        JPanel logoAndButtonPanel = new JPanel(new BorderLayout());
        JPanel P1Panel = new JPanel(new BorderLayout());
        JPanel P3Panel = new JPanel(new BorderLayout());
        JPanel P1aPanel = new JPanel(new BorderLayout());
        JPanel P3aPanel = new JPanel(new BorderLayout());
        JPanel hPanel = new JPanel(new BorderLayout());



        /**
         * Initialization and setup of GUI components for the hotel application.
         */

        // Nested button panel for housing top navigation buttons.
        /**
         * Panel that holds the top navigation buttons.
         */
        // Create nested buttons panel for top buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        /**
         * Creation of buttons with specific styling for navigation and user actions.
         */
        // Create buttons
        JButton homeButton = buttonStyling("Home", Color.GREEN);
        JButton roomsButton = buttonStyling("Rooms", Color.GREEN);
        JButton amenitiesButton = buttonStyling("Amenities", Color.GREEN);
        JButton bookingButton = buttonStyling("Book Now", Color.RED);
        JButton cancelReservationButton = buttonStyling("Cancel Reservation",Color.MAGENTA);
        JButton adminButton = buttonStyling("Admin",Color.ORANGE);

        /**
         * Scrollable panels to ensure the content of certain sections can be scrolled if they extend beyond the visible area.
         */
        // scrollable panels
        JScrollPane homeScrollPane = new JScrollPane(homePanel);
        JScrollPane amenitiesScrollPane = new JScrollPane(amenitiesPanel);
        JScrollPane RoomsScrollPane = new JScrollPane(roomsPanel); 
        JScrollPane BookingScrollPane = new JScrollPane(bookingPanel);

        /**
         * Adding the created buttons to the button panel.
         */
        // Add buttons to button panel
        buttonPanel.add(homeButton);
        buttonPanel.add(roomsButton);
        buttonPanel.add(amenitiesButton);
        buttonPanel.add (cancelReservationButton);
        buttonPanel.add(adminButton);
        
        /**
         * Load an image representing the hotel and create a label to display it within the GUI.
         */

        // Load the hotel image and create a JLabel for the image
        ImageIcon imageIcon = new ImageIcon("images/hotel.png");
        JLabel imageLabel = new JLabel(imageIcon);
       
        /**
         * Color definitions for possible GUI customization or styling.
         */
        //colors
        Color myColor = new Color(18, 13, 13); 
        Color myColor1 = new Color(51, 51, 51);
        Color myColor2 = new Color(251, 241, 241); 
        
        /**
         * GUI components related to the footer section of the hotel application.
         */

        /**
         * Footer label with a custom border.
         */
        //footer
        JLabel footerLabel = new JLabel();
        MatteBorder footerBorder = BorderFactory.createMatteBorder(78, 0, 2, 0, myColor1);
        footerLabel.setBorder(footerBorder);
        
        /**
         * Secondary footer label with a custom border.
         */
        JLabel footerLabel2 = new JLabel();
        MatteBorder footerBorder2 = BorderFactory.createMatteBorder(210, 0, 15, 0,myColor);
        footerLabel2.setBorder(footerBorder2);
       
       /**
         * Copyright label with predefined text and styling.
         */
        //footer labels/styling
        JLabel t = new JLabel("<html>Copyright \u00A9 2023 Hotel Toad. <br>\r\n" + //
                "All rights reserved. All trademarks, service marks, trade names, trade dress, product names and logos appearing on the site are the property of their respective owners\r\n" + //
                        "\r\n");
        Font  tt  = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 12);
        t.setFont(tt);
        t.setForeground(Color.WHITE);
        t.setBounds(44,912,511,411);

        /**
         * About us label with predefined text and styling.
         */
        JLabel t1 = new JLabel("ABOUT US");
        Font  tt1  = new Font(Font.DIALOG, Font.BOLD, 18);
        t1.setFont(tt1);
        t1.setForeground(myColor2);
        t1.setBounds(124,980,511,411);

        /**
         * Description label detailing the charm and allure of Hotel Toad.
         */
        JLabel t2 = new JLabel("<html>Embracing the timeless charm of Hotel Toad<br>amidst the modern allure of current hospitality,\r\n" + //
                "<br>Hotel Toad offers you a lasting escape from\r\n" + //
                        "<br>the instant you step into your cherished retreat.\r\n" + //
                                "\r\n" + //
                                " </html>");
        Font  ttt  = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 14);
        t2.setFont(ttt);
        t2.setForeground(Color.WHITE);
        t2.setBounds(44,1042,511,411);

        /**
         * Label to showcase the location heading.
         */
        JLabel t3 = new JLabel("LOCATION");
        t3.setFont(tt1);
        t3.setForeground(myColor2);
        t3.setBounds(924,980,511,411);

        /**
         * Address label displaying the location of Hotel Toad.
         */
        JLabel t4 = new JLabel("100 Universal City Plaza, Universal City, CA 91608");
        t4.setFont(ttt);
        t4.setForeground(Color.WHITE);
        t4.setBounds(824,1012,511,411);

       
        /**
         * GUI components and styling related to the "Contact Us" section, logos, and room types of the hotel application.
         */

        /**
         * Label for "CONTACT US" header.
         */      
        JLabel t5 = new JLabel("CONTACT US");
        t5.setFont(tt1);
        t5.setForeground(myColor2);
        t5.setBounds(1574,980,511,411);

        /**
         * Label displaying the email and phone contact details of the hotel.
         */
        JLabel t6 = new JLabel("<html> Email: universalstudios@gmail.com <br><br>Phone: 818-259-3329 </html>");
        t6.setFont(ttt);
        t6.setForeground(Color.WHITE);
        t6.setBounds(1524,1042,511,411);

        /**
         * Adding footer labels to a nested panel.
         */
        //add footer labels to nested panel
        hPanel.add(t);
        hPanel.add(t1);
        hPanel.add(t2);
        hPanel.add(t3);
        hPanel.add(t4);
        hPanel.add(t5);
        hPanel.add(t6);
   
        hPanel.add(imageLabel, BorderLayout.NORTH);
        hPanel.add(footerLabel, BorderLayout.CENTER);
        hPanel.add(footerLabel2, BorderLayout.SOUTH);
       
        /**
         * Nesting labels to the main panel.
         */
        //add nested labels to main panel
        homePanel.add(hPanel, BorderLayout.CENTER);

        // homePanel.add(footerLabel, BorderLayout.SOUTH);
        /**
         * Logo label with predefined image and border styling.
         */
        //add logo
        ImageIcon logo = new ImageIcon("images/logo.png");
        JLabel logoLabel = new JLabel(logo);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        logoLabel.setBorder(border);

        /**
         * Nesting elements to the logo and button panel.
         */
        logoAndButtonPanel.add(bookingButton, BorderLayout.EAST);
        logoAndButtonPanel.add(logoLabel, BorderLayout.WEST);
        logoAndButtonPanel.add(buttonPanel, BorderLayout.CENTER);
        homePanel.add(logoAndButtonPanel, BorderLayout.NORTH);
        buttonPanel.setBackground(Color.DARK_GRAY);
        
        logoAndButtonPanel.setBackground(Color.LIGHT_GRAY);
        
        //padding
        /**
         * Setting padding for buttons and panels.
         */
        EmptyBorder b = new EmptyBorder(22, 120, 0, 0);    
        buttonPanel.setBorder(b);
        EmptyBorder a = new EmptyBorder(0, 33, 0, 74);
        bookingButton.setBorder(a);
    
        // Rooms panel start
        
       /**
         * Loading images for different room types.
         */
        // Load images
        ImageIcon P1 = new ImageIcon("images/single.png");
        ImageIcon P2 = new ImageIcon("images/double.png");
        ImageIcon P3 = new ImageIcon("images/triple.png");
        ImageIcon P4 = new ImageIcon("images/suite.png");

       /**
         * Label for "Single Queen" title and its styling.
         */
        // label for title/ title styling
        JLabel P1LabelT = new JLabel("Single Queen");
        Font  f3  = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 32);
        P1LabelT.setFont(f3);
        P1LabelT.setForeground(Color.GRAY);
        P1LabelT.setBounds(1244,312,511,111);
        
        /**
         * Description label for "Single Queen" room type.
         */
        // label for text/ styling
        JLabel P1LabelTT = new JLabel("<html> Step into the delightful world of Mario-themed rooms, and\r\n" + //
                "experience<br> the comfort of air-conditioned spaces seamlessly\r\n" + //
                "ensuring a truly enjoyable adventure</html>");
        Font  f3T  = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 22);
        P1LabelTT.setFont(f3T);
        P1LabelTT.setForeground(Color.BLACK);
        P1LabelTT.setBounds(1044,162,711,711);

        /**
         * Label for "Classic Double" title and its styling.
         */
        JLabel P2LabelT = new JLabel("Classic Double");
        P2LabelT.setFont(f3);
        P2LabelT.setForeground(Color.GRAY);
        P2LabelT.setBounds(444,1212,511,111);

        /**
         * Description label for "Classic Double" room type.
         */
        JLabel P3LabelTT = new JLabel("<html> Our Classic Double room is meticulously crafted as a haven of\r\n" + 
                "tranquility and rejuvenation. Experience the enchanting blend\r\n" + //
                        "\r\n" + //
                "of Mario's charm and<br> modern amenities in this retreat.\r\n" + //
                      "</html>");
        P3LabelTT.setFont(f3T);
        P3LabelTT.setForeground(Color.BLACK);
        P3LabelTT.setBounds(244,1072,711,711);

        /**
         * Label for "Classic Triple" title and its styling.
         */
        JLabel P3LabelT = new JLabel("Classic Triple");
        P3LabelT.setFont(f3);
        P3LabelT.setForeground(Color.GRAY);
        P3LabelT.setBounds(1114,242,511,111);

        /**
         * Description label for "Classic Triple" room type.
         */
        JLabel P4LabelTT = new JLabel("<html> Step into the enchanting realm of our Mario-themed Triple Beds Room,\r\n" + //
                "\r\n" + //
                "where the magic of Mario awaits you and your companions. Embrace\r\n" + //
                        "\r\n" + //
                "the ultimate comfort and convenience.\r\n" + //
                 "</html>");
        P4LabelTT.setFont(f3T);
        P4LabelTT.setForeground(Color.BLACK);
        P4LabelTT.setBounds(944,122,711,711);

        /**
         * Label for "Classic Suite" title and its styling.
         */
        JLabel P4LabelT = new JLabel("Classic Suite");
        P4LabelT.setFont(f3);
        P4LabelT.setForeground(Color.GRAY);
        P4LabelT.setBounds(544,1122,511,111);

       
        /**
         * Description label for "Classic Suite" room type.
         */
        JLabel P5LabelTT = new JLabel("<html> Immerse yourself in an unparalleled experience of opulence\r\n" + //
                "\r\n" + //
                "as you step into this magnificent haven. Each detail of the suite is meticulously\r\n" + //
                        "\r\n" + //
                "crafted to exceed your highest expectations, providing the perfect setting. \r\n" + //
                        "\r\n" + //
                 "</html>");
        P5LabelTT.setFont(f3T);
        P5LabelTT.setForeground(Color.BLACK);
        P5LabelTT.setBounds(244,972,711,711);

        /**
         * Image labels for room types.
         */
        //img labels
        JLabel P1Label = new JLabel(P1);
        JLabel P2Label = new JLabel(P2);
        JLabel P3Label = new JLabel(P3);
        JLabel P4Label = new JLabel(P4);


         /**
         * Padding for room type images.
         */
         // Adds padding through an empty border
        EmptyBorder paddingBorder = new EmptyBorder(122, 140, 0, 1244);   
        EmptyBorder paddingBorder1 = new EmptyBorder(244, 740, 0, 0);
        EmptyBorder paddingBorder4 = new EmptyBorder(244, 740, 110, 0);   

        /**
         * Configures the borders for various labels.
         * <p>
         * P1Label and P3Label are given the same padding via {@code paddingBorder}.
         * P2Label uses {@code paddingBorder1} and P4Label uses {@code paddingBorder4}.
         * </p>
         */
        P1Label.setBorder(paddingBorder);
        P3Label.setBorder(paddingBorder);     

        P2Label.setBorder(paddingBorder1);    
        P4Label.setBorder(paddingBorder4);         
        /**
         * Adds images and text components to Panel.
         * <p>
         * This nests various labels, possibly representing images or text, into the P1Panel.
         * </p>
         */
     // Add img/text to nested panel   
        P1Panel.add(P1LabelT); 
        P1Panel.add(P1LabelTT);
        P1Panel.add(P3LabelTT);

     // Add img/text to nested panel   
        P3Panel.add(P4LabelTT);
        P3Panel.add(P5LabelTT);

        P1Panel.add(P2Label, BorderLayout.SOUTH);
        P1Panel.add(P2LabelT); 

        P3Panel.add(P4Label, BorderLayout.SOUTH);
        P3Panel.add(P3LabelT);
        P3Panel.add(P4LabelT);

        P1Panel.add(P1Label);
        P3Panel.add(P3Label);
        /**
         * Adds the nested panels P1Panel and P3Panel to the main panel called roomsPanel.
         */
        // add nested panels to main panel
        roomsPanel.add(P1Panel, BorderLayout.CENTER);
        roomsPanel.add(P3Panel, BorderLayout.SOUTH);

         // Rooms panel end


    // amenities tab start
        /**
         * Starts the configuration for the amenities tab.
         * 
         * Here we're loading up images for various amenities from specified paths.
         */

        // Load images
        ImageIcon P1a = new ImageIcon("images/pool.png");
        ImageIcon P2a = new ImageIcon("images/breakfast.jpg");
        ImageIcon P3a = new ImageIcon("images/fitnessRoom.png");
        ImageIcon P4a = new ImageIcon("images/golf.png");

        /**
         * Configures a label, possibly for showing information about an outdoor pool.
         * <p>
         * This sets up the text, font, color, and positioning for the label.
         * </p>
         */
        JLabel P1aLabelT = new JLabel("<html>Outdoor Pool<br> & Deck</html>");
        P1aLabelT.setFont(f3);
        P1aLabelT.setForeground(Color.GRAY);
        P1aLabelT.setBounds(1124,312,511,111);

        /**
         * Represents a label displaying a detailed description of the outdoor pool.
         * <p>
         * The label presents the facilities and ambiance of the heated outdoor pool 
         * where guests can relax and enjoy.
         * </p>
         */
        JLabel P1aLabelTT = new JLabel("<html> Take a dip in our heated outdoor pool and enjoy\r\n" + //
                "your time poolside with a drink. Curl up with your favorite\r\n" + //
                        "\r\n" + //
                "book, cool off after a busy day, and soak up the sun.\r\n" + //
                        "</html>");
        P1aLabelTT.setFont(f3T);
        P1aLabelTT.setForeground(Color.BLACK);
        P1aLabelTT.setBounds(944,162,711,711);

        /**
         * Represents a label highlighting the offering of a continental breakfast.
         */
        JLabel P2aLabelT = new JLabel("<html>Continental<br>Breakfast</html>");
        P2aLabelT.setFont(f3);
        P2aLabelT.setForeground(Color.GRAY);
        P2aLabelT.setBounds(444,1062,511,111);

        /**
         * Represents a label displaying a detailed description of the complimentary continental breakfast.
         * <p>
         * The label describes the various food items offered in the breakfast to entice the guests.
         * </p>
         */
        JLabel P3aLabelTT = new JLabel("<html> Enjoy our complimentary continental breakfast, featuring\r\n" + //
                "\r\n" + 
                "freshly baked pastries, a variety of bread, healthy fruits\r\n" + //
                "and yogurt. A perfect way to kickstart your morning.\r\n" + //
                      "</html>");
        P3aLabelTT.setFont(f3T);
        P3aLabelTT.setForeground(Color.BLACK);
        P3aLabelTT.setBounds(244,922,711,711);

        /**
         * Represents a label highlighting the availability of a fitness center.
         */
        JLabel P3aLabelT = new JLabel("Fitness Center");
        P3aLabelT.setFont(f3);
        P3aLabelT.setForeground(Color.GRAY);
        P3aLabelT.setBounds(1114,242,511,111);


        /**
         * Represents a label displaying a detailed description of the modern fitness center.
         * <p>
         * The label showcases the variety of exercise options available to cater to all fitness levels.
         * </p>
         */
        JLabel P4aLabelTT = new JLabel("<html> Jumpstart your day at our modern fitness center. Enjoy a wide range\r\n" + //
                "\r\n" + //
                "of exercise options suitable for all fitness levels. Discover\r\n" + //
                "moments of leisure in our versatile yoga.\r\n" + //
                 "</html>");
        P4aLabelTT.setFont(f3T);
        P4aLabelTT.setForeground(Color.BLACK);
        P4aLabelTT.setBounds(944,82,711,711);

        /**
         * Represents a label highlighting the availability of a golf course.
         */
        JLabel P4aLabelT = new JLabel("Golf Course");
        P4aLabelT.setFont(f3);
        P4aLabelT.setForeground(Color.GRAY);
        P4aLabelT.setBounds(444,1122,511,111);

        /**
         * Represents a label displaying a detailed description of the golf course.
         * <p>
         * The label presents the exquisiteness of the golf course, describing its challenges 
         * and pristine conditions, aiming to attract golf enthusiasts.
         * </p>
         */
        JLabel P5aLabelTT = new JLabel("<html> Embark on an unforgettable golfing journey at our stunning course\r\n" + //
                "\r\n" + //
                "Delight in diverse challenges catering to golfers of all levels. from\r\n" + //
                "well-groomed fairways to immaculate greens, it's a golfer's paradise.\r\n" + //
                 "</html>");
        P5aLabelTT.setFont(f3T);
        P5aLabelTT.setForeground(Color.BLACK);
        P5aLabelTT.setBounds(244,972,711,711);

        /**
         * Initializes labels to hold images for various amenities.
         */
        // img labels
        JLabel P1aLabel = new JLabel(P1a);
        JLabel P2aLabel = new JLabel(P2a);
        JLabel P3aLabel = new JLabel(P3a);
        JLabel P4aLabel = new JLabel(P4a);


         /**
         * Applies padding to the image labels.
         * Different borders are applied to different labels as defined earlier in the code.
         */
        // padding
        P1aLabel.setBorder(paddingBorder);
        P3aLabel.setBorder(paddingBorder);     

        P2aLabel.setBorder(paddingBorder1);    
        P4aLabel.setBorder(paddingBorder4);         
     
     // add elements to nested panels   
        P1aPanel.add(P1aLabelT); 
        P1aPanel.add(P1aLabelTT);
        P1aPanel.add(P3aLabelTT);

        P3aPanel.add(P4aLabelTT);
        P3aPanel.add(P5aLabelTT);

        P1aPanel.add(P2aLabel, BorderLayout.SOUTH);

        P1aPanel.add(P2aLabelT); 


        P3aPanel.add(P4aLabel, BorderLayout.SOUTH);
        P3aPanel.add(P3aLabelT);
        P3aPanel.add(P4aLabelT);


        P1aPanel.add(P1aLabel);
        P3aPanel.add(P3aLabel);

        /**
         * Adds the P1aPanel and P3aPanel to the main amenities panel.
         */
        // add nested panels to main panel
        amenitiesPanel.add(P1aPanel, BorderLayout.CENTER);
        amenitiesPanel.add(P3aPanel, BorderLayout.SOUTH);

        // This marks the end of configuration for the amenities tab

        /**
         * Adds different scrollable panels to the main panel using CardLayout.
         * This allows for switching between different panels based on user interaction.
         */
        // amenities tab end

        // Add panels to the main panel with CardLayout
        mainPanel.add(homeScrollPane, "Home");
        mainPanel.add(BookingScrollPane, "Booking");
        mainPanel.add(RoomsScrollPane, "Rooms"); 
        mainPanel.add(amenitiesScrollPane, "Amenities");
       
        /**
         * Adds the main panel to the main application frame.
         */
        // Add main panel to the frame
        frame.add(mainPanel);

        /**
         * Action listener for bookingButton.
         * On clicking the bookingButton, the frame visibility is set to false.
         */
        // action listeners
        bookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        /**
         * Action listener for amenitiesButton.
         * On clicking the amenitiesButton, the view is switched to show the amenities tab.
         * Additionally, styling adjustments are made to the booking button and logoAndButtonPanel is added to the amenitiesPanel.
         */
        amenitiesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
          
                // add buttonPanel to booking panel
                // Styling adjustments
        EmptyBorder a = new EmptyBorder(0, 33, 0, 226);
        bookingButton.setBorder(a);
        amenitiesPanel.add(logoAndButtonPanel, BorderLayout.NORTH);
                 // Switching view to show amenities tab
                cardLayout.show(mainPanel, "Amenities");

            }
        });

        /**
         * Action listener for roomsButton.
         * On clicking the roomsButton, the view is switched to show the rooms panel.
         * Styling adjustments are also made to the booking button and logoAndButtonPanel is added to the roomsPanel.
         */
        roomsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                // add buttonPanel to booking panel
                // Styling adjustments
        EmptyBorder a = new EmptyBorder(0, 33, 0, 226);
        bookingButton.setBorder(a);
        roomsPanel.add(logoAndButtonPanel, BorderLayout.NORTH);
                // Switching view to show rooms panel
                 cardLayout.show(mainPanel, "Rooms");

            }
        });          
            /**
             * Action listener for homeButton.
             * On clicking the homeButton, the view is switched to show the home panel.
             * Styling adjustments are also made to the booking button and logoAndButtonPanel is added to the homePanel.
             */
        // action listener for home panel
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                // Styling adjustments
        EmptyBorder a = new EmptyBorder(0, 33, 0, 74);
        bookingButton.setBorder(a);
        homePanel.add(logoAndButtonPanel, BorderLayout.NORTH);
                // Switching view to show home panel
                cardLayout.show(mainPanel, "Home");
            }
        });
       
        /**
         * Set the main application frame as visible.
         */
        // Make frame visible
        frame.setVisible(true);
    
        /**
         * Creates an administrative frame for hotel management purposes.
         */
        JFrame adminFrame = new JFrame("Hotel Toad GUI");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(1280, 720);

        /**
         * Creates a new panel for administrative controls.
         */  
        JPanel adminPanel = new JPanel();
        
        /**
         * Creates password and username text input fields
         * Creates enter and back buttons
        */
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel usernameLabel = new JLabel("Username: ");
        JTextField userName = new JTextField(20);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(userName);
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel passwordLabel = new JLabel("Password: ");
        JTextField password = new JTextField(20);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(password);
        JPanel credentialsPanel = new JPanel(new FlowLayout());
        credentialsPanel.add(usernamePanel, BorderLayout.CENTER);
        credentialsPanel.add(passwordPanel);
        JButton enter = new JButton("Enter");
        JButton goBack = new JButton("Go Back");
        credentialsPanel.add(enter);
        credentialsPanel.add(goBack);
        adminPanel.add(credentialsPanel, BorderLayout.CENTER);
        adminFrame.add(adminPanel);
        
        /**
         * Action listener for the adminButton.
         * On button click, the main frame is hidden and the admin frame is displayed centered on the screen.
         */  
        // Implement action listeners to handle button clicks
        adminButton.addActionListener(new ActionListener()  {
        // Code to handle admin actions
        public void actionPerformed(ActionEvent e){
            frame.setVisible(false);
            adminFrame.setVisible(true);
            adminFrame.setLocationRelativeTo(null);
            
        }
        });
        
        /**
         * Action listener for the goBack button.
         * On button click, the admin frame is hidden and the main frame is displayed.
         */
        goBack.addActionListener(new ActionListener()  {
            // Code to handle admin actions
            public void actionPerformed(ActionEvent e){
              adminFrame.setVisible(false);
              frame.setVisible(true);
              
            }
        });

        /**
         * Create and initialize the adminView frame that displays various admin views.
         */
        JFrame adminView = new JFrame("Hotel Toad GUI");
        JTable customerDetailsJTable = new JTable();
        JTable roomAvJTable = new JTable();
        JTable bookingJTable = new JTable();
        adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminView.setSize(1280, 720);
        JPanel adminViewer = new JPanel(new CardLayout());
        /**
         * Buttons to view customer details, room availability, and booking details.
         */
        JButton checkCustomerDetails  = new JButton("Check Customer Details");
        JButton roomAvailability  = new JButton("Rooms ");
        JButton bookingDetails  = new JButton("Booking Details");
        JButton goBack2  = new JButton("Go Back");
        
        // Set up the admin viewer layout and add components
        adminViewer.setLayout(new BorderLayout());
        adminView.add(new JScrollPane(customerDetailsJTable), BorderLayout.EAST);
        adminView.add(new JScrollPane(roomAvJTable), BorderLayout.SOUTH);
        adminView.add(new JScrollPane(bookingJTable), BorderLayout.WEST);
        // Create a button panel and add buttons to it
        JPanel buttonPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        checkCustomerDetails.setBounds(10, 0, 200, 30);
        roomAvailability.setBounds(300, 0, 200, 30);
        bookingDetails.setBounds(600, 0, 200, 30);
        buttonPanel3.add(checkCustomerDetails);
        buttonPanel3.add(roomAvailability);
        buttonPanel3.add(bookingDetails);
        adminViewer.add(buttonPanel3);
        buttonPanel3.add(goBack2);
        adminView.add(adminViewer);
        
        /**
         * Action listener for the enter button.
         * On button click, validates the username and password for admin login.
         * If credentials match, the admin frame is hidden and the admin view is displayed.
         * Else, displays an error message.
         */
        enter.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
            String adminU = userName.getText();
            String adminP = password.getText();
            if (adminU.equalsIgnoreCase("admin")&& adminP.equalsIgnoreCase("Bowser")){
                adminFrame.setVisible(false);
                adminView.setLocationRelativeTo(null);
                adminView.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(adminFrame,"Sorry Worng Username or Password. Please Try again");
            }
           
        
        }
        });

        /**
         * Action listener for the goBack2 button.
         * On button click, the admin view is hidden and the admin frame is displayed.
         */
        goBack2.addActionListener(new ActionListener() {
      
            public void actionPerformed(ActionEvent e){
              adminView.setVisible(false);
              adminFrame.setVisible(true);
             
            }
        });

        /**
         * Action listener for the checkCustomerDetails button.
         * On button click, retrieves the customer details from the database and sets the data to the customerDetailsJTable.
         */
        checkCustomerDetails.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
                try {
                    DefaultTableModel model = Database.getCustomerDetailsModel();
                
                    customerDetailsJTable.setModel(model);
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while fetching customer details.");
                }
                
                adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminView.setVisible(true);
            }

        });

        /**
         * Action listener for the roomAvailability button.
         * On button click, retrieves room availability details from the database and sets the data to the roomAvJTable.
         */
        roomAvailability.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
                try {
                    DefaultTableModel model = Database.getRoomAvailabilityModel();
                     // Print model to console to verify
               

                        // Set Model to JTable
                    roomAvJTable.setModel(model);
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while fetching customer details.");
                }
                
                adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminView.setVisible(true);
            }

        });
        
        /**
         * Action listener for the bookingDetails button.
         * On button click, retrieves booking details from the database and sets the data to the bookingJTable.
         */
        bookingDetails.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
                try {
                    DefaultTableModel model = Database.bookingDetails();
                
                    bookingJTable.setModel(model);
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while fetching customer details.");
                }
                
                adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminView.setVisible(true);
            }

        });
        
        /**
         * Initialize the customerViewFrame, set its properties, and add components for capturing customer booking details.
         */
        JFrame customerViewFrame = new JFrame("Hotel Toad GUI");
        customerViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerViewFrame.setSize(1500, 1000);

        JPanel customerPanel = new JPanel();
        JButton bookNow = new JButton("Book Now");
        JButton goBack3 = new JButton("Go Back");
        customerPanel.setLayout(new FlowLayout());
        JTable roomAv2JTable = new JTable();
        JPanel buttonPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField firstName, lastName, email, numAdults, numChildren;
        JDateChooser checkInDate, checkOutDate;
        JComboBox<String> roomType;
        JTextArea message;

        customerPanel.add(new JLabel("First Name: "));
        firstName = new JTextField();
        firstName.setColumns(20);
        customerPanel.add(firstName);

        customerPanel.add(new JLabel("Last Name: "));
        lastName = new JTextField();
        lastName.setColumns(20);
        customerPanel.add(lastName);

        customerPanel.add(new JLabel("Email: "));
        email = new JTextField();
        email.setColumns(25);
        customerPanel.add(email);

        customerPanel.add(new JLabel("Number of Adults: "));
        numAdults = new JTextField();
        numAdults.setColumns(7);
        customerPanel.add(numAdults);

        customerPanel.add(new JLabel("Number of Children: "));
        numChildren = new JTextField();
        numChildren.setColumns(7);
        customerPanel.add(numChildren);

        customerPanel.add(new JLabel("Check-In Date: "));
        checkInDate = new JDateChooser();
        checkInDate.setPreferredSize(new Dimension(150,25));
        Date today = new Date();
        checkInDate.setMinSelectableDate(today);
        customerPanel.add(checkInDate);

        customerPanel.add(new JLabel("Check-Out Date: "));
        checkOutDate = new JDateChooser();
        checkOutDate.setPreferredSize(new Dimension(150,25));
        checkOutDate.setMinSelectableDate(new Date(today.getTime() + (1000 * 60 * 60 * 24)));
        customerPanel.add(checkOutDate);

        customerPanel.add(new JLabel("Room Type: "));
        roomType = new JComboBox<>(new String[]{"Single", "Double", "Triple", "Suite"});
        customerPanel.add(roomType);

        customerPanel.add(new JLabel("Message: "));
        message = new JTextArea(3, 50);
        customerPanel.add(message);
        
        customerViewFrame.add(new JScrollPane(roomAv2JTable), BorderLayout.SOUTH);
        buttonPanel4.add(bookNow);
        buttonPanel4.add(goBack3);
        customerPanel.add(buttonPanel4);
        customerViewFrame.add(customerPanel);

        /**
         * Action listener for the bookingButton.
         * On button click, retrieves room availability details from the database and displays the customer booking form.
         */
        bookingButton.addActionListener(new ActionListener()  {
        // Code to handle admin actions
        public void actionPerformed(ActionEvent e){
            try {
            DefaultTableModel model = Database.getRoomAvailabilityModel();

                // Set Model to JTable
            roomAv2JTable.setModel(model);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            customerViewFrame.add(customerPanel);
            customerViewFrame.setVisible(false);
            customerViewFrame.setLocationRelativeTo(null);
            customerViewFrame.setVisible(true);
            
        }
        });

        /**
         * Action listener for the bookNow button.
         * On button click, processes the booking request based on the provided customer details.
         */
        bookNow.addActionListener(new ActionListener()  {
        // Code to handle admin actions
        public void actionPerformed(ActionEvent e){
            // Check if all necessary fields are filled out by user
            // Validate that all required fields are filled out by user
            if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || email.getText().isEmpty()
                    || numAdults.getText().isEmpty() || numChildren.getText().isEmpty()
                    || checkInDate.getDate() == null || checkOutDate.getDate() == null
                    || roomType.getSelectedItem().toString().isEmpty()){
                // If not, show a message dialog prompting the user to fill all fields
                JOptionPane.showMessageDialog(frame, "All fields must be filled!");

                //Clear all fields
                firstName.setText("");
                lastName.setText("");
                email.setText("");
                numAdults.setText("");
                numChildren.setText("");
                checkInDate.setDate(null);
                checkOutDate.setDate(null);
                roomType.setSelectedIndex(-1);
                message.setText("");

            } else {
                String checkIn = new SimpleDateFormat("MM/dd/yyyy").format(checkInDate.getDate());
                String checkOut = new SimpleDateFormat("MM/dd/yyyy").format(checkOutDate.getDate());

                roomType1String = roomType.getSelectedItem().toString();
                checkOut1String = checkOut;
                checkIn1String = checkIn;
                children = numChildren.getText();
                adults = numAdults.getText();
                email1String = email.getText();
                firstName1String = firstName.getText();
                lastName1String = lastName.getText();
                message1String = message.getText();
                // Create Guest, Reservation, and Payment objects based on form data
                Guest G = new Guest(firstName1String, lastName1String, email1String);
                int adults1 ;
                if (adults != null) {
                    adults1 = Integer.parseInt(adults);
                } else {
                    // Handle the null case, maybe set a default value or throw an exception
                    adults1 = 0;
                }

                int children1 ;
                if (children != null) {
                    children1 = Integer.parseInt(children);
                } else {
                    // Handle the null case, maybe set a default value or throw an exception
                    children1 = 0;
                }
                Reservation R = new Reservation(adults1, children1, checkIn1String, checkOut1String, roomType1String, message1String);
                Payment P = new Payment();
                String bill;
                try {
                    bill = P.calculateBill(R);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    String message = Hotel.reserveRoom(G, roomType1String, checkIn1String, checkOut1String, email1String, bill);
                    if (message == null){
                        JOptionPane.showMessageDialog(frame, "Sorry, room not available!");
                        customerViewFrame.add(customerPanel);
                        customerViewFrame.setVisible(true);
                    }
                    else if (message != null){
                        Hotel.reserveRoom1(G, roomType1String, checkIn1String, checkOut1String, email1String);
                        JOptionPane.showMessageDialog(frame, message);
                        customerViewFrame.add(customerPanel);
                        customerViewFrame.setVisible(true);
                    }
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                //Clear all fields
                firstName.setText("");
                lastName.setText("");
                email.setText("");
                numAdults.setText("");
                numChildren.setText("");
                checkInDate.setDate(null);
                checkOutDate.setDate(null);
                roomType.setSelectedIndex(-1);
                message.setText("");

                try {
                    DefaultTableModel model = Database.getRoomAvailabilityModel();

                    // Set Model to JTable
                    roomAv2JTable.setModel(model);
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                // Configure the visibility and position of the customer view frame
                customerViewFrame.add(customerPanel);
                customerViewFrame.setVisible(false);
                customerViewFrame.setLocationRelativeTo(null);
                customerViewFrame.setVisible(true);

                }
            }
        });

        /**
         * Action listener for the goBack3 button.
         * On button click, hides the customer view frame and shows the main frame.
         */
        goBack3.addActionListener(new ActionListener()  {
            // Code to handle admin actions
            public void actionPerformed(ActionEvent e){
              customerViewFrame.setVisible(false);
              frame.setVisible(true);
            }
          });

          /**
         * Initializes and attaches an action listener to the cancelReservationButton.
         * This action listener prompts the user to input their room number and attempts to cancel their reservation.
         */
        cancelReservationButton.addActionListener(new ActionListener()  {
            // Code to handle admin actions
            public void actionPerformed(ActionEvent e){
                // Prompt user for room number
              String roomNum = JOptionPane.showInputDialog(frame,"Enter You're Room Number Please"); 

              // Validate the entered room number
              if (roomNum != null && !roomNum.trim().isEmpty()) { 
                // Check if roomNum is not empty after trimming whitespace
                try {
                    roomNumber = Integer.parseInt(roomNum);
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(frame, "Invalid Room Number. Please enter a valid number.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please Enter A Room Number");
            }
             // Attempt to cancel room reservation using the room number and display the outcome to the user
              try {
                  String cancelMessage = Hotel.cancelRoom(roomNumber);
                  JOptionPane.showMessageDialog(frame, cancelMessage);
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
          });
    }

        /**
         * Method to apply hover effects to buttons.
         * 
         * @param title The text to be displayed on the button.
         * @param c     The foreground color when the mouse hovers over the button.
         * @return JButton The styled button with hover effects.
         */
    // Buttons styling on hover
    private static JButton buttonStyling(String title, Color c) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JButton button = new JButton(title);
        button.setBackground(c);
        button.setForeground(Color.WHITE);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setOpaque(true);
                button.setForeground(c);
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(c);
                button.setForeground(Color.WHITE);
            }
        });
        return button;
    }
}



