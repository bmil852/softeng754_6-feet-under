package nz.ac.auckland.marketcomprehension;

import java.util.List;
import nz.ac.auckland.businessidea.Keyword;

public interface APICommunicator {

	List<Document> searchAndCategorize(List<Keyword> weightedKeywords);
}
