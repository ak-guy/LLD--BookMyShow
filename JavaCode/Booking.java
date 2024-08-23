import java.util.*;

public class Booking {
    
    Show show;
    List<Seat> seatIDList = new ArrayList<>();
    Payement payment;

    public Show getShow() {
        return show;
    }
    public void setShow(Show show) {
        this.show = show;
    }
    public List<Seat> getSeatIDList() {
        return seatIDList;
    }
    public void setSeatIDList(List<Seat> seatIDList) {
        this.seatIDList = seatIDList;
    }
    public Payement getPayment() {
        return payment;
    }
    public void setPayment(Payement payment) {
        this.payment = payment;
    }

}
