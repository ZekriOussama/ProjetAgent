package behaviours_Etudiant;

import agents.Etudiant;
import agents.Bibliotheque;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import outils.AgentLogger;

public class EnvoyerTitre extends OneShotBehaviour{
	Etudiant agent;
	
	public EnvoyerTitre(Etudiant a){
		this.agent = a;
	}

	public void action() {
		
		
		ACLMessage reponse = new ACLMessage(ACLMessage.INFORM);
		reponse.setContent(agent.getTitre());
		reponse.addReceiver(Bibliotheque.IDENTIFIANT);
		agent.send(reponse);
		
	}

}
