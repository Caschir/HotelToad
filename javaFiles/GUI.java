import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
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


        // Add buttons to button panel
        buttonPanel.add(homeButton);
        buttonPanel.add(roomsButton);
        buttonPanel.add(amenitiesButton);
        buttonPanel.add(bookingButton);



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



