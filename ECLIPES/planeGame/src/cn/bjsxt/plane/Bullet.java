package cn.bjsxt.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cn.bjsxt.Util.Constant;

public class Bullet extends GameObject{

	double degree;
	
	public Bullet(){
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HEIGHT/2;
		width = 10;
		height = 10;
		
		
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		if(y> Constant.GAME_WIDTH-height || y<30){
			degree = -degree;
		}
		if(x<10 || x>Constant.GAME_HEIGHT-width  ){
			degree = Math.PI-degree;
		}
		
		g.setColor(c);
	}
}
