package comparator;

import java.util.Comparator;

import bean.Personagem;

public class PersonagemIdadeComparator implements Comparator<Personagem>{

	@Override
	public int compare(Personagem p1, Personagem p2) {
		if(p1.getIdade() > p2.getIdade())
			return 1;
		if(p1.getIdade() < p2.getIdade())
			return -1;
		
		return 0;
	}


}
