
package juegoletras;

import javax.swing.JLabel;

public class Letra extends JLabel{
    
    private int x,y;
    private static int speed=2;
    
    public Letra(int x,int y,String text){
        this.x=x;
        this.y=y;
        this.setText(text);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void bajar(){
        y+=speed;
    }
    
    public void setSpeed(int sp){
        speed=sp;
    }
   
}
