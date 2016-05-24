package hanoitower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

public class HanoiFrame extends JFrame {
    private HanoiCanvas canvas;

    public HanoiFrame() {

        super("Game HanoiTower");

        canvas = new HanoiCanvas();
        TextField textField = new TextField() ;

        JButton load = new JButton("Load Disk");
        JButton start = new JButton("Start");

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadActionPerformed(e);
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startActionPerformed(e);
            }
        });

        JPanel configPanel = new JPanel();
        configPanel.setBackground(new Color(247, 244, 215));
        configPanel.add(textField);
        configPanel.add(load);
        configPanel.add(start);

        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(800, 650);
        setLocation(250, 50);
        setVisible(true);
        textField.setPreferredSize(new Dimension(25,10));
    }

    private void startActionPerformed(ActionEvent e) {
   //     canvas.add(new Disc());
    }


    private void loadActionPerformed(ActionEvent e) {

      //  canvas.add(new Disc() );
    }

    public static void main(String[] args) {



        new HanoiFrame();
        }


    public static void moveDiscs (int currsize, int start, int middle, int end) {
        if(currsize < 0) {
            throw new InvalidParameterException("Thy number of disks should be non negative: " + currsize);
        }
        if(currsize == 0) return;

        moveDisks0 (currsize, start, middle, end);

    }

    private static void moveDisks0 (int currsize, int start, int middle, int end) {
        if(currsize == 1 ){
            System.out.println(start + " --> " + end);
        } else {
            moveDisks0(currsize - 1, start, end, middle);
            System.out.println(start + " --> " + middle);
            moveDisks0(currsize - 1,middle, start,end);
        }
    }
    }
