package tn.esprit.spring.log4j;

import org.apache.log4j.Logger;


public class log4j {
	private static final Logger l = Logger.getLogger(log4j.class);

	public static void main(String[] args) {
		log4j al = new log4j();
		al.getAllContrats();
		al.getAllTimesheet();
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
	
	public void getAllTimesheet() {
		try {
			l.info("In getAllTimesheet() : ");
			l.debug("Je vais lancer l'ajout des timesheet.");
			l.debug("Je viens de lancer l'ajout des timesheet. " );
			l.debug("Je viens de finir l'ajout des timesheet.");
			l.info("Out getAllTimesheet() without errors.");
		} catch (Exception e) {
			l.error("Erreur dans getAllTimesheet() : " + e);
		}
	}

}
