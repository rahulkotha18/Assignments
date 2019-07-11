import java.util.*;
class Vampire
{
	public static boolean odds(int num)
	{
		String st=String.valueOf(num);
		if(st.length()%2!=0)
			return true;
		return false;
	}
	
	public static boolean verify(int num,int k,int j)
	{

		String str=String.valueOf(num);
		int len=str.length();

		String a=String.valueOf(k);
		String b=String.valueOf(j);
		int l1=a.length();
		int l2=b.length();
		int i=0;
		if ( l1!=len/2 ||l2!=len/2  )
			return false;

		if ( a.charAt(l1-1)=='0' && b.charAt(l1-1)=='0' )
			return false;

		char[] org=str.toCharArray();
		char[] mix=(a+b).toCharArray();
		Arrays.sort(org);
		Arrays.sort(mix);
		return Arrays.equals(org,mix);
	}

	public static void main(String...args)
	{
		int num=1260,c=1,i=0,j=0,k=0;
		while(c<=100)
		{
			if (odds(num))
			{	num++;
				continue;
			}
			for(i=1;i<Math.sqrt(num);i++)
			{

				j=num/i;
				if (num%i==0)
				{
					if(verify(num,i,j))
					{	System.out.println(c+"  "+num);
						c++;
						break;
					}
				}

			}
			num++;
		}
	}

}


// public class Permutation 
// { 
// 	public static void main(String[] args) 
// 	{ 
// 		String str = "1260"; 
// 		int n = str.length(); 
// 		Permutation permutation = new Permutation(); 
// 		permutation.permute(str, 0, n-1); 
// 	} 
// 	private void permute(String str, int l, int r) 
// 	{ 
// 		if (l == r) 
// 			System.out.println(str.length()); 
// 		else
// 		{ 
// 			for (int i = l; i <= r; i++) 
// 			{ 
// 				str = swap(str,l,i); 
// 				permute(str, l+1, r); 
// 				str = swap(str,l,i); 
// 			} 
// 		} 
// 	} 

// 	public String swap(String a, int i, int j) 
// 	{ 
// 		char temp; 
// 		char[] charArray = a.toCharArray(); 
// 		temp = charArray[i] ; 
// 		charArray[i] = charArray[j]; 
// 		charArray[j] = temp; 
// 		return String.valueOf(charArray); 
// 	} 

// } 
// */