package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;




public interface IEmployeService {
	
	public int ajouterEmploye(Employe employe);
	public void mettreAjourEmailByEmployeId(String email, int employeId);
	public void affecterEmployeADepartement(int employeId, int depId);
	public void desaffecterEmployeDuDepartement(int employeId, int depId);
	public Double getSalaireMoyenByDepartementId(int departementId);
	public void deleteContratById(int contratId);
	public int ajouterContrat(Contrat contrat);
	public void deleteAllContratJPQL();
	public void affecterContratAEmploye(int contratId, int employeId);
	public String getEmployePrenomById(int employeId);
	public int getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId);
	public float getSalaireByEmployeIdJPQL(int employeId);
	public List<Employe> getAllEmployes();

	

	
}
