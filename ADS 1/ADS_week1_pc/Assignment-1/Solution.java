
import java.util.LinkedList;
import java.util.Scanner;
class Node1
{
	int data;
	Node1 next;
	Node1(int a)
	{
		this.data=a;
		this.next=null;
	}
}
class list
{
	int size=0;
	Node1 Head;
	list()
	{
		Head=null;
	}
	public void addFirst(int a)
	{
		Node1 value=new Node1(a);
		size++;
		if(Head==null)
		{
			Head=value;
		}
		else
		{
			value.next=Head;
			Head=value;
		}
	}
	public void add(int a)
	{
		Node1 value=new Node1(a);
		size++;
		if(Head==null)
		Head=value;
		else
		{
			Node1 temp=Head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=value;
		}
		//System.out.print(Disp());
	}
	public int popend()
	{
		size--;
		Node1 temp=Head;
		if(Head==null)
		{
			int c=0;
			return c;
		}
		else
		{
		if(temp.next==null)
		{
			int b=temp.data;
			Head=null;
			return b;
		}
		else
		{
			//Node1 temp=Head;
			while(temp.next.next!=null)
			{
				temp=temp.next;
			}
			int a=temp.next.data;
			temp.next=null;
			return a;
		}
		}
		
		
	}
	public String Disp()
	{
		Node1 temp1=Head;
		String s="";
		if(temp1==null)
		{
			return null;
		}
		else
		{
		while(temp1!=null)
		{
			s+=temp1.data;
			temp1=temp1.next;
			//System.out.println(temp1.data);
		}
		}
		//System.out.println("dis"+s);
		return s;
	}
}
class AddLargeNumbers {
    static Scanner sc=new Scanner(System.in);
    public static list numberToDigits(String number) {
    	String s=number;
    	list one=new list();
    	//System.out.println(s);
    	for(int i=0;i<s.length();i++)
    	{
    		int a=Character.getNumericValue(s.charAt(i));
    		one.add(a);
    		//System.out.println(one.Disp());
    	}
    	//System.out.println(one.Disp());
		return one;

    }

    public static String digitsToNumber(list result) {
    	//System.out.println(result.Disp());
    	Node1 temp1=result.Head;
		String s="";
		if(temp1==null)
		{
			return null;
		}
		else
		{
		while(temp1!=null)
		{
			s+=temp1.data;
			temp1=temp1.next;
			//System.out.println(temp1.data);
		}
		}
		//System.out.println("dis"+s);
		return s;
		
    }

    public static list addLargeNumbers(list pDigits, list qDigits) {
    	int len1=pDigits.size;
    	int len2=qDigits.size;
    	int d=0;
    	int e=0;
    	list two=new list();
    	if(len1>=len2)
    	{

    		for(int i=0;i<len1;i++)
    		{
    	int a=pDigits.popend();
    	int b=qDigits.popend();
    	
    	int c=a+b+e;
    	if(i==len1-1)
    	{
    		if(e!=0)
    		{
    			two.addFirst(e);
    		}
    	}
    	if(c>9)
    	{
    		d = c%10;
    		e=c/10;
    		two.addFirst(d);
    	}
    	else
    	{
    		d=0;
    		e=0;
    		two.addFirst(c);
    	} 
    	}
    		return two;
    	
    		}
    		
    	
    	else
    	{
    		for(int i=0;i<len2;i++)
    		{
    	int a=pDigits.popend();
    	int b=qDigits.popend();
    	System.out.println(a+" ..."+b);
    	int c=a+b+e;
    	if(i==len2-1)
    	{
    		if(e!=0)
    		{
    			two.addFirst(e);
    		}
    	}
    	if(c>9)
    	{
    		d = c%10;
    		e=c/10;
    		two.addFirst(d);
    	}
    	else
    	{
    		d=0;
    		e=0;
    		two.addFirst(c);
    	} 
    	
    	}
    		return two;
    	}
		
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                list pDigits = AddLargeNumbers.numberToDigits(p);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                list qDigits = AddLargeNumbers.numberToDigits(q);
               // System.out.println("....."+pDigits.Disp());
                
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                list pDigits1 = AddLargeNumbers.numberToDigits(p);
                list qDigits1 = AddLargeNumbers.numberToDigits(q);
                list result = AddLargeNumbers.addLargeNumbers(pDigits1, qDigits1);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
