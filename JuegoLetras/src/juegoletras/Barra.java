
package juegoletras;

import javax.swing.JPanel;

public class Barra extends JPanel{
    private int x,y;
    
    public Barra(int x,int y){
        this.x=x;
        this.y=y;        
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    public void moverBarra(int num){
        if(num==1){
            x+=10;
        }else{
            x-=10;
        }
    }
}
