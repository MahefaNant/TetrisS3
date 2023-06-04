package form;

import java.awt.Color;

import javax.swing.plaf.ColorUIResource;

import draw.Square;
import form.Piece;

public class LForm extends Piece{

    public LForm(int x, int y,int blockSize, int verifStart, int idPlayer) {
        super(x, y,blockSize,verifStart, idPlayer);
    }

    @Override
    public void formInit() {
        S.add(new Square(x, y +blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        S.add(new Square(x+blocksize, y +blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        S.add(new Square(x+2*blocksize, y +blocksize , blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        S.add(new Square(x+2*blocksize, y+2*blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
    }

    @Override
    public void form1() {
        if(S.size()>=1) S.set(0,new Square(x, y + blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        if(S.size()>=2) S.set(1,new Square(x+blocksize, y + blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        if(S.size()>=3) S.set(2,new Square(x+2*blocksize, y +blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        if(S.size()>=4) S.set(3,new Square(x+2*blocksize, y+2*blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
    }

    @Override
    public void form2() {
        if(S.size()>=1) S.set(0,new Square(x, y+ 2*blocksize , blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        if(S.size()>=2) S.set(1,new Square(x+blocksize, y + blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        if(S.size()>=3) S.set(2,new Square(x+blocksize, y, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        if(S.size()>=4) S.set(3,new Square(x+blocksize, y+2*blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white))); 
    }

    @Override
    public void form3() {
        if(S.size()>=1) S.set(0,new Square(x+blocksize, y, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        if(S.size()>=2) S.set(1,new Square(x+blocksize, y + blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        if(S.size()>=3) S.set(2,new Square(x+2*blocksize, y, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        if(S.size()>=4) S.set(3,new Square(x+blocksize, y+2*blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
    }

    @Override
    public void form4() {
        if(S.size()>=1) S.set(0,new Square(x +blocksize, y, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        if(S.size()>=2) S.set(1,new Square(x+blocksize, y + blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        if(S.size()>=3) S.set(2,new Square(x+2*blocksize, y, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
        if(S.size()>=4) S.set(3,new Square(x+blocksize, y+2*blocksize, blocksize, new ColorUIResource(Color.PINK), new ColorUIResource(Color.white)));
    }
    
}
