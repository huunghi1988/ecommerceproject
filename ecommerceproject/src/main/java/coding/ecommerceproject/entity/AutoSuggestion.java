package coding.ecommerceproject.entity;


public class AutoSuggestion {
	private int id;
	private String keyword;
	public AutoSuggestion(int id, String keyword) {
		super();
		this.id = id;
		this.keyword = keyword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	

	
}
