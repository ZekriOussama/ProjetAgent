package model;

import java.util.ArrayList;
import java.util.List;

public class Livre {
	
	public Livre (String titre, Boolean Disponibilite) {
		this.titre=titre;
		this.disponibility=Disponibilite;
	}

	private String titre;
	private boolean disponibility;

	public boolean getDisponibility() {
		return disponibility;
	}

	public void setDisponibility(boolean disponibility) {
		this.disponibility = disponibility;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}
