public class ConstructorOverload {

private String name;
public ConstructorOverload()
{
    this("rahul kotha");
    System.out.println("No arguments constructor");
}
public ConstructorOverload(String name)
{
    System.out.println("String argument constructor");
    this.name=name;
    System.out.println("name : "+name);
}

public static void main(String...args)
{
    ConstructorOverload a=new ConstructorOverload();
}
}
