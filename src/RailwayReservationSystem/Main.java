package RailwayReservationSystem;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        TicketManager ticketManager = new TicketManager();

        boolean loop = true;
        do{
            System.out.println("Press 1 - > To Book Tickets");
            System.out.println("Press 2 - > To cancel Tickets");
            System.out.println("Press 3 - > To print Tickets");
            System.out.println("Press 4 -> To Check Availability");
            System.out.println("Press 5 - > To Exit ");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    ticketManager.BookTicket();
                    break;
                case 2:
                    ticketManager.CancelTicket();
                    break;
                case 3:
                    ticketManager.PrintTicket();
                    break;
                case 4:
                    ticketManager.CheckAvailability();
                    break;
                case 5:
                    System.out.println("Exited");
                    loop= false;
                    break;
                default:
                    System.out.println("choose between 1-5");
                    break;
            }
        }while (loop);
    }
}
