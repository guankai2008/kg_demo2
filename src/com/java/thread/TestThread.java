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
public class TestThread {
	public static void main(String[] args) {
		//3.��������Ķ���
				SutThread st=new SutThread();
				SutThread2 st2=new SutThread2();
		//4.�����̵߳�start�ķ������������߳�;������Ӧ��run����
	
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
//1.����һ���̳���thread������
class SutThread extends Thread{
	//2.��дThread���run����������ʵ���߳���ɵĹ���
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