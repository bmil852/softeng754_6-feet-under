package nz.ac.auckland.marketcomprehension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nz.ac.auckland.businessidea.Keyword;

public class MarketService {

	private APICommunicator _apiCommunicator;
	private List<Document> _searchResults;
	
	public MarketService(APICommunicator apiCommunicator) {
		_apiCommunicator = apiCommunicator;
	}
	
	public void searchAndCategorize(List<Keyword> weightedKeywords) {
		_searchResults = _apiCommunicator.searchAndCategorize(weightedKeywords);
	}
	
	public List<Document> getSearchResults() {
		return _searchResults;
	}
	
	public Set<Category> getResultCategories() {
		Set<Category> allCategories = new HashSet<Category>();
		for (Document d : _searchResults) {
			allCategories.add(d.getCategory());
		}
		return allCategories;
	}
}
