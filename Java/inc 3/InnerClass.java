class A
{
    A()
    {
        System.out.println("constructor of A:");
    }
    class B
    {
        B ()
        {
            System.out.println("constructor of B:");
        }
    }
}
class C
{
    C()
    {
        System.out.println("constructor of C:");
    }
    class D extends A.B
    {
        D()
        {
            new A().super();
            System.out.println("constructor of D:");

        }
    }
}
class InnerClass
{
    public static void main(String args[])
    {
        new C().new D();
    }
}