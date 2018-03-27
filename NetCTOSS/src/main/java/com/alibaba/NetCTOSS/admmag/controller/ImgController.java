package com.alibaba.NetCTOSS.admmag.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/img")
public class ImgController {

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET })
	public void getImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 现在内存绘制一张图片，第一个参数宽度，高度，图片显示样式TYPE_INT_RGB不透明
		BufferedImage image = new BufferedImage(55, 30, BufferedImage.TYPE_INT_RGB);
		// 获取到内存的图片，在java平台绘制一个平面图形
		Graphics2D g = (Graphics2D) image.getGraphics();
		// 设置背景颜色，将颜色填充到图片
		g.setColor(Color.orange);
		g.fillRect(0, 0, 55, 30);
		// 往图片上面写数据
		g.setColor(Color.WHITE);
		g.setFont(new Font("斜体", Font.BOLD, 20));
		String number = getNum();
		g.drawString(number, 5, 20);
		// 创建session对象，将验证码放入session
		HttpSession session = request.getSession();
		session.setAttribute("code", number);
		// 将图片发送回客户端，客户端不缓存服务器传递回去的验证码图片
		response.setContentType("image/jpeg");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("pramga", "no-cache");

		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	public String getNum() {
		Random ra = new Random();
		String num = ra.nextInt(9999) + "";
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < 4 - num.length(); i++) {
			buf.append("0");
		}
		String temp = buf.toString() + num;
		return temp;
	}
}
