package cn.bjsxt.testFile;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;

public class Text extends Frame{

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setUndecorated(true);
		f.setBackground(Color.red);
		f.setBounds(75, 75, 260, 90);
		Panel p =new Panel();
		Font font = new Font("����",Font.BOLD,38);
		Label label = new Label("��ӭ����");
		label.setForeground(Color.yellow);
		label.setFont(font);
		p.add(label);
		p.setBounds(5,5,250,80);
		p.setVisible(true);
		p.setBackground(Color.black);
		f.setLayout(null);
		f.add(p);
		f.setVisible(true);
	}
}





