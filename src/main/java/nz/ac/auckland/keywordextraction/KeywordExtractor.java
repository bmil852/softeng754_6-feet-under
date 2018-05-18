package nz.ac.auckland.keywordextraction;

import java.util.List;

public interface KeywordExtractor {

	public List<Keyword> extractFrom(String businessIdea);
	
}
