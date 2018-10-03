import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class Quick{
	private int[] id;
	public int [] sz;
	public Quick(int N)
	{
		id =new int[N];
		sz =new int[N];
		for(int i=0;i<N;i++)
		{
			id[i]=i;
			sz[i]=i;
		}
	}
	private int root(int i)
	{
		while(i!=id[i]) 
			
			i =id[i];
		return i;
	}
	public boolean find(int p,int q)
	{
		
		return root(p)==root(q);
	}
	public void unite(int p,int q)
	{
		
		int i=root(p);
		
		int j=root(q);
		if(sz[i]<sz[j])
		{
			id[i]=j;
			
			sz[j]+=sz[i];
		}
		else
		{
			id[j]=i;
			sz[i]+=sz[j];
		}
		System.out.print(id);
		System.out.print(" ");
}
}

 class Percolation
{ 
  private boolean[][] sites; 
  private int grid; 
  private int beginNode; 
  private int endNode; 
 
  public Quick QU; 
  
  //private QuickFindUF QU; 
  public Percolation(int N) 
  { 
    N = N+1; 
    QU = new Quick (N*N+1); //+2 for the top and bottom node 
    //QU = new QuickFindUF(N*N+2); 
    sites = new boolean[N][N]; // create N-by-N grid, with all sites blocked 
    grid = N-1; 
    beginNode = 0; 
    endNode = N*N+1; 
 
  } 
  public void open(int i, int j) 
  { 
  // open site (row i, column j) if it is not already 
    // check if out of bound: 
 
    checkException(i, j);  
    if (!sites[j][i]) { 
      sites[j][i] = true; 
    } 
    int index = indexCalc(j, i); 
    //Connect the site with surrounding nodes 
    //left: 
    if (j != 1) { 
      if (sites[j-1][i]) { 
        QU.unite(index, index-1); 
      } 
      } 
    //right: 
    if (j != grid) { 
      if (sites[j+1][i]) { 
        QU.unite(index, index+1); 
      } 
    } 
    //top: 
    if (i != 1) { 
      if (sites[j][i-1]) { 
        QU.unite(index, j+grid*(i-1)); 
       
      } 
    } 
    else { 
      QU.unite(beginNode, index); //connect with top node which we will just have as N^2 
      
    } 
    //bottom: 
     
    if (i != grid) { 
      if (sites[j][i+1]) { 
        QU.unite(index, j+grid*(i+1)); 
      } 
    }  
       
  } 
   
  public boolean isOpen(int i, int j) 
  { 
 
    checkException(i, j); 
  // is site (row i, column j) open? 
    return sites[j][i]; 
  } 
   
  public boolean isFull(int i, int j) 
  { 
 
    checkException(i, j); 
  // is site (row i, column j) full? 
    return (QU.find(indexCalc(j,i), beginNode) ); 
  } 
   
 
   
  public boolean percolates() 
  { 
	  {
	        if (grid == 1)
	        {
	            if (isOpen(1,1))
	            {
	                return true;
	            }
	            return false;
	        }
	        if(grid == 2)
	        {
	            if (QU.find(0,3)) return true;
	            if (QU.find(1,2)) return true;
	            if (QU.find(0,2)) return true;
	            if (QU.find(1,3)) return true;
	            return false;
	        }


	        for (int i = (grid * (grid - 1))-1; i < (grid * grid); i++)
	        {
	           // System.out.println((gridSize * (gridSize - 1))-1);
	            //System.out.println(gridSize * gridSize-1);
	            for (int i2 = 0; i2 < grid; i2++)
	            {
	                //System.out.println(i);
	                //System.out.println(i2);
	                //System.out.print(wqf.connected(i, i2));
	                if (QU.find(i, i2)) return true;

	            }
	        }
	        return false;
	  }
  } 
   
  private int indexCalc(int i, int j) { 
    return i + grid*j; 
  } 
  private void checkException(int i, int j) {  
    if (i <= 0 || i > grid || j <= 0 || j > grid) { 
      throw new IndexOutOfBoundsException("row index i out of bounds"); 
    } 
  }
}
 
 class Solution
 {
	public static void main(String args[])
	 {
		Scanner sc1=new Scanner(System.in);
		
		int c=sc1.nextInt();
		//Quick q=new Quick(c*c);
		Percolation a=new Percolation(c);
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext())
		{
			int i=sc.nextInt();
			int j=sc.nextInt();
			a.open(i, j);
		}
		a.percolates();
	
	 }
 }


// You can implement the above API to solve the problem