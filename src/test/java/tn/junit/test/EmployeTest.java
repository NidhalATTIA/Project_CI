package tn.junit.test;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.EmployeServiceImpl;


public class EmployeTest {
	
	
	EmployeServiceImpl employeService=new EmployeServiceImpl();
	Employe employe = new Employe();
	Contrat contrat = new Contrat();
	Mission mission = new Mission();
	Date dateDebut;
	Date dateFin;
	int employeId,depId;

	@Test
	public void testAjoutContrat() {
		assertNotNull(employeService.ajouterContrat(contrat));
	}
	@Test
	public void testAjoutEmploye() {
		assertNotNull(employeService.ajouterEmploye(employe));
	}
	@Test
	public void testAjoutTimesheet() {
		assertNotNull(employeService.getTimesheetsByMissionAndDate(employe,mission,dateDebut,dateFin));
	}
	
	/*@Test
	public void testaffecterEmployeADepartement() {
		assertNotNull(employeService.affecterEmployeADepartement(employeId,depId));
	}*/
	
}
