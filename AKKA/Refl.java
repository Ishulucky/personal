
/*sir sum
class SuperList{
   public static void main(String[] args){
		Class cls=null;
		try{
		//loading class into the memory
		cls=Class.forName(args[0]);
        System.out.println(cls.getName());
        System.out.println(cls.getSimpleName());
		//listing all super classes of the given class
		while((cls=cls.getSuperclass())!=null){
	 	    System.out.println(cls.getName());
		}
	}catch(Exception ex){
	     ex.printStackTrace();
	}
   }
}*/

/*class loading and superclass
class Refl{
	public static void main(String args[]){
		try{
			Class a=CurrentAccount.class;
			Class c=Class.forName(args[0]);// let it be SavingsAccount
			Class b=Class.forName("Account");
			System.out.println("1. "+a.getName());
			System.out.println("2. "+c.getName());
			System.out.println("3. "+b.getName());
			System.out.println(" 4."+c.getSimpleName());
			System.out.println("5."+b.getSimpleName());
			while((c=c.getSuperclass())!=null){
	 	    System.out.println("SUPER LIST "+c.getName());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}*/
/*output
E:\Pratice\Collections\Reflections>java Refl SavingsAccount
1. CurrentAccount
2. SavingsAccount
3. Account
 4.SavingsAccount
5.Account
SUPER LIST Account
SUPER LIST java.lang.Object*/

/*
import java.lang.reflect.*;
class Refl{
	public static void main(String args[]){
		try{
			Class a=CurrentAccount.class;
			Class c=Class.forName(args[0]);// let it be SavingsAccount
			Class b=Class.forName("Account");
			Method[] m1=a.getDeclaredMethods();
			Method[] m2=a.getMethods();
			
			for(int i=0;i<m1.length;i++){
				System.out.println("1.return type "+m1[i].getReturnType());
				System.out.println("2.mehod name "+m1[i].getName()+"\n");
			}
			
			for(int i=0;i<m2.length;i++){
				System.out.println("3.return type "+m2[i].getReturnType());
				System.out.println("4.mehod name "+m2[i].getName()+"\n"+"------");
			}

			while((c=c.getSuperclass())!=null){
	 	    System.out.println("5.SUPER LIST "+c.getName());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
*/
/*
output
1.return type void
2.mehod name withdraw

1.return type void
2.mehod name calODInt

3.return type void
4.mehod name withdraw
------
3.return type void
4.mehod name calODInt
------
3.return type void
4.mehod name deposit
------
3.return type void
4.mehod name getbal
------
3.return type void
4.mehod name wait
------
3.return type void
4.mehod name wait
------
3.return type void
4.mehod name wait
------
3.return type boolean
4.mehod name equals
------
3.return type class java.lang.String
4.mehod name toString
------
3.return type int
4.mehod name hashCode
------
3.return type class java.lang.Class
4.mehod name getClass
------
3.return type void
4.mehod name notify
------
3.return type void
4.mehod name notifyAll
------
5.SUPER LIST Account
5.SUPER LIST java.lang.Object*/


import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
class Refl{
	public static void main(String args[]){
		try{
			Class a=Account.class;
			Method[] m1=a.getDeclaredMethods();
			Method[] m2=a.getMethods();
			Field[] f1=a.getDeclaredFields();
			Field[] f2=a.getFields();
			Constructor[] c1=a.getConstructors();
			Constructor[] c2=a.getDeclaredConstructors();
			
			for(int i=0;i<m1.length;i++){
				System.out.println("1.return type "+m1[i].getReturnType());
				System.out.println("2.mehod name "+m1[i].getName()+"\n");
			}
			
			for(int i=0;i<m2.length;i++){
				System.out.println("3.return type "+m2[i].getReturnType());
				System.out.println("4.mehod name "+m2[i].getName()+"\n"+"------");
			}
			System.out.println("-------------------------------------------------------------");
			
			for(Method k:m1){
				System.out.println("5."+k);
			}			
			for(Field k:f1){
				System.out.println("6."+k);
			}			
			for(Constructor k:c1){
				System.out.println("7."+k);
			}
			
			for(Method k:m2){
				System.out.println("8."+k);
			}			
			for(Field k:f2){
				System.out.println("9."+k);
			}			
			for(Constructor k:c2){
				System.out.println("10."+k);
			}


		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}