package nz.ac.auckland.marketcomprehension;

public class Document {

	private String _documentText;
	private Category _category;
	
	public Document(String text, Category category) {
		_documentText = text;
		_category = category;
	}
	
	public String getDocumentText() {
		return _documentText;
	}
	
	public Category getCategory() {
		return _category;
	}
}
