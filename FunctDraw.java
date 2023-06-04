package draw;

import draw.Ligne;
import win.Label;
import form.OForm;
import form.Piece;
import form.TForm;
import form.LForm;
import form.SForm;
import form.YForm;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.plaf.ColorUIResource;

public class FunctDraw {
    int blocksize = 30;

    public void drawLignes(Ligne[] lignes,Graphics2D g2d) {
        int sep = 0,y=blocksize*19;
        for(int i=0;i<lignes.length;i++) {
            lignes[i] = new Ligne(y-sep);
            lignes[i].paint(g2d);
            sep+=blocksize;
        }
    }

    Piece chooseP(int i) {
        Piece P = null;
        if(i==0) P = new OForm(1*30, 1*30/3, 20, -1, 0);
        if(i==1) P = new LForm(1*30, 1*30/3, 20, -1, 0);
        if(i==2) P = new SForm(1*30, 1*30/3, 20, -1, 0);
        if(i==3) P = new TForm(1*30, 1*30/3, 20, -1, 0);
        if(i==4) P = new YForm(1*30/2, 1*30/3, 20, -1, 0);
        return P;
    }

    public void drawCases(Label [] Pl,JLabel mere) {
        int sep = 0;
        for(int i=0;i<Pl.length;i++) {
            Pl[i] = new Label(blocksize, blocksize + sep, 4*blocksize, 3*blocksize, new ColorUIResource(Color.black),chooseP(i));
            if(i==0) Pl[i].setBorder(BorderFactory.createLineBorder(Color.decode("#FF0066"), 4));
            mere.add(Pl[i]);
            sep+=3*blocksize;
        }
    }
}
