
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
    /**
     * Si la variable que se le manda es igual a 1, mueve la barra a la derecha
     * y sino mueve la barra a la izquierda.
     * @param num es la direccion de la barra 
     */
    public void moverBarra(int num){
        if(num==1){
            x+=10;
        }else{
            x-=10;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
