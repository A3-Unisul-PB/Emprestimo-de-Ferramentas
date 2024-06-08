package view;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.AmigoDAO;
import dao.DatabaseConnection;
import dao.EmprestimoDAO;
import dao.FerramentaDAO;
import model.Emprestimo;
import model.Ferramenta;
import model.UtilData;

public class FrmCadastrarEmprestimo extends javax.swing.JFrame {

    /**
     * Declaração de variáveis de controle e instâncias de DAOs e objetos
     */
    private AmigoDAO amigoDAO;
    private FerramentaDAO ferramentaDAO;
    private EmprestimoDAO emprestimoDAO;
    private boolean countData = true;
    private Emprestimo emprestimo;
    private DatabaseConnection db;
    private ArrayList<String> ferramentasSelecionadas;

    /**
     * Construtor da classe
     */
    public FrmCadastrarEmprestimo() {
        initComponents();
        String dataAtual = UtilData.dataAtual().toString();
        JTFDataEmp.setText(dataAtual);
        db = new DatabaseConnection();
        this.emprestimo = new Emprestimo();
        this.amigoDAO = new AmigoDAO();
        this.ferramentaDAO = new FerramentaDAO();
        this.emprestimoDAO = new EmprestimoDAO();
        this.ferramentasSelecionadas = new ArrayList<>();
        preencherComboBoxAmigos();
        carregarTabelaFerramentas();
    }

    /**
     * Método para preencher o ComboBox com os nomes dos amigos
     */
    private void preencherComboBoxAmigos() {
        try {
            String query = "SELECT nome FROM tb_amigos";
            PreparedStatement statement = db.getConexao().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                JCBAmigo.addItem(nome);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar amigos: " + ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para carregar a tabela de ferramentas disponíveis
     */
    private void carregarTabelaFerramentas() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTable.getModel();
        modelo.setNumRows(0);
        for (Ferramenta ferramenta : ferramentaDAO.getFerramentasDisponiveis()) {
            modelo.addRow(new Object[] { ferramenta.getNome() });
        }
    }

    @SuppressWarnings("unchecked")
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

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        jLabel2.setText("Data do Empréstimo:");

        JTFDataEmp.setEditable(false);
        JTFDataEmp.setBackground(new java.awt.Color(166, 166, 166));
        JTFDataEmp.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        JTFDataEmp.setForeground(new java.awt.Color(255, 255, 255));
        JTFDataEmp.setBorder(null);

        JCBAmigo.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        JCBAmigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));
        JCBAmigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JCBAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBAmigoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        jLabel3.setText("Data de Devolução:");

        JTFDataDev.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
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

        JBCadastrar.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        JBCadastrar.setText("Cadastrar");
        JBCadastrar.setBorder(null);
        JBCadastrar.setContentAreaFilled(false);
        JBCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        JBCancelar.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
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
        JTFFerramenta.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        JTFFerramenta.setForeground(new java.awt.Color(255, 255, 255));
        JTFFerramenta.setBorder(null);

        JBAdicionar.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        JBAdicionar.setText("Adicionar");
        JBAdicionar.setBorder(null);
        JBAdicionar.setContentAreaFilled(false);
        JBAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAdicionarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        jLabel1.setText("Amigo:");

        JTFAmigo.setEditable(false);
        JTFAmigo.setBackground(new java.awt.Color(166, 166, 166));
        JTFAmigo.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        JTFAmigo.setForeground(new java.awt.Color(255, 255, 255));
        JTFAmigo.setBorder(null);

        jTable.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null },
                        { null },
                        { null },
                        { null },
                        { null },
                        { null },
                        { null }
                },
                new String[] {
                        "Ferramentas"
                }));
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
                                                .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53,
                                                        Short.MAX_VALUE)
                                                .addComponent(JBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(JCBAmigo, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addComponent(JTFDataEmp)
                                        .addComponent(JTFDataDev)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(JTFFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(JBAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(238, Short.MAX_VALUE))
                        .addComponent(jScrollPane3));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTFDataEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFDataDev, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JCBAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JBAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTFFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)));

        setSize(new java.awt.Dimension(781, 547));
        setLocationRelativeTo(null);
    }

    private void JTFDataDevKeyPressed(java.awt.event.KeyEvent evt) {
    }

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void JTFDataDevMouseClicked(java.awt.event.MouseEvent evt) {
        JTFDataDev.setText("");
    }

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (!isCamposValidos()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            emprestimo.setAmigo(Integer.parseInt((String) JCBAmigo.getSelectedItem()));
            emprestimo.setDataEmprestimo(Date.valueOf(JTFDataEmp.getText()));
            emprestimo.setDataLimite(Date.valueOf(JTFDataDev.getText()));
            for (String ferramenta : ferramentasSelecionadas) {
                emprestimo.setIdFerramenta(Integer.parseInt(ferramenta));
                if (!emprestimoDAO.inserirEmprestimoBD(emprestimo)) {
                    JOptionPane.showMessageDialog(this, "Erro ao registrar empréstimo para a ferramenta: " + ferramenta,
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Empréstimo registrado com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar empréstimo: " + ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void JCBAmigoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {
        int linhaSelecionada = jTable.getSelectedRow();
        String ferramenta = jTable.getValueAt(linhaSelecionada, 0).toString();
        JTFFerramenta.setText(ferramenta);
    }

    private void JBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        String ferramenta = JTFFerramenta.getText();
        if (!ferramenta.isEmpty() && !ferramentasSelecionadas.contains(ferramenta)) {
            ferramentasSelecionadas.add(ferramenta);
            JOptionPane.showMessageDialog(this, "Ferramenta adicionada.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ferramenta já adicionada ou não selecionada.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para validar se todos os campos foram preenchidos
     */
    private boolean isCamposValidos() {
        return !(JCBAmigo.getSelectedIndex() == 0 || JTFDataDev.getText().isEmpty()
                || ferramentasSelecionadas.isEmpty());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmCadastrarEmprestimo().setVisible(true));
    }

    // Declaração de variáveis da interface
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBAdicionar;
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
}
