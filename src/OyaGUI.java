import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class OyaGUI<getCodeBase> implements ActionListener {
    Oya myOya = new Oya();
    Reservation myReservation = new Reservation();
    private JFrame mainFrame;
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel reservationsPanel;
    private JLabel openingLabel;
    private JLabel welcome;
    private JPanel top;
    private JLabel sortHeader;
    private JButton peopleSortButton;
    private JButton timeSetSortButton;
    private JButton timeForSortButton;
    private JButton addReservation;
    private JLabel logo;



    public static void main(String[] args) {
        OyaGUI oyaGUI = new OyaGUI();
    }

    public OyaGUI(){
        mainFrame = new JFrame();

        top = new JPanel();
        top.setPreferredSize(new Dimension(800,100));
        top.setForeground(Color.blue);

        sortHeader = new JLabel("Ways to sort:");
        openingLabel = new JLabel("Reservations:");
        logo = new JLabel();
        welcome = new JLabel("Welcome to the Oya Reservation System!🍣🍱");


        peopleSortButton = new JButton("Sort by Number of People");
        timeForSortButton = new JButton("Sort by the Time of Reservation");
        timeSetSortButton = new JButton("Sort by the Time the Reservation Was Set");
        addReservation = new JButton("Add a Reservation");

        try {
            BufferedImage myPicture = ImageIO.read(new File("OyaLogo.png"));

            logo.setIcon(new ImageIcon(myPicture));

        } catch (Exception e) {
            e.printStackTrace();
        }

        mainFrame.pack();
        mainFrame.setMinimumSize(mainFrame.getPreferredSize());



        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        reservationsPanel = new JPanel();

        panel2.setLayout(new GridLayout(1, 3));
        panel2.add(peopleSortButton);
        panel2.add(timeForSortButton);
        panel2.add(timeSetSortButton);

        reservationsPanel.setLayout(new GridLayout(5, 1));

        panel3.setLayout(new GridLayout(4,1));
        panel3.add(sortHeader);
        panel3.add(panel2);
        panel3.add(openingLabel);
        panel3.add(reservationsPanel);


        top.setSize(600,100);
        top.setLayout(new BorderLayout());
        top.add(logo, BorderLayout.WEST);
        top.add(addReservation, BorderLayout.EAST);
        top.add(welcome, BorderLayout.CENTER);

        panel.setLayout(new BorderLayout()); // sets up layout for the button and panel
        panel.add(top, BorderLayout.NORTH);
        panel.add(panel3, BorderLayout.CENTER);



        mainFrame.add(panel);
        mainFrame.setSize(800, 600);



        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }


}
