import java.util.*;

import Enum.City;

public class Theater {
    String theaterID;
    String address;
    City city;
    List<Screen> screenList = new ArrayList<>();
    List<Show> showsList = new ArrayList<>();

    public Theater(String theaterID, City city) {
        this.theaterID = theaterID;
        this.city = city;
    }

    public String getTheaterID() {
        return theaterID;
    }
    public void setTheaterID(String theaterID) {
        this.theaterID = theaterID;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
    public List<Screen> getScreenList() {
        return screenList;
    }
    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }
    public List<Show> getShowsList() {
        return showsList;
    }
    public void setShowsList(List<Show> showsList) {
        this.showsList = showsList;
    }

}
