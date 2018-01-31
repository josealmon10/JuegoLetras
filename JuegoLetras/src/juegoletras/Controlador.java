
package juegoletras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controlador implements KeyListener,ActionListener{
    int cont=500,game=1;
    private Vista v;
    
    public Controlador(){
        v=new Vista(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            
        }
        v.eliminarLetra(e.getKeyChar());
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(cont==500){
            v.generarLetras();
            cont=0;
        }
        v.bajar();
        v.repaint();
        cont+=50;
    }

    public int getGame() {
        return game;
    }
    
}
