package com.smartnerd.serviceImp;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;

public class IDCard_Generator {

	static void Image(byte[] imageFile, File sourceImageFile, File destImageFile) {
		try {
			BufferedImage sourceImage = ImageIO.read(sourceImageFile);
			BufferedImage watermarkImage = ImageIO.read(new ByteArrayInputStream(imageFile));
			Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
			g2d.drawImage(watermarkImage, 87, 250, 489, 650, null);
			ImageIO.write(sourceImage, "png", destImageFile);
			g2d.dispose();
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
	static void addQr(byte[] qrimg, File sourceImageFile, File destImageFile) {
		try {
			BufferedImage sourceImage = ImageIO.read(sourceImageFile);
			BufferedImage watermarkImage = ImageIO.read(new ByteArrayInputStream(qrimg));
			Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
			g2d.drawImage(watermarkImage,490,900,160,160,null);
			ImageIO.write(sourceImage, "png", destImageFile);
			g2d.dispose();
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	static void Back(String text, String type, File source, File destination) throws IOException, FontFormatException {
		BufferedImage image = ImageIO.read(source);

		int imageType = "png".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
		BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);

		Graphics2D w = (Graphics2D) watermarked.getGraphics();
		w.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		w.drawImage(image, 0, 0, null);

		w.setColor(Color.BLACK);
		File BariolFont = new ClassPathResource("bariol.otf").getFile();
		Font font = Font.createFont(Font.TRUETYPE_FONT, BariolFont);
		font = font.deriveFont(Font.BOLD, 28);
		w.setFont(font);
		w.drawString(text, 310, 345);
		ImageIO.write(watermarked, type, destination);
		w.dispose();
	}

	public static void joinBufferedImage(File destImageFile, File destImageFileend, File actudestImageFilefront)
			throws IOException {
		BufferedImage img1 = ImageIO.read(destImageFile);
		BufferedImage img2 = ImageIO.read(destImageFileend);
		int offset = 50;
		int width = img1.getWidth() + img2.getWidth() + offset;
		int height = Math.max(img1.getHeight(), img2.getHeight());
		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = newImage.createGraphics();
		g2.drawImage(img1, null, 0, 0);
		g2.drawImage(img2, null, img1.getWidth() + offset, 0);
		g2.dispose();
		ImageIO.write(newImage, "png", actudestImageFilefront);

	}
	static void frontAddingText(String name,String id, String blood, String type,  File source, File destination) throws IOException, FontFormatException {
		BufferedImage image = ImageIO.read(source);
		int imageType = "png".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
		BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);
		Graphics2D w = (Graphics2D) watermarked.getGraphics();
		w.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		w.drawImage(image, 0, 0, null);
		w.setColor(Color.BLACK);
		File BariolFont = new ClassPathResource("bariol.otf").getFile();
		Font font = Font.createFont(Font.TRUETYPE_FONT, BariolFont);
		font = font.deriveFont(Font.PLAIN, 45);
		w.setFont(font);
		w.drawString(name, 85, 960);
		font = font.deriveFont(Font.PLAIN, 36);
		w.setFont(font);
		w.drawString("Blood Group :", 85, 1015);
		w.drawString(blood, 278, 1015);
		w.setFont(font);
		AffineTransform at = new AffineTransform();
		at.setToRotation(Math.toRadians(270), 80, 100);
		w.setTransform(at);
		w.drawString(id, -480, 650);
		font = font.deriveFont(Font.PLAIN, 34);
		ImageIO.write(watermarked, type, destination);
		w.dispose();
	}
}
