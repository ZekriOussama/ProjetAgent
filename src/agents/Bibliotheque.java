package agents;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import behaviours_Bibliotheque.AttendreTitre;
import behaviours_Bibliotheque.EnvoyerDisponibilite;
import behaviours_Bibliotheque.TrouverDisponibiliteLivre;
import behaviours_Etudiant.EnvoyerTitre;
import behaviours_Etudiant.LireTitre;
import behaviours_Etudiant.RecevoirDisponibiliteLivre;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;
import model.Livre;


public class Bibliotheque extends Agent {
	
	private String titre ;
	private String disponibilite ;
	


	public String getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	Livre livre1 = new Livre("livre1",false);
	Livre livre2 = new Livre("livre2",false);
	Livre livre3 = new Livre("livre3",false);

	public List<Livre> listeLivres = new ArrayList<Livre>() {{

		listeLivres.add(livre1);
		listeLivres.add(livre2);
		listeLivres.add(livre3);

	}};


	private static final String Attendre_Titre = "attendreTitre";
	private static final String Trouver_Disponibilite_Livre = "TrouverDisponibiliteLivre";
	private static final String Envoyer_Disponibilite_Livre = "envoyerDisponibilite";

	public static AID IDENTIFIANT = new AID("bibliotheque", AID.ISLOCALNAME);

	public void setup(){

		Livre livre1 = new Livre("livre1",false);
		Livre livre2 = new Livre("livre2",false);
		Livre livre3 = new Livre("livre3",false);

		List<Livre> listeLivres = new ArrayList<Livre>();

		listeLivres.add(livre1);
		listeLivres.add(livre2);
		listeLivres.add(livre3);

		FSMBehaviour behaviour = new FSMBehaviour(this);

		//Etats
		behaviour.registerFirstState(new AttendreTitre(this), Attendre_Titre);
		behaviour.registerState(new TrouverDisponibiliteLivre(this), Trouver_Disponibilite_Livre);
		behaviour.registerState(new EnvoyerDisponibilite(this), Envoyer_Disponibilite_Livre);

		//Transitions
		behaviour.registerDefaultTransition(Attendre_Titre,Trouver_Disponibilite_Livre);
		behaviour.registerDefaultTransition(Trouver_Disponibilite_Livre,Envoyer_Disponibilite_Livre);

		addBehaviour(behaviour);

	}

	public  String trouverDisponibilite (String titre) {
		for(Livre item :listeLivres) {
			if (item.getTitre().equalsIgnoreCase(titre) && item.getDisponibility()==true )
				return("disponible");
			else
				return ("livre indisponible");


		}
		return ("livre indisponible");

	}
}


