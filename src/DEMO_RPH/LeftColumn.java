package DEMO_RPH;

public class LeftColumn {
	private int order;
	private String X_Location;
	private String Page_Title;

	public LeftColumn() {}
	public LeftColumn(int i, String string1, String string2) {
		order = i;
		X_Location = string1;
		Page_Title = string2;
	}
	
//order on chart
	public void set_Order(int n) {   
		order = n;
	}	
	public int get_Order() {   
		return order;
	}
	
//X_Location
	public void set_X_Location(String n) {   
		X_Location = n;
	}
	public String get_X_Location() {   
		return X_Location;
	}
	
//Title on the page
	public void set_Page_Title(String n) {   
		Page_Title = n;
	}
	public String get_Page_Title() {   
		return Page_Title;
	}	
}
