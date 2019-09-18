/* Assignment -2

Question: Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive).
Write time and space complexity of your solution as comments in the source file.

Time Complexity : worst case : O(n)  , n=length of the input String
                  best case  : O(n)  , n=26
Space Complexity :O(1) 

*/
import java.util.Scanner;
class Pangram
{
    public boolean isPangram(String str)
    {
        boolean b[] = new boolean[26];
        int count =0, index =0;
        str=str.toLowerCase().replaceAll("\\s",""); 
        for(char i:str.toCharArray())
        {
            index=i-'a';
            if(index>=0 && index<26)
            {
                if(!b[index])
                {
                    b[index]=true;
                    count++;
                }
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
        Pangram obj = new Pangram();
        if (obj.isPangram(str))
            System.out.println("\n Entered String is a pangram");
        else
            System.out.println("\n Enetered String is not a pangram");
    }
}