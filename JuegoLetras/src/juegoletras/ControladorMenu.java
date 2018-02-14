
package juegoletras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenu implements ActionListener{

    private Vista v;
    
    public ControladorMenu(Vista v){
        this.v=v;
    }
    
    /**
     * Seleccion de nivel
     * @param e Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Salir":
                System.exit(0);
                break;
            case "Nivel 1":
                v.start(1);
                break;
            case "Nivel 2":
                v.start(2);
                break;
            case "Nivel 3":
                v.start(3);
                break;
            case "Nivel 4":
                v.start(4);
                break;
            case "Nivel 5":
                v.start(5);
                break;
        }
    
    }
}
