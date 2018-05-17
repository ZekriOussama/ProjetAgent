package behaviours_Etudiant;

import agents.Etudiant;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import outils.AgentLogger;

public class RecevoirDisponibiliteLivre extends OneShotBehaviour {
	
Etudiant agent;
	
	public RecevoirDisponibiliteLivre(Etudiant e){
		this.agent = e;
	}

	public void action() {
		
		agent.doWait();
		ACLMessage message = agent.receive();
		AgentLogger.log(message);
	}
		


}
	
