
package View;

import Model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class MainFrame extends javax.swing.JFrame {

   Connection conn = null;
   PreparedStatement pst =null;
   ResultSet rs = null;
    
           
    public MainFrame() {
        initComponents();
        conn = DBConnection.connect();
        tableload();
        
    }
    public void tableload(){
        
        try{
           String sql ="SELECT StudentId AS ID,Name AS NAME,Faculty AS FACULTY,Degreeprogram AS DEGREEPROGRAM,Telephone AS TELEPHONE FROM student" ;
           pst = conn.prepareStatement(sql);
           rs =pst.executeQuery();
           Table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
    }
     
    }
    
    public void tabledata(){
        
    int r = Table1.getSelectedRow();
    
    String StudenId = Table1.getValueAt(r,0).toString();
    String Name = Table1.getValueAt(r,1).toString();
    String Faculty =Table1.getValueAt(r,2).toString();
    String Degreeprogram =Table1.getValueAt(r,3).toString();
    String Telephone =Table1.getValueAt(r, 4).toString();
   
    NameBox.setText(Name);
    STIDBox.setText(StudenId);
    FacultyBox.setSelectedItem(Faculty);
    DegreeBox.setSelectedItem(Degreeprogram);
    Telbox.setText(Telephone);
    
    
    
    }
    
    public void search(){
    
        String srch = SearchBox.getText();
        try {
            String sql = "SELECT * FROM student WHERE Name LIKE '%"+srch+"%' OR StudentId LIKE'%"+srch+"%' "; 
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void update(){
        
      String StudentId =STIDBox.getText();
      String Name=NameBox.getText();
      String Faculty=FacultyBox.getSelectedItem().toString();
      String Degreeprogram =DegreeBox.getSelectedItem().toString();
      String Telephone =Telbox.getText();
      
        try {
            String sql ="UPDATE student SET Name='"+Name+"',StudentId='"+StudentId+"',Faculty='"+Faculty+"',Degreeprogram='"+Degreeprogram+"',Telephone='"+Telephone+"' WHERE StudentId='"+StudentId+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Updated!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error!");
        }
        
    } 
   

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        TelBox = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        SearchBox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NameBox = new javax.swing.JTextField();
        STIDBox = new javax.swing.JTextField();
        FacultyBox = new javax.swing.JComboBox<>();
        DegreeBox = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        Telbox = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        InsertBox = new javax.swing.JButton();
        UpdateBox = new javax.swing.JButton();
        DeleteBox = new javax.swing.JButton();
        CloseBox = new javax.swing.JButton();
        nextbox = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jLabel1.setText("Main Frame");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        TelBox.setViewportView(jTextArea1);

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table1.setAutoCreateRowSorter(true);
        Table1.setBackground(new java.awt.Color(51, 255, 204));
        Table1.setForeground(new java.awt.Color(255, 51, 51));
        Table1.setModel(new javax.swing.table.DefaultTableModel(
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
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        Table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 430, 100));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("search"));

        SearchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBoxActionPerformed(evt);
            }
        });
        SearchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBoxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(SearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(SearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Name:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Stid:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Faculty:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Degree program:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Telephone:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        NameBox.setToolTipText("enter your name");
        jPanel4.add(NameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 130, -1));

        STIDBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STIDBoxActionPerformed(evt);
            }
        });
        jPanel4.add(STIDBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, -1));

        FacultyBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Faculty of It", "Faculty of Science", "Faculty of Law", "Faculty of Education", "Faculty of Engineering" }));
        FacultyBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacultyBoxActionPerformed(evt);
            }
        });
        jPanel4.add(FacultyBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 130, -1));

        DegreeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select ", "Bsc(Hons)Information Technology", "Bsc(Hons)Network mobile computing", "Bsc(Hons)Bio Technology", "Bsc(Hons)Law", "Bsc(Hons)Electrical Engineering", "Bsc(Hons)Education" }));
        jPanel4.add(DegreeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 130, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+94", "+95", "+96", "+80", "+81", "+82" }));
        jPanel4.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));
        jPanel4.add(Telbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 80, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 300, 260));

        jPanel7.setBackground(new java.awt.Color(153, 153, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InsertBox.setBackground(new java.awt.Color(255, 255, 0));
        InsertBox.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        InsertBox.setText("Insert");
        InsertBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertBoxActionPerformed(evt);
            }
        });
        jPanel7.add(InsertBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        UpdateBox.setBackground(new java.awt.Color(255, 255, 51));
        UpdateBox.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        UpdateBox.setText("Update");
        UpdateBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBoxActionPerformed(evt);
            }
        });
        jPanel7.add(UpdateBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 13, -1, -1));

        DeleteBox.setBackground(new java.awt.Color(255, 255, 0));
        DeleteBox.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        DeleteBox.setText("Delete");
        DeleteBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBoxActionPerformed(evt);
            }
        });
        jPanel7.add(DeleteBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        CloseBox.setBackground(new java.awt.Color(255, 255, 0));
        CloseBox.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        CloseBox.setText("Close");
        CloseBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseBoxActionPerformed(evt);
            }
        });
        jPanel7.add(CloseBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        nextbox.setBackground(new java.awt.Color(255, 255, 0));
        nextbox.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        nextbox.setText("Next");
        nextbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextboxActionPerformed(evt);
            }
        });
        jPanel7.add(nextbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 300, 150));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Pictures\\Camera Roll\\WhatsApp Image 2024-06-13 at 09.19.37_c8e762d9.jpg")); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -40, -1, 860));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBoxActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void FacultyBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultyBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FacultyBoxActionPerformed

    private void STIDBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STIDBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_STIDBoxActionPerformed

    private void InsertBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertBoxActionPerformed
       String Name;
       int Stid;
       String Faculty;
       String DegreeProgram;
       int Telephone;
       
       Name = NameBox.getText();
       Stid = Integer.parseInt(STIDBox.getText());
       Faculty = FacultyBox.getSelectedItem().toString();
       DegreeProgram = DegreeBox.getSelectedItem().toString();
       Telephone=Integer.parseInt(Telbox.getText());
       
       try{ 
           String sql = "INSERT INTO student(Name,Faculty,Degreeprogram,Telephone)VALUES(' "+Name+"','"+Faculty+"','"+DegreeProgram+"','"+Telephone+"')";
           pst = conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(null,"Inserted!");
           
    }//GEN-LAST:event_InsertBoxActionPerformed
       catch (Exception e){
           JOptionPane.showMessageDialog(null,e);
           
       }
       tableload();
    }
       
    private void UpdateBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBoxActionPerformed
        update();
        tableload();
    }//GEN-LAST:event_UpdateBoxActionPerformed

    private void DeleteBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBoxActionPerformed
        
        int check = JOptionPane.showConfirmDialog(null, "do you want to delete!");
        
        if(check==0){
            
            String StudentId=STIDBox.getText();
            try {
                String sql = "DELETE FROM student WHERE StudentId='"+StudentId+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Deleted!");
                
                
            }catch (Exception e){
               JOptionPane.showMessageDialog(null,"Error!"); 
            }
         }
        tableload();
    }//GEN-LAST:event_DeleteBoxActionPerformed

    private void CloseBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseBoxActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CloseBoxActionPerformed

    private void SearchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBoxKeyReleased
        search();
    }//GEN-LAST:event_SearchBoxKeyReleased

    private void Table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table1KeyReleased
        tabledata();
    }//GEN-LAST:event_Table1KeyReleased

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        tabledata();
    }//GEN-LAST:event_Table1MouseClicked

    private void nextboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextboxActionPerformed
          DegreeDetails M1 = new  DegreeDetails();
          M1.setVisible(true);
          this.dispose(); 
    }//GEN-LAST:event_nextboxActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseBox;
    private javax.swing.JComboBox<String> DegreeBox;
    private javax.swing.JButton DeleteBox;
    private javax.swing.JComboBox<String> FacultyBox;
    private javax.swing.JButton InsertBox;
    private javax.swing.JTextField NameBox;
    private javax.swing.JTextField STIDBox;
    private javax.swing.JTextField SearchBox;
    private javax.swing.JTable Table1;
    private javax.swing.JScrollPane TelBox;
    private javax.swing.JTextField Telbox;
    private javax.swing.JButton UpdateBox;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton nextbox;
    // End of variables declaration//GEN-END:variables
}
