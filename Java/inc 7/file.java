import java.io.*;
import java.util.*;
class file
{
    public static void main(String args[]) throws Exception
    {
        File f=null;
        FileReader fr=null;
        FileWriter fout=null;
        PrintWriter pw=null;
        try
        {
            f=new File(args[0]);
            if(f!=null)
            {
                int i=0;
                char ch='\0';
                HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
                fr=new FileReader(f);
                while( (i=fr.read()) != -1 )
                {
                     ch=(char)i;
                    if( ch !=' ' && ch!='\t' && ch!='\n' )
                    {   
                        if (hm.containsKey(ch))
                            hm.put(ch,(int)hm.get(ch)+1);
                        else
                            hm.put(ch,1);
                        System.out.print((char)i);
                    }
                }
                System.out.println();
                fout= new FileWriter("results.txt");
                pw=new PrintWriter(fout);
                pw.printf("\nCharacter   Occurances\n");
                for (Map.Entry<Character,Integer> entry : hm.entrySet())
                pw.printf("   " + (char)entry.getKey() +"  \t  \t" + (int)entry.getValue() +"\n" ); 
            }
            else
            {
                System.out.println("Given file does not exists or cannot read");
            }
        }
        catch(Exception e)
        {
            System.out.print("exception occured: input file doesnot exists\n");
        }
        finally
        {
            System.out.println("result stored in results.txt file");
            pw.close();
            fout.close();
            fr.close();
        }
    }
}
