package usseless;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by dcamo on 8/3/2017.
 */
public class mergingExample {
    public static BufferedImage joinBufferedImage(BufferedImage img1, BufferedImage img2) {

        //do some calculate first
        int offset  = 5;
//        int wid = img1.getWidth()+img2.getWidth()+offset;
        int wid = Math.max(img1.getWidth(),img2.getWidth())+offset;
        int height =img1.getHeight()+img2.getHeight()+offset;
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
        g2.drawImage(img2, null, 50, 0);
        g2.dispose();
        return newImage;
    }
}
