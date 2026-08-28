public class Seat {
private Customer customer;
private Integer seatNumber;
public Boolean hasCustomer;

public Seat(){
this.customer = null;
hasCustomer = false;
}

public void setCustomer(Customer customer){
    this.customer = customer;
}
public Customer getCustomer(){
    return this.customer;
}

public void setSeatNumber(Integer seatNumber){
    this.seatNumber = seatNumber;
}

public Integer getSeatNumber(){
    return this.seatNumber;
}

}
