import java.io.*;
import java.util.Scanner;
class Node<T> {
    T value;
    Node<T> link;
}

class Stack<T> {
    Node<T> top;
    public Stack() {
        top = null;
    }
    public void push(T item) {
        Node<T> n = new Node<T>();
        n.value = item;
        n.link = top;
        top = n;
    }
    public T pop() {
        T item;
        item = top.value;
        Node<T> n = top;
        n = null;
        top = top.link;
        return item;
    }
    public void display() {
        Node<T> n = top;
        System.out.print("(top)");
        while (n != null) {
            System.out.print(" ->" + n.value);
            n = n.link;
        }
        System.out.println();
    }
}

// Queue---------------------------
class Queue<T> {
    Node<T> front, rear;
    Stack<T> s1 = new Stack<T>();
    Stack<T> s2 = new Stack<T>();
    public Queue() {
    }
    public void add(T item) {
        while (s2.top != null)
            s1.push(s2.pop());
        s1.push(item);
        rear = s1.top;
        while (s1.top != null)
            s2.push(s1.pop());
        front = s2.top;
    }
    public T remove() {
        T item = s2.pop();
        front = s2.top;
        return item;
    }
    public void display() {
        Node<T> n = s2.top;
        System.out.print("(front)");
        while (n != null) {
            System.out.print(" <-" + n.value);
            n = n.link;
        }
        System.out.println(" <-(rear)");
    }
}

// Josephus Problem-------------------
public class Solution {
    public static void main(String[] args) throws IOException {
        
        int n, m, i;
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        while(sc.hasNext())
        {
        Queue<Integer> q = new Queue<Integer>();
        Queue<Integer> q1 = new Queue<Integer>();
        String a=sc.nextLine();
    	int g=0;
    	String[] b=a.split(" ");
    	n=Integer.parseInt(b[0]);
    	m=Integer.parseInt(b[1]);
        for (i = 0; i < n; i++)
            q.add(i);
        Node<Integer> node = q.front;
        int l, k = 0;
        while (k != n - 1) {
            for (i = 0; i< m-1; i++)
                q.add(q.remove());
            l = q.remove();
            q1.add(l);
            k++;
        }
        
        	while (q1.front != null)
            System.out.print(q1.remove() + " ");
        	l=q.remove();
            q1.add(l);
            System.out.print(q1.remove());
            System.out.println("");
    }
        
    }
}