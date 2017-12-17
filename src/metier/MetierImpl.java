package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao; // couplage faible
                     // on a besoin du setter pour l'injection des dependances.
    // la couche m�tier est ainsi derm�e � la modification car si un changement occure dans la
    // couche Dao, on n'a pas besoin de modifier dans la couche m�tier.
    // la couche m�tier est aussi ouverte � l'extension, car elle est bas�e sur une INterface.
	public double calcul() {
		double t = dao.getTemperature();
		return t*7;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

}
