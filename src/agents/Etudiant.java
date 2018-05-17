package agents;

import java.util.Scanner;

import behaviours_Etudiant.EnvoyerTitre;
import behaviours_Etudiant.LireTitre;
import behaviours_Etudiant.RecevoirDisponibiliteLivre;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;

public class Etudiant extends Agent {
	
	
	private static final String Lire_Titre = "lireTitre";
	private static final String Envoyer_Titre = "envoyerTitre";
	private static final String Recevoir_Disonibilite_Livre = "disponibiliteLivre";
	
	public static AID  IDENTIFIANT = new AID("etudiant",AID.ISLOCALNAME);
	
	
	public void setup(){
		FSMBehaviour behaviour = new FSMBehaviour(this);
		
		//Etats
		behaviour.registerFirstState(new LireTitre(this), Lire_Titre);
		behaviour.registerState(new EnvoyerTitre(this), Envoyer_Titre);
		behaviour.registerState(new RecevoirDisponibiliteLivre(this),Recevoir_Disonibilite_Livre );
		
		//Transitions
		behaviour.registerDefaultTransition(Lire_Titre,Envoyer_Titre);
		behaviour.registerDefaultTransition(Envoyer_Titre, Recevoir_Disonibilite_Livre);
	
		
		addBehaviour(behaviour);
		
	}
	
	
	
	private String titre;

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	Scanner sc = new Scanner(System.in);

	public String lireTitre() {

		System.out.println("Veuillez saisir le titre du livre :");
		titre = sc.nextLine();
		return titre;

	}

}
