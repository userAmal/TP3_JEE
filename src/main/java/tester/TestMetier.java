package tester;

import java.util.List;

import metier.MetierImpl;
import metier.Reservation;

public class TestMetier {

	public static void main(String[] args) {
		MetierImpl metier= new MetierImpl();
		List<Reservation> res = metier.getReservationsParMotCle("syrine");
		for (Reservation r : res)
		System.out.println(r.getNomClient());
	}

	

}
