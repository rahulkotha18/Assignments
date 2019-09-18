import java.util.Scanner;
class Ex1 extends Exception
{
    public Ex1(String s)
    {
        super(s);
    }
}
class Ex2 extends Exception
{
    public Ex2(String s)
    {
        super(s);
    }
}
class Ex3 extends Exception
{
    public Ex3(String s)
    {
        super(s);
    }
}
class Exceptions
{
    public static void verify(int a,int b,int c) throws Ex1,Ex2,Ex3
    {
        if (a==0)
            throw new Ex1("ZeroValueException\n");
        if (b<0)
            throw new Ex2("NegativeValueException\n");
        if (c%2!=0)
            throw new Ex3("OddNumberException\n");
        String p=null;
        p.equals("rahul");
    }
    public static void main(String args[])
    {
        System.out.println("Enter a,b,c : a!=0 ,b>0 ,c as even");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        try {
            verify(a,b,c);
        }
        catch(Ex1|Ex2|Ex3 e)
        {
            System.out.println(e);
        }
        catch(Exception e)
        {
          System.out.println(e+":\tcompared to null");   
        }
        finally
        {
            System.out.println("Finally block: ");
        }
    }
}