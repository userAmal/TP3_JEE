package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements ImetierCatalogue {
	@Override
	public List<Reservation> getReservationsParMotCle(String mc) {
		List<Reservation> res = new ArrayList<Reservation>();
		Connection conn = SingletonConnection.getConnection();
		try {

			PreparedStatement ps = conn.prepareStatement("select * from RESRVATIONS where NOM_CLIENT LIKE ?");

			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reservation r = new Reservation();
				r.setIdReservation(rs.getLong("ID_RESERVATION"));
				r.setNomClient(rs.getString("NOM_CLIENT"));
				r.setPrix(rs.getDouble("PRIX_SEJOUR"));
				r.setDatedebut(rs.getDate("DATE_DEBUT"));
				r.setDatefin(rs.getDate("DATE_FIN"));
				res.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void addReservation(Reservation r) {
// TODO Auto-generated method stub
	}
}
