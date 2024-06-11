package visao;

public class FrmMenuPrincipal extends javax.swing.JFrame {

    public FrmMenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCadastroAmigos = new javax.swing.JMenuItem();
        menuGerenciarAmigos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuCadastroFerramentas = new javax.swing.JMenuItem();
        menuGerenciarFerramentas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuCadastroEmprestimos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuAcessarRelatorios = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel2.setFont(new java.awt.Font("Cambria Math", 3, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Empréstimo de Ferramentas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(128, 128, 128)
                .addComponent(jLabel2)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        jMenu1.setText("Amigos");

        menuCadastroAmigos.setText("Cadrastar Amigo");
        menuCadastroAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroAmigosActionPerformed(evt);
            }
        });
        jMenu1.add(menuCadastroAmigos);

        menuGerenciarAmigos.setText("Gerenciar Amigos");
        menuGerenciarAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGerenciarAmigosActionPerformed(evt);
            }
        });
        jMenu1.add(menuGerenciarAmigos);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Ferramentas");

        menuCadastroFerramentas.setText("Cadastrar Ferramenta");
        menuCadastroFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroFerramentasActionPerformed(evt);
            }
        });
        jMenu3.add(menuCadastroFerramentas);

        menuGerenciarFerramentas.setText("Gerenciar Ferramentas");
        menuGerenciarFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGerenciarFerramentasActionPerformed(evt);
            }
        });
        jMenu3.add(menuGerenciarFerramentas);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Empréstimos");

        menuCadastroEmprestimos.setText("Cadastrar Empréstimo");
        menuCadastroEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroEmprestimosActionPerformed(evt);
            }
        });
        jMenu5.add(menuCadastroEmprestimos);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Relatórios");

        menuAcessarRelatorios.setText("Empréstimos Ativos");
        menuAcessarRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcessarRelatoriosActionPerformed(evt);
            }
        });
        jMenu2.add(menuAcessarRelatorios);

        jMenuItem1.setText("Empréstimos Totais");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Empréstimos Pendentes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Usuário com Mais Empréstimos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(718, 415));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroAmigosActionPerformed
        FrmCadastrarAmigo objeto = new FrmCadastrarAmigo();
        objeto.setVisible(true);
    }//GEN-LAST:event_menuCadastroAmigosActionPerformed

    private void menuGerenciarAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGerenciarAmigosActionPerformed
        FrmGerenciarAmigo objeto = new FrmGerenciarAmigo();
        objeto.setVisible(true);
    }//GEN-LAST:event_menuGerenciarAmigosActionPerformed

    private void menuCadastroFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroFerramentasActionPerformed
        FrmCadastroFerramentas objeto = new FrmCadastroFerramentas();
        objeto.setVisible(true);
    }//GEN-LAST:event_menuCadastroFerramentasActionPerformed

    private void menuCadastroEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroEmprestimosActionPerformed
        FrmCadastrarEmprestimo objeto = new FrmCadastrarEmprestimo();
        objeto.setVisible(true);
    }//GEN-LAST:event_menuCadastroEmprestimosActionPerformed

    private void menuGerenciarFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGerenciarFerramentasActionPerformed
        // TODO add your handling code here:
        FrmGerenciarFerramentas frmFerr = new FrmGerenciarFerramentas();
        frmFerr.setVisible(true);
    }//GEN-LAST:event_menuGerenciarFerramentasActionPerformed

    private void menuAcessarRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcessarRelatoriosActionPerformed
        FrmRelatorioAtivo objeto = new FrmRelatorioAtivo();
        objeto.setVisible(true);
    }//GEN-LAST:event_menuAcessarRelatoriosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmRelatorioEmprestimo objeto = new FrmRelatorioEmprestimo();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FrmRelatorioPendente objeto = new FrmRelatorioPendente();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FrmRelatorioComMaisEmprestimos objeto = new FrmRelatorioComMaisEmprestimos();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuAcessarRelatorios;
    private javax.swing.JMenuItem menuCadastroAmigos;
    private javax.swing.JMenuItem menuCadastroEmprestimos;
    private javax.swing.JMenuItem menuCadastroFerramentas;
    private javax.swing.JMenuItem menuGerenciarAmigos;
    private javax.swing.JMenuItem menuGerenciarFerramentas;
    // End of variables declaration//GEN-END:variables
}