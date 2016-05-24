package hanoitower;


import figure.Figure;
import ui.FigureCanvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Peg extends Figure {

    List<Disc> discs = new ArrayList<>();
    private Rectangle board;
    private Rectangle stake;


    public Peg(int x, int y, int width, int height, FigureCanvas canvas) {
        super(x, y, width, height, canvas);
    }

    public Peg(int x, int y, int width, int height, FigureCanvas canvas, Color color) {
        super(x, y, width, height, canvas, color);
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(new Color(0x47FF22));
        g.fillRect(getX(), getY(), getWidth(), getHeight());

    }

    @Override
    public boolean isBelong(int x, int y) {
        return false;
    }
}
