package com.esprit.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.esprit.entity.ProjetEnseignant;

//import org.hibernate.annotations.LazyCollection;
//import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: Enseignant
 * 
 */
@Entity
public class Enseignant implements Serializable {

	private String nom;
	private String prenom;
	private int cin;
	private String email;
	private int numTelephone;
	private String nationalite;
	private Date date;

	// *********** adresse *************************
	private int codePostal;
	private String rue;
	private String ville;

	// *********** administration ******************
	private String matriculeEnseigant;
	private String login;
	private String password;
	private int privilege;

	private List<ProjetEnseignant> projetEnseignants;
	private List<ActiviteEnseignant> activiteEnseignants;

	private Unite unite;

	// private ChargeHoraireProjet chargeHoraireProjet;
	// private AnneeUniversitaire anneeUniversitaire;
	// private List<Encadrement> etudiant;
	// private ChargeHoraireActivite chargeHoraireActivite;
	// private ChargeHoraireEncadrement chargeHoraireEncadrement;
	// private ChargeHoraireProjet chargeHoraireProjet;

	private static final long serialVersionUID = 1L;

	public Enseignant() {
		super();
	}

	@Id
	public String getMatriculeEnseigant() {
		return matriculeEnseigant;
	}

	public void setMatriculeEnseigant(String matriculeEnseigant) {
		this.matriculeEnseigant = matriculeEnseigant;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(int numTelephone) {
		this.numTelephone = numTelephone;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationnalite) {
		this.nationalite = nationnalite;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPrivilege() {
		return privilege;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<ProjetEnseignant> getProjetEnseignants() {
		return projetEnseignants;
	}

	public void setProjetEnseignants(List<ProjetEnseignant> projetEnseignants) {
		this.projetEnseignants = projetEnseignants;
	}

	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<ActiviteEnseignant> getActiviteEnseignants() {
		return activiteEnseignants;
	}

	public void setActiviteEnseignants(
			List<ActiviteEnseignant> activiteEnseignants) {
		this.activiteEnseignants = activiteEnseignants;
	}

	// @OneToMany(mappedBy = "enseignant")
	// public List<Encadrement> getEtudiant() {
	// return etudiant;
	// }
	//
	// public void setEtudiant(List<Encadrement> etudiant) {
	// this.etudiant = etudiant;
	// }
	//
	// @ManyToOne(cascade = CascadeType.ALL)
	// public ChargeHoraireActivite getChargeHoraireActivite() {
	// return chargeHoraireActivite;
	// }
	//
	// public void setChargeHoraireActivite(
	// ChargeHoraireActivite chargeHoraireActivite) {
	// this.chargeHoraireActivite = chargeHoraireActivite;
	// }
	//
	// @ManyToOne(cascade = CascadeType.ALL)
	// public ChargeHoraireEncadrement getChargeHoraireEncadrement() {
	// return chargeHoraireEncadrement;
	// }
	//
	// public void setChargeHoraireEncadrement(
	// ChargeHoraireEncadrement chargeHoraireEncadrement) {
	// this.chargeHoraireEncadrement = chargeHoraireEncadrement;
	// }
	//
	// @ManyToOne(cascade = CascadeType.ALL)
	// public ChargeHoraireProjet getChargeHoraireProjet() {
	// return chargeHoraireProjet;
	// }
	//
	// public void setChargeHoraireProjet(ChargeHoraireProjet
	// chargeHoraireProjet) {
	// this.chargeHoraireProjet = chargeHoraireProjet;
	// }
	//
	//
	//
	
	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	// @OneToOne
	// public ChargeHoraireProjet getChargeHoraireProjet() {
	// return chargeHoraireProjet;
	// }
	//
	//
	//
	// public void setChargeHoraireProjet(ChargeHoraireProjet
	// chargeHoraireProjet) {
	// this.chargeHoraireProjet = chargeHoraireProjet;
	// }
	//
	// @ManyToMany(mappedBy = "enseignants", cascade = CascadeType.ALL)
	// public List<Projet> getProjets() {
	// return projets;
	// }
	//
	// public void setProjets(List<Projet> projets) {
	// this.projets = projets;
	// }

	@ManyToOne
	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

}