/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.Main;

/**
 *
 * @author Usuario
 */
public class VistaTablero extends javax.swing.JFrame {

    Main main;
    boolean seleccionoInformada = false;
    boolean seleccionoNoInformada = false;
    JPanel panelNumeros;
    int dimension;
    String tablero[][];

    public VistaTablero(int dimension, String tablero[][], Main main) {
        initComponents();
        this.main = main;
        this.tablero = tablero;
        this.dimension = dimension;
        panelNumeros = new JPanel();
        JPanel panel = new JPanel();
        panel.setSize(400, 400);
        panelNumeros.setSize(400, 400);
        panelNumeros.setLayout(new GridLayout(dimension, dimension));
        // panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

        Container content = this.getContentPane();
        content.setLayout(new BorderLayout());
        content.add("North", panel);
        panel.add("Center", panelNumeros);
        nuevoBotonNumerico();
        this.btnEmpezar.addActionListener(new ManejadorBotones());
        this.comboTipoBusqueda.addItemListener(new EventosCombo());
    }
    //funcion que bloquea los del combo para No Informada

    public void bloquearNoInformada() {
        comboBusquedaNoInformada.setEnabled(seleccionoInformada);
    }
    //funcion que crea botones que llenan la cuadricula

    private void nuevoBotonNumerico() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                boolean hayQuePintar = false;

                JButton btn = new JButton();
                if (tablero[i][j].equals("-1")) {
                    hayQuePintar = true;
                    btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\PRY_IA1V1.0\\robot.fw.png")); // NOI18N
                }
                if (tablero[i][j].equals("-2")) {
                    hayQuePintar = true;
                    btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\PRY_IA1V1.0\\objeto1.fw.png")); // NOI18N
                }
                if (tablero[i][j].equals("-3")) {
                    hayQuePintar = true;
                    btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\PRY_IA1V1.0\\objeto2.fw.png")); // NOI18N
                }
                if (tablero[i][j].equals("-4")) {
                    hayQuePintar = true;
                    btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\PRY_IA1V1.0\\lugar1.fw.png")); // NOI18N
                }
                if (tablero[i][j].equals("-5")) {
                    hayQuePintar = true;
                    btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\PRY_IA1V1.0\\lugar2.fw.png")); // NOI18N
                } else if (hayQuePintar == false && !tablero[i][j].equals("0")) {
                    btn.setText("" + tablero[i][j]);
                }

                panelNumeros.add(btn);
            }
            // btn.setText("" + i);
            //    System.out.println(i);
        }
    }

    public class ManejadorBotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String respuesta;
            if (ae.getSource() == btnEmpezar) {
                if (comboBusquedaNoInformada.isEnabled()) {
                    if (comboBusquedaNoInformada.getSelectedIndex() == 0) {
                        respuesta = "Amplitud";
                        main.empezarBusqueda(respuesta);
                    }
                    if (comboBusquedaNoInformada.getSelectedIndex() == 1) {
                        respuesta = "Profundidad";
                        main.empezarBusqueda(respuesta);
                    }
                    if (comboBusquedaNoInformada.getSelectedIndex() == 2) {
                        respuesta = "Costo Uniforme";
                        main.empezarBusqueda(respuesta);
                    }
                } else if (comboInformada.isEnabled()) {
                    if (comboInformada.getSelectedIndex() == 0) {
                        respuesta = "Voraz";
                        main.empezarBusqueda(respuesta);
                    }
                    if (comboInformada.getSelectedIndex() == 1) {
                        respuesta = "A*";
                        main.empezarBusqueda(respuesta);
                    }
                }
            }
        }
    }
//maneja los eventos que ocurren en el combobox

    public class EventosCombo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if (comboTipoBusqueda.getSelectedIndex() == 0) {
                //    System.out.println("seleccionaste Busqueda Informada");
                comboInformada.setEnabled(true);
                comboBusquedaNoInformada.setEnabled(false);
            }
            if (comboTipoBusqueda.getSelectedIndex() == 1) {
                //  System.out.println("seleccionaste Busqueda No Informada");
                comboBusquedaNoInformada.setEnabled(true);
                comboInformada.setEnabled(false);
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboTipoBusqueda = new javax.swing.JComboBox();
        comboBusquedaNoInformada = new javax.swing.JComboBox();
        labelInferior = new javax.swing.JLabel();
        btnEmpezar = new javax.swing.JButton();
        comboInformada = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Informada", "No Informada" }));

        comboBusquedaNoInformada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Amplitud (BFS)", "Profundidad Ciclos (DFS2)", "Costo Uniforme (CU)" }));
        comboBusquedaNoInformada.setEnabled(false);
        comboBusquedaNoInformada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBusquedaNoInformadaActionPerformed(evt);
            }
        });

        labelInferior.setText("Estrategia:");

        btnEmpezar.setText("Empezar");

        comboInformada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Voraz (V)", "A* (A)" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(labelInferior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboBusquedaNoInformada, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboInformada, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnEmpezar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 593, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBusquedaNoInformada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInferior)
                    .addComponent(btnEmpezar)
                    .addComponent(comboInformada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBusquedaNoInformadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBusquedaNoInformadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBusquedaNoInformadaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmpezar;
    private javax.swing.JComboBox comboBusquedaNoInformada;
    private javax.swing.JComboBox comboInformada;
    private javax.swing.JComboBox comboTipoBusqueda;
    private javax.swing.JLabel labelInferior;
    // End of variables declaration//GEN-END:variables
}
