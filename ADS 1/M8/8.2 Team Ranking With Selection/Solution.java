import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Team
{
	String TeamName;
	int Wins,Losses,Draws;
	public Team(String t,int w,int l,int d)
	{
		this.TeamName=t;
		this.Wins=w;
		this.Losses=l;
		this.Draws=d;
	}
}
class Solution
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<Team> al=new ArrayList<Team>();
		while(sc.hasNext())
		{
			String a=sc.nextLine();
			String []b=a.split(",");
			Team t=new Team(b[0],Integer.parseInt(b[1]),Integer.parseInt(b[2]),Integer.parseInt(b[3]));
			al.add(t);
		}
//		Iterator itr=al.iterator();
//		   while(itr.hasNext())
//		   {
//			   Team t=(Team) itr.next();
//			   System.out.print(t.Draws+",");
//		   }
			   for (int i = 0; i < al.size()-1; i++)
			   {
			      int min = i;
			      for (int j = i+1; j < al.size(); j++)
			    	  if (compare(al.get(j),al.get(min))) min = j;
			      Team temp = al.get(i);
			      al.set(i, al.get(min));
			      al.set(min, temp);
			      }
			   Iterator itr1=al.iterator();
			   while(itr1.hasNext())
			   {
				   Team t=(Team) itr1.next();
				   if(!itr1.hasNext())
				   {
					   System.out.print(t.TeamName);
					   break;
				   }
				   System.out.print(t.TeamName+",");
			   }
			   
	}
	 public static boolean  compare(Object a,Object b)
	   {
		 Team t1=(Team)a;
		 Team t2=(Team)b;
		   if(t1.Wins==t2.Wins)
		   {
			   if(t1.Losses==t2.Losses)
			   {
				   if(t1.Draws>t2.Draws)
				   {
					   return true;
				   }
				   else 
					   return false;
				   
			   }
			   else if(t1.Losses<t2.Losses)
			   {
				   return true;
			   }
			   else
				   return false;
		   }
		    if(t1.Wins>t2.Wins)
		   {
			   return true;
		   }
		   else
			   return false;
	   }
}