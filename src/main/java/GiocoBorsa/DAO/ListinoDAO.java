package GiocoBorsa.DAO;

import GiocoBorsa.Model.Borsa;
import GiocoBorsa.Model.Listino;
import GiocoBorsa.Model.Societa;

public interface ListinoDAO {

	public void addSocietaDB(Societa s, Borsa b);

	public Listino leggiListinoDB(Borsa b);

}