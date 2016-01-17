package cn.bjsxt.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏窗口类
 * @author llf
 *
 */
public class GameFrame extends Frame {//GUI:AWT,swing等实现窗口
	Image img = GameUtil.getImage("images/sun.jpg");
	
	/**
	 * 加载窗口
	 */
	public void launchFrame(){
		setSize(500,500);
		setLocation(100,100);
		setVisible(true);
		
		new PaintThread().start();//启动重画线程
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {		
				System.exit(0); 
			}
			
		});
	}
	
	
	private double x=100 ,y=100;
	@Override
	public void paint(Graphics g) {
		g.drawLine(100, 100, 200, 200);
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100,100,200,200);
		Font f = new Font("宋体",Font.BOLD,100);
		g.setFont(f);
		g.drawString("邓涛", 200, 200);
		Color c = g.getColor();//先保存颜色
		g.setColor(Color.red);
		g.fillOval(100, 100, 20,20);
		g.setColor(c);
		g.drawImage(img, (int)x, (int)y,null);
		x += 3;
		y += 3;
		
	}
	/**
	 * 定义一个重画窗口的线程类，是一个内部类，
	 * @author llf
	 *
	 */
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//1s = 1000 ms
			}
		}
	}

	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}

}
