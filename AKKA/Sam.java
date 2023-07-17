/*1.
interface Ish{
	default void su(){
		System.out.println("1.hi default");
	}
	static  void show(){
		System.out.println("hello static");
	}
	public void think();
}

class Sam implements Ish{
	public void think(){
		System.out.println("holla public abstract");
	}
	public static void main(String a[]){
		Sam h=new Sam();
		Ish.show();
		h.think();
	    //h.show();//can't assessed by the objects
		h.su();
		//Ish.su();  // error default method can onlu acessed by objects of implementred class as they treated as non static members.
	    //Sam.show();  // only static can accessed by the qualifier of interface
	}
}*/

/*2.by interface object
 interface Ish{
	default void su(){
		System.out.println("1.hi default");
	}
	static  void show(){
		System.out.println("hello static");
	}
	public void think();
}

class Sam{
	public static void main(String a[]){
		Ish  h=()->{
			System.out.println("3.holla public abstract");
			};
		Ish.show();
		h.su();
		h.think();
	}
}*/

/*3.Static inner class
class A{
	 static class B{
		public void dis(){
			System.out.println("hi");
		}
	}
}
class Sam{
		public static void main(String arg[]){
		A a=new A();
		A.B b=new A.B();
		b.dis();
		}
}*/
/*ouput hi*/


/*4.local inner class with shadowing
class A{
	int x=10;
	void su(){
		int x=11;
	    class B{
		    public void dis(){
			   int x= 15;
			   System.out.println(x);
		    }
	    }
		B b = new B();
		b.dis();
			
	}
	
}
class Sam{
	public static void main(String arg[]){
		A a = new A();
		a.su();
	}
}*/

/*5.anonymous class with thread
class Sam extends Thread{
	public static void main(String a[]){
		Sam t=new Sam(){
			public void run(){
				for (int i=0;i<5;i++){
					System.out.println(i);
				}
			}
		};
		t.start();
	}
}*/

/*6.anonymous class with runnable
class Sam{
	public static void main(String a[]){
		Thread t=new Thread(new Runnable(){
			public void run(){
				for (int i=0;i<5;i++){
					System.out.println(i);
				}
			}
		});
		t.start();
	}
}*/
/*7.anonymous class with interface
interface A{
	public void su();
}

class Sam{
	public static void main(String a[]){
		A bi=new A(){
			public void su(){
				System.out.println("hi");
			}
		};
		bi.su();
	}
}*/

/*8.anonymous class with a class
class A{
	public void su(){
		System.out.println("hi ishu");
	}
}
class Sam{
	public static void main(String a[]){
		A bi=new A(){
			public void su(){
				System.out.println("hi pandu");
			}
		};
		bi.su();
	}
}*/
/*9. threads
class A extends Thread{
	public void run(){
			for (int i=0;i<5;i++){
				System.out.println(i);
			}
	}
}
class Sam{
	public static void main(String args[]){
		A a=new A();
		a.start();
	}
}*/

/*10.runnable interface
class A implements Runnable{
	public void run(){
			for (int i=0;i<5;i++){
				System.out.println(i);
			}
	}
}
class Sam{
	public static void main(String args[]){
		A a=new A();
		Thread t=new Thread(a);
		t.start();
	}
}*/


/*11.
class Sam{
	public static void main(String args[]){
		String t=args[0];
		for(int i=0;i<t.length();i++){
			try{
				Thread.sleep(1000);
				System.out.println(t.charAt(i));
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}*/
class Account {
	private int ano;
	private double bal;
	private String title;

	public Account(int ano, double bal, String title) {
		super();
		this.ano = ano;
		this.bal = bal;
		this.title = title;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	synchronized public void deposit(double amt) {
		double b;
		try{
		b=bal+amt;
		Thread.sleep(1000);
		bal=b;
		System.out.println(bal);
	}
	catch(InterruptedException r){
		r.printStackTrace();
	}

	}
}

class A extends Thread {
	Account a;

	public A(Account a) {
		super();
		this.a = a;
	}

	public void run() {
		Thread t=currentThread();
		a.deposit(500);
		System.out.println(t.getName());
	}
}

class Sam {
	public static void main(String arg[]) {
		Account a = new Account(121, 5000, "ish");
		A[] b=new A[5];
		for(int i=0;i<5;i++){
			b[i]=new A(a);
			b[i].start();
		}
		for(int k=0;k<5;k++){
			try{
			b[k].join();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}