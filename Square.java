package draw;

import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.util.ArrayList;
import form.Piece;

public class Square {
    public int x,y,D;
    int blocksize = 30;
    public ColorUIResource color,border;
    public boolean exist = true;
    public Square(int x,int y,int D,ColorUIResource color,ColorUIResource border) {
        this.x = x;
        this.y = y;
        this.D =D;
        this.color = color;
        this.border = border;
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(x, y, D, D);
        g2d.setColor(border);
        g2d.drawRect(x, y, D, D);
    }
}
