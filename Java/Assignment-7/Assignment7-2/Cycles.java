import java.util.Scanner;
class Cycle
{
   int wheels;
   Cycle()
   {
       System.out.println("Cycle : super class");
   }
   public void setWheels(int wheels)
   {
       this.wheels=wheels;
   }
   public int getWheels()
   {
       return this.wheels;
   }
//    public void balance()
//    {
//        System.out.println("Balance of cycle super class");
//    }
}

class UniCycle extends Cycle
{
    public UniCycle()
    {
        wheels=1;
        System.out.println("UniCycle : sub class");
    }
    public void balance()
    {
        System.out.println("Unicycle balance method");
    }
}

class BiCycle extends Cycle
{
    public BiCycle()
    {
        wheels=2;
        System.out.println("BiCycle : sub class");
    }
    public void balance()
    {
        System.out.println("Bicycle balance method");
    }
}

class TriCycle extends Cycle
{
    public TriCycle()
    {
        System.out.println("TriCycle : sub class");
    }

}

class Testing
{
    public static void main(String args[])
    {
       
        Cycle[] obj=new Cycle[3];
        obj[0] = new UniCycle();
        System.out.println();
        obj[1] = new BiCycle();
        System.out.println();
        obj[2] = new TriCycle();
        System.out.println();
        try
        {
        //upcast  --- error : Cycle class refernce has no method signature of 'balance'
        // obj[0].balance();
        // obj[1].balance();
        // obj[2].balance();
        System.out.println();
        //downcast
        ((UniCycle)obj[0]).balance();
        ((BiCycle)obj[1]).balance();
       // ((TriCycle)obj[2]).balance();
        }
        catch(Exception e)
        {
            System.out.println("Class cast exception occured");
        }
    }
}