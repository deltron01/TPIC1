package presentation;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;
import metier.IMetier;

import dao.IDao;

public class PresentationV2 {

	/**
	 * @param args
	 */
	// l'injection de dépendance est un processus qui intervient au moment l'exécution de l'application
	// deux manières de le faire :
	// 1) instanciation dynamique dite programmation par reflexion, en créant un fichier de configuration
	// 2) framework Spring
	public static void main(String[] args) {
		// on va lire le fichier conf et extraire le nom de la classe et puis l'instancier par forName (comme pour le pilote JDBC)
        try {
			Scanner scanner = new Scanner(new File("config.txt"));
			String daoClassName = scanner.next();
			String metierClassName = scanner.next();
			//System.out.println(daoClassName);
			//System.out.println(metierClassName);
			Class cDao = Class.forName(daoClassName); // charger la classe en mémoire
			Class cMetier = Class.forName(metierClassName);
			IDao dao = (IDao) cDao.newInstance();  // instatiation dynamique, on garde l'interface pour s'assurer du couplage faible :)
			IMetier metier = (IMetier) cMetier.newInstance(); // newInstance toujrs fait appel au constructeur sans paramètres..si celui-ci n'est 
			                                                 // pas présent dans la classe, alors cette programmation n'est plus utile!!!
			Method mth = cMetier.getMethod("setDao", new Class[] {IDao.class});
			mth.invoke(metier, new Object[] {dao});//injection de dépendances en personne!!!
			System.out.println(metier.calcul());
			
        } catch (Exception e) {
			System.out.println("Error !");
			e.printStackTrace();
		}	
		/*} catch (FileNotFoundException e) {
			System.out.println("File not found !");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("No such class");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.out.println("Instantiation Exception");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("Illegal Acces Error");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("No such method error");
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
