package Notepad.notepad;
import bracechecker.BraceChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.MenuBar;
import java.awt.event.*;
import java.io.*;

import static notepad.Constants.*;

public class Notepad extends JFrame implements ActionListener{

    public void initSystemLookAndFeel() {
        try {
            String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(systemLookAndFeelClassName);
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Can't use the specified look and feel on this platform.");
        } catch (Exception e) {
            System.err.println("Couldn't get specified look and feel, for some reason.");
        }
    }

    private JFileChooser fc = new JFileChooser();

    private String content;
    private JTextArea textArea;
    private JTextField textField;
    private java.awt.MenuBar menuBar = new MenuBar();

    public Notepad() {

        super("Notepad_1.00");
        initSystemLookAndFeel();


        setJMenuBar(menuBar);
        BraceChecker.getInstance();

        textField = new JTextField();
        textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);
        textField.setEnabled(false);
        add(textField, BorderLayout.SOUTH);


        menuBar.get_new().addActionListener(this);
        menuBar.getOpen().addActionListener(this);
        menuBar.getSave().addActionListener(this);
        menuBar.getSaveAs().addActionListener(this);
        menuBar.getExit().addActionListener(this);

        menuBar.getEn().addActionListener(this);
        menuBar.getRu().addActionListener(this);
        menuBar.getHy().addActionListener(this);

        setVisible(true);
        setLocation(300, 300);
        setSize(500, 500);



        setDefaultCloseOperation(EXIT_ON_CLOSE);







        textArea.addKeyListener(new KeyListener() {


            @Override
            public void keyTyped(KeyEvent e) {


            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

                BraceChecker braceChecker = BraceChecker.getInstance();
                braceChecker.parse(textArea.getText());
                textField.setText(braceChecker.getResultInfo().getMessage());
            }
        });

    }






    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== _NEW) {
            int nuask = JOptionPane.showConfirmDialog(Notepad.this,"Are you sure? This will make a erease any unsaved documents!");
            if (nuask == JOptionPane.YES_OPTION) {
                textArea.setText("");
            }
        }
        if (e.getSource() == OPEN) {
            content="";
            content= textArea.getText();
            if (content.equals((textArea.getText()))) {


            }
            int returnVal = fc.showOpenDialog(Notepad.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    BufferedReader inputStream = new BufferedReader(new FileReader(file.getPath()));
                    String inputLine;
                    textArea.setText("");
                    setTitle("Notepad-"+file.getName());
                    while((inputLine = inputStream.readLine()) != null) {
                        textArea.append(inputLine+"\n");
                    }
                }
                catch(FileNotFoundException ioe) {
                    JOptionPane.showMessageDialog(null, "Sorry,File Not Found", "", JOptionPane.WARNING_MESSAGE );
                }
                catch(IOException ioe) {
                    System.out.println(file.getAbsoluteFile());
                }
            }
        }
        if (e.getSource() == SAVE) {
            content = textArea.getText();
            try {
                File file = fc.getSelectedFile();
                FileWriter outputStream=new FileWriter(file.getPath());
                outputStream.write(textArea.getText());
                outputStream.close();
                setTitle("Text Editor-"+file.getName());
            }
            catch(IOException ioe) {
                System.out.println("IOException");
            }
        }
        if (e.getSource() == SAVE_AS) {
            int returnVal = fc.showSaveDialog(Notepad.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fc.getSelectedFile();
                    FileWriter outputStream=new FileWriter(file.getPath()+".txt");
                    setTitle("Notepad-"+file.getName());
                    outputStream.write(textArea.getText());
                    outputStream.close();
                }
                catch(IOException ioe) {
                    System.out.println("IOException");
                }
            }
        }
        if (e.getSource() == EXIT) {
            int aske = JOptionPane.showConfirmDialog(Notepad.this,"Are you sure you want to exit " +getTitle() + " ?");
            if (aske == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }


    }

    public static void showMessageDialog(Component c) {
        int newAsk = JOptionPane.showConfirmDialog(c,"Are you sure you want to exit?");
        if(newAsk == JOptionPane.YES_OPTION){
            System.exit(0);
        }

    }

    public static void main(String args[]) {


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                final JFrame f = new Notepad();

                f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                f.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent we) {
                        showMessageDialog(f);

                    }
                });
                f.setSize(500, 500);
                f.setVisible(true);

            }

        });

}

}