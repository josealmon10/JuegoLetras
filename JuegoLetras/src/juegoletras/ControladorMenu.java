
package juegoletras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenu implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch(e.getActionCommand()){
            case "Salir":
                System.exit(0);
                break;
            case "Nivel 1":
                
                break;
            case "Nivel 2":
                    
                break;
            case "Nivel 3":
                    
                break;
            case "Nivel 4":
                    
                break;
            case "Nivel 5":
                    
                break;
        }
    
    }
}
