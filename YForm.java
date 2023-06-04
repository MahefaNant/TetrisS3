package form;

import java.awt.Color;

import javax.swing.plaf.ColorUIResource;

import draw.Square;
import form.Piece;


public class YForm extends Piece{

    public YForm(int x, int y,int blocksize, int verifStart, int idPlayer) {
        super(x, y,blocksize,verifStart, idPlayer);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void formInit() {
        S.add(new Square(x, y , blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        S.add(new Square(x+blocksize, y , blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        S.add(new Square(x+3*blocksize, y  , blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        S.add(new Square(x+2*blocksize, y, blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
    }

    @Override
    public void form1() {
        if(S.size()>=1) S.set(0,new Square(x, y , blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        if(S.size()>=2) S.set(1,new Square(x+blocksize, y , blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        if(S.size()>=3) S.set(2,new Square(x+3*blocksize, y , blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        if(S.size()>=4) S.set(3,new Square(x+2*blocksize, y, blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
    }

    @Override
    public void form2() {
        if(S.size()>=1) S.set(0,new Square(x, y , blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        if(S.size()>=2) S.set(1,new Square(x, y + blocksize, blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        if(S.size()>=3) S.set(2,new Square(x, y +2*blocksize, blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        if(S.size()>=4) S.set(3,new Square(x, y+3*blocksize, blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
    }

    @Override
    public void form3() {
        if(S.size()>=1) S.set(0,new Square(x, y , blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        if(S.size()>=2) S.set(1,new Square(x+blocksize, y , blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        if(S.size()>=3) S.set(2,new Square(x+3*blocksize, y , blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        if(S.size()>=4) S.set(3,new Square(x+2*blocksize, y, blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
    }

    @Override
    public void form4() {
        if(S.size()>=1) S.set(0,new Square(x, y , blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        if(S.size()>=2) S.set(1,new Square(x, y + blocksize, blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        if(S.size()>=3) S.set(2,new Square(x, y +2*blocksize, blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
        if(S.size()>=4) S.set(3,new Square(x, y+3*blocksize, blocksize, new ColorUIResource(Color.CYAN), new ColorUIResource(Color.white)));
    }
    
}
