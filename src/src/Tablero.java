/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author dieez
 */
public class Tablero extends javax.swing.JPanel {
    //agrega la imagen del trablero
        ImageIcon tablero = new ImageIcon(getClass().getResource("/img/tablero.png"));
        
    
    public Tablero() {
        this.setSize(910, 595); //se selecciona el tamaño del panel
        
    }

//Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics grafico) {
        Dimension height = getSize();

        

//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        grafico.drawImage(tablero.getImage(), 0, 0, 910,595, null);
       
        
        
        

        setOpaque(false);
        super.paintComponent(grafico);
    }

    
    
    
}