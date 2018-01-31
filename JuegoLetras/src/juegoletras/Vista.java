
package juegoletras;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Vista extends JFrame{
    
    private Controlador c;
    private JLabel score,nivel;
    private ArrayList<Letra> al=new ArrayList();
    private char let;
    private GeneradorLetras generador=new GeneradorLetras();
    private int punt;
    
    public Vista(Controlador c){
        this.c=c;
        
        generarVista();
    }
    
    private void generarVista(){
        this.setLayout(null);
        //puntuaicon
        score=new JLabel("PUNTUACION: 0");
        score.setBounds(20,500, 400, 100);
        score.setFont (score.getFont ().deriveFont (30.0f));
        this.add(score);
        
        nivel=new JLabel("Nivel "+c.getGame());
        nivel.setBounds(660, 0, 300, 100);
        nivel.setFont (score.getFont ().deriveFont (30.0f));
        this.add(nivel);
        
        this.addKeyListener(c);
        this.setBounds(100, 100, 800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Timer(50, c).start();
    }
    
    public void generarLetras(){
        let=generador.generarLetra(c.getGame());
        al.add(new Letra((int)Math.floor(Math.random()*700),20,""+let));
        al.get(al.size()-1).setBounds(al.get(al.size()-1).getX(), al.get(al.size()-1).getY(), 30, 30);
        this.add(al.get(al.size()-1));
    }
    
    public void bajar(){
        for (int i = 0; i < al.size(); i++) {
            al.get(i).bajar();
            al.get(i).setBounds(al.get(al.size()-1).getX(), al.get(al.size()-1).getY(), 30, 30);
        }
        this.repaint();
    }
    
    public void eliminarLetra(char comp){
        int test=punt;
        System.out.println(comp);
        for (int i = 0; i < al.size(); i++) {
            if(al.get(i).getText().equals(""+comp)){
                punt++;
                this.remove(al.get(i));
                al.remove(i);
                break;
            }
        }
        if(punt==test){
            punt--;
        }
        System.out.println(punt);
        score.setText("PUNTACION: "+punt);
        if(punt==10){
            al.get(0).setSpeed(4);
        }
        this.repaint();
    }
    
}
