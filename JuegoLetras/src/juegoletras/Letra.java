
package juegoletras;

import javax.swing.JLabel;

public class Letra extends JLabel{
    
    private int x,y;
    
    public Letra(int x,int y,String text){
        this.x=x;
        this.y=y;
        this.setText(text);
        System.out.println("Creado: "+x+" "+y+" "+text);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void bajar(){
        y+=2;
    }
   
}
