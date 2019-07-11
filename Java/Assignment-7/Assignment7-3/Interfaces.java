interface Externals {
	void u();
	void v();
}

interface Internals {
	void w();
	void x();
}

interface Labs {
	void y();
	void z();
}

interface Exams extends Internals,Externals, Labs {
	void zz();
}

class Center {
	String name;
    public Center()
    {
        name="Hyderabad";
    }
	public void getCenter()
    {
        System.out.println("Center is :"+name);
    }
}

class Student extends Center implements Exams
{
	public void u()
    {
        System.out.println("Method from Externals");
    }
	public void v()
    {
         System.out.println("Method from Externals");
    }
	public void w()
    {
         System.out.println("Method from Internals");
    }
	public void x()
    {
         System.out.println("Method from Internals");
    }
	public void y()
    {
         System.out.println("Method from labs");
    }
	public void z()
    {
         System.out.println("Method from labs");
    }
	public void zz()
    {
         System.out.println("Method from Students");
    }
}

class TestingInterfaces
{
    public static void u(Externals obj)
    {
        obj.u();
    }
    public static void w(Internals obj)
    {
        obj.w();
    }
    public static void z(Labs obj)
    {
        obj.z();
    }
    public static void zz(Student obj)
    {
        obj.zz();
    }
	public static void main(String[] args)
    {
	    Student std = new Student();
        u(std);
        w(std);
        z(std);
        zz(std);
	}
}