package FlightBooking;

public class Passenger {
    String PassengerName;
    int Passenger_Id;


    public Passenger(String name, int passenger_Id) {
        PassengerName = name;
        Passenger_Id = passenger_Id;
    }

    public String getPassengerName() {
        return PassengerName;
    }

    public void setPassengerName(String passengerName) {
        PassengerName = passengerName;
    }

    public int getPassenger_Id() {
        return Passenger_Id;
    }

    public void setPassenger_Id(int passenger_Id) {
        Passenger_Id = passenger_Id;
    }

    @Override
    public String toString() {
        return   "Passenger Id "+Passenger_Id + " PassengerName= " + PassengerName;
    }
}
