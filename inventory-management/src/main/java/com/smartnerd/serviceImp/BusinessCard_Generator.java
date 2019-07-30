package com.smartnerd.serviceImp;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;

public class BusinessCard_Generator {

	static void bccreation(File sourceBackImageFile, File destImageFileend, File actudestImageFilefront, String name,
			String email, String phno, String designation) throws IOException, FontFormatException {
		BufferedImage image = ImageIO.read(sourceBackImageFile);

		int imageType = "png".equalsIgnoreCase("png") ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
		BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);
		Graphics2D w = (Graphics2D) watermarked.getGraphics();
		w.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		w.drawImage(image, 0, 0, null);
		w.setColor(Color.BLACK);
		File BariolFont = new ClassPathResource("bariol.otf").getFile();
		Font font = Font.createFont(Font.TRUETYPE_FONT, BariolFont);
		font = font.deriveFont(Font.BOLD, 34);
		w.setFont(font);
		w.drawString(name, 40, 85);
		font = font.deriveFont(Font.PLAIN, 34);
		w.setFont(font);

		w.drawString(designation, 40, 130);
		font = font.deriveFont(Font.PLAIN, 32);
		w.setFont(font);		
		String ph = "+91 " + phno.substring(0, 5) + " " + phno.substring(5);
		w.drawString(ph, 40, 180);
		w.setColor(new Color(3, 53, 86));
		w.drawString(email, 689, 518);

		ImageIO.write(watermarked, "png", destImageFileend);
		w.dispose();

	}

	static void bcqr(File sourceBackImageFile, File destImageFileend, File qrimg) {
		try {
			BufferedImage sourceImage = ImageIO.read(sourceBackImageFile);
			BufferedImage watermarkImage = ImageIO.read(qrimg);

			Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
			g2d.drawImage(watermarkImage, 930, 298, 100, 100, null);

			ImageIO.write(sourceImage, "png", destImageFileend);
			g2d.dispose();

		} catch (IOException ex) {
			System.err.println(ex);
		}
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
}

