package view;

import conexao.ConexaoSQLite;
import view.TelaDelete;
import view.TelaPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class TelaRegistros extends javax.swing.JFrame{

    public String nomeDeUsuario = null;
     protected void pesquisar_Customers_Sem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select FullName, Telephone, Address, Email from Customers where FullName like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, PesquisarCustomers.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            TabelaCustomers.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void pesquisar_Customers() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select FullName, Telephone, Address, Email from Customers where FullName like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, PesquisarCustomers.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            TabelaCustomers.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void pesquisar_Employees_Sem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select FullName, Telephone, Address, Email from Employees;";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            resultSQL = comandoSQL.executeQuery();
            TabelaEmployees.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void pesquisar_Employees() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select FullName, Telephone, Address, Email from Employees where FullName like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1, PesquisarEmployees.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            TabelaEmployees.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void pesquisar_products_Sem() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Name, Brand, Stock, Description, Value, Type from Products;";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            resultSQL = comandoSQL.executeQuery();
            TabelaProducts.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void pesquisar_products() {

        ConexaoSQLite conexao = new ConexaoSQLite();

        conexao.conectar();
        ResultSet resultSQL = null;
        PreparedStatement comandoSQL = null;

        String sql = "select Name, Brand, Stock, Description, Value, Type from Products where Name like ?";

        try {

            comandoSQL = conexao.criarPreparedStatement(sql);
            comandoSQL.setString(1,PesquisarProducts.getText() + "%");
            resultSQL = comandoSQL.executeQuery();
            TabelaProducts.setModel(DbUtils.resultSetToTableModel(resultSQL));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
    


    
    
    

    public TelaRegistros() {

        setIcon();

        initComponents();
        
        
        setLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        resetLblColor(btn_schedule);

        Graphic.setVisible(true);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(false);
        Schedule.setVisible(false);

        TabelaProducts.getTableHeader().setOpaque(false);
        TabelaProducts.getTableHeader().setBackground(new Color(71, 120, 197));
        TabelaProducts.getTableHeader().setForeground(new Color(255, 255, 255));
        TabelaProducts.setRowHeight(25);

        TabelaCustomers.getTableHeader().setOpaque(false);
        TabelaCustomers.getTableHeader().setBackground(new Color(71, 120, 197));
        TabelaCustomers.getTableHeader().setForeground(new Color(255, 255, 255));
        TabelaCustomers.setRowHeight(25);

        TabelaEmployees.getTableHeader().setOpaque(false);
        TabelaEmployees.getTableHeader().setBackground(new Color(71, 120, 197));
        TabelaEmployees.getTableHeader().setForeground(new Color(255, 255, 255));
        TabelaEmployees.setRowHeight(25);

        TabelaSchedule.getTableHeader().setOpaque(false);
        TabelaSchedule.getTableHeader().setBackground(new Color(71, 120, 197));
        TabelaSchedule.getTableHeader().setForeground(new Color(255, 255, 255));
        TabelaSchedule.setRowHeight(25);

        TabelaServices.getTableHeader().setOpaque(false);
        TabelaServices.getTableHeader().setBackground(new Color(71, 120, 197));
        TabelaServices.getTableHeader().setForeground(new Color(255, 255, 255));
        TabelaServices.setRowHeight(25);
    }
    
        
            
    private void setar_camposProducts() {

        int setar = TabelaProducts.getSelectedRow();
        DeleteProducts.setText(TabelaProducts.getModel().getValueAt(setar, 0).toString());

    }

    public void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconPlanet.png")));

    }

    private CategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int lucro = 1000;

        int gastos = 534;

        int l = lucro - gastos;

        int m = l / 2;

        dataset.addValue(lucro, "Profit", "Overall");

        dataset.addValue(gastos, "Spending", "Overall");

        dataset.addValue(l, "Net Profit", "Overall");

        dataset.addValue(m, "Average", "Overall");

        return dataset;

    }

    public void criaGrafico() {

        CategoryDataset cds = createDataset();

        String titulo = "Monetary Chart";

        String eixoy = "Values";

        String txt_legenda = "";

        boolean legenda = true;

        boolean tooltips = true;

        boolean urls = true;

        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);

        ChartPanel myChartPanel = new ChartPanel(graf, true);

        myChartPanel.setSize(jPanel1.getWidth(), jPanel1.getHeight());

        myChartPanel.setVisible(true);

        jPanel1.removeAll();

        jPanel1.add(myChartPanel);

        jPanel1.revalidate();

        jPanel1.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_graphic = new javax.swing.JLabel();
        btn_products = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_services = new javax.swing.JLabel();
        btn_customers = new javax.swing.JLabel();
        btn_employees = new javax.swing.JLabel();
        btn_schedule = new javax.swing.JLabel();
        lblNomeDeUsuarioRegistro = new javax.swing.JLabel();
        Paineis = new javax.swing.JPanel();
        Graphic = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Products = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaProducts = new javax.swing.JTable();
        lblPesquisarProducts = new javax.swing.JLabel();
        PesquisarProducts = new javax.swing.JTextField();
        btn_DeleteProducts = new javax.swing.JLabel();
        DeleteProducts = new javax.swing.JTextField();
        Customers = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaCustomers = new javax.swing.JTable();
        lblPesquisarCustomers = new javax.swing.JLabel();
        PesquisarCustomers = new javax.swing.JTextField();
        btn_DeleteCustomers = new javax.swing.JLabel();
        DeleteCustomers = new javax.swing.JTextField();
        Employees = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelaEmployees = new javax.swing.JTable();
        lblEmployees = new javax.swing.JLabel();
        PesquisarEmployees = new javax.swing.JTextField();
        btn_DeleteEmployees = new javax.swing.JLabel();
        DeleteEmployees = new javax.swing.JTextField();
        Schedule = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelaSchedule = new javax.swing.JTable();
        PesquisarSchedule = new javax.swing.JTextField();
        btn_DeleteSchedule = new javax.swing.JLabel();
        DeleteSchedule = new javax.swing.JTextField();
        Services = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TabelaServices = new javax.swing.JTable();
        lblServices = new javax.swing.JLabel();
        PesquisarServices = new javax.swing.JTextField();
        btn_DeleteServices = new javax.swing.JLabel();
        DeleteServices = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setPreferredSize(new java.awt.Dimension(900, 555));

        header.setBackground(new java.awt.Color(23, 35, 51));
        header.setPreferredSize(new java.awt.Dimension(838, 200));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(23, 35, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        btn_graphic.setBackground(new java.awt.Color(23, 35, 51));
        btn_graphic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_graphic.setForeground(new java.awt.Color(255, 255, 255));
        btn_graphic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_graphic.setText("Graphic");
        btn_graphic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_graphic.setOpaque(true);
        btn_graphic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_graphicMouseClicked(evt);
            }
        });

        btn_products.setBackground(new java.awt.Color(23, 35, 51));
        btn_products.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_products.setForeground(new java.awt.Color(255, 255, 255));
        btn_products.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_products.setText("Products");
        btn_products.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_products.setOpaque(true);
        btn_products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_productsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_productsMouseEntered(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconFloatingPlanet.png"))); // NOI18N

        btn_services.setBackground(new java.awt.Color(23, 35, 51));
        btn_services.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_services.setForeground(new java.awt.Color(255, 255, 255));
        btn_services.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_services.setText("Services");
        btn_services.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_services.setOpaque(true);
        btn_services.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_servicesMouseClicked(evt);
            }
        });

        btn_customers.setBackground(new java.awt.Color(23, 35, 51));
        btn_customers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_customers.setForeground(new java.awt.Color(255, 255, 255));
        btn_customers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_customers.setText("Customers");
        btn_customers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_customers.setOpaque(true);
        btn_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_customersMouseClicked(evt);
            }
        });

        btn_employees.setBackground(new java.awt.Color(23, 35, 51));
        btn_employees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_employees.setForeground(new java.awt.Color(255, 255, 255));
        btn_employees.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_employees.setText("Employees");
        btn_employees.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_employees.setOpaque(true);
        btn_employees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_employeesMouseClicked(evt);
            }
        });

        btn_schedule.setBackground(new java.awt.Color(23, 35, 51));
        btn_schedule.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_schedule.setForeground(new java.awt.Color(255, 255, 255));
        btn_schedule.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_schedule.setText("Schedule");
        btn_schedule.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_schedule.setOpaque(true);
        btn_schedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_scheduleMouseClicked(evt);
            }
        });

        lblNomeDeUsuarioRegistro.setBackground(new java.awt.Color(23, 35, 51));
        lblNomeDeUsuarioRegistro.setForeground(new java.awt.Color(23, 35, 51));
        lblNomeDeUsuarioRegistro.setText("jLabel2");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNomeDeUsuarioRegistro)
                        .addGap(275, 275, 275)))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(btn_graphic, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_products, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_customers, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_employees, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_services, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_schedule, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblNomeDeUsuarioRegistro))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_employees, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_customers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_products, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_graphic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_services, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_schedule, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Paineis.setLayout(new java.awt.CardLayout());

        Graphic.setBackground(new java.awt.Color(255, 255, 255));
        Graphic.setForeground(new java.awt.Color(204, 204, 204));
        Graphic.setPreferredSize(new java.awt.Dimension(900, 565));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(785, 300));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout GraphicLayout = new javax.swing.GroupLayout(Graphic);
        Graphic.setLayout(GraphicLayout);
        GraphicLayout.setHorizontalGroup(
            GraphicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraphicLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        GraphicLayout.setVerticalGroup(
            GraphicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraphicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Paineis.add(Graphic, "card3");

        Products.setBackground(new java.awt.Color(255, 255, 255));
        Products.setForeground(new java.awt.Color(204, 204, 204));
        Products.setPreferredSize(new java.awt.Dimension(900, 565));
        Products.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabelaProducts.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        TabelaProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Brand", "Stock", "Description", "Value", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaProducts.setFocusable(false);
        TabelaProducts.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TabelaProducts.setRowHeight(25);
        TabelaProducts.setSelectionBackground(new java.awt.Color(192, 192, 192));
        TabelaProducts.setShowVerticalLines(false);
        TabelaProducts.getTableHeader().setReorderingAllowed(false);
        TabelaProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaProductsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaProducts);
        if (TabelaProducts.getColumnModel().getColumnCount() > 0) {
            TabelaProducts.getColumnModel().getColumn(0).setResizable(false);
            TabelaProducts.getColumnModel().getColumn(1).setResizable(false);
            TabelaProducts.getColumnModel().getColumn(2).setResizable(false);
            TabelaProducts.getColumnModel().getColumn(3).setResizable(false);
            TabelaProducts.getColumnModel().getColumn(4).setResizable(false);
            TabelaProducts.getColumnModel().getColumn(5).setResizable(false);
        }

        Products.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 11, 833, 227));

        lblPesquisarProducts.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPesquisarProducts.setText(" search here!");
        Products.add(lblPesquisarProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        PesquisarProducts.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PesquisarProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarProductsActionPerformed(evt);
            }
        });
        PesquisarProducts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PesquisarProductsKeyReleased(evt);
            }
        });
        Products.add(PesquisarProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 267, 270, -1));

        btn_DeleteProducts.setBackground(new java.awt.Color(23, 35, 51));
        btn_DeleteProducts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_DeleteProducts.setForeground(new java.awt.Color(255, 255, 255));
        btn_DeleteProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_DeleteProducts.setText("Delete");
        btn_DeleteProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeleteProducts.setOpaque(true);
        btn_DeleteProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeleteProductsMouseClicked(evt);
            }
        });
        Products.add(btn_DeleteProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 267, 146, 30));

        DeleteProducts.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        DeleteProducts.setToolTipText("");
        DeleteProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteProductsActionPerformed(evt);
            }
        });
        Products.add(DeleteProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 267, 189, -1));

        Paineis.add(Products, "card3");

        Customers.setBackground(new java.awt.Color(255, 255, 255));
        Customers.setForeground(new java.awt.Color(153, 153, 153));
        Customers.setPreferredSize(new java.awt.Dimension(900, 565));
        Customers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabelaCustomers.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        TabelaCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "FullName", "Age", "Email", "Telephone"
            }
        ));
        TabelaCustomers.setFocusable(false);
        TabelaCustomers.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TabelaCustomers.setRowHeight(25);
        TabelaCustomers.setSelectionBackground(new java.awt.Color(192, 192, 192));
        TabelaCustomers.setShowVerticalLines(false);
        TabelaCustomers.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TabelaCustomers);

        Customers.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 11, 833, 227));

        lblPesquisarCustomers.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPesquisarCustomers.setText("Search here!");
        Customers.add(lblPesquisarCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        PesquisarCustomers.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PesquisarCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarCustomersActionPerformed(evt);
            }
        });
        PesquisarCustomers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PesquisarCustomersKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PesquisarCustomersKeyReleased(evt);
            }
        });
        Customers.add(PesquisarCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 270, -1));

        btn_DeleteCustomers.setBackground(new java.awt.Color(23, 35, 51));
        btn_DeleteCustomers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_DeleteCustomers.setForeground(new java.awt.Color(255, 255, 255));
        btn_DeleteCustomers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_DeleteCustomers.setText("Delete");
        btn_DeleteCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeleteCustomers.setOpaque(true);
        btn_DeleteCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeleteCustomersMouseClicked(evt);
            }
        });
        Customers.add(btn_DeleteCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 260, 146, 30));

        DeleteCustomers.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        DeleteCustomers.setToolTipText("");
        DeleteCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCustomersActionPerformed(evt);
            }
        });
        Customers.add(DeleteCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 189, -1));

        Paineis.add(Customers, "card3");

        Employees.setBackground(new java.awt.Color(255, 255, 255));
        Employees.setForeground(new java.awt.Color(102, 102, 102));
        Employees.setPreferredSize(new java.awt.Dimension(900, 565));
        Employees.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabelaEmployees.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        TabelaEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "FullName", "Age", "Email", "telephone"
            }
        ));
        TabelaEmployees.setFocusable(false);
        TabelaEmployees.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TabelaEmployees.setRowHeight(25);
        TabelaEmployees.setSelectionBackground(new java.awt.Color(192, 192, 192));
        TabelaEmployees.setShowVerticalLines(false);
        TabelaEmployees.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TabelaEmployees);

        Employees.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 833, 227));

        lblEmployees.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmployees.setText(" search here!");
        Employees.add(lblEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        PesquisarEmployees.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PesquisarEmployees.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PesquisarEmployeesKeyReleased(evt);
            }
        });
        Employees.add(PesquisarEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 270, -1));

        btn_DeleteEmployees.setBackground(new java.awt.Color(23, 35, 51));
        btn_DeleteEmployees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_DeleteEmployees.setForeground(new java.awt.Color(255, 255, 255));
        btn_DeleteEmployees.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_DeleteEmployees.setText("Delete");
        btn_DeleteEmployees.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeleteEmployees.setOpaque(true);
        btn_DeleteEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeleteEmployeesMouseClicked(evt);
            }
        });
        Employees.add(btn_DeleteEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 146, 30));

        DeleteEmployees.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        DeleteEmployees.setToolTipText("");
        DeleteEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEmployeesActionPerformed(evt);
            }
        });
        Employees.add(DeleteEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 189, -1));

        Paineis.add(Employees, "card3");

        Schedule.setBackground(new java.awt.Color(255, 255, 255));
        Schedule.setForeground(new java.awt.Color(102, 102, 102));
        Schedule.setPreferredSize(new java.awt.Dimension(900, 565));

        TabelaSchedule.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        TabelaSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Telefone", "Endereço", "Email"
            }
        ));
        TabelaSchedule.setFocusable(false);
        TabelaSchedule.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TabelaSchedule.setRowHeight(25);
        TabelaSchedule.setSelectionBackground(new java.awt.Color(192, 192, 192));
        TabelaSchedule.setShowVerticalLines(false);
        TabelaSchedule.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(TabelaSchedule);

        PesquisarSchedule.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PesquisarSchedule.setText("Search here!");

        btn_DeleteSchedule.setBackground(new java.awt.Color(23, 35, 51));
        btn_DeleteSchedule.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_DeleteSchedule.setForeground(new java.awt.Color(255, 255, 255));
        btn_DeleteSchedule.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_DeleteSchedule.setText("Delete");
        btn_DeleteSchedule.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeleteSchedule.setOpaque(true);
        btn_DeleteSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeleteScheduleMouseClicked(evt);
            }
        });

        DeleteSchedule.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        DeleteSchedule.setToolTipText("");
        DeleteSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteScheduleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ScheduleLayout = new javax.swing.GroupLayout(Schedule);
        Schedule.setLayout(ScheduleLayout);
        ScheduleLayout.setHorizontalGroup(
            ScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScheduleLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(PesquisarSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(DeleteSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_DeleteSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(ScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScheduleLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        ScheduleLayout.setVerticalGroup(
            ScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScheduleLayout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addGroup(ScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DeleteSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_DeleteSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PesquisarSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(ScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScheduleLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        Paineis.add(Schedule, "card3");

        Services.setBackground(new java.awt.Color(255, 255, 255));
        Services.setForeground(new java.awt.Color(51, 51, 51));
        Services.setPreferredSize(new java.awt.Dimension(900, 565));
        Services.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabelaServices.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        TabelaServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Telefone", "Endereço", "Email"
            }
        ));
        TabelaServices.setFocusable(false);
        TabelaServices.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TabelaServices.setRowHeight(25);
        TabelaServices.setSelectionBackground(new java.awt.Color(192, 192, 192));
        TabelaServices.setShowVerticalLines(false);
        TabelaServices.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(TabelaServices);
        if (TabelaServices.getColumnModel().getColumnCount() > 0) {
            TabelaServices.getColumnModel().getColumn(1).setResizable(false);
            TabelaServices.getColumnModel().getColumn(2).setResizable(false);
        }

        Services.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 11, 833, 227));

        lblServices.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblServices.setText(" search here!");
        Services.add(lblServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 260, 20));

        PesquisarServices.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PesquisarServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarServicesActionPerformed(evt);
            }
        });
        Services.add(PesquisarServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 267, 270, -1));

        btn_DeleteServices.setBackground(new java.awt.Color(23, 35, 51));
        btn_DeleteServices.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_DeleteServices.setForeground(new java.awt.Color(255, 255, 255));
        btn_DeleteServices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_DeleteServices.setText("Delete");
        btn_DeleteServices.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DeleteServices.setOpaque(true);
        btn_DeleteServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeleteServicesMouseClicked(evt);
            }
        });
        Services.add(btn_DeleteServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 267, 146, 30));

        DeleteServices.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        DeleteServices.setToolTipText("");
        DeleteServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteServicesActionPerformed(evt);
            }
        });
        Services.add(DeleteServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 267, 189, -1));

        Paineis.add(Services, "card3");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Paineis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Paineis, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 536, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int xx;
    int xy;
    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed

        xx = evt.getX();
        xy = evt.getY();

    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);

    }//GEN-LAST:event_headerMouseDragged

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        TelaPrincipal principal = new TelaPrincipal();
        principal.lblNomeUsuario.setText(lblNomeDeUsuarioRegistro.getText());

        this.dispose();

        principal.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_graphicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_graphicMouseClicked

        setLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        resetLblColor(btn_schedule);

        Graphic.setVisible(true);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(false);
        Schedule.setVisible(false);

    }//GEN-LAST:event_btn_graphicMouseClicked

    private void btn_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productsMouseClicked

        resetLblColor(btn_graphic);
        setLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        resetLblColor(btn_schedule);

        Graphic.setVisible(false);
        Products.setVisible(true);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(false);
        Schedule.setVisible(false);
        
        this.lblNomeDeUsuarioRegistro.setVisible(true);
        
        pesquisar_products_Sem();

    }//GEN-LAST:event_btn_productsMouseClicked

    private void btn_servicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_servicesMouseClicked

        resetLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        setLblColor(btn_services);
        resetLblColor(btn_schedule);

        Graphic.setVisible(false);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(true);
        Schedule.setVisible(false);
        

    }//GEN-LAST:event_btn_servicesMouseClicked

    private void btn_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_customersMouseClicked

        resetLblColor(btn_graphic);
        resetLblColor(btn_products);
        setLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        resetLblColor(btn_schedule);

        Graphic.setVisible(false);
        Products.setVisible(false);
        Customers.setVisible(true);
        Employees.setVisible(false);
        Services.setVisible(false);
        Schedule.setVisible(false);
        
//        this.pesquisar_Customers_Sem();
        this.lblPesquisarCustomers.setVisible(true);
        
        pesquisar_Customers_Sem();
        

    }//GEN-LAST:event_btn_customersMouseClicked

    private void btn_employeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_employeesMouseClicked

        resetLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        setLblColor(btn_employees);
        resetLblColor(btn_services);
        resetLblColor(btn_schedule);

        Graphic.setVisible(false);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(true);
        Services.setVisible(false);
        Schedule.setVisible(false);
       
        pesquisar_Employees_Sem();
        
    }//GEN-LAST:event_btn_employeesMouseClicked

    private void btn_scheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_scheduleMouseClicked

        resetLblColor(btn_graphic);
        resetLblColor(btn_products);
        resetLblColor(btn_customers);
        resetLblColor(btn_employees);
        resetLblColor(btn_services);
        setLblColor(btn_schedule);

        Graphic.setVisible(false);
        Products.setVisible(false);
        Customers.setVisible(false);
        Employees.setVisible(false);
        Services.setVisible(false);
        Schedule.setVisible(true);

    }//GEN-LAST:event_btn_scheduleMouseClicked

    private void PesquisarCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarCustomersActionPerformed

    }//GEN-LAST:event_PesquisarCustomersActionPerformed

    private void PesquisarProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarProductsActionPerformed

    }//GEN-LAST:event_PesquisarProductsActionPerformed

    private void PesquisarServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarServicesActionPerformed

        this.lblServices.setVisible(false);
    }//GEN-LAST:event_PesquisarServicesActionPerformed

    private void btn_DeleteServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeleteServicesMouseClicked

        TelaDelete delete = new TelaDelete();
        delete.setVisible(true);

    }//GEN-LAST:event_btn_DeleteServicesMouseClicked

    private void DeleteServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteServicesActionPerformed

    }//GEN-LAST:event_DeleteServicesActionPerformed

    private void btn_DeleteProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeleteProductsMouseClicked

        TelaDelete delete = new TelaDelete();
        delete.setVisible(true);

    }//GEN-LAST:event_btn_DeleteProductsMouseClicked

    private void DeleteProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteProductsActionPerformed

    }//GEN-LAST:event_DeleteProductsActionPerformed

    private void btn_DeleteCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeleteCustomersMouseClicked

        TelaDelete delete = new TelaDelete();
        delete.setVisible(true);

    }//GEN-LAST:event_btn_DeleteCustomersMouseClicked

    private void DeleteCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteCustomersActionPerformed

    }//GEN-LAST:event_DeleteCustomersActionPerformed

    private void btn_DeleteScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeleteScheduleMouseClicked

        TelaDelete delete = new TelaDelete();
        delete.setVisible(true);

    }//GEN-LAST:event_btn_DeleteScheduleMouseClicked

    private void DeleteScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteScheduleActionPerformed

    }//GEN-LAST:event_DeleteScheduleActionPerformed

    private void btn_DeleteEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DeleteEmployeesMouseClicked

        TelaDelete delete = new TelaDelete();
        delete.setVisible(true);

    }//GEN-LAST:event_btn_DeleteEmployeesMouseClicked

    private void DeleteEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEmployeesActionPerformed

    }//GEN-LAST:event_DeleteEmployeesActionPerformed

    private void PesquisarProductsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PesquisarProductsKeyReleased
       
        pesquisar_products();
        this.lblPesquisarProducts.setVisible(false);
    }//GEN-LAST:event_PesquisarProductsKeyReleased

    private void TabelaProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaProductsMouseClicked
        setar_camposProducts();
    }//GEN-LAST:event_TabelaProductsMouseClicked

    private void PesquisarCustomersKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PesquisarCustomersKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PesquisarCustomersKeyPressed

    private void PesquisarCustomersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PesquisarCustomersKeyReleased
        // TODO add your handling code here:
//        this.pesquisar_Customers();
        pesquisar_Customers();
        this.lblPesquisarCustomers.setVisible(false);
    }//GEN-LAST:event_PesquisarCustomersKeyReleased

    private void PesquisarEmployeesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PesquisarEmployeesKeyReleased
        // TODO add your handling code here:
        pesquisar_Employees();
        this.lblEmployees.setVisible(false);
    }//GEN-LAST:event_PesquisarEmployeesKeyReleased

    private void btn_productsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_productsMouseEntered

    public void setLblColor(JLabel lbl) {

        lbl.setBackground(new Color(41, 57, 80));
    }

    public void resetLblColor(JLabel lbl) {

        lbl.setBackground(new Color(23, 35, 51));
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Customers;
    public javax.swing.JTextField DeleteCustomers;
    public javax.swing.JTextField DeleteEmployees;
    public javax.swing.JTextField DeleteProducts;
    private javax.swing.JTextField DeleteSchedule;
    private javax.swing.JTextField DeleteServices;
    public javax.swing.JPanel Employees;
    public javax.swing.JPanel Graphic;
    private javax.swing.JPanel Paineis;
    public javax.swing.JTextField PesquisarCustomers;
    public javax.swing.JTextField PesquisarEmployees;
    public javax.swing.JTextField PesquisarProducts;
    public javax.swing.JTextField PesquisarSchedule;
    public javax.swing.JTextField PesquisarServices;
    public javax.swing.JPanel Products;
    public javax.swing.JPanel Schedule;
    public javax.swing.JPanel Services;
    public javax.swing.JTable TabelaCustomers;
    public javax.swing.JTable TabelaEmployees;
    public javax.swing.JTable TabelaProducts;
    public javax.swing.JTable TabelaSchedule;
    public javax.swing.JTable TabelaServices;
    public javax.swing.JLabel btn_DeleteCustomers;
    public javax.swing.JLabel btn_DeleteEmployees;
    public javax.swing.JLabel btn_DeleteProducts;
    public javax.swing.JLabel btn_DeleteSchedule;
    private javax.swing.JLabel btn_DeleteServices;
    private javax.swing.JLabel btn_customers;
    private javax.swing.JLabel btn_employees;
    private javax.swing.JLabel btn_graphic;
    private javax.swing.JLabel btn_products;
    private javax.swing.JLabel btn_schedule;
    private javax.swing.JLabel btn_services;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JLabel lblEmployees;
    public javax.swing.JLabel lblNomeDeUsuarioRegistro;
    public javax.swing.JLabel lblPesquisarCustomers;
    public javax.swing.JLabel lblPesquisarProducts;
    public javax.swing.JLabel lblServices;
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables
}
