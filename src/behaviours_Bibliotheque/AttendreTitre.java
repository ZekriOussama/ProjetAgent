package behaviours_Bibliotheque;

import agents.Bibliotheque;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import outils.AgentLogger;

public class AttendreTitre extends OneShotBehaviour {

Bibliotheque agent;
	
	public AttendreTitre(Bibliotheque b){
		this.agent = b;
	}

	public void action() {
		agent.doWait();
		ACLMessage message = agent.receive();
		AgentLogger.log(message);
		agent.setTitre( (String) message.getContent()  );
	}
}	
