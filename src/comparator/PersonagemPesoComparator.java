package comparator;

import java.util.Comparator;

import bean.Personagem;

public class PersonagemPesoComparator implements Comparator<Personagem> {

	@Override
	public int compare(Personagem p1, Personagem p2) {
		if(p1.getPeso() > p2.getPeso())
			return 1;
		if(p1.getPeso() < p2.getPeso())
			return -1;
		
		return 0;
	}

	

}
