package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao; // couplage faible
                     // on a besoin du setter pour l'injection des dependances.
    // la couche métier est ainsi dermée à la modification car si un changement occure dans la
    // couche Dao, on n'a pas besoin de modifier dans la couche métier.
    // la couche métier est aussi ouverte à l'extension, car elle est basée sur une INterface.
	public double calcul() {
		double t = dao.getTemperature();
		return t*7;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

}
