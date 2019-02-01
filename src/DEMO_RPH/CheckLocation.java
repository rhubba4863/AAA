package DEMO_RPH;


public class CheckLocation {
	//System.out.print("Opened up another");
	public void Location(String current_Title, String desired_Page_Title) {
		//System.out.print("\n 2: Opened up another");
		
		if(current_Title.equalsIgnoreCase(desired_Page_Title))
		{
			System.out.print("\n1: Test Success - at page: ");
			System.out.print(current_Title + " AND " + desired_Page_Title);	
		}
		else 
		{
			System.out.print("\n2: Test Failed RPH - At this page: ");
			System.out.print(current_Title + " AND " + desired_Page_Title);
		}	
	}

	/*FUTURE STEPS
	Chrome
	Mclaren
	Dev Environment
	Overview Page
	Follow navigation steps
	*/
	
}
