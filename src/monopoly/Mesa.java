/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;


import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import src.Cuadros;
import src.Pieza;
import src.Tablero;

/**
 *
 * @author dieez
 */
public class Mesa extends javax.swing.JFrame {

    
   
    
/**
     * Creates new form Mesa
     */
        private String src1;
    private String src2;
    private String src3;
    private int seleccionJ1;
    private int seleccionJ2;
    private int seleccionJ3;
    private int noJugadores;
    private int turno = 1;
    
    Pieza j1 = new Pieza("j1");
    Pieza j2 = new Pieza("j2");
    Pieza j3 = new Pieza("j3");
        
    
     Cuadros _Cuadros = new Cuadros();
    
     private Point matriz[] = _Cuadros.getMatriz();
     
    public Mesa() {
        
        initComponents();
        
        //Coloca la Aplicacion al centro de la pantalla
        this.setLocationRelativeTo(null);
        
        lblTurno.setText(String.valueOf(turno));
        
       //mensaje para seleccion de cuantos jugadores hay
       noJugadores = Integer.valueOf(JOptionPane.showInputDialog("¿Cantidad de jugadores?"));
         
       //hace a los jugadores seleccionar piezas
       switch (noJugadores) {
                case 1:
                    seleccionJ1 = Integer.valueOf(JOptionPane.showInputDialog("¿Pieza Jugador 1? \n 1. Perro \n 2. Carro \n 3. Sombrero"));
                    break;
                case 2:
                    seleccionJ1 = Integer.valueOf(JOptionPane.showInputDialog("¿Pieza Jugador 1? \n 1. Perro \n 2. Carro \n 3. Sombrero"));
                    seleccionJ2 = Integer.valueOf(JOptionPane.showInputDialog("¿Pieza Jugador 2? \n 1. Perro \n 2. Carro \n 3. Sombrero"));
                    break;
                case 3:
                    seleccionJ1 = Integer.valueOf(JOptionPane.showInputDialog("¿Pieza Jugador 1? \n 1. Perro \n 2. Carro \n 3. Sombrero"));
                    seleccionJ2 = Integer.valueOf(JOptionPane.showInputDialog("¿Pieza Jugador 2? \n 1. Perro \n 2. Carro \n 3. Sombrero"));
                    seleccionJ3 = Integer.valueOf(JOptionPane.showInputDialog("¿Pieza Jugador 3? \n 1. Perro \n 2. Carro \n 3. Sombrero"));
                    break;
                default:
                    break;
            } 
              
        
        agregarPiezas();
        
        
        //dibuja el tablero
        Tablero imagen = new Tablero();
        jPanel1.add(imagen);
        jPanel1.repaint();
        
        //muestra mensaje de a quien le toca
        JOptionPane.showMessageDialog(null, "Turno Jugador " + turno);
    }
    
    //crea al jugador 1
    public void agregarJ1() {
        switch (seleccionJ1) {
            case 1:
                src1 = "/img/perro.png";
                break;
            case 2:
                src1 = "/img/carro.png";
                break;
            case 3:
                src1 = "/img/sombrero.png";
                break;
            default:
                break;
        }

        j1.setIcon(new ImageIcon(getClass().getResource(src1)));
        j1.setLocation(_Cuadros.getInicio());
        jPanel1.add(j1);
        System.out.println("j1");
    }

    //crea al jugador 2
    public void agregarJ2() {
       

        switch (seleccionJ2) {
            case 1:
                src2 = "/img/perro.png";
                break;
            case 2:
                src2 = "/img/carro.png";
                break;
            case 3:
                src2 = "/img/sombrero.png";
                break;
            default:
                break;
        }

        j2.setIcon(new ImageIcon(getClass().getResource(src2)));
        j2.setLocation(_Cuadros.getInicio());
        jPanel1.add(j2);
    }

    //crea al jugador 3
    public void agregarJ3() {

        switch (seleccionJ3) {
            case 1:
                src3 = "/img/perro.png";
                break;
            case 2:
                src3 = "/img/carro.png";
                break;
            case 3:
                src3 = "/img/sombrero.png";
                break;
            default:
                break;
        }

        j3.setIcon(new ImageIcon(getClass().getResource(src3)));
        j3.setLocation(_Cuadros.getInicio());
        jPanel1.add(j3);
    }
    
    //agrega a los jugadores
    public void agregarPiezas() {

        switch (noJugadores) {
            case 1:
                agregarJ1();
                break;
            case 2:
                agregarJ1();
                agregarJ2();
                break;
            case 3:
                agregarJ1();
                agregarJ2();
                agregarJ3();
                break;
            default:
                break;
        }

        jPanel1.repaint();
    }
    
     //mueve la pieza dependiendo de la posicion del jugadro y el numero del dado
    public void mover(int dado, Pieza jugador) {

        int auxiliar = 0;

        //busca la posicion de la pieza
        for (int j = 0; j < 23; j++) {

            if (Point.distance(jugador.getLocation().x, jugador.getLocation().y, matriz[j].getLocation().x, matriz[j].getLocation().y) == 0) {
                auxiliar = j;
                break;
            }
        }

        //aumenta la posicion de la matriz segun el dado
        for (int i = dado; i > 0; i--) {
            auxiliar++;

        }
        //mueve la pieza
        jugador.setLocation(matriz[auxiliar]);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(910, 595));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        lblDado.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblDado.setText("0");

        jButton1.setText("Tirar dado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Turno Jugador");

        lblTurno.setText("#");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTurno))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(lblDado))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jButton1)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTurno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //genera un numero aleatorio para el dado
        int numeroAleatorio;

        numeroAleatorio = (int) (Math.random() * 6 + 1);
        lblDado.setText(String.valueOf(numeroAleatorio));
      
        //mueve dependiendo del turno en curso        
        if (turno == 3) {
            System.out.println("3");
            mover(numeroAleatorio, j3);
            turno++;
        } else if (turno == 2) {
            System.out.println("2");
            mover(numeroAleatorio, j2);
            turno++;
        } else if (turno == 1) {
            System.out.println("1");
            mover(numeroAleatorio, j1);
            turno++;
        }
        
               
        //si el turno es mayor al numero de jugadoes regresa al turno 1
        if(turno > noJugadores)
        {
            turno = 1;
        }
        
        
        //muestra mensaje de a quien le toca
        JOptionPane.showMessageDialog(null, "Turno Jugador " + turno);
        lblTurno.setText(String.valueOf(turno));
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mesa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDado;
    private javax.swing.JLabel lblTurno;
    // End of variables declaration//GEN-END:variables
}
