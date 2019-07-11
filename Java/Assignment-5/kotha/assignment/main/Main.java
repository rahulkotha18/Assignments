package kotha.assignment.main;

import kotha.assignment.data.Data;
import kotha.assignment.singleton.Single;
public class Main
{
	public static void main(String...args)
	{
        Data d_obj= new Data();
        Single s_obj=Single.getObject("Rahul kotha");
        d_obj.getInstVar();
        s_obj.getName();
	}
}

