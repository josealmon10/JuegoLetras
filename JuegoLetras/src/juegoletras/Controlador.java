
package juegoletras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controlador implements KeyListener,ActionListener{
    private int cont,game,velgen;
    private Vista v;
    private boolean isDead=true,start=false;
    
    public Controlador(){
        v=new Vista(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!isDead){
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                v.moverBarra(1);
            } else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                v.moverBarra(2);
            }else{
                v.compAcierto(e.getKeyChar());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!isDead){
            setIsDead(v.compAlive());
        }
        if(!isDead){
            if(cont==velgen){
                v.generarLetras();
                cont=0;
            }
            v.bajar();
            v.compBarra();
            cont+=50;
        }else if(isDead && start){
            v.lose();
        }
        v.repaint();
    }

    public int getGame() {
        return game;
    }

    public void setIsDead(Boolean isDead) {
        this.isDead = isDead;
    }

    public void setGame(int game) {
        this.game = game;
        switch(game){
            case 1:
                velgen=500;
                break;
            case 2:
                velgen=400;
                break;
            case 3:
                velgen=300;
                break;
            case 4:
                velgen=200;
                break;
            case 5:
                velgen=100;
                break;
        }
        cont=0;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isIsDead() {
        return isDead;
    }
    
    
    
}
