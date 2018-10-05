import java.util.*;
class Sorted
{
public static void main(String args[])
{
int k=0,m=0,i;
Scanner sc=new Scanner(System.in);
//System.out.println("size of array-1");
int n1=sc.nextInt();
//System.out.println("size of array-2");
int n2=sc.nextInt();
int []a=new int[n1];
int []b=new int[n2];
int []c=new int[n1+n2];


       for(i=0;i<n1;i++)
	    {
	      //System.out.println("enter the elments of an array1");
	      a[i]=sc.nextInt();
	     }
       for(i=0;i<n2;i++)
	    {
              //System.out.println("enter the elments of an array2");
	      b[i]=sc.nextInt();
	    }
		//System.out.println(n1+n2);
for(i=0;k<a.length&&m<b.length;i++)
	{
	 if(a[k]>=b[m])
	 {
	 	c[i]=b[m];
	 	m++;
	 	 
	 }
	 else
	 {
	 	c[i]=a[k];
	 	k++;
		
	 }
   }
   while(k<a.length)
	{
	   c[i++]=a[k++];
	}
	while(m<b.length)
	{
	   c[i++]=b[m++];
	}
   int g=i;
     for(i=0;i<g;i++)
     {
    	 if(i<g-1)
	   System.out.print(c[i]+",");
    	 else
    		System.out.println(c[i]);
     }
}
}
