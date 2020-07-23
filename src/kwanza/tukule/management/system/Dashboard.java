/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwanza.tukule.management.system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Printer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Mariwa
 */
public class Dashboard extends javax.swing.JFrame {
Connection con = null;
ResultSet rs = null;
ResultSet rs2 = null;
PreparedStatement pst = null;
PreparedStatement pst2 = null;
PreparedStatement pst3 = null;
public String user;
public String role;
public String CustomerId;
public String CustomerName;
public String CustomerNumber;
public String CustomerDeliverer;
public String CustomerLocation;
public String CustomerStatus;
Queries stockQuery;
Queries stockQuery1;
Queries categories;
Queries categories1;
Queries print;
Queries returned;
Queries blackList1;
Queries blackList2;
Queries customers1;
Queries customers2;
Queries valuation;
CustomersPanel customers0;
NullPanel nullpanel;
SummaryPanel summary;
customersPrintPanel customersPrint;
ordersPrintPanel ordersPrint;
public Icon icon = new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/management/system/images/kwanza tukule icon.png"));
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
         nullpanel = new NullPanel();
        switchPanel(nullpanel);
        switchButton2();
        switchBar(sideBar);
        setIcon();
        ImageIcon img = new ImageIcon("/kwanza/tukule/management/system/images/kwanza tukule icon.png");
        this.setIconImage(img.getImage());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        stockQuery = new Queries();
        stockQuery1 = new Queries();
        categories = new Queries();
        categories1 = new Queries();
        blackList1 = new Queries();
        blackList2 = new Queries();
        customers1 = new Queries();
        print = new Queries();
        customers2 = new Queries();
        customers0 = new CustomersPanel();
        nullpanel = new NullPanel();
        summary = new SummaryPanel();
        returned = new Queries();
        valuation = new Queries();
        customersPrint = new customersPrintPanel();
        ordersPrint = new ordersPrintPanel();
    }
public Dashboard(String username) {
        this.setResizable(true);
         this.user=username;
         initComponents();
         switchBar(sideBar);
         switchButton2();
          nullpanel = new NullPanel();
        switchPanel(nullpanel);
        setIcon();
        ImageIcon img = new ImageIcon("/kwanza/tukule/management/system/images/kwanza tukule icon.png");
        this.setIconImage(img.getImage());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        stockQuery = new Queries();
        stockQuery1 = new Queries();
         categories = new Queries();
         categories1 = new Queries();
         returned = new Queries();
         print = new Queries();
         blackList1 = new Queries();
         blackList2 = new Queries();
         customers1 = new Queries();
         customers2 = new Queries();
        customers0 = new CustomersPanel(); 
        nullpanel = new NullPanel();
        summary = new SummaryPanel();
        valuation = new Queries();
        customersPrint = new customersPrintPanel();
        ordersPrint = new ordersPrintPanel();
    }
     public void switchPanel(JPanel panel)
     {
         basePanel.removeAll();
         basePanel.add(panel);
         basePanel.repaint();
         basePanel.revalidate();    
     }
     
     public void switchButton(JButton button)
     {
         buttonsPanel.removeAll();
         buttonsPanel.add(button);
         buttonsPanel.repaint();
         buttonsPanel.revalidate();     
     }
      public void switchButton2()
     {
         buttonsPanel.removeAll();
         buttonsPanel.repaint();
         buttonsPanel.revalidate();     
     }
      public void switchBar(JPanel panel)
     {
         sideBarPanel.removeAll();
         sideBarPanel.add(panel);
         sideBarPanel.repaint();
         sideBarPanel.revalidate();     
     }
       public void sideBar()
     {
         sideBarPanel.removeAll();
         sideBarPanel.add(sideBar);
         sideBarPanel.repaint();
         sideBarPanel.revalidate();     
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        avatarIcon = new javax.swing.JLabel();
        basePanel = new javax.swing.JLayeredPane();
        stockPanel = new javax.swing.JPanel();
        stockPageTitle = new javax.swing.JLabel();
        stockSearchName = new javax.swing.JTextField();
        addStockButton = new javax.swing.JButton();
        stockSaveChangesButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        showAllStockButton = new javax.swing.JButton();
        stockDeleteButton = new javax.swing.JButton();
        stockSearchCategory = new javax.swing.JTextField();
        categoriesButton = new javax.swing.JButton();
        stockValuationButton = new javax.swing.JButton();
        ordersPanel = new javax.swing.JPanel();
        ordersPageTitle = new javax.swing.JLabel();
        ordersSearchName = new javax.swing.JTextField();
        addOrderButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer r, int rw ,int col )
            {
                Component c = super.prepareRenderer(r, rw, col);
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
                int rows=(Integer)ordersTable.getRowCount();
                for(int row = 0; row<rows; row++)
                {
                    DefaultTableModel model = (DefaultTableModel)ordersTable.getModel();
                    double debt = Double.parseDouble(ordersTable.getValueAt(rw, 10).toString());
                    if(debt == 0.0 && col==1 )
                    {
                        c.setBackground(Color.GREEN);
                        c.setForeground(Color.BLACK);
                    }
                    else if(debt > 0.0 && col==1)
                    {
                        c.setBackground(Color.ORANGE);
                        c.setForeground(Color.BLACK);
                    }
                    else if(debt < 0.0 && debt >= -100.0 && col==1)
                    {
                        c.setBackground(Color.LIGHT_GRAY);
                        c.setForeground(Color.BLACK);
                    }
                    else if(debt < -100.0 && col==1)
                    {
                        c.setBackground(Color.RED);
                        c.setForeground(Color.BLACK);
                    }
                }
                return c;
            }
        }
        ;
        ordersSaveButton = new javax.swing.JButton();
        showAllOrdersButton = new javax.swing.JButton();
        ordersDeleteButton = new javax.swing.JButton();
        ordersSearchDeliverer = new javax.swing.JTextField();
        ordersSearchDate = new javax.swing.JTextField();
        ordersFineButton = new javax.swing.JButton();
        returnedGoodsButton = new javax.swing.JButton();
        gatePassButton1 = new javax.swing.JButton();
        delivererGatePass1 = new javax.swing.JTextField();
        timePrint1 = new javax.swing.JTextField();
        delivererDistribution1 = new javax.swing.JTextField();
        productDistributionButton1 = new javax.swing.JButton();
        allOrdersYesterday = new javax.swing.JButton();
        allOrdersTomorrowButton = new javax.swing.JButton();
        addStockPanel = new javax.swing.JPanel();
        addStockPageTitle = new javax.swing.JLabel();
        addStockNameLabel = new javax.swing.JLabel();
        addStockQuantityLabel = new javax.swing.JLabel();
        addStockPriceLabel = new javax.swing.JLabel();
        addStockPriceTextField = new javax.swing.JTextField();
        addStockNameTextField = new javax.swing.JTextField();
        addStockQuantityTextField = new javax.swing.JTextField();
        addStockSaveButton = new javax.swing.JButton();
        addStockCategoryIdLabel = new javax.swing.JLabel();
        addStockCategoryIdTextField = new javax.swing.JTextField();
        addStockBuyingPriceLabel = new javax.swing.JLabel();
        addStockBuyingPriceTextField = new javax.swing.JTextField();
        ordersPanel1 = new javax.swing.JPanel();
        ordersSearchName1 = new javax.swing.JTextField();
        addOrderButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ordersTable1 = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer r, int rw ,int col )
            {
                Component c = super.prepareRenderer(r, rw, col);
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
                int rows=(Integer)ordersTable.getRowCount();
                for(int row = 0; row<rows; row++)
                {
                    DefaultTableModel model = (DefaultTableModel)ordersTable.getModel();
                    double debt = Double.parseDouble(ordersTable.getValueAt(rw, 10).toString());
                    if(debt == 0.0 && col==1 )
                    {
                        c.setBackground(Color.GREEN);
                        c.setForeground(Color.BLACK);
                    }
                    else if(debt > 0.0 && col==1)
                    {
                        c.setBackground(Color.ORANGE);
                        c.setForeground(Color.BLACK);
                    }
                    else if(debt < 0.0 && debt >= -100.0 && col==1)
                    {
                        c.setBackground(Color.LIGHT_GRAY);
                        c.setForeground(Color.BLACK);
                    }
                    else if(debt < -100.0 && col==1)
                    {
                        c.setBackground(Color.RED);
                        c.setForeground(Color.BLACK);
                    }
                }
                return c;
            }
        }
        ;
        ordersPageTitle1 = new javax.swing.JLabel();
        showAllOrdersButton1 = new javax.swing.JButton();
        ordersSearchDeliverer1 = new javax.swing.JTextField();
        ordersSearchDate1 = new javax.swing.JTextField();
        allOrdersYesterdayButton1 = new javax.swing.JButton();
        allOrdersTomorrowButton1 = new javax.swing.JButton();
        addOrderPanel = new javax.swing.JPanel();
        addOrderPageTitle = new javax.swing.JLabel();
        newOrderSearchName = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        newOrderTable = new javax.swing.JTable();
        orderDetailsTitle = new javax.swing.JLabel();
        newOrderSearchStock = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        newOrderDetailsTable = new javax.swing.JTable();
        addToCartButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        newOrderCartTable = new javax.swing.JTable();
        completeOrderButton = new javax.swing.JButton();
        deleteCartItemButton = new javax.swing.JButton();
        orderTotalLabel = new javax.swing.JLabel();
        totalReadText = new javax.swing.JTextField();
        additionRadioButton = new javax.swing.JRadioButton();
        specifyOrderDate = new javax.swing.JTextField();
        customerDetailsTitle = new javax.swing.JLabel();
        stockPanel1 = new javax.swing.JPanel();
        stockPageTitle1 = new javax.swing.JLabel();
        stockSearchName1 = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        stockTable1 = new javax.swing.JTable();
        showAllStockButton1 = new javax.swing.JButton();
        stockSearchCategory1 = new javax.swing.JTextField();
        categoriesButton1 = new javax.swing.JButton();
        categoriesPanel = new javax.swing.JPanel();
        categoryDeleteButton = new javax.swing.JButton();
        categoriesAddTextField = new javax.swing.JTextField();
        categoriesPageTitle = new javax.swing.JLabel();
        categorySaveChangesButton = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        categoriesTable = new javax.swing.JTable();
        categoriesPanel1 = new javax.swing.JPanel();
        categoriesPageTitle1 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        categoriesTable1 = new javax.swing.JTable();
        returnedGoodsPanel = new javax.swing.JPanel();
        returnedGoodsPageTitle = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        returnedGoodsTable = new javax.swing.JTable();
        returnedGoodsInstruction = new javax.swing.JLabel();
        ordersPanel3 = new javax.swing.JPanel();
        ordersPageTitle3 = new javax.swing.JLabel();
        ordersSearchName3 = new javax.swing.JTextField();
        addOrderButton3 = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        ordersTable3 = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer r, int rw ,int col )
            {
                Component c = super.prepareRenderer(r, rw, col);
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
                int rows=(Integer)ordersTable3.getRowCount();
                for(int row = 0; row<rows; row++)
                {
                    DefaultTableModel model = (DefaultTableModel)ordersTable3.getModel();
                    double debt = Double.parseDouble(ordersTable3.getValueAt(rw, 10).toString());
                    if(debt == 0.0 && col==1 )
                    {
                        c.setBackground(Color.GREEN);
                        c.setForeground(Color.BLACK);
                    }
                    else if(debt > 0.0 && col==1)
                    {
                        c.setBackground(Color.ORANGE);
                        c.setForeground(Color.BLACK);
                    }
                    else if(debt < 0.0 && debt >= -100.0 && col==1)
                    {
                        c.setBackground(Color.LIGHT_GRAY);
                        c.setForeground(Color.BLACK);
                    }
                    else if(debt < -100.0 && col==1)
                    {
                        c.setBackground(Color.RED);
                        c.setForeground(Color.BLACK);
                    }
                }
                return c;
            }
        }
        ;
        ordersSaveButton1 = new javax.swing.JButton();
        showAllOrdersButton3 = new javax.swing.JButton();
        ordersSearchDeliverer3 = new javax.swing.JTextField();
        ordersSearchDate3 = new javax.swing.JTextField();
        ordersFineButton1 = new javax.swing.JButton();
        returnedGoodsButton1 = new javax.swing.JButton();
        gatePassButton = new javax.swing.JButton();
        delivererGatePass = new javax.swing.JTextField();
        timePrint = new javax.swing.JTextField();
        productDistributionButton = new javax.swing.JButton();
        delivererDistribution = new javax.swing.JTextField();
        allOrdersYesterdayButton3 = new javax.swing.JButton();
        allOrdersTomorrowButton3 = new javax.swing.JButton();
        addCustomerPanel = new javax.swing.JPanel();
        addCustomerPageTitle = new javax.swing.JLabel();
        addCustomerNameLabel = new javax.swing.JLabel();
        addCustomerNumberLabel = new javax.swing.JLabel();
        addCustomerDelivererLabel = new javax.swing.JLabel();
        addCustomerLocationLabel = new javax.swing.JLabel();
        addCustomerNameTextField = new javax.swing.JTextField();
        addCustomerNumberTextField = new javax.swing.JTextField();
        addCustomerLocationTextField = new javax.swing.JTextField();
        addCustomerDelivererTextField = new javax.swing.JTextField();
        addCustomerSaveButton = new javax.swing.JButton();
        addCustomerDelivererLabel1 = new javax.swing.JLabel();
        addCustomerNoteTextField = new javax.swing.JTextField();
        customersPanel1 = new javax.swing.JPanel();
        addCustomerButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        customersPageTitle1 = new javax.swing.JLabel();
        customerSearchDeliverer1 = new javax.swing.JTextField();
        customerSearchName1 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        customersTable1 = new javax.swing.JTable();
        customersSaveChangesButton1 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        blackListedTable1 = new javax.swing.JTable();
        showAllCustomersButton1 = new javax.swing.JButton();
        customerSearchContact1 = new javax.swing.JTextField();
        customersPanel2 = new javax.swing.JPanel();
        customersPageTitle2 = new javax.swing.JLabel();
        customerSearchDeliverer2 = new javax.swing.JTextField();
        customerSearchName2 = new javax.swing.JTextField();
        addCustomerButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        customersSaveChangesButton2 = new javax.swing.JButton();
        blacklistedSaveChangsButton1 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        customersTable2 = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        blackListedTable2 = new javax.swing.JTable();
        showAllCustomersButton2 = new javax.swing.JButton();
        customerBlacklist1 = new javax.swing.JButton();
        blacklistedRestore1 = new javax.swing.JButton();
        customerSearchContact2 = new javax.swing.JTextField();
        gatePass = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ordersTable4 = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer r, int rw ,int col )
            {
                Component c = super.prepareRenderer(r, rw, col);
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
                return c;
            }
        }
        ;
        ordersPageTitle4 = new javax.swing.JLabel();
        goodsDistribution = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ordersTable5 = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer r, int rw ,int col )
            {
                Component c = super.prepareRenderer(r, rw, col);
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
                return c;
            }
        }
        ;
        ordersPageTitle5 = new javax.swing.JLabel();
        stockPanel2 = new javax.swing.JPanel();
        stockValuationTitle = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        stockTable2 = new javax.swing.JTable();
        valuationDateTextfield = new javax.swing.JTextField();
        valuationInstruction = new javax.swing.JLabel();
        valuationTodayButton = new javax.swing.JButton();
        buttonsPanel = new javax.swing.JLayeredPane();
        ordersPrintButton = new javax.swing.JButton();
        customersPrintButton = new javax.swing.JButton();
        addOrderBackButton = new javax.swing.JButton();
        addStockBackButton = new javax.swing.JButton();
        addCustomerBackButton = new javax.swing.JButton();
        categoriesBackButton = new javax.swing.JButton();
        categoriesBackButton1 = new javax.swing.JButton();
        returnedGoodsBackButton = new javax.swing.JButton();
        stockValuationBackButton = new javax.swing.JButton();
        sideBarPanel = new javax.swing.JLayeredPane();
        sideBar = new javax.swing.JPanel();
        customerSideBar = new javax.swing.JLabel();
        stockSideBar = new javax.swing.JLabel();
        orderSideBar = new javax.swing.JLabel();
        summarySideBar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kwanza Tukule | Dashboard");

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/management/system/images/kwanza tukule logo.png"))); // NOI18N
        backgroundPanel.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, -1));

        logoutButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        logoutButton.setText("LOGOUT");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        backgroundPanel.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1096, 19, -1, -1));

        usernameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        usernameLabel.setText(user);
        backgroundPanel.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 21, 130, 20));

        avatarIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/management/system/images/avatar.png"))); // NOI18N
        backgroundPanel.add(avatarIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, 40));

        basePanel.setLayout(new java.awt.CardLayout());

        stockPageTitle.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        stockPageTitle.setText("Stock");

        stockSearchName.setBackground(new java.awt.Color(232, 228, 228));
        stockSearchName.setForeground(new java.awt.Color(102, 102, 102));
        stockSearchName.setText("Search by name...");
        stockSearchName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stockSearchNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockSearchNameFocusLost(evt);
            }
        });
        stockSearchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockSearchNameActionPerformed(evt);
            }
        });

        addStockButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addStockButton.setText("+ New Stock");
        addStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockButtonActionPerformed(evt);
            }
        });

        stockSaveChangesButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        stockSaveChangesButton.setText("Save");
        stockSaveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockSaveChangesButtonActionPerformed(evt);
            }
        });

        stockTable.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
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
                "#", "Category", "Brand Name", "Price/Unit", "Quantity Available ", "Buying Price(Last Purchase)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockTable.setRowHeight(20);
        jScrollPane5.setViewportView(stockTable);
        if (stockTable.getColumnModel().getColumnCount() > 0) {
            stockTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            stockTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            stockTable.getColumnModel().getColumn(1).setHeaderValue("Category");
            stockTable.getColumnModel().getColumn(2).setPreferredWidth(250);
            stockTable.getColumnModel().getColumn(3).setPreferredWidth(90);
            stockTable.getColumnModel().getColumn(3).setHeaderValue("Price/Unit");
            stockTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            stockTable.getColumnModel().getColumn(5).setPreferredWidth(170);
        }

        showAllStockButton.setText("All Stock");
        showAllStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllStockButtonActionPerformed(evt);
            }
        });

        stockDeleteButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        stockDeleteButton.setText("Delete");
        stockDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockDeleteButtonActionPerformed(evt);
            }
        });

        stockSearchCategory.setBackground(new java.awt.Color(232, 228, 228));
        stockSearchCategory.setForeground(new java.awt.Color(102, 102, 102));
        stockSearchCategory.setText("Search by category...");
        stockSearchCategory.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stockSearchCategoryFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockSearchCategoryFocusLost(evt);
            }
        });
        stockSearchCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockSearchCategoryActionPerformed(evt);
            }
        });

        categoriesButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        categoriesButton.setText("Categories");
        categoriesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriesButtonActionPerformed(evt);
            }
        });

        stockValuationButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        stockValuationButton.setText("Stock Valuation");
        stockValuationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockValuationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stockPanelLayout = new javax.swing.GroupLayout(stockPanel);
        stockPanel.setLayout(stockPanelLayout);
        stockPanelLayout.setHorizontalGroup(
            stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockPanelLayout.createSequentialGroup()
                .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(stockPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stockSaveChangesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stockDeleteButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, stockPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stockPanelLayout.createSequentialGroup()
                                .addComponent(stockPageTitle)
                                .addGap(26, 26, 26)
                                .addComponent(stockSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(stockSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addStockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoriesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(stockPanelLayout.createSequentialGroup()
                                .addComponent(showAllStockButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stockValuationButton)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        stockPanelLayout.setVerticalGroup(
            stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(stockPageTitle)
                        .addComponent(stockSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stockSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addStockButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(categoriesButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showAllStockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockValuationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockSaveChangesButton)
                    .addComponent(stockDeleteButton))
                .addGap(139, 139, 139))
        );

        basePanel.add(stockPanel, "card4");

        ordersPageTitle.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        ordersPageTitle.setText("Orders");

        ordersSearchName.setBackground(new java.awt.Color(232, 228, 228));
        ordersSearchName.setForeground(new java.awt.Color(102, 102, 102));
        ordersSearchName.setText("Search by name...");
        ordersSearchName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ordersSearchNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ordersSearchNameFocusLost(evt);
            }
        });
        ordersSearchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersSearchNameActionPerformed(evt);
            }
        });

        addOrderButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addOrderButton.setText("Add Order");
        addOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderButtonActionPerformed(evt);
            }
        });

        ordersTable.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Name", "Mobile No.", "Item", "Quantity", "Cost", "C/F/Debt", "M-Pesa", "Cash", "Fine", "Balance", "Delivery Day", "Returned", "Banked", "Slip No.", "Banked by"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, true, true, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ordersTable.setRowHeight(17);
        jScrollPane1.setViewportView(ordersTable);
        if (ordersTable.getColumnModel().getColumnCount() > 0) {
            ordersTable.getColumnModel().getColumn(0).setHeaderValue("#");
            ordersTable.getColumnModel().getColumn(1).setPreferredWidth(170);
            ordersTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            ordersTable.getColumnModel().getColumn(3).setPreferredWidth(230);
            ordersTable.getColumnModel().getColumn(4).setPreferredWidth(30);
            ordersTable.getColumnModel().getColumn(6).setHeaderValue("C/F/Debt");
            ordersTable.getColumnModel().getColumn(9).setHeaderValue("Fine");
            ordersTable.getColumnModel().getColumn(11).setPreferredWidth(100);
            ordersTable.getColumnModel().getColumn(11).setHeaderValue("Delivery Day");
            ordersTable.getColumnModel().getColumn(12).setHeaderValue("Returned");
            ordersTable.getColumnModel().getColumn(13).setHeaderValue("Banked");
            ordersTable.getColumnModel().getColumn(14).setHeaderValue("Slip No.");
            ordersTable.getColumnModel().getColumn(15).setHeaderValue("Banked by");
        }

        ordersSaveButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        ordersSaveButton.setText("Save");
        ordersSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersSaveButtonActionPerformed(evt);
            }
        });

        showAllOrdersButton.setText("All Orders Today ");
        showAllOrdersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllOrdersButtonActionPerformed(evt);
            }
        });

        ordersDeleteButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        ordersDeleteButton.setText("Delete");
        ordersDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersDeleteButtonActionPerformed(evt);
            }
        });

        ordersSearchDeliverer.setBackground(new java.awt.Color(232, 228, 228));
        ordersSearchDeliverer.setForeground(new java.awt.Color(102, 102, 102));
        ordersSearchDeliverer.setText("Search by deliverer...");
        ordersSearchDeliverer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ordersSearchDelivererFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ordersSearchDelivererFocusLost(evt);
            }
        });
        ordersSearchDeliverer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersSearchDelivererActionPerformed(evt);
            }
        });

        ordersSearchDate.setBackground(new java.awt.Color(232, 228, 228));
        ordersSearchDate.setForeground(new java.awt.Color(102, 102, 102));
        ordersSearchDate.setText("Search by date...(YYYY-MM-DD)");
        ordersSearchDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ordersSearchDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ordersSearchDateFocusLost(evt);
            }
        });
        ordersSearchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersSearchDateActionPerformed(evt);
            }
        });

        ordersFineButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        ordersFineButton.setText("Fine");
        ordersFineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersFineButtonActionPerformed(evt);
            }
        });

        returnedGoodsButton.setText("Returned Goods");
        returnedGoodsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnedGoodsButtonActionPerformed(evt);
            }
        });

        gatePassButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/management/system/images/printer.png"))); // NOI18N
        gatePassButton1.setText("Print Gate Pass");
        gatePassButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gatePassButton1ActionPerformed(evt);
            }
        });

        delivererGatePass1.setBackground(new java.awt.Color(232, 228, 228));
        delivererGatePass1.setForeground(new java.awt.Color(102, 102, 102));
        delivererGatePass1.setText("Deliverer(Gate Pass)...");
        delivererGatePass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                delivererGatePass1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                delivererGatePass1FocusLost(evt);
            }
        });
        delivererGatePass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delivererGatePass1ActionPerformed(evt);
            }
        });

        timePrint1.setBackground(new java.awt.Color(232, 228, 228));
        timePrint1.setForeground(new java.awt.Color(102, 102, 102));
        timePrint1.setText("Point in Time...");
        timePrint1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                timePrint1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                timePrint1FocusLost(evt);
            }
        });
        timePrint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timePrint1ActionPerformed(evt);
            }
        });

        delivererDistribution1.setBackground(new java.awt.Color(232, 228, 228));
        delivererDistribution1.setForeground(new java.awt.Color(102, 102, 102));
        delivererDistribution1.setText("Deliverer(Distribution)...");
        delivererDistribution1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                delivererDistribution1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                delivererDistribution1FocusLost(evt);
            }
        });
        delivererDistribution1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delivererDistribution1ActionPerformed(evt);
            }
        });

        productDistributionButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/management/system/images/printer.png"))); // NOI18N
        productDistributionButton1.setText("Print Product Distribution");
        productDistributionButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productDistributionButton1ActionPerformed(evt);
            }
        });

        allOrdersYesterday.setText("All Orders Yesterday");
        allOrdersYesterday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allOrdersYesterdayActionPerformed(evt);
            }
        });

        allOrdersTomorrowButton.setText("All Orders Tomorrow");
        allOrdersTomorrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allOrdersTomorrowButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ordersPanelLayout = new javax.swing.GroupLayout(ordersPanel);
        ordersPanel.setLayout(ordersPanelLayout);
        ordersPanelLayout.setHorizontalGroup(
            ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(ordersPageTitle)
                .addGap(29, 29, 29)
                .addComponent(ordersSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ordersSearchDeliverer, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ordersSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(addOrderButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(allOrdersYesterday, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showAllOrdersButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allOrdersTomorrowButton)
                .addGap(223, 223, 223)
                .addComponent(ordersFineButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ordersSaveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ordersDeleteButton)
                .addGap(168, 168, 168))
            .addGroup(ordersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ordersPanelLayout.createSequentialGroup()
                        .addComponent(productDistributionButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delivererDistribution1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(timePrint1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delivererGatePass1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gatePassButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnedGoodsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ordersPanelLayout.setVerticalGroup(
            ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ordersPageTitle)
                        .addComponent(ordersSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ordersSearchDeliverer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ordersSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnedGoodsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delivererDistribution1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(timePrint1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(productDistributionButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(delivererGatePass1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(gatePassButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ordersSaveButton)
                    .addComponent(ordersFineButton)
                    .addComponent(allOrdersTomorrowButton)
                    .addComponent(showAllOrdersButton)
                    .addComponent(allOrdersYesterday)
                    .addComponent(ordersDeleteButton))
                .addGap(102, 102, 102))
        );

        basePanel.add(ordersPanel, "card5");

        addStockPageTitle.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        addStockPageTitle.setText("Add Stock");

        addStockNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addStockNameLabel.setText("Stock Name:");

        addStockQuantityLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addStockQuantityLabel.setText("Quantity:");

        addStockPriceLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addStockPriceLabel.setText("Price:");

        addStockPriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockPriceTextFieldActionPerformed(evt);
            }
        });

        addStockNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockNameTextFieldActionPerformed(evt);
            }
        });

        addStockQuantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockQuantityTextFieldActionPerformed(evt);
            }
        });

        addStockSaveButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addStockSaveButton.setText("Add");
        addStockSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockSaveButtonActionPerformed(evt);
            }
        });

        addStockCategoryIdLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addStockCategoryIdLabel.setText("Category ID:");

        addStockCategoryIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockCategoryIdTextFieldActionPerformed(evt);
            }
        });

        addStockBuyingPriceLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addStockBuyingPriceLabel.setText("Buying Price:");

        addStockBuyingPriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockBuyingPriceTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addStockPanelLayout = new javax.swing.GroupLayout(addStockPanel);
        addStockPanel.setLayout(addStockPanelLayout);
        addStockPanelLayout.setHorizontalGroup(
            addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStockPanelLayout.createSequentialGroup()
                .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addStockPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(addStockPageTitle))
                    .addGroup(addStockPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(addStockNameLabel)
                                .addComponent(addStockCategoryIdLabel)
                                .addComponent(addStockBuyingPriceLabel)
                                .addComponent(addStockPriceLabel))
                            .addGroup(addStockPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(addStockQuantityLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addStockCategoryIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addStockNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addStockBuyingPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addStockPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addStockQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addStockPanelLayout.createSequentialGroup()
                        .addGap(483, 483, 483)
                        .addComponent(addStockSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        addStockPanelLayout.setVerticalGroup(
            addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStockPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(addStockPageTitle)
                .addGap(26, 26, 26)
                .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStockCategoryIdLabel)
                    .addComponent(addStockCategoryIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStockNameLabel)
                    .addComponent(addStockNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStockBuyingPriceLabel)
                    .addComponent(addStockBuyingPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addStockPriceLabel)
                    .addComponent(addStockPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(addStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStockQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStockQuantityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(addStockSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        basePanel.add(addStockPanel, "card8");

        ordersSearchName1.setBackground(new java.awt.Color(232, 228, 228));
        ordersSearchName1.setForeground(new java.awt.Color(102, 102, 102));
        ordersSearchName1.setText("Search by name...");
        ordersSearchName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ordersSearchName1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ordersSearchName1FocusLost(evt);
            }
        });
        ordersSearchName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersSearchName1ActionPerformed(evt);
            }
        });

        addOrderButton1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addOrderButton1.setText("Add Order");
        addOrderButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderButton1ActionPerformed(evt);
            }
        });

        ordersTable1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ordersTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Name", "Mobile No.", "Item", "Quantity", "Cost", "C/F/Debt", "Delivery Day", "Returned"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ordersTable1.setRowHeight(20);
        jScrollPane2.setViewportView(ordersTable1);
        if (ordersTable1.getColumnModel().getColumnCount() > 0) {
            ordersTable1.getColumnModel().getColumn(0).setHeaderValue("#");
            ordersTable1.getColumnModel().getColumn(1).setHeaderValue("Name");
            ordersTable1.getColumnModel().getColumn(2).setHeaderValue("Mobile No.");
            ordersTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
            ordersTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            ordersTable1.getColumnModel().getColumn(5).setHeaderValue("Cost");
            ordersTable1.getColumnModel().getColumn(6).setHeaderValue("C/F/Debt");
            ordersTable1.getColumnModel().getColumn(7).setHeaderValue("Delivery Day");
            ordersTable1.getColumnModel().getColumn(8).setHeaderValue("Returned");
        }

        ordersPageTitle1.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        ordersPageTitle1.setText("Orders");

        showAllOrdersButton1.setText("All Orders Today");
        showAllOrdersButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllOrdersButton1ActionPerformed(evt);
            }
        });

        ordersSearchDeliverer1.setBackground(new java.awt.Color(232, 228, 228));
        ordersSearchDeliverer1.setForeground(new java.awt.Color(102, 102, 102));
        ordersSearchDeliverer1.setText("Search by deliverer...");
        ordersSearchDeliverer1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ordersSearchDeliverer1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ordersSearchDeliverer1FocusLost(evt);
            }
        });
        ordersSearchDeliverer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersSearchDeliverer1ActionPerformed(evt);
            }
        });

        ordersSearchDate1.setBackground(new java.awt.Color(232, 228, 228));
        ordersSearchDate1.setForeground(new java.awt.Color(102, 102, 102));
        ordersSearchDate1.setText("Search by date...(YYYY-MM-DD)");
        ordersSearchDate1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ordersSearchDate1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ordersSearchDate1FocusLost(evt);
            }
        });
        ordersSearchDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersSearchDate1ActionPerformed(evt);
            }
        });

        allOrdersYesterdayButton1.setText("All Orders Yesterday");
        allOrdersYesterdayButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allOrdersYesterdayButton11ActionPerformed(evt);
            }
        });

        allOrdersTomorrowButton1.setText("All Orders Tomorrow");
        allOrdersTomorrowButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allOrdersTomorrowButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ordersPanel1Layout = new javax.swing.GroupLayout(ordersPanel1);
        ordersPanel1.setLayout(ordersPanel1Layout);
        ordersPanel1Layout.setHorizontalGroup(
            ordersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersPanel1Layout.createSequentialGroup()
                .addGroup(ordersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(ordersPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ordersPanel1Layout.createSequentialGroup()
                        .addGroup(ordersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ordersPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(ordersPageTitle1)
                                .addGap(18, 18, 18)
                                .addComponent(ordersSearchName1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(ordersPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(allOrdersYesterdayButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(showAllOrdersButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(ordersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ordersPanel1Layout.createSequentialGroup()
                                .addComponent(allOrdersTomorrowButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(297, 297, 297)
                                .addComponent(addOrderButton1))
                            .addGroup(ordersPanel1Layout.createSequentialGroup()
                                .addComponent(ordersSearchDeliverer1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ordersSearchDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        ordersPanel1Layout.setVerticalGroup(
            ordersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(ordersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showAllOrdersButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ordersPanel1Layout.createSequentialGroup()
                        .addGroup(ordersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ordersSearchDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ordersSearchDeliverer1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ordersSearchName1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ordersPageTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ordersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ordersPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addOrderButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ordersPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(allOrdersYesterdayButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(ordersPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(allOrdersTomorrowButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addGap(126, 126, 126))
        );

        basePanel.add(ordersPanel1, "card10");

        addOrderPageTitle.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        addOrderPageTitle.setText("New Order");

        newOrderSearchName.setBackground(new java.awt.Color(232, 228, 228));
        newOrderSearchName.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        newOrderSearchName.setForeground(new java.awt.Color(102, 102, 102));
        newOrderSearchName.setText("Search Customer by name...");
        newOrderSearchName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newOrderSearchNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                newOrderSearchNameFocusLost(evt);
            }
        });
        newOrderSearchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderSearchNameActionPerformed(evt);
            }
        });

        newOrderTable.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        newOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Name", "Mobile No.", "Location", "Deliverer", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        newOrderTable.setRowHeight(20);
        jScrollPane8.setViewportView(newOrderTable);

        orderDetailsTitle.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        orderDetailsTitle.setText("Order Details");

        newOrderSearchStock.setBackground(new java.awt.Color(232, 228, 228));
        newOrderSearchStock.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        newOrderSearchStock.setForeground(new java.awt.Color(102, 102, 102));
        newOrderSearchStock.setText("Search Stock by Category...");
        newOrderSearchStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newOrderSearchStockFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                newOrderSearchStockFocusLost(evt);
            }
        });
        newOrderSearchStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderSearchStockActionPerformed(evt);
            }
        });

        newOrderDetailsTable.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        newOrderDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "#", "Item Name", "Unit Price", "Quantity Available", "Order Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        newOrderDetailsTable.setRowHeight(20);
        jScrollPane9.setViewportView(newOrderDetailsTable);

        addToCartButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        addToCartButton.setText("Add Item to Cart");
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 22)); // NOI18N
        jLabel5.setText("Cart");

        newOrderCartTable.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        newOrderCartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Item Name", "Unit Price", "Order Quantity", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        newOrderCartTable.setRowHeight(20);
        jScrollPane10.setViewportView(newOrderCartTable);

        completeOrderButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        completeOrderButton.setText("Complete Order");
        completeOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeOrderButtonActionPerformed(evt);
            }
        });

        deleteCartItemButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        deleteCartItemButton.setText("Delete from Cart");
        deleteCartItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCartItemButtonActionPerformed(evt);
            }
        });

        orderTotalLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        orderTotalLabel.setText("Total:");

        totalReadText.setEditable(false);

        additionRadioButton.setText("This order is an addition to today's orders.");
        additionRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                additionRadioButtonActionPerformed(evt);
            }
        });

        specifyOrderDate.setBackground(new java.awt.Color(232, 228, 228));
        specifyOrderDate.setForeground(new java.awt.Color(102, 102, 102));
        specifyOrderDate.setText("Otherwise specify the order date(YYYY-MM-DD)...");
        specifyOrderDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                specifyOrderDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                specifyOrderDateFocusLost(evt);
            }
        });
        specifyOrderDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specifyOrderDateActionPerformed(evt);
            }
        });

        customerDetailsTitle.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        customerDetailsTitle.setText("Customer Details");

        javax.swing.GroupLayout addOrderPanelLayout = new javax.swing.GroupLayout(addOrderPanel);
        addOrderPanel.setLayout(addOrderPanelLayout);
        addOrderPanelLayout.setHorizontalGroup(
            addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOrderPanelLayout.createSequentialGroup()
                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addOrderPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(addOrderPanelLayout.createSequentialGroup()
                                    .addComponent(additionRadioButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(specifyOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(195, 195, 195))
                                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addOrderPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(addToCartButton)
                                            .addGap(11, 11, 11))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addOrderPageTitle)
                                            .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(addOrderPanelLayout.createSequentialGroup()
                                                    .addComponent(orderDetailsTitle)
                                                    .addGap(138, 138, 138)
                                                    .addComponent(newOrderSearchStock, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(addOrderPanelLayout.createSequentialGroup()
                                                    .addComponent(customerDetailsTitle)
                                                    .addGap(95, 95, 95)
                                                    .addComponent(newOrderSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jScrollPane8)
                                                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE))))))
                            .addGroup(addOrderPanelLayout.createSequentialGroup()
                                .addComponent(orderTotalLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalReadText, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteCartItemButton)
                                .addGap(12, 12, 12))))
                    .addGroup(addOrderPanelLayout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addComponent(completeOrderButton)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        addOrderPanelLayout.setVerticalGroup(
            addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOrderPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addOrderPageTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(customerDetailsTitle)
                    .addComponent(newOrderSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderDetailsTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newOrderSearchStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addOrderPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addOrderPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalReadText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteCartItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(specifyOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(additionRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(completeOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(862, 862, 862))
        );

        basePanel.add(addOrderPanel, "card11");

        stockPageTitle1.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        stockPageTitle1.setText("Stock");

        stockSearchName1.setBackground(new java.awt.Color(232, 228, 228));
        stockSearchName1.setForeground(new java.awt.Color(102, 102, 102));
        stockSearchName1.setText("Search by name...");
        stockSearchName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stockSearchName1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockSearchName1FocusLost(evt);
            }
        });
        stockSearchName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockSearchName1ActionPerformed(evt);
            }
        });

        stockTable1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        stockTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "#", "Category", "Brand Name", "Price/Unit", "Quantity Available"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockTable1.setRowHeight(20);
        jScrollPane11.setViewportView(stockTable1);

        showAllStockButton1.setText("All Stock");
        showAllStockButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllStockButton1ActionPerformed(evt);
            }
        });

        stockSearchCategory1.setBackground(new java.awt.Color(232, 228, 228));
        stockSearchCategory1.setForeground(new java.awt.Color(102, 102, 102));
        stockSearchCategory1.setText("Search by category...");
        stockSearchCategory1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stockSearchCategory1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockSearchCategory1FocusLost(evt);
            }
        });
        stockSearchCategory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockSearchCategory1ActionPerformed(evt);
            }
        });

        categoriesButton1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        categoriesButton1.setText("Categories");
        categoriesButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriesButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stockPanel1Layout = new javax.swing.GroupLayout(stockPanel1);
        stockPanel1.setLayout(stockPanel1Layout);
        stockPanel1Layout.setHorizontalGroup(
            stockPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(stockPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showAllStockButton1)
                    .addGroup(stockPanel1Layout.createSequentialGroup()
                        .addComponent(stockPageTitle1)
                        .addGap(26, 26, 26)
                        .addComponent(stockSearchName1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stockSearchCategory1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoriesButton1))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        stockPanel1Layout.setVerticalGroup(
            stockPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(stockPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockPageTitle1)
                    .addComponent(stockSearchName1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockSearchCategory1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoriesButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showAllStockButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        basePanel.add(stockPanel1, "card12");

        categoryDeleteButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        categoryDeleteButton.setText("Delete");
        categoryDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryDeleteButtonActionPerformed(evt);
            }
        });

        categoriesAddTextField.setBackground(new java.awt.Color(232, 228, 228));
        categoriesAddTextField.setForeground(new java.awt.Color(102, 102, 102));
        categoriesAddTextField.setText("Add New Category...");
        categoriesAddTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                categoriesAddTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                categoriesAddTextFieldFocusLost(evt);
            }
        });
        categoriesAddTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriesAddTextFieldActionPerformed(evt);
            }
        });

        categoriesPageTitle.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        categoriesPageTitle.setText("Categories");

        categorySaveChangesButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        categorySaveChangesButton.setText("Save");
        categorySaveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySaveChangesButtonActionPerformed(evt);
            }
        });

        categoriesTable.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        categoriesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "#", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categoriesTable.setRowHeight(20);
        jScrollPane14.setViewportView(categoriesTable);

        javax.swing.GroupLayout categoriesPanelLayout = new javax.swing.GroupLayout(categoriesPanel);
        categoriesPanel.setLayout(categoriesPanelLayout);
        categoriesPanelLayout.setHorizontalGroup(
            categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriesPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(categoriesPanelLayout.createSequentialGroup()
                        .addGap(811, 811, 811)
                        .addComponent(categorySaveChangesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryDeleteButton))
                    .addGroup(categoriesPanelLayout.createSequentialGroup()
                        .addComponent(categoriesPageTitle)
                        .addGap(230, 230, 230)
                        .addComponent(categoriesAddTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        categoriesPanelLayout.setVerticalGroup(
            categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriesPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoriesPageTitle)
                    .addComponent(categoriesAddTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categorySaveChangesButton)
                    .addComponent(categoryDeleteButton))
                .addContainerGap(840, Short.MAX_VALUE))
        );

        basePanel.add(categoriesPanel, "card4");

        categoriesPageTitle1.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        categoriesPageTitle1.setText("Categories");

        categoriesTable1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        categoriesTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "#", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categoriesTable1.setRowHeight(20);
        jScrollPane15.setViewportView(categoriesTable1);

        javax.swing.GroupLayout categoriesPanel1Layout = new javax.swing.GroupLayout(categoriesPanel1);
        categoriesPanel1.setLayout(categoriesPanel1Layout);
        categoriesPanel1Layout.setHorizontalGroup(
            categoriesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriesPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(categoriesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoriesPageTitle1)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 1013, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        categoriesPanel1Layout.setVerticalGroup(
            categoriesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriesPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(categoriesPageTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        basePanel.add(categoriesPanel1, "card4");

        returnedGoodsPageTitle.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        returnedGoodsPageTitle.setText("Returned Goods");

        returnedGoodsTable.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        returnedGoodsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#(Order)", "Customer Name", "Customer Number", "Deliverer", "Category", "Stock Name", "Quantity Taken", "Quantity Returned"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        returnedGoodsTable.setRowHeight(20);
        jScrollPane16.setViewportView(returnedGoodsTable);

        returnedGoodsInstruction.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        returnedGoodsInstruction.setText("The following are the recently returned goods. (From orders made today and yesterday)");

        javax.swing.GroupLayout returnedGoodsPanelLayout = new javax.swing.GroupLayout(returnedGoodsPanel);
        returnedGoodsPanel.setLayout(returnedGoodsPanelLayout);
        returnedGoodsPanelLayout.setHorizontalGroup(
            returnedGoodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnedGoodsPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(returnedGoodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnedGoodsInstruction)
                    .addComponent(returnedGoodsPageTitle)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        returnedGoodsPanelLayout.setVerticalGroup(
            returnedGoodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnedGoodsPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(returnedGoodsPageTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(returnedGoodsInstruction)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        basePanel.add(returnedGoodsPanel, "card4");

        ordersPageTitle3.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        ordersPageTitle3.setText("Orders");

        ordersSearchName3.setBackground(new java.awt.Color(232, 228, 228));
        ordersSearchName3.setForeground(new java.awt.Color(102, 102, 102));
        ordersSearchName3.setText("Search by name...");
        ordersSearchName3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ordersSearchName3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ordersSearchName3FocusLost(evt);
            }
        });
        ordersSearchName3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersSearchName3ActionPerformed(evt);
            }
        });

        addOrderButton3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addOrderButton3.setText("Add Order");
        addOrderButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderButton3ActionPerformed(evt);
            }
        });

        ordersTable3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        ordersTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Name", "Mobile No.", "Item", "Quantity", "Cost", "C/F/Debt", "M-Pesa", "Cash", "Fine", "Balance", "Delivery Day", "Returned", "Banked", "Slip No.", "Banked by"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, true, true, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ordersTable3.setRowHeight(17);
        jScrollPane18.setViewportView(ordersTable3);
        if (ordersTable3.getColumnModel().getColumnCount() > 0) {
            ordersTable3.getColumnModel().getColumn(0).setHeaderValue("#");
            ordersTable3.getColumnModel().getColumn(1).setPreferredWidth(170);
            ordersTable3.getColumnModel().getColumn(2).setPreferredWidth(100);
            ordersTable3.getColumnModel().getColumn(3).setPreferredWidth(230);
            ordersTable3.getColumnModel().getColumn(4).setPreferredWidth(30);
            ordersTable3.getColumnModel().getColumn(6).setHeaderValue("C/F/Debt");
            ordersTable3.getColumnModel().getColumn(9).setHeaderValue("Fine");
            ordersTable3.getColumnModel().getColumn(11).setPreferredWidth(100);
            ordersTable3.getColumnModel().getColumn(11).setHeaderValue("Delivery Day");
            ordersTable3.getColumnModel().getColumn(12).setHeaderValue("Returned");
            ordersTable3.getColumnModel().getColumn(13).setHeaderValue("Banked");
            ordersTable3.getColumnModel().getColumn(14).setHeaderValue("Slip No.");
            ordersTable3.getColumnModel().getColumn(15).setHeaderValue("Banked by");
        }

        ordersSaveButton1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        ordersSaveButton1.setText("Save");
        ordersSaveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersSaveButton1ActionPerformed(evt);
            }
        });

        showAllOrdersButton3.setText("All Orders Today");
        showAllOrdersButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllOrdersButton3ActionPerformed(evt);
            }
        });

        ordersSearchDeliverer3.setBackground(new java.awt.Color(232, 228, 228));
        ordersSearchDeliverer3.setForeground(new java.awt.Color(102, 102, 102));
        ordersSearchDeliverer3.setText("Search by deliverer...");
        ordersSearchDeliverer3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ordersSearchDeliverer3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ordersSearchDeliverer3FocusLost(evt);
            }
        });
        ordersSearchDeliverer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersSearchDeliverer3ActionPerformed(evt);
            }
        });

        ordersSearchDate3.setBackground(new java.awt.Color(232, 228, 228));
        ordersSearchDate3.setForeground(new java.awt.Color(102, 102, 102));
        ordersSearchDate3.setText("Search by date...(YYYY-MM-DD)");
        ordersSearchDate3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ordersSearchDate3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ordersSearchDate3FocusLost(evt);
            }
        });
        ordersSearchDate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersSearchDate3ActionPerformed(evt);
            }
        });

        ordersFineButton1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        ordersFineButton1.setText("Fine");
        ordersFineButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersFineButton1ActionPerformed(evt);
            }
        });

        returnedGoodsButton1.setText("Returned Goods");
        returnedGoodsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnedGoodsButton1ActionPerformed(evt);
            }
        });

        gatePassButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/management/system/images/printer.png"))); // NOI18N
        gatePassButton.setText("Print Gate Pass");
        gatePassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gatePassButtonActionPerformed(evt);
            }
        });

        delivererGatePass.setBackground(new java.awt.Color(232, 228, 228));
        delivererGatePass.setForeground(new java.awt.Color(102, 102, 102));
        delivererGatePass.setText("Deliverer(Gate Pass)...");
        delivererGatePass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                delivererGatePassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                delivererGatePassFocusLost(evt);
            }
        });
        delivererGatePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delivererGatePassActionPerformed(evt);
            }
        });

        timePrint.setBackground(new java.awt.Color(232, 228, 228));
        timePrint.setForeground(new java.awt.Color(102, 102, 102));
        timePrint.setText("Point in Time...");
        timePrint.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                timePrintFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                timePrintFocusLost(evt);
            }
        });

        productDistributionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/management/system/images/printer.png"))); // NOI18N
        productDistributionButton.setText("Print Product Distribution");
        productDistributionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productDistributionButtonActionPerformed(evt);
            }
        });

        delivererDistribution.setBackground(new java.awt.Color(232, 228, 228));
        delivererDistribution.setForeground(new java.awt.Color(102, 102, 102));
        delivererDistribution.setText("Deliverer(Distribution)...");
        delivererDistribution.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                delivererDistributionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                delivererDistributionFocusLost(evt);
            }
        });

        allOrdersYesterdayButton3.setText("All Orders Yesterday");
        allOrdersYesterdayButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allOrdersYesterdayButton3ActionPerformed(evt);
            }
        });

        allOrdersTomorrowButton3.setText("All Orders Tomorrow");
        allOrdersTomorrowButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allOrdersTomorrowButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ordersPanel3Layout = new javax.swing.GroupLayout(ordersPanel3);
        ordersPanel3.setLayout(ordersPanel3Layout);
        ordersPanel3Layout.setHorizontalGroup(
            ordersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersPanel3Layout.createSequentialGroup()
                .addGroup(ordersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ordersPanel3Layout.createSequentialGroup()
                        .addGroup(ordersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ordersPanel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(ordersPageTitle3)
                                .addGap(29, 29, 29)
                                .addComponent(ordersSearchName3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ordersSearchDeliverer3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ordersSearchDate3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordersPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(productDistributionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delivererDistribution, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timePrint, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delivererGatePass, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gatePassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(ordersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ordersPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(returnedGoodsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(addOrderButton3)))
                    .addGroup(ordersPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane18)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordersPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(allOrdersYesterdayButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showAllOrdersButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allOrdersTomorrowButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330)
                .addComponent(ordersSaveButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ordersFineButton1)
                .addGap(64, 64, 64))
        );
        ordersPanel3Layout.setVerticalGroup(
            ordersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(ordersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addOrderButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ordersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ordersPageTitle3)
                        .addComponent(ordersSearchName3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ordersSearchDeliverer3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ordersSearchDate3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ordersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ordersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gatePassButton, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(delivererGatePass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(timePrint, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(delivererDistribution, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(productDistributionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(returnedGoodsButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ordersPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ordersFineButton1)
                    .addComponent(ordersSaveButton1)
                    .addComponent(allOrdersTomorrowButton3)
                    .addComponent(showAllOrdersButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(allOrdersYesterdayButton3))
                .addGap(29, 29, 29))
        );

        basePanel.add(ordersPanel3, "card5");

        addCustomerPageTitle.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        addCustomerPageTitle.setText("Add Customer");

        addCustomerNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addCustomerNameLabel.setText("Customer Name:");

        addCustomerNumberLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addCustomerNumberLabel.setText("Mobile No. :");

        addCustomerDelivererLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addCustomerDelivererLabel.setText("Deliverer:");

        addCustomerLocationLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addCustomerLocationLabel.setText("Location:");

        addCustomerNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerNumberTextFieldActionPerformed(evt);
            }
        });

        addCustomerDelivererTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerDelivererTextFieldActionPerformed(evt);
            }
        });

        addCustomerSaveButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addCustomerSaveButton.setText("Add");
        addCustomerSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerSaveButtonActionPerformed(evt);
            }
        });

        addCustomerDelivererLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addCustomerDelivererLabel1.setText("Note (Optional):");

        addCustomerNoteTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerNoteTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addCustomerPanelLayout = new javax.swing.GroupLayout(addCustomerPanel);
        addCustomerPanel.setLayout(addCustomerPanelLayout);
        addCustomerPanelLayout.setHorizontalGroup(
            addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCustomerPanelLayout.createSequentialGroup()
                .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCustomerPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(addCustomerPageTitle))
                    .addGroup(addCustomerPanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addCustomerDelivererLabel)
                            .addComponent(addCustomerNameLabel)
                            .addComponent(addCustomerLocationLabel)
                            .addComponent(addCustomerNumberLabel)
                            .addComponent(addCustomerDelivererLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addCustomerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCustomerDelivererTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCustomerLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCustomerNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCustomerNoteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCustomerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addCustomerSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(477, 477, 477))
        );
        addCustomerPanelLayout.setVerticalGroup(
            addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCustomerPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(addCustomerPageTitle)
                .addGap(18, 18, 18)
                .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCustomerNameLabel)
                    .addComponent(addCustomerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCustomerNumberLabel)
                    .addComponent(addCustomerNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCustomerLocationLabel)
                    .addComponent(addCustomerLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCustomerDelivererLabel)
                    .addComponent(addCustomerDelivererTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCustomerDelivererLabel1)
                    .addComponent(addCustomerNoteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(addCustomerSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        basePanel.add(addCustomerPanel, "card7");

        addCustomerButton1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addCustomerButton1.setText("Add Customer");
        addCustomerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        jLabel4.setText("Blacklisted");

        customersPageTitle1.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        customersPageTitle1.setText("Customers");

        customerSearchDeliverer1.setBackground(new java.awt.Color(232, 228, 228));
        customerSearchDeliverer1.setForeground(new java.awt.Color(102, 102, 102));
        customerSearchDeliverer1.setText("Search by deliverer...");
        customerSearchDeliverer1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customerSearchDeliverer1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                customerSearchDeliverer1FocusLost(evt);
            }
        });
        customerSearchDeliverer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSearchDeliverer1ActionPerformed(evt);
            }
        });

        customerSearchName1.setBackground(new java.awt.Color(232, 228, 228));
        customerSearchName1.setForeground(new java.awt.Color(102, 102, 102));
        customerSearchName1.setText("Search by name...");
        customerSearchName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customerSearchName1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                customerSearchName1FocusLost(evt);
            }
        });
        customerSearchName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSearchName1ActionPerformed(evt);
            }
        });

        customersTable1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        customersTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Name", "Mobile No.", "Location", "Deliverer", "Status", "Note"
            }
        ));
        customersTable1.setRowHeight(20);
        jScrollPane6.setViewportView(customersTable1);

        customersSaveChangesButton1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        customersSaveChangesButton1.setText("Save");
        customersSaveChangesButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersSaveChangesButton1ActionPerformed(evt);
            }
        });

        blackListedTable1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        blackListedTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
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
                "#", "Name", "Mobile No.", "Location", "Amount Paid", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        blackListedTable1.setRowHeight(20);
        jScrollPane7.setViewportView(blackListedTable1);

        showAllCustomersButton1.setText("All Customers");
        showAllCustomersButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllCustomersButton1ActionPerformed(evt);
            }
        });

        customerSearchContact1.setBackground(new java.awt.Color(232, 228, 228));
        customerSearchContact1.setForeground(new java.awt.Color(102, 102, 102));
        customerSearchContact1.setText("Search by contact...");
        customerSearchContact1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customerSearchContact1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                customerSearchContact1FocusLost(evt);
            }
        });
        customerSearchContact1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSearchContact1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customersPanel1Layout = new javax.swing.GroupLayout(customersPanel1);
        customersPanel1.setLayout(customersPanel1Layout);
        customersPanel1Layout.setHorizontalGroup(
            customersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customersPanel1Layout.createSequentialGroup()
                .addGroup(customersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, customersPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7))
                    .addGroup(customersPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6))
                    .addGroup(customersPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(customersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customersPanel1Layout.createSequentialGroup()
                                .addComponent(showAllCustomersButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addCustomerButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customersPanel1Layout.createSequentialGroup()
                                .addComponent(customersPageTitle1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerSearchName1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerSearchDeliverer1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerSearchContact1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(customersPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customersSaveChangesButton1)))
                .addGap(42, 42, 42))
        );
        customersPanel1Layout.setVerticalGroup(
            customersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(customersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customersPageTitle1)
                    .addComponent(customerSearchName1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerSearchDeliverer1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerSearchContact1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customersPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showAllCustomersButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCustomerButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customersSaveChangesButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        basePanel.add(customersPanel1, "card9");

        customersPageTitle2.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        customersPageTitle2.setText("Customers");

        customerSearchDeliverer2.setBackground(new java.awt.Color(232, 228, 228));
        customerSearchDeliverer2.setForeground(new java.awt.Color(102, 102, 102));
        customerSearchDeliverer2.setText("Search by deliverer...");
        customerSearchDeliverer2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customerSearchDeliverer2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                customerSearchDeliverer2FocusLost(evt);
            }
        });
        customerSearchDeliverer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSearchDeliverer2ActionPerformed(evt);
            }
        });

        customerSearchName2.setBackground(new java.awt.Color(232, 228, 228));
        customerSearchName2.setForeground(new java.awt.Color(102, 102, 102));
        customerSearchName2.setText("Search by name...");
        customerSearchName2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customerSearchName2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                customerSearchName2FocusLost(evt);
            }
        });
        customerSearchName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSearchName2ActionPerformed(evt);
            }
        });

        addCustomerButton2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addCustomerButton2.setText("Add Customer");
        addCustomerButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        jLabel6.setText("Blacklisted");

        customersSaveChangesButton2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        customersSaveChangesButton2.setText("Save");
        customersSaveChangesButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersSaveChangesButton2ActionPerformed(evt);
            }
        });

        blacklistedSaveChangsButton1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        blacklistedSaveChangsButton1.setText("Save");
        blacklistedSaveChangsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blacklistedSaveChangsButton1ActionPerformed(evt);
            }
        });

        customersTable2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        customersTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
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
                "#", "Name", "Mobile No.", "Location", "Deliverer", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customersTable2.setRowHeight(20);
        jScrollPane12.setViewportView(customersTable2);

        blackListedTable2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        blackListedTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
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
                "#", "Name", "Mobile No.", "Location", "Amount Paid", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        blackListedTable2.setRowHeight(20);
        jScrollPane13.setViewportView(blackListedTable2);

        showAllCustomersButton2.setText("All Customers");
        showAllCustomersButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllCustomersButton2ActionPerformed(evt);
            }
        });

        customerBlacklist1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        customerBlacklist1.setText("Blacklist");
        customerBlacklist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerBlacklist1ActionPerformed(evt);
            }
        });

        blacklistedRestore1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        blacklistedRestore1.setText("Restore");
        blacklistedRestore1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blacklistedRestore1ActionPerformed(evt);
            }
        });

        customerSearchContact2.setBackground(new java.awt.Color(232, 228, 228));
        customerSearchContact2.setForeground(new java.awt.Color(102, 102, 102));
        customerSearchContact2.setText("Search by contact...");
        customerSearchContact2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customerSearchContact2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                customerSearchContact2FocusLost(evt);
            }
        });
        customerSearchContact2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSearchContact2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customersPanel2Layout = new javax.swing.GroupLayout(customersPanel2);
        customersPanel2.setLayout(customersPanel2Layout);
        customersPanel2Layout.setHorizontalGroup(
            customersPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanel2Layout.createSequentialGroup()
                .addGroup(customersPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(customersPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(customersPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(customersPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, customersPanel2Layout.createSequentialGroup()
                                    .addGroup(customersPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(customersPanel2Layout.createSequentialGroup()
                                            .addComponent(showAllCustomersButton2)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(customersPanel2Layout.createSequentialGroup()
                                            .addComponent(customersPageTitle2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(customerSearchName2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(customerSearchDeliverer2)))
                                    .addGap(18, 18, 18)
                                    .addGroup(customersPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(customerSearchContact2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addCustomerButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(customersPanel2Layout.createSequentialGroup()
                                    .addComponent(customersSaveChangesButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(customerBlacklist1))
                                .addGroup(customersPanel2Layout.createSequentialGroup()
                                    .addComponent(blacklistedSaveChangsButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(blacklistedRestore1))))
                        .addGroup(customersPanel2Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6))))
                .addGap(26, 26, 26))
        );
        customersPanel2Layout.setVerticalGroup(
            customersPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(customersPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customersPageTitle2)
                    .addComponent(customerSearchDeliverer2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerSearchName2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerSearchContact2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customersPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showAllCustomersButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCustomerButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customersPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customersSaveChangesButton2)
                    .addComponent(customerBlacklist1))
                .addGap(7, 7, 7)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customersPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blacklistedRestore1)
                    .addComponent(blacklistedSaveChangsButton1))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        basePanel.add(customersPanel2, "card13");

        ordersTable4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ordersTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Item", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ordersTable4.setRowHeight(20);
        jScrollPane3.setViewportView(ordersTable4);
        if (ordersTable4.getColumnModel().getColumnCount() > 0) {
            ordersTable4.getColumnModel().getColumn(0).setPreferredWidth(250);
            ordersTable4.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        ordersPageTitle4.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        ordersPageTitle4.setText("Gate Pass");

        javax.swing.GroupLayout gatePassLayout = new javax.swing.GroupLayout(gatePass);
        gatePass.setLayout(gatePassLayout);
        gatePassLayout.setHorizontalGroup(
            gatePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gatePassLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(gatePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ordersPageTitle4))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        gatePassLayout.setVerticalGroup(
            gatePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gatePassLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(ordersPageTitle4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        basePanel.add(gatePass, "card10");

        ordersTable5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ordersTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Number", "Location", "Item", "Quantity", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ordersTable5.setRowHeight(20);
        jScrollPane4.setViewportView(ordersTable5);
        if (ordersTable5.getColumnModel().getColumnCount() > 0) {
            ordersTable5.getColumnModel().getColumn(0).setPreferredWidth(250);
            ordersTable5.getColumnModel().getColumn(1).setPreferredWidth(100);
            ordersTable5.getColumnModel().getColumn(2).setPreferredWidth(100);
            ordersTable5.getColumnModel().getColumn(3).setPreferredWidth(250);
            ordersTable5.getColumnModel().getColumn(4).setPreferredWidth(7);
            ordersTable5.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        ordersPageTitle5.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        ordersPageTitle5.setText("Goods Distribution");

        javax.swing.GroupLayout goodsDistributionLayout = new javax.swing.GroupLayout(goodsDistribution);
        goodsDistribution.setLayout(goodsDistributionLayout);
        goodsDistributionLayout.setHorizontalGroup(
            goodsDistributionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goodsDistributionLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(goodsDistributionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ordersPageTitle5))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        goodsDistributionLayout.setVerticalGroup(
            goodsDistributionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goodsDistributionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(ordersPageTitle5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        basePanel.add(goodsDistribution, "card10");

        stockValuationTitle.setFont(new java.awt.Font("Lucida Grande", 1, 30)); // NOI18N
        stockValuationTitle.setText("Stock Valuation");

        stockTable2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        stockTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Brand Name", "Date-4 ", "Date-3", "Date-2", "Date-1 ", "Date", "Opening stock(Yesterday)", "Purchase(Yesterday)", "Closing Stock(Yesterday)", "Buying Price(Last Purchase)", "Stock Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockTable2.setRowHeight(20);
        jScrollPane20.setViewportView(stockTable2);
        if (stockTable2.getColumnModel().getColumnCount() > 0) {
            stockTable2.getColumnModel().getColumn(0).setPreferredWidth(60);
            stockTable2.getColumnModel().getColumn(1).setPreferredWidth(250);
            stockTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
            stockTable2.getColumnModel().getColumn(10).setPreferredWidth(170);
        }

        valuationDateTextfield.setBackground(new java.awt.Color(232, 228, 228));
        valuationDateTextfield.setForeground(new java.awt.Color(102, 102, 102));
        valuationDateTextfield.setText("Search valuation by date...");
        valuationDateTextfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valuationDateTextfieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valuationDateTextfieldFocusLost(evt);
            }
        });
        valuationDateTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valuationDateTextfieldActionPerformed(evt);
            }
        });

        valuationInstruction.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        valuationInstruction.setText("The default valuation is done from today backwards. Purchase records shown are as at the end of day yesterday.");

        valuationTodayButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        valuationTodayButton.setText("Valuation from Today");
        valuationTodayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valuationTodayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stockPanel2Layout = new javax.swing.GroupLayout(stockPanel2);
        stockPanel2.setLayout(stockPanel2Layout);
        stockPanel2Layout.setHorizontalGroup(
            stockPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockPanel2Layout.createSequentialGroup()
                .addGroup(stockPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stockPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(stockPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(stockPanel2Layout.createSequentialGroup()
                                .addComponent(stockValuationTitle)
                                .addGap(63, 63, 63)
                                .addComponent(valuationDateTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(valuationTodayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))))
                    .addGroup(stockPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(valuationInstruction)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        stockPanel2Layout.setVerticalGroup(
            stockPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(stockPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockValuationTitle)
                    .addComponent(valuationDateTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valuationTodayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(valuationInstruction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        basePanel.add(stockPanel2, "card4");

        backgroundPanel.add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 1090, 770));

        buttonsPanel.setLayout(new java.awt.CardLayout());

        ordersPrintButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/management/system/images/printer.png"))); // NOI18N
        ordersPrintButton.setText("Print");
        ordersPrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersPrintButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(ordersPrintButton, "card2");

        customersPrintButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/management/system/images/printer.png"))); // NOI18N
        customersPrintButton.setText("Print");
        customersPrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersPrintButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(customersPrintButton, "card3");

        addOrderBackButton.setText("< Back");
        addOrderBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderBackButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(addOrderBackButton, "card4");

        addStockBackButton.setText("< Back");
        addStockBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockBackButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(addStockBackButton, "card5");

        addCustomerBackButton.setText("< Back");
        addCustomerBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerBackButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(addCustomerBackButton, "card6");

        categoriesBackButton.setText("< Back");
        categoriesBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriesBackButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(categoriesBackButton, "card7");

        categoriesBackButton1.setText("< Back");
        categoriesBackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriesBackButton1ActionPerformed(evt);
            }
        });
        buttonsPanel.add(categoriesBackButton1, "card8");

        returnedGoodsBackButton.setText("< Back");
        returnedGoodsBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnedGoodsBackButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(returnedGoodsBackButton, "card8");

        stockValuationBackButton.setText("< Back");
        stockValuationBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockValuationBackButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(stockValuationBackButton, "card8");

        backgroundPanel.add(buttonsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 100, 50));

        sideBarPanel.setLayout(new java.awt.CardLayout());

        sideBar.setBackground(new java.awt.Color(51, 204, 0));
        sideBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sideBar.setForeground(new java.awt.Color(255, 255, 255));

        customerSideBar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        customerSideBar.setText("Customers");
        customerSideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                customerSideBarMousePressed(evt);
            }
        });

        stockSideBar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        stockSideBar.setText("Stock");
        stockSideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stockSideBarMousePressed(evt);
            }
        });

        orderSideBar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        orderSideBar.setText("Orders");
        orderSideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                orderSideBarMousePressed(evt);
            }
        });

        summarySideBar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        summarySideBar.setText("Summary");
        summarySideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                summarySideBarMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("YuGothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/management/system/images/menu icon.png"))); // NOI18N
        jLabel1.setText("Menu");

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(summarySideBar)
                    .addComponent(orderSideBar)
                    .addComponent(stockSideBar)
                    .addComponent(customerSideBar))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(121, 121, 121)
                .addComponent(customerSideBar)
                .addGap(40, 40, 40)
                .addComponent(stockSideBar)
                .addGap(41, 41, 41)
                .addComponent(orderSideBar)
                .addGap(48, 48, 48)
                .addComponent(summarySideBar)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        sideBarPanel.add(sideBar, "card3");

        backgroundPanel.add(sideBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 200, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        Login lg = new Login();
        this.setVisible(false);
        lg.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void addStockBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStockBackButtonActionPerformed
        switchPanel(stockPanel);
        switchButton2();
        switchBar(sideBar);
        sideBarColor2();
    }//GEN-LAST:event_addStockBackButtonActionPerformed

    private void addCustomerBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerBackButtonActionPerformed
    try {
        userAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_addCustomerBackButtonActionPerformed

    private void customersPrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersPrintButtonActionPerformed
        switchPanel(customersPrint);
        customersPrint.customerPrint();
        customersPrint.print();
    try {
        userAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_customersPrintButtonActionPerformed

    private void addOrderBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderBackButtonActionPerformed
    try {
        ordersAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_addOrderBackButtonActionPerformed

    private void ordersPrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersPrintButtonActionPerformed
        switchPanel(ordersPrint);
        ordersPrint.ordersPrinting();
        ordersPrint.print();
        try {
        ordersAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_ordersPrintButtonActionPerformed

    private void ordersSearchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersSearchNameActionPerformed
        String searched = ordersSearchName.getText();
        double price;
        int quantity;
        double cost;
        String delivery;
       // String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where customers.Name LIKE '"+searched+"%' AND DATE(orders.Created_at) = CURRENT_DATE()";
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where customers.Name LIKE '%"+searched+"%' order by orders.id ";
        Connection connect = databaseConnection.connection();
        try {            
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                cost=price*quantity;
                 delivery = rs.getString("orders.Late_Order");
                Object o[]={rs.getInt("id"),
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost,
                    rs.getString("Debt"),
                    rs.getString("Mpesa"),
                    rs.getString("Cash"),
                    rs.getDouble("Fine"),
                    rs.getString("Balance"),
                    delivery,
                    rs.getInt("Returned"),
                    rs.getString("Banked"),
                    rs.getString("Slip_Number"),
                    rs.getString("Banked_By")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_ordersSearchNameActionPerformed

    private void addOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderButtonActionPerformed
        switchButton(addOrderBackButton);
        switchPanel(addOrderPanel);
        switchBar(sideBar);
        sideBarColor3();
    }//GEN-LAST:event_addOrderButtonActionPerformed

    private void ordersSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersSaveButtonActionPerformed
        String new_status;
        int Customer_id;
        DefaultTableModel model = (DefaultTableModel)ordersTable.getModel();
        int selectedRowIndex = ordersTable.getSelectedRow();
        int row = ordersTable.getSelectedRow();
        String cell = ordersTable.getModel().getValueAt(row, 0).toString();
        double debt = Double.parseDouble(model.getValueAt(selectedRowIndex, 6).toString());
        int quantity = Integer.parseInt(model.getValueAt(selectedRowIndex, 4).toString());
        double Mpesa = Double.parseDouble(model.getValueAt(selectedRowIndex, 7).toString());
        double Cash = Double.parseDouble(model.getValueAt(selectedRowIndex, 8).toString());
        double Fine = Double.parseDouble(model.getValueAt(selectedRowIndex, 9).toString());
        double Balance = Double.parseDouble(model.getValueAt(selectedRowIndex,10).toString());
        String Banked = model.getValueAt(selectedRowIndex, 13).toString();
        String Slip = model.getValueAt(selectedRowIndex, 14).toString();
        String Banker = model.getValueAt(selectedRowIndex, 15).toString();
        Connection connect = databaseConnection.connection();
        String update0 = "select * from orders INNER JOIN stock ON orders.Stock_id=stock.id where orders.id="+cell;
        try {               
                pst = connect.prepareStatement(update0);
                rs=pst.executeQuery();
                while(rs.next()){
                    double price=rs.getDouble("stock.price");
                    double old_quantity=rs.getDouble("orders.Quantity");
                    int stock_id = rs.getInt("stock.id");
                    double cost = price*quantity;
        double new_balance = debt-cost+Mpesa+Cash+Fine;
        String update = "select * from orders where orders.id="+cell;
        try {               
                pst = connect.prepareStatement(update);
                rs=pst.executeQuery();
                while(rs.next()){
                    Double old_balance = rs.getDouble("Balance");
        String sql = "update orders set Quantity='"+quantity+"', Mpesa='"+Mpesa+"', Cash='"+Cash+"',Balance='"+new_balance+"', Banked='"+Banked+"' , Slip_Number='"+Slip+"', Banked_By='"+Banker+"' where id =" + cell;
        try{           
            pst = connect.prepareStatement(sql);
            pst.execute();
        try {               
                pst = connect.prepareStatement(update);
                rs=pst.executeQuery();
                while(rs.next()){
                    double newest_balance = rs.getDouble("Balance");
                    int customer_id = rs.getInt("Customer_id");
                    double new_quantity=rs.getDouble("Quantity");
                    double returned = old_quantity - new_quantity;
                    String new_qty = "update stock set Quantity= Quantity +"+returned+"  where id =" +stock_id;
                        try{                           
                            pst2 = connect.prepareStatement(new_qty);
                            pst2.execute();
                    String sql10 = "update orders set Returned= Returned +"+returned+"  where id =" +cell;
                    if (old_quantity > new_quantity )
                    {
                    try{                           
                            pst2 = connect.prepareStatement(sql10);
                            pst2.execute();
                            }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }    
                    double difference = old_balance - newest_balance;
                    String sql2 = "update orders set Debt= Debt-"+difference+", Balance= Balance-"+difference+" where Customer_id="+customer_id+" and id >" + cell;
                    //the status to be updated on checking last cell of orders of that customer
                    try{           
                      pst = connect.prepareStatement(sql2);
                       pst.execute();
            String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id  WHERE orders.id IN (SELECT MAX(orders.id)FROM orders INNER JOIN customers ON orders.Customer_id=customers.id where customers.id='"+customer_id+"' );";
            try {               
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                while(rs.next()){
                    Customer_id = rs.getInt("customers.id");
                    if(new_balance == 0){
                        new_status="clean";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                         
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(new_balance > 0){
                        new_status="credit";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                           
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(new_balance < 0 && new_balance >= -100){
                        new_status="fined";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                           
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(new_balance < -100){
                        new_status="no delivery";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                           
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
             }catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
            }catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Order Updated.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
            }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
         }
            }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    try {
        ordersQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_ordersSaveButtonActionPerformed

    private void showAllOrdersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllOrdersButtonActionPerformed
    try {
        ordersQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_showAllOrdersButtonActionPerformed

    private void ordersDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersDeleteButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel)ordersTable.getModel();
        int selectedRowIndex = ordersTable.getSelectedRow();
        int row = ordersTable.getSelectedRow();
        String cell = ordersTable.getModel().getValueAt(row, 0).toString();
        String id = model.getValueAt(selectedRowIndex, 0).toString();
        Double cost = Double.parseDouble(model.getValueAt(selectedRowIndex, 5).toString());
        String sql = "Delete from orders where id =" + cell;
        String sql2 = "select * from orders INNER JOIN stock ON orders.Stock_id=stock.id where orders.id="+id;
        Connection connect = databaseConnection.connection();
        try{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Delete selected Order?","Delete",dialogButton,JOptionPane.INFORMATION_MESSAGE,icon);
            if(dialogResult == JOptionPane.YES_OPTION){                
                try{                   
                    pst = connect.prepareStatement(sql2);
                    rs = pst.executeQuery();
                    while(rs.next()){;
                        int order_qty = rs.getInt("orders.Quantity");
                        int stock_qty = rs.getInt("stock.Quantity");
                        int customer_id = rs.getInt("orders.Customer_id");
                        int qty = stock_qty + order_qty;
                        int stock = rs.getInt("stock.id");
                        String sql3 = "update stock set Quantity='"+qty+"'  where id =" +stock;
                        try{                           
                            pst2 = connect.prepareStatement(sql3);
                            pst2.execute();

                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    String sql4 = "update orders set Debt= Debt+"+cost+", Balance= Balance+"+cost+" where Customer_id="+customer_id+" and id >" + cell;
                    //the status to be updated on checking last cell of orders of that customer
                    try{           
                      pst = connect.prepareStatement(sql4);
                       pst.execute();
                       }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                 }   
                }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                pst3 = connect.prepareStatement(sql);
                pst3.execute();
                JOptionPane.showMessageDialog(this, "Order Deleted.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
            }
            else{
                ordersQuery();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    try {
        ordersQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_ordersDeleteButtonActionPerformed

    private void ordersSearchDelivererActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersSearchDelivererActionPerformed
        String searched = ordersSearchDeliverer.getText();
        double price;
        int quantity;
        double cost;
        String delivery;
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where customers.Deliverer LIKE '%"+searched+"%' AND DATE(orders.Created_at) = CURRENT_DATE() order by orders.id";
        Connection connect = databaseConnection.connection();
        try {          
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                cost=price*quantity;
                delivery = rs.getString("orders.Late_Order");
                Object o[]={rs.getInt("id"),
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost,
                    rs.getString("Debt"),
                    rs.getString("Mpesa"),
                    rs.getString("Cash"),
                    rs.getDouble("Fine"),
                    rs.getString("Balance"),
                    delivery,
                    rs.getInt("Returned"),
                    rs.getString("Banked"),   
                    rs.getString("Slip_Number"),
                    rs.getString("Banked_By")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_ordersSearchDelivererActionPerformed

    private void ordersSearchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersSearchDateActionPerformed
        String searched = ordersSearchDate.getText();
        double price;
        int quantity;
        double cost;
        String delivery;
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where DATE(orders.Late_Order) LIKE '"+searched+"%' order by orders.id";
       Connection connect = databaseConnection.connection();
        try {           
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                cost=price*quantity;
                delivery = rs.getString("orders.Late_Order");
                Object o[]={rs.getInt("id"),
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost,
                    rs.getString("Debt"),
                    rs.getString("Mpesa"),
                    rs.getString("Cash"),
                    rs.getDouble("Fine"),
                    rs.getString("Balance"),
                    delivery,
                    rs.getInt("Returned"),
                    rs.getString("Banked"),
                    rs.getString("Slip_Number"),
                    rs.getString("Banked_By")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_ordersSearchDateActionPerformed

    private void addStockPriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStockPriceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStockPriceTextFieldActionPerformed

    private void addStockNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStockNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStockNameTextFieldActionPerformed

    private void addStockQuantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStockQuantityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStockQuantityTextFieldActionPerformed

    private void addStockSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStockSaveButtonActionPerformed
        Connection connect = databaseConnection.connection();
        try{
            String query = "INSERT INTO `stock`(`Category_id`,`Name`,`Buying_price`, `Price`, `Quantity`) VALUES (?,?,?,?,?)";
            pst = connect.prepareStatement(query);
            pst.setString(1,addStockCategoryIdTextField.getText());
            pst.setString(2,addStockNameTextField.getText());
            pst.setString(3,addStockBuyingPriceTextField.getText());
            pst.setString(4,addStockPriceTextField.getText());
            pst.setString(5,addStockQuantityTextField.getText());
            pst.execute();
            JOptionPane.showMessageDialog(this, "Stock Added.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
            addStockCategoryIdTextField.setText("");
            addStockNameTextField.setText("");
            addStockPriceTextField.setText("");
            addStockBuyingPriceTextField.setText("");
            addStockQuantityTextField.setText("");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    try {
        stockAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
       ArrayList stocks = null;
    try {
        stocks = stockQuery.stockQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(stocks.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Stock Available","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)stockTable.getModel();

            tm.setRowCount(0);
            for(int i=0; i<stocks.size(); i++)
            {
                Object o[] = (Object[])stocks.get(i);
                tm.addRow(o);
            }
        }
    }//GEN-LAST:event_addStockSaveButtonActionPerformed

    private void ordersSearchName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersSearchName1ActionPerformed
        String searched = ordersSearchName1.getText();
        double price;
        int quantity;
        double cost;
        String delivery;
        //String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where customers.Name LIKE '%"+searched+"%' AND DATE(orders.Created_at) = CURRENT_DATE()";
        Connection connect = databaseConnection.connection();
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where customers.Name LIKE '%"+searched+"%' order by orders.id";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable1.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                int returned=rs.getInt("orders.Returned");
                cost=price*quantity;
                delivery = rs.getString("orders.Late_Order");
                Object o[]={rs.getInt("id"),
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost,
                    rs.getString("Debt"),
                    delivery,
                    returned
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ordersSearchName1ActionPerformed

    private void addOrderButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderButton1ActionPerformed
        switchButton(addOrderBackButton);
        switchPanel(addOrderPanel);
        switchBar(sideBar);
        sideBarColor3();
    }//GEN-LAST:event_addOrderButton1ActionPerformed

    private void showAllOrdersButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllOrdersButton1ActionPerformed
    try {
        ordersQuery1();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_showAllOrdersButton1ActionPerformed

    private void ordersSearchDeliverer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersSearchDeliverer1ActionPerformed
        String searched = ordersSearchDeliverer1.getText();
        double price;
        int quantity;
        double cost;
        String delivery;
        Connection connect = databaseConnection.connection();
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where customers.Deliverer LIKE '%"+searched+"%' AND DATE(orders.Created_at) = CURRENT_DATE() order by orders.id";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable1.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                int returned=rs.getInt("orders.Returned");
                cost=price*quantity;
                delivery = rs.getString("orders.Late_Order");
                Object o[]={rs.getInt("id"),
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost,
                    rs.getString("Debt"),
                    delivery,
                    returned
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_ordersSearchDeliverer1ActionPerformed

    private void ordersSearchDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersSearchDate1ActionPerformed
        String searched = ordersSearchDate1.getText();
        double price;
        int quantity;
        double cost;
        String delivery;
        Connection connect = databaseConnection.connection();
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where DATE(orders.Late_Order) LIKE '"+searched+"%' order by orders.id";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable1.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                int returned=rs.getInt("orders.Returned");
                cost=price*quantity;
                delivery = rs.getString("orders.Late_Order");
                Object o[]={rs.getInt("id"),
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost,
                    rs.getString("Debt"),
                    delivery,
                    returned
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_ordersSearchDate1ActionPerformed

    private void newOrderSearchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderSearchNameActionPerformed
        String searched = newOrderSearchName.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select * from customers where Name LIKE '%"+searched+"%' and not Status='blacklisted'";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)newOrderTable.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("id"),
                    rs.getString("Name"),
                    rs.getString("Number"),
                    rs.getString("Location"),
                    rs.getString("Deliverer"),
                    rs.getString("Status")};
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newOrderSearchNameActionPerformed

    private void newOrderSearchStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderSearchStockActionPerformed
        String searched = newOrderSearchStock.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select * from stock INNER JOIN category ON stock.Category_id=category.id where Category_Name LIKE '%"+searched+"%'";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)newOrderDetailsTable.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("id"),
                    rs.getString("Name"),
                    rs.getString("Price"),
                    rs.getString("Quantity")};
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_newOrderSearchStockActionPerformed

    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartButtonActionPerformed
        DefaultTableModel model2 = (DefaultTableModel)newOrderDetailsTable.getModel();
        int selectedRowIndex = newOrderDetailsTable.getSelectedRow();
        int row2 = newOrderDetailsTable.getSelectedRow();
        Connection connect = databaseConnection.connection();
        String cell = newOrderDetailsTable.getModel().getValueAt(row2, 0).toString();
        int quantity0 = Integer.parseInt(model2.getValueAt(selectedRowIndex, 3).toString());
        int quantity1 = Integer.parseInt(model2.getValueAt(selectedRowIndex, 4).toString());
        if(quantity0 >= quantity1)
        {
            TableModel model = newOrderDetailsTable.getModel();
            int[] index = newOrderDetailsTable.getSelectedRows();
            Object[] row = new Object[5];
            DefaultTableModel tm=(DefaultTableModel)newOrderCartTable.getModel();
            for(int i=0; i<index.length; i++)
            {
                row[0] = model.getValueAt(index[i],0);
                row[1] = model.getValueAt(index[i],1);
                row[2] = model.getValueAt(index[i],2);
                row[3] = model.getValueAt(index[i],4);
                double price = Double.parseDouble( model.getValueAt(index[i], 2).toString()) ;
                int quantity = Integer.parseInt( model.getValueAt(index[i], 4).toString()) ;
                double cost = price*quantity;
                row[4] = cost;
                tm.addRow(row);
            }
            getTotals();
        }
        else{
            JOptionPane.showMessageDialog(this,"The ordered quantity is more than what is available","Error",JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }//GEN-LAST:event_addToCartButtonActionPerformed

    private void completeOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeOrderButtonActionPerformed
        Connection connect = databaseConnection.connection();
        try{
            DefaultTableModel model = (DefaultTableModel)newOrderTable.getModel();
            int selectedRowIndex = (Integer)newOrderTable.getSelectedRow();
            int rows=(Integer)newOrderCartTable.getRowCount();
            for(int row = 0; row<rows; row++)
            {
                String new_status;
                int Customer_id = Integer.parseInt(newOrderTable.getValueAt(selectedRowIndex, 0).toString());
                int Stock_id = Integer.parseInt(newOrderCartTable.getValueAt(row, 0).toString());
                int Quantity = Integer.parseInt(newOrderCartTable.getValueAt(row, 3).toString());
                Double Cost = Double.parseDouble(newOrderCartTable.getValueAt(row, 4).toString());
                String query2 = "select * from stock INNER JOIN category ON stock.Category_id=category.id where stock.id='"+Stock_id+"'";
                String query0 = "SELECT EXISTS(SELECT * FROM orders where Customer_id='"+Customer_id+"');";
                try{                   
                    pst = connect.prepareStatement(query0);
                    rs=pst.executeQuery();
                    int n = 0;
                    if ( rs.next() ) {
                        n = rs.getInt(1);
                    }
                    if ( n > 0 ) {
                        pst = connect.prepareStatement(query2);
                        rs=pst.executeQuery();
                        rs.next();
                        int Category_id = rs.getInt("Category_id");
                        int available = rs.getInt("Quantity");
                        String query3 = "SELECT * FROM orders where Customer_id='"+Customer_id+"' ORDER BY id DESC LIMIT  1";
                        try{
                            pst = connect.prepareStatement(query3);
                            rs=pst.executeQuery();
                            rs.next();
                            double old_Debt = rs.getDouble("Balance");
                            double new_balance = old_Debt-Cost;
                            if(additionRadioButton.isSelected() && specifyOrderDate.getText().equals("Otherwise specify the order date(YYYY-MM-DD)...")){
                             String query = "Insert into orders(Customer_id,Category_id,Stock_id,Quantity,Late_Order,Debt,Mpesa,Cash,Balance) values ('"+Customer_id+"','"+Category_id+"','"+Stock_id+"','"+Quantity+"',CURRENT_DATE(),'"+old_Debt+"','0','0','"+new_balance+"')";
                            try{
                                pst = connect.prepareStatement(query);
                                pst.execute();
                                int new_quantity = available-Quantity;
                                String query4 = "update stock set Quantity='"+new_quantity+"'  where id =" + Stock_id;
                                try{
                                    pst = connect.prepareStatement(query4);
                                    pst.execute();
                                    if(new_balance == 0){
                                        new_status="clean";
                                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                        try{
                                            pst = connect.prepareStatement(query5);
                                            pst.execute();
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    else if(new_balance > 0){
                                        new_status="credit";
                                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                        try{
                                            pst = connect.prepareStatement(query5);
                                            pst.execute();
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    else if(new_balance < 0 && new_balance >= -100){
                                        new_status="fined";
                                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                        try{
                                            pst = connect.prepareStatement(query5);
                                            pst.execute();
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    else if(new_balance < -100){
                                        new_status="no delivery";
                                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                        try{
                                            pst = connect.prepareStatement(query5);
                                            pst.execute();
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }catch (SQLException ex) {
                                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           }
                            else if (!additionRadioButton.isSelected() && !specifyOrderDate.getText().equals("Otherwise specify the order date(YYYY-MM-DD)...")){
                                String specified = specifyOrderDate.getText();
                                String query = "Insert into orders(Customer_id,Category_id,Stock_id,Quantity,Late_Order,Debt,Mpesa,Cash,Balance) values ('"+Customer_id+"','"+Category_id+"','"+Stock_id+"','"+Quantity+"','"+specified+"','"+old_Debt+"','0','0','"+new_balance+"')";
                            try{
                                pst = connect.prepareStatement(query);
                                pst.execute();
                                int new_quantity = available-Quantity;
                                String query4 = "update stock set Quantity='"+new_quantity+"'  where id =" + Stock_id;
                                try{
                                    pst = connect.prepareStatement(query4);
                                    pst.execute();
                                    if(new_balance == 0){
                                        new_status="clean";
                                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                        try{
                                            pst = connect.prepareStatement(query5);
                                            pst.execute();
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    else if(new_balance > 0){
                                        new_status="credit";
                                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                        try{
                                            pst = connect.prepareStatement(query5);
                                            pst.execute();
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    else if(new_balance < 0 && new_balance >= -100){
                                        new_status="fined";
                                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                        try{
                                            pst = connect.prepareStatement(query5);
                                            pst.execute();
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    else if(new_balance < -100){
                                        new_status="no delivery";
                                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                        try{
                                            pst = connect.prepareStatement(query5);
                                            pst.execute();
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }catch (SQLException ex) {
                                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            }
                            else if(additionRadioButton.isSelected() && !specifyOrderDate.getText().equals("Otherwise specify the order date(YYYY-MM-DD)...")){
                                 JOptionPane.showMessageDialog(this,"Kindly select a specific order date","Error",JOptionPane.INFORMATION_MESSAGE,icon);
                            }
                             else {
                              String query = "Insert into orders(Customer_id,Category_id,Stock_id,Quantity,Late_Order,Debt,Mpesa,Cash,Balance) values ('"+Customer_id+"','"+Category_id+"','"+Stock_id+"','"+Quantity+"',CURRENT_DATE() + INTERVAL 1 DAY,'"+old_Debt+"','0','0','"+new_balance+"')";
                            try{
                                pst = connect.prepareStatement(query);
                                pst.execute();
                                int new_quantity = available-Quantity;
                                String query4 = "update stock set Quantity='"+new_quantity+"'  where id =" + Stock_id;
                                try{
                                    pst = connect.prepareStatement(query4);
                                    pst.execute();
                                    if(new_balance == 0){
                                        new_status="clean";
                                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                        try{
                                            pst = connect.prepareStatement(query5);
                                            pst.execute();
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    else if(new_balance > 0){
                                        new_status="credit";
                                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                        try{
                                            pst = connect.prepareStatement(query5);
                                            pst.execute();
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    else if(new_balance < 0 && new_balance >= -100){
                                        new_status="fined";
                                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                        try{
                                            pst = connect.prepareStatement(query5);
                                            pst.execute();
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    else if(new_balance < -100){
                                        new_status="no delivery";
                                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                        try{
                                            pst = connect.prepareStatement(query5);
                                            pst.execute();
                                        }catch (SQLException ex) {
                                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }catch (SQLException ex) {
                                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            }
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if(n == 0)
                    {
                        pst = connect.prepareStatement(query2);
                        rs=pst.executeQuery();
                        rs.next();
                        int Category_id = rs.getInt("Category_id");
                        int available = rs.getInt("Quantity");
                        double new_Debt = 0-Cost;
                        double new_balance = new_Debt;
                        if(additionRadioButton.isSelected() && specifyOrderDate.getText().equals("Otherwise specify the order date(YYYY-MM-DD)...")){
                        String query = "Insert into orders(Customer_id,Category_id,Stock_id,Quantity,Late_Order,Debt,Mpesa,Cash,Balance) values ('"+Customer_id+"','"+Category_id+"','"+Stock_id+"','"+Quantity+"',CURRENT_DATE(),'0','0','0','"+new_balance+"')";
                        try{
                            pst = connect.prepareStatement(query);
                            pst.execute();
                            int new_quantity = available-Quantity;
                            String query4 = "update stock set Quantity='"+new_quantity+"'  where id =" + Stock_id;
                            try{
                                pst = connect.prepareStatement(query4);
                                pst.execute();
                                if(new_balance == 0){
                                    new_status="clean";
                                    String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                    try{
                                        pst = connect.prepareStatement(query5);
                                        pst.execute();
                                    }catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                else if(new_balance > 0){
                                    new_status="credit";
                                    String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                    try{
                                        pst = connect.prepareStatement(query5);
                                        pst.execute();
                                    }catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                else if(new_balance < 0 && new_balance >= -100){
                                    new_status="fined";
                                    String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                    try{
                                        pst = connect.prepareStatement(query5);
                                        pst.execute();
                                    }catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                else if(new_balance < -100){
                                    new_status="no delivery";
                                    String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                    try{
                                        pst = connect.prepareStatement(query5);
                                        pst.execute();
                                    }catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                        else if (!additionRadioButton.isSelected() && !specifyOrderDate.getText().equals("Otherwise specify the order date(YYYY-MM-DD)...")){
                            String specified = specifyOrderDate.getText();
                           String query = "Insert into orders(Customer_id,Category_id,Stock_id,Quantity,Late_Order,Debt,Mpesa,Cash,Balance) values ('"+Customer_id+"','"+Category_id+"','"+Stock_id+"','"+Quantity+"','"+specified+"','0','0','0','"+new_balance+"')";
                        try{
                            pst = connect.prepareStatement(query);
                            pst.execute();
                            int new_quantity = available-Quantity;
                            String query4 = "update stock set Quantity='"+new_quantity+"'  where id =" + Stock_id;
                            try{
                                pst = connect.prepareStatement(query4);
                                pst.execute();
                                if(new_balance == 0){
                                    new_status="clean";
                                    String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                    try{
                                        pst = connect.prepareStatement(query5);
                                        pst.execute();
                                    }catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                else if(new_balance > 0){
                                    new_status="credit";
                                    String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                    try{
                                        pst = connect.prepareStatement(query5);
                                        pst.execute();
                                    }catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                else if(new_balance < 0 && new_balance >= -100){
                                    new_status="fined";
                                    String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                    try{
                                        pst = connect.prepareStatement(query5);
                                        pst.execute();
                                    }catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                else if(new_balance < -100){
                                    new_status="no delivery";
                                    String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                    try{
                                        pst = connect.prepareStatement(query5);
                                        pst.execute();
                                    }catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                        }
                         else if(additionRadioButton.isSelected() && !specifyOrderDate.getText().equals("Otherwise specify the order date(YYYY-MM-DD)...")){
                                 JOptionPane.showMessageDialog(this,"Kindly select a specific order date","Error",JOptionPane.INFORMATION_MESSAGE,icon);
                            }
                        else
                        {
                            String query = "Insert into orders(Customer_id,Category_id,Stock_id,Quantity,Late_Order,Debt,Mpesa,Cash,Balance) values ('"+Customer_id+"','"+Category_id+"','"+Stock_id+"','"+Quantity+"',CURRENT_DATE() + INTERVAL 1 DAY,'0','0','0','"+new_balance+"')";
                        try{
                            pst = connect.prepareStatement(query);
                            pst.execute();
                            int new_quantity = available-Quantity;
                            String query4 = "update stock set Quantity='"+new_quantity+"'  where id =" + Stock_id;
                            try{
                                pst = connect.prepareStatement(query4);
                                pst.execute();
                                if(new_balance == 0){
                                    new_status="clean";
                                    String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                    try{
                                        pst = connect.prepareStatement(query5);
                                        pst.execute();
                                    }catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                else if(new_balance > 0){
                                    new_status="credit";
                                    String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                    try{
                                        pst = connect.prepareStatement(query5);
                                        pst.execute();
                                    }catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                else if(new_balance < 0 && new_balance >= -100){
                                    new_status="fined";
                                    String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                    try{
                                        pst = connect.prepareStatement(query5);
                                        pst.execute();
                                    }catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                else if(new_balance < -100){
                                    new_status="no delivery";
                                    String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                                    try{
                                        pst = connect.prepareStatement(query5);
                                        pst.execute();
                                    }catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ordersAccess();
            JOptionPane.showMessageDialog(this, "Order Complete.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
            DefaultTableModel tm=(DefaultTableModel)newOrderDetailsTable.getModel();
            tm.setRowCount(0);
            DefaultTableModel tm2=(DefaultTableModel)newOrderTable.getModel();
            tm2.setRowCount(0);
            DefaultTableModel tm3=(DefaultTableModel)newOrderCartTable.getModel();
            tm3.setRowCount(0);
            newOrderSearchName.setText("Search Customer by name...");
            newOrderSearchStock.setText("Search Stock by Category...");
            totalReadText.setText("");
            additionRadioButton.setSelected(false);
            specifyOrderDate.setText("Otherwise specify the order date(YYYY-MM-DD)...");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    try {
        ordersQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        ordersQuery1();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        ordersQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_completeOrderButtonActionPerformed

    private void deleteCartItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCartItemButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) newOrderCartTable.getModel();
        try{
            int SelectedRowIndex = newOrderCartTable.getSelectedRow();
            model.removeRow(SelectedRowIndex);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Select item to delete","Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        getTotals();
    }//GEN-LAST:event_deleteCartItemButtonActionPerformed

    private void stockSearchName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockSearchName1ActionPerformed
        String searched = stockSearchName1.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select * from stock INNER JOIN category ON stock.Category_id=category.id where Name LIKE '%"+searched+"%'";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)stockTable1.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("id"),
                    rs.getString("Category_Name"),
                    rs.getString("Name"),
                    rs.getString("Price"),
                    rs.getString("Quantity")};
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_stockSearchName1ActionPerformed

    private void showAllStockButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllStockButton1ActionPerformed
        ArrayList stocks1 = null;
    try {
        stocks1 = stockQuery1.stockQuery1();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(stocks1.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Stock Available","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)stockTable1.getModel();

            tm.setRowCount(0);
            for(int i=0; i<stocks1.size(); i++)
            {
                Object o[] = (Object[])stocks1.get(i);
                tm.addRow(o);
            }
        }
    }//GEN-LAST:event_showAllStockButton1ActionPerformed

    private void stockSearchCategory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockSearchCategory1ActionPerformed
        String searched = stockSearchCategory1.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select * from stock INNER JOIN category ON stock.Category_id=category.id where Category_Name LIKE '%"+searched+"%'";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)stockTable1.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("id"),
                    rs.getString("Category_Name"),
                    rs.getString("Name"),
                    rs.getString("Price"),
                    rs.getString("Quantity")};
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_stockSearchCategory1ActionPerformed

    private void ordersSearchNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchNameFocusGained
       if(ordersSearchName.getText().equals("Search by name...")){
            ordersSearchName.setText("");
        }
        ordersSearchName.setForeground(Color.BLACK);
        ordersSearchName.setBackground(Color.WHITE);
    }//GEN-LAST:event_ordersSearchNameFocusGained

    private void ordersSearchNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchNameFocusLost
        if(ordersSearchName.getText().equals("")){
            ordersSearchName.setText("Search by name...");
        }
        ordersSearchName.setForeground(new Color(102,102,102));
        ordersSearchName.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_ordersSearchNameFocusLost

    private void ordersSearchDelivererFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchDelivererFocusGained
       if(ordersSearchDeliverer.getText().equals("Search by deliverer...")){
            ordersSearchDeliverer.setText("");
        }
        ordersSearchDeliverer.setForeground(Color.BLACK);
        ordersSearchDeliverer.setBackground(Color.WHITE);
    }//GEN-LAST:event_ordersSearchDelivererFocusGained

    private void ordersSearchDelivererFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchDelivererFocusLost
       if(ordersSearchDeliverer.getText().equals("")){
            ordersSearchDeliverer.setText("Search by deliverer...");
        }
        ordersSearchDeliverer.setForeground(new Color(102,102,102));
        ordersSearchDeliverer.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_ordersSearchDelivererFocusLost

    private void ordersSearchDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchDateFocusGained
        if(ordersSearchDate.getText().equals("Search by date...(YYYY-MM-DD)")){
            ordersSearchDate.setText("");
        }
        ordersSearchDate.setForeground(Color.BLACK);
        ordersSearchDate.setBackground(Color.WHITE);
    }//GEN-LAST:event_ordersSearchDateFocusGained

    private void ordersSearchDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchDateFocusLost
       if(ordersSearchDate.getText().equals("")){
            ordersSearchDate.setText("Search by date...(YYYY-MM-DD)");
        }
        ordersSearchDate.setForeground(new Color(102,102,102));
        ordersSearchDate.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_ordersSearchDateFocusLost

    private void ordersSearchName1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchName1FocusGained
       if(ordersSearchName1.getText().equals("Search by name...")){
            ordersSearchName1.setText("");
        }
        ordersSearchName1.setForeground(Color.BLACK);
        ordersSearchName1.setBackground(Color.WHITE);
    }//GEN-LAST:event_ordersSearchName1FocusGained

    private void ordersSearchName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchName1FocusLost
        if(ordersSearchName1.getText().equals("")){
            ordersSearchName1.setText("Search by name...");
        }
        ordersSearchName1.setForeground(new Color(102,102,102));
        ordersSearchName1.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_ordersSearchName1FocusLost

    private void ordersSearchDeliverer1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchDeliverer1FocusGained
       if(ordersSearchDeliverer1.getText().equals("Search by deliverer...")){
            ordersSearchDeliverer1.setText("");
        }
        ordersSearchDeliverer1.setForeground(Color.BLACK);
        ordersSearchDeliverer1.setBackground(Color.WHITE);
    }//GEN-LAST:event_ordersSearchDeliverer1FocusGained

    private void ordersSearchDeliverer1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchDeliverer1FocusLost
        if(ordersSearchDeliverer1.getText().equals("")){
            ordersSearchDeliverer1.setText("Search by deliverer...");
        }
        ordersSearchDeliverer1.setForeground(new Color(102,102,102));
        ordersSearchDeliverer1.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_ordersSearchDeliverer1FocusLost

    private void ordersSearchDate1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchDate1FocusGained
       if(ordersSearchDate1.getText().equals("Search by date...(YYYY-MM-DD)")){
            ordersSearchDate1.setText("");
        }
        ordersSearchDate1.setForeground(Color.BLACK);
        ordersSearchDate1.setBackground(Color.WHITE);
    }//GEN-LAST:event_ordersSearchDate1FocusGained

    private void ordersSearchDate1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchDate1FocusLost
        if(ordersSearchDate1.getText().equals("")){
            ordersSearchDate1.setText("Search by date...(YYYY-MM-DD)");
        }
        ordersSearchDate1.setForeground(new Color(102,102,102));
        ordersSearchDate1.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_ordersSearchDate1FocusLost

    private void newOrderSearchNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newOrderSearchNameFocusGained
        if(newOrderSearchName.getText().equals("Search Customer by name...")){
            newOrderSearchName.setText("");
        }
        newOrderSearchName.setForeground(Color.BLACK);
        newOrderSearchName.setBackground(Color.WHITE);
    }//GEN-LAST:event_newOrderSearchNameFocusGained

    private void newOrderSearchNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newOrderSearchNameFocusLost
        if(newOrderSearchName.getText().equals("")){
            newOrderSearchName.setText("Search Customer by name...");
        }
        newOrderSearchName.setForeground(new Color(102,102,102));
        newOrderSearchName.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_newOrderSearchNameFocusLost

    private void newOrderSearchStockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newOrderSearchStockFocusGained
       if(newOrderSearchStock.getText().equals("Search Stock by Category...")){
            newOrderSearchStock.setText("");
        }
        newOrderSearchStock.setForeground(Color.BLACK);
        newOrderSearchStock.setBackground(Color.WHITE);
    }//GEN-LAST:event_newOrderSearchStockFocusGained

    private void newOrderSearchStockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newOrderSearchStockFocusLost
         if(newOrderSearchStock.getText().equals("")){
            newOrderSearchStock.setText("Search Stock by Category...");
        }
        newOrderSearchStock.setForeground(new Color(102,102,102));
        newOrderSearchStock.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_newOrderSearchStockFocusLost

    private void stockSearchName1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockSearchName1FocusGained
       if(stockSearchName1.getText().equals("Search by name...")){
            stockSearchName1.setText("");
        }
        stockSearchName1.setForeground(Color.BLACK);
        stockSearchName1.setBackground(Color.WHITE);
    }//GEN-LAST:event_stockSearchName1FocusGained

    private void stockSearchName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockSearchName1FocusLost
        if(stockSearchName1.getText().equals("")){
            stockSearchName1.setText("Search by name...");
        }
        stockSearchName1.setForeground(new Color(102,102,102));
        stockSearchName1.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_stockSearchName1FocusLost

    private void stockSearchCategory1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockSearchCategory1FocusGained
       if(stockSearchCategory1.getText().equals("Search by category...")){
            stockSearchCategory1.setText("");
        }
        stockSearchCategory1.setForeground(Color.BLACK);
        stockSearchCategory1.setBackground(Color.WHITE);
    }//GEN-LAST:event_stockSearchCategory1FocusGained

    private void stockSearchCategory1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockSearchCategory1FocusLost
        if(stockSearchCategory1.getText().equals("")){
            stockSearchCategory1.setText("Search by category...");
        }
        stockSearchCategory1.setForeground(new Color(102,102,102));
        stockSearchCategory1.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_stockSearchCategory1FocusLost

    private void categoryDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryDeleteButtonActionPerformed
        int row = categoriesTable.getSelectedRow();
        Connection connect = databaseConnection.connection();
        String cell = categoriesTable.getModel().getValueAt(row, 0).toString();
        String sql = "Delete from category where id =" + cell;
        try{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Delete Selected Category?","Delete",dialogButton,JOptionPane.INFORMATION_MESSAGE,icon);
            if(dialogResult == JOptionPane.YES_OPTION){               
                pst = connect.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Category Deleted.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
            }
            else{
             ArrayList categories1 = categories.categoriesQuery();
        if(categories1.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Category Avaliable","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)categoriesTable.getModel();

            tm.setRowCount(0);
            for(int i=0; i<categories1.size(); i++)
            {
                Object o[] = (Object[])categories1.get(i);
                tm.addRow(o);
            }
        }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        ArrayList categories1 = null;
    try {
        categories1 = categories.categoriesQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(categories1.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Category Avaliable","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)categoriesTable.getModel();

            tm.setRowCount(0);
            for(int i=0; i<categories1.size(); i++)
            {
                Object o[] = (Object[])categories1.get(i);
                tm.addRow(o);
            }
        }
    }//GEN-LAST:event_categoryDeleteButtonActionPerformed

    private void categoriesAddTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categoriesAddTextFieldFocusGained
        if(categoriesAddTextField.getText().equals("Add New Category...")){
            categoriesAddTextField.setText("");
        }
        categoriesAddTextField.setForeground(Color.BLACK);
        categoriesAddTextField.setBackground(Color.WHITE);
    }//GEN-LAST:event_categoriesAddTextFieldFocusGained

    private void categoriesAddTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categoriesAddTextFieldFocusLost
        if(categoriesAddTextField.getText().equals("")){
            categoriesAddTextField.setText("Add New Category...");
        }
        categoriesAddTextField.setForeground(new Color(102,102,102));
        categoriesAddTextField.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_categoriesAddTextFieldFocusLost

    private void categoriesAddTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriesAddTextFieldActionPerformed
        Connection connect = databaseConnection.connection();
        try{
            String query = "INSERT INTO `category`(`Category_Name`) VALUES (?)";           
            pst = connect.prepareStatement(query);
            pst.setString(1,categoriesAddTextField.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Category Added.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
             categoriesAddTextField.setText("Add New Category...");
             categoriesAddTextField.setForeground(new Color(102,102,102));
             categoriesAddTextField.setBackground(new Color(232,228,228));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        ArrayList categories1 = null;
    try {
        categories1 = categories.categoriesQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(categories1.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Category Avaliable","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)categoriesTable.getModel();

            tm.setRowCount(0);
            for(int i=0; i<categories1.size(); i++)
            {
                Object o[] = (Object[])categories1.get(i);
                tm.addRow(o);
            }
        }
    }//GEN-LAST:event_categoriesAddTextFieldActionPerformed

    private void categorySaveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySaveChangesButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel)categoriesTable.getModel();
        int selectedRowIndex = categoriesTable.getSelectedRow();
        int row = categoriesTable.getSelectedRow();
        String cell = categoriesTable.getModel().getValueAt(row, 0).toString();
        String name = model.getValueAt(selectedRowIndex, 1).toString();
        Connection connect = databaseConnection.connection();
        String sql = "update category set Category_Name = '"+name+"' where id =" + cell;
        try{
            pst = connect.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Category Updated.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
       ArrayList categories1 = null;
    try {
        categories1 = categories.categoriesQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(categories1.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Category Avaliable","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)categoriesTable.getModel();

            tm.setRowCount(0);
            for(int i=0; i<categories1.size(); i++)
            {
                Object o[] = (Object[])categories1.get(i);
                tm.addRow(o);
            }
        }
    }//GEN-LAST:event_categorySaveChangesButtonActionPerformed

    private void categoriesButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriesButton1ActionPerformed
        switchButton(categoriesBackButton1);
        switchPanel(categoriesPanel1);
        switchBar(sideBar);
        sideBarColor2();
        ArrayList categories2 = null;
    try {
        categories2 = categories1.categoriesQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(categories2.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Category Avaliable","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)categoriesTable1.getModel();

            tm.setRowCount(0);
            for(int i=0; i<categories2.size(); i++)
            {
                Object o[] = (Object[])categories2.get(i);
                tm.addRow(o);
            }
        }
    }//GEN-LAST:event_categoriesButton1ActionPerformed

    private void categoriesBackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriesBackButton1ActionPerformed
    try {
        stockAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_categoriesBackButton1ActionPerformed

    private void categoriesBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriesBackButtonActionPerformed
    try {
        stockAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_categoriesBackButtonActionPerformed

    private void ordersFineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersFineButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel)ordersTable.getModel();
        int selectedRowIndex = ordersTable.getSelectedRow();
        int row = ordersTable.getSelectedRow();
        String cell = ordersTable.getModel().getValueAt(row, 0).toString();
        String id = model.getValueAt(selectedRowIndex, 0).toString();
        String name = model.getValueAt(selectedRowIndex, 1).toString();
        double fined = Double.parseDouble(model.getValueAt(selectedRowIndex, 9).toString());
        Double balance = Double.parseDouble(model.getValueAt(selectedRowIndex, 10).toString());
        double fine;
        Connection connect = databaseConnection.connection();
        int Customer_id;
        String new_status;
         String sql5 = "select DATE(orders.Created_at) as 'day' from orders where id="+cell;
        try{
            pst = connect.prepareStatement(sql5);
                    rs = pst.executeQuery();
                    while(rs.next()){;
                    String date = rs.getString("day"); 
        String sql3 = "SELECT EXISTS(SELECT * FROM orders INNER JOIN customers ON orders.Customer_id = customers.id where customers.Name='"+name+"' && orders.Fine<'0' && DATE(orders.Created_at) = '"+date+"' );";
        try{
            pst = connect.prepareStatement(sql3);
            rs=pst.executeQuery();
            int n = 0;
            if ( rs.next() ) {
                n = rs.getInt(1);
            }
            if ( n == 0 ) 
            {
        int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Fine selected Customer?","Delete",dialogButton,JOptionPane.INFORMATION_MESSAGE,icon);
            if(dialogResult == JOptionPane.YES_OPTION){
             String sql4 = "select * from orders where orders.id="+id;
        try{
            pst = connect.prepareStatement(sql4);
                    rs = pst.executeQuery();
                    while(rs.next()){;
                    int customer_id = rs.getInt("orders.Customer_id");                  
         if ( balance > -500 && balance <0 )
                    {
                        fine = 0.1 * balance;
                        String sql = "update orders set Balance = Balance+"+fine+", Fine = '"+fine+"' where id =" + cell;
                        try{           
                        pst3 = connect.prepareStatement(sql);
                        pst3.execute();
                        JOptionPane.showMessageDialog(this, "Customer Fined.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
                        String sql6 = "update orders set Debt= Debt+"+fine+", Balance= Balance+"+fine+" where Customer_id="+customer_id+" and id >" + cell;
                        try{           
                      pst = connect.prepareStatement(sql6);
                       pst.execute();
                       }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
                }
                 } 
              if( balance <= -500)
                    {
                        fine = -100.0;
                        String sql = "update orders set Balance = Balance+"+fine+", Fine = '"+fine+"' where id =" + cell;
                        try{           
                        pst3 = connect.prepareStatement(sql);
                        pst3.execute();
                        JOptionPane.showMessageDialog(this, "Customer Fined.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
                        String sql7 = "update orders set Debt= Debt+"+fine+", Balance= Balance+"+fine+" where Customer_id="+customer_id+" and id >" + cell;
                        try{           
                      pst = connect.prepareStatement(sql7);
                       pst.execute();
                       }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
                }
                    } 
              if ( balance >= 0 )
              {
                  JOptionPane.showMessageDialog(this,"The selected customer has no balance to fine.","Error",JOptionPane.INFORMATION_MESSAGE,icon);
              }
              String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id  WHERE orders.id IN (SELECT MAX(orders.id)FROM orders INNER JOIN customers ON orders.Customer_id=customers.id where customers.id='"+customer_id+"' );";
            try {               
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                while(rs.next()){
                    Customer_id = rs.getInt("customers.id");
                    double new_balance = rs.getDouble("orders.Balance");
                    if(new_balance == 0){
                        new_status="clean";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                         
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(new_balance > 0){
                        new_status="credit";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                           
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(new_balance < 0 && new_balance >= -100){
                        new_status="fined";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                           
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(new_balance < -100){
                        new_status="no delivery";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                           
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                  }                    
               }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
             else{
                ordersQuery();
            }
        }
        if ( n > 0 ) 
        {
            JOptionPane.showMessageDialog(this, "The selected Customer has already been fined.","Error",JOptionPane.INFORMATION_MESSAGE,icon);
        }
            }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
         }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    try {
        ordersQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_ordersFineButtonActionPerformed

    private void returnedGoodsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnedGoodsButtonActionPerformed
        switchButton(returnedGoodsBackButton);
        switchPanel(returnedGoodsPanel);
        switchBar(sideBar);
        sideBarColor3();
        ArrayList returns = null;
    try {
        returns = returned.returnedQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(returns.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Returned goods","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)returnedGoodsTable.getModel();

            tm.setRowCount(0);
            for(int i=0; i<returns.size(); i++)
            {
                Object o[] = (Object[])returns.get(i);
                tm.addRow(o);
            }
        }
        
    }//GEN-LAST:event_returnedGoodsButtonActionPerformed

    private void returnedGoodsBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnedGoodsBackButtonActionPerformed
    try {
        ordersAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_returnedGoodsBackButtonActionPerformed

    private void ordersSearchName3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchName3FocusGained
        if(ordersSearchName3.getText().equals("Search by name...")){
            ordersSearchName3.setText("");
        }
        ordersSearchName3.setForeground(Color.BLACK);
        ordersSearchName3.setBackground(Color.WHITE);
    }//GEN-LAST:event_ordersSearchName3FocusGained

    private void ordersSearchName3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchName3FocusLost
        if(ordersSearchName3.getText().equals("")){
            ordersSearchName3.setText("Search by name...");
        }
        ordersSearchName3.setForeground(new Color(102,102,102));
        ordersSearchName3.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_ordersSearchName3FocusLost

    private void ordersSearchName3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersSearchName3ActionPerformed
        String searched = ordersSearchName3.getText();
        double price;
        int quantity;
        double cost;
        String delivery;
        Connection connect = databaseConnection.connection();
       // String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where customers.Name LIKE '"+searched+"%' AND DATE(orders.Created_at) = CURRENT_DATE()";
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where customers.Name LIKE '%"+searched+"%' order by orders.id ";
        try {            
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable3.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                cost=price*quantity;
                delivery = rs.getString("orders.Late_Order");
                Object o[]={rs.getInt("id"),
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost,
                    rs.getString("Debt"),
                    rs.getString("Mpesa"),
                    rs.getString("Cash"),
                    rs.getDouble("Fine"),
                    rs.getString("Balance"),
                    delivery,
                    rs.getInt("Returned"),
                    rs.getString("Banked"),
                    rs.getString("Slip_Number"),
                    rs.getString("Banked_By")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_ordersSearchName3ActionPerformed

    private void addOrderButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderButton3ActionPerformed
        switchButton(addOrderBackButton);
        switchPanel(addOrderPanel);
        switchBar(sideBar);
        sideBarColor3();
    }//GEN-LAST:event_addOrderButton3ActionPerformed

    private void ordersSaveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersSaveButton1ActionPerformed
        String new_status;
        int Customer_id;
        DefaultTableModel model = (DefaultTableModel)ordersTable3.getModel();
        int selectedRowIndex = ordersTable3.getSelectedRow();
        int row = ordersTable3.getSelectedRow();
        Connection connect = databaseConnection.connection();
        String cell = ordersTable3.getModel().getValueAt(row, 0).toString();
       // double cost = Double.parseDouble(model.getValueAt(selectedRowIndex, 5).toString());
        double debt = Double.parseDouble(model.getValueAt(selectedRowIndex, 6).toString());
        int quantity = Integer.parseInt(model.getValueAt(selectedRowIndex, 4).toString());
        double Mpesa = Double.parseDouble(model.getValueAt(selectedRowIndex, 7).toString());
        double Cash = Double.parseDouble(model.getValueAt(selectedRowIndex, 8).toString());
        double Fine = Double.parseDouble(model.getValueAt(selectedRowIndex, 9).toString());
        double Balance = Double.parseDouble(model.getValueAt(selectedRowIndex,10).toString());
        String Banked = model.getValueAt(selectedRowIndex, 13).toString();
        String Slip = model.getValueAt(selectedRowIndex, 14).toString();
        String Banker = model.getValueAt(selectedRowIndex, 15).toString();
        //double new_balance = (Mpesa+Cash)+Balance;
        String update0 = "select * from orders INNER JOIN stock ON orders.Stock_id=stock.id where orders.id="+cell;
        try {               
                pst = connect.prepareStatement(update0);
                rs=pst.executeQuery();
                while(rs.next()){
                    double price=rs.getDouble("stock.price");
                    double old_quantity=rs.getDouble("orders.Quantity");
                    int stock_id = rs.getInt("stock.id");
                    double cost = price*quantity;
        double new_balance = debt-cost+Mpesa+Cash+Fine;
        String update = "select * from orders where orders.id="+cell;
        try {               
                pst = connect.prepareStatement(update);
                rs=pst.executeQuery();
                while(rs.next()){
                    Double old_balance = rs.getDouble("Balance");
        String sql = "update orders set Quantity='"+quantity+"', Mpesa='"+Mpesa+"', Cash='"+Cash+"',Balance='"+new_balance+"', Banked='"+Banked+"' , Slip_Number='"+Slip+"', Banked_By='"+Banker+"' where id =" + cell;
        try{           
            pst = connect.prepareStatement(sql);
            pst.execute();
        try {               
                pst = connect.prepareStatement(update);
                rs=pst.executeQuery();
                while(rs.next()){
                    double newest_balance = rs.getDouble("Balance");
                    int customer_id = rs.getInt("Customer_id");
                    double new_quantity=rs.getDouble("Quantity");
                    double returned = old_quantity - new_quantity;
                    String new_qty = "update stock set Quantity= Quantity +"+returned+"  where id =" +stock_id;
                        try{                           
                            pst2 = connect.prepareStatement(new_qty);
                            pst2.execute();
                    String sql10 = "update orders set Returned= Returned +"+returned+"  where id =" +cell;
                    if (old_quantity > new_quantity )
                    {
                    try{                           
                            pst2 = connect.prepareStatement(sql10);
                            pst2.execute();
                            }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }    
                    double difference = old_balance - newest_balance;
                    String sql2 = "update orders set Debt= Debt-"+difference+", Balance= Balance-"+difference+" where Customer_id="+customer_id+" and id >" + cell;
                    //the status to be updated on checking last cell of orders of that customer
                    try{           
                      pst = connect.prepareStatement(sql2);
                       pst.execute();
            String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id  WHERE orders.id IN (SELECT MAX(orders.id)FROM orders INNER JOIN customers ON orders.Customer_id=customers.id where customers.id='"+customer_id+"' );";
            try {               
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                while(rs.next()){
                    Customer_id = rs.getInt("customers.id");
                    if(new_balance == 0){
                        new_status="clean";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                         
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(new_balance > 0){
                        new_status="credit";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                           
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(new_balance < 0 && new_balance >= -100){
                        new_status="fined";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                           
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(new_balance < -100){
                        new_status="no delivery";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                           
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
             }catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
            }catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Order Updated.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
            }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
         }
            }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    try {
        ordersQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_ordersSaveButton1ActionPerformed

    private void showAllOrdersButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllOrdersButton3ActionPerformed
    try {
        ordersQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_showAllOrdersButton3ActionPerformed

    private void ordersSearchDeliverer3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchDeliverer3FocusGained
        if(ordersSearchDeliverer3.getText().equals("Search by deliverer...")){
            ordersSearchDeliverer3.setText("");
        }
        ordersSearchDeliverer3.setForeground(Color.BLACK);
        ordersSearchDeliverer3.setBackground(Color.WHITE);
    }//GEN-LAST:event_ordersSearchDeliverer3FocusGained

    private void ordersSearchDeliverer3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchDeliverer3FocusLost
         if(ordersSearchDeliverer3.getText().equals("")){
            ordersSearchDeliverer3.setText("Search by deliverer...");
        }
        ordersSearchDeliverer3.setForeground(new Color(102,102,102));
        ordersSearchDeliverer3.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_ordersSearchDeliverer3FocusLost

    private void ordersSearchDeliverer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersSearchDeliverer3ActionPerformed
        String searched = ordersSearchDeliverer3.getText();
        double price;
        int quantity;
        double cost;
        String delivery;
        Connection connect = databaseConnection.connection();
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where customers.Deliverer LIKE '%"+searched+"%' AND DATE(orders.Created_at) = CURRENT_DATE() order by orders.id";
        try {          
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable3.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                cost=price*quantity;
                delivery = rs.getString("orders.Late_Order");
                Object o[]={rs.getInt("id"),
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost,
                    rs.getString("Debt"),
                    rs.getString("Mpesa"),
                    rs.getString("Cash"),
                    rs.getDouble("Fine"),
                    rs.getString("Balance"),
                    delivery,
                    rs.getInt("Returned"),
                    rs.getString("Banked"),       
                    rs.getString("Slip_Number"),
                    rs.getString("Banked_By")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_ordersSearchDeliverer3ActionPerformed

    private void ordersSearchDate3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchDate3FocusGained
         if(ordersSearchDate3.getText().equals("Search by date...(YYYY-MM-DD)")){
            ordersSearchDate3.setText("");
        }
        ordersSearchDate3.setForeground(Color.BLACK);
        ordersSearchDate3.setBackground(Color.WHITE);
    }//GEN-LAST:event_ordersSearchDate3FocusGained

    private void ordersSearchDate3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ordersSearchDate3FocusLost
        if(ordersSearchDate3.getText().equals("")){
            ordersSearchDate3.setText("Search by date...(YYYY-MM-DD)");
        }
        ordersSearchDate3.setForeground(new Color(102,102,102));
        ordersSearchDate3.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_ordersSearchDate3FocusLost

    private void ordersSearchDate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersSearchDate3ActionPerformed
        String searched = ordersSearchDate3.getText();
        double price;
        int quantity;
        double cost;
        String delivery;
        Connection connect = databaseConnection.connection();
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where DATE(orders.Late_Order) LIKE '"+searched+"%' order by orders.id";
        try {           
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable3.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                cost=price*quantity;
                delivery = rs.getString("orders.Late_Order");
                Object o[]={rs.getInt("id"),
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost,
                    rs.getString("Debt"),
                    rs.getString("Mpesa"),
                    rs.getString("Cash"),
                    rs.getDouble("Fine"),
                    rs.getString("Balance"),
                    delivery,
                    rs.getInt("Returned"),
                    rs.getString("Banked"),
                    rs.getString("Slip_Number"),
                    rs.getString("Banked_By")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_ordersSearchDate3ActionPerformed

    private void ordersFineButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersFineButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel)ordersTable3.getModel();
        int selectedRowIndex = ordersTable3.getSelectedRow();
        int row = ordersTable3.getSelectedRow();
        String cell = ordersTable3.getModel().getValueAt(row, 0).toString();
        String id = model.getValueAt(selectedRowIndex, 0).toString();
        String name = model.getValueAt(selectedRowIndex, 1).toString();
        double fined = Double.parseDouble(model.getValueAt(selectedRowIndex, 9).toString());
        Double balance = Double.parseDouble(model.getValueAt(selectedRowIndex, 10).toString());
        double fine;
        int Customer_id;
        String new_status;
        Connection connect = databaseConnection.connection();
         String sql5 = "select DATE(orders.Created_at) as 'day' from orders where id="+cell;
        try{
            pst = connect.prepareStatement(sql5);
                    rs = pst.executeQuery();
                    while(rs.next()){;
                    String date = rs.getString("day"); 
        String sql3 = "SELECT EXISTS(SELECT * FROM orders INNER JOIN customers ON orders.Customer_id = customers.id where customers.Name='"+name+"' && orders.Fine<'0' && DATE(orders.Created_at) = '"+date+"' );";
        try{
            pst = connect.prepareStatement(sql3);
            rs=pst.executeQuery();
            int n = 0;
            if ( rs.next() ) {
                n = rs.getInt(1);
            }
            if ( n == 0 ) 
            {
        int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Fine selected Customer?","Delete",dialogButton,JOptionPane.INFORMATION_MESSAGE,icon);
            if(dialogResult == JOptionPane.YES_OPTION){
             String sql4 = "select * from orders where orders.id="+id;
        try{
            pst = connect.prepareStatement(sql4);
                    rs = pst.executeQuery();
                    while(rs.next()){;
                    int customer_id = rs.getInt("orders.Customer_id");                  
         if ( balance > -500 && balance < 0 )
                    {
                        fine = 0.1 * balance;
                        String sql = "update orders set Balance = Balance+"+fine+", Fine = '"+fine+"' where id =" + cell;
                        try{           
                        pst3 = connect.prepareStatement(sql);
                        pst3.execute();
                        JOptionPane.showMessageDialog(this, "Customer Fined.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
                        String sql6 = "update orders set Debt= Debt+"+fine+", Balance= Balance+"+fine+" where Customer_id="+customer_id+" and id >" + cell;
                        try{           
                      pst = connect.prepareStatement(sql6);
                       pst.execute();
                       }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
                }
                 } 
              if( balance <= -500)
                    {
                        fine = -100.0;
                        String sql = "update orders set Balance = Balance +"+fine+", Fine = '"+fine+"' where id =" + cell;
                        try{           
                        pst3 = connect.prepareStatement(sql);
                        pst3.execute();
                        JOptionPane.showMessageDialog(this, "Customer Fined.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
                        String sql7 = "update orders set Debt= Debt+"+fine+", Balance= Balance+"+fine+" where Customer_id="+customer_id+" and id >" + cell;
                        try{           
                      pst = connect.prepareStatement(sql7);
                       pst.execute();
                       }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
                }
                    } 
              if ( balance >= 0 )
              {
                  JOptionPane.showMessageDialog(this,"The selected customer has no balance to fine.","Error",JOptionPane.INFORMATION_MESSAGE,icon);
              }
              String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id  WHERE orders.id IN (SELECT MAX(orders.id)FROM orders INNER JOIN customers ON orders.Customer_id=customers.id where customers.id='"+customer_id+"' );";
            try {               
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                while(rs.next()){
                    Customer_id = rs.getInt("customers.id");
                    double new_balance = rs.getDouble("orders.Balance");
                    if(new_balance == 0){
                        new_status="clean";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                         
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(new_balance > 0){
                        new_status="credit";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                           
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(new_balance < 0 && new_balance >= -100){
                        new_status="fined";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                           
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(new_balance < -100){
                        new_status="no delivery";
                        String query5= "update customers set Status='"+new_status+"'  where id =" + Customer_id;
                        try{                           
                            pst = connect.prepareStatement(query5);
                            pst.execute();
                        }catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                  }                    
               }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
             else{
                ordersQuery();
            }
        }
        if ( n > 0 ) 
        {
            JOptionPane.showMessageDialog(this, "The selected Customer has already been fined.","Error",JOptionPane.INFORMATION_MESSAGE,icon);
        }
            }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
         }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    try {
        ordersQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_ordersFineButton1ActionPerformed

    private void returnedGoodsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnedGoodsButton1ActionPerformed
         switchButton(returnedGoodsBackButton);
        switchPanel(returnedGoodsPanel);
        switchBar(sideBar);
        sideBarColor3();
        ArrayList returns = null;
    try {
        returns = returned.returnedQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(returns.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Returned goods","Error",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)returnedGoodsTable.getModel();

            tm.setRowCount(0);
            for(int i=0; i<returns.size(); i++)
            {
                Object o[] = (Object[])returns.get(i);
                tm.addRow(o);
            }
        }
    }//GEN-LAST:event_returnedGoodsButton1ActionPerformed

    private void summarySideBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_summarySideBarMousePressed
    try {
        summaryAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_summarySideBarMousePressed

    private void orderSideBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderSideBarMousePressed
    try {
        ordersAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        ordersQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        ordersQuery1();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        ordersQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        ordersPrint.ordersPrinting();
    }//GEN-LAST:event_orderSideBarMousePressed

    private void stockSideBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockSideBarMousePressed
        ArrayList stocks1 = null;
    try {
        stocks1 = stockQuery1.stockQuery1();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(stocks1.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Stock","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)stockTable1.getModel();

            tm.setRowCount(0);
            for(int i=0; i<stocks1.size(); i++)
            {
                Object o[] = (Object[])stocks1.get(i);
                tm.addRow(o);
            }
        }
    try {
        stockAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        ArrayList stocks = null;
    try {
        stocks = stockQuery.stockQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(stocks.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Stock","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)stockTable.getModel();

            tm.setRowCount(0);
            for(int i=0; i<stocks.size(); i++)
            {
                Object o[] = (Object[])stocks.get(i);
                tm.addRow(o);
            }
        }
    }//GEN-LAST:event_stockSideBarMousePressed

    private void customerSideBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerSideBarMousePressed
    try {
        userAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        customers0.customersQuery0();
        ArrayList customer1 = null;
    try {
        customer1 = customers1.customersQuery1();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm=(DefaultTableModel)customersTable1.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer1.size(); i++)
            {
                Object o[] = (Object[])customer1.get(i);
                tm.addRow(o);
            }
         ArrayList customer2 = null;
    try {
        customer2 = customers2.customersQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm3=(DefaultTableModel)customersTable2.getModel();

            tm3.setRowCount(0);
            for(int i=0; i<customer2 .size(); i++)
            {
                Object o[] = (Object[])customer2 .get(i);
                tm3.addRow(o);
            }
        customers0.blacklistQuery0();
        ArrayList blacklist1 = null;
    try {
        blacklist1 = blackList1.blacklistQuery1();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm2=(DefaultTableModel)blackListedTable1.getModel();

            tm2.setRowCount(0);
            for(int i=0; i<blacklist1.size(); i++)
            {
                Object o[] = (Object[])blacklist1.get(i);
                tm2.addRow(o);
            }       
        ArrayList blackListed2 = null;
    try {
        blackListed2 = blackList2.blacklistQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm4=(DefaultTableModel)blackListedTable2.getModel();
            tm4.setRowCount(0);
            for(int i=0; i<blackListed2.size(); i++)
            {
                Object o[] = (Object[])blackListed2.get(i);
                tm4.addRow(o);
            }
            customersPrint.customerPrint();
    }//GEN-LAST:event_customerSideBarMousePressed

    private void addCustomerNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCustomerNumberTextFieldActionPerformed

    private void addCustomerSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerSaveButtonActionPerformed
        Connection connect = databaseConnection.connection();
        try{
            if(addCustomerNoteTextField.getText().equals(""))
            {
            String query = "INSERT INTO `customers`(`Name`, `Number`, `Deliverer`, `Location`) VALUES (?,?,?,?)";
            pst = connect.prepareStatement(query);
            pst.setString(1,addCustomerNameTextField.getText());
            pst.setString(2,addCustomerNumberTextField.getText());
            pst.setString(3,addCustomerDelivererTextField.getText());
            pst.setString(4,addCustomerLocationTextField.getText());
            pst.execute();
            }
            else
            {
                String query = "INSERT INTO `customers`(`Name`, `Number`, `Deliverer`, `Location`,`Note`) VALUES (?,?,?,?,?)";
            pst = connect.prepareStatement(query);
            pst.setString(1,addCustomerNameTextField.getText());
            pst.setString(2,addCustomerNumberTextField.getText());
            pst.setString(3,addCustomerDelivererTextField.getText());
            pst.setString(4,addCustomerLocationTextField.getText());
            pst.setString(5,addCustomerNoteTextField.getText());
            pst.execute();
            }
            userAccess();
            JOptionPane.showMessageDialog(this, "Customer Added.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
            addCustomerNameTextField.setText("");
            addCustomerNumberTextField.setText("");
            addCustomerDelivererTextField.setText("");
            addCustomerLocationTextField.setText("");
            addCustomerNoteTextField.setText("");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    try {
        userAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        ArrayList customer1 = null;
    try {
        customer1 = customers1.customersQuery1();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm=(DefaultTableModel)customersTable1.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer1.size(); i++)
            {
                Object o[] = (Object[])customer1.get(i);
                tm.addRow(o);
            }
         ArrayList customer2 = null;
    try {
        customer2 = customers2.customersQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm2=(DefaultTableModel)customersTable2.getModel();

            tm2.setRowCount(0);
            for(int i=0; i<customer2 .size(); i++)
            {
                Object o[] = (Object[])customer2 .get(i);
                tm2.addRow(o);
            }
    }//GEN-LAST:event_addCustomerSaveButtonActionPerformed

    private void addCustomerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerButton1ActionPerformed
        customerBack();
        switchPanel(addCustomerPanel);
        sideBar();
        sideBarColor1();
    }//GEN-LAST:event_addCustomerButton1ActionPerformed

    private void customerSearchDeliverer1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerSearchDeliverer1FocusGained
        if(customerSearchDeliverer1.getText().equals("Search by deliverer...")){
            customerSearchDeliverer1.setText("");
        }
        customerSearchDeliverer1.setForeground(Color.BLACK);
        customerSearchDeliverer1.setBackground(Color.WHITE);
    }//GEN-LAST:event_customerSearchDeliverer1FocusGained

    private void customerSearchDeliverer1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerSearchDeliverer1FocusLost
        if(customerSearchDeliverer1.getText().equals("")){
            customerSearchDeliverer1.setText("Search by deliverer...");
        }
        customerSearchDeliverer1.setForeground(new Color(102,102,102));
        customerSearchDeliverer1.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_customerSearchDeliverer1FocusLost

    private void customerSearchDeliverer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSearchDeliverer1ActionPerformed
        String searched = customerSearchDeliverer1.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select * from customers where Deliverer LIKE '%"+searched+"%'";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)customersTable1.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("id"),
                    rs.getString("Name"),
                    rs.getString("Number"),
                    rs.getString("Location"),
                    rs.getString("Deliverer"),
                    rs.getString("Status"),
                    rs.getString("Note")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_customerSearchDeliverer1ActionPerformed

    private void customerSearchName1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerSearchName1FocusGained
        if(customerSearchName1.getText().equals("Search by name...")){
            customerSearchName1.setText("");
        }
        customerSearchName1.setForeground(Color.BLACK);
        customerSearchName1.setBackground(Color.WHITE);
    }//GEN-LAST:event_customerSearchName1FocusGained

    private void customerSearchName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerSearchName1FocusLost
        if(customerSearchName1.getText().equals("")){
            customerSearchName1.setText("Search by name...");
        }
        customerSearchName1.setForeground(new Color(102,102,102));
        customerSearchName1.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_customerSearchName1FocusLost

    private void customerSearchName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSearchName1ActionPerformed
        String searched = customerSearchName1.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select * from customers where Name LIKE '%"+searched+"%'";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)customersTable1.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("id"),
                    rs.getString("Name"),
                    rs.getString("Number"),
                    rs.getString("Location"),
                    rs.getString("Deliverer"),
                    rs.getString("Status"),
                    rs.getString("Note")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_customerSearchName1ActionPerformed

    private void customersSaveChangesButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersSaveChangesButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel)customersTable1.getModel();
        int selectedRowIndex = customersTable1.getSelectedRow();
        int row = customersTable1.getSelectedRow();
        String cell = customersTable1.getModel().getValueAt(row, 0).toString();
        String name = model.getValueAt(selectedRowIndex, 1).toString();
        String number = model.getValueAt(selectedRowIndex, 2).toString();
        String location = model.getValueAt(selectedRowIndex, 3).toString();
        String deliverer = model.getValueAt(selectedRowIndex, 4).toString();
        String note = model.getValueAt(selectedRowIndex, 6).toString();
        Connection connect = databaseConnection.connection();
        String sql = "update customers set Name = '"+name+"', Number='"+number+"',Location='"+location+"',Deliverer='"+deliverer+"',Note='"+note+"' where id =" + cell;
        try{
            pst = connect.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Customer Updated.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        ArrayList customer1 = null;
    try {
        customer1 = customers1.customersQuery1();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm=(DefaultTableModel)customersTable1.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer1.size(); i++)
            {
                Object o[] = (Object[])customer1.get(i);
                tm.addRow(o);
            }
    }//GEN-LAST:event_customersSaveChangesButton1ActionPerformed

    private void showAllCustomersButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllCustomersButton1ActionPerformed
        ArrayList customer1 = null;
    try {
        customer1 = customers1.customersQuery1();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm=(DefaultTableModel)customersTable1.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer1.size(); i++)
            {
                Object o[] = (Object[])customer1.get(i);
                tm.addRow(o);
            }
    }//GEN-LAST:event_showAllCustomersButton1ActionPerformed

    private void customerSearchContact1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerSearchContact1FocusGained
        if(customerSearchContact1.getText().equals("Search by contact...")){
            customerSearchContact1.setText("");
        }
        customerSearchContact1.setForeground(Color.BLACK);
        customerSearchContact1.setBackground(Color.WHITE);
    }//GEN-LAST:event_customerSearchContact1FocusGained

    private void customerSearchContact1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerSearchContact1FocusLost
        if(customerSearchContact1.getText().equals("")){
            customerSearchContact1.setText("Search by contact...");
        }
        customerSearchContact1.setForeground(new Color(102,102,102));
        customerSearchContact1.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_customerSearchContact1FocusLost

    private void customerSearchContact1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSearchContact1ActionPerformed
        String searched = customerSearchContact1.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select * from customers where Number LIKE '%"+searched+"%'";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)customersTable1.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("id"),
                    rs.getString("Name"),
                    rs.getString("Number"),
                    rs.getString("Location"),
                    rs.getString("Deliverer"),
                    rs.getString("Status"),
                    rs.getString("Note")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_customerSearchContact1ActionPerformed

    private void customerSearchDeliverer2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerSearchDeliverer2FocusGained
        if(customerSearchDeliverer2.getText().equals("Search by deliverer...")){
            customerSearchDeliverer2.setText("");
        }
        customerSearchDeliverer2.setForeground(Color.BLACK);
        customerSearchDeliverer2.setBackground(Color.WHITE);
    }//GEN-LAST:event_customerSearchDeliverer2FocusGained

    private void customerSearchDeliverer2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerSearchDeliverer2FocusLost
        if(customerSearchDeliverer2.getText().equals("")){
            customerSearchDeliverer2.setText("Search by deliverer...");
        }
        customerSearchDeliverer2.setForeground(new Color(102,102,102));
        customerSearchDeliverer2.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_customerSearchDeliverer2FocusLost

    private void customerSearchDeliverer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSearchDeliverer2ActionPerformed
        String searched = customerSearchDeliverer2.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select * from customers where Deliverer LIKE '%"+searched+"%'";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("id"),
                    rs.getString("Name"),
                    rs.getString("Number"),
                    rs.getString("Location"),
                    rs.getString("Deliverer"),
                    rs.getString("Status")};
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_customerSearchDeliverer2ActionPerformed

    private void customerSearchName2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerSearchName2FocusGained
        if(customerSearchName2.getText().equals("Search by name...")){
            customerSearchName2.setText("");
        }
        customerSearchName2.setForeground(Color.BLACK);
        customerSearchName2.setBackground(Color.WHITE);
    }//GEN-LAST:event_customerSearchName2FocusGained

    private void customerSearchName2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerSearchName2FocusLost
        if(customerSearchName2.getText().equals("")){
            customerSearchName2.setText("Search by name...");
        }
        customerSearchName2.setForeground(new Color(102,102,102));
        customerSearchName2.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_customerSearchName2FocusLost

    private void customerSearchName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSearchName2ActionPerformed
        String searched = customerSearchName2.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select * from customers where Name LIKE '%"+searched+"%'";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("id"),
                    rs.getString("Name"),
                    rs.getString("Number"),
                    rs.getString("Location"),
                    rs.getString("Deliverer"),
                    rs.getString("Status")};
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_customerSearchName2ActionPerformed

    private void addCustomerButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerButton2ActionPerformed
        customerBack();
        switchPanel(addCustomerPanel);
        sideBar();
        sideBarColor1();
    }//GEN-LAST:event_addCustomerButton2ActionPerformed

    private void customersSaveChangesButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersSaveChangesButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel)customersTable2.getModel();
        Connection connect = databaseConnection.connection();
        int selectedRowIndex = customersTable2.getSelectedRow();
        int row = customersTable2.getSelectedRow();
        String cell = customersTable2.getModel().getValueAt(row, 0).toString();
        String name = model.getValueAt(selectedRowIndex, 1).toString();
        String number = model.getValueAt(selectedRowIndex, 2).toString();
        String location = model.getValueAt(selectedRowIndex, 3).toString();
        String deliverer = model.getValueAt(selectedRowIndex, 4).toString();
        String sql = "update customers set Name = '"+name+"', Number='"+number+"',Location='"+location+"',Deliverer='"+deliverer+"' where id =" + cell;
        try{
            pst = connect.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Customer Updated.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
         ArrayList customer2 = null;
    try {
        customer2 = customers2.customersQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer2 .size(); i++)
            {
                Object o[] = (Object[])customer2 .get(i);
                tm.addRow(o);
            }
    }//GEN-LAST:event_customersSaveChangesButton2ActionPerformed

    private void blacklistedSaveChangsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blacklistedSaveChangsButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel)blackListedTable2.getModel();
        int selectedRowIndex = blackListedTable2.getSelectedRow();
        int row = blackListedTable2.getSelectedRow();
        String cell = blackListedTable2.getModel().getValueAt(row, 0).toString();
        double paid = Double.parseDouble(model.getValueAt(selectedRowIndex, 4).toString());
        double balance = Double.parseDouble(model.getValueAt(selectedRowIndex, 5).toString());
        Connection connect = databaseConnection.connection();
        double new_balance = balance+paid;
        String sql = "update orders set Balance = '"+new_balance+"' where Customer_id =" + cell;
        try{
            pst = connect.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Balance Updated.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        ArrayList blackListed2 = null;
    try {
        blackListed2 = blackList2.blacklistQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm2=(DefaultTableModel)blackListedTable2.getModel();
            tm2.setRowCount(0);
            for(int i=0; i<blackListed2.size(); i++)
            {
                Object o[] = (Object[])blackListed2.get(i);
                tm2.addRow(o);
            }
    }//GEN-LAST:event_blacklistedSaveChangsButton1ActionPerformed

    private void showAllCustomersButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllCustomersButton2ActionPerformed
        ArrayList customer2 = null;
    try {
        customer2 = customers2.customersQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer2 .size(); i++)
            {
                Object o[] = (Object[])customer2 .get(i);
                tm.addRow(o);
            }
    }//GEN-LAST:event_showAllCustomersButton2ActionPerformed

    private void customerBlacklist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerBlacklist1ActionPerformed
        int row = customersTable2.getSelectedRow();
        String cell = customersTable2.getModel().getValueAt(row, 0).toString();
        Connection connect = databaseConnection.connection();
        String sql2 = "SELECT EXISTS(SELECT MAX(orders.Created_at) FROM orders INNER JOIN customers ON orders.Customer_id=customers.id where customers.id='"+cell+"'  GROUP BY customers.id );";
        try{
            pst = connect.prepareStatement(sql2);
            rs=pst.executeQuery();
            int n = 0;
            if ( rs.next() ) {
                n = rs.getInt(1);
            }
            if ( n > 0 ) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(this, "Blacklist Selected Customer?","Blacklist",dialogButton,JOptionPane.INFORMATION_MESSAGE,icon);
                if(dialogResult == JOptionPane.YES_OPTION){
                    String sql = "update customers set Status = 'blacklisted' where id =" + cell;
                    try{
                        pst = connect.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(this, "Customer Blacklisted.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
                    }
                }
                else{
                     ArrayList customer2 = customers2.customersQuery2();
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer2 .size(); i++)
            {
                Object o[] = (Object[])customer2 .get(i);
                tm.addRow(o);
            }
                    ArrayList blackListed2 = blackList2.blacklistQuery2();
            DefaultTableModel tm2=(DefaultTableModel)blackListedTable2.getModel();
            tm2.setRowCount(0);
            for(int i=0; i<blackListed2.size(); i++)
            {
                Object o[] = (Object[])blackListed2.get(i);
                tm2.addRow(o);
            }
                }
            }
            if(n == 0)
            {
                JOptionPane.showMessageDialog(this, "Selected Customer hasn't made any order.","Error",JOptionPane.INFORMATION_MESSAGE,icon);
                 ArrayList customer2 = customers2.customersQuery2();
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer2 .size(); i++)
            {
                Object o[] = (Object[])customer2 .get(i);
                tm.addRow(o);
            }
                ArrayList blackListed2 = blackList2.blacklistQuery2();
            DefaultTableModel tm2=(DefaultTableModel)blackListedTable2.getModel();
            tm2.setRowCount(0);
            for(int i=0; i<blackListed2.size(); i++)
            {
                Object o[] = (Object[])blackListed2.get(i);
                tm2.addRow(o);
            }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
         ArrayList customer2 = null;
    try {
        customer2 = customers2.customersQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer2.size(); i++)
            {
                Object o[] = (Object[])customer2 .get(i);
                tm.addRow(o);
            }
        ArrayList blackListed2 = null;
    try {
        blackListed2 = blackList2.blacklistQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm2=(DefaultTableModel)blackListedTable2.getModel();
            tm2.setRowCount(0);
            for(int i=0; i<blackListed2.size(); i++)
            {
                Object o[] = (Object[])blackListed2.get(i);
                tm2.addRow(o);
            }
    }//GEN-LAST:event_customerBlacklist1ActionPerformed

    private void blacklistedRestore1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blacklistedRestore1ActionPerformed
        int row = blackListedTable2.getSelectedRow();
        String cell = blackListedTable2.getModel().getValueAt(row, 0).toString();
        Connection connect = databaseConnection.connection();
        String sql2 = "SELECT * FROM orders INNER JOIN customers ON orders.Customer_id=customers.id WHERE orders.Created_at IN (SELECT MAX(orders.Created_at) FROM orders INNER JOIN customers ON orders.Customer_id=customers.id where customers.Status='blacklisted'  and customers.id='"+cell+"' GROUP BY customers.id ); ";
        try{
            pst = connect.prepareStatement(sql2);
            rs=pst.executeQuery();
            while(rs.next()){
                double balance = rs.getDouble("orders.Balance");
                if(balance == 0){
                    String sql = "update customers set Status = 'clean' where id =" + cell;
                    try{
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(this, "Restore Selected Customer?","Restore",dialogButton,JOptionPane.INFORMATION_MESSAGE,icon);
                        if(dialogResult == JOptionPane.YES_OPTION){
                            pst = connect.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(this, "Customer Restored.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
                        }
                        else{
                             ArrayList customer2 = customers2.customersQuery2();
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer2 .size(); i++)
            {
                Object o[] = (Object[])customer2 .get(i);
                tm.addRow(o);
            }
                           ArrayList blackListed2 = blackList2.blacklistQuery2();
            DefaultTableModel tm2=(DefaultTableModel)blackListedTable2.getModel();
            tm2.setRowCount(0);
            for(int i=0; i<blackListed2.size(); i++)
            {
                Object o[] = (Object[])blackListed2.get(i);
                tm2.addRow(o);
            }
                        }

                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
                    }
                }
                if(balance > 0){
                    String sql = "update customers set Status = 'credit' where id =" + cell;
                    try{
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(this, "Restore Selected Customer?","Restore",dialogButton,JOptionPane.INFORMATION_MESSAGE,icon);
                        if(dialogResult == JOptionPane.YES_OPTION){
                            pst = connect.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(this, "Customer Restored.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
                        }
                        else{
                             ArrayList customer2 = customers2.customersQuery2();
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer2 .size(); i++)
            {
                Object o[] = (Object[])customer2 .get(i);
                tm.addRow(o);
            }
                           ArrayList blackListed2 = blackList2.blacklistQuery2();
            DefaultTableModel tm2=(DefaultTableModel)blackListedTable2.getModel();
            tm2.setRowCount(0);
            for(int i=0; i<blackListed2.size(); i++)
            {
                Object o[] = (Object[])blackListed2.get(i);
                tm2.addRow(o);
            }
                        }

                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
                    }
                }
                if(balance < 0 && balance >= -100){
                    String sql = "update customers set Status = 'fined' where id =" + cell;
                    try{
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(this, "Restore Selected Customer?","Restore",dialogButton,JOptionPane.INFORMATION_MESSAGE,icon);
                        if(dialogResult == JOptionPane.YES_OPTION){
                            pst = connect.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(this, "Customer Restored.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
                        }
                        else{
                             ArrayList customer2 = customers2.customersQuery2();
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer2 .size(); i++)
            {
                Object o[] = (Object[])customer2 .get(i);
                tm.addRow(o);
            }
                            ArrayList blackListed2 = blackList2.blacklistQuery2();
            DefaultTableModel tm2=(DefaultTableModel)blackListedTable2.getModel();
            tm2.setRowCount(0);
            for(int i=0; i<blackListed2.size(); i++)
            {
                Object o[] = (Object[])blackListed2.get(i);
                tm2.addRow(o);
            }
                        }
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
                    }
                }
                if(balance < -100){
                    String sql = "update customers set Status = 'no delivery' where id =" + cell;
                    try{
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(this, "Restore Selected Customer?","Restore",dialogButton,JOptionPane.INFORMATION_MESSAGE,icon);
                        if(dialogResult == JOptionPane.YES_OPTION){
                            pst = connect.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(this, "Customer Restored.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
                        }
                        else{
                             ArrayList customer2 = customers2.customersQuery2();
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer2 .size(); i++)
            {
                Object o[] = (Object[])customer2 .get(i);
                tm.addRow(o);
            }
                            ArrayList blackListed2 = blackList2.blacklistQuery2();
            DefaultTableModel tm2=(DefaultTableModel)blackListedTable2.getModel();
            tm2.setRowCount(0);
            for(int i=0; i<blackListed2.size(); i++)
            {
                Object o[] = (Object[])blackListed2.get(i);
                tm2.addRow(o);
            }
                        }
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        ArrayList customer2 = null;
    try {
        customer2 = customers2.customersQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();

            tm.setRowCount(0);
            for(int i=0; i<customer2 .size(); i++)
            {
                Object o[] = (Object[])customer2 .get(i);
                tm.addRow(o);
            }
        ArrayList blackListed2 = null;
    try {
        blackListed2 = blackList2.blacklistQuery2();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm2=(DefaultTableModel)blackListedTable2.getModel();
            tm2.setRowCount(0);
            for(int i=0; i<blackListed2.size(); i++)
            {
                Object o[] = (Object[])blackListed2.get(i);
                tm2.addRow(o);
            }
    }//GEN-LAST:event_blacklistedRestore1ActionPerformed

    private void customerSearchContact2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerSearchContact2FocusGained
        if(customerSearchContact2.getText().equals("Search by contact...")){
            customerSearchContact2.setText("");
        }
        customerSearchContact2.setForeground(Color.BLACK);
        customerSearchContact2.setBackground(Color.WHITE);
    }//GEN-LAST:event_customerSearchContact2FocusGained

    private void customerSearchContact2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerSearchContact2FocusLost
        if(customerSearchContact2.getText().equals("")){
            customerSearchContact2.setText("Search by contact...");
        }
        customerSearchContact2.setForeground(new Color(102,102,102));
        customerSearchContact2.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_customerSearchContact2FocusLost

    private void customerSearchContact2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSearchContact2ActionPerformed
        String searched = customerSearchContact2.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select * from customers where Number LIKE '%"+searched+"%'";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)customersTable2.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("id"),
                    rs.getString("Name"),
                    rs.getString("Number"),
                    rs.getString("Location"),
                    rs.getString("Deliverer"),
                    rs.getString("Status")};
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_customerSearchContact2ActionPerformed

    private void delivererGatePassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_delivererGatePassFocusGained
       if(delivererGatePass.getText().equals("Deliverer(Gate Pass)...")){
           delivererGatePass.setText("");
        }
        delivererGatePass.setForeground(Color.BLACK);
       delivererGatePass.setBackground(Color.WHITE);
    }//GEN-LAST:event_delivererGatePassFocusGained

    private void delivererGatePassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_delivererGatePassFocusLost
         if(delivererGatePass.getText().equals("")){
            delivererGatePass.setText("Deliverer(Gate Pass)...");
        }
        delivererGatePass.setForeground(new Color(102,102,102));
        delivererGatePass.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_delivererGatePassFocusLost

    private void gatePassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gatePassButtonActionPerformed
        String deliverer = delivererGatePass.getText();
        String time = timePrint.getText();
    try {
        printGatePass(deliverer,time);
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        gatePassprinter(deliverer,time);
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        ordersAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_gatePassButtonActionPerformed

    private void delivererGatePass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_delivererGatePass1FocusGained
        if(delivererGatePass1.getText().equals("Deliverer(Gate Pass)...")){
           delivererGatePass1.setText("");
        }
        delivererGatePass1.setForeground(Color.BLACK);
       delivererGatePass1.setBackground(Color.WHITE);
    }//GEN-LAST:event_delivererGatePass1FocusGained

    private void delivererGatePass1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_delivererGatePass1FocusLost
        if(delivererGatePass1.getText().equals("")){
            delivererGatePass1.setText("Deliverer(Gate Pass)...");
        }
        delivererGatePass1.setForeground(new Color(102,102,102));
        delivererGatePass1.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_delivererGatePass1FocusLost

    private void gatePassButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gatePassButton1ActionPerformed
        String deliverer = delivererGatePass1.getText();
        String time = timePrint1.getText();
    try {
        printGatePass(deliverer,time);
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        gatePassprinter(deliverer,time);
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        ordersAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_gatePassButton1ActionPerformed

    private void delivererGatePass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delivererGatePass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delivererGatePass1ActionPerformed

    private void timePrint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timePrint1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timePrint1ActionPerformed

    private void delivererGatePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delivererGatePassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delivererGatePassActionPerformed

    private void timePrintFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timePrintFocusGained
       if(timePrint.getText().equals("Point in Time...")){
           timePrint.setText("");
        }
        timePrint.setForeground(Color.BLACK);
       timePrint.setBackground(Color.WHITE);
    }//GEN-LAST:event_timePrintFocusGained

    private void timePrintFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timePrintFocusLost
       if(timePrint.getText().equals("")){
            timePrint.setText("Point in Time...");
        }
        timePrint.setForeground(new Color(102,102,102));
        timePrint.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_timePrintFocusLost

    private void delivererDistributionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_delivererDistributionFocusGained
        if(delivererDistribution.getText().equals("Deliverer(Distribution)...")){
           delivererDistribution.setText("");
        }
        delivererDistribution.setForeground(Color.BLACK);
       delivererDistribution.setBackground(Color.WHITE);
    }//GEN-LAST:event_delivererDistributionFocusGained

    private void delivererDistributionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_delivererDistributionFocusLost
       if(delivererDistribution.getText().equals("")){
            delivererDistribution.setText("Deliverer(Distribution)...");
        }
        delivererDistribution.setForeground(new Color(102,102,102));
        delivererDistribution.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_delivererDistributionFocusLost

    private void timePrint1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timePrint1FocusGained
        if(timePrint1.getText().equals("Point in Time...")){
           timePrint1.setText("");
        }
        timePrint1.setForeground(Color.BLACK);
       timePrint1.setBackground(Color.WHITE);
    }//GEN-LAST:event_timePrint1FocusGained

    private void timePrint1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timePrint1FocusLost
        if(timePrint1.getText().equals("")){
            timePrint1.setText("Point in Time...");
        }
        timePrint1.setForeground(new Color(102,102,102));
        timePrint1.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_timePrint1FocusLost

    private void delivererDistribution1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_delivererDistribution1FocusGained
        if(delivererDistribution1.getText().equals("Deliverer(Distribution)...")){
           delivererDistribution1.setText("");
        }
        delivererDistribution1.setForeground(Color.BLACK);
       delivererDistribution1.setBackground(Color.WHITE);
    }//GEN-LAST:event_delivererDistribution1FocusGained

    private void delivererDistribution1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_delivererDistribution1FocusLost
         if(delivererDistribution1.getText().equals("")){
            delivererDistribution1.setText("Deliverer(Distribution)...");
        }
        delivererDistribution1.setForeground(new Color(102,102,102));
        delivererDistribution1.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_delivererDistribution1FocusLost

    private void delivererDistribution1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delivererDistribution1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delivererDistribution1ActionPerformed

    private void productDistributionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productDistributionButtonActionPerformed
        String deliverer = delivererDistribution.getText();
        String time = timePrint.getText();
        try {
        distributionprinter(deliverer,time);
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    switchPanel(goodsDistribution);
    try {
        ordersAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_productDistributionButtonActionPerformed

    private void productDistributionButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productDistributionButton1ActionPerformed
       String deliverer = delivererDistribution1.getText();
        String time = timePrint1.getText();
        try {
        distributionprinter(deliverer,time);
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    switchPanel(goodsDistribution);
    try {
        ordersAccess();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_productDistributionButton1ActionPerformed

    private void allOrdersYesterdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allOrdersYesterdayActionPerformed
        double price;
        int quantity;
        double cost;
        double debt;
        double mpesa;
        double cash;
        double balance;
        double Debt;
        double fine;
        int returned;
        String delivery;
        Connection connect = databaseConnection.connection();
            String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id WHERE DATE(orders.Late_order) = CURRENT_DATE()-1 order by orders.id ASC ;";
            try {               
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                DefaultTableModel tm=(DefaultTableModel)ordersTable.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    price=rs.getDouble("stock.price");
                    quantity=rs.getInt("orders.Quantity");
                    cost=price*quantity;
                    debt=rs.getDouble("Debt");
                    mpesa=rs.getDouble("Mpesa");
                    cash=rs.getDouble("Cash");
                    fine=rs.getDouble("Fine");
                    returned=rs.getInt("Returned");
                    delivery = rs.getString("Late_Order");
                    balance=(mpesa+cash)+debt-cost+fine;
                    Object o[]={rs.getInt("id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("stock.Name"),
                                rs.getInt("orders.Quantity"),
                                cost,
                                debt,
                                mpesa,
                                cash,
                                fine,
                                balance,
                                delivery,
                                returned,
                                rs.getString("Banked"),
                                rs.getString("Slip_Number"),
                                rs.getString("Banked_By")
                    };
                    tm.addRow(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_allOrdersYesterdayActionPerformed

    private void allOrdersTomorrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allOrdersTomorrowButtonActionPerformed
        double price;
        int quantity;
        double cost;
        double debt;
        double mpesa;
        double cash;
        double balance;
        double Debt;
        double fine;
        int returned;
        String delivery;
        Connection connect = databaseConnection.connection();
            String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id WHERE DATE(orders.Late_order) = CURRENT_DATE()+1 order by orders.id ASC ;";
            try {               
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                DefaultTableModel tm=(DefaultTableModel)ordersTable.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    price=rs.getDouble("stock.price");
                    quantity=rs.getInt("orders.Quantity");
                    cost=price*quantity;
                    debt=rs.getDouble("Debt");
                    mpesa=rs.getDouble("Mpesa");
                    cash=rs.getDouble("Cash");
                    fine=rs.getDouble("Fine");
                    returned=rs.getInt("Returned");
                    delivery = rs.getString("Late_Order");
                    balance=(mpesa+cash)+debt-cost+fine;
                    Object o[]={rs.getInt("id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("stock.Name"),
                                rs.getInt("orders.Quantity"),
                                cost,
                                debt,
                                mpesa,
                                cash,
                                fine,
                                balance,
                                delivery,
                                returned,
                                rs.getString("Banked"),
                                rs.getString("Slip_Number"),
                                rs.getString("Banked_By")
                    };
                    tm.addRow(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_allOrdersTomorrowButtonActionPerformed

    private void allOrdersYesterdayButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allOrdersYesterdayButton11ActionPerformed
        double price;
        int quantity;
        double cost;
        double debt;
        double Debt;
        String delivery;
        String note;
        Connection connect = databaseConnection.connection();
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id WHERE DATE(orders.Late_Order) = CURRENT_DATE()-1 order by orders.id ASC ;";
        try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                DefaultTableModel tm=(DefaultTableModel)ordersTable1.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    price=rs.getDouble("stock.price");
                    quantity=rs.getInt("orders.Quantity");
                    cost=price*quantity;
                    debt=rs.getDouble("Debt");
                    delivery = rs.getString("Late_Order");
                    note = rs.getString("Note");
                    Object o[]={rs.getInt("id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("stock.Name"),
                                rs.getInt("orders.Quantity"),
                                cost,
                                debt,
                               delivery,
                               rs.getInt("Returned"),
                               note
                    };
                    tm.addRow(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_allOrdersYesterdayButton11ActionPerformed

    private void allOrdersTomorrowButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allOrdersTomorrowButton11ActionPerformed
         double price;
        int quantity;
        double cost;
        double debt;
        double Debt;
        String delivery;
        String note;
        Connection connect = databaseConnection.connection();
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id WHERE DATE(orders.Late_Order) = CURRENT_DATE()+1 order by orders.id ASC ;";
        try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                DefaultTableModel tm=(DefaultTableModel)ordersTable1.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    price=rs.getDouble("stock.price");
                    quantity=rs.getInt("orders.Quantity");
                    cost=price*quantity;
                    debt=rs.getDouble("Debt");
                    delivery = rs.getString("Late_Order");
                    note = rs.getString("Note");
                    Object o[]={rs.getInt("id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("stock.Name"),
                                rs.getInt("orders.Quantity"),
                                cost,
                                debt,
                               delivery,
                               rs.getInt("Returned"),
                               note
                    };
                    tm.addRow(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_allOrdersTomorrowButton11ActionPerformed

    private void allOrdersYesterdayButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allOrdersYesterdayButton3ActionPerformed
        double price;
        int quantity;
        double cost;
        double debt;
        double mpesa;
        double cash;
        double balance;
        double Debt;
        double fine;
        int returned;
        String delivery;
        Connection connect = databaseConnection.connection();
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id WHERE DATE(orders.Late_Order) = CURRENT_DATE()-1 order by orders.id ASC ;";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable3.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                cost=price*quantity;
                debt=rs.getDouble("Debt");
                mpesa=rs.getDouble("Mpesa");
                cash=rs.getDouble("Cash");
                fine=rs.getDouble("Fine");
                returned=rs.getInt("Returned");
                delivery = rs.getString("Late_Order");
                balance=(mpesa+cash)+debt-cost+fine;
                Object o[]={rs.getInt("id"),
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost,
                    debt,
                    mpesa,
                    cash,
                    fine,
                    balance,
                    delivery,
                    returned,
                    rs.getString("Banked"),
                    rs.getString("Slip_Number"),
                    rs.getString("Banked_By")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_allOrdersYesterdayButton3ActionPerformed

    private void allOrdersTomorrowButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allOrdersTomorrowButton3ActionPerformed
        double price;
        int quantity;
        double cost;
        double debt;
        double mpesa;
        double cash;
        double balance;
        double Debt;
        double fine;
        int returned;
        String delivery;
        Connection connect = databaseConnection.connection();
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id WHERE DATE(orders.Late_Order) = CURRENT_DATE()+1 order by orders.id ASC ;";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable3.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                cost=price*quantity;
                debt=rs.getDouble("Debt");
                mpesa=rs.getDouble("Mpesa");
                cash=rs.getDouble("Cash");
                fine=rs.getDouble("Fine");
                returned=rs.getInt("Returned");
                delivery = rs.getString("Late_Order");
                balance=(mpesa+cash)+debt-cost+fine;
                Object o[]={rs.getInt("id"),
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost,
                    debt,
                    mpesa,
                    cash,
                    fine,
                    balance,
                    delivery,
                    returned,
                    rs.getString("Banked"),
                    rs.getString("Slip_Number"),
                    rs.getString("Banked_By")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_allOrdersTomorrowButton3ActionPerformed

    private void stockSaveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockSaveChangesButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel)stockTable.getModel();
        int selectedRowIndex = stockTable.getSelectedRow();
        int row = stockTable.getSelectedRow();
        String cell = stockTable.getModel().getValueAt(row, 0).toString();
        String category_id = model.getValueAt(selectedRowIndex, 1).toString();
        String name = model.getValueAt(selectedRowIndex, 2).toString();
        String price = model.getValueAt(selectedRowIndex, 3).toString();
        int quantity = Integer.parseInt(model.getValueAt(selectedRowIndex, 4).toString());
        String buying_price = model.getValueAt(selectedRowIndex, 5).toString();
        Connection connect = databaseConnection.connection();
        String sql = "select Quantity,Category_id from stock where id =" + cell;
        try{
            pst = connect.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                int Quantity = rs.getInt("stock.Quantity");
                String category = rs.getString("stock.Category_id");

                    int difference = quantity - Quantity;
                    String sql2 = "update stock set  Price='"+price+"',Quantity='"+quantity+"',Buying_price='"+buying_price+"',purchased=purchased+'"+difference+"' where id =" + cell;
                    try{
                        pst = connect.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(this, "Stock Updated.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
                    }
            }
        }catch(Exception ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        ArrayList stocks = null;
    try {
        stocks = stockQuery.stockQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(stocks.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Stock","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)stockTable.getModel();

            tm.setRowCount(0);
            for(int i=0; i<stocks.size(); i++)
            {
                Object o[] = (Object[])stocks.get(i);
                tm.addRow(o);
            }
        }
    }//GEN-LAST:event_stockSaveChangesButtonActionPerformed

    private void stockDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockDeleteButtonActionPerformed
        int row = stockTable.getSelectedRow();
        String cell = stockTable.getModel().getValueAt(row, 0).toString();
        String sql = "Delete from stock where id =" + cell;
        Connection connect = databaseConnection.connection();
        try{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Delete Selected Stock?","Delete",dialogButton,JOptionPane.INFORMATION_MESSAGE,icon);
            if(dialogResult == JOptionPane.YES_OPTION){
                pst = connect.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Stock Deleted.","Success",JOptionPane.INFORMATION_MESSAGE,icon);
            }
            else{
                ArrayList stocks = stockQuery.stockQuery();
                if(stocks.size()==0)
                {
                    JOptionPane.showMessageDialog(this,"No Stock","Info",JOptionPane.INFORMATION_MESSAGE,icon);
                }
                else
                {
                    DefaultTableModel tm=(DefaultTableModel)stockTable.getModel();

                    tm.setRowCount(0);
                    for(int i=0; i<stocks.size(); i++)
                    {
                        Object o[] = (Object[])stocks.get(i);
                        tm.addRow(o);
                    }
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        ArrayList stocks = null;
    try {
        stocks = stockQuery.stockQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(stocks.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Stock","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)stockTable.getModel();

            tm.setRowCount(0);
            for(int i=0; i<stocks.size(); i++)
            {
                Object o[] = (Object[])stocks.get(i);
                tm.addRow(o);
            }
        }
    }//GEN-LAST:event_stockDeleteButtonActionPerformed

    private void addStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStockButtonActionPerformed
        switchButton(addStockBackButton);
        switchPanel(addStockPanel);
        switchBar(sideBar);
        sideBarColor2();
    }//GEN-LAST:event_addStockButtonActionPerformed

    private void categoriesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriesButtonActionPerformed
        switchButton(categoriesBackButton);
        switchPanel(categoriesPanel);
        switchBar(sideBar);
        sideBarColor2();
        ArrayList categories1 = null;
    try {
        categories1 = categories.categoriesQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(categories1.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Category Avaliable","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)categoriesTable.getModel();

            tm.setRowCount(0);
            for(int i=0; i<categories1.size(); i++)
            {
                Object o[] = (Object[])categories1.get(i);
                tm.addRow(o);
            }
        }
    }//GEN-LAST:event_categoriesButtonActionPerformed

    private void showAllStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllStockButtonActionPerformed
        ArrayList stocks = null;
    try {
        stocks = stockQuery.stockQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(stocks.size()==0)
        {
            JOptionPane.showMessageDialog(this,"No Stock","Info",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        else
        {
            DefaultTableModel tm=(DefaultTableModel)stockTable.getModel();

            tm.setRowCount(0);
            for(int i=0; i<stocks.size(); i++)
            {
                Object o[] = (Object[])stocks.get(i);
                tm.addRow(o);
            }
        }
    }//GEN-LAST:event_showAllStockButtonActionPerformed

    private void stockSearchCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockSearchCategoryActionPerformed
        String searched = stockSearchCategory.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select * from stock INNER JOIN category ON stock.Category_id=category.id where Category_Name LIKE '"+searched+"%'";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)stockTable.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("id"),
                    rs.getString("Category_Name"),
                    rs.getString("Name"),
                    rs.getString("Price"),
                    rs.getString("Quantity")};
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_stockSearchCategoryActionPerformed

    private void stockSearchCategoryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockSearchCategoryFocusLost
        if(stockSearchCategory.getText().equals("")){
            stockSearchCategory.setText("Search by category...");
        }
        stockSearchCategory.setForeground(new Color(102,102,102));
        stockSearchCategory.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_stockSearchCategoryFocusLost

    private void stockSearchCategoryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockSearchCategoryFocusGained
        if(stockSearchCategory.getText().equals("Search by category...")){
            stockSearchCategory.setText("");
        }
        stockSearchCategory.setForeground(Color.BLACK);
        stockSearchCategory.setBackground(Color.WHITE);
    }//GEN-LAST:event_stockSearchCategoryFocusGained

    private void stockSearchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockSearchNameActionPerformed
        String searched = stockSearchName.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select * from stock INNER JOIN category ON stock.Category_id=category.id where Name LIKE '%"+searched+"%'";
        try {
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)stockTable.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("id"),
                    rs.getString("Category_Name"),
                    rs.getString("Name"),
                    rs.getString("Price"),
                    rs.getString("Quantity")};
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_stockSearchNameActionPerformed

    private void stockSearchNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockSearchNameFocusLost
        if(stockSearchName.getText().equals("")){
            stockSearchName.setText("Search by name...");
        }
        stockSearchName.setForeground(new Color(102,102,102));
        stockSearchName.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_stockSearchNameFocusLost

    private void stockSearchNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockSearchNameFocusGained
        if(stockSearchName.getText().equals("Search by name...")){
            stockSearchName.setText("");
        }
        stockSearchName.setForeground(Color.BLACK);
        stockSearchName.setBackground(Color.WHITE);
    }//GEN-LAST:event_stockSearchNameFocusGained

    private void stockValuationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockValuationButtonActionPerformed
        switchButton(stockValuationBackButton);
        switchPanel(stockPanel2);
        switchBar(sideBar);
        sideBarColor2();
        ArrayList value = null;
    try {
        value = valuation.valuationQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm=(DefaultTableModel)stockTable2.getModel();

            tm.setRowCount(0);
            for(int i=0; i<value.size(); i++)
            {
                Object o[] = (Object[])value.get(i);
                tm.addRow(o);
            }
    }//GEN-LAST:event_stockValuationButtonActionPerformed

    private void stockValuationBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockValuationBackButtonActionPerformed
        switchPanel(stockPanel);
        switchButton2();
        switchBar(sideBar);
        sideBarColor2();
    }//GEN-LAST:event_stockValuationBackButtonActionPerformed

    private void additionRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_additionRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_additionRadioButtonActionPerformed

    private void valuationDateTextfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valuationDateTextfieldFocusGained
       if(valuationDateTextfield.getText().equals("Search valuation by date...")){
            valuationDateTextfield.setText("");
        }
        valuationDateTextfield.setForeground(Color.BLACK);
        valuationDateTextfield.setBackground(Color.WHITE);
    }//GEN-LAST:event_valuationDateTextfieldFocusGained

    private void valuationDateTextfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valuationDateTextfieldFocusLost
        if(valuationDateTextfield.getText().equals("")){
            valuationDateTextfield.setText("Search valuation by date...");
        }
        valuationDateTextfield.setForeground(new Color(102,102,102));
        valuationDateTextfield.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_valuationDateTextfieldFocusLost

    private void valuationDateTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valuationDateTextfieldActionPerformed
        String valuationDate = valuationDateTextfield.getText();
        Connection connect = databaseConnection.connection();
        String query2 = "select s.id as sid, s.Name as sname,\n" +
"       sum(case when date(o.Late_Order) =  "+valuationDate+"-4 then o.Quantity else 0 end) as sum1,\n" +
"       sum(case when date(o.Late_Order) =  "+valuationDate+"-3 then o.Quantity else 0 end) as sum2,\n" +
"       sum(case when date(o.Late_Order) =  "+valuationDate+"-2 then o.Quantity else 0 end) as sum3,\n" +
"       sum(case when date(o.Late_Order) =  "+valuationDate+"-1 then o.Quantity else 0 end) as sum4,\n" +
"       sum(case when date(o.Late_Order) =  "+valuationDate+" then o.Quantity else 0 end) as sum5\n" +
"from orders o inner join\n" +
"     stock s\n" +
"     on o.Stock_id = s.id \n" +
"group by s.id; ";
        try {          
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)stockTable2.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                int sum1 = rs.getInt("sum1");
                int sum2 = rs.getInt("sum2");
                int sum3 = rs.getInt("sum3");
                int sum4 = rs.getInt("sum4");
                int sum5 = rs.getInt("sum5");
                Object o[]={rs.getString("sid"),
                    rs.getString("sname"),
                    sum1,
                    sum2,
                    sum3,
                    sum4,
                    sum5
                };
                tm.addRow(o);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_valuationDateTextfieldActionPerformed

    private void valuationTodayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valuationTodayButtonActionPerformed
       ArrayList value = null;
    try {
        value = valuation.valuationQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
            DefaultTableModel tm=(DefaultTableModel)stockTable2.getModel();

            tm.setRowCount(0);
            for(int i=0; i<value.size(); i++)
            {
                Object o[] = (Object[])value.get(i);
                tm.addRow(o);
            }
    }//GEN-LAST:event_valuationTodayButtonActionPerformed

    private void specifyOrderDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_specifyOrderDateFocusGained
         if(specifyOrderDate.getText().equals("Otherwise specify the order date(YYYY-MM-DD)...")){
            specifyOrderDate.setText("");
        }
        specifyOrderDate.setForeground(Color.BLACK);
        specifyOrderDate.setBackground(Color.WHITE);
        
    }//GEN-LAST:event_specifyOrderDateFocusGained

    private void specifyOrderDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_specifyOrderDateFocusLost
        if(specifyOrderDate.getText().equals("")){
            specifyOrderDate.setText("Otherwise specify the order date(YYYY-MM-DD)...");
        }
        specifyOrderDate.setForeground(new Color(102,102,102));
        specifyOrderDate.setBackground(new Color(232,228,228));
    }//GEN-LAST:event_specifyOrderDateFocusLost

    private void addStockCategoryIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStockCategoryIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStockCategoryIdTextFieldActionPerformed

    private void addStockBuyingPriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStockBuyingPriceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStockBuyingPriceTextFieldActionPerformed

    private void addCustomerDelivererTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerDelivererTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCustomerDelivererTextFieldActionPerformed

    private void addCustomerNoteTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerNoteTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCustomerNoteTextFieldActionPerformed

    private void specifyOrderDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specifyOrderDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_specifyOrderDateActionPerformed
                                                      
    
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCustomerBackButton;
    private javax.swing.JButton addCustomerButton1;
    private javax.swing.JButton addCustomerButton2;
    private javax.swing.JLabel addCustomerDelivererLabel;
    private javax.swing.JLabel addCustomerDelivererLabel1;
    private javax.swing.JTextField addCustomerDelivererTextField;
    private javax.swing.JLabel addCustomerLocationLabel;
    private javax.swing.JTextField addCustomerLocationTextField;
    private javax.swing.JLabel addCustomerNameLabel;
    private javax.swing.JTextField addCustomerNameTextField;
    private javax.swing.JTextField addCustomerNoteTextField;
    private javax.swing.JLabel addCustomerNumberLabel;
    private javax.swing.JTextField addCustomerNumberTextField;
    private javax.swing.JLabel addCustomerPageTitle;
    private javax.swing.JPanel addCustomerPanel;
    private javax.swing.JButton addCustomerSaveButton;
    private javax.swing.JButton addOrderBackButton;
    private javax.swing.JButton addOrderButton;
    private javax.swing.JButton addOrderButton1;
    private javax.swing.JButton addOrderButton3;
    private javax.swing.JLabel addOrderPageTitle;
    private javax.swing.JPanel addOrderPanel;
    private javax.swing.JButton addStockBackButton;
    private javax.swing.JButton addStockButton;
    private javax.swing.JLabel addStockBuyingPriceLabel;
    private javax.swing.JTextField addStockBuyingPriceTextField;
    private javax.swing.JLabel addStockCategoryIdLabel;
    private javax.swing.JTextField addStockCategoryIdTextField;
    private javax.swing.JLabel addStockNameLabel;
    private javax.swing.JTextField addStockNameTextField;
    private javax.swing.JLabel addStockPageTitle;
    private javax.swing.JPanel addStockPanel;
    private javax.swing.JLabel addStockPriceLabel;
    private javax.swing.JTextField addStockPriceTextField;
    private javax.swing.JLabel addStockQuantityLabel;
    private javax.swing.JTextField addStockQuantityTextField;
    private javax.swing.JButton addStockSaveButton;
    private javax.swing.JButton addToCartButton;
    private javax.swing.JRadioButton additionRadioButton;
    private javax.swing.JButton allOrdersTomorrowButton;
    private javax.swing.JButton allOrdersTomorrowButton1;
    private javax.swing.JButton allOrdersTomorrowButton3;
    private javax.swing.JButton allOrdersYesterday;
    private javax.swing.JButton allOrdersYesterdayButton1;
    private javax.swing.JButton allOrdersYesterdayButton3;
    private javax.swing.JLabel avatarIcon;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLayeredPane basePanel;
    private javax.swing.JTable blackListedTable1;
    private javax.swing.JTable blackListedTable2;
    private javax.swing.JButton blacklistedRestore1;
    private javax.swing.JButton blacklistedSaveChangsButton1;
    private javax.swing.JLayeredPane buttonsPanel;
    private javax.swing.JTextField categoriesAddTextField;
    private javax.swing.JButton categoriesBackButton;
    private javax.swing.JButton categoriesBackButton1;
    private javax.swing.JButton categoriesButton;
    private javax.swing.JButton categoriesButton1;
    private javax.swing.JLabel categoriesPageTitle;
    private javax.swing.JLabel categoriesPageTitle1;
    private javax.swing.JPanel categoriesPanel;
    private javax.swing.JPanel categoriesPanel1;
    private javax.swing.JTable categoriesTable;
    private javax.swing.JTable categoriesTable1;
    private javax.swing.JButton categoryDeleteButton;
    private javax.swing.JButton categorySaveChangesButton;
    private javax.swing.JButton completeOrderButton;
    private javax.swing.JButton customerBlacklist1;
    private javax.swing.JLabel customerDetailsTitle;
    private javax.swing.JTextField customerSearchContact1;
    private javax.swing.JTextField customerSearchContact2;
    private javax.swing.JTextField customerSearchDeliverer1;
    private javax.swing.JTextField customerSearchDeliverer2;
    private javax.swing.JTextField customerSearchName1;
    private javax.swing.JTextField customerSearchName2;
    private javax.swing.JLabel customerSideBar;
    private javax.swing.JLabel customersPageTitle1;
    private javax.swing.JLabel customersPageTitle2;
    private javax.swing.JPanel customersPanel1;
    private javax.swing.JPanel customersPanel2;
    private javax.swing.JButton customersPrintButton;
    private javax.swing.JButton customersSaveChangesButton1;
    private javax.swing.JButton customersSaveChangesButton2;
    private javax.swing.JTable customersTable1;
    private javax.swing.JTable customersTable2;
    private javax.swing.JButton deleteCartItemButton;
    private javax.swing.JTextField delivererDistribution;
    private javax.swing.JTextField delivererDistribution1;
    private javax.swing.JTextField delivererGatePass;
    private javax.swing.JTextField delivererGatePass1;
    private javax.swing.JPanel gatePass;
    private javax.swing.JButton gatePassButton;
    private javax.swing.JButton gatePassButton1;
    private javax.swing.JPanel goodsDistribution;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTable newOrderCartTable;
    private javax.swing.JTable newOrderDetailsTable;
    private javax.swing.JTextField newOrderSearchName;
    private javax.swing.JTextField newOrderSearchStock;
    private javax.swing.JTable newOrderTable;
    private javax.swing.JLabel orderDetailsTitle;
    private javax.swing.JLabel orderSideBar;
    private javax.swing.JLabel orderTotalLabel;
    private javax.swing.JButton ordersDeleteButton;
    private javax.swing.JButton ordersFineButton;
    private javax.swing.JButton ordersFineButton1;
    private javax.swing.JLabel ordersPageTitle;
    private javax.swing.JLabel ordersPageTitle1;
    private javax.swing.JLabel ordersPageTitle3;
    private javax.swing.JLabel ordersPageTitle4;
    private javax.swing.JLabel ordersPageTitle5;
    private javax.swing.JPanel ordersPanel;
    private javax.swing.JPanel ordersPanel1;
    private javax.swing.JPanel ordersPanel3;
    private javax.swing.JButton ordersPrintButton;
    private javax.swing.JButton ordersSaveButton;
    private javax.swing.JButton ordersSaveButton1;
    private javax.swing.JTextField ordersSearchDate;
    private javax.swing.JTextField ordersSearchDate1;
    private javax.swing.JTextField ordersSearchDate3;
    private javax.swing.JTextField ordersSearchDeliverer;
    private javax.swing.JTextField ordersSearchDeliverer1;
    private javax.swing.JTextField ordersSearchDeliverer3;
    private javax.swing.JTextField ordersSearchName;
    private javax.swing.JTextField ordersSearchName1;
    private javax.swing.JTextField ordersSearchName3;
    private javax.swing.JTable ordersTable;
    private javax.swing.JTable ordersTable1;
    private javax.swing.JTable ordersTable3;
    private javax.swing.JTable ordersTable4;
    private javax.swing.JTable ordersTable5;
    private javax.swing.JButton productDistributionButton;
    private javax.swing.JButton productDistributionButton1;
    private javax.swing.JButton returnedGoodsBackButton;
    private javax.swing.JButton returnedGoodsButton;
    private javax.swing.JButton returnedGoodsButton1;
    private javax.swing.JLabel returnedGoodsInstruction;
    private javax.swing.JLabel returnedGoodsPageTitle;
    private javax.swing.JPanel returnedGoodsPanel;
    private javax.swing.JTable returnedGoodsTable;
    private javax.swing.JButton showAllCustomersButton1;
    private javax.swing.JButton showAllCustomersButton2;
    private javax.swing.JButton showAllOrdersButton;
    private javax.swing.JButton showAllOrdersButton1;
    private javax.swing.JButton showAllOrdersButton3;
    private javax.swing.JButton showAllStockButton;
    private javax.swing.JButton showAllStockButton1;
    private javax.swing.JPanel sideBar;
    private javax.swing.JLayeredPane sideBarPanel;
    private javax.swing.JTextField specifyOrderDate;
    private javax.swing.JButton stockDeleteButton;
    private javax.swing.JLabel stockPageTitle;
    private javax.swing.JLabel stockPageTitle1;
    private javax.swing.JPanel stockPanel;
    private javax.swing.JPanel stockPanel1;
    private javax.swing.JPanel stockPanel2;
    private javax.swing.JButton stockSaveChangesButton;
    private javax.swing.JTextField stockSearchCategory;
    private javax.swing.JTextField stockSearchCategory1;
    private javax.swing.JTextField stockSearchName;
    private javax.swing.JTextField stockSearchName1;
    private javax.swing.JLabel stockSideBar;
    private javax.swing.JTable stockTable;
    private javax.swing.JTable stockTable1;
    private javax.swing.JTable stockTable2;
    private javax.swing.JButton stockValuationBackButton;
    private javax.swing.JButton stockValuationButton;
    private javax.swing.JLabel stockValuationTitle;
    private javax.swing.JLabel summarySideBar;
    private javax.swing.JTextField timePrint;
    private javax.swing.JTextField timePrint1;
    private javax.swing.JTextField totalReadText;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField valuationDateTextfield;
    private javax.swing.JLabel valuationInstruction;
    private javax.swing.JButton valuationTodayButton;
    // End of variables declaration//GEN-END:variables
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/kwanza/tukule/management/system/images/kwanza tukule icon.png")));
    }
    
    public void userAccess() throws SQLException {
        String username;
        Connection connect = databaseConnection.connection();
        String query2 = "select * from users";
            try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                while (rs.next()) {
                   role = rs.getString("role");
                   username = rs.getString("username");
                   if( username.equals(user)  && role.equals("Software") ){
            switchButton(customersPrintButton);
            switchPanel(customers0);
            switchBar(sideBar);
             sideBarColor1();
                }
                else if( username.equals(user)  && role.equals("CEO") ){
                switchButton(customersPrintButton);
                switchPanel(customers0);
                switchBar(sideBar);
                sideBarColor1();
                }
                   else if( username.equals(user)  && role.equals("General operation manager") ){
                switchButton(customersPrintButton);
                switchPanel(customersPanel2);
                switchBar(sideBar);
                sideBarColor1();
                }

                   else if( username.equals(user)  && role.equals("admin") ){
                switchButton(customersPrintButton);                
               switchPanel(customersPanel1);
                sideBarColor1();
                   }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
            if(connect!=null){
                connect.close();
            }
        }
    }

    public void ordersAccess() throws SQLException {
        String username;
        Connection connect = databaseConnection.connection();
        String query = "select * from users";
            try {
                pst = connect.prepareStatement(query);
                rs=pst.executeQuery();
                while (rs.next()) {
                   role = rs.getString("role");
                   username = rs.getString("username");
                   if( username.equals(user)  && role.equals("Software") ){
            switchButton(ordersPrintButton);
      switchPanel(ordersPanel);
      switchBar(sideBar);
      sideBarColor3();
      }    
           else if( username.equals(user)  && role.equals("CEO") ) 
               {
            switchButton(ordersPrintButton);
         switchPanel(ordersPanel);
        switchBar(sideBar);
          sideBarColor3();
         }    
         else if( username.equals(user)  && role.equals("General operation manager") ) 
               {
          switchButton(ordersPrintButton);
         switchPanel(ordersPanel3);
        switchBar(sideBar);
          sideBarColor3();
         }  
          else if( username.equals(user)  && role.equals("admin") ){
          switchButton(ordersPrintButton);
         switchPanel(ordersPanel1);
         switchBar(sideBar);
          sideBarColor3();
                }
           }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
            if(connect!=null){
                connect.close();
            }
        }
    }
    public void ordersQuery() throws SQLException{
        double price;
        int quantity;
        double cost;
        double debt;
        double mpesa;
        double cash;
        double balance;
        double Debt;
        double fine;
        int returned;
        String delivery;
        String set_date;
        String date = ordersSearchDate.getText();
        Connection connect = databaseConnection.connection();
        if(date.equals("Search by date...(YYYY-MM-DD)"))
        {
            String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id WHERE DATE(orders.Late_Order) = CURRENT_DATE() order by orders.id ASC ;";
            try {               
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                DefaultTableModel tm=(DefaultTableModel)ordersTable.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    price=rs.getDouble("stock.price");
                    quantity=rs.getInt("orders.Quantity");
                    cost=price*quantity;
                    debt=rs.getDouble("Debt");
                    mpesa=rs.getDouble("Mpesa");
                    cash=rs.getDouble("Cash");
                    fine=rs.getDouble("Fine");
                    returned=rs.getInt("Returned");
                    delivery = rs.getString("Late_Order");
                    balance=(mpesa+cash)+debt-cost+fine;
                    Object o[]={rs.getInt("id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("stock.Name"),
                                rs.getInt("orders.Quantity"),
                                cost,
                                debt,
                                mpesa,
                                cash,
                                fine,
                                balance,
                                delivery,
                                returned,
                                rs.getString("Banked"),
                                rs.getString("Slip_Number"),
                                rs.getString("Banked_By")
                    };
                    tm.addRow(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
            if(connect!=null){
                connect.close();
            }
        }
        }
        else
        {
            String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id WHERE DATE(orders.Late_Order) = '"+date+"' order by orders.id ASC ;";
            try {               
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                DefaultTableModel tm=(DefaultTableModel)ordersTable.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    price=rs.getDouble("stock.price");
                    quantity=rs.getInt("orders.Quantity");
                    cost=price*quantity;
                    debt=rs.getDouble("Debt");
                    mpesa=rs.getDouble("Mpesa");
                    cash=rs.getDouble("Cash");
                    fine=rs.getDouble("Fine");
                    returned=rs.getInt("Returned");
                    delivery = rs.getString("Late_Order");
                    balance=(mpesa+cash)+debt-cost+fine;
                    Object o[]={rs.getInt("id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("stock.Name"),
                                rs.getInt("orders.Quantity"),
                                cost,
                                debt,
                                mpesa,
                                cash,
                                fine,
                                balance,
                                delivery,
                                returned,
                                rs.getString("Banked"),
                                rs.getString("Slip_Number"),
                                rs.getString("Banked_By")
                    };
                    tm.addRow(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
           finally{
            if(connect!=null){
                connect.close();
            }
        } 
        }
    }
    public void ordersQuery1() throws SQLException{
        double price;
        int quantity;
        double cost;
        double debt;
        double Debt;
        String delivery;
        String note;
        String date = ordersSearchDate1.getText();
        Connection connect = databaseConnection.connection();
        if(date.equals("Search by date...(YYYY-MM-DD)"))
        {
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id WHERE DATE(orders.Late_Order) = CURRENT_DATE() order by orders.id ASC ;";
        try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                DefaultTableModel tm=(DefaultTableModel)ordersTable1.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    price=rs.getDouble("stock.price");
                    quantity=rs.getInt("orders.Quantity");
                    cost=price*quantity;
                    debt=rs.getDouble("Debt");
                    delivery = rs.getString("Late_Order");
                    note = rs.getString("Note");
                    Object o[]={rs.getInt("id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("stock.Name"),
                                rs.getInt("orders.Quantity"),
                                cost,
                                debt,
                               delivery,
                               rs.getInt("Returned"),
                               note
                    };
                    tm.addRow(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
            if(connect!=null){
                connect.close();
            }
        }
    }
        else
        {
            String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id WHERE DATE(orders.Late_Order) = '"+date+"' order by orders.id ASC ;";
        try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                DefaultTableModel tm=(DefaultTableModel)ordersTable1.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    price=rs.getDouble("stock.price");
                    quantity=rs.getInt("orders.Quantity");
                    cost=price*quantity;
                    debt=rs.getDouble("Debt");
                    delivery = rs.getString("Late_Order");
                    Object o[]={rs.getInt("id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("stock.Name"),
                                rs.getInt("orders.Quantity"),
                                cost,
                                debt,
                               delivery,
                               rs.getInt("Returned")
                    };
                    tm.addRow(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
            if(connect!=null){
                connect.close();
            }
        }
        }
    }
    public void getTotals(){
        double sum = 0;
            for(int i=0;i<newOrderCartTable.getRowCount(); i++ )
            {
                sum = sum + Double.parseDouble(newOrderCartTable.getValueAt(i,4).toString());
            }
            totalReadText.setText(Double.toString(sum));
    }

    

   

    public void stockAccess() throws SQLException {
        String username;
        String query = "select * from users";
        Connection connect = databaseConnection.connection();
            try {
                pst = connect.prepareStatement(query);
                rs=pst.executeQuery();
                while (rs.next()) {
                   role = rs.getString("role");
                   username = rs.getString("username");
                   if( username.equals(user)  && role.equals("Software") ){
        switchPanel(stockPanel);
      switchButton2();
      switchBar(sideBar);
       sideBarColor2();
      }    
           else if( username.equals(user)  && role.equals("CEO") ) 
               {
        switchPanel(stockPanel);
        switchButton2();
        switchBar(sideBar);
      sideBarColor2();
         }    
         else if( username.equals(user)  && role.equals("General operation manager") ) 
               {
        switchPanel(stockPanel);
        switchButton2();
       switchBar(sideBar);
     sideBarColor2();
         }  
          else if( username.equals(user)  && role.equals("admin") ){
       switchPanel(stockPanel1);
       switchButton2();
       switchBar(sideBar);
     sideBarColor2();
                }
           }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
            if(connect!=null){
                connect.close();
            }
        }
    }
    public void summaryAccess() throws SQLException {
        String username;
        String query = "select * from users";
        Connection connect = databaseConnection.connection();
            try {
                pst = connect.prepareStatement(query);
                rs=pst.executeQuery();
                while (rs.next()) {
                   role = rs.getString("role");
                   username = rs.getString("username");
                   if( username.equals(user)  && role.equals("Software") ){
        switchPanel(summary);
        switchButton2();
       switchBar(sideBar);
     sideBarColor4();
      summary.summaryQuery();
      }    
           else if( username.equals(user)  && role.equals("CEO") ) 
               {
        switchPanel(summary);
        switchButton2();
      switchBar(sideBar);
      sideBarColor4();
      summary.summaryQuery();
         }    
         else if( username.equals(user)  && role.equals("General operation manager") ) 
               {
        switchPanel(summary);
        switchButton2();
       switchBar(sideBar);
      sideBarColor4();
      summary.summaryQuery();
         }  
          else if( username.equals(user)  && role.equals("admin") ){
      switchButton2();
      switchBar(sideBar);
       switchPanel(nullpanel);
     sideBarColor0();
      JOptionPane.showMessageDialog(this,"Unauthorized Action","Access Denied",JOptionPane.INFORMATION_MESSAGE,icon);       
                }
           }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
            if(connect!=null){
                connect.close();
            }
        }
    }

    public void ordersQuery2() throws SQLException {
        double price;
        int quantity;
        double cost;
        double debt;
        double mpesa;
        double cash;
        double balance;
        double Debt;
        double fine;
        int returned;
        String delivery;
        String set_date;
        String date = ordersSearchDate3.getText();
        Connection connect = databaseConnection.connection();
        if(date.equals("Search by date...(YYYY-MM-DD)"))
        {
            String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id WHERE DATE(orders.Late_Order) = CURRENT_DATE() order by orders.id ASC ;";
            try {               
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                DefaultTableModel tm=(DefaultTableModel)ordersTable3.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    price=rs.getDouble("stock.price");
                    quantity=rs.getInt("orders.Quantity");
                    cost=price*quantity;
                    debt=rs.getDouble("Debt");
                    mpesa=rs.getDouble("Mpesa");
                    cash=rs.getDouble("Cash");
                    fine=rs.getDouble("Fine");
                    returned=rs.getInt("Returned");
                    delivery = rs.getString("Late_Order");
                    balance=(mpesa+cash)+debt-cost+fine;
                    Object o[]={rs.getInt("id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("stock.Name"),
                                rs.getInt("orders.Quantity"),
                                cost,
                                debt,
                                mpesa,
                                cash,
                                fine,
                                balance,
                                delivery,
                                returned,
                                rs.getString("Banked"),
                                rs.getString("Slip_Number"),
                                rs.getString("Banked_By")
                    };
                    tm.addRow(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id WHERE DATE(orders.Late_Order) = '"+date+"' order by orders.id ASC ;";
            try {               
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                DefaultTableModel tm=(DefaultTableModel)ordersTable3.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    price=rs.getDouble("stock.price");
                    quantity=rs.getInt("orders.Quantity");
                    cost=price*quantity;
                    debt=rs.getDouble("Debt");
                    mpesa=rs.getDouble("Mpesa");
                    cash=rs.getDouble("Cash");
                    fine=rs.getDouble("Fine");
                    returned=rs.getInt("Returned");
                    delivery = rs.getString("Late_Order");
                    balance=(mpesa+cash)+debt-cost+fine;
                    Object o[]={rs.getInt("id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("stock.Name"),
                                rs.getInt("orders.Quantity"),
                                cost,
                                debt,
                                mpesa,
                                cash,
                                fine,
                                balance,
                                delivery,
                                returned,
                                rs.getString("Banked"),
                                rs.getString("Slip_Number"),
                                rs.getString("Banked_By")
                    };
                    tm.addRow(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
            if(connect!=null){
                connect.close();
            }
        }
        }
    }

public void sideBarColor0(){
        customerSideBar.setForeground(Color.black);
        stockSideBar.setForeground(Color.black);
        orderSideBar.setForeground(Color.black);
        summarySideBar.setForeground(Color.black);
}
     public void sideBarColor1(){
        customerSideBar.setForeground(Color.white);
        stockSideBar.setForeground(Color.black);
        orderSideBar.setForeground(Color.black);
        summarySideBar.setForeground(Color.black);
}
     public void sideBarColor2(){
        customerSideBar.setForeground(Color.black);
        stockSideBar.setForeground(Color.white);
        orderSideBar.setForeground(Color.black);
        summarySideBar.setForeground(Color.black);
}
     public void sideBarColor3(){
        customerSideBar.setForeground(Color.black);
        stockSideBar.setForeground(Color.black);
        orderSideBar.setForeground(Color.white);
        summarySideBar.setForeground(Color.black);
}
     public void sideBarColor4(){
        customerSideBar.setForeground(Color.black);
        stockSideBar.setForeground(Color.black);
        orderSideBar.setForeground(Color.black);
        summarySideBar.setForeground(Color.white);
}
     public void orderBack()
     {
         buttonsPanel.removeAll();
         buttonsPanel.add(addOrderBackButton);
         buttonsPanel.repaint();
         buttonsPanel.revalidate();     
     }
public void customerBack()
     {
         buttonsPanel.removeAll();
         buttonsPanel.add(addCustomerBackButton);
         buttonsPanel.repaint();
         buttonsPanel.revalidate();     
     }
public void stockBack()
     {
         buttonsPanel.removeAll();
         buttonsPanel.add(addStockBackButton);
         buttonsPanel.repaint();
         buttonsPanel.revalidate();     
     }
public void categoriesBack()
     {
         buttonsPanel.removeAll();
         buttonsPanel.add(categoriesBackButton);
         buttonsPanel.repaint();
         buttonsPanel.revalidate();     
     }
public void categoriesBack1()
     {
         buttonsPanel.removeAll();
         buttonsPanel.add(categoriesBackButton1);
         buttonsPanel.repaint();
         buttonsPanel.revalidate();     
     }
public void returnedBack()
     {
         buttonsPanel.removeAll();
         buttonsPanel.add(returnedGoodsBackButton);
         buttonsPanel.repaint();
         buttonsPanel.revalidate();     
     }
public void customersPrint()
     {
         buttonsPanel.removeAll();
         buttonsPanel.add(customersPrintButton);
         buttonsPanel.repaint();
         buttonsPanel.revalidate();     
     }
public void orderPrint()
     {
         buttonsPanel.removeAll();
         buttonsPanel.add(ordersPrintButton);
         buttonsPanel.repaint();
         buttonsPanel.revalidate();     
     }

     public void sidebar()
     {
         sideBarPanel.removeAll();
         sideBarPanel.add(sideBar);
         sideBarPanel.repaint();
         sideBarPanel.revalidate();     
     }

    private void printGatePass(String deliverer,String time) throws SQLException {
        Connection connect = databaseConnection.connection();
         if(time.equals("Point in Time...") && deliverer.equals("Deliverer(Gate Pass)..."))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Specifications of the Gate Pass","Error",JOptionPane.INFORMATION_MESSAGE,icon);
        }
         else if(time.equals("Point in Time...") && !deliverer.equals("Deliverer(Gate Pass)..."))
        {
        String query2 = "SELECT stock.Name as 'name',SUM(orders.Quantity) AS 'sum' FROM orders inner join stock on Stock_id = stock.id inner join customers on Customer_id = customers.id where DATE(orders.Late_Order) = CURRENT_DATE()+1 and customers.deliverer LIKE '%"+deliverer+"%'GROUP BY stock.ID";
        try {          
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable4.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={
                    rs.getString("name"),
                    rs.getString("sum")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                connect.close();
            }
        }   
        }  
        else 
        {
             String query2 = "SELECT stock.Name as 'name',SUM(orders.Quantity) AS 'sum' FROM orders inner join stock on Stock_id = stock.id inner join customers on Customer_id = customers.id where DATE(orders.Late_Order) =CURRENT_DATE()and orders.Created_at >'"+time+"%' and customers.deliverer LIKE '%"+deliverer+"%'GROUP BY stock.ID";
        try {          
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable4.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getString("name"),
                    rs.getString("sum")
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            if(connect!=null){
                connect.close();
            }
        }  
        }   
    }
   public void gatePassprinter(String deliverer,String time) throws SQLException{
        printGatePass(deliverer,time);
        switchPanel(gatePass);
        print.print(ordersTable4);
    }
    private void printDistribution(String deliverer, String time) throws SQLException {
        Connection connect = databaseConnection.connection();
         if(time.equals("Point in Time...") && deliverer.equals("Deliverer(Distribution)..."))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Specifications of the Distribution","Error",JOptionPane.INFORMATION_MESSAGE,icon);
        }
         else if(time.equals("Point in Time...") && !deliverer.equals("Deliverer(Distribution)..."))
        {
            double price;
        int quantity;
        double cost;
        String delivery;
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where customers.Deliverer LIKE '%"+deliverer+"%' AND DATE(orders.Late_Order) = CURRENT_DATE()+1 order by orders.id";
        try {          
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable5.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                cost=price*quantity;
                delivery = rs.getString("orders.Late_Order");
                Object o[]={
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("customers.Location"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost
                };
                tm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connect!=null){
                connect.close();
            }
        }
        }  
        else 
        {
           double price;
        int quantity;
        double cost;
        String delivery;
        String query2 = "select * from orders INNER JOIN customers ON orders.Customer_id=customers.id INNER JOIN stock ON orders.Stock_id=stock.id where customers.Deliverer LIKE '%"+deliverer+"%' AND DATE(orders.Late_Order) =CURRENT_DATE()and orders.Created_at >'"+time+"%' order by orders.id";
        try {          
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)ordersTable5.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                price=rs.getDouble("stock.price");
                quantity=rs.getInt("orders.Quantity");
                cost=price*quantity;
                delivery = rs.getString("orders.Late_Order");
                Object o[]={
                    rs.getString("customers.Name"),
                    rs.getString("customers.Number"),
                    rs.getString("customers.Location"),
                    rs.getString("stock.Name"),
                    rs.getInt("orders.Quantity"),
                    cost
                };
                tm.addRow(o);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            if(connect!=null){
                connect.close();
            }
        }
        }     
    }
     public void distributionprinter(String deliverer,String time) throws SQLException {
        printDistribution(deliverer,time);
        switchPanel(goodsDistribution);
        print.print(ordersTable5);
    }

    }

   

