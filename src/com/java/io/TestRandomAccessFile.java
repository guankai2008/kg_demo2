package com.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

/*
 * RandmoAccessFile:֧���������
 * 1.���Գ䵱��������Ҳ�����������
 * 2.֧���ļ��Ŀ�ͷ��ȡ��д��
 * 3.֧��������ְ�Ķ�ȡ��д�루���룩
 */
public class TestRandomAccessFile {
	/*
	 * Ҫ������ı����л��С�
	 */
	@Test
	public void test3(){
		
		RandomAccessFile raf=null;		
		try {
			raf = new RandomAccessFile(new File("hello1.txt"),"rw");
			//System.out.println(raf.getFilePointer());
			StringBuffer sb=new StringBuffer();
			raf.seek(4);
			byte [] b=new byte[4];
			int len;
				while((len=raf.read(b))!=-1){
				sb.append(new String(b,0,len));
			}
				raf.seek(4);
				raf.write("testinsert".getBytes());
				raf.write(sb.toString().getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

	
	//���룬RandomAccessFile����ֱ�Ӳ��룬�ǰѲ���Ǳ�������滻��
	//��ɲ��룬�ȰѽǱ굽���ĸ��Ƶ��ַ������ٲ������ݣ��ٰɲ����ļ���Ĳ���
	@Test
	public void test2(){
		RandomAccessFile raf=null;
		try {
			raf = new RandomAccessFile(new File("hello1.txt"),"rw");
			raf.seek(3);//��ָ��֪��Ҫ����λ�õĽǱ�
			String str=raf.readLine();//���Ǳ����ļ���ȡ��һ���ַ�����
			/*long l=raf.getFilePointer(); //��ӡ��ָ�����ڽǱ�λ��
			
			System.out.println(l);*/ 
			raf.seek(3);//�ٽ�ָ��ָ�ӵ�Ҫ�����λ��
			raf.write("xy".getBytes());//ִ�в���
			raf.write(str.getBytes());//�ٰ��ļ��ļ����ƻ���
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(raf!=null){
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//����
	@Test
	public void test1(){
		RandomAccessFile raf1=null;
		RandomAccessFile raf2=null;
		try {
			raf1 = new RandomAccessFile(new File("hello.txt"), "r");
			raf2 = new RandomAccessFile(new File("hello1.txt"),"rw");
			byte [] t=new byte[5];
			int i;
			while((i=raf1.read(t))!=-1){
				raf2.write(t, 0, i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(raf2!=null){
				try {
					raf2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(raf1!=null){
				try {
					raf1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
