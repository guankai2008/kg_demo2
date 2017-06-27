package com.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

/*
 * RandmoAccessFile:支持随机访问
 * 1.可以充当输入流，也可以是输出流
 * 2.支持文件的开头读取、写入
 * 3.支持任意文职的读取、写入（插入）
 */
public class TestRandomAccessFile {
	/*
	 * 要插入的文本会有换行。
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
	

	
	//插入，RandomAccessFile不能直接插入，是把插入角标的内容替换了
	//完成插入，先把角标到最后的复制到字符串，再插入内容，再吧插入文件后的插入
	@Test
	public void test2(){
		RandomAccessFile raf=null;
		try {
			raf = new RandomAccessFile(new File("hello1.txt"),"rw");
			raf.seek(3);//将指针知道要插入位置的角标
			String str=raf.readLine();//将角标后的文件读取到一个字符串中
			/*long l=raf.getFilePointer(); //打印下指针所在角标位置
			
			System.out.println(l);*/ 
			raf.seek(3);//再将指针指挥到要插入的位置
			raf.write("xy".getBytes());//执行插入
			raf.write(str.getBytes());//再把文件文件复制回来
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
	
	//复制
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
