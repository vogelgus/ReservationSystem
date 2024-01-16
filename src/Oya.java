import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

public class Oya implements ActionListener{
    public ArrayList<Reservation> reservations = new ArrayList<>();
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
    private JTextArea reservationsList;
    private JTextField addTime;
    private JTextField addNumPeople;
    private JTextField addTimeSet;
    private JPanel addPanel;






    public Oya(){
        for(int x=0; x<=4; x++) {
            addReservation();

        }
        displayReservations();
//        sortByTimeFor();
//        displayReservations();


        mainFrame = new JFrame();

        top = new JPanel();
        top.setPreferredSize(new Dimension(800,100));
        top.setForeground(Color.blue);

        sortHeader = new JLabel("Ways to sort:");
        openingLabel = new JLabel("Reservations:");
        logo = new JLabel();
        welcome = new JLabel("Welcome to the O Ya Reservation System🍣🍱😋!");

        reservationsList = new JTextArea();
        for(int x=0; x<reservations.size(); x++) {
            reservationsList.setText(reservationsList.getText() + reservations.get(x).getInfo() + "\n");
        }

        reservationsList.setEditable(false);



        peopleSortButton = new JButton("Sort by Number of People");
        peopleSortButton.addActionListener(this);
        timeForSortButton = new JButton("Sort by the Time of Reservation");
        timeForSortButton.addActionListener(this);
        timeSetSortButton = new JButton("Sort by the Time the Reservation Was Set");
        timeSetSortButton.addActionListener(this);
        addReservation = new JButton("Add a Reservation");
        addReservation.addActionListener(this);
        addTime = new JTextField("When is this for?  M-dd-yyyy k:mm");
        addNumPeople = new JTextField("Write in the number of people");
        addTimeSet = new JTextField("When did you set this? M-dd-yyyy k:mm");

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
        addPanel = new JPanel();

        panel2.setLayout(new GridLayout(1, 3));
        panel2.add(peopleSortButton);
        panel2.add(timeForSortButton);
        panel2.add(timeSetSortButton);

        reservationsPanel.setLayout(new GridLayout(1, 1));
        reservationsPanel.add(reservationsList);


        panel3.setLayout(new GridLayout(4,1));
        panel3.add(sortHeader);
        panel3.add(panel2);
        panel3.add(openingLabel);
        panel3.add(reservationsPanel);

        addPanel.setLayout(new GridLayout(4,1));
        addPanel.add(addTime);
        addPanel.add(addNumPeople);
        addPanel.add(addTimeSet);
        addPanel.add(addReservation);

        top.setSize(600,100);
        top.setLayout(new BorderLayout());
        top.add(logo, BorderLayout.WEST);
        top.add(addPanel, BorderLayout.EAST);
        top.add(welcome, BorderLayout.CENTER);

        panel.setLayout(new BorderLayout()); // sets up layout for the button and panel
        panel.add(top, BorderLayout.NORTH);
        panel.add(panel3, BorderLayout.CENTER);



        mainFrame.add(panel);
        mainFrame.setSize(800, 600);



        mainFrame.setVisible(true);

    }













    public void displayReservations(){
        for (int y = 0; y<=4; y++){
            reservations.get(y).printInfo();
        }
        System.out.println();

//       for (Reservation r : reservations){  // for each loop that will sort through the objects, not the index and then getting the object
//           r.printInfo();
//       }

    } // might not need anymore after the GUI exists






    public void addReservation(){
        reservations.add(new Reservation());
    }

//    public void makeReservation(int np, String tf, String tm){
//        reservations.add(new Reservation(np,tf,tm));
//    }



    public void sortByNPeople() {
        //insertion sort
        for (int i = 1; i < reservations.size(); i++) {
            // cycle through each index
            int j = i;
            while (j > 0 && reservations.get(j).getNPeople() < reservations.get(j - 1).getNPeople()) {
                Reservation temp = reservations.get(j - 1);
                reservations.set((j - 1), reservations.get(j));
                reservations.set(j, temp);
                j--;
            }
        }
    }







    public void sortByTimeMade(){
        //selection sort
        for (int x = 0; x < (reservations.size()-1); x++){
            int currentMin = x;
            for (int y = x+1; y < (reservations.size()); y++){
                if (reservations.get(y).getTimeSet() < reservations.get(currentMin).getTimeSet()){
                    currentMin = y;
                }
            }
            Reservation min = reservations.get(currentMin);
            reservations.set(currentMin, reservations.get(x));
            reservations.set(x, min);

        }
    }

//


    public void sortByTimeFor(){
        //bubble sort
        for (int y = 1; y < reservations.size(); y++){

            for (int x=1; x < reservations.size()-(y-1); x++){
                if (reservations.get(x-1).getTimeFor() > reservations.get(x).getTimeFor()){
                    Reservation temp = reservations.get(x);
                    reservations.set(x, reservations.get(x-1));
                    reservations.set(x-1, temp);
                }
            }
        }

    }



    public void actionPerformed(ActionEvent e) {
        Object buttonClicked = e.getSource();

        if (buttonClicked == peopleSortButton) {
            reservationsList.setText("");
            sortByNPeople();
            for(int x=0; x<reservations.size(); x++) {
                reservationsList.setText(reservationsList.getText() + reservations.get(x).getInfo() + "\n");
            }




        }

        if (buttonClicked == timeForSortButton) {
            reservationsList.setText("");
            sortByTimeFor();
            for(int x=0; x<reservations.size(); x++) {
                reservationsList.setText(reservationsList.getText() + reservations.get(x).getInfo() + "\n");
            }

        }

        if (buttonClicked == timeSetSortButton){
            reservationsList.setText("");
            sortByTimeMade();
            for(int x=0; x<reservations.size(); x++) {
                reservationsList.setText(reservationsList.getText() + reservations.get(x).getInfo() + "\n");
            }
        }

        if (buttonClicked == addReservation){
            String numPeople = addNumPeople.getText();
            System.out.println("new reservation for " + Integer.parseInt(numPeople));
            String newDate = addTime.getText();
            System.out.println("The new reservation is at " + newDate);
            String newDateSet = addTimeSet.getText();
            System.out.println("The new reservation is at " + newDateSet);
            reservations.add(new Reservation(numPeople, newDate, newDateSet));
            reservationsList.setText("");

            for(int x=0; x<reservations.size(); x++) {
                reservationsList.setText(reservationsList.getText() + reservations.get(x).getInfo() + "\n");
            }



        }

    }


    public static void main(String[] args) {
        Oya oya = new Oya();
    }



}