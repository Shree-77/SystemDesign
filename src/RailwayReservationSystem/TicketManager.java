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
    List<Passenger>bookedList = new ArrayList<>();
    Queue<Passenger> RACQueue = new LinkedList<>();
    Queue<Passenger> WaitingListQueue = new LinkedList<>();

    List<Integer>HighBerthQueue = new LinkedList<>(Arrays.asList(1));
    List<Integer>MiddleBerthQueue = new LinkedList<>(Arrays.asList(1));
    List<Integer>LowBerthQueue = new LinkedList<>(Arrays.asList(1));
    List<Integer> RACList = new LinkedList<>(Arrays.asList(1));
    List<Integer>WaitingListlist=new LinkedList<>(Arrays.asList(1));

    public void BookTicket() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the Passenger Details: {Name Age BerthPreference}");
                String[] inputs = in.nextLine().split(" ");

                if (inputs.length != 3) {
                    throw new IllegalArgumentException("Insufficient input. Please enter Name, Age, and BerthPreference.");
                }

                String name = inputs[0];
                int age = Integer.parseInt(inputs[1]);
                String berthPreference = inputs[2].toLowerCase();

                Passenger passenger = new Passenger(name, age, berthPreference);

                if (WaitingList < 0) {
                    System.out.println("No tickets available");
                    return;
                }
                BookingBasedOnPreference(passenger);

                PassengerMap.put(ID++, passenger);
                System.out.println("Ticket booked successfully!");
                break; // Exit the loop after successful booking

            } catch (NumberFormatException e) {
                System.out.println("Invalid age format. Please enter a valid integer for age.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
            }
        }
    }

    public void BookingBasedOnPreference(Passenger passenger){
        String berthPreference= passenger.getBerthPreference();
        if (berthPreference.equals("l") && LowBerth > 0) {
            System.out.println("Preferred Berth Given");
            passenger.setAlloted(berthPreference);
            bookedList.add(passenger);
            passenger.setSeatNumber(LowBerthQueue.get(0));
            LowBerthQueue.remove(0);
            LowBerth--;
        } else if (berthPreference.equals("m") && MiddleBerth > 0) {
            System.out.println("Preferred Berth Given");
            passenger.setAlloted(berthPreference);
            bookedList.add(passenger);
            passenger.setSeatNumber(MiddleBerthQueue.get(0));
            MiddleBerthQueue.remove(0);
            MiddleBerth--;
        } else if (berthPreference.equals("h") && HighBerth > 0) {
            System.out.println("Preferred Berth Given");
            passenger.setAlloted(berthPreference);
            bookedList.add(passenger);
            passenger.setSeatNumber(HighBerthQueue.get(0));
            HighBerthQueue.remove(0);
            HighBerth--;
        } else {
            // Preference not available, assign next available berth
            if (LowBerth > 0) {
                System.out.println("Lower Berth Given");
                passenger.setAlloted("l");
                bookedList.add(passenger);
                passenger.setSeatNumber(LowBerthQueue.get(0));
                LowBerthQueue.remove(0);
                LowBerth--;
            } else if (MiddleBerth > 0) {
                System.out.println("Middle Berth Given");
                passenger.setAlloted("m");
                bookedList.add(passenger);
                passenger.setSeatNumber(MiddleBerthQueue.get(0));
                MiddleBerthQueue.remove(0);
                MiddleBerth--;
            } else if (HighBerth > 0) {
                System.out.println("High Berth Given");
                passenger.setAlloted("h");
                bookedList.add(passenger);
                passenger.setSeatNumber(HighBerthQueue.get(0));
                HighBerthQueue.remove(0);
                HighBerth--;
            } else if (GeneralSeat > 0) {
                System.out.println("General Seat Given");
                passenger.setAlloted("g");
                bookedList.add(passenger);
                passenger.setSeatNumber(RACList.get(0));
                RACList.remove(0);
                GeneralSeat--;
                RACQueue.add(passenger);
            } else if (WaitingList > 0) {
                System.out.println("Added to Waiting List");
                passenger.setAlloted("w");
                bookedList.add(passenger);
                passenger.setSeatNumber(WaitingListlist.get(0));
                WaitingListlist.remove(0);
                WaitingList--;
                WaitingListQueue.add(passenger);
            } else {
                System.out.println("No tickets available");

            }
        }
    }

    public void PrintTicket(){
        if(PassengerMap.isEmpty())
            System.out.println("No Tickets Available");

        for(int i : PassengerMap.keySet()){
            int age = PassengerMap.get(i).getAge();
            String Name = PassengerMap.get(i).getName();
            String preference = PassengerMap.get(i).getBerthPreference();
            String alloted = PassengerMap.get(i).getAlloted();
            int seat=PassengerMap.get(i).getSeatNumber();

            System.out.printf("Booking id :  "+ i +"\n" +
                     "Passenger Name : " + Name +"\n" +
                    "Age : " + age + "\n" +
                    "SeatingPreferred : "+preference + "\n" +
                    "Seating Alloted: "+alloted + "\n"+
                    "Seat number : "+seat
            );
            System.out.println();
        }
    }

    public void CancelTicket(){
        System.out.println("Enter the Ticket ID to cancel : ");
        int ticketID = scanner.nextInt();

        if(PassengerMap.containsKey(ticketID)){
            Passenger passenger = PassengerMap.get(ticketID);
            PassengerMap.remove(ticketID);

            int seat = passenger.getSeatNumber();
            String alloted = passenger.getAlloted();
            if(alloted.equals("l")){
                LowBerth++;
                LowBerthQueue.add(seat);
            }else if(alloted.equals("m")){
                MiddleBerth++;
                MiddleBerthQueue.add(seat);
            } else if (alloted.equals("h")) {
                HighBerth++;
                HighBerthQueue.add(seat);
            }else if(alloted.equals("g")){
                GeneralSeat++;
                RACList.add(seat);
            }
            Passenger waitingList = WaitingListQueue.poll();
            Passenger Rac_Passenger = RACQueue.poll();

            if(Rac_Passenger!=null){
                BookingBasedOnPreference(Rac_Passenger);
            }
            if(waitingList!=null){
                RACQueue.add(waitingList);
                GeneralSeat--;
            }
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
