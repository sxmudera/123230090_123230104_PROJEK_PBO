/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTextField; 
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;
import controller.DetailController;
import dao.CategoryDao;
import model.TaskModel;
import model.CategoryModel;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
import java.time.format.DateTimeParseException; 
import javax.swing.JOptionPane; 
import javax.swing.JButton;

public class DetailView extends javax.swing.JFrame {
    private DetailController detailC;
    private TaskModel task1;
    private ButtonGroup statusButtonGroup;

    public DetailView(TaskModel task) {
        initComponents();
        setSize(500, 465);
        setLocationRelativeTo(null);
        setResizable(false);
        this.task1 = task;
        detailC = new DetailController(this);
        
        statusButtonGroup = new ButtonGroup();
        statusButtonGroup.add(radioNotStarted);
        statusButtonGroup.add(radioInProgress);
        statusButtonGroup.add(radioCompleted);
        
        loadCategories();
        detailC.showData(task1);
        setFieldsEditable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_title = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_desc = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbox_priority = new javax.swing.JComboBox<>();
        btn_edit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbox_category = new javax.swing.JComboBox<>();
        lbl_category = new javax.swing.JLabel();
        lbl_title = new javax.swing.JLabel();
        lbl_desc = new javax.swing.JTextArea();
        jScrollPaneForLabel = new javax.swing.JScrollPane();
        lbl_priority = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();
        radioNotStarted = new javax.swing.JRadioButton();
        radioInProgress = new javax.swing.JRadioButton();
        radioCompleted = new javax.swing.JRadioButton();
        statusPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel(); 
        txt_deadline = new JTextField();
        lbl_deadline = new javax.swing.JLabel(); 


        btn_back = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TODO List Application");
        setBackground(new java.awt.Color(255, 186, 117));

        jPanel1.setBackground(new java.awt.Color(255, 186, 117));

        jLabel1.setFont(new java.awt.Font("Unispace", 0, 18));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DETAIL");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txt_title.setBackground(new java.awt.Color(255, 186, 117));
        txt_title.setForeground(new java.awt.Color(0, 0, 0));
        txt_title.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_title.setEditable(false);
        txt_title.setHighlighter(null);

        txt_desc.setBackground(new java.awt.Color(255, 186, 117));
        txt_desc.setColumns(20);
        txt_desc.setForeground(new java.awt.Color(0, 0, 0));
        txt_desc.setRows(5);
        txt_desc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_desc.setEditable(false);
        txt_desc.setHighlighter(null);
        jScrollPane1.setViewportView(txt_desc);

        jLabel2.setFont(new java.awt.Font("Unispace", 0, 14));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Title");

        jLabel3.setFont(new java.awt.Font("Unispace", 0, 14));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Description");

        btn_delete.setBackground(new java.awt.Color(51, 51, 51));
        btn_delete.setFont(new java.awt.Font("Unispace", 0, 12));
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("DELETE");
        btn_delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Unispace", 0, 14));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Priority");

        cbox_priority.setBackground(new java.awt.Color(255, 204, 153));
        cbox_priority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Mid", "High" }));
        cbox_priority.setEnabled(false);

        lbl_title.setOpaque(true);
        lbl_title.setBackground(new java.awt.Color(255, 204, 153));
        lbl_title.setText("Title Value");
        lbl_title.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_desc.setEditable(false);
        lbl_desc.setLineWrap(true);
        lbl_desc.setWrapStyleWord(true);
        lbl_desc.setBackground(new java.awt.Color(255, 204, 153));
        lbl_desc.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        jScrollPaneForLabel.setViewportView(lbl_desc);
        jScrollPaneForLabel.setBorder(null);
        jScrollPaneForLabel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        lbl_priority.setOpaque(true);
        lbl_priority.setBackground(new java.awt.Color(255, 204, 153));
        lbl_priority.setText("Priority Value");
        lbl_priority.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_edit.setBackground(new java.awt.Color(51, 51, 51));
        btn_edit.setFont(new java.awt.Font("Unispace", 0, 12));
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("EDIT");
        btn_edit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_edit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Unispace", 0, 14));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Category");

        cbox_category.setBackground(new java.awt.Color(255, 255, 255));
        cbox_category.setEnabled(false);

        lbl_category.setForeground(new java.awt.Color(0, 0, 0));
        lbl_category.setText("Category Name");
        lbl_category.setBackground(new java.awt.Color(255, 204, 153));
        lbl_category.setOpaque(true);
        lbl_category.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        // Status components
        jLabel6.setFont(new java.awt.Font("Unispace", 0, 14));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Status");

        lbl_status.setOpaque(true);
        lbl_status.setBackground(new java.awt.Color(255, 204, 153));
        lbl_status.setText("Status Value");
        lbl_status.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        radioNotStarted.setText("Not Started");
        radioNotStarted.setEnabled(false);
        radioNotStarted.setBackground(new java.awt.Color(255, 186, 117));

        radioInProgress.setText("In Progress");
        radioInProgress.setEnabled(false);
        radioInProgress.setBackground(new java.awt.Color(255, 186, 117));

        radioCompleted.setText("Completed");
        radioCompleted.setEnabled(false);
        radioCompleted.setBackground(new java.awt.Color(255, 186, 117));

        statusPanel.setBackground(new java.awt.Color(255, 186, 117));
        statusPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));
        statusPanel.add(radioInProgress);
        statusPanel.add(radioCompleted);

        // SIMPLIFIED: Inisialisasi properti untuk komponen deadline
        jLabel7.setFont(new java.awt.Font("Unispace", 0, 14));
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Deadline (YYYY-MM-DD HH:MM)"); 

        txt_deadline.setBackground(new java.awt.Color(255, 204, 153));
        txt_deadline.setForeground(new java.awt.Color(0, 0, 0));
        txt_deadline.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_deadline.setEditable(false);
        txt_deadline.setHighlighter(null);

        lbl_deadline.setOpaque(true);
        lbl_deadline.setBackground(new java.awt.Color(255, 204, 153));
        lbl_deadline.setText("No Deadline");
        lbl_deadline.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        // --- Akhir inisialisasi properti untuk komponen deadline ---

        // Properti tombol back
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
                        .addGap(30 + 6, 30 + 6, 30 + 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_title, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cbox_category, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_category, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cbox_priority, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_priority, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneForLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7) 
                    .addComponent(txt_deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE) 
                    .addComponent(lbl_deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE) 
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_title, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbox_priority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_priority, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbox_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_category, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE) 
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneForLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE) 
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) 
                .addComponent(jLabel7) 
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_deadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE) 
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void txt_titleActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {
        detailC.deleteData(task1.getId());
    }

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {
        if (btn_edit.getText().equals("EDIT")) {
            setFieldsEditable(true);
            btn_edit.setText("SAVE");
        } else {
            try {
                LocalDateTime testDeadline = getOutDeadline();
                detailC.editData(task1.getId());
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Format deadline tidak valid. Gunakan format YYYY-MM-DD HH:MM. Contoh: 2025-12-31 14:30", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {
        MainView mainView = new MainView(); 
        mainView.setVisible(true); 
        this.dispose();
    }

    public void setFieldsEditable(boolean editable) {
        txt_title.setVisible(editable);
        jScrollPane1.setVisible(editable);
        jScrollPaneForLabel.setVisible(!editable);
        cbox_priority.setVisible(editable);
        cbox_category.setVisible(editable);
        statusPanel.setVisible(editable);

        lbl_title.setVisible(!editable);
        lbl_priority.setVisible(!editable);
        lbl_category.setVisible(!editable);
        lbl_status.setVisible(!editable);

        txt_deadline.setVisible(editable);
        lbl_deadline.setVisible(!editable);

        txt_title.setEditable(editable);
        txt_desc.setEditable(editable);
        cbox_priority.setEnabled(editable);
        cbox_category.setEnabled(editable);
        radioNotStarted.setEnabled(editable);
        radioInProgress.setEnabled(editable);
        radioCompleted.setEnabled(editable);
        txt_deadline.setEditable(editable);

        if (editable) {
            txt_title.setBackground(new java.awt.Color(255, 204, 153));
            txt_desc.setBackground(new java.awt.Color(255, 204, 153));
            cbox_category.setBackground(new java.awt.Color(255, 204, 153));
            txt_deadline.setBackground(new java.awt.Color(255, 204, 153));
        } else {
            lbl_title.setText(txt_title.getText());
            lbl_desc.setText(txt_desc.getText());
            
            if (cbox_priority.getSelectedItem() != null) {
                lbl_priority.setText(cbox_priority.getSelectedItem().toString());
            }
            if (cbox_category.getSelectedItem() != null) {
                lbl_category.setText(cbox_category.getSelectedItem().toString());
            }
            
            if (radioNotStarted.isSelected()) {
                lbl_status.setText("Not Started");
            } else if (radioInProgress.isSelected()) {
                lbl_status.setText("In Progress");
            } else if (radioCompleted.isSelected()) {
                lbl_status.setText("Completed");
            }
            LocalDateTime currentDateTime = null;
            try {
                currentDateTime = getOutDeadline();
            } catch (DateTimeParseException e) {

            }
            
            if (currentDateTime != null) {
                lbl_deadline.setText(currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            } else {
                lbl_deadline.setText("No Deadline");
            }


            txt_title.setBackground(new java.awt.Color(255, 204, 153));
            txt_desc.setBackground(new java.awt.Color(255, 204, 153));
            lbl_category.setBackground(new java.awt.Color(255, 204, 153));
            lbl_status.setBackground(new java.awt.Color(255, 204, 153));
            lbl_deadline.setBackground(new java.awt.Color(255, 204, 153));
        }
    }

    public void setEditButtonText(String text) {
        btn_edit.setText(text);
    }

    public String getOutTitle() {
        return txt_title.getText();
    }

    public String getOutDesc() {
        return txt_desc.getText();
    }

    public String getOutPriority() {
        if (cbox_priority.getSelectedItem() != null) {
            return cbox_priority.getSelectedItem().toString();
        }
        return null;
    }

    public String getOutStatus() {
        if (radioNotStarted.isSelected()) {
            return "Not Started";
        } else if (radioInProgress.isSelected()) {
            return "In Progress";
        } else if (radioCompleted.isSelected()) {
            return "Completed";
        }
        return "";
    }

    public String getOutCategory() {
        if (cbox_category.getSelectedItem() != null) {
            return (String) cbox_category.getSelectedItem();
        }
        return null;
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

    public void setOutTitle(String title) {
        txt_title.setText(title);
        lbl_title.setText(title);
    }

    public void setOutPriority(String priority) {
        cbox_priority.setSelectedItem(priority);
        lbl_priority.setText(priority);
    }

    public void setOutStatus(String status) {
        switch (status) {
            case "Not Started":
                radioNotStarted.setSelected(true);
                break;
            case "In Progress":
                radioInProgress.setSelected(true);
                break;
            case "Completed":
                radioCompleted.setSelected(true);
                break;
        }
        lbl_status.setText(status);
    }

    public void setOutDesc(String desc) {
        txt_desc.setText(desc);
        lbl_desc.setText(desc);
    }

    public void setOutCategory(String categoryName) {
        lbl_category.setText(categoryName);
        cbox_category.setSelectedItem(categoryName);
    }

    public void setOutDeadline(LocalDateTime deadline) {
        if (deadline != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            txt_deadline.setText(deadline.format(formatter));
            lbl_deadline.setText(deadline.format(formatter));
        } else {
            txt_deadline.setText("No Deadline");
            lbl_deadline.setText("No Deadline");
        }
    }

    public String getSelectedCategory() {
        if (cbox_category.isVisible()) {
            return (String) cbox_category.getSelectedItem();
        } else {
            return lbl_category.getText();
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
            java.util.logging.Logger.getLogger(DetailView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailView(new TaskModel(1, "Test Task", "Ini adalah deskripsi tugas.", "High", "Not Started", 1, "Work", null)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JComboBox<String> cbox_category;
    private javax.swing.JComboBox<String> cbox_priority;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneForLabel;
    private javax.swing.JLabel lbl_category;
    private javax.swing.JTextArea lbl_desc;
    private javax.swing.JLabel lbl_deadline;
    private javax.swing.JLabel lbl_priority;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JRadioButton radioCompleted;
    private javax.swing.JRadioButton radioInProgress;
    private javax.swing.JRadioButton radioNotStarted;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTextArea txt_desc;
    private javax.swing.JTextField txt_deadline;
    private javax.swing.JTextField txt_title;
    private javax.swing.JButton btn_back;
    // End of variables declaration
}