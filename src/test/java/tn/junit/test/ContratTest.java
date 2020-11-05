package tn.junit.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.TimesheetSpringBootCoreDataJpaMvcRest1Application;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetSpringBootCoreDataJpaMvcRest1Application.class)
public class ContratTest {
	//oumayma
	@Autowired 
	IEmployeService es;
	ITimesheetService ts;
	
	@Test
	public void testAjoutContrat() throws ParseException {
		SimpleDateFormat f=new SimpleDateFormat("dd/mm/yyyy");

		Date d=f.parse("20/11/2001");
		Contrat c=new Contrat(d,"engineer",1254f);
		es.ajouterContrat(c);
		assertNotNull(es.ajouterContrat(c));
	}
	
	/*@Test
	public void testAffecterContratEmploye() throws ParseException {
		es.affecterContratAEmploye(30, 2);

	}*/
	
/*	@Test
	public void testDeleteContart() throws ParseException {
		es.deleteContratById(31);

	}
*/
	

	

	
}

