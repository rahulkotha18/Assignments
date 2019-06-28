package kotha.assignment.data;
public class Data
{
	int n;
	char ch;
	public void getInstVar()
	{
		System.out.println("int variable:"+n);
		System.out.println("char variable:"+ch);	
	}

	/* Error : local variables must be initialized in java since there is 
		        no concept of garbage values in java
	
    public void printLocVar()
	{
		int n;
		char ch;
		System.out.println("int variable:"+n);
		System.out.println("char variable:"+ch);	
	}
	*/
}
