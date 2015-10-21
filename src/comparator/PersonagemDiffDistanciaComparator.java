package comparator;

import java.util.Comparator;

import bean.PersonagemDiff;

public class PersonagemDiffDistanciaComparator implements
		Comparator<PersonagemDiff> {

	@Override
	public int compare(PersonagemDiff p1, PersonagemDiff p2) {
		if (p1.getDistancia() > p2.getDistancia())
			return -1;
		else if (p1.getDistancia() < p2.getDistancia())
			return 1;

		return 0;

	}

}
