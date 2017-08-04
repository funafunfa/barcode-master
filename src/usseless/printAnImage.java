package usseless;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;


public class printAnImage {
    public static void main(String[] args) {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(new Printable() {
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex != 0) {
                    return NO_SUCH_PAGE;
                }

                File sourceimage = new File("joineds.png");
                    if (sourceimage.exists()){
                        System.out.println("Here");
                        try {
                            Image image = ImageIO.read(sourceimage);
                            graphics.drawImage(image, 0, 0, 20, 20, null);
                            return PAGE_EXISTS;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println("Ploho");

                    }


                return 1;
            }
        });
        try {
            printJob.print();
        } catch (PrinterException e1) {
            e1.printStackTrace();
        }
    }
}
