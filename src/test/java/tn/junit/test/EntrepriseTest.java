package tn.junit.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IEntrepriseService;

public class EntrepriseTest {

	EntrepriseServiceImpl entrepriseService = new EntrepriseServiceImpl();
	IEntrepriseService entrepriseSer;
	Entreprise entreprise = new Entreprise();
	Departement dep = new Departement();

	
	
//	@Test
	// public void testAjoutEntreprise() {
	// Entreprise u = new Entreprise("sahar", "sahar");
	// entrepriseSer.ajouterEntreprise(u);
	// assertNotNull(entrepriseService.ajouterEntreprise(new Entreprise("sahar",
	// "sahar")));
//	}

	// @Test
	// public void testAjoutDepartement() {
	// assertNotNull(entrepriseService.ajouterDepartement(dep));
//	}

}