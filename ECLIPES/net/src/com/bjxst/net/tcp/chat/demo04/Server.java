package com.bjxst.net.tcp.chat.demo04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * ����������
 * 
 * @author llf
 *
 */
public class Server {
	private List<MyChannel> all= new ArrayList<MyChannel>();
	
	public static void main(String[] args) throws IOException {
		new Server().start();
	}
	public void start() throws IOException{
		ServerSocket server= new ServerSocket(6666);
		while(true){
			Socket client =server.accept();//�����׽��ֽڵ�
			MyChannel channel =new MyChannel(client);
			all.add(channel);//ͳһ����
			new Thread(channel).start();//һ����·
		}
	
		
	}
/**
 * һ���ͻ���һ����·
 * 1��������
 *2�������
 *3����������
 *4���������� 	
 * @author llf
 *
 */
	
	
private class MyChannel implements Runnable{
	private DataInputStream dis;
	private DataOutputStream dos;
	private String name;
	private boolean isRunning=true;
public MyChannel(Socket client){
		try {
			dis=new DataInputStream(client.getInputStream());
			dos= new DataOutputStream(client.getOutputStream());
			this.name = dis.readUTF();
			this.send("��ӭ����������");
			sendOthers(this.name+"����������",true);
		} catch (IOException e) {
			CloseUtil.Close(dis,dos);
			isRunning =false;
		}
	}
	/**
	 * ��������
	 * @return
	 */
	
	private String receive(){
		String msg="";
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
			CloseUtil.Close(dis,dos);
			isRunning =false;
			all.remove(this);
			

		}
		return msg;
	}
	/**
	 * ��������
	 * @param msg
	 */
	private void send(String msg){
		if(null==msg || msg.equals("")){
			return ;
		}
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			CloseUtil.Close(dis,dos);
			isRunning =false;
			all.remove(this);

		}
		
	}
	/**
	 * ���͸������ͻ���
	 */
	public void sendOthers(String msg,boolean sys){
		//��������
		//˽��     �Թ̶��ĸ�ʽ�����ж�ȡ
		if(msg.startsWith("@")&& msg.indexOf(":")>-1){//startsWith�����Ƿ��ָ���ַ�����ʼindexOf����ָ���ַ��ڴ��ַ����е�һ�γ��ִ�������
			String name = msg.substring(1,msg.indexOf(":"));//����һ�����ַ��������Ǵ��ַ�����һ�����ַ����������ַ�����ָ���� beginIndex ����ʼ��ֱ������ endIndex - 1 �����ַ�
			String content =msg.substring(msg.indexOf(":")+1);//����һ���µ��ַ��������Ǵ��ַ�����һ�����ַ����������ַ�����ָ�����������ַ���ʼ��ֱ�����ַ���ĩβ
			for(MyChannel other:all){
				if(other.name.equals(name)){
					//˽��
					other.send(this.name+"��������˵:"+content);
				}
			}
		}else{
			for(MyChannel other:all){
				if(other==this){
					continue;
				}
				if(sys){//sysΪtrueʱ��Ϊϵͳ��Ϣ
					//ϵͳ��Ϣ
					other.send("ϵͳ��Ϣ"+msg);
				}else{
				//���͸������ͻ���
				other.send(this.name+"��������˵"+msg);
				}
			}
		}
	}
	
	public void run() {
		while(isRunning){
		sendOthers(receive(),false);
		}
	}
	
}
}