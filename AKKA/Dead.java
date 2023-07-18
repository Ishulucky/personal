/*class Dead{
	public static void main(String args[]){
		final Ish i=new Ish();
		final Surya s=new Surya();// as we cant use set and get method.
		Thread t=new Thread(new Runnable(){
			public void run(){
				synchronized(i)
				{
					try{
						System.out.println("1.");
					    Thread.sleep(1000);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
					synchronized(s){
						System.out.println("2..");
					}
				}
				
			}
		});
		Thread t2=new Thread(new Runnable(){
			public void run(){
				synchronized(i)
				{
					try{
						System.out.println("3.");
					    Thread.sleep(1000);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
					synchronized(s){
						System.out.println("4.");
					}
				}
				
			}
		});	
	    t.start();
		t2.start();
	
	}
}

class Surya{
	private int i=10;
	
	public int geti(){
		return i;
	}
	public void seti(int j){
		this.i=j;
	}
}




class Ish{
	private int i=10;
	public int geti(){
		return i;
	}
	public void seti(int j){
		this.i=j;
	}
}

output 
1.
2.
3.
4.*/

/*dead lock example
class Dead{
	public static void main(String args[]){
		final Ish i=new Ish();
		final Surya s=new Surya();// as we cant use set and get method.
		Thread t=new Thread(new Runnable(){
			public void run(){
				synchronized(i)
				{
					try{
						System.out.println("1.");
					    Thread.sleep(1000);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
					synchronized(s){
						System.out.println("2..");
					}
				}
				
			}
		});
		Thread t2=new Thread(new Runnable(){
			public void run(){
				synchronized(s)
				{
					try{
						System.out.println("3.");
					    Thread.sleep(1000);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
					synchronized(i){
						System.out.println("4.");
					}
				}
				
			}
		});	
	    t.start();
		t2.start();
	
	}
}

class Surya{
	private int i=10;
	
	public int geti(){
		return i;
	}
	public void seti(int j){
		this.i=j;
	}
}




class Ish{
	private int i=10;
	public int geti(){
		return i;
	}
	public void seti(int j){
		this.i=j;
	}
}
output 
1.
3.*/

/*yield
class Dead{
	public static void main(String args[]){
		A a=new A();
		a.start();
		for(int i=1;i<7;i++){
			Thread t=Thread.currentThread();
			Thread.yield();
			System.out.println(t.getName()+"hi");
		}
	}
}
class A extends Thread{
	public void run(){
		for(int i=1;i<7;i++){
			Thread t=currentThread();
			Thread.yield();
			System.out.println(t.getName());
		}
	}
}*/