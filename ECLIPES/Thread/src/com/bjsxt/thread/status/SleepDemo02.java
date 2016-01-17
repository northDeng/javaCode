package com.bjsxt.thread.status;


/**
 * sleep ģ��������ʱ �̲߳���ȫ����
 * @author llf
 * 
 */
public class SleepDemo02 {
	public static void main(String[] args) {
		Web12306 wb=new Web12306();
		Thread t1=new Thread(wb,"·�˼�");
		Thread t2=new Thread(wb,"·����");
		Thread t3=new Thread(wb,"·�˱�");
		t1.start();
		t2.start();
		t3.start();
	}
}
class Web12306 implements Runnable{
	private int num=100;

	@Override
	public void run() {
		while(true){
			if(num<=0){
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"������"+num--);
		}
	}
	
}