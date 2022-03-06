package daw.prog10_1_tarea;

import javax.swing.JOptionPane;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase que genera una interfaz a través de la clase JFrame. Se trata de un menú, para gestionar una estación de servicio
con 8 surtidores. La aplicación permite ir listando los importes que los clientes van debiendo en una lista, restaurando el 
valor en el momento del pago y almacenando todos los valores en el total recaudado. Se validan los datos introducidos, se incluyen
mensajes de aviso conforme las operaciones no se pueden hacer o si se han realizado con éxito y se crean un par de botones 
fuera de requerimiento: resetear el total recaudado y salir de la aplicación.
 */
public class NewJFrame extends javax.swing.JFrame {

    //Atributos
    int numSurtidor;
    double[] surtidores;
    double recadacionTotal;

    //Constructor
    public NewJFrame(double[] s, double rt) {
        initComponents();
        this.surtidores = s;
        this.recadacionTotal = rt;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Surtidor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        importe = new javax.swing.JTextField();
        Repostado = new javax.swing.JButton();
        Pagado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        importesDebidos = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Recadación = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        resetearRecadacion = new javax.swing.JButton();
        sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estación de servizo");
        setBackground(new java.awt.Color(102, 102, 102));

        Surtidor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        Surtidor.setToolTipText("");
        Surtidor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Surtidor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Surtidor.setFocusable(false);
        Surtidor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SurtidorItemStateChanged(evt);
            }
        });
        Surtidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SurtidorActionPerformed(evt);
            }
        });

        jLabel1.setText("Surtidor");

        jLabel2.setText("Importe (€)");

        Repostado.setText("Repostado");
        Repostado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepostadoActionPerformed(evt);
            }
        });

        Pagado.setText("Pagado");
        Pagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagadoActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        importesDebidos.setColumns(20);
        importesDebidos.setRows(5);
        jScrollPane1.setViewportView(importesDebidos);

        jLabel3.setText("Importes debidos");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Recadación.setColumns(20);
        Recadación.setRows(5);
        jScrollPane2.setViewportView(Recadación);

        jLabel4.setText("Recadación (€)");

        resetearRecadacion.setText("Resetear");
        resetearRecadacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetearRecadacionActionPerformed(evt);
            }
        });

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(Surtidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(importe, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Repostado))
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pagado))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sair)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(resetearRecadacion))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Surtidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Repostado)
                    .addComponent(Pagado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sair)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetearRecadacion))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Método que almacena en una variable la opción que está seleccionada del Combobox
    private void SurtidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SurtidorActionPerformed
        numSurtidor = Integer.valueOf(Surtidor.getSelectedItem().toString()) - 1;
    }//GEN-LAST:event_SurtidorActionPerformed

    private void SurtidorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SurtidorItemStateChanged

    }//GEN-LAST:event_SurtidorItemStateChanged
    /*Método donde al accionar el botón, se almacena en un array el importe que debe el cliente de un determinado surtidor y se actualiza la información
    en el area de texto de "Importes debidos" donde se pueden ver totos los importes. También valida el dato a introducir saliendo un mensaje 
    si el dato no es válido y también sale un mensaje si la operación se realiza con éxito.
     */
    private void RepostadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepostadoActionPerformed

        try {
            double importeDouble = Double.valueOf(importe.getText());
            if (importeDouble < 0) {
                JOptionPane.showMessageDialog(this, "O importe debe ser un número positivo", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                surtidores[numSurtidor] += importeDouble;
                JOptionPane.showMessageDialog(this, "Surtidor número " + (numSurtidor + 1) + " repostado. Importe: " + importeDouble + " €", "Información", JOptionPane.INFORMATION_MESSAGE);
                importesDebidos.setText(
                        "1 -" + String.valueOf(surtidores[0])
                        + "\n2 -" + String.valueOf(surtidores[1])
                        + "\n3 -" + String.valueOf(surtidores[2])
                        + "\n4 -" + String.valueOf(surtidores[3])
                        + "\n5 -" + String.valueOf(surtidores[4])
                        + "\n6 -" + String.valueOf(surtidores[5])
                        + "\n7 -" + String.valueOf(surtidores[6])
                        + "\n8 -" + String.valueOf(surtidores[7])
                );
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, inserte importe válido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_RepostadoActionPerformed
    /*Método donde al accionar el botón cuando se paga el importe que se debe, se suma al total de recaudación, la posición correspondiente
    del array se pone a cero y también se actualiza el área de texto de "Importe debidos".Si no hay importe pendiente, aparece un mensaje
    indicando que ya está pagado y también aparece mensaje si la operación se realiza con éxito.
     */
    private void PagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagadoActionPerformed

        if (surtidores[numSurtidor] == 0) {
            JOptionPane.showMessageDialog(this, "Surtidor xa pagado", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            double valor = surtidores[numSurtidor];
            surtidores[numSurtidor] = 0;
            recadacionTotal = recadacionTotal + valor;
            Recadación.setText(String.valueOf(recadacionTotal));
            JOptionPane.showMessageDialog(this, "Surtidor número " + (numSurtidor + 1) + " pagado. Importe: " + valor + " €", "Información", JOptionPane.INFORMATION_MESSAGE);
            importesDebidos.setText(
                    "1 -" + String.valueOf(surtidores[0])
                    + "\n2 -" + String.valueOf(surtidores[1])
                    + "\n3 -" + String.valueOf(surtidores[2])
                    + "\n4 -" + String.valueOf(surtidores[3])
                    + "\n5 -" + String.valueOf(surtidores[4])
                    + "\n6 -" + String.valueOf(surtidores[5])
                    + "\n7 -" + String.valueOf(surtidores[6])
                    + "\n8 -" + String.valueOf(surtidores[7])
            );
        }
        importe.setText("");
    }//GEN-LAST:event_PagadoActionPerformed
    //Método donde al accionar el botón, se resetea a cero la cantidad recaudada
    private void resetearRecadacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetearRecadacionActionPerformed

        if (recadacionTotal == 0) {
            JOptionPane.showMessageDialog(this, "Recadación xa baleira", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            recadacionTotal = 0;
            Recadación.setText(String.valueOf(recadacionTotal));
            JOptionPane.showMessageDialog(this, "Recadación reseteada", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_resetearRecadacionActionPerformed
    //Método donde al accionar el botón, se sale de la aplicación
    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pagado;
    private javax.swing.JTextArea Recadación;
    private javax.swing.JButton Repostado;
    private javax.swing.JComboBox<String> Surtidor;
    private javax.swing.JTextField importe;
    private javax.swing.JTextArea importesDebidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton resetearRecadacion;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables
}
