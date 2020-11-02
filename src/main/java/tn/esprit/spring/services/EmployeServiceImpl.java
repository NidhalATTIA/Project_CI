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
import tn.esprit.spring.entities.EmployeDTO;
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

	
	///raya :employe
	public int ajouterEmploye(EmployeDTO employe) {
		l.debug("Je viens de lancer l'ajout des employes. " );
		employeRepository.save(employe);
		l.info("Ajout done!!!! ");
		
		return employe.getId();
	}

	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		Optional<EmployeDTO> employeop= this.employeRepository.findById(employeId);
		if (employeop.isPresent() ){	
		EmployeDTO employe = employeop.get();
		employe.setEmail(email);
		l.info("mettreAjourEmailByEmployeId done!!!! ");
		employeRepository.save(employe);
		}
	}

	@Transactional	
	public void affecterEmployeADepartement(int employeId, int depId) {
		Optional<Departement> Departementop= this.deptRepoistory.findById(depId);
		Optional<EmployeDTO> employeop= this.employeRepository.findById(employeId);
		if (Departementop.isPresent() && employeop.isPresent() ){
		
		Departement depManagedEntity = Departementop.get();
		EmployeDTO employeManagedEntity = employeop.get();
		
		if(depManagedEntity.getEmployes() == null){

			List<EmployeDTO> employes = new ArrayList<>();
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
		Optional<EmployeDTO> employeop= this.employeRepository.findById(employeId);
		Optional<Contrat> Contratop= this.contratRepoistory.findById(employeId);
		
		if(employeop.isPresent() && Contratop.isPresent()){
		Contrat contratManagedEntity = Contratop.get();
		EmployeDTO employeManagedEntity = employeop.get();

		contratManagedEntity.setEmploye(employeManagedEntity);
		contratRepoistory.save(contratManagedEntity);
		
	}}

	public String getEmployePrenomById(int employeId) {
		l.debug("Je viens de lancer getEmployePrenomById. " );
		Optional<EmployeDTO> employeop= this.employeRepository.findById(employeId);
		EmployeDTO employeManagedEntity = employeop.get();
		l.info("getEmployePrenomById done!!!! ");
		return employeManagedEntity.getPrenom();
		
		
	}
	public void deleteEmployeById(int employeId)
	{
		l.debug("Je viens de lancer deleteEmployeById. " );
		Optional<EmployeDTO> employeop= this.employeRepository.findById(employeId);
		
		if (employeop.isPresent() ){	
		EmployeDTO employe = employeop.get();

		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
		for(Departement dep : employe.getDepartements()){
			dep.getEmployes().remove(employe);
		}
		
		employeRepository.delete(employe);
		l.info("delete done!!!! ");
	}}

	public void deleteContratById(int contratId) {
		Optional<Contrat> Contratop= this.contratRepoistory.findById(contratId);
		if (Contratop.isPresent() ){
		Contrat contratManagedEntity = Contratop.get();
		contratRepoistory.delete(contratManagedEntity);
		}
	}

	public int getNombreEmployeJPQL() {
		return employeRepository.countemp();
	}
	
	public List<String> getAllEmployeNamesJPQL() {
		return employeRepository.employeNames();

	}
	
	public List<EmployeDTO> getAllEmployeByEntreprise(Entreprise entreprise) {
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
	
	public List<Timesheet> getTimesheetsByMissionAndDate(EmployeDTO employe, Mission mission, Date dateDebut,
			Date dateFin) {
		return timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}

	public List<EmployeDTO> getAllEmployes() {
				return (List<EmployeDTO>) employeRepository.findAll();
	}

}
