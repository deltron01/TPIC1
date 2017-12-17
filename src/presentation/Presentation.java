package presentation;

import dao.DaoImpl;
import metier.MetierImpl;

public class Presentation {

	/**
	 * @author Ali
	 */
	// la couche pr�sentation n'est pas ferm�e � la modification, parce que l'on utilise l'op�rateur new.
	// new = couplage fort :(
	// ainsi s'il ya un nouvelle version dans la couche Dao, on est oblig� de modifier le code source ICI.
	public static void main(String[] args) {
		// il faut d�finir l'injection de d�pendance pour que �a marche.
		
		DaoImpl dao = new DaoImpl(); // ajoutez cette intru
        MetierImpl mi = new MetierImpl();
        mi.setDao(dao);              // ajoutez cette instru ,pour que l'injection de d�pendance aura lieu.
        System.out.println(mi.calcul());
	}

}
