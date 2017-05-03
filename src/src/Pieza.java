/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author dieez
 */
public class Pieza extends JLabel {
    
     private Point inicio;
    //posicion de la imagen
    private Point posicion = new Point(0,0); 
    //tamaño de la imagen
    private Dimension d = new Dimension(105,74);   
    //identifica la pieza
    private String key;
    
    public Pieza(String key){
    
        this.key = key;
        this.setToolTipText(key);
        this.setSize (d);
        this.setPreferredSize(d);
        this.setIcon(new ImageIcon(getClass().getResource("/img/perro.png")));
        this.setText("");
        this.setVisible(true);
        this.setLocation(posicion);
        this.inicio = posicion;
        this.setName(key);     
    }
    
    
    
}
