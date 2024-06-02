package CabBookingApplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Booking TaxiBooking = new Booking();
        int n ;
        do{
            System.out.println(" 1.Book a Taxi \n 2.Check Available \n 3.Print bookings \n 4.Quit");
            n = in.nextInt();
            in.nextLine();
            switch (n){
                case 1:
                    System.out.println("Enter the Pickup point , Drop Point , PickupTime ");
                    String input = in.nextLine();
                    String[]inputs = input.split(" ");
                    char pickup_point = inputs[0].toCharArray()[0];
                    char drop_point = inputs[1].toCharArray()[0];
                    int pickup_time = inputs[2].toCharArray()[0];
                    TaxiBooking.bookTaxi(pickup_point,drop_point,pickup_time);
                    break;
                case 2:
                    TaxiBooking.Availability();
                    break;
                case 3:
                    break;
            }
        }while (n!=4);
    }
}
