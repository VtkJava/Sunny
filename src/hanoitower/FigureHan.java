package hanoitower;

import java.awt.*;

/**
 * Created by Vacho on 13.04.2016.
 */
public abstract class FigureHan {

    public static final Color DEFAULT_COLOR = Color.orange;

    private int x;
    private int y;
    private int width;
    private int height;
    Color color;

    private HanoiCanvas canvas;

    public FigureHan(int x, int y, int width, int height,HanoiCanvas canvas) {
        this(x, y, width, height, canvas, DEFAULT_COLOR);
    }

    public FigureHan(int x, int y, int width, int height,HanoiCanvas canvas, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.canvas = canvas;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    abstract void draw(Graphics g);

}
