package RailwayReservationSystem;

import java.util.*;

public class TicketManager {

    static int ID =1;
    static int HighBerth =1;
    static int MiddleBerth = 1;
    static int LowBerth = 1;
    static  int GeneralSeat = 1;
    static int WaitingList =1;

    Scanner scanner = new Scanner(System.in);
    HashMap<Integer,Passenger>PassengerMap = new HashMap<>();
    Queue<Queue<Passenger>>TicketQueue = new LinkedList<>();

    Queue<Passenger>HighBerthQueue = new LinkedList<>();
    Queue<Passenger>MiddleBerthQueue = new LinkedList<>();
    Queue<Passenger>LowBerthQueue = new LinkedList<>();

    public void BookTicket(){
        Passenger passenger = new Passenger();
        System.out.println("Enter The name of the Passenger : ");
        passenger.setName(scanner.nextLine());
        System.out.println("Enter the Age : ");
        passenger.setAge(scanner.nextInt());
        System.out.println("Enter the preference (HighBerth - H , MiddleBerth - B , LowBerth - L) Default Preference would be HighBerth : ");
        String preference = scanner.next();
        SetBerthPreference(passenger,preference);
        PassengerMap.put(ID,passenger);
        ID++;
    }
    public void PrintTicket(){
        if(PassengerMap.isEmpty())
            System.out.println("No Tickets Available");

        for(int i : PassengerMap.keySet()){
            int age = PassengerMap.get(i).getAge();
            String Name = PassengerMap.get(i).getName();
            BerthPreference preference = PassengerMap.get(i).getBerthPreference();

            System.out.printf("Booking id :  "+ i +"\n" +
                     "Passenger Name : " + Name +"\n" +
                    "Age : " + age + "\n" +
                    "Seating : "+preference + "\n"
            );
            System.out.println();
        }
    }
    public void SetBerthPreference(Passenger passenger , String preference){
        if(Objects.equals(preference, "l") || Objects.equals(preference, "L")){
            passenger.setBerthPreference(BerthPreference.LOW);
           if(LowBerth>LowBerthQueue.size()){
               LowBerthQueue.add(passenger);
           }else{
               
           }
            LowBerth--;
        }else if (Objects.equals(preference, "m") || Objects.equals(preference, "M")){
            passenger.setBerthPreference(BerthPreference.MIDDLE);
            MiddleBerth--;
        }else{
            passenger.setBerthPreference(BerthPreference.HIGH);
            HighBerth--;
        }
    }
    public void CancelTicket(){
        System.out.println("Enter the Ticket ID to cancel : ");
        int ticketID = scanner.nextInt();
        if(PassengerMap.containsKey(ticketID)){
            PassengerMap.remove(ticketID);
            System.out.println("Ticket Cancelled");
        }else{
            System.out.println("ID not found ");
        }
    }
    public void CheckAvailability(){
        System.out.printf("Remaining HighBerth Seats : " +HighBerth + "\n"+
                "Remaining MiddleBerth Seats : "+MiddleBerth + "\n" +
                "Remaining LowBerth Seats : "+LowBerth
        );
        System.out.println();
    }


}
