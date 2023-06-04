package win;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.plaf.ColorUIResource;

import draw.FunctDraw;
import event.Control;
import win.Label;
import win.Tapis;
import win.Window;

public class Mix {
    private int blockSize = 30;
    Window win;
    JLabel[] fen = new JLabel[5];
    Label[] LabP1 = new Label[5];
    Label[] LabP2 = new Label[5];
    Tapis tapis = new Tapis(6*blockSize, 2*blockSize, 10*blockSize, 20*blockSize, new ColorUIResource(Color.BLACK));

    FunctDraw functD = new FunctDraw();
    Control control;

    public Mix() {
        DrawLabel();
        functD.drawCases(LabP1, fen[1]);
        functD.drawCases(LabP2, fen[2]);
        win = new Window("TETRIS", 22*blockSize, 26*blockSize, true, fen);
        control = new Control(win, tapis, tapis.allP, tapis.lignes,LabP1,LabP2);
    }

    void DrawLabel() {
        fen[0] = tapis;
        fen[1] = new Label(0, 0, 6*blockSize, 16*blockSize, new ColorUIResource(Color.GRAY),null);
        fen[2] = new Label(16*blockSize, 0, 6*blockSize, 16*blockSize, new ColorUIResource(Color.GRAY),null);
        fen[3] = new Label(6*blockSize, 0, 10*blockSize, 2*blockSize, new ColorUIResource(Color.GRAY),null);
        fen[4] = new Label(6*blockSize, 22*blockSize, 10*blockSize, 5*blockSize, new ColorUIResource(Color.GRAY),null);
    }
}
