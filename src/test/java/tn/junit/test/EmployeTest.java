package tn.junit.test;


import static org.junit.Assert.*;


import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.time.LocalDate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.TimesheetSpringBootCoreDataJpaMvcRest1Application;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetSpringBootCoreDataJpaMvcRest1Application.class)
public class EmployeTest {
	@Autowired
	IEmployeService es;
	ITimesheetService ts;
	
	LocalDate dateDebut = LocalDate.now();
	LocalDate dateFin = LocalDate.now();
	

	//raya test
	@Test
	public void testAjoutEmploye() {  	
		//ajout Employe:

		Employe employe1=new Employe("khaled","Kalel","khaled.kalel@ssiiconsulting.tn",true,Role.INGENIEUR);
		es.ajouterEmploye(employe1);
		assertNotNull(es.ajouterEmploye(employe1));
		
		Employe employe2=new Employe("Mouhamed","Zitouni","mohamed.zitouni@ssiiconsulting.tn",false,Role.TECHNICIEN);
		es.ajouterEmploye(employe2);
		assertNotNull(es.ajouterEmploye(employe2));
		
		Employe employe3=new Employe("Aymen","ouali","aymen.ouali@ssiiconsulting.tn",true,Role.INGENIEUR);
		es.ajouterEmploye(employe3);
		assertNotNull(es.ajouterEmploye(employe3));
		
		Employe employe4=new Employe("bochra","bouzid","bochra.bouzid@ssiiconsulting.tn",true,Role.CHEF_DEPARTEMENT);
		es.ajouterEmploye(employe4);
		assertNotNull(es.ajouterEmploye(employe4));
		
		Employe employe5=new Employe("yosra","arbi","yosra.arbi@ssiiconsulting.tn",true,Role.CHEF_DEPARTEMENT);
		es.ajouterEmploye(employe5);
		assertNotNull(es.ajouterEmploye(employe5));	

	}

	@Test
	public void testmettreAjourEmailByEmployeId() {  
		//mettre ajour Email
		es.mettreAjourEmailByEmployeId("raya.hadhri@esprit.tn",5);
	}
	
	@Test
	public void testgetEmployePrenomById() {  
		es.getEmployePrenomById(5);
		assertNotNull(es.getEmployePrenomById(5));
	}
	@Test
	public void testdeleteEmployeById() {
		es.deleteEmployeById(2);
	}
	
	@Test
	public void testgetNombreEmployeJPQL() {
		es.getNombreEmployeJPQL();
		assertNotNull(es.getNombreEmployeJPQL());
	}
	@Test
	public void testgetAllEmployeNamesJPQL() {
		es.getAllEmployeNamesJPQL();
		assertNotNull(es.getAllEmployeNamesJPQL());
	}
	@Test
	public void testgetAllEmployes() {
		es.getAllEmployes();
		assertNotNull(es.getAllEmployes());
	}

	
}
