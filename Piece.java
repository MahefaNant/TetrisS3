package form;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Timer;
import javax.swing.plaf.ColorUIResource;

import draw.Ligne;
import draw.Square;
import funct.Function;
import win.Tapis;

public abstract class Piece {
    int count =0;
    public int x,y,idPlayer,blocksize=30;
    public int[] XYinit = new int[2];
    public int verifStart ;
    public int FORM = 0; 
    public ArrayList<Square> Sprev = new ArrayList<Square>();
    public ArrayList<Square> S = new ArrayList<Square>();
    public int auto = 0;
    public int newX,newY;

    Function funct = new Function();

    public Piece(int x,int y,int blocksize,int verifStart,int idPlayer) {
        this.x = x;
        this.y = y;
        this.verifStart = verifStart;
        this.idPlayer = idPlayer;
        this.blocksize = blocksize;
        XYinit[0] = x;XYinit[1] = y;
    }

    public void paint (Graphics2D g2d) {
        if(S!=null) {
            if((verifStart==1 &&count ==0) || verifStart ==-1)formInit(); 
            if(verifStart==1) AllForm();
            for(int i=0;i<S.size();i++) S.get(i).paint(g2d);
            count++;
        }
    }

    /// MOUVEMENT

    public void changeForm(ArrayList<Piece> P) {
        int verCount = 0;
        
        if(this.verifStart==1) {
            if(rotateAccess()==false);
            else {
                if(collisionBottom(null,P, 1)==null)
                if(collisionFond()==false)
                if(verCount==1) verCount=0;
                if(this.FORM == 3 && verCount==0)  {
                    this.FORM=0;
                    verCount=1;
                }
                if(this.FORM == 2) this.FORM=3;
                if(this.FORM == 1) this.FORM=2;
                if(this.FORM == 0 && verCount==0) this.FORM=1;
            }
        }
    }

    void AllForm() {
            if(this.FORM==0) form1();
            if(this.FORM==1) form2();
            if(this.FORM==2) form3();
            if(this.FORM==3) form4();
    }

    public void autoRun(Ligne[] L,ArrayList<Piece> P) {
            if(collisionBottom(L,P,1)==null)
            if(collisionFond()==false)
            if(this.verifStart==1) {
                this.y +=blocksize;
                //
            } 
      
        //Shute(P);
    }

    public void ToRight(ArrayList<Piece> P) {
        if(RightAccess(blocksize)==true)
        if(collisionRorL(P,-blocksize)==false)
        if(this.verifStart==1) {
            this.x += blocksize;
        }
    }

    public void ToLeft(ArrayList<Piece> P) {
        if(LeftAccess(blocksize)==true)
        if(collisionRorL(P,blocksize)==false)
        if(this.verifStart==1) {
            this.x -= blocksize;
            
        }
    }

    public void ToBottom(ArrayList<Piece> P,Ligne[] L) {
        if(collisionBottom(L,P, 1)==null)
        if(collisionFond()==false)
        if(this.verifStart==1) {
            this.y += blocksize;
        } 
    }
    /////////////////////////////
    ////Collision

    boolean RightAccess(int moins) {
        int count =0;
        for(int i=0;i<S.size();i++) if(S.get(i).x+moins <10*blocksize) count++;
        if(count>=S.size()) return true;
        return false;
    }

    boolean LeftAccess(int moins) {
        int count =0;
        for(int i=0;i<S.size();i++) if(S.get(i).x-moins >=0) count++;
        if(count>=S.size()) return true;
        return false;
    }

    boolean collisionFond() {
        for(int i=0;i<S.size();i++) {
            if(S.get(i).y+blocksize >= 20*blocksize) {
                verifStart = 0;
                return true;
            } 
        }
        return false;
    }

    public Square collisionBottom(Ligne[] L,ArrayList<Piece> P,int verS) {
        Square s = null;
        if(this.verifStart ==verS) {
            for(int i=0;i<S.size();i++) {
                for(int j=0;j<P.size();j++) {
                    for(int k=0;k<P.get(j).S.size();k++) {
                        if(P.get(j).verifStart==0)
                        if(S.get(i).y+blocksize == P.get(j).S.get(k).y && S.get(i).x == P.get(j).S.get(k).x) {
                            this.verifStart = 0;
                            s = S.get(i);
                        }
                    }
                }
            }
            if(s!=null)  return s;
        }
        return null;
    }

    public int getMaxY() {
       ArrayList<Integer> tab = new ArrayList<Integer>();
       for(int i=0;i<S.size();i++) {
           tab.add(S.get(i).y);
       }
       return Collections.max(tab);
    }

    public boolean coll(Ligne[] L,ArrayList<Piece> P) {
        if(this.verifStart ==1) {
            for(int i=0;i<S.size();i++) {
                for(int j=0;j<P.size();j++) {
                    for(int k=0;k<P.get(j).S.size();k++) {
                        if(P.get(j).verifStart==0)
                        if(S.get(i).y+blocksize == P.get(j).S.get(k).y && S.get(i).x == P.get(j).S.get(k).x) {
                            funct.removePiece(L, P);
                        }
                    }
                }
            }
        }
        
        return false;
    }

    boolean collisionRorL(ArrayList<Piece> P,int LR) {
        if(FORM==0) form2();if(FORM==1) form3();if(FORM==2) form4();if(FORM==3) form1();
        for(int i=0;i<S.size();i++) {
            for(int j=0;j<P.size();j++) {
                for(int k=0;k<P.get(j).S.size();k++) {
                    if(P.get(j)!=this && P.get(j).verifStart==0)
                    if(S.get(i).x==P.get(j).S.get(k).x + LR && S.get(i).y == P.get(j).S.get(k).y) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean rotateAccess() {
        if(FORM==0) form2();if(FORM==1) form3();if(FORM==2) form4();if(FORM==3) form1();
        if(RightAccess(0) ==true && LeftAccess(0)==true) return true;
        return false;
    }

    ///////////////////////////
    public boolean unique(ArrayList<Piece> P) {
        int ver =0;
        for(int i=0;i<S.size();i++) {
            for(int j=0;j<P.size();j++) {
                for(int k=0;k<P.get(j).S.size();k++) {
                    if(P.get(j)!=this)
                    if(S.get(i).y==P.get(j).S.get(k).y && S.get(i).x==P.get(j).S.get(k).x) {
                        ver=1;
                        break;
                    }
                }
            }
        }
        if(ver==1)  return false;
        return true;
    }
    int isa = 0;

    /*public void autoDepl(Tapis tapis,Ligne[] L,ArrayList<Piece> P,int x,int y) {
        auto=1;
        tapis.timer.setDelay(0);
        if (auto==1) {
            if(isa ==0) {
                this.
                this.
            }
          
            Square s = collisionBottom(L,P,1);
            if(s==null) {
               
                if(collisionFond()==false) {
                    if(verifStart==1) {
                        if(this.x!=x) {
                            if(this.x< x) this.x+=blocksize;
                            if(this.x> x)this.x-=blocksize;
                        }
                        if(this.y!=y)this.y+=blocksize;
                    } 
                }
            } else {
                for(int i=0;i<L.length;i++) {
                    if(L[i].y==s.y) {
                       if(L[i].LignePlein(P)==true) {
                            this.newX = this.x;
                            this.newY = this.y;
                       }
                    }
                }
                this.x = this.XYinit[0];
                this.y = this.XYinit[1];
                this.auto = 0;
                tapis.c = 2;
                tapis.timer.setDelay(500);
            }
            isa++;
        }
        
    }


    public void autoDepl2(Tapis tapis,Ligne[] L,ArrayList<Piece> P,int x,int y) {
        if(tapis.c==2) {
            tapis.timer.setDelay(500);
            if(this.x!=x) {
                if(this.x< x) this.x+=blocksize;
                if(this.x> x)this.x-=blocksize;
            }
            if(this.y!=y)this.y+=blocksize;
        }
    }
*/
    ////////////////////////////

    

    public abstract void formInit();
    public abstract void form1();
    public abstract void form2();
    public abstract void form3();
    public abstract void form4();

}