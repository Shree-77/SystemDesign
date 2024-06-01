package FlightBooking;

import java.util.*;

public class Main {
    private static final Map<Flight , List<Passenger>>Travelers = new HashMap<>();
    private static final Map<Integer  , Flight> MapFlight = new HashMap<>();
    static int passengerId =1;
    static int ticketsBooked =0;
     static int basePrice = 5000;
     static int canceledTicket=1;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        MapFlight.put(1,new Flight(1 , "KingFisher"));
        MapFlight.put(2,new Flight(2,"Air India"));

        int i=0;
        do{
            System.out.println("Choose the Option : ");
            System.out.println("1.Book Ticket");
            System.out.println("2.Cancel ticket");
            System.out.println("3. Print the ticket");
            System.out.println("4. Exit");

            i = in.nextInt();

            switch (i){
                case 1:
                    BookTicket();
                    break;
                case 2 :
                   CancelTickets();
                    break;
                case 3 :
                    PrintTickets();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Input");
                    break;
            }

        }while (true);
    }
    public static void BookTicket(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter FlightID : ");
        int FlightId = in.nextInt();
        Flight bookingFlight = null;

        bookingFlight = MapFlight.get(FlightId);

        if(bookingFlight == null){
            System.out.println("Flight not found");
            return;
        }


        System.out.println("Enter no of seats ");
        int seats = in.nextInt();
        System.out.println("Fill information for " +seats +" seats");

        int remaining_seats = bookingFlight.no_of_seats - seats;
        int TicketPrice =0;
        in.nextLine();


        List<Passenger>passengerList = Travelers.getOrDefault(bookingFlight , new ArrayList<>());

       if(remaining_seats >=0){
           while(seats>0){
               System.out.println("Enter the Passenger name : ");
               String name = in.nextLine();
               Passenger passenger = new Passenger(name , passengerId);
               passengerList.add(passenger);
               TicketPrice+=CalculateTicketPrice(passengerList.size());
               seats--;
               passengerId++;
           }
           Travelers.put(bookingFlight , passengerList);
           System.out.println("Your Total Ticket Price : "+TicketPrice);
       }else{
           System.out.println("Seats not available");
           return;
       }
       bookingFlight.no_of_seats = remaining_seats;
        System.out.println("Successfully Booked");
    }

    public static void CancelTickets(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the flight ID : ");
        int flightId = in.nextInt();

        if(MapFlight.containsKey(flightId)){
            Flight flight = MapFlight.get(flightId);
            for(Map.Entry<Flight , List<Passenger>> entry : Travelers.entrySet()){
                Flight flight1 = entry.getKey();
                List<Passenger>passengerList = entry.getValue();
                if(flight1==flight){
                    System.out.println("Enter the passengerID : ");
                    int passengerID = in.nextInt();
                    for(Passenger passenger : passengerList){
                        if(passenger.Passenger_Id == passengerID){
                            passengerList.remove(passenger);
                            System.out.println("Successfully removed");
                            System.out.println("Refund credited : " +(5000 - canceledTicket*200));
                            canceledTicket+=1;
                            return;
                        }
                    }
                }
                System.out.println("Invalid Passenger ID");
            }
        }else{
            System.out.println("Invalid FlightId");
        }
    }
    public static void PrintTickets() {
        for (Map.Entry<Flight, List<Passenger>> entry : Travelers.entrySet()) {
            Flight flight = entry.getKey();

            if(MapFlight.containsKey(flight.FlightId)){
                List<Passenger>passengerList =entry.getValue();
                if(entry.getValue()!=null && !entry.getValue().isEmpty()){
                    System.out.println("Flight Details");
                    System.out.println(flight);
                    System.out.println("Passengers List : ");
                    for (Passenger passenger : passengerList) {
                        System.out.println(passenger);
                    }
                    System.out.println();
                }
            }
        }
    }

    public static int CalculateTicketPrice(int num){
        int Price  =  basePrice+(ticketsBooked*200);
        ticketsBooked+=1;
        return Price;

    }

}
