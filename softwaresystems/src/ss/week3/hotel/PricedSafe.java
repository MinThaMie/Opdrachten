package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item {
	//-----------------------------Instance Variables
private double amount;
private String name;
	//-----------------------------Constructor
public PricedSafe(double price){
	this.amount=price;
	this.name= "Safe";
}
	//-----------------------------Queries
public double getAmount(){
	return amount;
}
public String toString(){
	return name + Double.toString(this.amount);
}
	//-----------------------------Commands
}
