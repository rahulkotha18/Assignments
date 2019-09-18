
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Ping {
  public static void runCommand(String command,int numberoftimes)
  {
		try
		{
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(p.getInputStream()));
			ArrayList<Float> f=new ArrayList<>();
			String response  = "";
			String pingtime = "";
			int len = numberoftimes;
			boolean unreachable=false;
			while ((response = inputStream.readLine()) != null)
			{
				if(Pattern.matches(".*time=.*",response)) 
				{
					String ss[] = response.split(" ");
				    pingtime=ss[7].substring(5);
				    System.out.println(pingtime+" ms");
					f.add(Float.parseFloat(pingtime));
					unreachable=true;
				}
			}
			Collections.sort(f);
			if (!unreachable)
			 System.out.println("unreachable");
			else
			{   
				float medainTime=0;
				if(len%2 == 0)
					medainTime=( f.get(len/2) + f.get(len/2 -1) ) /2 ;
				else
					medainTime=(float) f.get(len/2);
				System.out.println("Median of time taken to ping host:"+medainTime+" ms");
			}
		}
		catch (Exception e)
		{
			System.out.println(" error while executing ping command");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter url of host");
		String url = sc.next();
		System.out.println("enter number of times for ping (eg:1-20)");
		int numberoftimes = sc.nextInt();
		runCommand("ping -c"+numberoftimes+" "+url,numberoftimes);
	}
}
