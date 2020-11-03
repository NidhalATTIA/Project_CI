package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {
	private static final Logger l = Logger.getLogger(EmployeServiceImpl.class);
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;

	
	///////////////////raya :employe
	@Override
	public int ajouterEmploye(Employe employe) {
	
		try {
			l.info("In ajouterEmploye() : ");
			l.debug("Je viens de lancer l'ajouterEmploye. ");
			employeRepository.save(employe);
			l.debug("Je viens de finir l'ajouterEmploye.");
			l.info("Out ajouterEmploye() without errors.");
		} catch (Exception e) {
			l.error("Erreur dans ajouterEmploye() : " + e);
		}
		
		return employe.getId();	
		
	}

	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		try {
		l.info("In mettreAjourEmailByEmployeId() : ");
	Optional<Employe> employeop= this.employeRepository.findById(employeId);
	if (employeop.isPresent() ){
		l.debug("Je viens de lancer mettreAjourEmailByEmployeId" );
			Employe employe = employeop.get();
			employe.setEmail(email);
			employeRepository.save(employe);
			l.debug("Je viens de finir mettreAjourEmailByEmployeId.");
			l.info("mettreAjourEmailByEmployeId done!!!! ");
			l.info("Out mettreAjourEmailByEmployeId() without errors.");
		}} catch (Exception e) {
			l.error("Erreur dans ajouterEmploye() : " + e);
		}
		

	}
	
	
	public String getEmployePrenomById(int employeId) {
	
			l.info("In getEmployePrenomById() : ");
			l.debug("Je viens de lancer getEmployePrenomById. " );
			Optional<Employe> employeop= this.employeRepository.findById(employeId);
			Employe employeManagedEntity = employeop.get();
			l.debug("Je viens de finir et voici l'employer:  " + employeManagedEntity.getPrenom());
			l.info("Out getEmployePrenomById() without errors et l'employe est: "+ employeManagedEntity.getPrenom());
		
		return employeManagedEntity.getPrenom();
	}
	
	
	public void deleteEmployeById(int employeId){
		try {
		l.info("In deleteEmployeById(): ");
		l.debug("Je viens de lancer deleteEmployeById." );
		Optional<Employe> employeop= this.employeRepository.findById(employeId);
		if (employeop.isPresent() ){	
			
			l.debug("Je viens de lancer le delete" );
			Employe employe = employeop.get();

			for(Departement dep : employe.getDepartements()){
				dep.getEmployes().remove(employe);
			}	
			employeRepository.delete(employe);
			
			l.debug("Je viens de finir le delete de l'employe "+employeId);
			l.info("deleteEmployeById done!!!! ");
			l.info("Out mettreAjourEmailByEmployeId() without errors.");
		}} catch (Exception e) {
			l.error("Erreur dans ajouterEmploye() : " + e);
		}
	
	}
	
	public int getNombreEmployeJPQL() {
		try {
			l.info("In getNombreEmployeJPQL() : ");
			l.debug("Je vais lancer le Nombre des Employes.");
			l.debug("Je viens de lancer l'affichage des nbre des employes. ");
			l.debug("Je viens de finir l'affichage des nbre des employes.");
			l.info("Out getNombreEmployeJPQL() without errors.");
		} catch (Exception e) {
			l.error("Erreur dans getNombreEmployeJPQL() : " + e);
		}
		return employeRepository.countemp();
	}
	
	public List<String> getAllEmployeNamesJPQL() {
		try {
			l.info("In getAllEmployeNamesJPQL() : ");
			l.debug("Je vais lancer l'affichage des noms des employes.");
			l.debug("Je viens de lancer l'affichage des noms des employes. ");
			List<String> li=(List<String>)employeRepository.employeNames();
			l.debug("Je viens de finir et l'affichage des noms des employes est: \n " +li);
			l.info("Out getAllEmployeNamesJPQL() without errors.");
		} catch (Exception e) {
			l.error("Erreur dans getAllEmployeNamesJPQL() : " + e);
		}
		return employeRepository.employeNames();

	}
	
	public List<Employe> getAllEmployes() {
		try {
			l.info("In getAllEmployes() : ");
			l.debug("Je vais lancer l'affichage des employes.");
			l.debug("Je viens de lancer l'affichage des employes. ");
			List<Employe> emp = (List<Employe>)employeRepository.findAll();
			l.debug("Je viens de finir et l'affichage des employes est: \n " +emp);
			l.info("Out getAllEmployes() without errors.");
		} catch (Exception e) {
			l.error("Erreur dans getAllEmployes() : " + e);
		}
		return (List<Employe>) employeRepository.findAll();
}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	@Transactional	
	public void affecterEmployeADepartement(int employeId, int depId) {
		Optional<Departement> Departementop= this.deptRepoistory.findById(depId);
		Optional<Employe> employeop= this.employeRepository.findById(employeId);
		if (Departementop.isPresent() && employeop.isPresent() ){
		
		Departement depManagedEntity = Departementop.get();
		Employe employeManagedEntity = employeop.get();
		
		if(depManagedEntity.getEmployes() == null){

			List<Employe> employes = new ArrayList<>();
			employes.add(employeManagedEntity);
			depManagedEntity.setEmployes(employes);
		}else{

			depManagedEntity.getEmployes().add(employeManagedEntity);


		}


		}}
		

	
	@Transactional
	public void desaffecterEmployeDuDepartement(int employeId, int depId)
	{
		Optional<Departement> Departementop= this.deptRepoistory.findById(depId);
		if (Departementop.isPresent() ){
		Departement dep = Departementop.get();

		int employeNb = dep.getEmployes().size();
		for(int index = 0; index < employeNb; index++){
			if(dep.getEmployes().get(index).getId() == employeId){
				dep.getEmployes().remove(index);
				break;//a revoir
			}
		}}
	}

	public int ajouterContrat(Contrat contrat) {
		contratRepoistory.save(contrat);
		return contrat.getReference();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {
		Optional<Employe> employeop= this.employeRepository.findById(employeId);
		Optional<Contrat> Contratop= this.contratRepoistory.findById(employeId);
		
		if(employeop.isPresent() && Contratop.isPresent()){
		Contrat contratManagedEntity = Contratop.get();
		Employe employeManagedEntity = employeop.get();

		contratManagedEntity.setEmploye(employeManagedEntity);
		contratRepoistory.save(contratManagedEntity);
		
	}}

	

	public void deleteContratById(int contratId) {
		Optional<Contrat> Contratop= this.contratRepoistory.findById(contratId);
		if (Contratop.isPresent() ){
		Contrat contratManagedEntity = Contratop.get();
		contratRepoistory.delete(contratManagedEntity);
		}
	}

	
	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		return employeRepository.getAllEmployeByEntreprisec(entreprise);
	}

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		employeRepository.mettreAjourEmailByEmployeIdJPQL(email, employeId);

	}
	public void deleteAllContratJPQL() {
         employeRepository.deleteAllContratJPQL();
	}
	
	public float getSalaireByEmployeIdJPQL(int employeId) {
		return employeRepository.getSalaireByEmployeIdJPQL(employeId);
	}

	public Double getSalaireMoyenByDepartementId(int departementId) {
		return employeRepository.getSalaireMoyenByDepartementId(departementId);
	}
	
	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		return timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}



}
