
package juegoletras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controlador implements KeyListener,ActionListener{
    private int cont,game,velgen,gameinicial;
    private Vista v;
    private boolean isDead=true,start=false,compgame=true;
    
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
            }else if(e.getKeyCode()!=20){
                v.compAcierto(e.getKeyChar());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!isDead){//Si no estamos muertos comprobamos si lo estamos
            setIsDead(v.compAlive());
        }
        if(!isDead){//Si seguimos sin estarlo continuamos
            if(cont==velgen){
                v.generarLetras();
                v.changeSpeed();
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

    /**
     * Seleccionar el nivel de juego
     * @param game Nivel de juego
     */
    public void setGame(int game) {
        this.game = game;
        if(compgame){
            gameinicial=game;
            compgame=false;
        }
        switch(game){//Depende del nivel cambia la velocidad de genracion y el nivel
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

    public int getGameinicial() {
        return gameinicial;
    }

    public void setCompgame(boolean compgame) {
        this.compgame = compgame;
    }
    
    
}
