package GiocoBorsa.DAO;

import java.time.LocalDate;

import GiocoBorsa.Model.Giocatore;
import GiocoBorsa.Model.Societa;

public interface GiocatoreDAO {


	void acquistaDB(Giocatore g, int quantita, LocalDate now, float prezzo, Societa societa);


}