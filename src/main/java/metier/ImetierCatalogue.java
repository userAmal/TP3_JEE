package metier;

import java.util.List;

public interface ImetierCatalogue {
	public List<Reservation> getReservationsParMotCle(String mc);
	public void addReservation(Reservation r);
}
