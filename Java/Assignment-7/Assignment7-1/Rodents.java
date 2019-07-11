abstract class Rodent
{
    int legs;
    public Rodent()
    {
        System.out.println("I am from  Rodent abstract class");
    }
    abstract public void speed();
    abstract public void about();
}

class Mouse extends Rodent
{
    public Mouse()
    {
        legs=4;
        System.out.println("and this  is mouse");
    }
     public void speed()
     {
         System.out.println("I am faster than other 2");
     }
     public void about()
     {
         System.out.println("I have"+legs+" legs with tail and am vehicle of lord ganesha!!");
     }
}

class Gerbil extends Rodent
{
    public Gerbil()
    {
        legs=4;
        System.out.println("and this is Gerbil");
    }
     public void speed()
     {
         System.out.println("I am not faster");
     }
     public void about()
     {
         System.out.println("I have no tail and no one knows much about  me and i have"+legs+" legs");
     }
}

class Hamster extends Rodent
{
    public Hamster()
    {
        legs=4;
        System.out.println("and this is Hamster");
    }
     public void speed()
     {
         System.out.println("I am bit lazy of all");
     }
     public void about()
     {
         System.out.println("I am  domesticated in some parts of world and i ahve "+legs+" legs");
     }
}


class TestRodents
{
    public static void main(String args[])
    {
        Rodent[] obj=new Rodent[3];
        obj[0]=new Mouse();
        obj[0].speed();
        obj[0].about();
        System.out.println("\n");
        obj[1]=new Gerbil();
        obj[1].speed();
        obj[1].about(); 
        System.out.println("\n");
        obj[2]=new Hamster();
        obj[2].speed();
        obj[2].about();             
        
    }
}