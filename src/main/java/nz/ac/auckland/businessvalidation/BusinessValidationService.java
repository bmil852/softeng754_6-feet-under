package nz.ac.auckland.businessvalidation;

import java.util.List;

import nz.ac.auckland.marketcomprehension.Category;

public class BusinessValidationService {

	private List<Category> _categories;
	
	public BusinessValidationService(List<Category> categories) {
		_categories = categories;
	}
	
	public void calculateCategoryPopularities() {
		int corpusSize = 0;
		for (Category c : _categories) {
			corpusSize += c.getCategoryDocuments().size();
		}
		for (Category c : _categories) {
			c.updatePopularity(c.getCategoryDocuments().size() / (corpusSize * 1.0));
		}
	}
	
	public double getPopularity(int categoryNumber) {
		int categoryIndex = categoryNumber-1;
		return _categories.get(categoryIndex).getPopularity();
	}
	
	public void addCategory(Category c) {
		_categories.add(c);
	}
	
	public void setRelevance(int categoryNumber, Relevance relevance) {
		_categories.get(categoryNumber-1).setRelevance(relevance);
	}
	
	public Relevance getRelevance(int categoryNumber) {
		return _categories.get(categoryNumber-1).getRelevance();
	}
	
	public double getOverallMaturity() {
		calculateCategoryPopularities();
		double d = 0.0;
		for (Category c : _categories) {
			d += (c.getRelevance().ordinal() / 4.0) * c.getPopularity();
		}
		return d;
	}
}
