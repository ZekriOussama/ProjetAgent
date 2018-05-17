package behaviours_Bibliotheque;

import agents.Bibliotheque;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import outils.AgentLogger;

public class TrouverDisponibiliteLivre extends OneShotBehaviour {

Bibliotheque agent;
	
	public TrouverDisponibiliteLivre(Bibliotheque b){
		this.agent = b;
	}

	public void action() {
		String titre = agent.getTitre();
		String disponibilite=agent.trouverDisponibilite(titre);
		agent.setDisponibilite(disponibilite);
	}
}