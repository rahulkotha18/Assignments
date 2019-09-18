import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
class KYC
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
            Calendar c1=Calendar.getInstance();
            Calendar c2=Calendar.getInstance();
            
            StringTokenizer st = new StringTokenizer(input[0],"-");
            int x[]= new int[3];
            int i=0;
            while(st.hasMoreTokens())
                x[i++] = Integer.parseInt(st.nextToken());

            c1.set(Calendar.DATE,x[0]);
            c1.set(Calendar.MONTH,x[1]-1);
            c1.set(Calendar.YEAR,x[2]);


            st = new StringTokenizer(input[1],"-");
            int y[]= new int[3];
            i=0;
            while(st.hasMoreTokens())
                y[i++] = Integer.parseInt(st.nextToken());

            c2.set(Calendar.DATE,y[0]);
            c2.set(Calendar.MONTH,y[1]-1);
            c2.set(Calendar.YEAR,y[2]);
            Date currDate=c2.getTime();
            if(c1.getTime().after(currDate))
            {
                System.out.println("No ranges");
                continue;
            }
            c1.set(Calendar.YEAR, y[2]);

            c1.add(Calendar.DATE,-30);
            System.out.print(df.format(c1.getTime())+" ");
            
            c1.add(Calendar.DATE,60);
            
            if(c1.getTime().after(currDate))
                System.out.println(df.format(currDate));
            else
                System.out.println(df.format(c1.getTime()));
        }
    }

}

