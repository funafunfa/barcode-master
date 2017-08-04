package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;


import javax.swing.ImageIcon;

import static main.Main.combinedFileName;
import static main.Main.doubledFileName;

public class oneMoreTimeBabe {{
}

    static class MyPrintable implements Printable {
        // TODO: 8/3/2017 Change path
        ImageIcon printImage = new javax.swing.ImageIcon(doubledFileName);

        public int print(Graphics g, PageFormat pf, int pageIndex) {
            Graphics2D g2d = (Graphics2D) g;
            g.translate((int) (pf.getImageableX()), (int) (pf.getImageableY()));
            if (pageIndex == 0) {
                //Scaling to the 50% original
                g2d.scale(0.5, 0.5);
                g.drawImage(printImage.getImage(), 0, 0, null);
                return Printable.PAGE_EXISTS;
            }
            return Printable.NO_SUCH_PAGE;
        }
    }
}