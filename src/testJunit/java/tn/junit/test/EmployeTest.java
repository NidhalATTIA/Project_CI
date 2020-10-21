package tn.junit.test;

import org.junit.Test;

import tn.esprit.spring.services.EmployeServiceImpl;


public class EmployeTest {
	
	
	EmployeServiceImpl employe=new EmployeServiceImpl();
	TimesheetImpl timeS = new TimesheetImpl();
	

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
		assertNotNull(timeS.ajouterTimesheet(timeS));
	}
	
	
}
