import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    public static String firstName1String;
    public static String lastName1String ;
    public static String email1String ;
    public static String checkIn1String ;
    public static String checkOut1String ;
    public static String roomType1String ;
    public static String message1String ;
    static String adults;
    static String children;
    public static int roomNumber;
    public static void main(String[] args) {

        // Create GUI frame
        JFrame frame = new JFrame("Hotel Toad GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);

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



        // Create nested buttons panel for top buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        // Create buttons
        JButton homeButton = buttonStyling("Home", Color.GREEN);
        JButton roomsButton = buttonStyling("Rooms", Color.GREEN);
        JButton amenitiesButton = buttonStyling("Amenities", Color.GREEN);
        JButton bookingButton = buttonStyling("Book Now", Color.RED);
        JButton adminButton = buttonStyling("Admin",Color.DARK_GRAY);

        // scrollable panels
        JScrollPane homeScrollPane = new JScrollPane(homePanel);
        JScrollPane amenitiesScrollPane = new JScrollPane(amenitiesPanel);
        JScrollPane RoomsScrollPane = new JScrollPane(roomsPanel); 
        JScrollPane BookingScrollPane = new JScrollPane(bookingPanel);


        // Add buttons to button panel
        buttonPanel.add(homeButton);
        buttonPanel.add(roomsButton);
        buttonPanel.add(amenitiesButton);
        buttonPanel.add(adminButton);


        // Load the hotel image and create a JLabel for the image
        ImageIcon imageIcon = new ImageIcon("images/hotel.png");
        JLabel imageLabel = new JLabel(imageIcon);
        
        //colors
        Color myColor = new Color(18, 13, 13); 
        Color myColor1 = new Color(51, 51, 51);
        Color myColor2 = new Color(251, 241, 241); 
        //footer
        JLabel footerLabel = new JLabel();
        MatteBorder footerBorder = BorderFactory.createMatteBorder(78, 0, 2, 0, myColor1);
        footerLabel.setBorder(footerBorder);
        JLabel footerLabel2 = new JLabel();
        MatteBorder footerBorder2 = BorderFactory.createMatteBorder(210, 0, 15, 0,myColor);
        footerLabel2.setBorder(footerBorder2);
        //footer labels/styling
        JLabel t = new JLabel("<html>Copyright \u00A9 2023 Hotel Toad. <br>\r\n" + //
                "All rights reserved. All trademarks, service marks, trade names, trade dress, product names and logos appearing on the site are the property of their respective owners\r\n" + //
                        "\r\n");
        Font  tt  = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 12);
        t.setFont(tt);
        t.setForeground(Color.WHITE);
        t.setBounds(44,912,511,411);

        JLabel t1 = new JLabel("ABOUT US");
        Font  tt1  = new Font(Font.DIALOG, Font.BOLD, 18);
        t1.setFont(tt1);
        t1.setForeground(myColor2);
        t1.setBounds(124,980,511,411);

        JLabel t2 = new JLabel("<html>Embracing the timeless charm of Hotel Toad<br>amidst the modern allure of current hospitality,\r\n" + //
                "<br>Hotel Toad offers you a lasting escape from\r\n" + //
                        "<br>the instant you step into your cherished retreat.\r\n" + //
                                "\r\n" + //
                                " </html>");
        Font  ttt  = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 14);
        t2.setFont(ttt);
        t2.setForeground(Color.WHITE);
        t2.setBounds(44,1042,511,411);

        JLabel t3 = new JLabel("LOCATION");
        t3.setFont(tt1);
        t3.setForeground(myColor2);
        t3.setBounds(924,980,511,411);

        JLabel t4 = new JLabel("100 Universal City Plaza, Universal City, CA 91608");
        t4.setFont(ttt);
        t4.setForeground(Color.WHITE);
        t4.setBounds(824,1012,511,411);

        JLabel t5 = new JLabel("CONTACT US");
        t5.setFont(tt1);
        t5.setForeground(myColor2);
        t5.setBounds(1574,980,511,411);

        JLabel t6 = new JLabel("<html> Email: universalstudios@gmail.com <br><br>Phone: 818-259-3329 </html>");
        t6.setFont(ttt);
        t6.setForeground(Color.WHITE);
        t6.setBounds(1524,1042,511,411);

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
        //add nested labels to main panel
        homePanel.add(hPanel, BorderLayout.CENTER);

      //  homePanel.add(footerLabel, BorderLayout.SOUTH);

        //add logo
        ImageIcon logo = new ImageIcon("images/logo.png");
        JLabel logoLabel = new JLabel(logo);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        logoLabel.setBorder(border);

        logoAndButtonPanel.add(bookingButton, BorderLayout.EAST);
        logoAndButtonPanel.add(logoLabel, BorderLayout.WEST);
        logoAndButtonPanel.add(buttonPanel, BorderLayout.CENTER);
        homePanel.add(logoAndButtonPanel, BorderLayout.NORTH);
        buttonPanel.setBackground(Color.DARK_GRAY);
        
        logoAndButtonPanel.setBackground(Color.GRAY);
        //padding
        EmptyBorder b = new EmptyBorder(22, 120, 0, 0);    
        buttonPanel.setBorder(b);
        EmptyBorder a = new EmptyBorder(0, 33, 0, 74);
        bookingButton.setBorder(a);
    
        // Rooms panel start
        
        // Load images
        ImageIcon P1 = new ImageIcon("images/single.png");
        ImageIcon P2 = new ImageIcon("images/double.png");
        ImageIcon P3 = new ImageIcon("images/triple.png");
        ImageIcon P4 = new ImageIcon("images/suite.png");

        // label for title/ title styling
        JLabel P1LabelT = new JLabel("Single Queen");
        Font  f3  = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 32);
        P1LabelT.setFont(f3);
        P1LabelT.setForeground(Color.GRAY);
        P1LabelT.setBounds(1244,312,511,111);

        // label for text/ styling
        JLabel P1LabelTT = new JLabel("<html> Step into the delightful world of Mario-themed rooms, and\r\n" + //
                "experience<br> the comfort of air-conditioned spaces seamlessly\r\n" + //
                "ensuring a truly enjoyable adventure</html>");
        Font  f3T  = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 22);
        P1LabelTT.setFont(f3T);
        P1LabelTT.setForeground(Color.BLACK);
        P1LabelTT.setBounds(1044,162,711,711);

        JLabel P2LabelT = new JLabel("Classic Double");
        P2LabelT.setFont(f3);
        P2LabelT.setForeground(Color.GRAY);
        P2LabelT.setBounds(444,1212,511,111);

        JLabel P3LabelTT = new JLabel("<html> Our Classic Double room is meticulously crafted as a haven of\r\n" + 
                "tranquility and rejuvenation. Experience the enchanting blend\r\n" + //
                        "\r\n" + //
                "of Mario's charm and<br> modern amenities in this retreat.\r\n" + //
                      "</html>");
        P3LabelTT.setFont(f3T);
        P3LabelTT.setForeground(Color.BLACK);
        P3LabelTT.setBounds(244,1072,711,711);

        JLabel P3LabelT = new JLabel("Classic Triple");
        P3LabelT.setFont(f3);
        P3LabelT.setForeground(Color.GRAY);
        P3LabelT.setBounds(1114,242,511,111);


        JLabel P4LabelTT = new JLabel("<html> Step into the enchanting realm of our Mario-themed Triple Beds Room,\r\n" + //
                "\r\n" + //
                "where the magic of Mario awaits you and your companions. Embrace\r\n" + //
                        "\r\n" + //
                "the ultimate comfort and convenience.\r\n" + //
                 "</html>");
        P4LabelTT.setFont(f3T);
        P4LabelTT.setForeground(Color.BLACK);
        P4LabelTT.setBounds(944,122,711,711);

        JLabel P4LabelT = new JLabel("Classic Suite");
        P4LabelT.setFont(f3);
        P4LabelT.setForeground(Color.GRAY);
        P4LabelT.setBounds(544,1122,511,111);

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

        //img labels
        JLabel P1Label = new JLabel(P1);
        JLabel P2Label = new JLabel(P2);
        JLabel P3Label = new JLabel(P3);
        JLabel P4Label = new JLabel(P4);


         
         // Adds padding through an empty border
        EmptyBorder paddingBorder = new EmptyBorder(122, 140, 0, 1244);   
        EmptyBorder paddingBorder1 = new EmptyBorder(244, 740, 0, 0);
        EmptyBorder paddingBorder4 = new EmptyBorder(244, 740, 110, 0);   

        P1Label.setBorder(paddingBorder);
        P3Label.setBorder(paddingBorder);     

        P2Label.setBorder(paddingBorder1);    
        P4Label.setBorder(paddingBorder4);         
     
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


        // add nested panels to main panel
        roomsPanel.add(P1Panel, BorderLayout.CENTER);
        roomsPanel.add(P3Panel, BorderLayout.SOUTH);

         // Rooms panel end


    // amenities tab start

        // Load images
        ImageIcon P1a = new ImageIcon("images/pool.png");
        ImageIcon P2a = new ImageIcon("images/breakfast.jpg");
        ImageIcon P3a = new ImageIcon("images/fitnessRoom.png");
        ImageIcon P4a = new ImageIcon("images/golf.png");

        JLabel P1aLabelT = new JLabel("<html>Outdoor Pool<br> & Deck</html>");
        P1aLabelT.setFont(f3);
        P1aLabelT.setForeground(Color.GRAY);
        P1aLabelT.setBounds(1124,312,511,111);

        JLabel P1aLabelTT = new JLabel("<html> Take a dip in our heated outdoor pool and enjoy\r\n" + //
                "your time poolside with a drink. Curl up with your favorite\r\n" + //
                        "\r\n" + //
                "book, cool off after a busy day, and soak up the sun.\r\n" + //
                        "</html>");
        P1aLabelTT.setFont(f3T);
        P1aLabelTT.setForeground(Color.BLACK);
        P1aLabelTT.setBounds(944,162,711,711);

        JLabel P2aLabelT = new JLabel("<html>Continental<br>Breakfast</html>");
        P2aLabelT.setFont(f3);
        P2aLabelT.setForeground(Color.GRAY);
        P2aLabelT.setBounds(444,1062,511,111);

        JLabel P3aLabelTT = new JLabel("<html> Enjoy our complimentary continental breakfast, featuring\r\n" + //
                "\r\n" + 
                "freshly baked pastries, a variety of bread, healthy fruits\r\n" + //
                "and yogurt. A perfect way to kickstart your morning.\r\n" + //
                      "</html>");
        P3aLabelTT.setFont(f3T);
        P3aLabelTT.setForeground(Color.BLACK);
        P3aLabelTT.setBounds(244,922,711,711);

        JLabel P3aLabelT = new JLabel("Fitness Center");
        P3aLabelT.setFont(f3);
        P3aLabelT.setForeground(Color.GRAY);
        P3aLabelT.setBounds(1114,242,511,111);


        JLabel P4aLabelTT = new JLabel("<html> Jumpstart your day at our modern fitness center. Enjoy a wide range\r\n" + //
                "\r\n" + //
                "of exercise options suitable for all fitness levels. Discover\r\n" + //
                "moments of leisure in our versatile yoga.\r\n" + //
                 "</html>");
        P4aLabelTT.setFont(f3T);
        P4aLabelTT.setForeground(Color.BLACK);
        P4aLabelTT.setBounds(944,82,711,711);

        JLabel P4aLabelT = new JLabel("Golf Course");
        P4aLabelT.setFont(f3);
        P4aLabelT.setForeground(Color.GRAY);
        P4aLabelT.setBounds(444,1122,511,111);

        JLabel P5aLabelTT = new JLabel("<html> Embark on an unforgettable golfing journey at our stunning course\r\n" + //
                "\r\n" + //
                "Delight in diverse challenges catering to golfers of all levels. from\r\n" + //
                "well-groomed fairways to immaculate greens, it's a golfer's paradise.\r\n" + //
                 "</html>");
        P5aLabelTT.setFont(f3T);
        P5aLabelTT.setForeground(Color.BLACK);
        P5aLabelTT.setBounds(244,972,711,711);

        // img labels
        JLabel P1aLabel = new JLabel(P1a);
        JLabel P2aLabel = new JLabel(P2a);
        JLabel P3aLabel = new JLabel(P3a);
        JLabel P4aLabel = new JLabel(P4a);


         
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

        // add nested panels to main panel
        amenitiesPanel.add(P1aPanel, BorderLayout.CENTER);
        amenitiesPanel.add(P3aPanel, BorderLayout.SOUTH);

    // amenities tab end

        // Add panels to the main panel with CardLayout
        mainPanel.add(homeScrollPane, "Home");
        mainPanel.add(BookingScrollPane, "Booking");
        mainPanel.add(RoomsScrollPane, "Rooms"); 
        mainPanel.add(amenitiesScrollPane, "Amenities");

        // Add main panel to the frame
        frame.add(mainPanel);

        // action listeners
        bookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                // add buttonPanel to booking panel
        EmptyBorder a = new EmptyBorder(0, 33, 0, 56);
        bookingButton.setBorder(a);
        bookingPanel.add(logoAndButtonPanel, BorderLayout.NORTH);

                cardLayout.show(mainPanel, "Booking");
            }
        });
        amenitiesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                // add buttonPanel to booking panel
        EmptyBorder a = new EmptyBorder(0, 33, 0, 226);
        bookingButton.setBorder(a);
        amenitiesPanel.add(logoAndButtonPanel, BorderLayout.NORTH);

                cardLayout.show(mainPanel, "Amenities");

            }
        });        
        roomsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                // add buttonPanel to booking panel
        EmptyBorder a = new EmptyBorder(0, 33, 0, 226);
        bookingButton.setBorder(a);
        roomsPanel.add(logoAndButtonPanel, BorderLayout.NORTH);

                 cardLayout.show(mainPanel, "Rooms");

            }
        });          
              
        // action listener for home panel
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        EmptyBorder a = new EmptyBorder(0, 33, 0, 74);
        bookingButton.setBorder(a);
        homePanel.add(logoAndButtonPanel, BorderLayout.NORTH);

                cardLayout.show(mainPanel, "Home");
            }
        });

        // Make frame visible
        frame.setVisible(true);
    
    /* 
        JFrame adminFrame = new JFrame("Hotel Toad GUI");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(1280, 720);

        //Create a new panel
    
        JPanel adminPanel = new JPanel();
        JButton enter = new JButton("Enter");
        JButton goBack = new JButton("Go Back");
        adminPanel.setLayout(new BorderLayout());
        
        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField userName ,password;
        userName=new JTextField("UserName");  
        userName.setBounds(50,100, 200,30);  
        password=new JTextField("Password");  
        password.setBounds(50,150, 200,30); 
        buttonPanel2.add(enter);
        buttonPanel2.add(goBack);
        adminPanel.add(buttonPanel2);
        
        adminFrame.add(userName); adminFrame.add(password);
        adminFrame.add(adminPanel);
        
    
            
        // Implement action listeners to handle button clicks
        adminButton.addActionListener(new ActionListener()  {
        // Code to handle admin actions
        public void actionPerformed(ActionEvent e){
            frame.setVisible(false);
            adminFrame.setVisible(true);
            
        }
        });
        goBack.addActionListener(new ActionListener()  {
            // Code to handle admin actions
            public void actionPerformed(ActionEvent e){
              adminFrame.setVisible(false);
              frame.setVisible(true);
              
            }
        });

        JFrame adminView = new JFrame("Hotel Toad GUI");
        JTable customerDetailsJTable = new JTable();
        JTable roomAvJTable = new JTable();
        JTable bookingJTable = new JTable();
        adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminView.setSize(1280, 720);
        JPanel adminViewer = new JPanel(new CardLayout());
        JButton checkCustomerDetails  = new JButton("Check Customer Details");
        JButton roomAvailability  = new JButton("Rooms ");
        JButton bookingDetails  = new JButton("Booking Details");
        JButton goBack2  = new JButton("Go Back");
        adminViewer.setLayout(new BorderLayout());
        adminView.add(new JScrollPane(customerDetailsJTable), BorderLayout.EAST);
        adminView.add(new JScrollPane(roomAvJTable), BorderLayout.SOUTH);
        adminView.add(new JScrollPane(bookingJTable), BorderLayout.WEST);
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
        
        
        enter.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
            adminFrame.setVisible(false);
            adminView.setVisible(true);
        
        }

        });
        goBack2.addActionListener(new ActionListener() {
      
            public void actionPerformed(ActionEvent e){
              adminView.setVisible(false);
              adminFrame.setVisible(true);
             
            }
      
        });
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
        
        JFrame customerViewFrame = new JFrame("Hotel Toad GUI");
        customerViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerViewFrame.setSize(1500, 1000);

        JPanel customerPanel = new JPanel();
        JButton bookNow = new JButton("Book Now");
        JButton goBack3 = new JButton("Go Back");
        customerPanel.setLayout(new FlowLayout());
        JTable roomAv2JTable = new JTable();
        JPanel buttonPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField firstName ,lastName, email,numAuldts, numChildren, checkIn ,checkOut, roomType;
        firstName=new JTextField("First Name        ");  
        JLabel noRoom = new JLabel("Sorry No Rooms Available");
        JLabel conformationJLabel = new JLabel(" Succesfull Room Reserved");
        email=new JTextField("Email                 ");  
        
        numAuldts=new JTextField("Number of Adults  ");  
        
        numChildren=new JTextField("Number Children ");  
        
        checkIn=new JTextField("Check In     ");  
        
        checkOut=new JTextField("Check Out   ");  
        
        roomType=new JTextField("Room Type     ");  
        
        customerViewFrame.add(new JScrollPane(roomAv2JTable), BorderLayout.SOUTH);
        buttonPanel4.add(bookNow);
        buttonPanel4.add(goBack3);
        customerPanel.add(buttonPanel4);
        customerPanel.add(firstName);
        customerPanel.add(email);
        customerPanel.add(numAuldts);
        customerPanel.add(numChildren);
        customerPanel.add(checkIn);
        customerPanel.add(checkOut);
        customerPanel.add(roomType);
        customerViewFrame.add(customerPanel);

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
            customerViewFrame.setVisible(true);
            
        }
        });

        bookNow.addActionListener(new ActionListener()  {
        // Code to handle admin actions
        public void actionPerformed(ActionEvent e){
            roomType1String= roomType.getText();
            checkOut1String = checkOut.getText();
            checkIn1String = checkIn.getText();
            children = numChildren.getText();
            adults = numAuldts.getText();
            email1String = email.getText();
            firstName1String = firstName.getText();
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
            try {
                if (Hotel.reserveRoom(G, roomType1String, checkIn1String, checkOut1String, email1String)== null){
                    customerPanel.add(noRoom);
                    customerViewFrame.add(customerPanel);
                    customerViewFrame.setVisible(true);
                }
                else if ( Hotel.reserveRoom(G, roomType1String, checkIn1String, checkOut1String, email1String)!= null){
                    Hotel.reserveRoom1(G, roomType1String, checkIn1String, checkOut1String, email1String);
                    customerPanel.add(conformationJLabel);
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
            
        }
        });
         goBack3.addActionListener(new ActionListener()  {
            // Code to handle admin actions
            public void actionPerformed(ActionEvent e){
              customerViewFrame.setVisible(false);
              frame.setVisible(true);
              
            }
          });
    }
*/
    // buttons styling on hover
    private static JButton buttonStyling(String title, Color c) {
        JButton button = new JButton(title);
        button.setBackground(c);
        button.setForeground(Color.WHITE);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.WHITE);
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



