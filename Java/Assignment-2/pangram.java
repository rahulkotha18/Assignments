/* Assignment -2

Descrition : This program checks if the input string contains all the letters of the 
alphabet a-z (case-insensitive).

Input : a String 
Output: pangram or not

Time Complexity : worst case : O(n)  , n=length of the input String
                  best case  : O(n)  , n=26
Space Complexity :O(1) 

*/
import java.util.Scanner;
class pangram
{
    public boolean isPangram(String str)
    {
        boolean b[] = new boolean[26];
        int count =0, index =0;
        str=str.toLowerCase().replaceAll("\\s",""); // trim blanck spaces and tab spaces  and convert 
                                                    // all characters to lower case
        for(char i:str.toCharArray())
        {
            index=i-'a';
            try{
                if(b[index]);
                else
                {
                    b[index]=true;
                    count++;
                }
            }
            catch(Exception e)                    
            {
                System.out.println("only string literals are allowed in the input");
                return false;
            }
            if(count == 26)
                break;
        }
        if(count == 26)
            return true;
        else
            return false;
    }

    public static void main(String...args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String..");
        String str = sc.nextLine();
        pangram obj = new pangram();
        if (obj.isPangram(str))
            System.out.println("its a pangram");
        else
            System.out.println("its not a pangram");
    }
}