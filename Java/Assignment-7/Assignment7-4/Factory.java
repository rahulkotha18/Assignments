import java.util.Scanner;
interface  cycle
{
    void about();
}
interface cyclefactory
{
    cycle getCycle(String name);
}

class bicycle implements cycle
{
    public void about()
    {
        System.out.println("This is bicycle");
    }
}
class unicycle implements cycle
{
    public void about()
    {
        System.out.println("This is unicycle");
    }
}
class tricycle implements cycle
{
    public void about()
    {
        System.out.println("This is tricycle");
    }
}

class getcyclefactory implements cyclefactory
{
    public cycle getCycle(String name)
    {
        if (name.equalsIgnoreCase("bicycle"))
            return new bicycle();
        if (name.equalsIgnoreCase("unicycle"))
            return new unicycle();
        if (name.equalsIgnoreCase("tricycle"))
            return new tricycle();
        return null;
    }
}

class Riders
{
    public static void main(String...args)
    {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the type of cycle:");
    new getcyclefactory().getCycle(sc.nextLine()).about();
    }
}