package com.bjxst.net.URL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo02 {
	public static void main(String[] args) throws IOException {
		URL url =new URL("http://www.baidu.com");
		//获取资源  网络流
		/*
		InputStream is= url.openStream();
		byte [] flush= new byte[1024];
		int len =0;
		while(-1!=(len=is.read())){
			System.out.println(new String(flush,0,len));
		}
		is.close();
		*/
		//使用字节流输入输出
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"utf-8"));
		String msg=null;
		while((msg=br.readLine())!=null){
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
