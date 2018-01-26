
package juegoletras;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Vista extends JFrame{
    
    private Controlador c;
    private JLabel score;
    private ArrayList<Letra> al=new ArrayList();
    private char let;
    
    public Vista(Controlador c){
        this.c=c;
        
        generarVista();
    }
    
    private void generarVista(){
        this.setLayout(null);
        
        score=new JLabel("0");
        score.setBounds(730,30, 50, 50);
        score.setFont (score.getFont ().deriveFont (64.0f));
        this.add(score);
        
        this.addKeyListener(c);
        this.setBounds(100, 100, 800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Timer(500, c).start();
    }
    
    public void generarLetras(){
        let=(char)Math.floor(Math.random()*(90-65)+65);
        System.out.println(let);
        System.out.println((int)Math.floor(Math.random()*700));
        al.add(new Letra((int)Math.floor(Math.random()*700),20,""+let));
        al.get(al.size()-1).setBounds(al.get(al.size()-1).getX(), al.get(al.size()-1).getY(), 30, 30);
        this.add(al.get(al.size()-1));
    }
    
}
