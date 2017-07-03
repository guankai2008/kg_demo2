package com.java.thread;
/*
 * 创建一个子线程，完成1-100之间的自然数输出，同样的。主线程执行同样操作
 * 
 * 
 * 步骤1. 创建一个extends Thread的子类。
 *     2. 子类重写 run方法(方法内部是要实现的功能)
 *     3. 主线程创建子类的对象实例。
 *     4. 对象调用Thread的start方法。
 *     5. 一 个线程只能start一次。
 *     6. 不能通过Tread对象调用run方法的方式，这样就是单线程。
 * 
 */
public class TestThread {
	public static void main(String[] args) {
		//3.创建子类的对象
				SutThread st=new SutThread();
				SutThread2 st2=new SutThread2();
		//4.调用线程的start的方法：启动此线程;调用相应的run方法
	
				st.start();
				st2.start();
				int i=0;
				while(i<100){
					System.out.print(Thread.currentThread().getName()+":"+i);
					i++;
					System.out.println();
			}
	}	
}
//1.创建一个继承于thread的子类
class SutThread extends Thread{
	//2.重写Thread类的run方法。方法实现线程完成的工作
	public void run(){
		int i=0;
		while(i<100){
			System.out.print(Thread.currentThread().getName()+":"+i);
			i++;
			System.out.println();
		}
	}
}

class SutThread2 extends Thread{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}