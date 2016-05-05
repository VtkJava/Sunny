package hanoitower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vacho on 14.04.2016. XXXXXXXXXXXXXXXXXXXXXXX
 */
public class HanoiFrame extends JFrame {
    private HanoiCanvas canvas;

    public HanoiFrame() {

        canvas = new HanoiCanvas();

        JButton load = new JButton("Load Disk");
        JButton start = new JButton("Start");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JPanel configPanel = new JPanel();
        configPanel.setBackground(new Color(247, 244, 215));

        configPanel.add(load);
        configPanel.add(start);

        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 650);
        setLocation(250, 50);
        setVisible(true);


    }

    private void addActionPerformed(ActionEvent e) {
        //canvas.add(new );
    }

    public static void main(String[] args) {
        new HanoiFrame();

    }
}
