package tn.junit.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.TimesheetSpringBootCoreDataJpaMvcRest1Application;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetSpringBootCoreDataJpaMvcRest1Application.class)
	
public class MissionTest {
	@Autowired 
	IEmployeService es;
	@Test
	public void testAjoutEmploye() {  
		
		//ajout Employe:
	Mission miss1=new Mission("mission de sarra","une mission trés simple");
	es.ajouterMission(miss1);
	assertNotNull(es.ajouterMission(miss1));
}
}
