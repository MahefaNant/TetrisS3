package funct;

import java.util.ArrayList;

import draw.Ligne;
import draw.Square;
import form.Piece;

public class Function {
    int blocksize=0;
    public void removePiece(Ligne[] L,ArrayList<Piece> P) {
        for(int i=0;i<L.length;i++) {
            L[i].removePiece(P);
        }
    }

    public boolean enMouv(ArrayList<Piece> P,int idPlayer) {
        for(int i=0;i<P.size();i++) {
            if(P.get(i).verifStart==1 && P.get(i).idPlayer==idPlayer) return true;
        }
        return false;
    }

    public boolean verifLigneFull(Square s,ArrayList<Piece> P,Ligne[] L) {
        for(int i=0;i<L.length;i++) {
            if(L[i].y == s.y) {
                L[i].LignePlein(P);
                //return true;
            }
        }
        return false;
    }



}
