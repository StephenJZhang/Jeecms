package com.jeecms.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private static Logger log  = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/test")
    public Object test() throws Exception {
		
        BufferedImage image = ImageIO.read(new File("d:\\test.jpg"));//读取图片
        Graphics g = image.getGraphics();//画笔
        g.setColor(Color.RED);// 设置画笔颜色
        g.drawRect(150, 100, 150, 100);//根据坐标标注矩形
        FileOutputStream out = new FileOutputStream("d:\\test6.jpg");//输出图片的地址
        ImageIO.write(image, "jpeg", out);
        g.dispose();// close 释放
        out.close();
    	return "test";
    }
	
	
	
	@RequestMapping("/test2")
    public Object test2() throws Exception {
		int width = 100;     
        int height = 100;     
        String s = "你好";     
             
        File file = new File("d:\\image.jpg");     
             
        Font font = new Font("Serif", Font.BOLD, 10);     
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);     
        Graphics2D g2 = (Graphics2D)bi.getGraphics();     
        //g2.setBackground(Color.WHITE);     
        //g2.clearRect(0, 0, width, height);     
        g2.setPaint(Color.CYAN);   
        g2.setColor(Color.cyan);
        FontRenderContext context = g2.getFontRenderContext();     
        Rectangle2D bounds = font.getStringBounds(s, context);     
        double x = (width - bounds.getWidth()) / 2;     
        double y = (height - bounds.getHeight()) / 2;     
        double ascent = -bounds.getY();     
        double baseY = y + ascent;     
        g2.drawRect(150, 100, 150, 100);
        //g2.drawString(s, (int)x, (int)baseY);     
             
        ImageIO.write(bi, "jpg", file);      
    	return "test";
    }
	
	@RequestMapping("/test3")
    public Object test3() throws Exception {
		int width = 100;     
        int height = 100;     
        File file = new File("d:\\image4.jpg");     
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);     
        Graphics g2 = (Graphics)bi.getGraphics();     
        g2.setColor(Color.cyan);   
        g2.drawLine(100, 100, 100, 100);
        ImageIO.write(bi, "jpg", file);      
    	return "test3";
    }
}
