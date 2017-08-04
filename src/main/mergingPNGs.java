package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * This code try to join two BufferedImage
 * @author wangdq
 * 2013-12-29
 */
public class mergingPNGs {

    /**
     * join two BufferedImage
     * you can add a orientation parameter to control direction
     * you can use a array to join more BufferedImage
     */

    public static BufferedImage joinBufferedImage(BufferedImage img1,BufferedImage img2, BufferedImage img3) {

        //do some calculate first
        int offset  = 10;
        int wid = Math.max(Math.max(img1.getWidth(),img2.getWidth()),Math.max(img2.getWidth(),img3.getWidth()))+offset;

        int height =img1.getHeight()+img2.getHeight()+img3.getHeight()+(offset*2);
        //create a new buffer and draw two image into the new image
        BufferedImage newImage = new BufferedImage(wid,height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, wid, height);
        g2.setColor(oldColor);
        Integer one, two ,three, max = null;
        one = img1.getWidth();
        two = img2.getWidth();
        three = img3.getWidth();
        max = Math.max(Math.max(one, two),Math.max(two, three));
        g2.drawImage(img1, null, 4 + ((max - img1.getWidth())/2), 0);
        g2.drawImage(img2, null, 4 + ((max - img2.getWidth())/2),img1.getHeight()+offset);
        g2.drawImage(img3, null, 4 + ((max - img3.getWidth())/2), (img1.getHeight()+ img2.getHeight())+(offset * 2));
        g2.dispose();
        return newImage;
    }
}