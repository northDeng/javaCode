package com.bjxst.net.tcp.chat.demo03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据
 * @author llf
 *
 */
public class Send implements Runnable {
	//控制台输入流
	private BufferedReader console;
	//管道输出流
	private DataOutputStream dos;
	//控制线程
	private boolean isRunning=true;
	//初始化数据
	public Send() {
		console=new BufferedReader(new InputStreamReader(System.in));
	}
	public Send(Socket client){
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			isRunning =false;
			CloseUtil.Close(dos,console);
		}
		
	}
	//从控制台接收数据
	public String getMsgFormConsle(){
		
		try {
			return console.readLine();
		} catch (IOException e) {
			
		}
		return "";
	}
	//发送数据
	public void send(){
		String info=getMsgFormConsle();
		try {
			if(null!=info&&!info.equals("")){
				dos.writeUTF(info);
				dos.flush();//强制刷新
			}
		} catch (IOException e) {
			isRunning=false;
			CloseUtil.Close(dos,console);
		}
		
	}
	public void run() {
		while(isRunning){
			//线程体
			send();
		}
		
	}

}
