import java.util.Arrays;
class Vampire
{
	public static boolean isOddLength(int num)
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
		int num=1260,counts=1,i=0,j=0,k=0;
		while(counts<=100)
		{
			if (isOddLength(num))
			{	num++;
				continue;
			}
			for(i=1;i<Math.sqrt(num);i++)
			{

				j=num/i;
				if (num%i==0)
				{
					if(verify(num,i,j))
					{	System.out.println(counts+"  "+num);
						counts++;
						break;
					}
				}

			}
			num++;
		}
	}

}


// 1  1260
// 2  1395
// 3  1435
// 4  1530
// 5  1827
// 6  2187
// 7  6880
// 8  102510
// 9  104260
// 10  105210
// 11  105264
// 12  105750
// 13  108135
// 14  110758
// 15  115672
// 16  116725
// 17  117067
// 18  118440
// 19  120600
// 20  123354
// 21  124483
// 22  125248
// 23  125433
// 24  125460
// 25  125500
// 26  126027
// 27  126846
// 28  129640
// 29  129775
// 30  131242
// 31  132430
// 32  133245
// 33  134725
// 34  135828
// 35  135837
// 36  136525
// 37  136948
// 38  140350
// 39  145314
// 40  146137
// 41  146952
// 42  150300
// 43  152608
// 44  152685
// 45  153436
// 46  156240
// 47  156289
// 48  156915
// 49  162976
// 50  163944
// 51  172822
// 52  173250
// 53  174370
// 54  175329
// 55  180225
// 56  180297
// 57  182250
// 58  182650
// 59  186624
// 60  190260
// 61  192150
// 62  193257
// 63  193945
// 64  197725
// 65  201852
// 66  205785
// 67  211896
// 68  213466
// 69  215860
// 70  216733
// 71  217638
// 72  218488
// 73  226498
// 74  226872
// 75  229648
// 76  233896
// 77  241564
// 78  245182
// 79  251896
// 80  253750
// 81  254740
// 82  260338
// 83  262984
// 84  263074
// 85  284598
// 86  284760
// 87  286416
// 88  296320
// 89  304717
// 90  312475
// 91  312975
// 92  315594
// 93  315900
// 94  319059
// 95  319536
// 96  326452
// 97  329346
// 98  329656
// 99  336550
// 100  336960