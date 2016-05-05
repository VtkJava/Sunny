package notepad;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static notepad.Constants.*;

/**
 * Created by 1 on 27.04.2016.
 */
public class MenuBar extends JMenuBar {

    private JMenu file;
    private JMenuItem _new, open, save, saveAs, exit;

    private JMenu lang;
    public JMenuItem en;
    public JMenuItem ru;
    private JMenuItem hy;
    private Properties properties;

    public MenuBar() {

        file = new JMenu();
        _new = new JMenuItem();
        file.add(_new);

        open = new JMenuItem();
        file.add(open);

        save = new JMenuItem();
        file.add(save);

        saveAs = new JMenuItem();
        file.add(saveAs);

        exit = new JMenuItem();
        file.add(exit);
        add(file);

        lang = new JMenu();
        en = new JMenuItem();
        lang.add(en);

        ru = new JMenuItem();
        lang.add(ru);

        hy = new JMenuItem();
        lang.add(hy);
        add(lang);

        init(DEFAULT_LANG);
    }




    public JMenu getFile() {
        return file;
    }

    public void setFile(JMenu file) {
        this.file = file;
    }

    public JMenuItem get_new() {
        return _new;
    }

    public void set_new(JMenuItem _new) {
        this._new = _new;
    }

    public JMenuItem getOpen() {
        return open;
    }

    public void setOpen(JMenuItem open) {
        this.open = open;
    }

    public JMenuItem getSave() {
        return save;
    }

    public void setSave(JMenuItem save) {
        this.save = save;
    }

    public JMenuItem getSaveAs() {
        return saveAs;
    }

    public void setSaveAs(JMenuItem saveAs) {
        this.saveAs = saveAs;
    }

    public JMenuItem getExit() {
        return exit;
    }

    public void setExit(JMenuItem exit) {
        this.exit = exit;
    }

    public JMenu getLang() {
        return lang;
    }

    public void setLang(JMenu lang) {
        this.lang = lang;
    }

    public JMenuItem getEn() {
        return en;
    }

    public void setEn(JMenuItem en) {
        this.en = en;
    }

    public JMenuItem getRu() {
        return ru;
    }

    public void setRu(JMenuItem ru) {
        this.ru = ru;
    }

    public JMenuItem getHy() {
        return hy;
    }

    public void setHy(JMenuItem hy) {
        this.hy = hy;
    }


    private void init(String key) {
        properties = new Properties();
        InputStream in = getClass().getClassLoader().getResourceAsStream("i18n/notepad" + key + ".properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            System.err.println("Property file does not exist. " + e.getMessage());
            e.printStackTrace();
        }




        file.setText(properties.getProperty(FILE));
        _new.setText(properties.getProperty(_NEW));
        open.setText(properties.getProperty(OPEN));
        save.setText(properties.getProperty(SAVE));
        saveAs.setText(properties.getProperty(SAVE_AS));
        exit.setText(properties.getProperty(EXIT));

        lang.setText(properties.getProperty(LANG));
        en.setText(properties.getProperty(EN));
        ru.setText(properties.getProperty(RU));
        hy.setText(properties.getProperty(HY));

    }

    public static void main(String[] args) {
        new Notepad();
    }


}