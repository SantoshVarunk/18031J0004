package ADS;

import java.util.Arrays;
import java.util.Scanner;

class quicksort1 {
	public static void main(String[] args)
	{	
		Scanner sc=new Scanner(System.in);
		String n=sc.nextLine();
		while(sc.hasNext())
		{
			cutoff=Integer.parseInt(sc.nextLine());
			String s=sc.nextLine();
			String []b=s.split(" ");
			if (b[0].equals("")) {
                System.out.println("[]");
            }
			else
			{
			quickSort2(b,0,b.length-1,cutoff);
			 System.out.println(Arrays.toString(b));
			}
		}	
		
		
	}	
	static int pi,cutoff;
	/*
	 static  void quickSort2 (String[] arr,int low,int high,int cutoff)
	{
		 
		 if((high-low)<cutoff)
		 {		 
			       return;
			   }
		 }
		
//		if(low>=0&&high<=arr.length)
//		{
//			//System.out.println("********");
	    if (low < high)
	    {
	    	if(high-low>=cutoff)
	    	{
	         pi is partitioning index, arr[pi] is now
	           at right place 
	        pi = partition(arr, low, high);
	        System.out.println(Arrays.toString(arr));
                    if(pi>0&&pi<=arr.length)
	        quickSort2(arr, low, pi - 1,cutoff);  // Before pi
                    if(high>=0&&high<=arr.length)
	        quickSort2(arr, pi + 1, high,cutoff); // After pi
	    	}
	    }
		}*/
	static void quickSort2(String[] a,int low,int high,int cutoff)
	{
		if(high<cutoff-1)
		{
			int i, j;
			 String key;
			
			  //if(high-low>=-1)
				System.out.println("insertionSort called");
				   for (i = low+1; i <=high; i++) 
				   { 
				       key = a[i]; 
				       j = i-1;
				       while (j >= 0&&a[j].compareTo(key)>0)
				       { 
				           a[j+1] = a[j];
				    	   j = j-1; 
				       } 
				       
				       a[j+1] = key; 
				   }
		}
		pi = partition(a, low, high);
        System.out.println(Arrays.toString(a));
              //  if(pi>0&&pi<=arr.length)
        quickSort2(a, low, pi - 1,cutoff);  // Before pi
               // if(high>=0&&high<=arr.length)
        quickSort2(a, pi + 1, high,cutoff); // After pi
	}
	 private static int partition(String[] a, int lo, int hi) {
		 int i = lo;
	     int j = hi + 1;
	     String v = a[lo];
	     while (true) { 
	    	 
	    	 i++;
	    	// System.out.print("i val:"+i );
	         while ((i<=hi && a[i].compareTo(v)<0 )) {
	        	 i++;
	             if (i == hi) break;
	         }
	         j--;
	         //System.out.println("j val:"+j );

	         while (a[j].compareTo(v)>0) {
	        	 j--;
	             if (j == lo) break;  
	         }
	         if (i >= j) break;

		String temp = a[i]; 
	    a[i] =a[j]; 
	    a[j] = temp;
	     }
	     //System.out.println("io ..i val:"+i);
	     String temp = a[lo]; 
	     a[lo] = a[j]; 
	     a[j] = temp;
	     return j;
	    }
}