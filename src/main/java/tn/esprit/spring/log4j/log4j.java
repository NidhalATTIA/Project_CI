package tn.esprit.spring.log4j;

import org.apache.log4j.Logger;


public class log4j {
	private static final Logger l = Logger.getLogger(log4j.class);

	public static void main(String[] args) {
		log4j al = new log4j();

		
		al.getAllContrats();
		al.getAllEmployes();
		
	}

	public void getAllContrats() {
		try {
			l.info("In getAllContrats() : ");
			l.debug("Je vais lancer l'ajout des contrats.");
			l.debug("Je viens de lancer l'ajout des contrats. " );
			l.debug("Je viens de finir l'ajout des contrats.");
			l.info("Out getAllContrats() without errors.");
		} catch (Exception e) {
			l.error("Erreur dans getAllContrats() : " + e);
		}
	}
	public void getAllEmployes() {
		try {
			l.info("In getAllEmployes() : ");
			l.debug("Je vais lancer l'ajout des Employes.");
			l.debug("Je viens de lancer l'ajout des employes. " );
			l.debug("Je viens de finir l'ajout des employes.");
			l.info("Out getAllContrats() without employes.");
		} catch (Exception e) {
			l.error("Erreur dans getAllContrats() : " + e);
		}
	}

	
}
