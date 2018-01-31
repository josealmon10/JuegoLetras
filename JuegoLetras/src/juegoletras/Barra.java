
package juegoletras;

import javax.swing.JPanel;

public class Barra extends JPanel{
    private int x,y;
    
    public Barra(int x,int y){
        this.x=x;
        this.y=y;        
    }
    public void moverDer(){
        x+=5;
    }
    public void moverIzq(){
        x-=5;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }    
}
