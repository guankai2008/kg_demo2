package com.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

public class TestObjectStream {
	@Test
	public void testObjectOutStream(){
		Person p1=new Person("ถþนท", 28);
		ObjectOutputStream oos=null;
		try {
			FileOutputStream fos=new FileOutputStream (new File("txtPer"));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(p1);
			oos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}

class Person implements Serializable{
	private String name;
	private Integer age;
	public Person(String s,int a){
		this.name=s;
		this.age=a;
	}
}