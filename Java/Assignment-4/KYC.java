import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
public class KYC
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int t = Integer.parseInt(br.readLine());
        while(t>0)
        {
            t--;
            String input[] = br.readLine().split(" ");
            Calendar applyDate=Calendar.getInstance();
            Calendar renewalDate=Calendar.getInstance();
            
            StringTokenizer st = new StringTokenizer(input[0],"-");
            int apply[]= new int[3];
            int i=0;
            while(st.hasMoreTokens())
                apply[i++] = Integer.parseInt(st.nextToken());

            applyDate.set(Calendar.DATE,apply[0]);
            applyDate.set(Calendar.MONTH,apply[1]-1);
            applyDate.set(Calendar.YEAR,apply[2]);


            st = new StringTokenizer(input[1],"-");
            int renewal[]= new int[3];
            i=0;
            while(st.hasMoreTokens())
                renewal[i++] = Integer.parseInt(st.nextToken());

            renewalDate.set(Calendar.DATE,renewal[0]);
            renewalDate.set(Calendar.MONTH,renewal[1]-1);
            renewalDate.set(Calendar.YEAR,renewal[2]);

            Date currDate=renewalDate.getTime();

            if(applyDate.getTime().after(currDate))
            {
                System.out.println("No ranges");
                continue;
            }
            applyDate.set(Calendar.YEAR, renewal[2]);

            applyDate.add(Calendar.DATE,-30);
            System.out.print(df.format(applyDate.getTime())+" ");
            
            applyDate.add(Calendar.DATE,60);
            
            if(applyDate.getTime().after(currDate))
                System.out.println(df.format(currDate));
            else
                System.out.println(df.format(applyDate.getTime()));
        }
    }

}

