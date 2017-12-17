package presentation;

import metier.IMetier;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresentationAvecSpring {

	/**
	 * tout framework utilise un framework de journalisation (Log) tel <Log4j> framework
	 * Ajoutez le fichier log4j.xml à votre projet pour configurer le framework log4j
	 * la journalisation est un métier!!!.
	 */
	public static void main(String[] args) {
        // si vous n'avez pas integré les .JAR de Spring, vous ne pouvez pas avoir la classe ci-dessous
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IMetier metier = (IMetier) context.getBean("metier");
		System.out.println(metier.calcul());

	}

}
