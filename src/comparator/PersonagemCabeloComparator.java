package comparator;

import java.util.Comparator;

import bean.Personagem;

public class PersonagemCabeloComparator implements Comparator<Personagem> {

	@Override
	public int compare(Personagem p1, Personagem p2) {
		if(p1.getCabelo() > p2.getCabelo())
			return 1;
		if(p1.getCabelo() < p2.getCabelo())
			return -1;
		
		return 0;
	}



}
