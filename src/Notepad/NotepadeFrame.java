package Notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;



/**
 * Created by TatevTorosyan 21.03.2016.
 */

public class NotepadeFrame extends JFrame implements ActionListener {

    final static String PROGRAM_NAME = "Notepad TT";
    final static String FILE_DEFAULT_NAME = "Untitled";
    private JFileChooser fileChooser;
    private File file;

    private NotepadeMenuBar menuBar = new NotepadeMenuBar();
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public NotepadeFrame(String frameTitle) {
        super(frameTitle);

        fileChooser = new JFileChooser();

        menuBar.getMiNew().addActionListener(this);
        menuBar.getMiOpen().addActionListener(this);
        menuBar.getMiSave().addActionListener(this);
        menuBar.getMiSaveAs().addActionListener(this);
        menuBar.getMiPrint().addActionListener(this);
        menuBar.getMiPageSetup().addActionListener(this);
        menuBar.getMiExit().addActionListener(this);

        menuBar.getMiEn().addActionListener(this);
        menuBar.getMiRu().addActionListener(this);
        menuBar.getMiHy().addActionListener(this);

        setJMenuBar(menuBar);
        menuBar.initMenuLabels(LanguageType.ENG);

        textArea = new JTextArea();
        setLayout(new BorderLayout());
        add("Center", textArea);

        scrollPane = new JScrollPane();
        scrollPane.getViewport().add(textArea);
        add(scrollPane, BorderLayout.CENTER);

        setBounds(350, 350, 750, 500);
        setSize(750, 500);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(menuBar.getMiNew())) {
            handleNewFileAction();
        } else if (e.getSource().equals(menuBar.getMiOpen())) {
            handleOpenAction();
        } else if (e.getSource().equals(menuBar.getMiSave())) {
            save();
        } else if (e.getSource().equals(menuBar.getMiSaveAs())) {
            saveAs();
        } else if (e.getSource().equals(menuBar.getMiPrint())) {
            doFilePrint();
        } else if (e.getSource().equals(menuBar.getMiPageSetup())) {
            doFilePageSetup();
        } else if (e.getSource().equals(menuBar.getMiExit())) {
//            doFileClose();
        } else if (e.getSource().equals(menuBar.getMiEn())) {
            menuBar.initMenuLabels(LanguageType.ENG);
        } else if (e.getSource().equals(menuBar.getMiRu())) {
            menuBar.initMenuLabels(LanguageType.RUS);
        } else if (e.getSource().equals(menuBar.getMiHy())) {
            menuBar.initMenuLabels(LanguageType.ARM);
        }
    }


    private void handleNewFileAction() {
        if (isChanged() && !handleSaveConfirmDialog(ActionType.NEW)) {
            return;
        }
        newFile();
    }

    private void newFile() {
        file = null;
        setTitle(FILE_DEFAULT_NAME + " - " + PROGRAM_NAME);
        textArea.setText("");
    }

    /**
     * Opens a confirm dialog window to ask
     * save or no the content of TextArea or cancel the action.
     * if save is chosen then the content save,  otherwise if selected no nothing is saved.
     *
     * @return false if selected cancel option, otherwise true.
     */
    private boolean handleSaveConfirmDialog(ActionType actionType) {
        switch (askSave()) {
            case JOptionPane.CANCEL_OPTION:
                return false;
            case JOptionPane.YES_OPTION:
                if ((ActionType.SAVE_AS == actionType) || isNewMode()) {
                    saveAs();
                } else {
                    save();
                }
        }

        return true;
    }

    private void save() {
        if (isNewMode()) {
            saveAs();
        } else {
            write(file);
        }
    }

    private void saveAs() {
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            write(file);
        }
    }

    private void handleOpenAction() {
        if (isChanged() && !handleSaveConfirmDialog(ActionType.OPEN)) {
            return;
        }
        open();
    }

    private void open() {
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            textArea.setText(read(file));
            setTitle(PROGRAM_NAME + " - " + file.getName());
        }
    }

    private void write(File file) {
        try (FileOutputStream stream = new FileOutputStream(file)) {
            stream.write(textArea.getText().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean isNewMode() {
        return file == null;
    }

    private boolean isChanged() {
        if (file == null && textArea.getText().length() > 0) {
            return true;
        } else if (file != null &&
                !textArea.getText().equals(read(file))) {
            return true;
        }
        return false;
    }


    private String read(File file) {
        if (file == null) {
            throw new NullPointerException("The file can't be null");
        }
        int size = (int) file.length();
        byte[] result = new byte[size];
        try (FileInputStream stream = new FileInputStream(file)) {
            stream.read(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(result);
    }

    public void doFilePrint() {
        PrinterJob pj = PrinterJob.getPrinterJob();
        if (pj.printDialog()) {
            try {
                pj.print();
            } catch (PrinterException exc) {
                System.out.println(2 + exc.toString());
            }
        }
    }

    public void doFilePageSetup() {
        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat pf = pj.pageDialog(pj.defaultPage());
    }

//    public void doFileClose() {
//        if (checkeChanged()) {
//            int result = showSaveDialog();
//            if (result == 0) {
//                doFileSave();
//                if (!isChanged) {
//                    this.dispose();
//                }
//            } else if (result == 1) {
//                this.dispose();
//            }
//        } else {
//            this.dispose();
//        }
//    }


    private int askSave() {
        int returnVal = JOptionPane.showConfirmDialog(null, "Do you want save file");
        return returnVal;
    }


    enum ActionType {NEW, OPEN, SAVE, SAVE_AS, EXIT}

}

enum LanguageType {

    ARM(1, "hy", "Armenian"),
    RUS(2, "ru", "Russian"),
    ENG(3, "en", "English");

    int id;
    String label;
    String description;

    LanguageType(int id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }
}