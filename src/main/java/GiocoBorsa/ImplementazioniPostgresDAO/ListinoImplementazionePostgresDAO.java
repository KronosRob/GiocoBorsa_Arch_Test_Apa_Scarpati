package GiocoBorsa.ImplementazioniPostgresDAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import GiocoBorsa.DAO.ListinoDAO;
import GiocoBorsa.Database.ConnessioneDatabase;
import GiocoBorsa.Model.Borsa;
import GiocoBorsa.Model.Listino;
import GiocoBorsa.Model.Societa;

public class ListinoImplementazionePostgresDAO implements ListinoDAO {

	private Connection connection;

	public ListinoImplementazionePostgresDAO(){
		try {
			connection = ConnessioneDatabase.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Listino leggiListinoDB(Borsa b) {
		PreparedStatement leggiListinoPS;
		Listino l=new Listino();
		try {
			leggiListinoPS = connection.prepareStatement(
					"SELECT * FROM \"Borsa\".\"Societa\" WHERE \"CittaBorsa\"='"+b.getCitta()+"'");
		ResultSet rs = leggiListinoPS.executeQuery();
		while (rs.next()) {
			Societa s = new Societa(rs.getString("Nome"),rs.getFloat("PrezzoAzione"));
			l.addSocieta(s);
			connection.close();
		}
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;		
	}


	@Override
	public void addSocietaDB(Societa s, Borsa b) {		
		try {
			PreparedStatement leggiListinoPS = connection.prepareStatement(
					"INSERT INTO \"Borsa\".\"Societa\" " + 
					"(\"Nome\", \"PrezzoAzione\", \"CittaBorsa\")" +
					"VALUES ('"+s.getNome()+"',"+s.getPrezzoAzione()+", '"+b.getCitta()+"');");
			leggiListinoPS.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
