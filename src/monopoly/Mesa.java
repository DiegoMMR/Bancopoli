/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;



import java.util.ArrayList;
import javax.swing.JOptionPane;
import src.Casilla;
import src.Casillas;
import src.Cuadros;
import src.Jugador;
import src.Tablero;

/**
 *
 * @author dieez
 */
public class Mesa extends javax.swing.JFrame {

    
   
    
/**
     * Creates new form Mesa
     */
   
    private int turno = 1;
    private int noJugadores;
    private String jugadorAPagar;
    private double cantidadAPagar = 0;
    private Casillas _Casillas = new Casillas();
    private Casilla matriz[] = _Casillas.getMatriz();
    private ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
    
    Jugador j1;
    Jugador j2;
    Jugador j3;
        
    
     Cuadros _Cuadros = new Cuadros();
    
     
     
    public Mesa() {
        
        //crea los jugadores
        this.j3 = new Jugador("Jugador 3");
        this.j2 = new Jugador("Jugador 2");
        this.j1 = new Jugador("Jugador 1");
        
        
        
        initComponents();
        
        //Coloca la Aplicacion al centro de la pantalla
        this.setLocationRelativeTo(null);
        
        lblTurno.setText(String.valueOf(turno));
        
        
        
       //mensaje para seleccion de cuantos jugadores hay
       noJugadores = Integer.valueOf(JOptionPane.showInputDialog("¿Cantidad de jugadores?"));
         
       //hace a los jugadores seleccionar piezas
        switch (noJugadores) {
            case 1:
                j1.setSeleccion(Integer.valueOf(JOptionPane.showInputDialog("¿Pieza Jugador 1? \n 1. Perro \n 2. Carro \n 3. Sombrero")));
                //llena los labes a usar
                lblSaldoJugador1.setText("Q. " + String.valueOf(j1.getSaldo()));
                
                //vacia los labes a usar
                lblSaldoJugador2.setText("");
                lblJugador2.setText("");
                lblSaldoJugador3.setText("");
                lblJugador3.setText("");
                
               
                break;
            case 2:
                j1.setSeleccion(Integer.valueOf(JOptionPane.showInputDialog("¿Pieza Jugador 1? \n 1. Perro \n 2. Carro \n 3. Sombrero")));
                j2.setSeleccion(Integer.valueOf(JOptionPane.showInputDialog("¿Pieza Jugador 1? \n 1. Perro \n 2. Carro \n 3. Sombrero")));

                lblSaldoJugador1.setText("Q. " + String.valueOf(j1.getSaldo()));
                lblSaldoJugador2.setText("Q. " + String.valueOf(j2.getSaldo()));

                lblSaldoJugador3.setText("");
                lblJugador3.setText("");
                
                
                break;
            case 3:
                j1.setSeleccion(Integer.valueOf(JOptionPane.showInputDialog("¿Pieza Jugador 1? \n 1. Perro \n 2. Carro \n 3. Sombrero")));
                j2.setSeleccion(Integer.valueOf(JOptionPane.showInputDialog("¿Pieza Jugador 1? \n 1. Perro \n 2. Carro \n 3. Sombrero")));
                j3.setSeleccion(Integer.valueOf(JOptionPane.showInputDialog("¿Pieza Jugador 1? \n 1. Perro \n 2. Carro \n 3. Sombrero")));

                lblSaldoJugador1.setText("Q. " + String.valueOf(j1.getSaldo()));
                lblSaldoJugador2.setText("Q. " + String.valueOf(j2.getSaldo()));
                lblSaldoJugador3.setText("Q. " + String.valueOf(j3.getSaldo()));
                
                listaJugadores.add(j1);
                listaJugadores.add(j2);
                listaJugadores.add(j3);
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
    
    
    
   
    //agrega a los jugadores
    public void agregarPiezas() {

        switch (noJugadores) {
            case 1:
                j1.agregar(jPanel1);
                
                 listaJugadores.add(j1);
                break;
            case 2:
                j1.agregar(jPanel1);
                j2.agregar(jPanel1);
                
                listaJugadores.add(j1);
                listaJugadores.add(j2);
                break;
            case 3:
                j1.agregar(jPanel1);
                j2.agregar(jPanel1);
                j3.agregar(jPanel1);
                
                listaJugadores.add(j1);
                listaJugadores.add(j2);
                listaJugadores.add(j3);
                break;
            default:
                break;
        }

        jPanel1.repaint();
    }
    
    public void actualizarSaldos(){
        
       if(noJugadores == 3)
       {
        String jugador1 = String.valueOf(listaJugadores.get(0).getSaldo());
        String jugador2 = String.valueOf(listaJugadores.get(1).getSaldo());
        String jugador3 = String.valueOf(listaJugadores.get(2).getSaldo());
        
        lblSaldoJugador1.setText("Q. " + jugador1);
        lblSaldoJugador2.setText("Q. " + jugador2);
        lblSaldoJugador3.setText("Q. " + jugador3);
       }
       
       if(noJugadores == 2)
       {
        String jugador1 = String.valueOf(listaJugadores.get(0).getSaldo());
        String jugador2 = String.valueOf(listaJugadores.get(1).getSaldo());
        
        lblSaldoJugador1.setText("Q. " + jugador1);
        lblSaldoJugador2.setText("Q. " + jugador2);
       }
       
        
       
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
        lblJugador1 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        lblJugador3 = new javax.swing.JLabel();
        lblSaldoJugador1 = new javax.swing.JLabel();
        lblSaldoJugador2 = new javax.swing.JLabel();
        lblSaldoJugador3 = new javax.swing.JLabel();

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

        lblJugador1.setText("Jugador 1");

        lblJugador2.setText("Jugador 2");

        lblJugador3.setText("Jugador 3");

        lblSaldoJugador1.setText("Q. ###.#");

        lblSaldoJugador2.setText("Q. ###.#");

        lblSaldoJugador3.setText("Q. ###.#");

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
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblJugador2)
                                    .addComponent(lblJugador1)
                                    .addComponent(lblJugador3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSaldoJugador1)
                                    .addComponent(lblSaldoJugador2)
                                    .addComponent(lblSaldoJugador3))))))
                .addContainerGap(36, Short.MAX_VALUE))
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
                        .addComponent(jButton1)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJugador1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblJugador2)
                                    .addComponent(lblSaldoJugador2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblJugador3)
                                    .addComponent(lblSaldoJugador3)))
                            .addComponent(lblSaldoJugador1)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void bancarrota(Jugador j)
    {
        if (j.isBancarrota() == true)
        {
            listaJugadores.remove(j);
            
            //si un jugador pierde desaparece sus datos
        if("Jugador 3".equals(j.getNombre()))
        {
             lblSaldoJugador3.setText("");
            lblJugador3.setText("");
        }
        
        if("Jugador 2".equals(j.getNombre()))
        {
             lblSaldoJugador2.setText("");
             lblJugador2.setText("");
        }
        if("Jugador 1".equals(j.getNombre()))
        {
             lblSaldoJugador1.setText("");
             lblJugador1.setText("");
        }
        
        noJugadores--;
        
        }
        
        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        
        //genera un numero aleatorio para el dado
        int dado;

        dado = (int) (Math.random() * 6 + 1);
        
        
        lblDado.setText(String.valueOf(dado));
      
        //mueve dependiendo del turno en curso
        switch (turno) {
            case 3:
                listaJugadores.get(turno-1).mover(dado, lblSaldoJugador3, matriz);
                cantidadAPagar = listaJugadores.get(turno-1).getCantidadAPagar();
                jugadorAPagar = listaJugadores.get(turno-1).getJugadorAPagar();
                turno++;
                break;
            case 2:
                listaJugadores.get(turno-1).mover(dado, lblSaldoJugador2, matriz);
                cantidadAPagar = listaJugadores.get(turno-1).getCantidadAPagar();
                jugadorAPagar = listaJugadores.get(turno-1).getJugadorAPagar();
                turno++;
                break;
            case 1:
                listaJugadores.get(turno-1).mover(dado, lblSaldoJugador1, matriz);
                cantidadAPagar = listaJugadores.get(turno-1).getCantidadAPagar();
                jugadorAPagar = listaJugadores.get(turno-1).getJugadorAPagar();
                turno++;
                break;
            default:
                break;
        }
        
        bancarrota(listaJugadores.get(turno-2));
        if(listaJugadores.size() == 1)
        {
            JOptionPane.showMessageDialog(null, "Juego terminado");
            JOptionPane.showMessageDialog(null, "Ganador: \n" + listaJugadores.get(0).getNombre());
            System.exit(0);
        }
        
        System.out.println("Cantidad a pagar mesa: " + cantidadAPagar);
        
        
        //para cambiar el saldo del jugador a pagar
        if (cantidadAPagar != 0)
        {
            if ("Jugador 3".equals(jugadorAPagar)) {  
            double saldo2 = j3.getSaldo() + cantidadAPagar;
            j3.setSaldo(saldo2);
            System.out.println("pagar a 3");
        } else if ("Jugador 2".equals(jugadorAPagar)) {            
            double saldo2 = j2.getSaldo() + cantidadAPagar;
            j2.setSaldo(saldo2);
            System.out.println("pagar a 2");
        } else if ("Jugador 1".equals(jugadorAPagar)) {
            double saldo2 = j1.getSaldo() + cantidadAPagar;
            j1.setSaldo(saldo2);
            System.out.println("pagar a 1");
        }
            actualizarSaldos();
            cantidadAPagar = 0;
            jugadorAPagar = "";
            
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
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblJugador3;
    private javax.swing.JLabel lblSaldoJugador1;
    private javax.swing.JLabel lblSaldoJugador2;
    private javax.swing.JLabel lblSaldoJugador3;
    private javax.swing.JLabel lblTurno;
    // End of variables declaration//GEN-END:variables
}
