
package juegoletras;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Vista extends JFrame{
   
    private ControladorMenu cm;
    private Controlador c;
    private JLabel score,nivel,lose,inicio;
    private ArrayList<Letra> al=new ArrayList();
    private char let;
    private GeneradorLetras generador;
    private int punt;
    private Barra barra1,barra2;
    private Timer timer;
    private boolean pause=false;
    private JPanel panel;
    
    public Vista(Controlador c){
        this.c=c;
        cm=new ControladorMenu(this);
        generador=new GeneradorLetras();        
        generarVista();
    }
    
    /**
     * Generacion de vista
     */
    public void generarVista(){
        this.setLayout(null);
        
        crearMenu();
        generarLabels();
        /*Crear Barra*/
        generarBarras();
        /*Crear ventana*/
        this.addKeyListener(c);
        this.setBounds(100, 100, 800, 620);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer=new Timer(50, c);
    }
    
    /**
     * Generacion de labels
     */
    public void generarLabels(){
        /*Frase principal*/
        inicio=new JLabel("Escoge un nivel para comenzar");
        inicio.setBounds(140, 250, 600, 40);
        inicio.setFont (inicio.getFont ().deriveFont (30.0f));
        this.add(inicio);
        /*Frase de que has perdido*/
        lose=new JLabel("¡Has perdido! Escoge un nuevo nivel");
        lose.setBounds(140, 250, 600, 40);
        lose.setFont (lose.getFont ().deriveFont (30.0f));
        this.add(lose);
        lose.setVisible(false);
        /*Contador de la puntuacion*/
        score=new JLabel("PUNTUACION: 0");
        score.setBounds(20,500, 400, 100);
        score.setFont (score.getFont ().deriveFont (30.0f));
        this.add(score);
        /*Nivel en el que esta el jugador*/
        nivel=new JLabel("Nivel: ");
        nivel.setBounds(660, 0, 300, 100);
        nivel.setFont (nivel.getFont ().deriveFont (30.0f));
        this.add(nivel);
    }
    
    public void generarBarras(){
        barra1=new Barra(350,480);
        barra1.setBounds(barra1.getY(), barra1.getX(), 100,20 );
        barra1.setBackground(Color.GRAY);
        barra1.setVisible(false);
        this.add(barra1);
        barra2=new Barra(350,0);
        barra2.setBounds(barra2.getY(), barra2.getX(), 100,20 );
        barra2.setBackground(Color.GRAY);
        barra2.setVisible(false);
        this.add(barra2);
    }
    
    /**
     * Generacion del menu
     */
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
        JMenuItem p=new JMenuItem("Pause");
        //Creo los elementos que van dentro del elemento nivel.
        JMenuItem n1=new JMenuItem("Nivel 1");
        JMenuItem n2=new JMenuItem("Nivel 2");
        JMenuItem n3=new JMenuItem("Nivel 3");
        JMenuItem n4=new JMenuItem("Nivel 4");
        JMenuItem n5=new JMenuItem("Nivel 5");
        //Añado los elementos
        mArchivo.add(g);        
        mArchivo.add(c);
        mArchivo.add(p);
        mArchivo.addSeparator();
        mArchivo.add(s);
        mNivel.add(n1);
        mNivel.add(n2);
        mNivel.add(n3);
        mNivel.add(n4);
        mNivel.add(n5);
        //Crear el accelerator para utilizar el ctrl+numero.
        n1.setAccelerator(KeyStroke.getKeyStroke('1', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        n2.setAccelerator(KeyStroke.getKeyStroke('2', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        n3.setAccelerator(KeyStroke.getKeyStroke('3', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        n4.setAccelerator(KeyStroke.getKeyStroke('4', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        n5.setAccelerator(KeyStroke.getKeyStroke('5', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        //Añado la barra a la ventana.
        s.addActionListener(cm);
        p.addActionListener(cm);
        n1.addActionListener(cm);
        n2.addActionListener(cm);
        n3.addActionListener(cm);
        n4.addActionListener(cm);
        n5.addActionListener(cm);
        this.setJMenuBar(mb);
    }
    
    /**
     * Generar una nueva letra aleatoria
     */
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
    
    /**
     * Movimiento de las letras
     */
    public void bajar(){
        for (int i = 0; i < al.size(); i++) {
            al.get(i).mover();
            al.get(i).setBounds(al.get(al.size()-1).getX(), al.get(al.size()-1).getY(), 30, 30);
        }
        this.repaint();
    }
    
    /**
     * Comprobacion de letra acertada
     * @param comp Letra pulsada
     */
    public void compAcierto(char comp){
        boolean changeColor=true;
        int test=punt;
        for (int i = 0; i < al.size(); i++) {
            if(al.get(i).getText().equals(""+comp)){
                al.get(i).color();
                changeColor=false;
                if(al.get(i).getEstado()==0){
                    punt++;
                    this.remove(al.get(i));
                    al.remove(i);
                    break;
                }
            }
        }
        if(punt==test && changeColor){
            punt--;
        }
        score.setText("PUNTUACION: "+punt);
        comprobarAumentoNivel();
        this.repaint();
    }
    
    /**
     * Comprobacion de que sigues vivo
     * @return Retorna si sigue vivo
     */
    public boolean compAlive(){
        boolean alive=false;
        for (int i = 0; i < al.size(); i++) {
            if(al.get(i).getY()>=500 && al.get(i).getDireccion()==1){
                alive=true;
            }else if(al.get(i).getY()<=5 && al.get(i).getDireccion()==2){
                alive=true;
            }
        }
        if(punt<0){
            alive=true;
        }
        return alive;
    }
    
    /**
     * Perdida de partida
     */
    public void lose(){
        for (int i = 0; i < al.size(); i++) {
            this.remove(al.get(i));
        }
        al.clear();
        lose.setVisible(true);
        barra1.setVisible(false);
        barra2.setVisible(false);
        if(punt<0){
            score.setText("Deberias practicar mas :(");
        }
        c.setCompgame(true);
        nivel.setText("Nivel: ");
        timer.stop();
        this.repaint();
    }
    
    /**
     * Comenzar partida
     * @param game Indica el nivel de la partida
     */
    public void start(int game){
        if(c.isIsDead()){
            c.setGame(game);
            c.setStart(true);
            c.setIsDead(false);
            inicio.setVisible(false);
            lose.setVisible(false);
            score.setText("PUNTUACION: 0");
            nivel.setText("Nivel: "+game);
            punt=0;
            barra1.setVisible(true);
            barra2.setVisible(true);
            timer.start();
            this.repaint();
        }
    }
    
    /**
     * Permite el movimiento de la barra
     * @param num Direccion de la barra
     */
    public void moverBarra(int num){
        barra1.moverBarra(num);
        barra2.moverBarra(num);
        this.repaint();
    }
    
    /**
     * Comprobar colision con la barra
     */
    public void compBarra(){
        for (int i = 0; i < al.size(); i++) {
            if(al.get(i).getY()>=458 && al.get(i).getX()>barra1.getX() && al.get(i).getX()<barra1.getX()+105 && al.get(i).getDireccion()==1){
                al.get(i).changeDirection();
            }
            if(al.get(i).getY()<=14 && al.get(i).getX()>barra1.getX() && al.get(i).getX()<barra1.getX()+105 && al.get(i).getDireccion()==2){
                al.get(i).changeDirection();
            }
        }
    }
    
    /**
     * Comprobar el aumento del nivel cada 10 puntos
     */
    public void comprobarAumentoNivel(){
        switch(c.getGameinicial()){
            case 1:
                if(punt>=10 && punt<20){
                    c.setGame(2);
                } else if(punt>=20 && punt<30){
                    c.setGame(3);
                } else if(punt>=30 && punt<40){
                    c.setGame(4);
                } else if(punt>=40){
                    c.setGame(5);
                }else{
                    c.setGame(1);
                }
                break;
            case 2:
                if(punt>=10 && punt<20){
                    c.setGame(3);
                } else if(punt>=20 && punt<30){
                    c.setGame(4);
                } else if(punt>=30){
                    c.setGame(5);
                }else{
                    c.setGame(2);
                }
                break;
            case 3:
                if(punt>=10 && punt<20){
                    c.setGame(4);
                } else if(punt>=20){
                    c.setGame(5);
                }else{
                    c.setGame(3);
                }
                break;
            case 4:
                if(punt>=10){
                    c.setGame(5);
                }else{
                    c.setGame(5);
                }
                break;
        }
        nivel.setText("Nivel: "+c.getGame());
        this.repaint();
    }
    
    /**
     * Cambia la velocidad de la letra
     * @param n Velocidad deseada
     */
    public void changeSpeed(){
        switch(c.getGame()){
            case 1:
                al.get(al.size()-1).setSpeed((int)Math.floor(Math.random()*(3-1)+1));
                break;
            case 2:
                al.get(al.size()-1).setSpeed((int)Math.floor(Math.random()*(4-1)+1));
                break;
            case 3:
                al.get(al.size()-1).setSpeed((int)Math.floor(Math.random()*(5-1)+1));
                break;
            case 4:
                al.get(al.size()-1).setSpeed((int)Math.floor(Math.random()*(5-2)+2));
                break;
            case 5:
                al.get(al.size()-1).setSpeed((int)Math.floor(Math.random()*(5-3)+3));
                break;
        }
    }
    
    public void pause(){
        if(!pause){
            timer.stop();
            pause=true;
            panel=new JPanel();
            panel.setBackground(Color.black);
            panel.setBounds(0, 0, 1000, 1000);
            panel.setVisible(true);
            this.add(panel);
        }else{
            timer.start();
            pause=false;
            this.remove(panel);
        }
    }
}
