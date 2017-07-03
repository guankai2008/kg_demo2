package com.java.thread;
/*
 * ����һ�����̣߳����1-100֮�����Ȼ�������ͬ���ġ����߳�ִ��ͬ������
 * 
 * 
 * ����1. ����һ��extends Thread�����ࡣ
 *     2. ������д run����(�����ڲ���Ҫʵ�ֵĹ���)
 *     3. ���̴߳�������Ķ���ʵ����
 *     4. �������Thread��start������
 *     5. һ ���߳�ֻ��startһ�Ρ�
 *     6. ����ͨ��Tread�������run�����ķ�ʽ���������ǵ��̡߳�
 * 
 */



/*
 * Thread()�ĳ��÷�����
 *  1.start() :�����̲߳�ִ����Ӧ��run()������
 *  2.run() :  ���߳�Ҫִ�еĴ������run()������
 *  3.currentThread():��̬�ģ����õ�ǰ�̡߳�
 *  4.getName():��ȡ��ǰ�̵߳����֡�
 *  5.setName()�������̵߳����֡�
 *  6.yield(); ִ�д˷�����ǿ���ͷŵ����̵߳�cpuִ��Ȩ��
 *  7.join();��A�߳��е���B�̵߳�join��������ʾ��ִ�е���joinʱ��A�߳���ֹ��B�߳̿�ʼִ�У�ֱ��B�߳�ִ����ɡ�
 *  8.isAlive():�߳��Ƿ񻹴�
 *  9.sleep(long l)����ʾ���õ�ǰ�߳�˯��l���롣
 */
public class TestThread2 {
	public static void main(String[] args) {
		//3.��������Ķ���
				SutThread1 st=new SutThread1();
				
		//4.�����̵߳�start�ķ������������߳�;������Ӧ��run����
				st.setName("���߳�1");
				st.start();
				int i=0;
				
				Thread.currentThread().setName("-----+���߳�");
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
//1.����һ���̳���thread������
class SutThread1 extends Thread{
	//2.��дThread���run����������ʵ���߳���ɵĹ���
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

