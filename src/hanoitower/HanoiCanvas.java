package hanoitower;

import ui.FigureCanvas;
import java.awt.*;

public class HanoiCanvas extends FigureCanvas implements Runnable {

    public HanoiCanvas canvas;
    private  Disc discs;

    private Peg peg1;
    private Peg peg2;
    private Peg peg3;

    int dX,dY;

    public HanoiCanvas() {


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.YELLOW);
        g.fillRect(130, 195, 60, 35);

        g.setColor(Color.GREEN);
        g.fillRect(110, 230, 100, 35);


        g.setColor(Color.RED);
        g.fillRect(90, 265, 140, 35);

        g.setColor(Color.CYAN);
        g.fillRect(70,300,180,35);




        g.setColor(Color.GRAY);
        g.fillRect(150, 67, 17, 270);
        g.fillRect(510, 335, 230, 20);

        g.fillRect(385, 67, 17, 270);
        g.fillRect(280, 335, 220, 20);

        g.fillRect(610, 67, 17, 270);
        g.fillRect(50, 335, 220, 20);
    }


    public void load(int discs){

    }

    public void moveDisc(Peg peg1, Peg peg2) {

        }
//mode


    @Override
    public void run() {

        moveDisc(peg1,peg2);

    }


}
