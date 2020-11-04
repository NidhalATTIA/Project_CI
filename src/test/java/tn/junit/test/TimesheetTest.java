package tn.junit.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TimesheetTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	ITimesheetService itimesheetservice;
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	EmployeRepository employeRepository;
	static ObjectMapper mapper;
	static int employeId;
	int idmission;
	static int departementId;
	static String requestJson;
	static HttpHeaders headers;
	static String strDateDebut;
	static String strDateFin;
	
	 @BeforeClass
	 public static void setUp() {
		mapper = new ObjectMapper();
		employeId=3;
		departementId=2;
		headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    strDateDebut="28-10-2020";
	    strDateFin="03-11-2020";
	}
	 
	 @Test
	 public void getAllEmployeByMissionTest() throws JsonProcessingException {
		this.setIdmission(14);
		List<Employe> employeesList = itimesheetservice.getAllEmployeByMission(idmission);
		System.out.println(employeesList);
		System.out.println(idmission);
		String json = mapper.writeValueAsString(employeesList);
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/SpringMVC/servlet/getAllEmployeByMission/"+idmission,
				String.class)).contains(json);
	}	 
	
	
	
	@Test
	public void findAllMissionByEmployeJPQLTest() throws JsonProcessingException {
		List<Mission> missionsList = itimesheetservice.findAllMissionByEmployeJPQL(employeId);
		String json = mapper.writeValueAsString(missionsList);
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/SpringMVC/servlet/findAllMissionByEmployeJPQL/"+employeId,
				String.class)).contains(json);
	}
	
	@Test
	public void affecterMissionADepartementTest() {
	    requestJson = "{}";
		ResponseEntity<String> entity = new TestRestTemplate().exchange(
	            "http://localhost:" + this.port + "/SpringMVC/servlet/affecterMissionADepartement/"+idmission+"/"+departementId, HttpMethod.PUT,
	            new HttpEntity<String>(requestJson,headers),
	            String.class);
	    assertEquals(HttpStatus.OK, entity.getStatusCode()); 
	    
	}
	


	public int getIdmission() {
		return idmission;
	}

	public void setIdmission(int idmission) {
		this.idmission = idmission;
	}
	
	public int findLastIdMission() {
		List <Mission> missionList=((List <Mission>)missionRepository.findAll());
		return missionList.get(missionList.size()-1).getId();
	}
	

}