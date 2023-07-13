import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
 class Add extends Thread{
	 private int a,b;
	 public Add(int a,int b){
		 this.a=a;
		 this.b=b;
	 }
	@Override
	public void run(){
		int c;
		c=a+b;
		System.out.println(c);
	}
 }
 
  class Sub extends Thread{
	 private int x,y;
	 public Sub(int x,int y){
		 this.x=x;
		 this.y=y;
	 }
	@Override
	public void run(){
		int c;
		c=x-y;
		System.out.println(c);
	}
 }
 
 class Multi extends Thread{
	 private int d,e;
	 public Multi(int x,int y){
		 this.d=x;
		 this.e=y;
	 }
	@Override
	public void run(){
		int c;
		c=d*e;
		System.out.println(c);
	}
 }
 
 class Exe{
	 public static void main(String args[]){
		 ExecutorService e = Executors.newFixedThreadPool(1);
		 e.execute(new Add(25,100));
		 Sub b=new Sub(100,25);
		 e.execute(b);
		 e.execute(new Multi(25,100));
		 e.shutdown();
     }
 }