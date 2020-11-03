package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
<<<<<<< HEAD
	EntrepriseRepository entrepriseRepoistory;

	Entreprise entreprise;
	@Autowired
	DepartementRepository deptRepoistory;

/// sahaar 
	public int ajouterEntreprise(Entreprise entreprise) {
		l.debug("Je viens de lancer ajouterEntreprise ! ");
		entrepriseRepoistory.save(entreprise);
		l.info("ajouterEntreprise done !");
		return entreprise.getId();
	}

	/// sahaar
	public Entreprise getEntrepriseById(int entrepriseId) {
		l.debug("Je viens de lancer getEntrepriseById :");
		Optional<Entreprise> entrepriseop = this.entrepriseRepoistory.findById(entrepriseId);
		Entreprise entreprise = entrepriseop.get();
		l.info("getEntrepriseById done !" + "nom :" + entreprise.getName() + "raison :" + entreprise.getRaisonSocial());
		return entreprise;

	}

	/// sahaar
	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		l.debug("Je viens de lancer deleteEntrepriseById ! ");
		Optional<Entreprise> entrepriseop = this.entrepriseRepoistory.findById(entrepriseId);
		if (entrepriseop.isPresent()) {
			Entreprise entrepriseManagedEntity = entrepriseop.get();
			entrepriseRepoistory.delete(entrepriseManagedEntity);
		}
	}

	/// sahaar
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		Optional<Departement> Departementop = this.deptRepoistory.findById(depId);
		Optional<Entreprise> Entrepriseop = this.entrepriseRepoistory.findById(entrepriseId);
		if (Departementop.isPresent() && Entrepriseop.isPresent()) {
			Entreprise entrepriseManagedEntity = Entrepriseop.get();
			Departement depManagedEntity = Departementop.get();
			depManagedEntity.setEntreprise(entrepriseManagedEntity);
			l.debug("Departmement affecté a l'entreprise! ");
			deptRepoistory.save(depManagedEntity);
		}
	}

	//// nidhal
	public int ajouterDepartement(Departement dep) {
		l.debug("Je viens de lancer l'ajout des departements! ");
		deptRepoistory.save(dep);
		l.info("Ajouté !");
		return dep.getId();
	}

=======
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
	
>>>>>>> b27b361ba29dd57e6f1c45b322fcaea42f8793fd
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise entrepriseManagedEntity =entrepriseRepoistory.findById(entrepriseId).get();
		List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
<<<<<<< HEAD
		l.debug("Liste des departements par entreprise ! ");
		return depNames;
	}
=======
		
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		Optional<Entreprise> entrepriseop= this.entrepriseRepoistory.findById(entrepriseId);
		if (entrepriseop.isPresent() ){	
		
		entrepriseRepoistory.delete(entrepriseop.get());}	
	}
>>>>>>> b27b361ba29dd57e6f1c45b322fcaea42f8793fd

	@Transactional
	public void deleteDepartementById(int depId) {
		Optional<Departement> Departementoptional= this.deptRepoistory.findById(depId);
		if( Departementoptional.isPresent()){
		deptRepoistory.delete(Departementoptional.get());	
	}
	}

<<<<<<< HEAD
=======
	public Entreprise getEntrepriseById(int entrepriseId) {
		return entrepriseRepoistory.findById(entrepriseId).get();	
	}

>>>>>>> b27b361ba29dd57e6f1c45b322fcaea42f8793fd
}
