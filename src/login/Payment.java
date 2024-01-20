/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Sora
 */
public class Payment extends javax.swing.JFrame {
    protected String foodID;
    protected String cusID;
    protected int price;
    protected String billID;
    protected String paymentID;

    public Payment(String id, String user, int price) {
        initComponents();
        this.foodID = id;
        this.cusID = user;
        this.price = price;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bcredit = new javax.swing.JButton();
        bcash = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pay Method");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/image_2024-01-03_135421131.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/image_2024-01-03_140058303.png"))); // NOI18N

        bcredit.setText("Credit");
        bcredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcreditActionPerformed(evt);
            }
        });

        bcash.setText("Cash");
        bcash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcashActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(172, 172, 172)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(bcredit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bcash)
                .addGap(93, 93, 93))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bcredit)
                    .addComponent(bcash))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bcashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcashActionPerformed
        String method = "Cash";
        int x1 = 0;
        int x2 = 0;

        String connectionUrl = "jdbc:sqlserver://localhost:1434;databaseName=Project;user=sa;password=sa";
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("Select Top 1 billID, paymentID From Bill_Report Order By billID DESC SET NOCOUNT ON;");
            if (rs.next()){
                this.billID = rs.getString(1);
                this.paymentID = rs.getString(2);

                billID = this.billID.replaceAll("[^0-9]", "");
                billID = this.billID.replaceAll(" +", "");

                paymentID = this.paymentID.replaceAll("[^0-9]", "");
                paymentID = this.paymentID.replaceAll(" +", "");
 
                x1 = parseInt(billID)+1;
                x2 = parseInt(paymentID)+1;
            }
            String n1 = Integer.toString(x1);
            String n2 = Integer.toString(x2);

            stmt.executeUpdate("Insert Into Payment Values("+price+", 'PAY0"+n2+"', '"+foodID+"')");
            stmt.executeUpdate("Insert Into Bill_Report Values("+price+", "+price+", 'B0"+n1+"', '"+method+"', '"+cusID+"', 'PAY0"+n2+"')");
            JOptionPane.showMessageDialog(null, "Transaction Complete");
            this.setVisible(false);
            new Menu(cusID).setVisible(true);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_bcashActionPerformed

    private void bcreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcreditActionPerformed
        String method = "Credit";
        int x1 = 0;
        int x2 = 0;

        String connectionUrl = "jdbc:sqlserver://localhost:1434;databaseName=Project;user=sa;password=sa";
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("Select Top 1 billID, paymentID From Bill_Report Order By billID DESC SET NOCOUNT ON;");
            if (rs.next()){
                this.billID = rs.getString(1);
                this.paymentID = rs.getString(2);

                billID = this.billID.replaceAll("[^0-9]", "");
                billID = this.billID.replaceAll(" +", "");

                paymentID = this.paymentID.replaceAll("[^0-9]", "");
                paymentID = this.paymentID.replaceAll(" +", "");
 
                x1 = parseInt(billID)+1;
                x2 = parseInt(paymentID)+1;
            }
        String n1 = Integer.toString(x1);
        String n2 = Integer.toString(x2);
        stmt.executeUpdate("Insert Into Payment Values("+price+", 'PAY0"+n2+"', '"+foodID+"')");
        stmt.executeUpdate("Insert Into Bill_Report Values("+price+", "+price+", 'B0"+n1+"', '"+method+"', '"+cusID+"', 'PAY0"+n2+"')");
        JOptionPane.showMessageDialog(null, "Transaction Complete");
        this.setVisible(false);
        new Menu(this.cusID).setVisible(true);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_bcreditActionPerformed

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcash;
    private javax.swing.JButton bcredit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}