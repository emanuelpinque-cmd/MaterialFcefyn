import java.util.HashMap;
public class Function {
private String name;
private Integer cash;
private Integer price=10;
private Integer numberOfSeats;
private HashMap<Integer,Seat> seats;

Object criticalSection = new Object();

public Function(String name,Integer numberOfSeats){
    seats=new HashMap<>();
    this.name=name;
    this.cash=0;
    this.numberOfSeats=numberOfSeats;
    for(int i=0;i<numberOfSeats;i++){
        seats.put(i,new Seat());
        seats.get(i).setSeatNumber(i);
    }

}


public void putSeat(Integer seatNumber,Customer customer){
    synchronized(criticalSection){
    if(this.seats.get(seatNumber).hasCustomer){
        System.out.println("Seat number "+seatNumber+" is already in room");
        return;
    }

try{
    Thread.sleep(5);
}
    catch(InterruptedException e){}

    //Asing the customer

        this.seats.get(seatNumber).setCustomer(customer);
        this.seats.get(seatNumber).hasCustomer = true;
        this.cash += price;
    }
}
public Seat getSeat(Integer seatNumber){
    return this.seats.get(seatNumber);
}

public void showSeats(){
    for(Seat seat:seats.values()){
        if(seat.hasCustomer){
            System.out.println(seat.getCustomer().getName()+" " + " "+seat.getSeatNumber());
        }

    }
}
public void showCash(){
    System.out.println(this.cash);
}
}
