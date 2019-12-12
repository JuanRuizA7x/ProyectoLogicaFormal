/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ProyectoLogica.Formula;
import ProyectoLogica.ProyectoLogica;

/**
 * @author Juan Ruiz
 * @author Juan Pinzon
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private ArrayList<Formula> formulas;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        formulas = new ArrayList<>();

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width / 2, height / 2);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void actualizarTabla() {
        String[][] matriz = new String[formulas.size()][2];

        for (int i = 0; i < formulas.size(); i++) {
            matriz[i][0] = formulas.get(i).getProposicional();
            matriz[i][1] = formulas.get(i).getFnc();
        }

        jTableFormulas.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Fórmula Proposicional", "FNC"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldFormula = new javax.swing.JTextField();
        jButtonAgregarFormula = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonDobleImplicacion = new javax.swing.JButton();
        jButtonImplicacion = new javax.swing.JButton();
        jButtonConjuncion = new javax.swing.JButton();
        jButtonDisyuncion = new javax.swing.JButton();
        jButtonNegacion = new javax.swing.JButton();
        jButtonP = new javax.swing.JButton();
        jButtonQ = new javax.swing.JButton();
        jButtonR = new javax.swing.JButton();
        jButtonS = new javax.swing.JButton();
        jButtonT = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFormulas = new javax.swing.JTable();
        jButtonEliminar = new javax.swing.JButton();
        jButtonVerPasosFNC = new javax.swing.JButton();
        jButtonVerificarSatisfacibilidad = new javax.swing.JButton();
        jButtonGuia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldFormula.setEnabled(false);

        jButtonAgregarFormula.setText("Agregar Fórmula");
        jButtonAgregarFormula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarFormulaActionPerformed(evt);
            }
        });

        jButtonLimpiar.setText("Limpiar Área ");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonDobleImplicacion.setText("(p) ↔ (q)");
        jButtonDobleImplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDobleImplicacionActionPerformed(evt);
            }
        });

        jButtonImplicacion.setText("(p) → (q)");
        jButtonImplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImplicacionActionPerformed(evt);
            }
        });

        jButtonConjuncion.setText("(p) Λ (q)");
        jButtonConjuncion.setPreferredSize(new java.awt.Dimension(77, 23));
        jButtonConjuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConjuncionActionPerformed(evt);
            }
        });

        jButtonDisyuncion.setText("(p) V (q)");
        jButtonDisyuncion.setPreferredSize(new java.awt.Dimension(77, 23));
        jButtonDisyuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisyuncionActionPerformed(evt);
            }
        });

        jButtonNegacion.setText("¬ (p)");
        jButtonNegacion.setPreferredSize(new java.awt.Dimension(77, 23));
        jButtonNegacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNegacionActionPerformed(evt);
            }
        });

        jButtonP.setText("p");
        jButtonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPActionPerformed(evt);
            }
        });

        jButtonQ.setText("q");
        jButtonQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQActionPerformed(evt);
            }
        });

        jButtonR.setText("r");
        jButtonR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRActionPerformed(evt);
            }
        });

        jButtonS.setText("s");
        jButtonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSActionPerformed(evt);
            }
        });

        jButtonT.setText("t");
        jButtonT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jTableFormulas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fórmula Proposicional", "FNC"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFormulas.setRowHeight(25);
        jScrollPane1.setViewportView(jTableFormulas);

        jButtonEliminar.setLabel("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonVerPasosFNC.setText("Ver Pasos FNC");
        jButtonVerPasosFNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerPasosFNCActionPerformed(evt);
            }
        });

        jButtonVerificarSatisfacibilidad.setText("Verificar Satisfacibilidad");
        jButtonVerificarSatisfacibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerificarSatisfacibilidadActionPerformed(evt);
            }
        });

        jButtonGuia.setText("Guía");
        jButtonGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldFormula, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAgregarFormula, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jButtonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonDobleImplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonImplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonConjuncion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonDisyuncion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonNegacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonGuia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVerificarSatisfacibilidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVerPasosFNC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldFormula)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAgregarFormula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimpiar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDobleImplicacion)
                    .addComponent(jButtonImplicacion)
                    .addComponent(jButtonConjuncion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDisyuncion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNegacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonP)
                    .addComponent(jButtonQ)
                    .addComponent(jButtonR)
                    .addComponent(jButtonS)
                    .addComponent(jButtonT))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalir)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonVerPasosFNC)
                    .addComponent(jButtonVerificarSatisfacibilidad)
                    .addComponent(jButtonGuia))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDobleImplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDobleImplicacionActionPerformed
        if (jTextFieldFormula.getText().isEmpty()) {
            jTextFieldFormula.setText("(*) ↔ (*)");
        } else if (!jTextFieldFormula.getText().contains("*")) {
            JOptionPane.showMessageDialog(null, "Fórmula completa");
        } else {

            String formula = jTextFieldFormula.getText();

            try {
                ArrayList<Integer> posiciones = new ArrayList<>();

                for (int i = 0; i < formula.length(); i++) {
                    if (formula.charAt(i) == '*') {
                        posiciones.add(i);
                    }
                }
                int posicion;
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el asterisco en el que desea ingresar la subfórmula"
                        + "\nEjemplo: Para ingresarla en el primer asterisco, ingrese 1"));

                if (posicion > posiciones.size()) {
                    JOptionPane.showMessageDialog(null, "Posición inválida");
                } else {
                    int aux = posiciones.get(posicion - 1);
                    formula = formula.substring(0, aux) + "(*) ↔ (*)" + formula.substring(aux + 1);
                    jTextFieldFormula.setText(formula);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }//GEN-LAST:event_jButtonDobleImplicacionActionPerformed

    private void jButtonImplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImplicacionActionPerformed
        if (jTextFieldFormula.getText().isEmpty()) {
            jTextFieldFormula.setText("(*) → (*)");
        } else if (!jTextFieldFormula.getText().contains("*")) {
            JOptionPane.showMessageDialog(null, "Fórmula completa");
        } else {

            String formula = jTextFieldFormula.getText();

            try {
                ArrayList<Integer> posiciones = new ArrayList<>();

                for (int i = 0; i < formula.length(); i++) {
                    if (formula.charAt(i) == '*') {
                        posiciones.add(i);
                    }
                }
                int posicion;
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el asterisco en el que desea ingresar la subfórmula"
                        + "\nEjemplo: Para ingresarla en el primer asterisco, ingrese 1"));

                if (posicion > posiciones.size()) {
                    JOptionPane.showMessageDialog(null, "Posición inválida");
                } else {
                    int aux = posiciones.get(posicion - 1);
                    formula = formula.substring(0, aux) + "(*) → (*)" + formula.substring(aux + 1);
                    jTextFieldFormula.setText(formula);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }//GEN-LAST:event_jButtonImplicacionActionPerformed

    private void jButtonConjuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConjuncionActionPerformed
        if (jTextFieldFormula.getText().isEmpty()) {
            jTextFieldFormula.setText("(*) Λ (*)");
        } else if (!jTextFieldFormula.getText().contains("*")) {
            JOptionPane.showMessageDialog(null, "Fórmula completa");
        } else {

            String formula = jTextFieldFormula.getText();

            try {
                ArrayList<Integer> posiciones = new ArrayList<>();

                for (int i = 0; i < formula.length(); i++) {
                    if (formula.charAt(i) == '*') {
                        posiciones.add(i);
                    }
                }
                int posicion;
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el asterisco en el que desea ingresar la subfórmula"
                        + "\nEjemplo: Para ingresarla en el primer asterisco, ingrese 1"));

                if (posicion > posiciones.size()) {
                    JOptionPane.showMessageDialog(null, "Posición inválida");
                } else {
                    int aux = posiciones.get(posicion - 1);
                    formula = formula.substring(0, aux) + "(*) Λ (*)" + formula.substring(aux + 1);
                    jTextFieldFormula.setText(formula);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }//GEN-LAST:event_jButtonConjuncionActionPerformed

    private void jButtonDisyuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisyuncionActionPerformed
        if (jTextFieldFormula.getText().isEmpty()) {
            jTextFieldFormula.setText("(*) V (*)");
        } else if (!jTextFieldFormula.getText().contains("*")) {
            JOptionPane.showMessageDialog(null, "Fórmula completa");
        } else {

            String formula = jTextFieldFormula.getText();

            try {
                ArrayList<Integer> posiciones = new ArrayList<>();

                for (int i = 0; i < formula.length(); i++) {
                    if (formula.charAt(i) == '*') {
                        posiciones.add(i);
                    }
                }
                int posicion;
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el asterisco en el que desea ingresar la subfórmula"
                        + "\nEjemplo: Para ingresarla en el primer asterisco, ingrese 1"));

                if (posicion > posiciones.size()) {
                    JOptionPane.showMessageDialog(null, "Posición inválida");
                } else {
                    int aux = posiciones.get(posicion - 1);
                    formula = formula.substring(0, aux) + "(*) V (*)" + formula.substring(aux + 1);
                    jTextFieldFormula.setText(formula);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }//GEN-LAST:event_jButtonDisyuncionActionPerformed

    private void jButtonNegacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNegacionActionPerformed
        if (jTextFieldFormula.getText().isEmpty()) {
            jTextFieldFormula.setText("¬ (*)");
        } else if (!jTextFieldFormula.getText().contains("*")) {
            JOptionPane.showMessageDialog(null, "Fórmula completa");
        } else {

            String formula = jTextFieldFormula.getText();

            try {
                ArrayList<Integer> posiciones = new ArrayList<>();

                for (int i = 0; i < formula.length(); i++) {
                    if (formula.charAt(i) == '*') {
                        posiciones.add(i);
                    }
                }
                int posicion;
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el asterisco en el que desea ingresar la subfórmula"
                        + "\nEjemplo: Para ingresarla en el primer asterisco, ingrese 1"));

                if (posicion > posiciones.size()) {
                    JOptionPane.showMessageDialog(null, "Posición inválida");
                } else {
                    int aux = posiciones.get(posicion - 1);
                    formula = formula.substring(0, aux) + "¬ (*)" + formula.substring(aux + 1);
                    jTextFieldFormula.setText(formula);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }//GEN-LAST:event_jButtonNegacionActionPerformed

    private void jButtonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPActionPerformed
        if (jTextFieldFormula.getText().isEmpty()) {
            jTextFieldFormula.setText("p");
        } else if (!jTextFieldFormula.getText().contains("*")) {
            JOptionPane.showMessageDialog(null, "Fórmula completa");
        } else {

            String formula = jTextFieldFormula.getText();

            try {
                ArrayList<Integer> posiciones = new ArrayList<>();

                for (int i = 0; i < formula.length(); i++) {
                    if (formula.charAt(i) == '*') {
                        posiciones.add(i);
                    }
                }
                int posicion;
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el asterisco en el que desea ingresar la subfórmula"
                        + "\nEjemplo: Para ingresarla en el primer asterisco, ingrese 1"));

                if (posicion > posiciones.size()) {
                    JOptionPane.showMessageDialog(null, "Posición inválida");
                } else {
                    int aux = posiciones.get(posicion - 1);
                    formula = formula.substring(0, aux) + "p" + formula.substring(aux + 1);
                    jTextFieldFormula.setText(formula);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }//GEN-LAST:event_jButtonPActionPerformed

    private void jButtonQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQActionPerformed
        if (jTextFieldFormula.getText().isEmpty()) {
            jTextFieldFormula.setText("q");
        } else if (!jTextFieldFormula.getText().contains("*")) {
            JOptionPane.showMessageDialog(null, "Fórmula completa");
        } else {

            String formula = jTextFieldFormula.getText();

            try {
                ArrayList<Integer> posiciones = new ArrayList<>();

                for (int i = 0; i < formula.length(); i++) {
                    if (formula.charAt(i) == '*') {
                        posiciones.add(i);
                    }
                }
                int posicion;
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el asterisco en el que desea ingresar la subfórmula"
                        + "\nEjemplo: Para ingresarla en el primer asterisco, ingrese 1"));

                if (posicion > posiciones.size()) {
                    JOptionPane.showMessageDialog(null, "Posición inválida");
                } else {
                    int aux = posiciones.get(posicion - 1);
                    formula = formula.substring(0, aux) + "q" + formula.substring(aux + 1);
                    jTextFieldFormula.setText(formula);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }//GEN-LAST:event_jButtonQActionPerformed

    private void jButtonRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRActionPerformed
        if (jTextFieldFormula.getText().isEmpty()) {
            jTextFieldFormula.setText("r");
        } else if (!jTextFieldFormula.getText().contains("*")) {
            JOptionPane.showMessageDialog(null, "Fórmula completa");
        } else {

            String formula = jTextFieldFormula.getText();

            try {
                ArrayList<Integer> posiciones = new ArrayList<>();

                for (int i = 0; i < formula.length(); i++) {
                    if (formula.charAt(i) == '*') {
                        posiciones.add(i);
                    }
                }
                int posicion;
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el asterisco en el que desea ingresar la subfórmula"
                        + "\nEjemplo: Para ingresarla en el primer asterisco, ingrese 1"));

                if (posicion > posiciones.size()) {
                    JOptionPane.showMessageDialog(null, "Posición inválida");
                } else {
                    int aux = posiciones.get(posicion - 1);
                    formula = formula.substring(0, aux) + "r" + formula.substring(aux + 1);
                    jTextFieldFormula.setText(formula);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }//GEN-LAST:event_jButtonRActionPerformed

    private void jButtonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSActionPerformed
        if (jTextFieldFormula.getText().isEmpty()) {
            jTextFieldFormula.setText("s");
        } else if (!jTextFieldFormula.getText().contains("*")) {
            JOptionPane.showMessageDialog(null, "Fórmula completa");
        } else {

            String formula = jTextFieldFormula.getText();

            try {
                ArrayList<Integer> posiciones = new ArrayList<>();

                for (int i = 0; i < formula.length(); i++) {
                    if (formula.charAt(i) == '*') {
                        posiciones.add(i);
                    }
                }
                int posicion;
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el asterisco en el que desea ingresar la subfórmula"
                        + "\nEjemplo: Para ingresarla en el primer asterisco, ingrese 1"));

                if (posicion > posiciones.size()) {
                    JOptionPane.showMessageDialog(null, "Posición inválida");
                } else {
                    int aux = posiciones.get(posicion - 1);
                    formula = formula.substring(0, aux) + "s" + formula.substring(aux + 1);
                    jTextFieldFormula.setText(formula);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }//GEN-LAST:event_jButtonSActionPerformed

    private void jButtonTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTActionPerformed
        if (jTextFieldFormula.getText().isEmpty()) {
            jTextFieldFormula.setText("t");
        } else if (!jTextFieldFormula.getText().contains("*")) {
            JOptionPane.showMessageDialog(null, "Fórmula completa");
        } else {

            String formula = jTextFieldFormula.getText();

            try {
                ArrayList<Integer> posiciones = new ArrayList<>();

                for (int i = 0; i < formula.length(); i++) {
                    if (formula.charAt(i) == '*') {
                        posiciones.add(i);
                    }
                }
                int posicion;
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el asterisco en el que desea ingresar la subfórmula"
                        + "\nEjemplo: Para ingresarla en el primer asterisco, ingrese 1"));

                if (posicion > posiciones.size()) {
                    JOptionPane.showMessageDialog(null, "Posición inválida");
                } else {
                    int aux = posiciones.get(posicion - 1);
                    formula = formula.substring(0, aux) + "t" + formula.substring(aux + 1);
                    jTextFieldFormula.setText(formula);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }//GEN-LAST:event_jButtonTActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        jTextFieldFormula.setText("");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonAgregarFormulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarFormulaActionPerformed
        if (jTextFieldFormula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ninguna fórmula");
        } else if (jTextFieldFormula.getText().contains("*")) {
            JOptionPane.showMessageDialog(null, "Fórmula mal formada");
        } else {
            formulas.add(new Formula(jTextFieldFormula.getText()));
            actualizarTabla();
            jTextFieldFormula.setText("");
        }
    }//GEN-LAST:event_jButtonAgregarFormulaActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        try {
            int fila = jTableFormulas.getSelectedRow();
            if (fila < formulas.size()) {
                formulas.remove(fila);
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado la fórmula");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado la fórmula");
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonVerPasosFNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerPasosFNCActionPerformed
        try {
            int fila = jTableFormulas.getSelectedRow();
            if (fila < formulas.size()) {
                String pasos = "Transformación a FNC \n";
                pasos += formulas.get(fila).getProposicional() + "\n";

                Formula formula = formulas.get(fila);

                for (int i = 0; i < formula.getPasosFnc().size(); i++) {
                    pasos += formula.getPasosFnc().get(i) + "\n";
                }

                JOptionPane.showMessageDialog(null, pasos);

            } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado la fórmula");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado la fórmula");
        }
    }//GEN-LAST:event_jButtonVerPasosFNCActionPerformed

    private void jButtonVerificarSatisfacibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerificarSatisfacibilidadActionPerformed

        if (!formulas.isEmpty()) {
            ArrayList<String> clausulas = ProyectoLogica.obtenerClausulas(formulas);
            boolean satisfacible = ProyectoLogica.verificarSatisfacibilidad(formulas);
            String satis = "";
            if (satisfacible) {
                satis = "Es satisfacible";
            } else {
                satis = "No es satisfacible";
            }
            JOptionPane.showMessageDialog(null, "Formas clausales: \n\n" + clausulas + "\n\n" + satis);
        } else {
            JOptionPane.showMessageDialog(null, "No ha ingresado  ninguna fórmula");
        }

    }//GEN-LAST:event_jButtonVerificarSatisfacibilidadActionPerformed

    private void jButtonGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuiaActionPerformed
        try {
            File objetofile = new File("Manal de uso.pdf");
            Desktop.getDesktop().open(objetofile);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_jButtonGuiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarFormula;
    private javax.swing.JButton jButtonConjuncion;
    private javax.swing.JButton jButtonDisyuncion;
    private javax.swing.JButton jButtonDobleImplicacion;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuia;
    private javax.swing.JButton jButtonImplicacion;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonNegacion;
    private javax.swing.JButton jButtonP;
    private javax.swing.JButton jButtonQ;
    private javax.swing.JButton jButtonR;
    private javax.swing.JButton jButtonS;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonT;
    private javax.swing.JButton jButtonVerPasosFNC;
    private javax.swing.JButton jButtonVerificarSatisfacibilidad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFormulas;
    private javax.swing.JTextField jTextFieldFormula;
    // End of variables declaration//GEN-END:variables
}
