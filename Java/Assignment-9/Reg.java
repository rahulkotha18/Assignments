import java.util.regex.*;
import java.util.Scanner;
class Reg
{
    public static void main(String...args)
    {
        Scanner sc=new Scanner(System.in);
        Pattern p = Pattern.compile("^[A-Z].*[.]");
        while(true)
        {       
        System.out.println("Enter Sentence: or D to stop");
        String s=sc.nextLine();
        if("D".equals(s))
            break;
        Matcher m = p.matcher(s);
        boolean b = m.matches();
        System.out.println(b);
        //System.out.println ( Pattern.matches( "^[A-Z].*[.]" ,s) ); 
        }
        sc.close();
    }
}
