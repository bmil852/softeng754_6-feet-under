package nz.ac.auckland.businessidea;

public class Keyword {

	private String _word;
	private double _weight;
	
	public Keyword(String word, double weight) {
		_word = word;
		_weight = weight;
	}
	
	public String getWord() {
		return _word;
	}
	
	public double getWeight() {
		return _weight;
	}
	
	public void updateWeight(double newWeight) {
		_weight = newWeight;
	}
}
