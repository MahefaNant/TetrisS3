package event;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import draw.Ligne;
import form.Piece;
import funct.Function;
import win.Label;
import win.Tapis;

public class Control{
    int blocksize = 30;
    int TourP1 = 0;
    int TourP2 = 0;
    int verifP1 = 0;
    int verifP2 = 0;
    
    Function funct = new Function();

    public Control(JFrame frame,Tapis tapis,ArrayList<Piece> P,Ligne[] L,Label[] lab1,Label[] lab2) {
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(funct.enMouv(P,0)==false) {
                    if(e.getKeyCode()== KeyEvent.VK_S) changeDownP1(lab1);
                    if(e.getKeyCode()== KeyEvent.VK_W) changeUpP1(lab1);
                    if(e.getKeyCode()== KeyEvent.VK_F) tapis.addPiece(TourP1, 0, blocksize);;
                } 
                if(funct.enMouv(P,1)==false) {
                    if(e.getKeyCode()== KeyEvent.VK_DOWN) changeDownP2(lab2);
                    if(e.getKeyCode()== KeyEvent.VK_UP) changeUpP2(lab2);
                    if(e.getKeyCode()== KeyEvent.VK_SHIFT) tapis.addPiece(TourP2, 1, 5*blocksize);;
                }
                /////Mouvement P1
                if(e.getKeyCode()== KeyEvent.VK_W) for(int i=0;i<P.size();i++) if(P.get(i).idPlayer==0 && P.get(i).verifStart==1) P.get(i).changeForm(P);
                if(e.getKeyCode()== KeyEvent.VK_S) for(int i=0;i<P.size();i++) if(P.get(i).idPlayer==0 && P.get(i).verifStart==1) P.get(i).ToBottom(P,L);;
                if(e.getKeyCode()== KeyEvent.VK_A) for(int i=0;i<P.size();i++) if(P.get(i).idPlayer==0 && P.get(i).verifStart==1) P.get(i).ToLeft(P);
                if(e.getKeyCode()== KeyEvent.VK_D) for(int i=0;i<P.size();i++) if(P.get(i).idPlayer==0 && P.get(i).verifStart==1) P.get(i).ToRight(P);
                /////////////////
                /////Mouvement P2
                if(e.getKeyCode()== KeyEvent.VK_UP) for(int i=0;i<P.size();i++) if(P.get(i).idPlayer==1 && P.get(i).verifStart==1) P.get(i).changeForm(P);
                if(e.getKeyCode()== KeyEvent.VK_DOWN) for(int i=0;i<P.size();i++) if(P.get(i).idPlayer==1 && P.get(i).verifStart==1) P.get(i).ToBottom(P,L);;
                if(e.getKeyCode()== KeyEvent.VK_LEFT) for(int i=0;i<P.size();i++) if(P.get(i).idPlayer==1 && P.get(i).verifStart==1) P.get(i).ToLeft(P);
                if(e.getKeyCode()== KeyEvent.VK_RIGHT) for(int i=0;i<P.size();i++) if(P.get(i).idPlayer==1 && P.get(i).verifStart==1) P.get(i).ToRight(P);
                /////////////////
                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT) tapis.repaint();
                if(e.getKeyCode() != KeyEvent.VK_H ) tapis.repaint();
            }
            @Override
            public void keyTyped(KeyEvent e) {}


            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }


    void changeDownP1(Label[] lab) {
        if(verifP1 == 1) verifP1=0;
        if(TourP1==4 && verifP1==0) {
            TourP1 =0;
            verifP1 = 1;
        }
        if(TourP1==3) TourP1 =4;
        if(TourP1==2) TourP1 =3;
        if(TourP1==1) TourP1 =2;
        if(TourP1==0 && verifP1==0) TourP1 =1;
        makeTour(lab, TourP1);
    }

    void changeUpP1(Label[] lab) {
        if(verifP1 == 1) verifP1=0;
        if(TourP1==0 && verifP1==0) {
            TourP1 =4;
            verifP1 = 1;
        }
        if(TourP1==1) TourP1 =0;
        if(TourP1==2) TourP1 =1;
        if(TourP1==3) TourP1 =2;
        if(TourP1==4 && verifP1==0) TourP1 =3;
        makeTour(lab, TourP1);
    }

    void changeDownP2(Label[] lab) {
        if(verifP2== 1) verifP2=0;
        if(TourP2==4 && verifP2==0) {
            TourP2 =0;
            verifP2 = 1;
        }
        if(TourP2==3) TourP2 =4;
        if(TourP2==2) TourP2 =3;
        if(TourP2==1) TourP2 =2;
        if(TourP2==0 && verifP2==0) TourP2 =1;
        makeTour(lab, TourP2);
    }

    void changeUpP2(Label[] lab) {
        if(verifP2 == 1) verifP2=0;
        if(TourP2==0 && verifP2==0) {
            TourP2 =4;
            verifP2 = 1;
        }
        if(TourP2==1) TourP2 =0;
        if(TourP2==2) TourP2 =1;
        if(TourP2==3) TourP2 =2;
        if(TourP2==4 && verifP2==0) TourP2 =3;
        makeTour(lab, TourP2);
    }

    void makeTour(Label[] lab,int Tour){
        for(int i=0;i<lab.length;i++) {
            if(i==Tour) lab[i].setBorder(BorderFactory.createLineBorder(Color.decode("#FF0066"),4)); 
            else lab[i].setBorder(null);
            lab[Tour].repaint();
        }
    }

}
