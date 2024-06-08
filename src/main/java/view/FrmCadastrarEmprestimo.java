package view;

import com.google.protobuf.TextFormat;
import dao.AmigoDAO;
import dao.DatabaseConnection;
import dao.EmprestimoDAO;
import dao.FerramentaDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Emprestimo;
import model.Ferramenta;
import model.UtilData;
import model.UtilData;

public class FrmCadastrarEmprestimo extends javax.swing.JFrame {

    /**
     * Declaração de variáveis de controle e instâncias de DAOs e objetos
     */
    private AmigoDAO daoAmg;
    private FerramentaDAO dao;
    private EmprestimoDAO daoEmp;
    private boolean countData = true;
    private Emprestimo objetoEmprestimo;
    private DatabaseConnection db;
    public ArrayList<String> FerSelect;

    /**
     * Construtor da classe
     */
    public FrmCadastrarEmprestimo() {
        initComponents();      
        String data = UtilData.dataAtual().toString();
        JTFDataEmp.setText(data);
        db = new DatabaseConnection();
        this.objetoEmprestimo = new Emprestimo();
        this.daoAmg = new AmigoDAO();
        this.dao = new FerramentaDAO();
        this.daoEmp = new EmprestimoDAO(); 
        this.FerSelect = new ArrayList<>();
        preencherComboBox();
        carregaTabelaFerramentas();
    }
        
    /**
     * Método para preencher o ComboBox com os nomes dos amigos
     */
    private void preencherComboBox() {
        try {
            String query = "SELECT nome FROM tb_amigos";
            PreparedStatement statement = db.getConexao().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                JCBAmigo.addItem(nome);
            }

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
            /**
             * Lidar com exceções adequadamente
             */
        }
    }

    /**
     * Método para carregar a tabela de ferramentas disponíveis
     */
    private void carregaTabelaFerramentas() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTable.getModel();
        modelo.setNumRows(0);
        for (Ferramenta a : dao.getFerramentasDisponiveis()) {
            modelo.addRow(new Object[]{
                a.getNome()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        JTFDataEmp = new javax.swing.JTextField();
        JCBAmigo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        JTFDataDev = new javax.swing.JTextField();
        JBCadastrar = new javax.swing.JButton();
        JBCancelar = new javax.swing.JButton();
        JTFFerramenta = new javax.swing.JTextField();
        JBAdicionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JTFAmigo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Empréstimos");
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel2.setText("Data do Empréstimo:");

        JTFDataEmp.setEditable(false);
        JTFDataEmp.setBackground(new java.awt.Color(166, 166, 166));
        JTFDataEmp.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        JTFDataEmp.setForeground(new java.awt.Color(255, 255, 255));
        JTFDataEmp.setBorder(null);

        JCBAmigo.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        JCBAmigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));
        JCBAmigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JCBAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBAmigoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel3.setText("Data de Devolução:");

        JTFDataDev.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        JTFDataDev.setText("yyyy-MM-dd");
        JTFDataDev.setBorder(null);
        JTFDataDev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTFDataDevMouseClicked(evt);
            }
        });
        JTFDataDev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTFDataDevKeyPressed(evt);
            }
        });

        JBCadastrar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        JBCadastrar.setText("Cadastrar");
        JBCadastrar.setBorder(null);
        JBCadastrar.setContentAreaFilled(false);
        JBCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        JBCancelar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        JBCancelar.setText("Fechar");
        JBCancelar.setBorder(null);
        JBCancelar.setContentAreaFilled(false);
        JBCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JTFFerramenta.setEditable(false);
        JTFFerramenta.setBackground(new java.awt.Color(166, 166, 166));
        JTFFerramenta.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        JTFFerramenta.setForeground(new java.awt.Color(255, 255, 255));
        JTFFerramenta.setBorder(null);

        JBAdicionar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        JBAdicionar.setText("Adicionar");
        JBAdicionar.setBorder(null);
        JBAdicionar.setContentAreaFilled(false);
        JBAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAdicionarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel1.setText("Amigo:");

        JTFAmigo.setEditable(false);
        JTFAmigo.setBackground(new java.awt.Color(166, 166, 166));
        JTFAmigo.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        JTFAmigo.setForeground(new java.awt.Color(255, 255, 255));
        JTFAmigo.setBorder(null);

        jTable.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Ferramentas"
            }
        ));
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JTFFerramenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCBAmigo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JTFAmigo)
                    .addComponent(JTFDataEmp)
                    .addComponent(JTFDataDev))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(JTFAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTFFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(JTFDataEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(JTFDataDev, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(756, 438));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void JCBAmigoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String nomeSelecionado = (String) JCBAmigo.getSelectedItem();
        JTFAmigo.setText(nomeSelecionado);
    }                                        

    private void JTFDataDevMouseClicked(java.awt.event.MouseEvent evt) {                                        
        if (countData == true) {
            JTFDataDev.setText("");
            countData = false;
        }
    }                                       

    private void JTFDataDevKeyPressed(java.awt.event.KeyEvent evt) {                                      
        if (countData == true) {
            JTFDataDev.setText("");
            countData = false;
        }
    }                                     

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            String regex = "\\d{4}-\\d{2}-\\d{2}";
            int idAmg = 0;
            Date dataEmprestimo = UtilData.dataAtual();
            boolean entregue = false;
            Date dataDevolucao = null;

            if ("".equals(this.JTFAmigo.getText())) {
                throw new Mensagem("Primeiro selecione um Amigo.");
            } else {
                idAmg = AmigoDAO.getIdPeloNome(JTFAmigo.getText());
                boolean Ver = daoAmg.verificarPendencia(idAmg);
                if (Ver == true) {
                    int respostaUsuario = JOptionPane.showConfirmDialog(null, "Esse amigo tem empréstimos pendentes deseja continuar?");

                    if (respostaUsuario != 0) {
                        return;
                    }
                }
            }

            if (FerSelect.size() == 0) {
                throw new Mensagem("Primeiro selecione pelo menos uma Ferramenta");
            }

            if (this.JTFDataDev.getText().matches(regex)) {
                dataDevolucao = UtilData.stringParaDateSQL(JTFDataDev.getText());
                if (dataDevolucao.before(dataEmprestimo)) {
                    dataDevolucao = null;
                    throw new Mensagem("Data de Devolução não pode ser antes da Data do Empréstimo");

                } else if (dataDevolucao.after(dataEmprestimo)) {
                    dataDevolucao = UtilData.stringParaDateSQL(JTFDataDev.getText());
                } else {
                    dataDevolucao = null;
                    throw new Mensagem("Data de Devolução não pode ser igual a da Data do Empréstimo");
                }
            } else {
                throw new Mensagem("Data de Devolução deve conter o seguite formato:\nyyyy-MM-dd");
            }

            if (this.objetoEmprestimo.inserirEmprestimo(dataEmprestimo, dataDevolucao, entregue, idAmg)) {
                JOptionPane.showMessageDialog(rootPane, "Empréstimo Cadastrado com Sucesso!");
                this.JTFAmigo.setText("");
                this.JTFFerramenta.setText("");
                this.JTFDataDev.setText("");

            }
            /**
             * System.out.println(this.objEmprestimo.getListaFerramentas().toString());
             */
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (TextFormat.ParseException ex) {
            Logger.getLogger(FrmCadastrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(FrmCadastrarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            carregaTabelaFerramentas();
        }

    }                                           

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
    }                                          

    private void JBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (this.jTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Primeiro Selecione uma Ferramenta");
        } else {
            if (this.jTable.getSelectedRow() != -1) {
                String id = this.jTable.getValueAt(this.jTable.getSelectedRow(), 0).toString();
                if (!FerSelect.contains(id)) {
                    /**
                     * Verifica se o número já está na lista
                     */
                    FerSelect.add(id);
                    System.out.println("Selecionados: " + FerSelect);
                    JOptionPane.showMessageDialog(null, "Ferramenta adicionada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Essa Ferramenta já foi adicionada!");
                }
            }
        }

    }                                           

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {                                    
        if (this.jTable.getSelectedRow() != -1) {
            String nome = this.jTable.getValueAt(this.jTable.getSelectedRow(), 0).toString();
            this.JTFFerramenta.setText(nome);
        }
    }                                   

    private void jTableAncestorAdded(javax.swing.event.AncestorEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastrarEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton JBAdicionar;
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JComboBox<String> JCBAmigo;
    private javax.swing.JTextField JTFAmigo;
    private javax.swing.JTextField JTFDataDev;
    private javax.swing.JTextField JTFDataEmp;
    private javax.swing.JTextField JTFFerramenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    // End of variables declaration                   
}
