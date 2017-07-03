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



/*
 * Thread()的常用方法：
 *  1.start() :启动线程并执行相应的run()方法。
 *  2.run() :  子线程要执行的代码放入run()方法。
 *  3.currentThread():静态的，调用当前线程。
 *  4.getName():获取当前线程的名字。
 *  5.setName()：设置线程的名字。
 *  6.yield(); 执行此方法后，强制释放当期线程的cpu执行权。
 *  7.join();在A线程中调用B线程的join方法，表示当执行到此join时，A线程终止，B线程开始执行，直到B线程执行完成。
 *  8.isAlive():线程是否还存活。
 *  9.sleep(long l)：显示的让当前线程睡眠l毫秒。
 */
public class TestThread2 {
	public static void main(String[] args) {
		//3.创建子类的对象
				SutThread1 st=new SutThread1();
				
		//4.调用线程的start的方法：启动此线程;调用相应的run方法
				st.setName("分线程1");
				st.start();
				int i=0;
				
				Thread.currentThread().setName("-----+主线程");
				while(i<100){
					System.out.print(Thread.currentThread().getName()+":"+i);
					/*if(i%10==0){
						Thread.currentThread().yield();
					}*/
					if(i==20){
						try {
							st.join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					i++;
					System.out.println();
					
			}
				System.out.println(st.isAlive());
	}	
}
//1.创建一个继承于thread的子类
class SutThread1 extends Thread{
	//2.重写Thread类的run方法。方法实现线程完成的工作
	public void run(){
		int i=0;
		while(i<100){
			System.out.print(Thread.currentThread().getName()+":"+i);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
			System.out.println();
		}
	}
}

