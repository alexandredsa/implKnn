package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import bean.Personagem;

public class PersonagemChainedComparator implements Comparator<Personagem> {

	private List<Comparator<Personagem>> listPersonagemComparators;

	public PersonagemChainedComparator(Comparator<Personagem>... comparators) {
		this.listPersonagemComparators = Arrays.asList(comparators);
	}

	@Override
	public int compare(Personagem o1, Personagem o2) {
		for (Comparator<Personagem> c : listPersonagemComparators) {
			int res = c.compare(o1, o2);
			if (res != 0) {
				return res;
			}
		}
		return 0;
	}

}
