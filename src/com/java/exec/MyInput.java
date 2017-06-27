package com.java.exec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

/*
 * Create a program named MyInput.java: 
 * Contain the methods for reading int, double,
 *  float, boolean, short, byte and String values from the keyboard
 */
public class MyInput {
	/*
	 * 从键盘获取一个String的字符串，return出去；
	 */
	public static String myString(){
		//通过键盘获取一个InputStream传给InputStreamReader,进行解码。
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String str=null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
	}
	public static int myInt(){
		Integer i=null;
		return i.parseInt(myString());
	}
	public static boolean myBoolean(){
		Boolean b=false;
		return b.parseBoolean(MyInput.myString());
	}
	
	
	
	@Test
	public void test1(){
		System.out.println("请输入一个字符串");
		String str=	MyInput.myString();
		System.out.println(str);
	}
	@Test
	public void test2(){
		System.out.println("请输入一个数字");
		int i=MyInput.myInt();
		System.out.println(i);
	}
	@Test
	public void test3(){
		System.out.println("请输入true或者false");
		boolean b=MyInput.myBoolean();
		System.out.println(b);
	}
	
	
}
