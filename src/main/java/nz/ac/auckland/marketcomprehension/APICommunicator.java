package nz.ac.auckland.marketcomprehension;

import java.util.List;
import nz.ac.auckland.businessidea.Keyword;

public interface APICommunicator {

	List<Document> callAllAPIs(List<Keyword> weightedKeywords);
}
