import java.util.Scanner;

class Solution
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int i=0;
		int sum=0;
		int[] a=new int[N];
		while(sc.hasNext())
		{
			a[i]=sc.nextInt();
			i++;
		}
		for(int j=0;j<n;j++)
		{
			for(int k=j+1;k<N;k++)
			{
				for(int l=k+1;l<N;l++)
				{
					if((a[j]+a[k]+a[l])==0)
					sum++;
				}
			}
		}
	}
}