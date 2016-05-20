package hanoitower;


import ui.FigureCanvas;

import java.awt.*;


public class HanoiCanvas extends FigureCanvas implements Runnable {

    public HanoiCanvas canvas;

    private Peg peg1;
    private Peg peg2;
    private Peg peg3;


    public HanoiCanvas() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.GRAY);
        g.fillRect(150, 67, 17, 270);
        g.fillRect(510,335, 220, 20);

        g.fillRect(385, 67, 17, 270);
        g.fillRect(280,335,220,20);

        g.fillRect(620, 67, 17, 270);
        g.fillRect(50, 335, 220, 20);

    }

    public void moveDisc(Peg peg1,Peg peg2) {
//mode
    }

    @Override
    public void run() {

    }
}




