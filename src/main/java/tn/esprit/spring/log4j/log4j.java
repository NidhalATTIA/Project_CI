package tn.esprit.spring.log4j;

import org.apache.log4j.Logger;


public class log4j {
	private static final Logger l = Logger.getLogger(log4j.class);

	public static void main(String[] args) {
		log4j al = new log4j();
		al.getAllContrats();

		al.getAllTimesheet();

		al.getAllEmployes();
		al.getSalaireMoyenByDepartementId();
		al.getAllMission();

	}

	private void getAllMission() {
		try {
			l.info("In getAllMission() : ");
			l.debug("Je vais lancer l'affichage des missions.");
			l.debug("Je viens de lancer l'affichage des mission. " );
			l.debug("Je viens de finir l'affichage des mission.");
			l.info("Out getAllMission() without errors.");
		} catch (Exception e) {
			l.error("Erreur dans getAllMission() : " + e);
		}		
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
	
	public void getSalaireMoyenByDepartementId() {
		try {
			l.info("In getSalaireMoyenByDepartementId() : ");
			l.debug("Je vais lancer l'ajout des departements.");
			l.debug("Je viens de lancer l'ajout des departements. " );
			l.debug("Je viens de finir l'ajout des departement.");
			l.info("Out getAllContrats() without departement.");
		} catch (Exception e) {
			l.error("Erreur dans getSalaireMoyenByDepartementId() : " + e);
		}
	}


	
}
