package testsRelationships;

import OneToOneModel.Client;
import OneToOneModel.Seat;
import infrastructure.DAO;

public class NewClientSeatDidirectional {

	public static void main(String[] args) {
		
		DAO<Client> dao = new DAO<>(Client.class);
		Client client = dao.obtainById(1L);
		
		DAO<Seat> daoSeat = new DAO<>(Seat.class);
		Seat seat = daoSeat.obtainById(1L);
		
		
		System.out.println(client.getSeat().getName());
		System.out.println(seat.getClient().getName());
		
		dao.close();
		daoSeat.close();
	}
	
}
