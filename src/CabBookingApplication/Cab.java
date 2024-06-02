package CabBookingApplication;

public class Cab {
    int cabId;
    char Location;
    int earnings;
    int FreeTime;

    public int getFreeTime() {
        return FreeTime;
    }

    public void setFreeTime(int freeTime) {
        this.FreeTime = freeTime;
    }

    public Cab(int Id , char location, int earnings , int startTime) {
        this.cabId=Id;
        Location = location;
        this.earnings = earnings;
        this.FreeTime =startTime;
    }

    public char getLocation() {
        return Location;
    }

    public int getCabId() {
        return cabId;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public void setLocation(char location) {
        Location = location;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }
}
