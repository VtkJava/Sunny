package Notepad;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by TatevTorosyan 22.03.2016.
 */

public class NotepadeMenuBar extends JMenuBar {

    private Properties properties;

    private JMenu mFile;
    private JMenuItem miNew;
    private JMenuItem miOpen;
    private JMenuItem miSave;
    private JMenuItem miSaveAs;
    private JMenuItem miPageSetup;
    private JMenuItem miPrint;
    private JMenuItem miExit;

    private JMenu mLang;
    private JMenuItem miEn;
    private JMenuItem miRu;
    private JMenuItem miHy;

    public NotepadeMenuBar() {

        mFile = new JMenu();
        miNew = new JMenuItem();
        mFile.add(miNew);
        miOpen = new JMenuItem();
        mFile.add(miOpen);
        miSave = new JMenuItem();
        mFile.add(miSave);
        miSaveAs = new JMenuItem();
        mFile.add(miSaveAs);
        mFile.addSeparator();
        miPageSetup = new JMenuItem();
        mFile.add(miPageSetup);
        miPrint = new JMenuItem();
        mFile.add(miPrint);
        mFile.addSeparator();
        miExit = new JMenuItem();
        mFile.add(miExit);

        add(mFile);

        mLang = new JMenu();
        miEn = new JMenuItem();
        mLang.add(miEn);
        miRu = new JMenuItem();
        mLang.add(miRu);
        miHy = new JMenuItem();
        mLang.add(miHy);
        add(mLang);
    }

    public JMenuItem getMiNew() {
        return miNew;
    }

    public void setMiNew(JMenuItem miNew) {
        this.miNew = miNew;
    }

    public JMenuItem getMiOpen() {
        return miOpen;
    }

    public void setMiOpen(JMenuItem miOpen) {
        this.miOpen = miOpen;
    }

    public JMenuItem getMiSave() {
        return miSave;
    }

    public void setMiSave(JMenuItem miSave) {
        this.miSave = miSave;
    }

    public JMenuItem getMiSaveAs() {
        return miSaveAs;
    }

    public void setMiSaveAs(JMenuItem miSaveAs) {
        this.miSaveAs = miSaveAs;
    }

    public JMenuItem getMiPageSetup() {
        return miPageSetup;
    }

    public void setMiPageSetup(JMenuItem miPageSetup) {
        this.miPageSetup = miPageSetup;
    }

    public JMenuItem getMiPrint() {
        return miPrint;
    }

    public void setMiPrint(JMenuItem miPrint) {
        this.miPrint = miPrint;
    }

    public JMenuItem getMiExit() {
        return miExit;
    }

    public void setMiExit(JMenuItem miExit) {
        this.miExit = miExit;
    }

    public JMenuItem getMiHy() {
        return miHy;
    }

    public void setMiHy(JMenuItem miHy) {
        this.miHy = miHy;
    }

    public JMenuItem getMiRu() {
        return miRu;
    }

    public void setMiRu(JMenuItem miRu) {
        this.miRu = miRu;
    }

    public JMenuItem getMiEn() {
        return miEn;
    }

    public void setMiEn(JMenuItem miEn) {
        this.miEn = miEn;
    }

    public void  initMenuLabels(LanguageType languageType) {
        String key = languageType == LanguageType.ARM
                ? "_" + LanguageType.ARM.getLabel()
                : languageType == LanguageType.RUS
                ? "_" + LanguageType.RUS.getLabel()
                : "";

        System.out.println();

        InputStream in = getClass().getClassLoader().getResourceAsStream("i18n/notepad" + key + ".properties");
        try {
            properties = new Properties();
            properties.load(in);
        } catch (IOException e) {
            System.err.println("Property file does not exist. " + e.getMessage());
            e.printStackTrace();
        }

        mFile.setText(properties.getProperty(LabelKey.FILE.getName()));
        miNew.setText(properties.getProperty(LabelKey.NEW.getName()));
        miOpen.setText(properties.getProperty(LabelKey.OPEN.getName()));
        miSave.setText(properties.getProperty(LabelKey.SAVE.getName()));
        miSaveAs.setText(properties.getProperty(LabelKey.SAVE_AS.getName()));
        miPageSetup.setText(properties.getProperty(LabelKey.PAGE_SETUP.getName()));
        miPrint.setText(properties.getProperty(LabelKey.PRINT.getName()));
        miExit.setText(properties.getProperty(LabelKey.EXIT.getName()));

        mLang.setText(properties.getProperty(LabelKey.LANG.getName()));
        miEn.setText(properties.getProperty(LabelKey.EN.getName()));
        miRu.setText(properties.getProperty(LabelKey.RU.getName()));
        miHy.setText(properties.getProperty(LabelKey.HY.getName()));
    }


    public static void main(String[] args) {
        new NotepadeFrame(NotepadeFrame.FILE_DEFAULT_NAME + " - " + NotepadeFrame.PROGRAM_NAME);
    }

    enum LabelKey {

        FILE("file"),
        NEW("new"),
        SAVE("save"),
        SAVE_AS("saveAs"),
        OPEN("open"),
        PAGE_SETUP("pageSetup"),
        PRINT("print"),
        EXIT("exit"),

        LANG("lang"),
        EN("en"),
        RU("ru"),
        HY("hy"),
        ;



        LabelKey(String val) {
            this.name = val;
        }

        public String getName() {
            return name;
        }

        public static LabelKey getByName (String name) {
            LabelKey[] labels = values();
            for (LabelKey labelKey : labels) {
                if(labelKey.getName().equals(name) ){
                    return labelKey;
                }
            }
            return null;
        }

        private final String name;
    }

}
