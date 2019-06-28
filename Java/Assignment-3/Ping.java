/* Assignment -3

Descrition : This program will ping any host ( given as input ) and computes 
							the median of the time taken to ping.
Uses the system ping utility.

Input : URL of the host ( Eg:  google.com or yahoo.com ) 
				and number of times (n) to ping for median calculation
Output: 'n' lines of response times in millisecs and median 


*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.*;
import java.util.*;
public class Ping {
  public static void runCommand(String command,int times) {
		try
		{
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(p.getInputStream()));
			ArrayList<Float> f=new ArrayList<>();
			String s  = "";
			String ms = "";
			float pp  = 0;
			int len = times, flag = 0;
			while ((s = inputStream.readLine()) != null)
			{
				if(Pattern.matches(".*time=.*",s)) 
				{
					String ss[] = s.split(" ");
				    ms=ss[7].substring(5);
				    System.out.println(s+"\n"+ms);
					f.add(Float.parseFloat(ms));
					flag = 1;
				}
			}
			Collections.sort(f);
			if (flag == 0)
			 System.out.println("unreachable");  // if host is unavailable
			else
			{   if(len%2 == 0)
				System.out.println( (float) (f.get(len/2) + f.get(len/2 -1)) /2  );
				else
				System.out.println( (float) f.get(len/2) );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter url of host");
		String url = sc.next();
		System.out.println("enter number of times for ping (eg:1-20)");
		int t = sc.nextInt();
		runCommand("ping -c"+t+" "+url,t);
	}
}