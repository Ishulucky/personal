/*BOUNDED Generics without any list
class Account {
	private int ano;
	private String title;
	private double balance;

	public Account(int ano, String title, double balance) {
		this.ano = ano;
		this.title = title;
		this.balance = balance;
	}

	public void withdraw() {
		// TODO Auto-generated method stub

	}

	public int geta() {
		return ano;
	}

	public String gettitle() {
		return title;
	}

	public double getbal() {
		return balance;
	}

	public void deposit(double amt) {
		balance += amt;
		System.out.println("balance is: " + balance);
	}

	public void withdraw(double amt) {
		if (balance >= amt) {
			balance -= amt;
			System.out.println("balance is: " + balance);
		} else
			System.out.println("balance is insufficient");
	}

	public void interestcal() {
		System.out.println("interest calculation of account");
	}
}

class SavingsAccount extends Account {
	public SavingsAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("sa withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("sa interest");
	}

	public void calsaving() {
		System.out.println("sa call");
	}
}

class CurrentAccount extends Account {
	public CurrentAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("ca withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("ca interest");
	}

	public void calODInterest() {
		System.out.println("ca odi");
	}
}

class RecurringAccount extends Account {
	public RecurringAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("ra withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("ra interest");
	}

	public void calMatAmount() {
		System.out.println("ra amount");
	}
}

public class Gen {
	public <T extends Account> void process (T m) {
		m.withdraw(500);
		m.deposit(1500);
		m.interestcal();
		if(m instanceof SavingsAccount) {
			SavingsAccount sa=(SavingsAccount)m;
			sa.calsaving();
		}
		else if(m instanceof CurrentAccount){
			CurrentAccount k=(CurrentAccount)m;
			k.calODInterest();
		}
		else if(m instanceof RecurringAccount){
			RecurringAccount l=(RecurringAccount)m;
			l.calMatAmount();
		}
		System.out.println("\n");

	}

	public static void main(String args[]) {
		Gen o = new Gen();
		SavingsAccount s = new SavingsAccount(121, "ishji", 1000);
		o.process(s);
		CurrentAccount p = new CurrentAccount(11, "nik", 5000);
		o.process(p);
		RecurringAccount i = new RecurringAccount(12, "pandu", 100);
		o.process(i);
	}

}*/
/*oUTPUT:
balance is: 500.0
balance is: 2000.0
sa interest
sa call


balance is: 4500.0
balance is: 6000.0
ca interest
ca odi


balance is insufficient
balance is: 1600.0
ra interest
ra amount
*/

/*wildcards with upperbound as wildcards allows us to use list as a parameter where upper bound generics parameters are not
import java.util.*;
class Account {
	private int ano;
	private String title;
	private double balance;

	public Account(int ano, String title, double balance) {
		this.ano = ano;
		this.title = title;
		this.balance = balance;
	}

	public int geta() {
		return ano;
	}

	public String gettitle() {
		return title;
	}

	public double getbal() {
		return balance;
	}

	public void deposit(double amt) {
		balance += amt;
		System.out.println("balance is: " + balance);
	}
	public void withdraw() {
		System.out.println("account");
	}

	public void withdraw(double amt) {
		if (balance >= amt) {
			balance -= amt;
			System.out.println("balance is: " + balance);
		} else
			System.out.println("balance is insufficient");
	}

	public void interestcal() {
		System.out.println("interest calculation of account");
	}
}

class SavingsAccount extends Account {
	public SavingsAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("sa withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("sa interest");
	}

	public void calsaving() {
		System.out.println("sa call");
	}
}

class CurrentAccount extends Account {
	public CurrentAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("ca withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("ca interest");
	}

	public void calODInterest() {
		System.out.println("ca odi");
	}
}

class RecurringAccount extends Account {
	public RecurringAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("ra withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("ra interest");
	}

	public void calMatAmount() {
		System.out.println("ra amount");
	}
}

public class Gen {
	public  static void process(List<? extends Account> b) {
		for(Account m:b){
		m.withdraw(500);
		m.deposit(1500);
		m.interestcal();
		if(m instanceof SavingsAccount) {
			SavingsAccount sa=(SavingsAccount)m;
			sa.calsaving();
		}
		else if(m instanceof CurrentAccount){
			CurrentAccount k=(CurrentAccount)m;
			k.calODInterest();
		}
		else if(m instanceof RecurringAccount){
			RecurringAccount l=(RecurringAccount)m;
			l.calMatAmount();
		}
		System.out.println("\n");
		}
	}

	public static void main(String args[]) {
		List<SavingsAccount> t1=new ArrayList<>();
		List<CurrentAccount> t2=new ArrayList<>();
		List<RecurringAccount> t3=new ArrayList<>();
		SavingsAccount s1 = new SavingsAccount(121, "ishji", 1000);
		SavingsAccount s2 = new SavingsAccount(120, "ish", 5000);
		SavingsAccount s3 = new SavingsAccount(123, "ij", 6000);
		t1.add(s1);
		t1.add(s2);
		t1.add(s3);
		CurrentAccount p1 = new CurrentAccount(11, "nik", 1800);
		CurrentAccount p2 = new CurrentAccount(11, "surya", 5004);
		CurrentAccount p3 = new CurrentAccount(11, "ok", 5057);
		t2.add(p1);
		t2.add(p2);
		t2.add(p3);
		RecurringAccount i1 = new RecurringAccount(12, "hi", 1001);
		RecurringAccount i2 = new RecurringAccount(12, "pandu", 1600);
		RecurringAccount i3 = new RecurringAccount(12, "pan", 1900);
	    Gen o=new Gen();
		o.process(t1);
		o.process(t2);
		o.process(t3);
		
	}
}*/

/*output:
balance is: 500.0
balance is: 2000.0
sa interest
sa call


balance is: 4500.0
balance is: 6000.0
sa interest
sa call


balance is: 5500.0
balance is: 7000.0
sa interest
sa call


balance is: 1300.0
balance is: 2800.0
ca interest
ca odi


balance is: 4504.0
balance is: 6004.0
ca interest
ca odi


balance is: 4557.0
balance is: 6057.0
ca interest
ca odi*/
/*upper bound generics with using class name
import java.util.*;
class Account {
	private int ano;
	private String title;
	private double balance;

	public Account(int ano, String title, double balance) {
		this.ano = ano;
		this.title = title;
		this.balance = balance;
	}

	public int geta() {
		return ano;
	}

	public String gettitle() {
		return title;
	}

	public double getbal() {
		return balance;
	}

	public void deposit(double amt) {
		balance += amt;
		System.out.println("balance is: " + balance);
	}
	public void withdraw() {
		System.out.println("account");
	}

	public void withdraw(double amt) {
		if (balance >= amt) {
			balance -= amt;
			System.out.println("balance is: " + balance);
		} else
			System.out.println("balance is insufficient");
	}

	public void interestcal() {
		System.out.println("interest calculation of account");
	}
}

class SavingsAccount extends Account {
	public SavingsAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("sa withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("sa interest");
	}

	public void calsaving() {
		System.out.println("sa call");
	}
}

class CurrentAccount extends Account {
	public CurrentAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("ca withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("ca interest");
	}

	public void calODInterest() {
		System.out.println("ca odi");
	}
}

class RecurringAccount extends Account {
	public RecurringAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("ra withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("ra interest");
	}

	public void calMatAmount() {
		System.out.println("ra amount");
	}
}

public class Gen <T extends Account>{
	public void process(List<T> b) {
		for(Account m:b){
		m.withdraw(500);
		m.deposit(1500);
		m.interestcal();
		if(m instanceof SavingsAccount) {
			SavingsAccount sa=(SavingsAccount)m;
			sa.calsaving();
		}
		else if(m instanceof CurrentAccount){
			CurrentAccount k=(CurrentAccount)m;
			k.calODInterest();
		}
		else if(m instanceof RecurringAccount){
			RecurringAccount l=(RecurringAccount)m;
			l.calMatAmount();
		}
		System.out.println("\n");
		}
	}

	public static void main(String args[]) {
		List<SavingsAccount> t1=new ArrayList<>();
		List<CurrentAccount> t2=new ArrayList<>();
		List<RecurringAccount> t3=new ArrayList<>();
		SavingsAccount s1 = new SavingsAccount(121, "ishji", 1000);
		SavingsAccount s2 = new SavingsAccount(120, "ish", 5000);
		SavingsAccount s3 = new SavingsAccount(123, "ij", 6000);
		t1.add(s1);
		t1.add(s2);
		t1.add(s3);
		CurrentAccount p1 = new CurrentAccount(11, "nik", 1800);
		CurrentAccount p2 = new CurrentAccount(11, "surya", 5004);
		CurrentAccount p3 = new CurrentAccount(11, "ok", 5057);
		t2.add(p1);
		t2.add(p2);
		t2.add(p3);
		RecurringAccount i1 = new RecurringAccount(12, "hi", 1001);
		RecurringAccount i2 = new RecurringAccount(12, "pandu", 1600);
		RecurringAccount i3 = new RecurringAccount(12, "pan", 1900);
	    Gen o=new Gen();
		o.process(t1);
		o.process(t2);
		o.process(t3);
		
	}
}*/

/*unbounded wildcards 
import java.util.*;
class Account {
	private int ano;
	private String title;
	private double balance;

	public Account(int ano, String title, double balance) {
		this.ano = ano;
		this.title = title;
		this.balance = balance;
	}

	public int geta() {
		return ano;
	}

	public String gettitle() {
		return title;
	}

	public double getbal() {
		return balance;
	}

	public void deposit(double amt) {
		balance += amt;
		System.out.println("balance is: " + balance);
	}
	public void withdraw() {
		System.out.println("account");
	}

	public void withdraw(double amt) {
		if (balance >= amt) {
			balance -= amt;
			System.out.println("balance is: " + balance);
		} else
			System.out.println("balance is insufficient");
	}

	public void interestcal() {
		System.out.println("interest calculation of account");
	}
}

class SavingsAccount extends Account {
	public SavingsAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("sa withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("sa interest");
	}

	public void calsaving() {
		System.out.println("sa call");
	}
}

class CurrentAccount extends Account {
	public CurrentAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("ca withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("ca interest");
	}

	public void calODInterest() {
		System.out.println("ca odi");
	}
}

class RecurringAccount extends Account {
	public RecurringAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("ra withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("ra interest");
	}

	public void calMatAmount() {
		System.out.println("ra amount");
	}
}

public class Gen {
	public void process(List<?> b) {
		for(Object k:b){
		if(k instanceof Account){
			Account m=(Account)k;
			m.withdraw(500);
			m.deposit(1500);
			m.interestcal();
			if(m instanceof SavingsAccount) {
				SavingsAccount sa=(SavingsAccount)m;
				sa.calsaving();
			}
			else if(m instanceof CurrentAccount){
				CurrentAccount n=(CurrentAccount)m;
				n.calODInterest();
			}
			else if(m instanceof RecurringAccount){
				RecurringAccount l=(RecurringAccount)m;
				l.calMatAmount();
			}
			System.out.println("\n");
			}
			
		}
	}

	public static void main(String args[]) {
		List<SavingsAccount> t1=new ArrayList<>();
		List<CurrentAccount> t2=new ArrayList<>();
		List<RecurringAccount> t3=new ArrayList<>();
		SavingsAccount s1 = new SavingsAccount(121, "ishji", 1000);
		SavingsAccount s2 = new SavingsAccount(120, "ish", 5000);
		SavingsAccount s3 = new SavingsAccount(123, "ij", 6000);
		t1.add(s1);
		t1.add(s2);
		t1.add(s3);
		CurrentAccount p1 = new CurrentAccount(11, "nik", 1800);
		CurrentAccount p2 = new CurrentAccount(11, "surya", 5004);
		CurrentAccount p3 = new CurrentAccount(11, "ok", 5057);
		t2.add(p1);
		t2.add(p2);
		t2.add(p3);
		RecurringAccount i1 = new RecurringAccount(12, "hi", 1001);
		RecurringAccount i2 = new RecurringAccount(12, "pandu", 1600);
		RecurringAccount i3 = new RecurringAccount(12, "pan", 1900);
	    Gen o=new Gen();
		o.process(t1);
		o.process(t2);
		o.process(t3);
		
	}
}*/
/*
output
balance is: 500.0
balance is: 2000.0
sa interest
sa call


balance is: 4500.0
balance is: 6000.0
sa interest
sa call


balance is: 5500.0
balance is: 7000.0
sa interest
sa call


balance is: 1300.0
balance is: 2800.0
ca interest
ca odi


balance is: 4504.0
balance is: 6004.0
ca interest
ca odi


balance is: 4557.0
balance is: 6057.0
ca interest
ca odi
*/
/*lower bound wildcards
import java.util.*;
class Account {
	private int ano;
	private String title;
	private double balance;

	public Account(int ano, String title, double balance) {
		this.ano = ano;
		this.title = title;
		this.balance = balance;
	}

	public int geta() {
		return ano;
	}

	public String gettitle() {
		return title;
	}

	public double getbal() {
		return balance;
	}

	public void deposit(double amt) {
		balance += amt;
		System.out.println("balance is: " + balance);
	}
	public void withdraw() {
		System.out.println("account");
	}

	public void withdraw(double amt) {
		if (balance >= amt) {
			balance -= amt;
			System.out.println("balance is: " + balance);
		} else
			System.out.println("balance is insufficient");
	}

	public void interestcal() {
		System.out.println("interest calculation of account");
	}
}

class SavingsAccount extends Account {
	public SavingsAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("sa withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("sa interest");
	}

	public void calsaving() {
		System.out.println("sa call");
	}
}

class CurrentAccount extends Account {
	public CurrentAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("ca withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("ca interest");
	}

	public void calODInterest() {
		System.out.println("ca odi");
	}
}

class RecurringAccount extends Account {
	public RecurringAccount(int a, String t, double b) {
		super(a, t, b);
	}

	@Override
	public void withdraw() {
		System.out.println("ra withdraw");
	}

	@Override
	public void interestcal() {
		System.out.println("ra interest");
	}

	public void calMatAmount() {
		System.out.println("ra amount");
	}
}


class Gen {
	public void process(List<? super SavingsAccount> b) {
		for(Object m:b){
			
		if(m instanceof SavingsAccount) {
			SavingsAccount sa=(SavingsAccount)m;
			sa.calsaving();
			sa.withdraw(500);
			sa.deposit(1500);
			sa.interestcal();
		}
		}
}
    public void process1(List<? super CurrentAccount> b) {
		for(Object m:b){
		
		if(m instanceof CurrentAccount){
			CurrentAccount k=(CurrentAccount)m;
			k.calODInterest();
			k.withdraw(500);
		    k.deposit(1500);
		    k.interestcal();
		}
		}
}
    public void process2(List<? super RecurringAccount> b) {
		for(Object m:b){
		
		if(m instanceof RecurringAccount){
			RecurringAccount l=(RecurringAccount)m;
			l.calMatAmount();
			l.withdraw(500);
			l.deposit(1500);
			l.interestcal();
		}
		
}
}
}		


class Ish{	
	public static void main(String args[]) {
		List<SavingsAccount> t1=new ArrayList<>();
		List<CurrentAccount> t2=new ArrayList<>();
		List<RecurringAccount> t3=new ArrayList<>();
		SavingsAccount s1 = new SavingsAccount(121, "ishji", 1000);
		SavingsAccount s2 = new SavingsAccount(120, "ish", 5000);
		SavingsAccount s3 = new SavingsAccount(123, "ij", 6000);
		t1.add(s1);
		t1.add(s2);
		t1.add(s3);
		CurrentAccount p1 = new CurrentAccount(11, "nik", 1800);
		CurrentAccount p2 = new CurrentAccount(11, "surya", 5004);
		CurrentAccount p3 = new CurrentAccount(11, "ok", 5057);
		t2.add(p1);
		t2.add(p2);
		t2.add(p3);
		RecurringAccount i1 = new RecurringAccount(12, "hi", 1001);
		RecurringAccount i2 = new RecurringAccount(12, "pandu", 1600);
		RecurringAccount i3 = new RecurringAccount(12, "pan", 1900);
	    Gen o=new Gen();
		o.process(t1);
		o.process1(t2);
		o.process2(t3);
		
	}
}*/
/*
output:
sa call
balance is: 500.0
balance is: 2000.0
sa interest
sa call
balance is: 4500.0
balance is: 6000.0
sa interest
sa call
balance is: 5500.0
balance is: 7000.0
sa interest
ca odi
balance is: 1300.0
balance is: 2800.0
ca interest
ca odi
balance is: 4504.0
balance is: 6004.0
ca interest
ca odi
balance is: 4557.0
balance is: 6057.0
ca interest*/