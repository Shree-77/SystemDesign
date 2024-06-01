package FlightBooking;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    public int FlightId;
    public String FlightName;
    public int no_of_seats;

    public List<Passenger> BoardedPassengers = new ArrayList<>();

    public Flight(int flightId, String flightName) {
        FlightId = flightId;
        FlightName = flightName;
        no_of_seats = 50;
    }

    @Override
    public String toString() {
        return
                "FlightId=" + FlightId + "," + '\n'+
                 "FlightName=" + FlightName +","+ '\n' +
                "no_of_seats=" + no_of_seats +"," +'\n';


    }
}
