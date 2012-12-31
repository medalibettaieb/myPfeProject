package tn.esprit.teatchingHourlyCalculationClient.test;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.esprit.entity.Activite;
import com.esprit.entity.Enseignant;
import com.esprit.entity.Locale;
import com.esprit.entity.Projet;
import com.esprit.entity.Unite;
import com.esprit.service.gestionActivite.GestionActiviteRemote;
import com.esprit.service.gestionEnseignant.GestionEnseignantRemote;
import com.esprit.service.gestionLocal.GestionLocaleRemote;
import com.esprit.service.gestionProjet.GestionProjetRemote;
import com.esprit.service.gestionUnite.GestionUniteRemote;

public class InitDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			GestionEnseignantRemote gestionEnseignantRemote = (GestionEnseignantRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionEnseignant!com.esprit.service.gestionEnseignant.GestionEnseignantRemote");
			GestionProjetRemote gestionProjetRemote = (GestionProjetRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionProjet!com.esprit.service.gestionProjet.GestionProjetRemote");
			GestionLocaleRemote gestionLocaleRemote = (GestionLocaleRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionLocale!com.esprit.service.gestionLocal.GestionLocaleRemote");

			GestionActiviteRemote gestionActiviteRemote = (GestionActiviteRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionActivite!com.esprit.service.gestionActivite.GestionActiviteRemote");

			GestionUniteRemote gestionUniteRemote = (GestionUniteRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionUnite!com.esprit.service.gestionUnite.GestionUniteRemote");

			
			Unite unite=new Unite();
			unite.setNomUnite("mobile");
			
			gestionUniteRemote.save(unite);
			
			
			Unite unite1=new Unite();
			unite1.setNomUnite("EspritOnLine");
			
			gestionUniteRemote.save(unite1);
			
			
			Enseignant enseignant = new Enseignant();
			enseignant.setMatriculeEnseigant("mat02");
			enseignant.setNom("ramla");
			enseignant.setCin(0123456);
			enseignant.setCodePostal(2013);
			enseignant.setPrivilege(1);
			enseignant.setNumTelephone(98989898);
			enseignant.setLogin("a");
			enseignant.setPassword("a");

			gestionEnseignantRemote.save(enseignant);

			Projet projet = new Projet();
			projet.setLibelleProjet("proj02");
			projet.setDescription("description");

			gestionProjetRemote.addProject(projet);

			Activite activite = new Activite();
			activite.setLibelleActivite("activite1");
			activite.setDescription("description");

			gestionActiviteRemote.addActivite(activite);
			
			Activite activite1 = new Activite();
			activite1.setLibelleActivite("activite2");
			activite1.setDescription("description2");

			gestionActiviteRemote.addActivite(activite1);

			Locale locale = new Locale();
			locale.setLibelleLocal("D12");

			gestionLocaleRemote.createLocal(locale);
			Locale locale2 = new Locale();
			locale2.setLibelleLocal("D13");

			gestionLocaleRemote.createLocal(locale2);
			
			
			

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
