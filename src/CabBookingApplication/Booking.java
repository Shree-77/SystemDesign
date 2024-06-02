package CabBookingApplication;

import java.util.*;

public class Booking {
    List<Cab> cabs = new ArrayList<>(Arrays.asList(
            new Cab(1, 'A', 0, 0),
            new Cab(2, 'A', 0, 0),
            new Cab(3, 'A', 0, 0),
            new Cab(4, 'A', 0, 0)
    ));

    public void bookTaxi(char pickup_point, char drop_point, int pickup_Time) {
        int nearestTaxiIndex = CalculateNearestTaxi(pickup_point, pickup_Time);
        if (nearestTaxiIndex == -1) {
            System.out.println("No available taxis.");
            return;
        }

        Cab bookedCab = cabs.get(nearestTaxiIndex);
        double cost = CalculateEarnings(pickup_point, drop_point);
        bookedCab.setEarnings(bookedCab.getEarnings() + (int) cost);

        int travelTime = Math.abs(drop_point - pickup_point) * 60 / 15;
        int freetime = pickup_Time + travelTime;
        bookedCab.setFreeTime(freetime);
        bookedCab.setLocation(drop_point);
        System.out.println("Cab no : " + bookedCab.getCabId() + " booked");
    }

    public void Availability() {
        for (Cab cab : cabs) {
            System.out.println("Cab " + cab.getCabId() + " is at " + cab.getLocation() + " and its free time is " + cab.getFreeTime());
        }
    }

    public int CalculateNearestTaxi(char pickup_point, int pickup_time) {
        int nearestTaxiIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < cabs.size(); i++) {
            Cab cab = cabs.get(i);
            int distance = Math.abs(pickup_point - cab.getLocation());
            int travelTime = distance * 60 / 15; // Convert distance to travel time

            if (cab.getFreeTime() + travelTime <= pickup_time) {
                if (distance < minDistance || (distance == minDistance && cab.getEarnings() < cabs.get(nearestTaxiIndex).getEarnings())) {
                    minDistance = distance;
                    nearestTaxiIndex = i;
                }
            }
        }

        return nearestTaxiIndex;
    }

    public double CalculateEarnings(char pickup_point, char drop_point) {
        int distance = Math.abs(drop_point - pickup_point) * 15; // Convert points to distance in KM
        int initialCost = 100;
        int remainingKm = Math.max(0, distance - 5);
        return initialCost + remainingKm * 10;
    }

    public static void main(String[] args) {
        Booking booking = new Booking();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Book a Taxi");
            System.out.println("2. Check Availability");
            System.out.println("3. Print Bookings");
            System.out.println("4. Quit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the Pickup point, Drop Point, Pickup Time");
                    char pickup_point = scanner.next().charAt(0);
                    char drop_point = scanner.next().charAt(0);
                    int pickup_time = scanner.nextInt();
                    booking.bookTaxi(pickup_point, drop_point, pickup_time);
                    break;
                case 2:
                    booking.Availability();
                    break;
                case 3:
                    // Implement if you have a specific method to print bookings
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
