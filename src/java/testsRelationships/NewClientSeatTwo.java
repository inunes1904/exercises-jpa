package testsRelationships;

import OneToOneModel.Client;
import OneToOneModel.Seat;
import infrastructure.DAO;

public class NewClientSeatTwo {
	public static void main(String[] args) {
		
		DAO<Client> dao = new DAO<>(Client.class);
		
		Seat seat = new Seat("19F");
		Client client = new Client("Salomé Afonso", seat);
		
		dao.includeAtomic(client);
	}

}
