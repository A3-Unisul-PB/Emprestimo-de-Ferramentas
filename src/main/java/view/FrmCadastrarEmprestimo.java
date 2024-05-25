package view;

import com.mysql.cj.util.Util;
import dao.DatabaseConnection;
import dao.EmprestimoDAO;
import dao.FerramentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Amigo;
import model.Emprestimo;
import model.Ferramenta;
import model.UtilData;

public class FrmCadastrarEmprestimo extends javax.swing.JFrame {

    private FerramentaDAO dao = new FerramentaDAO();
    private EmprestimoDAO daoEmp = new EmprestimoDAO();
    private boolean countData = true;
    private Emprestimo objEmprestimo;
    private DatabaseConnection connect;
    public ArrayList<String> FerSelect = new ArrayList<>();
    private DatabaseConnection db;

    public FrmCadastrarEmprestimo() {
        initComponents();
        preencherComboBox();
        this.objEmprestimo = new Emprestimo();
        connect = new DatabaseConnection();
        String data = UtilData.dataAtual().toString();
        inputDateEmprestimo.setText(data);
        this.carregaTabelaFerramentas();
    }

    private void preencherComboBox() {
        try {
            String query = "SELECT nome FROM tb_amigos";
            PreparedStatement statement = connect.getConexao().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                dropdownAmigos.addItem(nome);
            }

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
            // Lidar com exceções adequadamente
        }
    }

    public void carregaTabelaFerramentas() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaFerramentas.getModel(); // Corrigido para tabelaFerramentas
        modelo.setNumRows(0);
        for (Ferramenta a : dao.getFerramentasDisponiveis()) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome()
            });
        }
    }

    public boolean alterarIdEmpFerramenta() {
        String sql = "UPDATE tb_ferramentas SET id_emprestimo = ? WHERE id_ferramenta = ?";
        try {
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            for (String id : FerSelect) {
                stmt.setInt(1, daoEmp.maiorID());
                stmt.setInt(2, Integer.parseInt(id));
                stmt.execute();
            }
            FerSelect.clear();

            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dropdownAmigos = new javax.swing.JComboBox<>();
        dropdownFerramentas = new javax.swing.JComboBox<>();
        inputDataDevolucao = new javax.swing.JFormattedTextField();
        mensagemEmprestimo = new javax.swing.JLabel();
        btnEmprestar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        inputDateEmprestimo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaFerramentas = new javax.swing.JTable();

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Amigos:");

        jLabel2.setText("Ferramenta:");

        jLabel3.setText("Data de Empréstimo:");

        dropdownAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropdownAmigosActionPerformed(evt);
            }
        });

        dropdownFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropdownFerramentasActionPerformed(evt);
            }
        });

        inputDataDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDataDevolucaoActionPerformed(evt);
            }
        });

        btnEmprestar.setText("Emprestar");
        btnEmprestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Data de Devolução:");

        tabelaFerramentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Ferramenta", "Empréstimo", "Devolução"
            }
        ));
        tabelaFerramentas.setRequestFocusEnabled(false);
        jScrollPane3.setViewportView(tabelaFerramentas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(inputDateEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dropdownAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dropdownFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(btnEmprestar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(btnCancelar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mensagemEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(inputDateEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(dropdownAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(dropdownFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addComponent(mensagemEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnEmprestar)
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestarActionPerformed

        btnEmprestar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String infoAmigos = (String) dropdownAmigos.getSelectedItem();
                String infoFerramentas = (String) dropdownFerramentas.getSelectedItem();
                String dateEmprestimo = inputDateEmprestimo.getText();
                String dateDevolucao = inputDataDevolucao.getText();

                DefaultTableModel model = (DefaultTableModel) tabelaFerramentas.getModel();
                model.addRow(new Object[]{infoAmigos, infoFerramentas, dateEmprestimo, dateDevolucao});

                try {
                    String query = "INSERT INTO tb_emprestimo (colunaAmigos, colunaFerramentas, colunaDateEmprestimo, colunaDateDevolucao) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = db.prepareStatement(query);
                    pstmt.setString(1, infoAmigos);
                    pstmt.setString(2, infoFerramentas);
                    pstmt.setString(3, dateEmprestimo);
                    pstmt.setString(4, dateDevolucao);
                    pstmt.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


    }//GEN-LAST:event_btnEmprestarActionPerformed

    private void dropdownAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropdownAmigosActionPerformed
        // TODO add your handling code here:
        Object selectedAmigo = dropdownAmigos.getSelectedItem();
        Object selectedFerramenta = dropdownFerramentas.getSelectedItem();
        String inputDate = this.inputDataDevolucao.getText();

        if (selectedAmigo != null && selectedFerramenta != null && !inputDate.isEmpty()) {
            String amigo = selectedAmigo.toString();
            String ferramenta = selectedFerramenta.toString();
            mensagemEmprestimo.setText(amigo + " irá pegar " + ferramenta + " emprestado até " + inputDate + ", certo?");
        } else {
            mensagemEmprestimo.setText("Por favor, selecione um amigo, uma ferramenta e insira a data de devolução.");
        }
    }//GEN-LAST:event_dropdownAmigosActionPerformed

    private void dropdownFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropdownFerramentasActionPerformed
        // TODO add your handling code here:
        String amigo = dropdownAmigos.getSelectedItem().toString();
        String ferramenta = dropdownFerramentas.getSelectedItem().toString();
        String inputDate = this.inputDataDevolucao.getText();

        mensagemEmprestimo.setText(amigo + " irá pegar " + ferramenta + " emprestado até " + inputDate + ", certo?");
        try {
            String query = "SELECT * FROM tb_ferramentas"; 
            PreparedStatement pstmt = db.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                dropdownFerramentas.addItem(rs.getString("colunaFerramentas")); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_dropdownFerramentasActionPerformed

    private void inputDataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDataDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDataDevolucaoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadastrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastrarEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEmprestar;
    private javax.swing.JComboBox<String> dropdownAmigos;
    private javax.swing.JComboBox<String> dropdownFerramentas;
    private javax.swing.JFormattedTextField inputDataDevolucao;
    private javax.swing.JLabel inputDateEmprestimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel mensagemEmprestimo;
    private javax.swing.JTable tabelaFerramentas;
    // End of variables declaration//GEN-END:variables
}
