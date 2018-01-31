
package juegoletras;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Vista extends JFrame{
    
    private Controlador c;
    private JLabel score,nivel,lose;
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
        
        crearMenu();
        generarLabels();
        
        this.addKeyListener(c);
        this.setBounds(100, 100, 800, 620);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Timer(50, c).start();
    }
    
    public void generarLabels(){
        lose=new JLabel("¡Has perdido! Escoge un nuevo nivel");
        lose.setBounds(140, 250, 600, 40);
        lose.setFont (lose.getFont ().deriveFont (30.0f));
        this.add(lose);
        lose.setVisible(false);
        
        score=new JLabel("PUNTUACION: 0");
        score.setBounds(20,500, 400, 100);
        score.setFont (score.getFont ().deriveFont (30.0f));
        this.add(score);
        
        nivel=new JLabel("Nivel "+c.getGame());
        nivel.setBounds(660, 0, 300, 100);
        nivel.setFont (nivel.getFont ().deriveFont (30.0f));
        this.add(nivel);
    }
    public void crearMenu(){
        //Creo la barra de menu.
        JMenuBar mb=new JMenuBar();        
        //Creo los elementos de la barra y los añado.
        JMenu mArchivo=new JMenu("Archivo");
        JMenu mNivel=new JMenu("Nivel");
        mb.add(mArchivo);        
        mb.add(mNivel);
        //Creo los elementos que van dentro del elemento archivo.
        JMenuItem s=new JMenuItem("Salir");
        JMenuItem g=new JMenuItem("Guardar");
        JMenuItem c=new JMenuItem("Cargar");
        //Creo los elementos que van dentro del elemento nivel.
        JMenuItem n1=new JMenuItem("Nivel 1");
        JMenuItem n2=new JMenuItem("Nivel 2");
        JMenuItem n3=new JMenuItem("Nivel 3");
        JMenuItem n4=new JMenuItem("Nivel 4");
        JMenuItem n5=new JMenuItem("Nivel 5");
        //Añado los elementos
        mArchivo.add(g);        
        mArchivo.add(c);
        mArchivo.addSeparator();
        mArchivo.add(s);
        mNivel.add(n1);
        mNivel.add(n2);
        mNivel.add(n3);
        mNivel.add(n4);
        mNivel.add(n5);
        //Crear
        n1.setAccelerator(KeyStroke.getKeyStroke('1', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        n2.setAccelerator(KeyStroke.getKeyStroke('2', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        n3.setAccelerator(KeyStroke.getKeyStroke('3', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        n4.setAccelerator(KeyStroke.getKeyStroke('4', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        n5.setAccelerator(KeyStroke.getKeyStroke('5', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        //Añado la barra a la ventana.
        this.setJMenuBar(mb);
    }
    public void generarLetras(){
        int comp=0;
        let=generador.generarLetra(c.getGame());
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).getText().equals(""+let)) {
                comp=1;
                break;
            }
        }
        if(comp==0){
            al.add(new Letra((int)Math.floor(Math.random()*700),20,""+let));
            al.get(al.size()-1).setBounds(al.get(al.size()-1).getX(), al.get(al.size()-1).getY(), 30, 30);
            this.add(al.get(al.size()-1));
        }
        
        
    }
    
    public void bajar(){
        for (int i = 0; i < al.size(); i++) {
            al.get(i).bajar();
            al.get(i).setBounds(al.get(al.size()-1).getX(), al.get(al.size()-1).getY(), 30, 30);
        }
        this.repaint();
    }
    
    public void compAcierto(char comp){
        int test=punt;
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
        score.setText("PUNTUACION: "+punt);
        if(punt==10){
            al.get(0).setSpeed(4);
        }
        this.repaint();
    }
    
    
    public boolean compAlive(){
        boolean alive=false;
        for (int i = 0; i < al.size(); i++) {
            if(al.get(i).getY()>=500){
                alive=true;
            }
        }
        if(punt<0){
            alive=true;
        }
        return alive;
    }
    
    public void lose(){
        for (int i = 0; i < al.size(); i++) {
            this.remove(al.get(i));
        }
        al.clear();
        lose.setVisible(true);
        this.repaint();
    }
    
    public void reset(){
        lose.setVisible(false);
        score.setText("PUNTUACION: 0");
        punt=0;
        this.repaint();
    }
}
