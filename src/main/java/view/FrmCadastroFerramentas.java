package view;

import java.sql.Connection;
import model.Ferramenta;
import javax.swing.JOptionPane;

public class FrmCadastroFerramentas extends javax.swing.JFrame {
    
    private Ferramenta objetoferramenta; 
    
    public FrmCadastroFerramentas() {
        initComponents();
        this.objetoferramenta = new Ferramenta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JTFFerramenta = new javax.swing.JTextField();
        JTFMarca = new javax.swing.JTextField();
        JTFCusto = new javax.swing.JTextField();
        b_cadastrar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ferramentas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTFFerramenta.setBorder(null);
        getContentPane().add(JTFFerramenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 220, 30));

        JTFMarca.setBorder(null);
        JTFMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(JTFMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 76, 220, 30));

        JTFCusto.setBorder(null);
        getContentPane().add(JTFCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 126, 220, 30));

        b_cadastrar.setText("Cadastrar");
        b_cadastrar.setBorder(null);
        b_cadastrar.setContentAreaFilled(false);
        b_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(b_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 292, 40));

        b_cancelar.setText("Cancelar");
        b_cancelar.setBorder(null);
        b_cancelar.setContentAreaFilled(false);
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(b_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 292, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\jpns2\\OneDrive\\Documentos\\NetBeansProjects\\Emprestimo-de-Ferramentas\\src\\main\\java\\img\\FERRAMENTAS CAD.png")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void b_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cadastrarActionPerformed
        try {
            String ferramenta = "";
            String marca = "";
            double preco = 0.0;

            if (this.JTFFerramenta.getText().length() < 2) {
                throw new Mensagem("Ferramenta deve conter ao menos 2 caracteres.");
            } else {
                ferramenta = this.JTFFerramenta.getText();
            }

            if (this.JTFMarca.getText().length() <= 0) {
                throw new Mensagem("Marca deve conter ao menos 2 caracteres.");
            } else {
                marca = this.JTFMarca.getText();
            }

            if (this.JTFCusto.getText().length() <= 0) {
                throw new Mensagem("Preço deve ser número e maior que zero.");
            } else {
                preco = Double.parseDouble(this.JTFCusto.getText());
            }

            if (this.objetoferramenta.insertFerramentaBD(ferramenta, marca, preco)) {
                JOptionPane.showMessageDialog(null, "Ferramenta Cadastrada com Sucesso!");
                // limpa campos da interface
                this.JTFFerramenta.setText("");
                this.JTFMarca.setText("");
                this.JTFCusto.setText("");
            }
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_b_cadastrarActionPerformed

    private void JTFMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFMarcaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroFerramentas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTFCusto;
    private javax.swing.JTextField JTFFerramenta;
    private javax.swing.JTextField JTFMarca;
    private javax.swing.JButton b_cadastrar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
