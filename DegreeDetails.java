
package View;

import Model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class DegreeDetails extends javax.swing.JFrame {
    Connection conn =null;
    PreparedStatement pst = null;
    ResultSet rs=null;

 
    public DegreeDetails() {
        initComponents();
        conn = DBConnection.connect();
        tableload();
        
        
    }
    
    public void tableload(){
        try {
            String sql ="SELECT DegreeNumber ,DegreeName,credits,years FROM degreedetails";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Table3.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  }
    
    public void tabledata(){
     int r = Table3.getSelectedRow();
     
     String Number =Table3.getValueAt(r, 0).toString();
     String Name=Table3.getValueAt(r, 1).toString();
     String credit=Table3.getValueAt(r, 2).toString();
     String year =Table3.getValueAt(r, 3).toString();
     
     DNumbox.setText(Number);
     DNbox.setText(Name);
     Ncbox.setText(credit);
     NYbox.setText(year);
    
    }
    
    public void update(){
       String Number= DNumbox.getText();
       String Name=DNbox.getText();
       String credit=Ncbox.getText();
       String year =  NYbox.getText();
       
        try {
            String sql = "UPDATE degreedetails SET DegreeNumber ='"+Number+"',DegreeName='"+Name+"',credits='"+credit+"',years='"+year+"'  WHERE DegreeNumber='"+Number+"'";
            pst = conn. prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated!");
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"gfhfjj");
        }
    
    }
    
 

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DNbox = new javax.swing.JTextField();
        DNumbox = new javax.swing.JTextField();
        Ncbox = new javax.swing.JTextField();
        NYbox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Inbox = new javax.swing.JButton();
        Delbox = new javax.swing.JButton();
        Upbox = new javax.swing.JButton();
        Exbox = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("DEGREE PROGRAMS");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 253, 62));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Degree NUmber");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel4.setText("Degree Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 20));

        jLabel5.setText("Numbers of credit");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 20));

        jLabel6.setText("Number of year");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 20));
        jPanel3.add(DNbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 70, -1));
        jPanel3.add(DNumbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 70, -1));
        jPanel3.add(Ncbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 70, -1));
        jPanel3.add(NYbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 70, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 330, 310));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Degree Course Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 280, 60));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Inbox.setText("Insert");
        Inbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InboxActionPerformed(evt);
            }
        });
        jPanel4.add(Inbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        Delbox.setText("Delete");
        Delbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelboxActionPerformed(evt);
            }
        });
        jPanel4.add(Delbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        Upbox.setText("Update");
        Upbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpboxActionPerformed(evt);
            }
        });
        jPanel4.add(Upbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        Exbox.setText("Exit");
        Exbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExboxActionPerformed(evt);
            }
        });
        jPanel4.add(Exbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 90, 70, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 310, 130));

        panel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 400, 690));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        Table3.setBackground(new java.awt.Color(255, 255, 204));
        Table3.setModel(new javax.swing.table.DefaultTableModel(
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
        Table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table3MouseClicked(evt);
            }
        });
        Table3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Table3KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table3);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 80, 452, 110);

        panel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 460, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InboxActionPerformed
        int Number;
        String Name;
        int credit;
        int year;
        
        Number =Integer.parseInt(DNumbox.getText());
        Name = DNbox.getText();
        credit = Integer.parseInt(Ncbox.getText());
        year =Integer.parseInt(NYbox.getText());
        
        try {
            String sql = "INSERT INTO degreedetails (DegreeName,credits,years)VALUES('"+Name+"','"+credit+"','"+year+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
             JOptionPane.showConfirmDialog(null, "INSERTED!");
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
     tableload();   
    }//GEN-LAST:event_InboxActionPerformed

    private void Table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table3MouseClicked
        tabledata();
    }//GEN-LAST:event_Table3MouseClicked

    private void Table3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table3KeyReleased
       tabledata();
    }//GEN-LAST:event_Table3KeyReleased

    private void UpboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpboxActionPerformed
        update();
        tableload();
    }//GEN-LAST:event_UpboxActionPerformed

    private void DelboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelboxActionPerformed
       int check = JOptionPane.showConfirmDialog(null,"Do you want to delete!");
       
       if(check==0){
           String Number=DNumbox.getText(); 
           try {
               String sql = "DELETE FROM degreedetails WHERE DegreeNumber='"+Number+"'";
               pst = conn.prepareStatement(sql);
               pst.execute();
               JOptionPane.showConfirmDialog(null,"deleted!");
           } catch (Exception e) {
               JOptionPane.showConfirmDialog(null,"error!");
           }
       
       }
        tableload();
    }//GEN-LAST:event_DelboxActionPerformed

    private void ExboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExboxActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExboxActionPerformed

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
            java.util.logging.Logger.getLogger(DegreeDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DegreeDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DegreeDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DegreeDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DegreeDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DNbox;
    private javax.swing.JTextField DNumbox;
    private javax.swing.JButton Delbox;
    private javax.swing.JButton Exbox;
    private javax.swing.JButton Inbox;
    private javax.swing.JTextField NYbox;
    private javax.swing.JTextField Ncbox;
    private javax.swing.JTable Table3;
    private javax.swing.JButton Upbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
