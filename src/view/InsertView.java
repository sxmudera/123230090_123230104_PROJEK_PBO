/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controller.InsertController;
import dao.CategoryDao;
import model.CategoryModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.JButton; 

/**
 *
 * @author ivans
 */
public class InsertView extends javax.swing.JFrame {
    private InsertController insertC;

    public InsertView() {
        initComponents();
        setSize(550, 440);
        setLocationRelativeTo(null); 
        setResizable(false);
        insertC = new InsertController(this);
        loadCategories();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_title = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbox_priority = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbox_category = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_desc = new javax.swing.JTextArea();
        btn_tambah = new javax.swing.JButton();

        txt_deadline = new JTextField();
        jLabel7 = new javax.swing.JLabel();

        btn_back = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 186, 117));
        setTitle("TODO List Application");

        jPanel1.setBackground(new java.awt.Color(255, 186, 117));

        jLabel1.setFont(new java.awt.Font("Unispace", 0, 18)); 
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        // Mengubah horizontal alignment agar bisa diatur di tengah
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
        jLabel1.setText("INSERT NEW TASK"); 

        jLabel2.setFont(new java.awt.Font("Unispace", 0, 14)); 
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Title");

        txt_title.setBackground(new java.awt.Color(255, 204, 153));
        txt_title.setForeground(new java.awt.Color(0, 0, 0));
        txt_title.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Unispace", 0, 14)); 
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Priority");

        cbox_priority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Mid", "High" }));
        cbox_priority.setBackground(new java.awt.Color(255, 204, 153));

        jLabel5.setFont(new java.awt.Font("Unispace", 0, 14)); 
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Category");

        cbox_category.setBackground(new java.awt.Color(255, 204, 153));
        cbox_category.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Unispace", 0, 14)); 
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Description");

        txt_desc.setBackground(new java.awt.Color(255, 204, 153));
        txt_desc.setColumns(20);
        txt_desc.setForeground(new java.awt.Color(0, 0, 0));
        txt_desc.setRows(5);
        txt_desc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(txt_desc);

        btn_tambah.setBackground(new java.awt.Color(51, 51, 51));
        btn_tambah.setFont(new java.awt.Font("Unispace", 0, 12)); 
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("ADD NEW TASK");
        btn_tambah.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Unispace", 0, 14));
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Deadline (YYYY-MM-DD HH:MM)");

        txt_deadline.setBackground(new java.awt.Color(255, 204, 153));
        txt_deadline.setForeground(new java.awt.Color(0, 0, 0));
        txt_deadline.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_deadline.setHighlighter(null);
        txt_deadline.setText("No Deadline"); 

        btn_back.setBackground(new java.awt.Color(51, 51, 51));
        btn_back.setFont(new java.awt.Font("Unispace", 0, 12)); 
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("<<"); 
        btn_back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE) 
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30 + 6, 30 + 6, 30 + 6)) // 
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_title, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cbox_category, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cbox_priority, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.DEFAULT_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txt_deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_title, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox_priority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE) 
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)) 
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE) 
                    .addComponent(cbox_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)) 
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        pack();
    }// </editor-fold>

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            getOutDeadline(); 
            insertC.insertData();
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Format deadline tidak valid. Gunakan format YYYY-MM-DD HH:MM. Contoh: 2025-12-31 14:30", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {
        MainView mainView = new MainView(); 
        mainView.setVisible(true); 
        this.dispose(); 
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertView().setVisible(true);
            }
        });
    }

    public JTextField getTxtTitle() {
        return txt_title;
    }

    public JTextArea getTxtDesc() {
        return txt_desc;
    }

    public JComboBox<String> getCBoxPriority() {
        return cbox_priority;
    }

    public JComboBox<String> getCBoxCategory() {
        return cbox_category;
    }

    public LocalDateTime getOutDeadline() throws DateTimeParseException {
        String deadlineText = txt_deadline.getText().trim();

        if (deadlineText.isEmpty() || deadlineText.equalsIgnoreCase("No Deadline")) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            return LocalDateTime.parse(deadlineText, formatter);
        } catch (DateTimeParseException e) {
            throw e; 
        }
    }

    public void setTxtTitle(String title) {
        txt_title.setText(title);
    }

    public void setTxtDesc(String desc) {
        txt_desc.setText(desc);
    }

    public void setCBoxPriority(String priority) {
        cbox_priority.setSelectedItem(priority);
    }

    public void setTxtDeadline(LocalDateTime deadline) {
        if (deadline != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            txt_deadline.setText(deadline.format(formatter));
        } else {
            txt_deadline.setText("No Deadline");
        }
    }

    public void loadCategories() {
        CategoryDao catDao = new CategoryDao();
        List<CategoryModel> categories = catDao.getAllCategoryNames();

        cbox_category.removeAllItems();

        for (CategoryModel cat : categories) {
            cbox_category.addItem(cat.getCategoryName());
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> cbox_category;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> cbox_priority;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7; 
    private javax.swing.JTextField txt_deadline; 
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_desc;
    private javax.swing.JTextField txt_title;
    private javax.swing.JButton btn_back; 
    // End of variables declaration
}