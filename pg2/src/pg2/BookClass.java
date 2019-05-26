package pg2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class BookClass {
	public static void main(String args[])
	{
		LinkedList<Books> lb = new LinkedList<Books>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of books");
		int nlen = sc.nextInt();
		Books arr[] = new Books[nlen];
		
		for(int i = 0; i < nlen; i++) {
			System.out.println("Enter book name,publicaton,author,price");

			String n = sc.next();
			String p = sc.next();
			String a = sc.next();
			int pri = sc.nextInt();
			arr[i] = new Books(n,p,a,pri);
			lb.add(arr[i]);
			
		}
		LinkedList<Books> lb1 = new LinkedList<Books>(lb);
		Collections.sort(lb1);
		for(Books bo:lb1)
		{
			System.out.println(bo);
		}
		sc.close();
	}
}

class Books implements Comparable<Books>{
	String name,author,publication;
	int price=0;
	Books(String n,String p,String a,int pri)
	{
		name=n;
		author = a;
		publication = p;
		price = pri;
	}
	Integer getPrice()
	{
		return price;
	}
	void display()
	{
		System.out.println("Name of book :"+name);
		System.out.println("Author of book :"+author);
		System.out.println("Publication of book :"+publication);
		System.out.println("Price of book :"+price);
	}
	public String toString()
	{
		return "Book Details : Title "+name+"\n Author "+author+"\n"+" Publisher "+publication+"\n"+"price "+price;
	}
	public int compareTo(Books b)
	{
		return getPrice().compareTo(b.getPrice());
	}
}