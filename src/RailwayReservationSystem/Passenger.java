package RailwayReservationSystem;

public class Passenger {

    private String Name;
    private int Age;

    private BerthPreference berthPreference;

    public Passenger(String name, int age, BerthPreference berthPreference) {
        Name = name;
        Age = age;
        this.berthPreference = berthPreference;
    }
    public Passenger(){

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

    public BerthPreference getBerthPreference() {
        return berthPreference;
    }

    public void setBerthPreference(BerthPreference berthPreference) {
        this.berthPreference = berthPreference;
    }
}
