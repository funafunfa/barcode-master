package main;


import java.awt.*;
import java.awt.image.BufferedImage;



public class doublingPNGs {

    public static BufferedImage doubleBufferedImage(BufferedImage img1, BufferedImage img2) {

        //do some calculate first
        /*

        Some weird magic

        */
        int offset  = 100;
        int wid =img1.getWidth();
        int height =(img1.getHeight() *2) + offset ;
        //create a new buffer and draw two image into the new image
        BufferedImage newImage = new BufferedImage(wid,height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        //fill background
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, wid, height);
        //draw image
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, img2.getHeight()+offset);
        g2.drawImage(img2, null, 0, 0);
        g2.dispose();
        return newImage;
    }
}
