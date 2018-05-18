package nz.ac.auckland.businessidea;

import java.util.Collections;
import java.util.List;

public class BusinessIdeaService {

	private KeywordExtractor _keywordExtractor;
	private List<Keyword> _keywords;
	
	public BusinessIdeaService(KeywordExtractor extractor) {
		_keywordExtractor = extractor;
	}
	
	public void extractFrom(String businessIdea) {
		_keywords = _keywordExtractor.extractFrom(businessIdea);
	}
	
	public List<Keyword> getKeywords() {
		return _keywords;
	}
	
	public void swapOrder(int to, int from) {
		int toIndex = to-1;
		int fromIndex = from-1;
		if (toIndex >= 0 && fromIndex >= 0) {
			Collections.swap(_keywords, to-1, from-1);
		}
	}
	
	public void updateWeight(int keyword, int newWeight) {
		if (newWeight > 0) {
			_keywords.get(keyword-1).updateWeight(newWeight);
		}
	}
	
	public void addKeyword(String newWord, int newWeight) {
		if (newWord.length() > 0 && newWeight > 0) {
			_keywords.add(new Keyword(newWord, newWeight));
		}
	}
	
	public void removeKeyword(int keyword) {
		int index = keyword-1;
		if (index >= 0 && index < _keywords.size()) {
			_keywords.remove(index);
		}
	}
}
