/*import java.util.*;
class Lam{
	public static void main(String arg[]){
		List<String> k=new ArrayList<>();
		k.add("ish");
		k.add("ash");
		k.add("bshsfv");
		k.add("zshmfiiwfn");
		k.add("krish");
		k.add("blackish");
		k.add("ishu");
		Collections.sort(k);
		for(String i:k){
			System.out.println(i);
		}
}
}*/


/*
import java .util.*;
class Lam{
	public static void main(String args[]){
		List<String> s=new ArrayList<>();
		s.add("ishu");
		s.add("is");
		s.add("apple");
		s.add("zoo");
		s.add("zebra");
		s.add("bat");
		s.add("niki");
		Collections.sort(s);
		for(String k:s){
			System.out.println(k);
		}
	}
}*/
/*
import java.util.*;
public class Lam{
    public static void main(String[] args){

		List<String> list = new ArrayList<>();
   		list.add("Vizag"); 
       list.add("Amaravati");  
       list.add("Chennai");  
       list.add("Bangalore");  
       list.add("Bhubaneswar");  
 		list.add("Mangalore"); 

		//sorting
		Collections.sort(list, (String a, String b) -> {
    			return a.compareTo(b);
		});
		
		Comparator c = new Comparator(){
			public int compare(String s1, String s2){
				return (int) (s1.length() - s2.length());
			}
		};
		
		System.out.println(list); 

   }
}*/
/*
class Lam{
	public static void main(String[] args){
		Runnable r=()->{
			for(int i=0;i<5;i++){
				System.out.println(i);
			}
		};
		Thread t=new Thread(r);
		t.start();
	}
}*/

/*
interface Ish{
	public void su( int m);
}
class Lam{
	public static void main(String[] args){
		Ish r=(m)->{
			for(int i=0;i<m;i++){
				System.out.println(i);
			}
		};
		
		r.su(50);
	}
}*/

/*
interface Ish{
	public int su( int m, int n);
}
class Lam{
	public static void main(String[] args){
		Ish r=(m,n)->(m+n);
		System.out.println(r.su(100,51));
		
		
		Ish r2=(int m,int n)->{
			return m+n;
		};
		System.out.println(r.su(100,51));
	}
}*/

import java.util.*;
class Account{
    private int ano;
    private String title;
    private double balance;
    public Account(int a,String t,double b){
			ano=a;
			title=t;
			balance=b;  
    }
    public int getAno(){
		return ano;
    }
     public void setTitle(String t){
		title=t;
     }
     public String getTitle(){
		return title;
     }
     public double getBalance(){
		return balance;
     }

     public void deposit(double amt){
			balance+=amt;
			System.out.println("Balance after deposit is "+balance);
     }
     public void withdraw(double amt){
		if ((balance-amt)>=0){
	 	   balance-=amt;
	  	   System.out.println("Balance after withdrawl is "+balance);
		}else
	   	   System.out.println("Sorry insufficient funds");
     }
}


public class LambdaExprCollSort2{
    public static void main(String[] args){

		//Create collecton
		ArrayList<Account> al=new ArrayList<>();
	
 		//adding elements
		al.add(new Account(101,"NS",50000));
		al.add(new Account(102,"NX",65000));
		al.add(new Account(103,"NK",31000));
	
		//sorting
		Collections.sort(al,(a1,a2)->{  
        	return a1.getTitle().compareTo(a2.getTitle());  
        });

		//reading collection
		Iterator<Account> itr=al.iterator();
	
		//readinng elements
		Account a;
		while(itr.hasNext()){
	   	     a=itr.next();
	    	 System.out.println(a.getTitle());
		}
   }
}