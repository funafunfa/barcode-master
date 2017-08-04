package usseless;

import com.sun.org.apache.xml.internal.serialize.Printer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.Size2DSyntax;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSize;
import javax.swing.*;

public class PrintImage {
    static public void main(String args[]) throws Exception {
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(new Copies(1));

        PrintService pss[] = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.PNG, pras);
        if (pss.length == 0)
            throw new RuntimeException("No printer services available.");
        for (PrintService printer: pss
             ) {
            System.out.println(printer.toString());

        }
        PrintService ps = pss[3];
        System.out.println("Printing to " + ps);
        DocPrintJob job = ps.createPrintJob();
        FileInputStream fin = new FileInputStream("Untitled.png");
//        fin.set
        Doc doc = new SimpleDoc(fin, DocFlavor.INPUT_STREAM.PNG, (DocAttributeSet) new MediaSize(123,2,123));
        job.print(doc, pras);
        fin.close();
    }


}