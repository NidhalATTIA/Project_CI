package tn.junit.test;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.EntrepriseServiceImpl;

public class EntrepriseTest {

	EntrepriseServiceImpl entreprise = new EntrepriseServiceImpl();

	@Test
	public void testAjoutEntreprise() {
		assertNotNull(entreprise.ajouterEntreprise(entreprise));
	}

}