package hanoitower;



import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


public class HanoiCanvas extends JPanel {

    public HanoiCanvas canvas;
    public HanRectangle border;
    private List<FigureHan> figures = new ArrayList<>();


    public HanoiCanvas(){

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int x =175;
        int y = 275;

        for (int i = 0; i < 3; i++) {

//        g.clearRect(0, 0, 2000, 2000);
        g.fillRect(x, y, 110, 10);
        g.fillRect(x + 50, y -110, 8, 120);
        g.setColor(new Color(0, 0, 0));
            g.drawRect( x , y , 110, 10);
            x =  x + 50 + 110;


 //       for (FigureHan figure : figures) {
   //         figure.draw(g);
       // }
        }

    }

    }



