package nz.ac.auckland.marketcomprehension;

import java.util.List;
import nz.ac.auckland.keywordextraction.Keyword;

public interface APICommunicator {

	List<Document> searchAndCategorize(List<Keyword> weightedKeywords);
	
	String labelCategory(List<Document> documentsInCategory);
	
	String summarizeCategory(List<Document> documentsInCategory);
}
