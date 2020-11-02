package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepoistory.save(entreprise);
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		
		Optional<Departement> Departementop= this.deptRepoistory.findById(depId);
		Optional<Entreprise> Entrepriseop= this.entrepriseRepoistory.findById(entrepriseId);
		if (Departementop.isPresent()  && Entrepriseop.isPresent()){
				Entreprise entrepriseManagedEntity = Entrepriseop.get();
				Departement depManagedEntity = Departementop.get();
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
		
	}}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise entrepriseManagedEntity =entrepriseRepoistory.findById(entrepriseId).get();
		List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		
		return depNames;
	}
	

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		Optional<Entreprise> entrepriseop= this.entrepriseRepoistory.findById(entrepriseId);
		if (entrepriseop.isPresent() ){	
		
		entrepriseRepoistory.delete(entrepriseop.get());}	
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		Optional<Departement> Departementoptional= this.deptRepoistory.findById(depId);
		if( Departementoptional.isPresent()){
		deptRepoistory.delete(Departementoptional.get());	
	}
	}

	public Entreprise getEntrepriseById(int entrepriseId) {
		return entrepriseRepoistory.findById(entrepriseId).get();	
	}

}
