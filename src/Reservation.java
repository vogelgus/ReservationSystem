import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {

    private String name;
    private int nPeople;
    private long timeSet; //can also make this a date // make them a long in the future
    private long timeFor; // the time the reservation is set for
    private boolean waitlisted; //optional -- but shows whether there is availability for that time
    private String timeSetDate; // string version of date set
    private String timeForDate; //string version of reservation time
    private Date newDate;
    private Date newDateSet;

    public Reservation(){
        nPeople = (int)(Math.random()*10+1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd k:mm"); // setting the date format
         timeSet = new Date().getTime() - ((int)(Math.random()*1000000000)); //creates a random time that they set the date
         timeFor = new Date().getTime() + ((int)(Math.random()* 1000000000)); // creates a random time for when the date is for
//        timeStuff();
    }

    public Reservation(String pNumPeople, String pNewDate, String pNewDateSet){
        nPeople = Integer.valueOf(pNumPeople);

        try {
            DateFormat stringToDate = new SimpleDateFormat("M-dd-yyyy k:mm");
            Date newDate = stringToDate.parse(pNewDate);
            Date newDateSet = stringToDate.parse(pNewDateSet);
           timeSet = newDate.getTime();
            timeFor = newDateSet.getTime();
        } catch (ParseException pe) {
            pe.printStackTrace();
        }


        
    }



    public void timeStuff(){
        DateFormat dateFormat = new SimpleDateFormat("yyy-M-dd k:mm"); // setting the date format


        long now = new Date().getTime();
        System.out.println(now);
        String timeString = dateFormat.format(now);
        System.out.println(timeString);

        long future = new Date().getTime() + 100000000; // make that a random number for sorting
        String futureString = dateFormat.format(future);
        System.out.println(futureString);
        System.out.println(future > now);

        System.out.println("**");



    }

    public void printInfo(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd k:mm"); // setting the date format
        timeSetDate = dateFormat.format(timeSet);
        timeForDate = dateFormat.format(timeFor);

        try{
            Date date1 = dateFormat.parse(timeSetDate);
//            System.out.println(timeSetDate + "\t");
            if (nPeople==1){
                System.out.println("There is a reservation for " +nPeople + " people at " + timeForDate);
            }else{
                System.out.println("There is a reservation for " +nPeople + " people at " + timeForDate + " aka " + date1.getTime());
            }

        }catch (Exception e){

        }
        //print the details for a single reservation
//        System.out.println("There is a reservation for " +nPeople + " people at " + timeForDate + " which was set at " + timeSetDate);

    } // might not need anymore after the GUI exists

    public String getInfo() {
        DateFormat dateFormat = new SimpleDateFormat("M-dd-yyyy k:mm"); // setting the date format
        timeSetDate = dateFormat.format(timeSet);
        timeForDate = dateFormat.format(timeFor);



        //print the details for a single reservation
        String s = "There is a reservation for " +nPeople + " at " + timeForDate + " which was set at " + timeSetDate;
        return s;


    }


    public int getNPeople(){
        return nPeople;
    }
    public long getTimeSet(){
        return timeSet;
    }
    public long getTimeFor(){
        return timeFor;
    }


}
