package draw;

import java.awt.*;
import java.util.*;

import javax.swing.plaf.ColorUIResource;

import draw.Square;
import form.Piece;

public class Ligne {
    public int y;

    int blocksize = 30;

    public Square [] S = new Square[10];

    public Ligne(int y) {
        this.y = y;
    }

    void drawSquare(Graphics2D g2d) {
        int sep =0,x=0;
        for(int i=0;i< S.length;i++) {
            S[i] = new Square(x + sep, y, blocksize, new ColorUIResource(Color.TRANSLUCENT), new ColorUIResource(Color.decode("#fff")));
            S[i].paint(g2d);
            sep+=blocksize;
        }
    }

    /////Plein

    public boolean LignePlein(ArrayList<Piece> P) {
        int count = 0;
        for(int i=0;i<S.length;i++) {
            for(int j=0;j<P.size();j++) {
                for(int k=0;k<P.get(j).S.size();k++) {
                    if(P.get(j).verifStart==0 && P.get(j).S.get(k).x==S[i].x && P.get(j).S.get(k).y == S[i].y ) {
                        count++;
                    }
                }
            }
        }
        if(count>=10) return true;
        return false;
    }

    public void removePiece(ArrayList<Piece> P) {
        int count = 0;
        if(LignePlein(P)==true) {
            for(int i=0;i<S.length;i++) {
                for(int j=0;j<P.size();j++) {
                    for(int k=0;k<P.get(j).S.size();k++) {
                        if(P.get(j).verifStart==0 && P.get(j).S.get(k).x==S[i].x && P.get(j).S.get(k).y == S[i].y ) {
                            P.get(j).S.remove(k);
                        }
                    }
                }
            }
            getPieceTop(P);
        }
        
    }

    /*public boolean verifPlein(int y,ArrayList<Piece> P) {
        int
    } */

    public void getPieceTop(ArrayList<Piece> P) {
        int count = 0;
        for(int i=0;i<P.size();i++) {
            for(int j=0;j<P.get(i).S.size();j++) {
                if(P.get(i).S.get(j).y < this.y) {
                    P.get(i).S.get(j).y+=blocksize;
                }
            }
        }
    }

    public Square getFirstX(ArrayList<Piece> P) {
        int verif = 0;
        for(int i=0;i<P.size();i++) {
            for(int j=0;j<P.get(i).S.size();j++) {
                if(this.S[0].x==P.get(i).S.get(j).x && this.S[0].y==P.get(i).S.get(j).y) {
                    System.out.println(P.get(i).x + ":"+P.get(i).y);
                }
            }
        }
        return null;
    }

    ////////////////////

    public void paint(Graphics2D g2d) {
        drawSquare(g2d);
    }
}
