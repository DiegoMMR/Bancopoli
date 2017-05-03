/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dieez
 */

 

public class Creacion {
    
    private JPanel mesa;
    private JLabel pieza;
    private String src;
    
    Cuadros _Cuadros = new Cuadros();
    
    public Creacion(JPanel jpanel) {
        this.mesa = jpanel;
    }
    
    
    public void agregarPiezas(int seleccionJ1)
    {
        switch (seleccionJ1) {
            case 1:
                src = "/img/perro.png";
                break;
            case 2:
                src = "/img/carro.png";
                break;
            case 3:
                src = "/img/sombrero.png";
                break;
            default:
                break;

        }
        
        Pieza j1 = new Pieza("j1");
        
        
        j1.setIcon(new ImageIcon(getClass().getResource(src)));
        j1.setLocation(_Cuadros.getInicio());
        this.mesa.add(j1);
        this.mesa.repaint();
    }
}


