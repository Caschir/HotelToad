import javax.swing.*;
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
        frame.setSize(1280, 720);

        // Create panels
        JPanel mainPanel = new JPanel(new CardLayout());
        JPanel homePanel = new JPanel(new BorderLayout());
        JPanel bookingPanel = new JPanel(new BorderLayout());

        // Create buttons panel for top buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));


        // Create buttons
        JButton homeButton = buttonStyling("Home", Color.GREEN);
        JButton roomsButton = buttonStyling("Rooms", Color.GREEN);
        JButton amenitiesButton = buttonStyling("Amenities", Color.GREEN);
        JButton bookingButton = buttonStyling("Book Now", Color.RED);
        JButton adminButton = buttonStyling("Admin",Color.DARK_GRAY);

        // Add buttons to button panel
        buttonPanel.add(homeButton);
        buttonPanel.add(roomsButton);
        buttonPanel.add(amenitiesButton);
        buttonPanel.add(bookingButton);
        buttonPanel.add(adminButton);



        // Add button panel to home panel
        homePanel.add(buttonPanel, BorderLayout.NORTH);


        // Load the hotel image and create a JLabel for the image
        ImageIcon imageIcon = new ImageIcon("images/hotel.png");
        JLabel imageLabel = new JLabel(imageIcon);

        // Add imageLabel to the center of the home panel
        homePanel.add(imageLabel, BorderLayout.CENTER);

        // Add panels to the main panel with CardLayout
        mainPanel.add(homePanel, "Home");
        mainPanel.add(bookingPanel, "Booking");

        // Add main panel to the frame
        frame.add(mainPanel);

        // Add action listener to the bookingButton
        bookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                // add buttonPanel to booking panel
                 bookingPanel.add(buttonPanel, BorderLayout.NORTH);

                cardLayout.show(mainPanel, "Booking");
            }
        });
        // action listener for home panel
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                 homePanel.add(buttonPanel, BorderLayout.NORTH);

                cardLayout.show(mainPanel, "Home");
            }
        });
        // Make the frame visible
        frame.setVisible(true);

        JFrame adminFrame = new JFrame("Hotel Toad GUI");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(1280, 720);

        //Create a new panel
    
        JPanel adminPanel = new JPanel();
        JButton enter = new JButton("Enter");
        adminPanel.setLayout(new BorderLayout());
        
        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField userName ,password;
        userName=new JTextField("UserName");  
        userName.setBounds(50,100, 200,30);  
        password=new JTextField("Password");  
        password.setBounds(50,150, 200,30); 
        buttonPanel2.add(enter);
    
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

        JFrame adminView = new JFrame("Hotel Toad GUI");
        adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminView.setSize(1280, 720);
        JPanel adminViewer = new JPanel();
        JButton checkCustomerDetails  = new JButton("Check Customer Details");
        JButton roomAvailability  = new JButton("Rooms ");
        JButton bookingDetails  = new JButton("Booking Details");
        adminViewer.setLayout(new BorderLayout());

        JPanel buttonPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        checkCustomerDetails.setBounds(10, 0, 200, 30);
        roomAvailability.setBounds(300, 0, 200, 30);
        bookingDetails.setBounds(600, 0, 200, 30);
        buttonPanel3.add(checkCustomerDetails);
        buttonPanel3.add(roomAvailability);
        buttonPanel3.add(bookingDetails);
        adminViewer.add(buttonPanel3);
        adminView.add(adminViewer);
        JTextArea textArea = new JTextArea();
        
        enter.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
            adminFrame.setVisible(false);
            adminView.setVisible(true);
        
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
        firstName.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateResult();
                }

                private void updateResult() {
                    firstName1String = firstName.getText();
                    //resultLabel.setText("You entered: " + inputText);
                }
            });
        email.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateResult();
                }

                private void updateResult() {
                    email1String = email.getText();
                    //resultLabel.setText("You entered: " + inputText);
                }
            });
        numAuldts.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateResult();
                }

                private void updateResult() {
                adults = numAuldts.getText();
                    //resultLabel.setText("You entered: " + inputText);
                }
            });
        numChildren.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateResult();
                }

                private void updateResult() {
                children = numChildren.getText();
                    //resultLabel.setText("You entered: " + inputText);
                }
            });
        checkIn.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateResult();
                }

                private void updateResult() {
                checkIn1String = checkIn.getText();
                    //resultLabel.setText("You entered: " + inputText);
                }
            });
        checkOut.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateResult();
                }

                private void updateResult() {
                    checkOut1String = checkOut.getText();
                    //resultLabel.setText("You entered: " + inputText);
                }
            });
        roomType.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateResult();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateResult();
                }

                private void updateResult() {
                roomType1String= roomType.getText();
                    //resultLabel.setText("You entered: " + inputText);
                }
            });
        
        Guest G = new Guest(firstName1String, lastName1String, email1String);
        bookNow.addActionListener(new ActionListener()  {
        // Code to handle admin actions
        public void actionPerformed(ActionEvent e){
            try {
                if (Hotel.reserveRoom(G, roomType1String, checkIn1String, checkOut1String, email1String)!= null){
                    customerPanel.add(noRoom);
                    customerViewFrame.add(customerPanel);
                    customerViewFrame.setVisible(true);
                }
                else if ( Hotel.reserveRoom(G, roomType1String, checkIn1String, checkOut1String, email1String)== null){
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
    }

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



