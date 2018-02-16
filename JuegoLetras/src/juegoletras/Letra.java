
package juegoletras;

import java.awt.Color;
import javax.swing.JLabel;

public class Letra extends JLabel{
    
    private int x,y,direccion=1,speed=2,estado;
    
    public Letra(int x,int y,String text){
        this.x=x;
        this.y=y;
        this.setText(text);
        estado=(int)Math.floor(Math.random()*(5-2)+2);
        color();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    /**
     * Moviemiento de la letra en funcion de de la direccion
     */
    public void mover(){
        if(direccion==1){
            y+=speed;
        }else{
            y-=speed;
        }
    }
    
    public void setSpeed(int sp){
        speed=sp;
    }
   
    public void changeDirection(){
        if(direccion==1){
            direccion=2;
        }else{
            direccion=1;
        }
    }

    public int getDireccion() {
        return direccion;
    }
    
    public void color(){
        estado--;
        switch(estado){
            case 3:
                this.setForeground(Color.BLACK);
                break;
            case 2:
                this.setForeground(Color.RED);
                break;
            case 1:
                this.setForeground(Color.GREEN);
                break;
        }
    }

    public int getEstado() {
        return estado;
    }
    
    
}
