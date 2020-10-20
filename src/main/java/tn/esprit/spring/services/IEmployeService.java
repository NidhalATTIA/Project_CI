package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;




public interface IEmployeService {
	
	
	public void affecterEmployeADepartement(int employeId, int depId);
	public void desaffecterEmployeDuDepartement(int employeId, int depId);
	public void deleteContratById(int contratId);
	public int ajouterContrat(Contrat contrat);
	public void deleteAllContratJPQL();


	

	
}
