package cn.bjxst.io.Others;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo01 {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("test");
		PrintStream ps=System.out;
		ps.println(false);
//������ļ�
		File src=new File("E:/Java/print.txt");
		ps =new PrintStream(new BufferedOutputStream(new FileOutputStream(src)));
		ps.println("io is so easy");
		ps.close();
	}

}
