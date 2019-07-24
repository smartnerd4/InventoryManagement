package com.smartnerd.serviceImp;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IDCard_Generator {
	static void Name(String text, String type, File source, File destination) throws IOException {
		BufferedImage image = ImageIO.read(source);

		int imageType = "png".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
		BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);

		Graphics2D w = (Graphics2D) watermarked.getGraphics();
		w.drawImage(image, 0, 0, null);
		w.setColor(Color.BLACK);
		w.setFont(new Font(Font.SERIF, Font.PLAIN, 42));
		FontMetrics fontMetrics = w.getFontMetrics();
		Rectangle2D rect = fontMetrics.getStringBounds(text, w);
		int centerX = (image.getWidth() - (int) rect.getWidth()) / 2;
		w.drawString(text, centerX, 960);
		ImageIO.write(watermarked, type, destination);
		w.dispose();
	}

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

	static void Id(String text, String type, File source, File destination) throws IOException {
		BufferedImage image = ImageIO.read(source);
		int imageType = "png".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
		BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);
		Graphics2D w = (Graphics2D) watermarked.getGraphics();
		w.drawImage(image, 0, 0, null);
		w.setColor(Color.BLACK);
		w.setFont(new Font(Font.SERIF, Font.PLAIN, 36));
		FontMetrics fontMetrics = w.getFontMetrics();
		Rectangle2D rect = fontMetrics.getStringBounds(text, w);
		int centerX = (image.getWidth() - (int) rect.getWidth()) / 2;
		int centerY = image.getHeight() / 2;

		w.drawString(text, 100, 1010);

		ImageIO.write(watermarked, type, destination);
		w.dispose();
	}

	static void Blood(String text, String type, File source, File destination) throws IOException {
		BufferedImage image = ImageIO.read(source);

		int imageType = "png".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
		BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);

		Graphics2D w = (Graphics2D) watermarked.getGraphics();
		w.drawImage(image, 0, 0, null);
		w.setColor(Color.BLACK);
		w.setFont(new Font(Font.SERIF, Font.PLAIN, 36));
		FontMetrics fontMetrics = w.getFontMetrics();
		Rectangle2D rect = fontMetrics.getStringBounds(text, w);
		int centerX = (image.getWidth() - (int) rect.getWidth()) / 2;
		int centerY = image.getHeight() / 2;

		w.drawString(text, 480, 1010);

		ImageIO.write(watermarked, type, destination);
		w.dispose();
	}

	static void addQr(byte[] qrimg, File sourceImageFile, File destImageFile) {
		try {
			BufferedImage sourceImage = ImageIO.read(sourceImageFile);
			BufferedImage watermarkImage = ImageIO.read(new ByteArrayInputStream(qrimg));
			Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
			g2d.drawImage(watermarkImage, 510, 235, 140, 140, null);
			ImageIO.write(sourceImage, "png", destImageFile);
			g2d.dispose();
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
