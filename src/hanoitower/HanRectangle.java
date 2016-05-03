package hanoitower;

import java.awt.*;

/**
 * Created by Vacho on 13.04.2016.
 */
public class HanRectangle extends FigureHan {

    public HanRectangle(int x, int y, int width, int height,HanoiCanvas canvas) {
        this(x, y, width, height,canvas,Color.blue);
    }
    public HanRectangle(int x, int y, int width, int height,HanoiCanvas canvas, Color color) {
        super(x, y, width, height,canvas, Color.BLACK);
    }

//    int x = 175;
//    int y = 275;

    @Override
    void draw(Graphics g) {
        // Some changes
        g.setColor(g.getColor());
//        g.fillRect(x, y, 110, 10);
//        g.fillRect(x + 50, y -110, 8, 120);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
