/* Assignment -1
Descrition : This java program  search through the home directory and look for files that match 
a regular expression. The program take inputs repeatedly and  prints out the full absolute path 
of the matching files found.
To stop the program give input as 'D'
Input : a regular expression of the file
Output: all files matching regular expression with their absolute paths
*/
import java.io.File;
import java.util.regex.*;
import java.util.Scanner;
public class regfile
{

public static void fileFinder(String ff , String ref)
{
	File folder = new File(ff);
	for(File f1:folder.listFiles())
{   
	if(f1.isDirectory())
		fileFinder(f1.getAbsolutePath(),ref);
	else
		if (Pattern.matches(ref,f1.getName()))
		  System.out.println(f1.getAbsolutePath());
   }
}

public static void main(String...args)
{
	boolean run = true;
	Scanner  sc = new Scanner(System.in);
	String ref  = "";
	while(run)
	{
		System.out.println("Enter regex of target (eg: .*.java  ) or \nEnter D to quit");
		ref = sc.nextLine();
		if(ref.equals("D"))
			break;
		else
		fileFinder("/home",ref);
	}
	System.out.println("bye!!");
}
}