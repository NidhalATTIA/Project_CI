package tn.junit.test;

import org.junit.Test;

import tn.esprit.spring.services.EmployeServiceImpl;


public class EmployeTest {
	
	
	EmployeServiceImpl employe=new EmployeServiceImpl();

	@Test
	public void testAjoutContrat() {
		assertNotNull(employe.ajouterContrat(contrat));
	}
	@Test
	public void testAjoutEmploye() {
		assertNotNull(employe.ajouterEmploye(employe));
	}
	@Test
	public void testAjoutTimesheet() {
		assertNotNull(employe.getTimesheetsByMissionAndDate(employe,mission,dateDebut,dateFin));
	}
	
	
}
