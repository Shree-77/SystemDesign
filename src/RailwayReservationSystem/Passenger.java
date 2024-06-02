package RailwayReservationSystem;

public class Passenger {

    private String Name;
    private int Age;

    private String  berthPreference;
    private String alloted;
    private  int seatNumber;

    public Passenger(String name, int age, String berthPreference , String allotedNumber) {
        Name = name;
        Age = age;
        this.berthPreference = berthPreference;
        this.alloted ="";
    }

    public Passenger(String name, int age, String berthPreference) {
        Name = name;
        Age = age;
        this.berthPreference = berthPreference;
    }

    public Passenger(){

    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getAlloted() {
        return alloted;
    }

    public void setAlloted(String alloted) {
        this.alloted = alloted;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getBerthPreference() {
        return berthPreference;
    }

    public void setBerthPreference(String berthPreference) {
        this.berthPreference = berthPreference;
    }
}
