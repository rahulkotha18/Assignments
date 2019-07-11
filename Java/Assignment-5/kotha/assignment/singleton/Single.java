package kotha.assignment.singleton;
public class Single
{
	String name;
	public static Single getObject(String str)
	{
        Single obj=new Single();
		obj.name=str;	
        return obj;
	}
    public void getName()
    {
        System.out.println("Name is :"+name);
    }
}

