package main;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import javax.swing.*;

import static main.Main.combinedPreviewFileName;
import static main.Main.deleteFile;
import static main.Main.firstText;

public class mainGraphics extends JFrame {
    JButton printButton, previewButton, saveButton, openButton;
    JTextField nameField, serialField, problemField;
    public static JLabel imagelabel;

    public mainGraphics() {
        super("Barcode");
        createGUI();
    }
    public void createGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        printButton = new JButton("Print");
        printButton.setBounds(25, 400, 90, 40);
        printButton.addActionListener(e -> {
            validation(serialField);
            validation(problemField);
            validation(nameField);
            if(validation(serialField) && validation(problemField) && validation(nameField)){
                System.out.println("ready to print");
                String[] mainArray = new String[4];
                mainArray[0] = nameField.getText();
                mainArray[1] = serialField.getText();
                mainArray[2] = problemField.getText();
                mainArray[3] = "print";
                // TODO: 8/3/2017 delete OPEN
                try {
                    Main.main(mainArray);

                } catch (BarcodeException | OutputException e1) {
                    e1.printStackTrace();
                }
            }
        });
        panel.add(printButton);

        previewButton = new JButton("Preview");
        previewButton.setBounds(180, 400, 90, 40);
        previewButton.addActionListener(e -> {
            validation(serialField);
            validation(problemField);
            validation(nameField);
            if(validation(serialField) && validation(problemField) && validation(nameField)){
                System.out.println("ready to preview");
                String[] mainArray = new String[4];
                mainArray[0] = nameField.getText();
                mainArray[1] = serialField.getText();
                mainArray[2] = problemField.getText();
                mainArray[3] = "preview";
                // TODO: 8/3/2017 Learn how to delete PREVIEW FILES 
                try {
                    Main.main(mainArray);

                } catch (BarcodeException | OutputException e1) {
                    e1.printStackTrace();
                }
            }
        });
        // One more time, just disabling (useless and to much work to do it good)
//        panel.add(previewButton);
        previewButton.setEnabled(false);
        previewButton.setVisible(false);

        saveButton = new JButton("Save");
        saveButton.setBounds(415, 400, 90, 40);
        // TODO: 8/3/2017 Usseless button, delete it
        saveButton.setEnabled(false);
        saveButton.setVisible(false);
        //just disabling it
//        panel.add(saveButton);
        saveButton.setEnabled(false);
        saveButton.setVisible(false);

        openButton = new JButton("Open");
        openButton.setBounds(565, 400, 90, 40);
        panel.add(openButton);
        openButton.addActionListener(e -> {
            JFileChooser fileopen = new JFileChooser();
            File workingDirectory = new File(System.getProperty("user.dir"));
            fileopen.setCurrentDirectory(workingDirectory);

            int ret = fileopen.showDialog(null, "OpenBarCode");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                ImageIcon image_preview = new ImageIcon(String.valueOf(file));
                imagelabel.setIcon(image_preview);
    /*
     * Какие-то действия.
     */
            }
        });

        nameField = new JTextField();
        nameField.setBounds(25, 20, 205, 30);
        panel.add(nameField);
        nameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                nameField.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                nameField.setBackground(Color.WHITE);
            }
        });

        serialField = new JTextField();
        serialField.setBounds(25, 80, 205, 30);
        panel.add(serialField);
        serialField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                serialField.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        problemField = new JTextField();
        problemField.setBounds(25, 140, 205, 30);
        panel.add(problemField);
        problemField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                problemField.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });


        imagelabel = new JLabel();
        imagelabel.setBounds(300, 20,300,350);


        getContentPane().add(imagelabel);

        getContentPane().add(panel);
        setPreferredSize(new Dimension(285, 145));
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            mainGraphics frame = new mainGraphics();
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    if (JOptionPane.showConfirmDialog(frame,
                            "Are you sure to close this window?", "Really Closing?",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        try{
                            deleteFile(combinedPreviewFileName);
                            deleteFile(firstText);
                        }catch (NullPointerException e){
                            e.printStackTrace();
                        }

                        System.exit(0);
                    }
                }
            });
            frame.pack();
            frame.setResizable(false);
            frame.setBounds(200,300,700,500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public boolean validation(JTextField caller){
        if (caller.getText().isEmpty()){
            caller.setBackground(Color.RED);
            return false;
        }else{
            return true;
        }
        }
    }