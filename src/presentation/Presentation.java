package presentation;

import dao.DaoImpl;
import metier.MetierImpl;

public class Presentation {

	/**
	 * @author Ali
	 */
	// la couche présentation n'est pas fermée à la modification, parce que l'on utilise l'opérateur new.
	// new = couplage fort :(
	// ainsi s'il ya un nouvelle version dans la couche Dao, on est obligé de modifier le code source ICI.
	public static void main(String[] args) {
		// il faut définir l'injection de dépendance pour que ça marche.
		
		DaoImpl dao = new DaoImpl(); // ajoutez cette intru
        MetierImpl mi = new MetierImpl();
        mi.setDao(dao);              // ajoutez cette instru ,pour que l'injection de dépendance aura lieu.
        System.out.println(mi.calcul());
	}

}
