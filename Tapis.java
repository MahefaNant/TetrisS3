package win;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.plaf.ColorUIResource;

import draw.FunctDraw;
import draw.Ligne;
import draw.Square;
import form.OForm;
import form.TForm;
import form.LForm;
import form.SForm;
import form.YForm;
import funct.Function;
import form.Piece;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tapis extends JLabel implements ActionListener{
    int blocksize=30;
    public Timer timer = new Timer(200, this);

    FunctDraw functD = new FunctDraw();
    Function funct = new Function();
    Ligne [] lignes = new Ligne[20];
    ArrayList<Piece> allP = new ArrayList<Piece>();
    
    
    public Tapis(int x, int y, int w, int h, ColorUIResource back) {
        this.setBounds(x, y, w, h);
        this.setOpaque(true);
        this.setBackground(back);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        functD.drawLignes(lignes, g2d);
        
        for(int i=0;i<allP.size();i++) allP.get(i).paint(g2d);
    }

    public void addPiece(int Tour,int player,int x) {
        if(Tour == 0 ) allP.add(new OForm(x, 0, blocksize, 1, player));
        if(Tour == 1 ) allP.add(new LForm(x, 0, blocksize, 1, player));
        if(Tour == 2 ) allP.add(new SForm(x, 0, blocksize, 1, player));
        if(Tour == 3 ) allP.add(new TForm(x, 0, blocksize, 1, player));
        if(Tour == 4 ) allP.add(new YForm(x, 0, blocksize, 1, player));
    }

    boolean GameOver() {
        for(int i=0;i<allP.size();i++) {
            for(int j=0;j<allP.get(i).S.size();j++) {
                if(allP.get(i).verifStart ==0)
                if(allP.get(i).S.get(j).y<=2*blocksize) {
                    return true;
                }
            }
        }
        return false;
    }

    ///Listener
    public int c =0;
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<allP.size();i++) {
            allP.get(i).autoRun(lignes,allP);
        }
        funct.removePiece(lignes, allP);
        this.repaint();
    }
}
