
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import UserInterface.User.*;
import Business.Connection.Connection;
import Business.Hospital.Hospital;
import Business.Network;
import Business.Organization.Organization;
import Business.User.User;
import Business.UserAccount.UserAccount;
import UserInterface.EmailPage;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author barua
 */
public class ViewBloodDonationRequest extends javax.swing.JPanel {

    /**
     * Creates new form UserHomePage
     */
    private JPanel userProcessContainer;
    private Network network;
    private Organization organization;
    private Hospital hospital;
    private UserAccount userAccount;

    public ViewBloodDonationRequest(JPanel userProcessContainer, Network network, Hospital hospital, Organization organization, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.network = network;
        this.organization = organization;
        this.hospital = hospital;
        this.userAccount = userAccount;
        getConnections();
    }

    public void getConnections() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) userdetails_jTable.getModel();
        TableColumnModel tableColumnModel = userdetails_jTable.getColumnModel();
        defaultTableModel.setRowCount(0);
        for (Connection connection : network.getConnectionDirectory().getConnectionDirectory()) {
            if (connection.getHospital().getHospitalemailId().equals(hospital.getHospitalemailId())) {
                Object row[] = new Object[defaultTableModel.getColumnCount()];
                row[0] = connection.getRecieverUser();
                row[1] = connection.getSenderUser();
                row[2] = connection.getRecieverUser().getBloodGroup();
                row[3] = connection.getRecieverUser().getAddress().getZipCode();
                row[4] = connection.getStatus();
                row[5] = connection.getHospital().getHospitalName();
                row[6] = connection.getHospital();
                row[7] = connection;
                row[8] = connection.getAppointmentDate();
                if (connection.getAssignee() == null) {
                    row[9] = "Not Assigned Yet";
                } else {
                    row[9] = connection.getAssignee().getEmployee().getEmployeeName();
                }
                defaultTableModel.addRow(row);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        userdetails_jTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        assignRequestToMeButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userdetails_jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Donor Name", "Receiver Name", "Blood group", "Zip Code", "Conection Status", "Hsopital Name", "Hospital Emaill", "Hospital Status", "Appointment Date", "Assigned To"
            }
        ));
        jScrollPane1.setViewportView(userdetails_jTable);
        if (userdetails_jTable.getColumnModel().getColumnCount() > 0) {
            userdetails_jTable.getColumnModel().getColumn(0).setResizable(false);
            userdetails_jTable.getColumnModel().getColumn(2).setResizable(false);
            userdetails_jTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 1154, 242));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/16/Knob-Fast-Forward-icon.png"))); // NOI18N
        jButton1.setText("Assign To Lab");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 354, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/16/Knob-Fast-Rewind-icon.png"))); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1131, 43, -1, -1));

        assignRequestToMeButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        assignRequestToMeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/16/Knob-Add-icon.png"))); // NOI18N
        assignRequestToMeButton.setText("Assign Request to ME");
        assignRequestToMeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignRequestToMeButtonActionPerformed(evt);
            }
        });
        add(assignRequestToMeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 354, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 3, 36)); // NOI18N
        jLabel3.setText("View Blood Donation Request ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 35, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/watermark_1.PNG"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = userdetails_jTable.getSelectedRow();
        if (selectedRow >= 0) {
            Hospital selectedHospital = (Hospital) userdetails_jTable.getValueAt(selectedRow, 6);
            Connection connection = (Connection) userdetails_jTable.getValueAt(selectedRow, 7);
            int token = 0;
            if (connection.getAssignee() == null) {
                JOptionPane.showMessageDialog(null, "Please assign request before approving");
            } else {
                if(connection.getHospitalStatus().equals("Assigned to Doctor"))
                {    
                connection.setHospitalStatus("Assigned To Lab");
                JOptionPane.showMessageDialog(null, "Request has been assigned to Lab");
                getConnections();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Request already assigned to Lab");
                }

            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.remove(this);
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void assignRequestToMeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignRequestToMeButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = userdetails_jTable.getSelectedRow();
        if (selectedRow >= 0) {
            Connection connection = (Connection) userdetails_jTable.getValueAt(selectedRow, 7);
            if (connection.getStatus().equals("Connected")) {
                if(connection.getHospitalStatus().equals("Received"))
                {   
                connection.setAssignee(userAccount);
                connection.setHospitalStatus("Assigned to Doctor");
                JOptionPane.showMessageDialog(null, "Request has been assigned to you");
                getConnections();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Request already sent to lab cannout assiged this request to you");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Request is pending for donor's approval");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
    }//GEN-LAST:event_assignRequestToMeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignRequestToMeButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable userdetails_jTable;
    // End of variables declaration//GEN-END:variables
}
