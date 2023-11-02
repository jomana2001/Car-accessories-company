package system;

public class Worker {
String id;
String name;
String phone;
String address;
private boolean isFree;

public Worker(String id , String name ,String phone ,String address ,boolean isFree) {
	this.id=id;
	this.name=name;
	this.phone=phone;
	this.address=address;
	this.isFree=isFree;
	
}
public boolean getIsFree() {
    return isFree;
}

public void setIsFree(boolean isFree) {
    this.isFree = isFree;
}
}
