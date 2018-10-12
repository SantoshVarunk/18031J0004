import java.util.Scanner;

public class Solution{
	public static void main(String args[])
	{
Scanner s=new Scanner(System.in);
int n=s.nextInt();
//int i;
String st[]=new String[n+1];

/*String s1=s.next();
System.out.println(s1);*/
//for(i=0;i<n;i++)
int i;
for(i=0;i<n+1;)
{

	st[i]=s.nextLine();
	i++;
}

String st1[]=new String[2];
Linkl l=new Linkl();
int count=0;
for(i=0;i<(st.length);i++)
{
	
	st1=st[i].split(" ");
	 /*count++;
	 System.out.println("count:"+count);*/
	switch(st1[0])
	{
	case "pushLeft":
                     l.pushfront(Integer.parseInt(st1[1]));
                     l.display();
	                 break;
	case "pushRight":
                     l.pushend(Integer.parseInt(st1[1]));   
                     l.display();
                     break;
	case "popLeft":l.popfront();
					l.display();
	
	                 break;
	case "popRight":l.popend();
	                l.display();
                     break;
	case "size":System.out.println(l.size());
	                 break;
	default:break;
   
                
	}
	
}
//System.out.println(count);
}
}

 class Node {
int data;
Node next;
Node(int a)
{
	this.data=a;
}
@Override
public String toString() {
	return "["+data +","+next+"]";
}

}
 class Linkl {
Node head;

public void pushend(int a)
	{
		Node n=new Node(a);
	
		if(head==null)
		{
			head=n;
			
		}
		else
		{	Node temp =head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		
		temp.next=n;
		
		}
		
	}
	public int  popend()
{
		Node temp1=null;
	
	if(head==null)
		
	{
		return 0;
	}
	else if(head.next==null)
	{Node temp=head;
	head=null;
		return temp.data;
	}
	else
	{
		Node temp=head;
	
	while(temp.next.next!=null)
	{
		temp=temp.next;
	}
	temp1=temp.next;
	temp.next=null;
	return temp1.data;
	}
	

}

public void display()
{	
	Node temp=head;
	if(head==null)
	{
		System.out.println("Deck is empty");
	}
	else
	{
		System.out.print("[");
	while(temp!=null)
	{
		
		System.out.print(temp.data);
		temp=temp.next;
		if(temp!=null)
		System.out.print(", ");
	}
	System.out.print("]");
	System.out.println();
	}
}
public void pushfront(int a)
{

		Node n=new Node(a);
	
		if(head==null)
		{
			head=n;
			
		}
		else
		{	n.next=head;
		    head=n;
		    
		}
		
}
public int popfront()
{
	
		if(head==null)
		{
			return 0;
		}
		else
		{	Node temp1=head;
		head=head.next;
		   return temp1.data;
		}
		
}


public int size()
{Node temp1=head;
int count=0;
while(temp1!=null)
{
	temp1=temp1.next;
	count++;
	
}
return count;
	
}
public String toString() {
	Node temp=head;
	
	return head+"";
}

}



