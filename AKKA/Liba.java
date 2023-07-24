
import java.util.*;
class Book{
	private int isbn;
	private String title;
	private double price;
	private int noofpages;
	public Book(int isbn,String title,double price,int noofpages){
		this.isbn=isbn;
		this.title=title;
		this.price=price;
		this.noofpages=noofpages;
	}
	public String toString(){
		return("code  "+isbn+" title of book "+title+" rate "+price+" pages"+noofpages);
	}
}

class Lib{
	public static void main(String args[]){
		Map<String,Map<String,Book>> a=new HashMap<>();
		Map<String,Book> b=new HashMap<>();
		Map<String,Book> c=new HashMap<>();
		b.put("ish",new Book(1,"c",520,50));
		b.put("surya",new Book(2,"c++",820,90));
		b.put("ish",new Book(3,"c",520,50));
		c.put("surya",new Book(4,"c++",820,90));
		c.put("ish",new Book(5,"c",520,50));
		c.put("surya",new Book(6,"c++",820,90));
		a.put("sri",b);
		a.put("padma",c);
		for(Map.Entry<String,Map<String,Book>> k:a.entrySet()){
			System.out.println(k.getKey());
			for(Map.Entry<String,Book> p:k.getValue().entrySet()){
				System.out.println(p.getKey()+"------"+p.getValue());
			}
		}
	}
}