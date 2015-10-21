package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import bean.PersonagemDiff;

public class PersonagemDiffChainedComparator implements Comparator<PersonagemDiff> {

	private List<Comparator<PersonagemDiff>> listPersonagemComparators;

	public PersonagemDiffChainedComparator(Comparator<PersonagemDiff>... comparators) {
		this.listPersonagemComparators = Arrays.asList(comparators);
	}

	@Override
	public int compare(PersonagemDiff o1, PersonagemDiff o2) {
		for (Comparator<PersonagemDiff> c : listPersonagemComparators) {
			int res = c.compare(o1, o2);
			if (res != 0) {
				return res;
			}
		}
		return 0;
	}

}
