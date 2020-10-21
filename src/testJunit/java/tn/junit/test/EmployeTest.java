package tn.junit.test;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;


import tn.esprit.spring.services.EmployeServiceImpl;


public class EmployeTest {
	
	
	EmployeServiceImpl employe=new EmployeServiceImpl();

	@Test
	public void testAjoutContrat() {
		assertNotNull(employe.ajouterContrat(contrat));
	}
	
	
}
