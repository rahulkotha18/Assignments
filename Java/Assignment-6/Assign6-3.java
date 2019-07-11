class Assign3
{
    private String name;
    public Assign3(String name)
    {
        this.name=name;
        System.out.println("Name: "+name);
    }
    public static void main(String args[])
    {  
        for(int i=0;i<10;i++)
            new Assign3("No."+i);
    }
}