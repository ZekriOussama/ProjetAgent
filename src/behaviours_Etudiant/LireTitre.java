package behaviours_Etudiant;

import agents.Etudiant;
import jade.core.behaviours.OneShotBehaviour;

public class LireTitre extends OneShotBehaviour {

Etudiant agent;
	
	public LireTitre(Etudiant e){
		this.agent = e;
	}
	public void action() {
		String titre = agent.lireTitre();
		agent.setTitre(titre);
		
	}

}
