
package juegoletras;

import java.awt.Color;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author josealmon
 */
public class VistaNombre extends JFrame{
    
    private Controlador c;
    private JLabel tname;
    private TextField name;
    private JButton jugar;
    
    public VistaNombre(Controlador c){
        this.c=c;
        this.setLayout(null);
        
        tname=new JLabel("Introduce tu nombre");
        tname.setBounds(50, 60, 600, 40);
        tname.setFont (tname.getFont ().deriveFont (30.0f));
        this.add(tname);
        
        name=new TextField();
        name.setBounds(50, 150, 300, 30);
        this.add(name);
        
        jugar=new JButton("Jugar");
        jugar.setBounds(50, 220, 300, 40);
        jugar.setFont(jugar.getFont().deriveFont(15.0f));
        this.add(jugar);
        jugar.addMouseListener(c);
        
        this.getContentPane().setBackground(Color.CYAN);
        this.setBounds(100, 100, 400, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public String getNombre(){
        return name.getText();
    }
}
