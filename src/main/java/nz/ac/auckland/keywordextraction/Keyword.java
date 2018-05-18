package nz.ac.auckland.keywordextraction;

public class Keyword {

	private String _word;
	private int _weight;
	
	public Keyword(String word, int weight) {
		_word = word;
		_weight = weight;
	}
	
	public String getWord() {
		return _word;
	}
	
	public int getWeight() {
		return _weight;
	}
	
	public void updateWeight(int newWeight) {
		_weight = newWeight;
	}
}
