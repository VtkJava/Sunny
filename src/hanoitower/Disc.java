package hanoitower;

import figure.Figure;
import ui.FigureCanvas;

import java.awt.*;

/**
 * Created by 1 on 20.05.2016.
 */
public class Disc extends Figure {

     private Peg owner;


    public Disc(int x, int y, int width, int height, FigureCanvas canvas) {
        super(x, y, width, height, canvas);
    }

    public Disc(int x, int y, int width, int height, FigureCanvas canvas, Color color) {
        super(x, y, width, height, canvas, color);
    }

    @Override
    public void draw(Graphics g) {


    }

    @Override
    public boolean isBelong(int x, int y) {
        return x >= this.getX() && x <= (this.getX() + this.getWidth())
                && y >= this.getY() && y <= (this.getY() + this.getHeight());

    }
}
