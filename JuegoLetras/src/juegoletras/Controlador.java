
package juegoletras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controlador implements KeyListener,ActionListener,MouseListener{
    private int cont,game,velgen,gameinicial;
    private Vista v;
    private VistaNombre vn;
    private boolean isDead=true,start=false,compgame=true;
    
    public Controlador(){
        vn=new VistaNombre(this);
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
                v.changeBarras(30, 30);
                break;
            case 3:
                velgen=300;
                v.changeBarras(30, 30);
                break;
            case 4:
                velgen=200;
                v.changeBarras(30, 30);
                break;
            case 5:
                velgen=100;
                v.changeBarras(30, 30);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        v=new Vista(this,vn.getNombre());
        vn.dispose();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
}
