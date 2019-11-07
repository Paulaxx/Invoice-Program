package invoice;

import java.util.ArrayList;

public class Client {
	
	int id;
	String name, surname, address;
	int nip;
	static ArrayList<String> ClientName = new ArrayList<String>();
	static ArrayList<String> ClientSurname = new ArrayList<String>();
	static ArrayList<String> ClientAddress = new ArrayList<String>();
	static ArrayList<String> ClientNip = new ArrayList<String>();
	
	public Client(int id, String name, String surname, String address, int nip) {
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.address=address;
		this.nip=nip;
	}
	
	

}
