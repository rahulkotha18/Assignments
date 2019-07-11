class Assign4
{
    private String name;
    public Assign4(String name)
    {
        this.name=name;
        System.out.println("Name: "+name);
    }
    public static void main(String args[])
    {  
        Assign4[] obj=new Assign4[10];
        for(int i=0;i<10;i++)
        {
            obj[i]=new Assign4("object at Index:"+i);
        }
    }
}