import java.util.*;

public class Screen {
    String screenID;
    List<Seat> seatList = new ArrayList<>();

    public String getScreenID() {
        return screenID;
    }
    public void setScreenID(String screenID) {
        this.screenID = screenID;
    }
    public List<Seat> getSeatList() {
        return seatList;
    }
    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

}
