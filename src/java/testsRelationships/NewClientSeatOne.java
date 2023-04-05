package testsRelationships;

import OneToOneModel.Client;

import OneToOneModel.Seat;
import infrastructure.DAO;

public class NewClientSeatOne {

	public static void main(String[] args) {
		
		
		Seat seat = new Seat("17C");
		
		
		Client client = new Client("Pedro Nunes", seat);
		
		DAO<Object> dao = new DAO<>();
		
		dao.openTransaction().include(seat)
		.include(client).commitTransaction()
		.close();
		
	}
}
