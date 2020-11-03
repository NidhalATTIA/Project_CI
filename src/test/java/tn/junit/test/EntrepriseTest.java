package tn.junit.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.TimesheetSpringBootCoreDataJpaMvcRest1Application;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetSpringBootCoreDataJpaMvcRest1Application.class)
public class EntrepriseTest {
	@Autowired
	IEntrepriseService es;
	Entreprise entreprise;
	@Autowired
	IEmployeService emp;

	@Test
	public void testAjoutEntreprise() {
		Entreprise entreprise = new Entreprise("sahar", "mansouri");
		es.ajouterEntreprise(entreprise);
		assertNotNull(es.ajouterEntreprise(entreprise));
	}

	@Test
	public void testGetEntrepriseById() {
		es.getEntrepriseById(10);
		assertNotNull(es.getEntrepriseById(10));
	}
	
	
	
	@Test
	public void testDeleteEntreprise() {
		es.deleteEntrepriseById(7);
	}

	@Test
	public void testGetAllEmployeByEntreprise() {
		Entreprise entreprise = new Entreprise(12);
		emp.getAllEmployeByEntreprise(entreprise);
		assertNotNull(emp.getAllEmployeByEntreprise(entreprise));

	}
}