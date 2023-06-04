package win;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import form.Piece;
import form.OForm;

public class Label extends JLabel{
    Piece P ;
    public Graphics2D g2d;
    public Label(int x,int y,int w,int h,ColorUIResource back,Piece P) {
        this.setBounds(x, y, w, h);
        this.setOpaque(true);
        this.setBackground(back); 
        this.P = P;

        //Border border = BorderFactory.createLineBorder(Color.WHITE,this.bord);
        //this.setBorder(border);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if(P!=null) P.paint(g2d);

    }
}
