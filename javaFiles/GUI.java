import javax.swing.*;
import javax.swing.border.*;
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

        // Create buttons panel for top buttons
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
        // Add imageLabel to the center of the home panel
        homePanel.add(imageLabel, BorderLayout.CENTER);

        JLabel footerLabel = new JLabel();
        MatteBorder footerBorder = BorderFactory.createMatteBorder(150, 0, 5, 0, Color.darkGray);
        footerLabel.setBorder(footerBorder);

        homePanel.add(footerLabel, BorderLayout.SOUTH);


        ImageIcon logo = new ImageIcon("images/logo.png");
        JLabel logoLabel = new JLabel(logo);
        Border border = BorderFactory.createLineBorder(Color.red, 3);
        logoLabel.setBorder(border);


        logoAndButtonPanel.add(bookingButton, BorderLayout.EAST);
        logoAndButtonPanel.add(logoLabel, BorderLayout.WEST);
        logoAndButtonPanel.add(buttonPanel, BorderLayout.CENTER);
        homePanel.add(logoAndButtonPanel, BorderLayout.NORTH);
        buttonPanel.setBackground(Color.gray);
        
        logoAndButtonPanel.setBackground(Color.gray);

        EmptyBorder b = new EmptyBorder(22, 120, 0, 0);    
        buttonPanel.setBorder(b);
        
        EmptyBorder a = new EmptyBorder(0, 33, 0, 74);
        bookingButton.setBorder(a);
    
        
        // Rooms panel start
        
        // Load P1 image 
        ImageIcon P1 = new ImageIcon("images/single1.png");
        JLabel P1Label = new JLabel(P1);
                 
         // Add padding to the P1Label
        EmptyBorder paddingBorder = new EmptyBorder(122, 140, 0, 1244);           
        P1Label.setBorder(paddingBorder);         
        roomsPanel.add(P1Label, BorderLayout.NORTH);
                 

         // Rooms panel end

        // Add panels to the main panel with CardLayout
        mainPanel.add(homeScrollPane, "Home");
        mainPanel.add(BookingScrollPane, "Booking");
        mainPanel.add(RoomsScrollPane, "Rooms");
        mainPanel.add(amenitiesScrollPane, "Amenities");

        // Add main panel to the frame
        frame.add(mainPanel);

        // Add action listener to the bookingButton
        bookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                // add buttonPanel to booking panel
        bookingPanel.add(logoAndButtonPanel, BorderLayout.NORTH);

                cardLayout.show(mainPanel, "Booking");
            }
        });
        amenitiesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                // add buttonPanel to booking panel
        amenitiesPanel.add(logoAndButtonPanel, BorderLayout.NORTH);

                cardLayout.show(mainPanel, "Amenities");

            }
        });        
        roomsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                // add buttonPanel to booking panel
        roomsPanel.add(logoAndButtonPanel, BorderLayout.NORTH);

         
                 cardLayout.show(mainPanel, "Rooms");

            }
        });          
              
        // action listener for home panel
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        homePanel.add(logoAndButtonPanel, BorderLayout.NORTH);

                cardLayout.show(mainPanel, "Home");
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }
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
        adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminView.setSize(1280, 720);
        JPanel adminViewer = new JPanel();
        JButton checkCustomerDetails  = new JButton("Check Customer Details");
        JButton roomAvailability  = new JButton("Rooms ");
        JButton bookingDetails  = new JButton("Booking Details");
        JButton goBack2  = new JButton("Go Back");
        adminViewer.setLayout(new BorderLayout());

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
        JTextArea textArea = new JTextArea();
        
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
                    Database.checkCustomerDetails(textArea);
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while fetching customer details.");
                }
                adminView.add(new JScrollPane(textArea), java.awt.BorderLayout.CENTER);
                adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminView.setVisible(true);
            }

        });
        roomAvailability.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
                try {
                    Database.roomAvailability(textArea);
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while fetching customer details.");
                }
                adminView.add(new JScrollPane(textArea), java.awt.BorderLayout.CENTER);
                adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminView.setVisible(true);
            }

        });
        bookingDetails.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
                try {
                    Database.bookingDetails(textArea);
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while fetching customer details.");
                }
                adminView.add(new JScrollPane(textArea), java.awt.BorderLayout.CENTER);
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



