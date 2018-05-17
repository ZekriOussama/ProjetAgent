package behaviours_Bibliotheque;

import agents.Bibliotheque;
import agents.Etudiant;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class EnvoyerDisponibilite extends OneShotBehaviour{
	Bibliotheque agent;
	
	public EnvoyerDisponibilite(Bibliotheque b){
		this.agent = b;
	}

	public void action() {
		
		
		ACLMessage reponse = new ACLMessage(ACLMessage.INFORM);
		reponse.setContent(agent.getDisponibilite());
		reponse.addReceiver(Bibliotheque.IDENTIFIANT);
		agent.send(reponse);
		
	}

}