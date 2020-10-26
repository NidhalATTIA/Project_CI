package tn.junit.test;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.EntrepriseServiceImpl;

public class EntrepriseTest {

	EntrepriseServiceImpl entrepriseService = new EntrepriseServiceImpl();
	Entreprise entreprise = new Entreprise();

	@Test
	public void testAjoutEntreprise() {
		assertNotNull(entrepriseService.ajouterEntreprise(entreprise));
	}

}