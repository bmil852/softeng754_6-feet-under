package nz.ac.auckland.marketcomprehension;

import java.util.List;

import nz.ac.auckland.businessidea.Keyword;

public class MarketService {

	private APICommunicator _apiCommunicator;
	private List<Document> _searchResults;
	
	public MarketService(APICommunicator apiCommunicator) {
		_apiCommunicator = apiCommunicator;
	}
	
	public void performSearch(List<Keyword> weightedKeywords) {
		_searchResults = _apiCommunicator.callAllAPIs(weightedKeywords);
	}
	
	public List<Document> getSearchResults() {
		return _searchResults;
	}
}
