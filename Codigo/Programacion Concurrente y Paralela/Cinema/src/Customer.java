public class Customer implements Runnable{
private String name;
private Integer seat2buy;
private Integer seats;
private Function function;

public Customer(String name, Integer seat2buy, Integer seats, Function function){
    this.name = name;
    this.seat2buy = seat2buy;
    this.seats = seats;
    this.function = function;
}
@Override
public void run() {
    for(int i=0;i<seats;i++){
        this.buyTicket(function,seat2buy+i);
    }

}

public void buyTicket(Function f,Integer seatNumber){
f.putSeat(seatNumber,this);
}

public String getName(){
    return name;
}

}
